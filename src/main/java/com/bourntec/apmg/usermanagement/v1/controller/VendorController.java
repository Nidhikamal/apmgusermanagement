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

import com.bourntec.apmg.usermanagement.v1.dto.request.VendorDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorDataResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.VendorService;



/**
 * @author Vidya P
 *
 */
@RestController(value = "VendorController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v3")
public class VendorController {

	@Autowired
	VendorService vendorService;
	
	/**
	 * This API creates new VendorData
	 * @param merchandiseCategoryRequestDTO
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */
	@PostMapping("/vendor")
	public ResponseEntity<VendorDataResponseDTO> saveVendor(@RequestBody VendorDataRequestDTO vendorDataRequestDTO) throws Exception{
		VendorDataResponseDTO vendorDataResponseDTO = vendorService.saveVendor(vendorDataRequestDTO);
		return ResponseEntity.ok(vendorDataResponseDTO);
	}
	
	/**
	 * This API update new VendorData
	 * @param vendor id
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */
	@PutMapping("/vendor/{id}")
	public ResponseEntity<VendorDataResponseDTO> updateVendor(@PathVariable String id, @RequestBody VendorDataRequestDTO vendorDataRequestDTO) throws Exception {
		VendorDataResponseDTO vendorDataResponseDTO = vendorService.updateVendor(id, vendorDataRequestDTO);
		return ResponseEntity.ok(vendorDataResponseDTO);
	}
	/**
	 * This API get  VendorData by
	 * @param vendor id
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */
	
	@GetMapping("/vendor/{id}")
	public ResponseEntity<VendorDataResponseDTO> findVendorById(@PathVariable String id) throws Exception {
		VendorDataResponseDTO vendorDataResponseDTO = vendorService.findVendorById(id);
		return ResponseEntity.ok(vendorDataResponseDTO);
	}
	/**
	 * This API get  all VendorData 
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */
	
	@GetMapping("/vendor")
	public ResponseEntity<List<VendorDataResponseDTO>> findAllVendor() throws Exception{
		List<VendorDataResponseDTO> vendorDataResponseDTO= vendorService.findAllVendor();
		return ResponseEntity.ok(vendorDataResponseDTO);
	}
	
	
}
