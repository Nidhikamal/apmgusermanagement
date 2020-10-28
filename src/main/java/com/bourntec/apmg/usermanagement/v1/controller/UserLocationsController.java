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

import com.bourntec.apmg.entity.UserLocations;
import com.bourntec.apmg.usermanagement.v1.dto.request.UserLocationsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PassAccessListResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.UserLocationsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.UserLocationsService;

@RestController(value = "UserLocationsController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/userlocations")
public class UserLocationsController {

	@Autowired
	UserLocationsService userLocationsService;

	/**
	 * This API save new UserLocations
	 * 
	 * @param UserLocationsRequestDTO
	 * @return ResponseEntity<UserLocationsResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<UserLocationsResponseDTO> saveUserLocations(
			@RequestBody UserLocationsRequestDTO userLocationsRequestDTO) throws Exception {
		UserLocationsResponseDTO userLocationsResponseDTO = userLocationsService
				.saveUserLocations(userLocationsRequestDTO);
		return ResponseEntity.ok(userLocationsResponseDTO);
	}

	/**
	 * This API updates UserLocations
	 * 
	 * @param String id
	 * @param String UserLocationsRequestDTO
	 * @return ResponseEntity<UserLocationsResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<UserLocationsResponseDTO> updateUserLocations(@PathVariable Long id,
			@RequestBody UserLocationsRequestDTO userLocationsRequestDTO) throws Exception {
		UserLocationsResponseDTO userLocationsResponseDTO = userLocationsService.updateUserLocations(id,
				userLocationsRequestDTO);
		return ResponseEntity.ok(userLocationsResponseDTO);
	}

	/**
	 * This API get UserLocations .
	 * 
	 * @param String id
	 * @return ResponseEntity<UserLocationsResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<UserLocationsResponseDTO> findUserLocationsById(@PathVariable Long id) throws Exception {
		UserLocationsResponseDTO userLocationsResponseDTO = userLocationsService.findUserLocationsById(id);
		return ResponseEntity.ok(userLocationsResponseDTO);
	}

	/**
	 * This API get UserLocations .
	 * 
	 * @return ResponseEntity<UserLocationsResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<UserLocationsResponseDTO>> findUserLocations() throws Exception {
		List<UserLocationsResponseDTO> userLocationsResponseDTOList = userLocationsService.findAllUserLocations();
		return ResponseEntity.ok(userLocationsResponseDTOList);
	}

	@PostMapping("/search")
	public ResponseEntity<List<UserLocations>> fetchUserLocationsByCriteria(
			@RequestBody UserLocationsRequestDTO paymentTermsRequestDTO) throws Exception {

		List<UserLocations> selectedUserLocations = userLocationsService
				.findUserLocationsByCriteria(paymentTermsRequestDTO);

		return ResponseEntity.ok(selectedUserLocations);
	}

	/**
	 * End point for delete user location *
	 * 
	 * @param id
	 * @return ResponseEntity<UserLocationsResponseDTO>
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<UserLocationsResponseDTO> userLocationsService(@PathVariable Long id) throws Exception {
		UserLocationsResponseDTO response = userLocationsService.deleteUserLocation(id);
		return ResponseEntity.ok(response);
	}
}
