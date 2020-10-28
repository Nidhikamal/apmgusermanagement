package com.bourntec.apmg.usermanagement.v1.service;



import java.util.List;

import com.bourntec.apmg.usermanagement.v1.dto.request.RmaItemsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.RmaItemsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.impl.ReturnDataServiceImpl;

/**
 * interface for  RmaItems services
 * @author Tinu
 *@see ReturnDataServiceImpl
 */
public interface RmaItemsService {
	/**
	 *    Method for retrieving  all RmaItems details
	 * 
	 * @return List<RmaItemsResponseDTO>
	 * @throws Exception
	 */
	List<RmaItemsResponseDTO> getAll() throws Exception;

	/**
	 *    Method for retrieving  RmaItems with given id
	 * 
	 * @param id
	 * @return RmaItemsResponseDTO
	 * @throws Exception
	 */
	RmaItemsResponseDTO getById(long id) throws Exception;
	/**
	 *    Method for saving  RmaItems
	 * 
	 * @param RmaItemsRequestDTO
	 * @return RmaItemsResponseDTO
	 * @throws Exception
	 */
	RmaItemsResponseDTO saveRmaItems(RmaItemsRequestDTO rmaItemsRequestDTO) throws Exception;

	/**
	 * This is the main method which is used to search RmaItems dynamically
	 * 
	 * @param RmaItemsRequestDTO
	 * @return List<RmaItemsResponseDTO>
	 */
	List<RmaItemsResponseDTO> searchForRmaItems(RmaItemsRequestDTO rmaItemsRequestDTO) throws Exception;
	
	/**
	 *    Method for deleting  RmaItems
	 * 
	 * @param id-
	 * @return RmaItemsResponseDTO
	 * @throws Exception
	 */
	RmaItemsResponseDTO deleteRmaItems(long id) throws Exception;
	
	/**
	 *    Method for updating  RmaItems
	 * 
	 * @param id
	 * @param RmaItemsRequestDTO
	 * @return RmaItemsResponseDTO
	 * @throws Exception
	 */
	RmaItemsResponseDTO updateRmaItems(long id,RmaItemsRequestDTO rmaItemsRequestDTO) throws Exception;

}
