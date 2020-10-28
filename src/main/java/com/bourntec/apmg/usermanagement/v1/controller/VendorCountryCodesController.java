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

import com.bourntec.apmg.entity.VendorCountryCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorCountryCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorCountryCodesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.VendorCountryCodesService;

@RestController(value = "VenderCountryCodesController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/VenderCountryCodes")
public class VendorCountryCodesController {
	
	@Autowired
	VendorCountryCodesService venderCountryService ;
	
	
	@PostMapping("")
	public ResponseEntity<VendorCountryCodesResponseDTO> saveVendorCountry(
			@RequestBody VendorCountryCodesRequestDTO countryRequestDTO) throws Exception {
		VendorCountryCodesResponseDTO vendorCountrycodeResponseDTO = venderCountryService.saveVendorCountry(countryRequestDTO);
		return ResponseEntity.ok(vendorCountrycodeResponseDTO);
	}

	/**
	 * This API updates new VendorCountry object
	 * 
	 * @param VendorCountryCodesRequestDTO
	 * @param countryCode
	 * @return ResponseEntity<VendorCountrycodeResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/{countryCode}")
	public ResponseEntity<VendorCountryCodesResponseDTO> updateVendorCountry(@PathVariable String countryCode,
			@RequestBody VendorCountryCodesRequestDTO countryRequestDTO) throws Exception {
		VendorCountryCodesResponseDTO countrycodeResponseDTO = venderCountryService.updateVendorCountry(countryCode,
				countryRequestDTO);
		return ResponseEntity.ok(countrycodeResponseDTO);
	}

	/**
	 * This API fetches an VendorCountry object.
	 * 
	 * @param countryCode
	 * @param VendorCountrycodeRequestDTO
	 * @return ResponseEntity<VendorCountrycodeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/{countryCode}")
	public ResponseEntity<VendorCountryCodesResponseDTO> findByVendorcountryCode(@PathVariable String countryCode)
			throws Exception {
		VendorCountryCodesResponseDTO vendorCountrycodeResponseDTO = venderCountryService.findByVendorcountryCode(countryCode);
		return ResponseEntity.ok(vendorCountrycodeResponseDTO);
	}

	/**
	 * This API fetches an AllCountry object.
	 * 
	 * @return ResponseEntity<VendorCountryCodes>
	 * @throws Exception
	 */

	@GetMapping("")
	public List<VendorCountryCodes> findAllVendorCountry() throws Exception {
		List<VendorCountryCodes> vendorCountryCodesList = venderCountryService.findAllVendorCountry();
		return vendorCountryCodesList;
	}


}
