package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.usermanagement.v1.dto.request.RmaDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.RmaDataResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.impl.ReturnDataServiceImpl;

/**
 * interface for  RmaData services
 * @author Tinu
 *@see ReturnDataServiceImpl
 */
public interface RmaDataService {
	/**
	 *    Method for retrieving  all RmaData details
	 * 
	 * @return List<RmaDataResponseDTO>
	 * @throws Exception
	 */
	List<RmaDataResponseDTO>getAll() throws Exception;

	/**
	 *    Method for retrieving  RmaData with given id
	 * 
	 * @param rmaNo
	 * @return RmaDataResponseDTO
	 * @throws Exception
	 */
	RmaDataResponseDTO getById(String rmaNo) throws Exception;
	/**
	 *    Method for saving  RmaData
	 * 
	 * @param RmaDataRequestDTO
	 * @return RmaDataResponseDTO
	 * @throws Exception
	 */
	RmaDataResponseDTO saveRmaData(RmaDataRequestDTO rmaDataRequestDTO) throws Exception;

	/**
	 * This is the main method which is used to search RmaData dynamically
	 * 
	 * @param RmaDataRequestDTO
	 * @return List<RmaData>
	 */
	List<RmaDataResponseDTO> searchForRmaData(RmaDataRequestDTO rmaDataRequestDTO) throws Exception;
	
	/**
	 *    Method for deleting  RmaData
	 * 
	 * @param rmaNo-
	 * @return RmaDataResponseDTO
	 * @throws Exception
	 */
	RmaDataResponseDTO deleteRmaData(String rmaNo) throws Exception;
	
	/**
	 *    Method for updating  RmaData
	 * 
	 * @param rmaNo
	 * @param RmaDataRequestDTO
	 * @return RmaDataResponseDTO
	 * @throws Exception
	 */
	RmaDataResponseDTO updateRmaData(String rmaNo,RmaDataRequestDTO rmaDataRequestDTO) throws Exception;

}
