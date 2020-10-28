package com.bourntec.apmg.usermanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.entity.ShippingCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.ShippingCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ShippingCodesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.ShippingCodesService;

/**
 * @author Amal Chandra N A
 *
 */
@RestController(value = "ShippingCodesController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/shippingcodes")
public class ShippingCodesController {

	@Autowired
	ShippingCodesService shippingService;

	
	/**
	 * This REST endpoint exposes the search interface for saving shipping codes
	 * 
	 * @param
	 * @return ResponseEntity<ShippingCodesResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<ShippingCodesResponseDTO> saveShippingCodes(
			@RequestBody ShippingCodesRequestDTO shippingcodesreq) throws Exception {

		ShippingCodesResponseDTO savedresppacking = shippingService.saveShippingCodes(shippingcodesreq);

		return ResponseEntity.ok(savedresppacking);

	}

	/**
	 * This REST endpoint exposes the search interface for returning shipping codes
	 * by id
	 * 
	 * @param String id
	 * @return ResponseEntity<ShippingCodesResponseDTO>
	 */

	@GetMapping("/{id}")
	public ResponseEntity<ShippingCodesResponseDTO> fetchShippingCodesById(@PathVariable String id) throws Exception {

		ShippingCodesResponseDTO selectedpackingcodes = shippingService.getShippingCodesById(id);

		return ResponseEntity.ok(selectedpackingcodes);
	}

	/**
	 * This REST endpoint exposes the search interface for update shipping codes by
	 * id
	 * 
	 * @param ShippingCodesRequestDTO,String id
	 * @return ResponseEntity<ShippingCodesResponseDTO>
	 */

	@PutMapping("/{id}")
	public ResponseEntity<ShippingCodesResponseDTO> updateShippingCodes(@RequestBody ShippingCodesRequestDTO shippingcodesreq,
			@PathVariable String id) throws Exception {

		ShippingCodesResponseDTO updatedshippingcodes = shippingService.updateShippingCodes(id, shippingcodesreq);
		return ResponseEntity.ok(updatedshippingcodes);
	}

	/**
	 * This REST endpoint exposes the search interface for returning all shipping
	 * codes
	 * 
	 * @param
	 * @return ResponseEntity<ShippingCodesResponseDTO>
	 */

	@GetMapping("")
	public ResponseEntity<List<ShippingCodes>> fetchAllshippingCodes() throws Exception {

		List<ShippingCodes> allshippingcodes = shippingService.findAllShippingCodes();
		return ResponseEntity.ok(allshippingcodes);
	}
	
	/**
	 * This REST endpoint exposes the search interface for searching  company codes dynamically
	 * @param ShippingCodesRequestDTO
	 * @return List<ShippingCodes>
	 */
	
	@PostMapping("/search")
	public ResponseEntity<List<ShippingCodes>> fetchByCreditCriteria(@RequestBody ShippingCodesRequestDTO shippingcodesreq) throws Exception  {

		
		List<ShippingCodes> selectedShippingCodes= shippingService.findShippingCodeByCriteria(shippingcodesreq);

		return ResponseEntity.ok(selectedShippingCodes);
	}

}
