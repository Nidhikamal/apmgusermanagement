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

import com.bourntec.apmg.entity.VendorBrandDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorBrandDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorContactDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorBrandDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorBrandDetailsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorContactDetailsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.VendorBrandService;



/**
 * @author Vidya P
 *
 */
@RestController(value = "VendorBrandController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/vendorbrand")
public class VendorBrandController {

	@Autowired
	VendorBrandService vendorBrandService;
	
	/**
	 * This API creates new VendorBrandDetails
	 * @param merchandiseCategoryRequestDTO
	 * @return ResponseEntity<VendorBrandDetailsResponseDTO>
	 * @throws Exception 
	 */
	@PostMapping("")
	public ResponseEntity<VendorBrandDetailsResponseDTO> saveVendorBrand(@RequestBody VendorBrandDetailsRequestDTO vendorBrandDetailsRequestDTO) throws Exception{
		VendorBrandDetailsResponseDTO vendorBrandDetailsResponseDTO = vendorBrandService.saveVendorBrand(vendorBrandDetailsRequestDTO);
		return ResponseEntity.ok(vendorBrandDetailsResponseDTO);
	}
	
	/**
	 * This API update new VendorBrandDetails
	 * @param vendorbrand id
	 * @return ResponseEntity<VendorBrandDetailsResponseDTO>
	 * @throws Exception 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<VendorBrandDetailsResponseDTO> updateVendorBrand(@PathVariable Long id, @RequestBody VendorBrandDetailsRequestDTO vendorBrandDetailsRequestDTO) throws Exception {
		VendorBrandDetailsResponseDTO vendorBrandDetailsResponseDTO = vendorBrandService.updateVendorBrand(id, vendorBrandDetailsRequestDTO);
		return ResponseEntity.ok(vendorBrandDetailsResponseDTO);
	}
	/**
	 * This API get  VendorBrandDetails by
	 * @param vendorbrand id
	 * @return ResponseEntity<VendorBrandDetailsResponseDTO>
	 * @throws Exception 
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<VendorBrandDetailsResponseDTO> findVendorBrandById(@PathVariable Long id) throws Exception {
		VendorBrandDetailsResponseDTO vendorBrandDetailsResponseDTO = vendorBrandService.findVendorBrandById(id);
		return ResponseEntity.ok(vendorBrandDetailsResponseDTO);
	}
	/**
	 * This API get  all VendorBrandDetails 
	 * @return ResponseEntity<VendorBrandDetailsResponseDTO>
	 * @throws Exception 
	 */
	
	@GetMapping("")
	public ResponseEntity<List<VendorBrandDetailsResponseDTO>> findAllVendorBrand() throws Exception{
		List<VendorBrandDetailsResponseDTO> vendorBrandDetailsResponseDTO= vendorBrandService.findAllVendorBrand();
		return ResponseEntity.ok(vendorBrandDetailsResponseDTO);
	}
	
	/**
	 * This REST endpoint exposes the search interface for searching  vendorcontact dynamically
	 * @param vendorcontactRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 */
	@PostMapping("/search")
	public ResponseEntity<List<VendorBrandDetails>> fetchByVendorBrandsCriteria(@RequestBody VendorBrandDetailsRequestDTO vendorBrandDetailsRequestDTO) throws Exception  {		
		List<VendorBrandDetails> selectedVendorData = vendorBrandService.findVendorBrandCriteria(vendorBrandDetailsRequestDTO);
		return ResponseEntity.ok(selectedVendorData);
	}
	
}
