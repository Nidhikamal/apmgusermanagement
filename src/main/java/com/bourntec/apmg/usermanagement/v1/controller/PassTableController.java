/**
 * 
 */
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.usermanagement.v1.dto.request.PassTableRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PassTableResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.PassTableService;

/**
 * @author Srijini
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/pass")
public class PassTableController {
	
	@Autowired
	PassTableService passTableService;
	
	/**
	 * Get all passTable list
	 * 
	 * @return List<PassTableResponseDTO>
	 * @throws Exception
	 */

	// @PreAuthorize("hasPermission(returnObject,
	// '^/forms/administration/validIP')")
	@GetMapping("")
	public ResponseEntity<List<PassTableResponseDTO>> getAll() throws Exception {
		List<PassTableResponseDTO> passTableResponseDTOList = passTableService.getAll();
		return ResponseEntity.ok(passTableResponseDTOList);
	}
	
	/**
	 * Get passTable from userId
	 * @param userId
	 * @return PassTableResponseDTO
	 * @throws Exception
	 */
	@GetMapping("/{userId}")
	public ResponseEntity<PassTableResponseDTO> getById(@PathVariable String userId) throws Exception {
		PassTableResponseDTO passTableResponseDTO = passTableService.getById(userId);
		return ResponseEntity.ok(passTableResponseDTO);
	}
	
	/**
	 * End point for saving passTable	 * 	
	 * @param PassTableRequestDTO
	 * @return ResponseEntity<PassTableResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<PassTableResponseDTO> savePassTable(
			@RequestBody PassTableRequestDTO passTableRequestDTO) throws Exception {
		PassTableResponseDTO response = passTableService.savePassTable(passTableRequestDTO);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * End point for update passTable	 * 	
	 * @param PassTableRequestDTO
	 * @return ResponseEntity<PassTableResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/{userId}")
	public ResponseEntity<PassTableResponseDTO> updatePassTable(@PathVariable String userId,
			@RequestBody PassTableRequestDTO passTableRequestDTO) throws Exception {
		PassTableResponseDTO response = passTableService.updatePassTable(userId,passTableRequestDTO);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * End point for deleting passTable	 * 	
	 * @param PassTableRequestDTO
	 * @return ResponseEntity<PassTableResponseDTO>
	 * @throws Exception
	 */
	@DeleteMapping("/{userId}")
	public ResponseEntity<PassTableResponseDTO> updatePassTableRole(
			@PathVariable String userId) throws Exception {
		PassTableResponseDTO response = passTableService.deletePassTable(userId);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * AP 227 - Method for Search passTable based on passTableid
	 * 
	 * @param PassTableRequestDTO
	 * @return ResponseEntity<List<PassTableResponseDTO>>
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<PassTableResponseDTO>> getPassTableSearchList(@RequestBody PassTableRequestDTO passTableRequestDTO,
			@RequestParam int page, @RequestParam int size) throws Exception {
		List<PassTableResponseDTO> passTableResponseDTOList = passTableService.searchForPassTable(passTableRequestDTO, page, size);
		return ResponseEntity.ok(passTableResponseDTOList);
	}
}
