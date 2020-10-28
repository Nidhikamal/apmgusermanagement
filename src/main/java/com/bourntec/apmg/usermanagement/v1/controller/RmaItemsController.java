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

import com.bourntec.apmg.usermanagement.v1.dto.request.RmaItemsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.RmaItemsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.RmaItemsService;

/**
 * Controller for RmaItems Entity
 * @author Tinu
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/rmaitems")
public class RmaItemsController {
	
	@Autowired
	RmaItemsService rmaItemsService;
	
	
	/**
	 * Get all RmaItems list
	 * 
	 * @return ResponseEntity<List<RmaItemsResponseDTO> > 
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<RmaItemsResponseDTO> > getAll() throws Exception {
		List<RmaItemsResponseDTO> rmaItemsResponseDTOList = rmaItemsService.getAll();
		return ResponseEntity.ok(rmaItemsResponseDTOList);
	}
	
	/**
	 * Get RmaItems from Id
	 * @param id
	 * @return ResponseEntity<RmaItemsResponseDTO> 
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<RmaItemsResponseDTO> getById(@PathVariable long id) throws Exception {
		RmaItemsResponseDTO rmaItemsResponseDTO = rmaItemsService.getById(id);
		return ResponseEntity.ok(rmaItemsResponseDTO);
	}
	
	/**
	 * End point for saving RmaItems	 * 	
	 * @param RmaItemsRequestDTO
	 * @return ResponseEntity<RmaItemsResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<RmaItemsResponseDTO> saveRmaItems(
			@RequestBody RmaItemsRequestDTO rmaItemsRequestDTO) throws Exception {
		RmaItemsResponseDTO response = rmaItemsService.saveRmaItems(rmaItemsRequestDTO);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * End point for update RmaItems	 * 	
	 * @param RmaItemsRequestDTO
	 * @return ResponseEntity<RmaItemsResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<RmaItemsResponseDTO> updateRmaItems(@PathVariable long id,
			@RequestBody RmaItemsRequestDTO rmaItemsRequestDTO) throws Exception {
		RmaItemsResponseDTO response = rmaItemsService.updateRmaItems(id,rmaItemsRequestDTO);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * End point for deleting RmaItems	 * 	
	 * @param id
	 * @return ResponseEntity<RmaItemsResponseDTO>
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<RmaItemsResponseDTO> deleteRmaItems(
			@PathVariable long id) throws Exception {
		RmaItemsResponseDTO response = rmaItemsService.deleteRmaItems(id);
		return ResponseEntity.ok(response);
	}
	
	/**
	 *  Method for Search RmaItems based on RmaItemsid
	 * 
	 * @param RmaItemsRequestDTO
	 * @return ResponseEntity<List<RmaItemsResponseDTO>>
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<RmaItemsResponseDTO>> getRmaItems(@RequestBody RmaItemsRequestDTO rmaItemsRequestDTO)
			throws Exception {
		List<RmaItemsResponseDTO> rmaItemsResponseDTOList = rmaItemsService.searchForRmaItems(rmaItemsRequestDTO);
		return ResponseEntity.ok(rmaItemsResponseDTOList);
	}
}

