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

import com.bourntec.apmg.entity.VendorData;
import com.bourntec.apmg.entity.VendorEmployees;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorEmployeesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorShippingDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorEmployeesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorShippingDetailsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.VendorEmployeeService;



/**
 * @author Vidya P
 *
 */
@RestController(value = "VendorEmployeeController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/vendoremployee")
public class VendorEmployeeController {

	@Autowired
	VendorEmployeeService vendorEmployeeService;
	
	/**
	 * This API creates new VendorData
	 * @param merchandiseCategoryRequestDTO
	 * @return ResponseEntity<VendorEmployeesResponseDTO>
	 * @throws Exception 
	 */
	@PostMapping("")
	public ResponseEntity<VendorEmployeesResponseDTO> saveVendorEmployees(@RequestBody VendorEmployeesRequestDTO vendorEmployeesRequestDTO) throws Exception{
		VendorEmployeesResponseDTO VendorEmployeesResponseDTO = vendorEmployeeService.saveVendorEmployees(vendorEmployeesRequestDTO);
		return ResponseEntity.ok(VendorEmployeesResponseDTO);
	}
	
	/**
	 * This API update new VendorData
	 * @param VendorEmployees id
	 * @return ResponseEntity<VendorEmployeesResponseDTO>
	 * @throws Exception 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<VendorEmployeesResponseDTO> updateVendorEmployees(@PathVariable Long id, @RequestBody VendorEmployeesRequestDTO vendorEmployeesRequestDTO) throws Exception {
		VendorEmployeesResponseDTO VendorEmployeesResponseDTO = vendorEmployeeService.updateVendorEmployees(id, vendorEmployeesRequestDTO);
		return ResponseEntity.ok(VendorEmployeesResponseDTO);
	}
	/**
	 * This API get  VendorData by
	 * @param vendor id
	 * @return ResponseEntity<VendorEmployeesResponseDTO>
	 * @throws Exception 
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<VendorEmployeesResponseDTO> findVendorEmployeesById(@PathVariable Long id) throws Exception {
		VendorEmployeesResponseDTO VendorEmployeesResponseDTO = vendorEmployeeService.findVendorEmployeesById(id);
		return ResponseEntity.ok(VendorEmployeesResponseDTO);
	}
	/**
	 * This API get  all VendorData 
	 * @return ResponseEntity<VendorEmployeesResponseDTO>
	 * @throws Exception 
	 */
	
	@GetMapping("")
	public ResponseEntity<List<VendorEmployeesResponseDTO>> findAllVendorEmployees() throws Exception{
		List<VendorEmployeesResponseDTO> VendorEmployeesResponseDTO= vendorEmployeeService.findAllVendorEmployees();
		return ResponseEntity.ok(VendorEmployeesResponseDTO);
	}
	
	/**
	 * This REST endpoint exposes the search interface for searching  VendorEmployees dynamically
	 * @param VendorEmployeesRequestDTO
	 * @return ResponseEntity<vendoremployee>
	 */
	@PostMapping("/search")
	public ResponseEntity<List<VendorEmployees>> fetchByVendorEmployeeCtriteria(@RequestBody VendorEmployeesRequestDTO vendorEmployeesRequestDTO) throws Exception  {		
		List<VendorEmployees> selectedVendorData = vendorEmployeeService.findVendorEmployeesByCriteria(vendorEmployeesRequestDTO);
		return ResponseEntity.ok(selectedVendorData);
	}
	
	
	
}
