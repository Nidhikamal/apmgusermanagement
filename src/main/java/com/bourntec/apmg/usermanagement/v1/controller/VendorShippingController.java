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

import com.bourntec.apmg.entity.VendorShippingDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorShippingDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorShippingDetailsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.VendorShippingService;



/**
 * @author Vidya P
 *
 */
@RestController(value = "VendorShippingController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/vendorShipping")
public class VendorShippingController {

	@Autowired
	VendorShippingService vendorShippingService;
	
	/**
	 * This API creates new VendorShipping
	 * @param merchandiseCategoryRequestDTO
	 * @return ResponseEntity<VendorShippingResponseDTO>
	 * @throws Exception 
	 */
	@PostMapping("")
	public ResponseEntity<VendorShippingDetailsResponseDTO> saveVendorShipping(@RequestBody VendorShippingDetailsRequestDTO vendorShippingRequestDTO) throws Exception{
		VendorShippingDetailsResponseDTO vendorShippingResponseDTO = vendorShippingService.saveVendorShipping(vendorShippingRequestDTO);
		return ResponseEntity.ok(vendorShippingResponseDTO);
	}
	
	/**
	 * This API update new VendorShipping
	 * @param vendor id
	 * @return ResponseEntity<VendorShippingResponseDTO>
	 * @throws Exception 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<VendorShippingDetailsResponseDTO> updateVendorShipping(@PathVariable Long id, @RequestBody VendorShippingDetailsRequestDTO vendorShippingRequestDTO) throws Exception {
		VendorShippingDetailsResponseDTO vendorShippingResponseDTO = vendorShippingService.updateVendorShipping(id, vendorShippingRequestDTO);
		return ResponseEntity.ok(vendorShippingResponseDTO);
	}
	/**
	 * This API get  VendorShipping by
	 * @param vendor id
	 * @return ResponseEntity<VendorShippingResponseDTO>
	 * @throws Exception 
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<VendorShippingDetailsResponseDTO> findVendorShippingById(@PathVariable Long id) throws Exception {
		VendorShippingDetailsResponseDTO vendorShippingResponseDTO = vendorShippingService.findVendorShippingById(id);
		return ResponseEntity.ok(vendorShippingResponseDTO);
	}
	/**
	 * This API get  all VendorShipping 
	 * @return ResponseEntity<VendorShippingResponseDTO>
	 * @throws Exception 
	 */
	
	@GetMapping("")
	public ResponseEntity<List<VendorShippingDetailsResponseDTO>> findAllVendorShipping() throws Exception{
		List<VendorShippingDetailsResponseDTO> vendorShippingResponseDTO= vendorShippingService.findAllVendorShipping();
		return ResponseEntity.ok(vendorShippingResponseDTO);
	}
	
	/**
	 * This REST endpoint exposes the search interface for searching  vendorShipping dynamically
	 * @param VendorShippingDetailsRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 */
	@PostMapping("/search")
	public ResponseEntity<List<VendorShippingDetails>> fetchByVendorShippingCtriteria(@RequestBody VendorShippingDetailsRequestDTO vendorShippingDetailsRequestDTO) throws Exception  {		
		List<VendorShippingDetails> selectedVendorData = vendorShippingService.findVendorShippingByCriteria(vendorShippingDetailsRequestDTO);
		return ResponseEntity.ok(selectedVendorData);
	}
	
	
}
