package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.PassAccessList;
import com.bourntec.apmg.usermanagement.v1.dto.request.PassAccessListRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PassAccessListResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.PassAccessListRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.PassAccessListService;

/**
 * @author Srijini
 *
 */
@Service
public class PassAccessListServiceImpl implements PassAccessListService {
	private static final Logger logger = LogManager.getLogger(PassAccessListServiceImpl.class);
	@Autowired
	PassAccessListRepository passAccessListRepository;

	@Override
	public List<PassAccessList> getAll() throws Exception {
		return passAccessListRepository.findAll();
	}

	@Override
	public List<PassAccessList> getById(String userId) throws Exception {
		PassAccessList accessListObj = new PassAccessList();
		// accessListObj.setUserId(userId);
		return passAccessListRepository.findAll(Example.of(accessListObj));
	}

	@Override
	public PassAccessListResponseDTO saveUserRole(PassAccessListRequestDTO accessListRequestDTO) throws Exception {
		logger.info("Entering saveUserRole ");
		PassAccessListResponseDTO passAccessListResponseDTO = new PassAccessListResponseDTO();
		try {
			PassAccessList passAccessList = passAccessListRepository
					.save(accessListRequestDTO.toModel(accessListRequestDTO));
			logger.info("User role Details  is saved");
			BeanUtils.copyProperties(passAccessList, passAccessListResponseDTO);
			passAccessListResponseDTO.setResponseMessage("User role Details  is saved successfully ");
		}

		catch (Exception e) {
			logger.error("  User role Details  save failed" + e);
			throw e;
		}
		logger.info("Exiting saveUserRole ");
		return passAccessListResponseDTO;
	}

	@Override
	@Transactional
	public PassAccessListResponseDTO updateUserRole(List<PassAccessListRequestDTO> accessListRequestDTO)
			throws Exception {
		try {
			if (accessListRequestDTO != null && !accessListRequestDTO.isEmpty()) {
				List<PassAccessList> accessLists = new ArrayList<PassAccessList>();

				passAccessListRepository.deleteByUserIdAndModuleName(accessListRequestDTO.get(0).getUserId(),
						accessListRequestDTO.get(0).getModuleName());

				accessListRequestDTO.forEach(requestDto -> {
					accessLists.add(requestDto.toModel(requestDto));
				});

				List<PassAccessList> accessList = passAccessListRepository.saveAll(accessLists);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PassAccessListResponseDTO deleteUserRole(Long id) throws Exception {
		PassAccessListResponseDTO responseDTO = new PassAccessListResponseDTO();
		try {
			passAccessListRepository.deleteById(id);
			responseDTO.setResponseMessage("Imported access removed successfully");
		} catch (Exception e) {
			throw e;
		}
		return responseDTO;
	}

	@Override
	public List<PassAccessListResponseDTO> search(PassAccessListRequestDTO accessListRequestDTO, int page, int size)
			throws Exception {
		List<PassAccessListResponseDTO> accessListResponseDTOList = new ArrayList<PassAccessListResponseDTO>();

		try {

			Page<PassAccessList> accessLists = findRolesByCriteria(accessListRequestDTO, page, size);
			if (accessLists != null && !accessLists.isEmpty()) {
				accessLists.forEach(access -> {
					PassAccessListResponseDTO responseDTO = new PassAccessListResponseDTO();
					BeanUtils.copyProperties(access, responseDTO);
					accessListResponseDTOList.add(responseDTO);
				});
			}

		} catch (Exception e) {
			logger.error("getAll " + e);
		}
		/*
		 * accessLists.forEach(access -> { access.getPassTable().getUserId();
		 * access.getPassId().getModuleOptionList(); }); HashMap<String,
		 * List<PassModuleOptionList>> userRoleMap = new HashMap<String,
		 * List<PassModuleOptionList>>(); accessLists.forEach(access -> { if
		 * (!userRoleMap.containsKey(access.getPassTable().getUserId())) {
		 * List<PassModuleOptionList> list = new ArrayList<PassModuleOptionList>();
		 * list.add(access.getPassId().getModuleOptionList());
		 * 
		 * userRoleMap.put(access.getPassTable().getUserId(), list); } else {
		 * userRoleMap.get(access.getPassTable().getUserId()).add(access.getPassId().
		 * getModuleOptionList()); } });
		 */
		return accessListResponseDTOList;
	}

	/**
	 * This is the main method which is used to search PassAccessList dynamically
	 * 
	 * @param PassAccessListRequestDTO
	 * @return Page<PassAccessList>
	 */

	public Page<PassAccessList> findRolesByCriteria(PassAccessListRequestDTO accessListRequestDTO, int page, int size)
			throws Exception {
		logger.info("Searching PassTable ...");
		GenericSpesification<PassAccessList> genericSpesification = new GenericSpesification<PassAccessList>();
		try {
			if (accessListRequestDTO.getUserId() != null) {
				genericSpesification
						.add(new SearchCriteria("userId", accessListRequestDTO.getUserId(), SearchOperation.EQUAL));
			}
			if (accessListRequestDTO.getOptionName() != null) {
				genericSpesification.add(
						new SearchCriteria("optionName", accessListRequestDTO.getOptionName(), SearchOperation.EQUAL));
			}if (accessListRequestDTO.getModuleName() != null) {
				genericSpesification.add(
						new SearchCriteria("moduleName", accessListRequestDTO.getModuleName(), SearchOperation.EQUAL));
			}

			return passAccessListRepository.findAll(genericSpesification, PageRequest.of(page, size));

		} catch (Exception e) {
			throw new ResourceNotFoundException(ErrorCodes.SEARCH_FAILED.getMessage());
		}

	}
	/**
	 * 
	 */
	/*
	 * public Map<Object, Map<Object, List<Object>>> getAllOptions() {
	 * List<PassAccessList> accessLists = passAccessListRepository.findAll();
	 * 
	 * final Map<Object, Map<Object, List<Object>>> userPermissionList =
	 * accessLists.stream() .collect(Collectors.groupingBy(m ->
	 * m.getPassTable().getUserId(), Collectors.groupingBy(p ->
	 * p.getPassId().getModuleOptionList().getOptionUrl(), Collectors.mapping(p ->
	 * p.getPassId().getModuleOptionList().getId().getOptionName(),
	 * Collectors.toList())))); // filter null urls
	 * 
	 * return userPermissionList; }
	 */
}
