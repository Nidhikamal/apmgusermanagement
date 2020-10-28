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

import com.bourntec.apmg.usermanagement.v1.dto.request.ReturnItemsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ReturnItemsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.ReturnItemsService;

/**
 * Controller for ReturnItems Entity
 * @author Tinu
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/returnitems")
public class ReturnItemsController {
	
	@Autowired
	ReturnItemsService returnItemsService;
	
	
	/**
	 * Get all ReturnItems list
	 * 
	 * @return ResponseEntity<List<ReturnItemsResponseDTO>> 
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<ReturnItemsResponseDTO>> getAll() throws Exception {
		List<ReturnItemsResponseDTO> returnItemsResponseDTOList = returnItemsService.getAll();
		return ResponseEntity.ok(returnItemsResponseDTOList);
	}
	
	/**
	 * Get ReturnItems from Id
	 * @param id
	 * @return ResponseEntity<ReturnItemsResponseDTO> 
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ReturnItemsResponseDTO> getById(@PathVariable long id) throws Exception {
		ReturnItemsResponseDTO returnItemsResponseDTO = returnItemsService.getById(id);
		return ResponseEntity.ok(returnItemsResponseDTO);
	}
	
	/**
	 * End point for saving ReturnItems	 * 	
	 * @param ReturnItemsRequestDTO
	 * @return ResponseEntity<ReturnItemsResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<ReturnItemsResponseDTO> saveReturnItems(
			@RequestBody ReturnItemsRequestDTO returnItemsRequestDTO) throws Exception {
		ReturnItemsResponseDTO response = returnItemsService.saveReturnItems(returnItemsRequestDTO);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * End point for update ReturnItems	 * 	
	 * @param ReturnItemsRequestDTO
	 * @return ResponseEntity<ReturnItemsResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<ReturnItemsResponseDTO> updateReturnItems(@PathVariable long id,
			@RequestBody ReturnItemsRequestDTO returnItemsRequestDTO) throws Exception {
		ReturnItemsResponseDTO response = returnItemsService.updateReturnItems(id,returnItemsRequestDTO);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * End point for deleting ReturnItems	 * 	
	 * @param id
	 * @return ResponseEntity<ReturnItemsResponseDTO>
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<ReturnItemsResponseDTO> deleteReturnItems(
			@PathVariable long id) throws Exception {
		ReturnItemsResponseDTO response = returnItemsService.deleteReturnItems(id);
		return ResponseEntity.ok(response);
	}
	
	/**
	 *  Method for Search ReturnItems based on ReturnItemsid
	 * 
	 * @param ReturnItemsRequestDTO
	 * @return ResponseEntity<List<ReturnItemsResponseDTO>>
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<ReturnItemsResponseDTO>> getReturnItems(@RequestBody ReturnItemsRequestDTO returnItemsRequestDTO)
			throws Exception {
		List<ReturnItemsResponseDTO> returnItemsResponseDTOList = returnItemsService.searchForReturnItems(returnItemsRequestDTO);
		return ResponseEntity.ok(returnItemsResponseDTOList);
	}
	
}
