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

import com.bourntec.apmg.usermanagement.v1.dto.request.ShippingTypeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ShippingTypeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.ShippingTypeService;
/**
 * Controller for ShippingType Entity
 * @author Tinu
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/shippingtype")
public class ShippingTypeController {
	
	@Autowired
	ShippingTypeService shippingTypeService;
	
	
	/**
	 * Get all ShippingType list
	 * 
	 * @return List<ShippingTypeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<ShippingTypeResponseDTO>> getAll() throws Exception {
		List<ShippingTypeResponseDTO> shippingTypeResponseDTOList = shippingTypeService.getAll();
		return ResponseEntity.ok(shippingTypeResponseDTOList);
	}
	
	/**
	 * Get ShippingType from Id
	 * @param id
	 * @return ShippingTypeResponseDTO
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ShippingTypeResponseDTO> getById(@PathVariable Long id) throws Exception {
		ShippingTypeResponseDTO shippingTypeResponseDTO = shippingTypeService.getById(id);
		return ResponseEntity.ok(shippingTypeResponseDTO);
	}
	
	/**
	 * End point for saving ShippingType	 * 	
	 * @param ShippingTypeRequestDTO
	 * @return ResponseEntity<ShippingTypeResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<ShippingTypeResponseDTO> saveShippingType(
			@RequestBody ShippingTypeRequestDTO shippingTypeRequestDTO) throws Exception {
		ShippingTypeResponseDTO response = shippingTypeService.saveShippingType(shippingTypeRequestDTO);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * End point for update ShippingType	 *
	 * @param #ida
	 * @param ShippingTypeRequestDTO
	 * @return ResponseEntity<ShippingTypeResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<ShippingTypeResponseDTO> updateShippingType(@PathVariable Long id,
			@RequestBody ShippingTypeRequestDTO shippingTypeRequestDTO) throws Exception {
		ShippingTypeResponseDTO response = shippingTypeService.updateShippingType(id,shippingTypeRequestDTO);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * End point for deleting ShippingType	 * 	
	 * @param id
	 * @return ResponseEntity<ShippingTypeResponseDTO>
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<ShippingTypeResponseDTO> deleteShippingType(
			@PathVariable Long id) throws Exception {
		ShippingTypeResponseDTO response = shippingTypeService.deleteShippingType(id);
		return ResponseEntity.ok(response);
	}
	
	/**
	 *  Method for Search ShippingType 
	 * 
	 * @param ShippingTypeRequestDTO
	 * @return ResponseEntity<List<ShippingTypeResponseDTO>>
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<ShippingTypeResponseDTO>> searchShippingType(@RequestBody ShippingTypeRequestDTO shippingTypeRequestDTO)
			throws Exception {
		List<ShippingTypeResponseDTO> shippingTypeResponseDTOList = shippingTypeService.searchForShippingType(shippingTypeRequestDTO);
		return ResponseEntity.ok(shippingTypeResponseDTOList);
	}
}
