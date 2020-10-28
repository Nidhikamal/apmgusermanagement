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

import com.bourntec.apmg.entity.CustData;
import com.bourntec.apmg.entity.VendorData;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorDataResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.VendorDataService;
import com.bourntec.apmg.usermanagement.v1.service.VendorService;



/**
 * @author Vidya P
 *
 */
@RestController(value = "VendorDataController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/vendorData")
public class VendorDataController {

	@Autowired
	VendorDataService vendorDataService;
	
	/**
	 * This API creates new VendorData
	 * @param vendorDataRequestDTO
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */
	@PostMapping("")
	public ResponseEntity<VendorDataResponseDTO> saveVendor(@RequestBody VendorDataRequestDTO vendorDataRequestDTO) throws Exception{
		VendorDataResponseDTO vendorDataResponseDTO = vendorDataService.saveVendorData(vendorDataRequestDTO);
		return ResponseEntity.ok(vendorDataResponseDTO);
	}
	
	/**
	 * This API update new VendorData
	 * @param vendor id
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<VendorDataResponseDTO> updateVendor(@PathVariable String id, @RequestBody VendorDataRequestDTO vendorDataRequestDTO) throws Exception {
		VendorDataResponseDTO vendorDataResponseDTO = vendorDataService.updateVendorData(id, vendorDataRequestDTO);
		return ResponseEntity.ok(vendorDataResponseDTO);
	}
	/**
	 * This API get  VendorData by
	 * @param vendor id
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<VendorDataResponseDTO> findVendorDataById(@PathVariable String id) throws Exception {
		VendorDataResponseDTO vendorDataResponseDTO = vendorDataService.findVendorDataById(id);
		return ResponseEntity.ok(vendorDataResponseDTO);
	}
	/**
	 * This API get  all VendorData 
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */
	
	@GetMapping("")
	public ResponseEntity<List<VendorDataResponseDTO>> findAllVendorData() throws Exception{
		List<VendorDataResponseDTO> vendorDataResponseDTO= vendorDataService.findAllVendorData();
		return ResponseEntity.ok(vendorDataResponseDTO);
	}
	
	/**
	 * This REST endpoint exposes the search interface for searching  vendordata dynamically
	 * @param VendorDataRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 */
	@PostMapping("/search")
	public ResponseEntity<List<VendorData>> findVendorDataByCriteria(@RequestBody VendorDataRequestDTO vendorDataRequestDTO) throws Exception  {		
		List<VendorData> selectedVendorData = vendorDataService.findVendorDataByCriteria(vendorDataRequestDTO);
		return ResponseEntity.ok(selectedVendorData);
	}
	
}
