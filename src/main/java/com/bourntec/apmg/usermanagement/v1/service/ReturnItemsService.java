package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.usermanagement.v1.dto.request.ReturnItemsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ReturnItemsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.impl.ReturnDataServiceImpl;

/**
 * interface for  ReturnItems services
 * @author Tinu
 *@see ReturnDataServiceImpl
 */
public interface ReturnItemsService {
	/**
	 *    Method for retrieving  all ReturnItems details
	 * 
	 * @return List<ReturnItemsResponseDTO>
	 * @throws Exception
	 */
	List<ReturnItemsResponseDTO> getAll() throws Exception;

	/**
	 *    Method for retrieving  ReturnItems with given id
	 * 
	 * @param id
	 * @return ReturnItemsResponseDTO
	 * @throws Exception
	 */
	ReturnItemsResponseDTO getById(long id) throws Exception;
	/**
	 *    Method for saving  ReturnItems
	 * 
	 * @param ReturnItemsRequestDTO
	 * @return ReturnItemsResponseDTO
	 * @throws Exception
	 */
	ReturnItemsResponseDTO saveReturnItems(ReturnItemsRequestDTO returnItemsRequestDTO) throws Exception;

	/**
	 * This is the main method which is used to search ReturnItems dynamically
	 * 
	 * @param ReturnItemsRequestDTO
	 * @return List<ReturnItemsResponseDTO>
	 */
	List<ReturnItemsResponseDTO> searchForReturnItems(ReturnItemsRequestDTO returnItemsRequestDTO) throws Exception;
	
	/**
	 *    Method for deleting  ReturnItems
	 * 
	 * @param id-
	 * @return ReturnItemsResponseDTO
	 * @throws Exception
	 */
	ReturnItemsResponseDTO deleteReturnItems(long id) throws Exception;
	
	/**
	 *    Method for updating  ReturnItems
	 * 
	 * @param id
	 * @param ReturnItemsRequestDTO
	 * @return ReturnItemsResponseDTO
	 * @throws Exception
	 */
	ReturnItemsResponseDTO updateReturnItems(long id,ReturnItemsRequestDTO returnItemsRequestDTO) throws Exception;

}
