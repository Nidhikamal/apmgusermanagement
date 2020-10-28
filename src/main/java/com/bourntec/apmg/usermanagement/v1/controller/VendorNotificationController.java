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

import com.bourntec.apmg.entity.VendorNotification;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorNotificationRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorShippingDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorNotificationResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorShippingDetailsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.VendorNotificationService;



/**
 * @author Vidya P
 *
 */
@RestController(value = "VendorNotificationController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/vendorNotification")
public class VendorNotificationController {

	@Autowired
	VendorNotificationService vendorNotificationService;
	
	/**
	 * This API creates new vendorNotification
	 * @param VendorNotificationRequestDTO
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */
	@PostMapping("")
	public ResponseEntity<VendorNotificationResponseDTO> saveVendor(@RequestBody VendorNotificationRequestDTO vendorNotificationRequestDTO) throws Exception{
		VendorNotificationResponseDTO vendorNotificationResponseDTO = vendorNotificationService.save(vendorNotificationRequestDTO);
		return ResponseEntity.ok(vendorNotificationResponseDTO);
	}
	
	/**
	 * This API update new vendorNotification
	 * @param vendor id
	 * @return ResponseEntity<VendorNotificationRequestDTO>
	 * @throws Exception 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<VendorNotificationResponseDTO> updateVendor(@PathVariable String id, @RequestBody VendorNotificationRequestDTO vendorNotificationRequestDTO) throws Exception {
		VendorNotificationResponseDTO vendorNotificationResponseDTO = vendorNotificationService.update(id, vendorNotificationRequestDTO);
		return ResponseEntity.ok(vendorNotificationResponseDTO);
	}
	/**
	 * This API get  vendorNotification by Id
	 * @param vendor id
	 * @return ResponseEntity VendorNotificationResponseDTO
	 * @throws Exception 
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<VendorNotificationResponseDTO> findVendorById(@PathVariable String id) throws Exception {
		VendorNotificationResponseDTO vendorNotificationResponseDTO = vendorNotificationService.findById(id);
		return ResponseEntity.ok(vendorNotificationResponseDTO);
	}
	/**
	 * This API get  all vendorNotification 
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */
	
	@GetMapping("")
	public ResponseEntity<List<VendorNotificationResponseDTO>> findAllVendor() throws Exception{
		List<VendorNotificationResponseDTO> vendorNotificationResponseDTO= vendorNotificationService.findAll();
		return ResponseEntity.ok(vendorNotificationResponseDTO);
	}
	
	/**
	 * This REST endpoint exposes the search interface for searching  vendordata dynamically
	 * @param VendorShippingDetailsRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 */
	@PostMapping("/search")
	public ResponseEntity<List<VendorNotification>> fetchCtriteria(@RequestBody VendorNotificationResponseDTO vendorNotificationResponseDTO) throws Exception  {		
		List<VendorNotification> selectedVendorData = vendorNotificationService.findByCriteria(vendorNotificationResponseDTO);
		return ResponseEntity.ok(selectedVendorData);
	}
	
}
