package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.UserLocations;
import com.bourntec.apmg.usermanagement.v1.dto.request.UserLocationsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.UserLocationsResponseDTO;

public interface UserLocationsService {
	
	/**
	 * updateUserLocations
	 * @param id,UserLocationsRequestDTO
	 * @return UserLocationsResponseDTO
	 * @throws Exception
	 */
	UserLocationsResponseDTO updateUserLocations(Long id, UserLocationsRequestDTO userLocationsRequestDTO)throws Exception;
	
	/**
	 * saveUserLocations
	 * @param userLocationsRequestDTO
	 * @return userLocationsResponseDTO
	 * @throws Exception
	 */
	UserLocationsResponseDTO saveUserLocations(UserLocationsRequestDTO userLocationsRequestDTO)throws Exception;
	
	/**
	 * findUserLocationsById
	 * @param id
	 * @return UserLocationsResponseDTO
	 * @throws Exception
	 */
	UserLocationsResponseDTO findUserLocationsById(Long id)throws Exception;
	
	/**
	 * findAllUserLocations
	 * @return UserLocationsResponseDTO  list
	 * @throws Exception
	 */
	List<UserLocationsResponseDTO> findAllUserLocations()throws Exception;

	/**
	 * findUserLocationsByCriteria
	 * @return UserLocations list
	 * @throws Exception
	 */
	List<UserLocations> findUserLocationsByCriteria(UserLocationsRequestDTO userLocationsRequestDTO);

	/**
	 * 
	 * @param id
	 * @return
	 */
	UserLocationsResponseDTO deleteUserLocation(Long id);
}
