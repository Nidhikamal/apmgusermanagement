package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.UserLocations;
import com.bourntec.apmg.usermanagement.v1.dto.request.UserLocationsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.UserLocationsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.UserLocationsRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.UserLocationsService;

@Service(value = "UserLocationsServiceImpl")
public class UserLocationsServiceImpl implements UserLocationsService {

	private static final Logger logger = LogManager.getLogger(UserLocationsServiceImpl.class);

	@Autowired
	private UserLocationsRepository userLocationsRepository;

	/**
	 * updateUserLocations
	 * 
	 * @param id,userLocationsRequestDTO
	 * @return userLocationsResponseDTO
	 * @throws Exception
	 */
	public UserLocationsResponseDTO updateUserLocations(Long id, UserLocationsRequestDTO userLocationsRequestDTO)
			throws Exception {

		logger.info("Going to update user locations");

		try {
			UserLocationsResponseDTO userLocationsResponseDTO = new UserLocationsResponseDTO();
			UserLocations userLocations = userLocationsRequestDTO.toModel(userLocationsRequestDTO);
			userLocations.setId(id);
			UserLocations userLocationsRepo = userLocationsRepository.save(userLocations);
			logger.info("Update user locations");
			if (userLocationsRepo != null) {
				BeanUtils.copyProperties(userLocationsRepo, userLocationsResponseDTO);
			} else {
				logger.error(" Error in update UserLocations");
				userLocationsResponseDTO.setResponseMessage("Error in update UserLocations");
			}
			return userLocationsResponseDTO;
		} catch (Exception e) {
			logger.error(" updateUserLocations failed" + e);
			throw e;
		}

	}

	/**
	 * saveUserLocations
	 * 
	 * @param termsId,UserLocationsRequestDTO
	 * @return userLocationsResponseDTO
	 * @throws Exception
	 */
	public UserLocationsResponseDTO saveUserLocations(UserLocationsRequestDTO userLocationsRequestDTO)
			throws Exception {

		logger.info(" UserLocations is going to save");
		UserLocationsResponseDTO userLocationsResponseDTO = new UserLocationsResponseDTO();
		try {
			UserLocations userLocations = userLocationsRequestDTO.toModel(userLocationsRequestDTO);
			UserLocations userLocationsRepo = userLocationsRepository.save(userLocations);
			logger.info(" UserLocations persisted in Db");
			if (userLocationsRepo != null) {
				BeanUtils.copyProperties(userLocationsRepo, userLocationsResponseDTO);
				userLocationsResponseDTO.setResponseMessage("saved in saveUserLocations");
			} else {
				logger.error(" Error in saveUserLocations ");
				userLocationsResponseDTO.setResponseMessage("Error in saveUserLocations");
			}
			return userLocationsResponseDTO;
		} catch (Exception e) {
			logger.error(" saveUserLocations failed" + e);
			throw e;
		}
	}

	/**
	 * findUserLocationsById
	 * 
	 * @param id
	 * @return userLocationsResponseDTO
	 * @throws Exception
	 */

	public UserLocationsResponseDTO findUserLocationsById(Long id) throws Exception {
		logger.info("Going to findUserLocations");

		try {
			UserLocationsResponseDTO userLocationsResponseDTO = new UserLocationsResponseDTO();
			Optional<UserLocations> userLocations = userLocationsRepository.findById(id);
			logger.info("findUserLocationsById");
			if (userLocations != null) {
				BeanUtils.copyProperties(userLocations.get(), userLocationsResponseDTO);
				return userLocationsResponseDTO;
			} else {

				throw new ResourceNotFoundException(ErrorCodes.PAYMENTTERMS_NOT_FOUND.getMessage());
			}

		} catch (Exception e) {
			logger.error(" findUserLocationsById failed" + e);
			throw e;
		}
	}

	/**
	 * findAllUserLocations
	 * 
	 * @return UserLocationsResponseDTO list
	 * @throws Exception
	 */
	public List<UserLocationsResponseDTO> findAllUserLocations() throws Exception {

		logger.info(" RetrieveAllUserLocations");
		List<UserLocationsResponseDTO> userLocationsResponseDTOList = new ArrayList<UserLocationsResponseDTO>();
		try {
			List<UserLocations> userLocationsList = userLocationsRepository.findAll();
			if (userLocationsList != null && userLocationsList.size() > 0) {
				userLocationsList.forEach((userLocations) -> {
					UserLocationsResponseDTO userLocationsResponseDTO = new UserLocationsResponseDTO();
					BeanUtils.copyProperties(userLocations, userLocationsResponseDTO);
					userLocationsResponseDTOList.add(userLocationsResponseDTO);

				});
				logger.info("findAllUserLocations");
			} else {
				logger.error(" Error findAllUserLocations ");

			}

			return userLocationsResponseDTOList;
		} catch (Exception e) {
			logger.error("findAllUserLocations" + e);
			throw e;
		}

	}

	/**
	 * This method Searches UserLocations by criteria
	 * 
	 * @author Nince
	 * @return List<UserLocations>
	 * @throws Exception
	 */

	public List<UserLocations> findUserLocationsByCriteria(UserLocationsRequestDTO userLocationsRequestDTO) {
		GenericSpesification<UserLocations> genericSpesification = new GenericSpesification<UserLocations>();

		if (userLocationsRequestDTO.getUserId() != null && !userLocationsRequestDTO.getUserId().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("userId", userLocationsRequestDTO.getUserId(), SearchOperation.EQUAL));
		}
		if (userLocationsRequestDTO.getLocation() != null && !userLocationsRequestDTO.getLocation().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("location", userLocationsRequestDTO.getLocation(), SearchOperation.EQUAL));
		}
		return userLocationsRepository.findAll(genericSpesification);
	}

	@Override
	public UserLocationsResponseDTO deleteUserLocation(Long id) {

		logger.info("Entering delete ....");
		UserLocationsResponseDTO responseDTO = new UserLocationsResponseDTO();
		try {
			Optional<UserLocations> userLocObj = userLocationsRepository.findById(id);
			if (!userLocObj.isPresent()) {
				logger.error("userLoc doesn't exist");
				responseDTO.setResponseMessage("userLoc doesn't exist");
				return responseDTO;
			}
			UserLocations dataRespDTO = userLocObj.get();
			if (dataRespDTO == null) {
				logger.info("The userLoc doesn't exists!!!");
				responseDTO.setResponseMessage("The userLoc doesn't exists!!!");
			} else {
				userLocationsRepository.delete(dataRespDTO);
				responseDTO.setResponseMessage(" userLoc deleted successfully");
			}
		} catch (Exception e) {
			logger.error("delete :delete userLocof userLocServiceImpl  " + e);
		}
		logger.info("Exiting delete userLoc");
		return responseDTO;
	}
}
