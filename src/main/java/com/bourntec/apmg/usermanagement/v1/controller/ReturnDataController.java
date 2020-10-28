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

import com.bourntec.apmg.usermanagement.v1.dto.request.ReturnDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ReturnDataResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.ReturnDataService;

/**
 * Controller for ReturnData Entity
 * @author Tinu
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/returndata")
public class ReturnDataController {
	
	@Autowired
	ReturnDataService returnDataService;
	
	
	/**
	 * Get all ReturnData list
	 * 
	 * @return ResponseEntity<List<ReturnDataResponseDTO>> 
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<ReturnDataResponseDTO>> getAll() throws Exception {
		List<ReturnDataResponseDTO> returnDataResponseDTOList = returnDataService.getAll();
		return ResponseEntity.ok(returnDataResponseDTOList);
	}
	
	/**
	 * Get ReturnData from Id
	 * @param returnNo
	 * @return ResponseEntity<ReturnDataResponseDTO> 
	 * @throws Exception
	 */
	@GetMapping("/{returnNo}")
	public ResponseEntity<ReturnDataResponseDTO> getById(@PathVariable String returnNo) throws Exception {
		ReturnDataResponseDTO returnDataResponseDTO = returnDataService.getById(returnNo);
		return ResponseEntity.ok(returnDataResponseDTO);
	}
	
	/**
	 * End point for saving ReturnData	 * 	
	 * @param ReturnDataRequestDTO
	 * @return ResponseEntity<ReturnDataResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<ReturnDataResponseDTO> saveReturnData(
			@RequestBody ReturnDataRequestDTO returnDataRequestDTO) throws Exception {
		ReturnDataResponseDTO response = returnDataService.saveReturnData(returnDataRequestDTO);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * End point for update ReturnData	 * 	
	 * @param ReturnDataRequestDTO
	 * @return ResponseEntity<ReturnDataResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/{returnNo}")
	public ResponseEntity<ReturnDataResponseDTO> updateReturnData(@PathVariable String returnNo,
			@RequestBody ReturnDataRequestDTO returnDataRequestDTO) throws Exception {
		ReturnDataResponseDTO response = returnDataService.updateReturnData(returnNo,returnDataRequestDTO);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * End point for deleting ReturnData	 * 	
	 * @param returnNo
	 * @return ResponseEntity<ReturnDataResponseDTO>
	 * @throws Exception
	 */
	@DeleteMapping("/{returnNo}")
	public ResponseEntity<ReturnDataResponseDTO> deleteReturnData(
			@PathVariable String returnNo) throws Exception {
		ReturnDataResponseDTO response = returnDataService.deleteReturnData(returnNo);
		return ResponseEntity.ok(response);
	}
	
	/**
	 *  Method for Search ReturnData
	 * 
	 * @param ReturnDataRequestDTO
	 * @return ResponseEntity<List<ReturnDataResponseDTO>>
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<ReturnDataResponseDTO>> getReturnData(@RequestBody ReturnDataRequestDTO returnDataRequestDTO)
			throws Exception {
		List<ReturnDataResponseDTO> returnDataResponseDTOList = returnDataService.searchForReturnData(returnDataRequestDTO);
		return ResponseEntity.ok(returnDataResponseDTOList);
	}
}
