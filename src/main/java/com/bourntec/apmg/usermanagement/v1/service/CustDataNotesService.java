package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataNotesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustDataNotesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.impl.CustDataNotesServiceImpl;
/**
 * interface for  CustDataNotes services
 * @author Tinu
 *@see CustDataNotesServiceImpl
 */
public interface CustDataNotesService {
	/**
	 *    Method for retrieving  all CustDataNotes details
	 * 
	 * @return List<CustDataNotesResponseDTO>
	 * @throws Exception
	 */
    List<CustDataNotesResponseDTO> getAll() throws Exception;

	/**
	 *    Method for retrieving  CustDataNotes with given id
	 * 
	 * @param custNo
	 * @return CustDataNotesResponseDTO
	 * @throws Exception
	 */
    CustDataNotesResponseDTO getById(String id) throws Exception;

    /**
	 * Method for saving CustDataNotes
	 * 
	 * @param CustDataNotesRequestDTO
	 * @return CustDataNotesResponseDTO
	 * @throws Exception
	 */
	CustDataNotesResponseDTO saveCustDataNotes(CustDataNotesRequestDTO custDataNotesRequestDTO) throws Exception;

	/**
	 * This is the main method which is used to search CustDataNotes dynamically
	 * 
	 * @param CustDataNotesRequestDTO
	 * @return List<CustDataNotesResponseDTO>
	 */
	List<CustDataNotesResponseDTO> searchForCustDataNotes(CustDataNotesRequestDTO custDataNotesRequestDTO) throws Exception;

	/**
	 *    Method for deleting  CustDataNotes
	 * 
	 * @param id
	 * @return CustDataNotesResponseDTO
	 * @throws Exception
	 */
	CustDataNotesResponseDTO deleteCustDataNotes(String id) throws Exception;
	
	/**
	 *    Method for updating  CustDataNotes
	 * 
	 * @param id
	 * @param CustDataNotesRequestDTO
	 * @return CustDataNotesResponseDTO
	 * @throws Exception
	 */
	CustDataNotesResponseDTO updateCustDataNotes(String id,CustDataNotesRequestDTO custDataNotesRequestDTO) throws Exception;
	
	
}
