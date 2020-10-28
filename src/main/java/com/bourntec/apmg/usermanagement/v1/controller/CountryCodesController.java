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

import com.bourntec.apmg.entity.CountryCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.CountryCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CountryCodesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.CountryCodesService;

/**
 * @author naveen Radhakrishnan
 *
 */

@RestController(value = "CountryCodesController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/countrycodes")
public class CountryCodesController {
	
	@Autowired
	CountryCodesService customerservice;
	
	

	

	/**
	 * This API creates new customer country object
	 * 
	 * @param CountryCodesRequestDTO
	 * @return ResponseEntity<CountrycodeResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("")
	public ResponseEntity<CountryCodesResponseDTO> saveCustomerCountry(@RequestBody CountryCodesRequestDTO countryRequestDTO)
			throws Exception {
		CountryCodesResponseDTO countrycodeResponseDTO = customerservice.saveCustomerCountry(countryRequestDTO);
		return ResponseEntity.ok(countrycodeResponseDTO);
	}

	/**
	 * This API updates an customercountry object.
	 * 
	 * @param countryCode
	 * @param CountryCodesRequestDTO
	 * @return ResponseEntity<CountrycodeResponseDTO>
	 * @throws Exception
	 */

	@PutMapping("/{countryCode}")
	public ResponseEntity<CountryCodesResponseDTO> updateCountry(@PathVariable String countryCode,
			@RequestBody CountryCodesRequestDTO countryRequestDTO) throws Exception {
		CountryCodesResponseDTO countrycodeResponseDTO = customerservice.updateCountry(countryCode, countryRequestDTO);
		return ResponseEntity.ok(countrycodeResponseDTO);
	}

	/**
	 * This API fetch an customercountry object.
	 * 
	 * @param userId
	 * @return ResponseEntity<CountrycodeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/{countryCode}")
	public ResponseEntity<CountryCodesResponseDTO> findBycountryCode(@PathVariable String countryCode) throws Exception {
		CountryCodesResponseDTO countrycodeResponseDTO = customerservice.findBycountryCode(countryCode);
		return ResponseEntity.ok(countrycodeResponseDTO);
	}

	/**
	 * This API fetch all fetchAllCountryCode.
	 * 
	 * @return List<CountryCodes>
	 * @throws Exception
	 */

	@GetMapping("")
	public List<CountryCodes> fetchAllCountryCode() throws Exception {
		List<CountryCodes> countrycodeResponseList = customerservice.fetchAllCountryCode();
		return countrycodeResponseList;
	}

	
	/**
	 * This API fetch all fetchAllCountryCode.
	 * 
	 * @return List<CountryCodes>
	 * @throws Exception
	 */

	/**
	 * This REST endpoint exposes the search interface for searching  customer dynamically
	 * @param CustDataRequestDTO
	 * @return ResponseEntity<CountryCodes>
	 */
	@PostMapping("/search")
	public ResponseEntity<List<CountryCodes>>
	fetchByCustomercountry(@RequestBody CountryCodesRequestDTO brandsreqDTO) throws Exception  {

		
		List<CountryCodes> countryCodes = customerservice.fetchByCustomercountry(brandsreqDTO);

		return ResponseEntity.ok(countryCodes);
	}

	
	
	
}
