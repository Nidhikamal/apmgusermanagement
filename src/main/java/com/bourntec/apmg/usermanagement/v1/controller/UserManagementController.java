package com.bourntec.apmg.usermanagement.v1.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.entity.PassTable;
import com.bourntec.apmg.usermanagement.v1.dto.request.PassModuleOptionListRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.PassTableRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.SuccessResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PassTableResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.PassModuleOptionService;
import com.bourntec.apmg.usermanagement.v1.service.UserService;

/**
 * @author Srijini T.S
 *
 */
@RestController(value = "UserManagementController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v3/user")
public class UserManagementController {

	@Autowired
	UserService userService;

	@Autowired
	PassModuleOptionService passModuleOptionService;

	/**
	 * Get all user list
	 * 
	 * @return
	 * @throws Exception
	 */

	// @PreAuthorize("hasPermission(returnObject,
	// '^/forms/administration/validIP')")
	public ResponseEntity<List<PassTable>> getAll() throws Exception {
		List<PassTable> userLists = userService.getAll();
		return ResponseEntity.ok(userLists);
	}

	/**
	 * Map All Users Permisssions
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/permission")
	// @PreAuthorize("hasPermission(returnObject,
	// '^/forms/inventory/editInventory.jsf')")
	public ResponseEntity<Map<Object, Map<Object, List<Object>>>> getAllUserPermissionList() throws Exception {
		// Map<Object, Map<Object, List<Object>>> userPermissionList =
		// passModuleOptionService.getAllOptions();
		return null;// ResponseEntity.ok(userPermissionList);
	}

	/**
	 * AP 227 - Method for Search user based on userid
	 * 
	 * @param PassTableRequestDTO
	 * @return ResponseEntity<List<UserResponseDTO>>
	 * @throws Exception
	 */
	@GetMapping("/search")
	public ResponseEntity<List<PassTableResponseDTO>> getUserSearchList(@RequestBody PassTableRequestDTO userRequestDTO,
			@RequestParam int page, @RequestParam int size) throws Exception {
		List<PassTableResponseDTO> userResponseDTOList = userService.searchForUser(userRequestDTO, page, size);
		return ResponseEntity.ok(userResponseDTOList);
	}

	/**
	 * AP 228 - Method for Set each Module permission separately
	 * 
	 * @param userId
	 * @param List<PassModuleOptionListRequestDTO>
	 * @return ResponseEntity<ResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("/update/{userId}")
	public ResponseEntity<SuccessResponseDTO> updateUserRole(@PathVariable String userId,
			@RequestBody List<PassModuleOptionListRequestDTO> optionListRequestDTOs) throws Exception {
		SuccessResponseDTO response = userService.updateUserRole(userId, optionListRequestDTOs);
		return ResponseEntity.ok(response);
	}

	/**
	 * AP 21 - Method for Copy roles from already existing user to new user
	 * 
	 * @param newUserId of new user
	 * @param UserId    of existing user
	 * @return ResponseEntity<String>
	 * @throws Exception
	 */
	@PostMapping("/copyRole/{newUserId}/{userId}")
	public ResponseEntity<SuccessResponseDTO> setUserForNewRole(@PathVariable String newUserId,
			@PathVariable String userId) throws Exception {
		SuccessResponseDTO response = userService.setUserForNewRole(newUserId, userId);
		return ResponseEntity.ok(response);
	}

}
