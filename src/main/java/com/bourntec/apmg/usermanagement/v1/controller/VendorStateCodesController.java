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

import com.bourntec.apmg.entity.CustData;
import com.bourntec.apmg.entity.VendorStateCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorStateCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustDataResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.UserLocationsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorStateCodesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.VendorStateCodesService;

/**
 * @author Vidya P
 *
 */
@RestController(value = "VendorStateCodesController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/VenderStateCodes")
public class VendorStateCodesController {
	
	@Autowired
	VendorStateCodesService  vendorStateService ;
	/**
	 * This API creates Customer 
	 * @param custDataRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 * @throws Exception 
	 */
	@PostMapping("")
	public ResponseEntity<VendorStateCodesResponseDTO> saveVendorStateCustomer(@RequestBody VendorStateCodesRequestDTO custDataRequestDTO) throws Exception{
		VendorStateCodesResponseDTO custDataResponseDTO = vendorStateService.saveVendorStateCustomer(custDataRequestDTO);
		return ResponseEntity.ok(custDataResponseDTO);
	}
	
	/**
	 * This API get customerByID  
	 * @param custDataRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 * @throws Exception 
	 */
	@GetMapping("/{stateCode}")
	public ResponseEntity<VendorStateCodesResponseDTO> findStatecodeById(@PathVariable String stateCode) throws Exception {
		VendorStateCodesResponseDTO custDataResponseDTO = vendorStateService.findStatecodeById(stateCode);
		return ResponseEntity.ok(custDataResponseDTO);
	}
	
	/**
	 * This REST endpoint exposes the search interface for updating  customer by Id
	 * @param 
	 * @return ResponseEntity<CustDataResponseDTO>
	 */

	@PutMapping("/{stateCode}")
	public ResponseEntity<VendorStateCodesResponseDTO> updatestatecode(@RequestBody VendorStateCodesRequestDTO customerReqDTO,
			
			@PathVariable String stateCode) throws Exception {

		VendorStateCodesResponseDTO updatedReqDTO = vendorStateService.updatestatecode(stateCode, customerReqDTO);
		return ResponseEntity.ok(updatedReqDTO);
	}
	
	/**
	 * This REST endpoint exposes the search interface for searching  customer dynamically
	 * @param CustDataRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 */
	@PostMapping("/search")
	public ResponseEntity<List<VendorStateCodes>>
	fetchByStaterCtriteria(@RequestBody VendorStateCodesRequestDTO customerReqDTO) throws Exception  {

		
		List<VendorStateCodes> selectedCustomers = vendorStateService.fetchByStaterCtriteria(customerReqDTO);

		return ResponseEntity.ok(selectedCustomers);
	}

	/**
	 * This REST endpoint exposes the search interface for returning  all customers
	 * @param 
	 * @return ResponseEntity<CustDataResponseDTO>
	 */
	@GetMapping("")
	public ResponseEntity<List<VendorStateCodes>> fetchAllStatecode() throws Exception {

		List<VendorStateCodes> allCustomers = vendorStateService.fetchAllStatecode();
		return ResponseEntity.ok(allCustomers);
	}
	/**
	 * End point for delete VendorStateCodes *
	 * 
	 * @param id
	 * @return ResponseEntity<VendorStateCodesResponseDTO>
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<VendorStateCodesResponseDTO> deleteVendorStateCodes(@PathVariable String id) throws Exception {
		VendorStateCodesResponseDTO response = vendorStateService.deleteVendorStateCodes(id);
		return ResponseEntity.ok(response);
	}
}
