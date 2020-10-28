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

import com.bourntec.apmg.usermanagement.v1.dto.request.RmaDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.RmaDataResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.RmaDataService;

/**
 * Controller for RmaData Entity
 * @author Tinu
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/rmadata")
public class RmaDataController {
	
	@Autowired
	RmaDataService rmaDataService;
	
	
	/**
	 * Get all RmaData list
	 * 
	 * @return ResponseEntity<List<RmaDataResponseDTO>> 
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<RmaDataResponseDTO>> getAll() throws Exception {
		List<RmaDataResponseDTO> rmaDataResponseDTOlist = rmaDataService.getAll();
		return ResponseEntity.ok(rmaDataResponseDTOlist);
	}
	
	/**
	 * Get RmaData from Id
	 * @param rmaNo
	 * @return ResponseEntity<RmaDataResponseDTO> 
	 * @throws Exception
	 */
	@GetMapping("/{rmaNo}")
	public ResponseEntity<RmaDataResponseDTO> getById(@PathVariable String rmaNo) throws Exception {
		RmaDataResponseDTO rmaDataResponseDTO = rmaDataService.getById(rmaNo);
		return ResponseEntity.ok(rmaDataResponseDTO);
	}
	
	/**
	 * End point for saving RmaData	 * 	
	 * @param RmaDataRequestDTO
	 * @return ResponseEntity<RmaDataResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<RmaDataResponseDTO> saveRmaData(
			@RequestBody RmaDataRequestDTO rmaDataRequestDTO) throws Exception {
		RmaDataResponseDTO response = rmaDataService.saveRmaData(rmaDataRequestDTO);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * End point for update RmaData	 * 	
	 * @param RmaDataRequestDTO
	 * @return ResponseEntity<RmaDataResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/{rmaNo}")
	public ResponseEntity<RmaDataResponseDTO> updateRmaData(@PathVariable String rmaNo,
			@RequestBody RmaDataRequestDTO rmaDataRequestDTO) throws Exception {
		RmaDataResponseDTO response = rmaDataService.updateRmaData(rmaNo,rmaDataRequestDTO);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * End point for deleting RmaData	 * 	
	 * @param rmaNo
	 * @return ResponseEntity<RmaDataResponseDTO>
	 * @throws Exception
	 */
	@DeleteMapping("/{rmaNo}")
	public ResponseEntity<RmaDataResponseDTO> deleteRmaData(
			@PathVariable String rmaNo) throws Exception {
		RmaDataResponseDTO response = rmaDataService.deleteRmaData(rmaNo);
		return ResponseEntity.ok(response);
	}
	
	/**
	 *  Method for Search RmaData based on RmaDataid
	 * 
	 * @param RmaDataRequestDTO
	 * @return ResponseEntity<List<RmaDataResponseDTO>>
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<RmaDataResponseDTO>> getRmaData(@RequestBody RmaDataRequestDTO rmaDataRequestDTO)
			throws Exception {
		List<RmaDataResponseDTO> rmaDataResponseDTOList = rmaDataService.searchForRmaData(rmaDataRequestDTO);
		return ResponseEntity.ok(rmaDataResponseDTOList);
	}
}
