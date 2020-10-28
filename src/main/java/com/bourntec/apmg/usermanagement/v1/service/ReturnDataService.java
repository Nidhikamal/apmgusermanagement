package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.usermanagement.v1.dto.request.ReturnDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ReturnDataResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.impl.ReturnDataServiceImpl;
/**
 * interface for  ReturnData services
 * @author Tinu
 *@see ReturnDataServiceImpl
 */
public interface ReturnDataService {
	/**
	 *    Method for retrieving  all ReturnData details
	 * 
	 * @return List<ReturnDataResponseDTO>
	 * @throws Exception
	 */
	List<ReturnDataResponseDTO>  getAll() throws Exception;

	/**
	 *    Method for retrieving  ReturnData with given id
	 * 
	 * @param returnNo
	 * @return ReturnDataResponseDTO
	 * @throws Exception
	 */
	ReturnDataResponseDTO getById(String returnNo) throws Exception;
	
	/**
	 *    Method for saving  ReturnData
	 * 
	 * @param ReturnDataRequestDTO
	 * @return ReturnDataResponseDTO
	 * @throws Exception
	 */
	ReturnDataResponseDTO saveReturnData(ReturnDataRequestDTO returnDataRequestDTO) throws Exception;

	/**
	 *    Method for Search 
	 * 
	 * @param ReturnDataRequestDTO
	 * @return List<ReturnDataResponseDTO>
	 * @throws Exception
	 */
	List<ReturnDataResponseDTO> searchForReturnData(ReturnDataRequestDTO returnDataRequestDTO) throws Exception;

	/**
	 *    Method for deleting  ReturnData
	 * 
	 * @param returnNo-
	 * @return ReturnDataResponseDTO
	 * @throws Exception
	 */
	ReturnDataResponseDTO deleteReturnData(String returnNo) throws Exception;

	/**
	 *    Method for updating  ReturnData
	 * 
	 * @param returnNo
	 * @param ReturnDataRequestDTO
	 * @return ReturnDataResponseDTO
	 * @throws Exception
	 */
	ReturnDataResponseDTO updateReturnData(String returnNo,ReturnDataRequestDTO returnDataRequestDTO) throws Exception;

}
