package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.usermanagement.v1.dto.request.PassTableRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PassTableResponseDTO;

public interface PassTableService {

	/**
	 *    Method for retrieving  all PassTable details
	 * 
	 * @return List<PassTableResponseDTO>
	 * @throws Exception
	 */
	List<PassTableResponseDTO> getAll() throws Exception;

	
	/**
	 *    Method for retrieving  PassTable with given id
	 * 
	 * @param userId
	 * @return PassTableResponseDTO
	 * @throws Exception
	 */
	PassTableResponseDTO getById(String userId) throws Exception;
	
	/**
	 *  Method for saving PassTable 
	 * 
	 * @param PassTableRequestDTO
	 * @return PassTableResponseDTO
	 * @throws Exception
	 */
	PassTableResponseDTO savePassTable(PassTableRequestDTO passTableRequestDTO) throws Exception;

	/**
	 * AP 227 - Method for Search passTable based on passTableid
	 * 
	 * @param PassTableRequestDTO
	 * 
	 * @return ResponseEntity<List<PassTableResponseDTO>>
	 * @throws Exception
	 */
	List<PassTableResponseDTO> searchForPassTable(PassTableRequestDTO passTableRequestDTO, int page, int size) throws Exception;

	/**
	 *    Method for deleting  PassTable
	 * 
	 * @param userId-
	 * @return PassTableResponseDTO
	 * @throws Exception
	 */
	PassTableResponseDTO deletePassTable(String userId) throws Exception;
	
	
	/**
	 *    Method for updating  PassTable
	 * 
	 * @param userId
	 * @param PassTableRequestDTO
	 * @return PassTableResponseDTO
	 * @throws Exception
	 */
	PassTableResponseDTO updatePassTable(String userId,PassTableRequestDTO passTableRequestDTO) throws Exception;

}
