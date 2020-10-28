package com.bourntec.apmg.usermanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataNotesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustDataNotesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.CustDataNotesService;
/**
 * Controller for CustDataNotes Entity
 * @author Tinu
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/custdatanotes")
public class CustDataNotesController {
	
	@Autowired
	CustDataNotesService custDataNotesService;
	
	
	/**
	 * Get all CustDataNotes list
	 * 
	 * @return List<CustDataNotesResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<CustDataNotesResponseDTO>> getAll() throws Exception {
		List<CustDataNotesResponseDTO> custDataNotesResponseDTOList = custDataNotesService.getAll();
		return ResponseEntity.ok(custDataNotesResponseDTOList);
	}
	
	/**
	 * Get CustDataNotes from Id
	 * @param custNo
	 * @return CustDataNotesResponseDTO
	 * @throws Exception
	 */
	@GetMapping("/{custNo}")
	public ResponseEntity<CustDataNotesResponseDTO> getById(@PathVariable String custNo) throws Exception {
		CustDataNotesResponseDTO custDataNotesResponseDTO = custDataNotesService.getById(custNo);
		return ResponseEntity.ok(custDataNotesResponseDTO);
	}
	
	/**
	 * End point for saving CustDataNotes	 * 	
	 * @param CustDataNotesRequestDTO
	 * @return ResponseEntity<CustDataNotesResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<CustDataNotesResponseDTO> saveCustDataNotes(
			@RequestBody CustDataNotesRequestDTO custDataNotesRequestDTO) throws Exception {
		CustDataNotesResponseDTO response = custDataNotesService.saveCustDataNotes(custDataNotesRequestDTO);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * End point for update CustDataNotes	 * 	
	 * @param CustDataNotesRequestDTO
	 * @return ResponseEntity<CustDataNotesResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/{custNo}")
	public ResponseEntity<CustDataNotesResponseDTO> updateCustDataNotes(@PathVariable String custNo,
			@RequestBody CustDataNotesRequestDTO custDataNotesRequestDTO) throws Exception {
		CustDataNotesResponseDTO response = custDataNotesService.updateCustDataNotes(custNo,custDataNotesRequestDTO);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * End point for deleting CustDataNotes	 * 	
	 * @param custNo
	 * @return ResponseEntity<CustDataNotesResponseDTO>
	 * @throws Exception
	 */
	@DeleteMapping("/{custNo}")
	public ResponseEntity<CustDataNotesResponseDTO> deleteCustDataNotes(
			@PathVariable String custNo) throws Exception {
		CustDataNotesResponseDTO response = custDataNotesService.deleteCustDataNotes(custNo);
		return ResponseEntity.ok(response);
	}
	
	/**
	 *  Method for Search CustDataNotes based on CustDataNotesid
	 * 
	 * @param CustDataNotesRequestDTO
	 * @return ResponseEntity<List<CustDataNotesResponseDTO>>
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<CustDataNotesResponseDTO>> searchCustDataNotes(@RequestBody CustDataNotesRequestDTO custDataNotesRequestDTO)
			throws Exception {
		List<CustDataNotesResponseDTO> custDataNotesResponseDTOList = custDataNotesService.searchForCustDataNotes(custDataNotesRequestDTO);
		return ResponseEntity.ok(custDataNotesResponseDTOList);
	}
}
