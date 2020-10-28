package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.PassAccessList;
import com.bourntec.apmg.entity.PassTable;
import com.bourntec.apmg.usermanagement.v1.dto.request.PassModuleOptionListRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.PassTableRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.SuccessResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PassTableResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.PassAccessListRepository;
import com.bourntec.apmg.usermanagement.v1.repository.PassTableRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.UserService;

/**
 * 
 * @author Srijini
 *
 */
@Deprecated
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	PassTableRepository userRepository;

	@Autowired
	PassAccessListRepository passAccessListRepository;

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	/**
	 * Fetch all User details as List
	 * 
	 */
	public List<PassTable> getAll() {
		return userRepository.findAll();
	}

	/**
	 * Search for user
	 */
	@Override
	public List<PassTableResponseDTO> searchForUser(PassTableRequestDTO userRequestDTO, int page, int size) throws Exception {
		List<PassTableResponseDTO> userResponseDTOList = new ArrayList<PassTableResponseDTO>();
		try {
			Page<PassTable> passTablesList = findCustomersByCriteria(userRequestDTO, page, size);
			if (passTablesList != null && !passTablesList.isEmpty()) {
				passTablesList.stream().forEach((pass) -> {
					PassTableResponseDTO userResponseDTO = new PassTableResponseDTO();
					BeanUtils.copyProperties(pass, userResponseDTO);
					userResponseDTOList.add(userResponseDTO);
				});

			} else {
				throw new ResourceNotFoundException(ErrorCodes.USER_NOT_FOUND.getMessage());
			}
		} catch (BeansException e) {
			throw new ResourceNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}

		return userResponseDTOList;
	}

	/**
	 * This is the main method which is used to search user dynamically
	 * 
	 * @param CustDataRequestDTO
	 * @return List<CustData>
	 */

	public Page<PassTable> findCustomersByCriteria(PassTableRequestDTO userRequestDTO, int page, int size) throws Exception {
		logger.info("Searching User ...");
		GenericSpesification<PassTable> genericSpesification = new GenericSpesification<PassTable>();
		try {
			if (userRequestDTO.getUserId() != null) {
				genericSpesification
						.add(new SearchCriteria("userId", userRequestDTO.getUserId(), SearchOperation.EQUAL));
			}
			if (userRequestDTO.getFullName() != null) {
				genericSpesification
						.add(new SearchCriteria("fullName", userRequestDTO.getFullName(), SearchOperation.MATCH));
			}
			if (userRequestDTO.getLocCode() != null) {
				genericSpesification
						.add(new SearchCriteria("locCode", userRequestDTO.getLocCode(), SearchOperation.EQUAL));
			}
			if (userRequestDTO.getAccountDisabled() != null) {
				genericSpesification.add(new SearchCriteria("accountDisabled", userRequestDTO.getAccountDisabled(),
						SearchOperation.EQUAL));
			}
			return userRepository.findAll(genericSpesification, PageRequest.of(page, size));

		} catch (Exception e) {
			throw new ResourceNotFoundException(ErrorCodes.SEARCH_FAILED.getMessage());
		}

	}

	/**
	 * Method for copy roles of existing user to new user
	 */
	@Override
	@Transactional
	public SuccessResponseDTO setUserForNewRole(String newUserId, String userId) throws Exception {
		try {
			passAccessListRepository.copyRole(newUserId, userId);
		} catch (Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}

		SuccessResponseDTO responseDto = new SuccessResponseDTO();
		responseDto.setStatus("Success");
		responseDto.setMessage("Copied roles of existing user to new user");
		return responseDto;
	}

	/**
	 * AP 228 - Method for Set each Module permission separately
	 */
	@Override
	@Transactional
	public SuccessResponseDTO updateUserRole(String userId, List<PassModuleOptionListRequestDTO> optionListRequestDTOs)
			throws Exception {
		List<PassAccessList> passAccessListIdList = new ArrayList<PassAccessList>();
		try {
			passAccessListRepository.deleteByUserId(userId);
			optionListRequestDTOs.forEach((option) -> {
				/*
				 * PassAccessListId accessListIdObj = new PassAccessListId(); PassAccessList
				 * accessListObj = new PassAccessList(); PassModuleOptionList moduleOptionList =
				 * new PassModuleOptionList(); PassModuleList moduleListObj = new
				 * PassModuleList();
				 * 
				 * PassModuleOptionId moduleOptionIdObj = new PassModuleOptionId();
				 * moduleOptionIdObj.setOptionName(option.getOptionName());
				 * moduleListObj.setModuleName(option.getModuleName());
				 * 
				 * moduleOptionIdObj.setModuleList(moduleListObj);
				 * moduleOptionList.setId(moduleOptionIdObj);
				 * 
				 * accessListIdObj.setUserId(userId);
				 * accessListIdObj.setModuleOptionList(moduleOptionList);
				 * 
				 * accessListObj.setPassId(accessListIdObj);
				 * accessListObj.setDescription(option.getDescription());
				 * passAccessListIdList.add(accessListObj);
				 */
//				passAccessListRepository.saveRole(userId, option.getOptionName(), option.getModuleName(),
//						option.getAccessStatus(), option.getDescription(), option.getGroupId(),
//						option.getLocCode(), option.getAccessDescription(), option.getImported());
			});
			// passAccessListRepository.saveAll(passAccessListIdList);
		} catch (Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
		SuccessResponseDTO responseDto = new SuccessResponseDTO();
		responseDto.setStatus("Success");
		responseDto.setMessage("Module Permission Updated");
		return responseDto;
	}
}
