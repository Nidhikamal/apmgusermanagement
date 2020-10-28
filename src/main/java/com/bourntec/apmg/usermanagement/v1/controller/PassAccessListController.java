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

import com.bourntec.apmg.entity.PassAccessList;
import com.bourntec.apmg.usermanagement.v1.dto.request.PassAccessListRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PassAccessListResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.PassAccessListService;



/**
 * @author Srijini
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/passaccess")
public class PassAccessListController {
	@Autowired
	PassAccessListService passAccessListService;
	
	/**
	 * Get all permission list
	 * 
	 * @return List<PassAccessList>
	 * @throws Exception
	 */

	// @PreAuthorize("hasPermission(returnObject,
	// '^/forms/administration/validIP')")
	@GetMapping("")
	public ResponseEntity<List<PassAccessList>> getAll() throws Exception {
		List<PassAccessList> passAccessLists = passAccessListService.getAll();
		return ResponseEntity.ok(passAccessLists);
	}
	
	/**
	 * Get permission of {userId}
	 * @param userId
	 * @return List<PassAccessList>
	 * @throws Exception
	 */
	@GetMapping("/{userId}")
	public ResponseEntity<List<PassAccessList>> getById(@PathVariable String userId) throws Exception {
		List<PassAccessList> passAccessListObj = passAccessListService.getById(userId);
		return ResponseEntity.ok(passAccessListObj);
	}
	
	/**
	 * End point for saving user permission	 * 
	 * @param PassAccessListResponseDTO
	 * @return ResponseEntity<PassAccessListResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<PassAccessListResponseDTO> saveUserRole(
			@RequestBody PassAccessListRequestDTO accessListRequestDTO) throws Exception {
		PassAccessListResponseDTO response = passAccessListService.saveUserRole(accessListRequestDTO);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * End point for update user permission	 * 
	 * @param PassAccessListResponseDTO
	 * @return ResponseEntity<PassAccessListResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("")
	public ResponseEntity<PassAccessListResponseDTO> updateUserRole(
			@RequestBody List<PassAccessListRequestDTO> accessListRequestDTO) throws Exception {
		PassAccessListResponseDTO response = passAccessListService.updateUserRole(accessListRequestDTO);
		return ResponseEntity.ok(response);
	}
	/**
	 * End point for delete user permission	 * 
	 * @param userId
	 * @return ResponseEntity<PassAccessListResponseDTO>
	 * @throws ExceptionPassAccessListRequestDTO> accessListRequestDTO
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<PassAccessListResponseDTO> deleteUserRole(
			@PathVariable Long id) throws Exception {
		PassAccessListResponseDTO response = passAccessListService.deleteUserRole(id);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * AP 227 - Method for Search
	 * 
	 * @param PassAccessListRequestDTO
	 * @return ResponseEntity<List<PassAccessListResponseDTO>>
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<PassAccessListResponseDTO>> getUserSearchList(@RequestBody PassAccessListRequestDTO accessListRequestDTO,
			@RequestParam int page, @RequestParam int size)
			throws Exception {
		List<PassAccessListResponseDTO> userResponseDTOList = passAccessListService.search(accessListRequestDTO,page,size);
		return ResponseEntity.ok(userResponseDTOList);
	}
}
