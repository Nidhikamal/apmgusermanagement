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

import com.bourntec.apmg.entity.VendorContactDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorContactDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorContactDetailsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.VendorContactService;




/**
 * @author Vidya P
 *
 */
@RestController(value = "VendorContactController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/vendorcontact")
public class VendorContactController {

	@Autowired
	VendorContactService vendorContactService;
	
	/**
	 * This API creates new vendorcontact
	 * @param vendorContactRequestDTO
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */
	@PostMapping("")
	public ResponseEntity<VendorContactDetailsResponseDTO> saveVendorContact(@RequestBody VendorContactDetailsRequestDTO vendorContactRequestDTO) throws Exception{
		VendorContactDetailsResponseDTO vendorDataResponseDTO = vendorContactService.saveVendorContact(vendorContactRequestDTO);
		return ResponseEntity.ok(vendorDataResponseDTO);
	}
	
	/**
	 * This API update new VendorData
	 * @param vendorcontact id
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<VendorContactDetailsResponseDTO> updateVendorContact(@PathVariable Long id, @RequestBody VendorContactDetailsRequestDTO vendorContactRequestDTO) throws Exception {
		VendorContactDetailsResponseDTO contactDetailsResponseDTO = vendorContactService.updateVendorContact(id, vendorContactRequestDTO);
		return ResponseEntity.ok(contactDetailsResponseDTO);
	}
	/**
	 * This API get  vendorcontact by id
	 * @param vendorcontact id
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<VendorContactDetailsResponseDTO> findVendorContactById(@PathVariable Long id) throws Exception {
		VendorContactDetailsResponseDTO vendorDataResponseDTO = vendorContactService.findVendorContactById(id);
		return ResponseEntity.ok(vendorDataResponseDTO);
	}
	/**
	 * This API get  all vendorcontact 
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */
	
	@GetMapping("")
	public ResponseEntity<List<VendorContactDetailsResponseDTO>> findAllVendorContact() throws Exception{
		List<VendorContactDetailsResponseDTO> vendorDataResponseDTO= vendorContactService.findAllVendorContact();
		return ResponseEntity.ok(vendorDataResponseDTO);
	}
	
	/**
	 * This REST endpoint exposes the search interface for searching  vendorcontact dynamically
	 * @param vendorcontactRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 */
	@PostMapping("/search")
	public ResponseEntity<List<VendorContactDetails>> fetchByVendorContactCtriteria(@RequestBody VendorContactDetailsRequestDTO vendorContactDetailsRequestDTO) throws Exception  {		
		List<VendorContactDetails> selectedVendorData = vendorContactService.fetchByVendorContactCtriteria(vendorContactDetailsRequestDTO);
		return ResponseEntity.ok(selectedVendorData);
	}
	
	
}
