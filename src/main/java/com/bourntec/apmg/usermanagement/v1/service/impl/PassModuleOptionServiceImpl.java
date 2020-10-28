package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.PassAccessList;
import com.bourntec.apmg.entity.PassModuleOptionList;
import com.bourntec.apmg.usermanagement.v1.dto.request.PassAccessListRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.PassModuleOptionListRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PassAccessListResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PassModuleOptionListResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.PassAccessListRepository;
import com.bourntec.apmg.usermanagement.v1.repository.PassModuleOptionListRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.PassModuleOptionService;

/**
 * @author Srijini T.S
 *
 */
@Service
public class PassModuleOptionServiceImpl implements PassModuleOptionService {
	private static final Logger logger = LogManager.getLogger(PassModuleOptionServiceImpl.class);
	@Autowired
	PassModuleOptionListRepository passModuleOptionListRepository;

	@Override
	public List<PassModuleOptionListResponseDTO> getAll() throws Exception {
		List<PassModuleOptionListResponseDTO> responseDTOs = new ArrayList<PassModuleOptionListResponseDTO>();
		try {
			List<PassModuleOptionList> moduleOptionLists = passModuleOptionListRepository.findAll();
			moduleOptionLists.forEach((moduleOptionObj) -> {
				PassModuleOptionListResponseDTO listRequestDTO = new PassModuleOptionListResponseDTO();
				BeanUtils.copyProperties(moduleOptionObj, listRequestDTO);
				responseDTOs.add(listRequestDTO);
			});
		} catch (Exception e) {
			logger.error("getAll " + e);
		}
		return responseDTOs;
	}

	@Override
	public List<PassModuleOptionListResponseDTO> getById(String optionname) throws Exception {
		List<PassModuleOptionListResponseDTO> responseDTOs = new ArrayList<PassModuleOptionListResponseDTO>();
		try {
			List<PassModuleOptionList> moduleOptionLists = passModuleOptionListRepository.findByOptionName(optionname);
			if (moduleOptionLists != null && !moduleOptionLists.isEmpty()) {
				responseDTOs = copyToResponseDto(moduleOptionLists);
			}
		} catch (Exception e) {
			logger.error("getAll " + e);
		}
		return responseDTOs;
	}

	private List<PassModuleOptionListResponseDTO> copyToResponseDto(List<PassModuleOptionList> moduleOptionLists) {
		List<PassModuleOptionListResponseDTO> responseDTOs = new ArrayList<PassModuleOptionListResponseDTO>();

		moduleOptionLists.forEach((submoduleObj) -> {
			PassModuleOptionListResponseDTO dto = new PassModuleOptionListResponseDTO();
			BeanUtils.copyProperties(dto, submoduleObj);
			/*
			 * dto.setOptionName(submoduleObj.getOptionName());
			 * dto.setModuleName(submoduleObj.getModuleName());
			 * dto.setOptionUrl(submoduleObj.getOptionUrl());
			 * dto.setLocationCode(submoduleObj.getLocCode());
			 * dto.setDescription(submoduleObj.getOptionDesc());
			 */

			responseDTOs.add(dto);

		});
		return responseDTOs;
	}

	@Override
	public PassModuleOptionListResponseDTO saveOptions(List<PassModuleOptionListRequestDTO> listRequestDTOs)
			throws Exception {
		listRequestDTOs.forEach(option -> {

		});
		return null;
	}

	@Override
	public PassModuleOptionListResponseDTO updateOption(List<PassModuleOptionListRequestDTO> accessListRequestDTO)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PassModuleOptionListResponseDTO deleteOption(String option) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * search method
	 */
	@Override
	public List<PassModuleOptionListResponseDTO> search(PassModuleOptionListRequestDTO accessListRequestDTO, int page,
			int size) throws Exception {
		List<PassModuleOptionListResponseDTO> optionListResponseDTOList = new ArrayList<PassModuleOptionListResponseDTO>();
		try {
			Page<PassModuleOptionList> moduleOptionList = findOptionByCriteria(accessListRequestDTO, page, size);
			moduleOptionList.forEach(option -> {
				PassModuleOptionListResponseDTO responseDTO = new PassModuleOptionListResponseDTO();
				BeanUtils.copyProperties(option, responseDTO);
				optionListResponseDTOList.add(responseDTO);
			});
		} catch (Exception e) {

		}
		return optionListResponseDTOList;
	}

	/**
	 * This is the main method which is used to search PassAccessList dynamically
	 * 
	 * @param PassModuleOptionListRequestDTO
	 * @return Page<PassModuleOptionList>
	 */

	public Page<PassModuleOptionList> findOptionByCriteria(PassModuleOptionListRequestDTO optionListRequestDTO,
			int page, int size) throws Exception {
		logger.info("Searching PassTable ...");
		GenericSpesification<PassModuleOptionList> genericSpesification = new GenericSpesification<PassModuleOptionList>();
		try {
			  if (optionListRequestDTO.getModuleName() != null) {
				genericSpesification.add(
						new SearchCriteria("moduleName", optionListRequestDTO.getModuleName(), SearchOperation.EQUAL));
			}  if (optionListRequestDTO.getOptionName() != null) {
				genericSpesification.add(
						new SearchCriteria("optionName", optionListRequestDTO.getOptionName(), SearchOperation.EQUAL));
			}

			return passModuleOptionListRepository.findAll(genericSpesification, PageRequest.of(page, size));

		} catch (Exception e) {
			throw new ResourceNotFoundException(ErrorCodes.SEARCH_FAILED.getMessage());
		}

	}
}
