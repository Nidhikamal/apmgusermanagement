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

import com.bourntec.apmg.entity.StateCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.StateCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.StateCodesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.UserLocationsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.StateCodesService;

/**
 * @author naveen Radhakrishnan
 *
 */

@RestController(value = "StateCodesController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/statecode")
public class StateCodesController {

	@Autowired
	StateCodesService stateService;

	/**
	 * This API creates new customer state object
	 * 
	 * @param CountryCodesRequestDTO
	 * @return ResponseEntity<CountrycodeResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("")
	public ResponseEntity<StateCodesResponseDTO> savecustomerstate(@RequestBody StateCodesRequestDTO stateRequestDTO)
			throws Exception {
		StateCodesResponseDTO stateRespOnseDTO = stateService.savecustomerstate(stateRequestDTO);
		return ResponseEntity.ok(stateRespOnseDTO);
	}

	/**
	 * This API updates an customercountry object.
	 * 
	 * @param countryCode
	 * @param CountryCodesRequestDTO
	 * @return ResponseEntity<CountrycodeResponseDTO>
	 * @throws Exception
	 */

	@PutMapping("/{stateCode}")
	public ResponseEntity<StateCodesResponseDTO> updatecustomerstate(@PathVariable String stateCode,
			@RequestBody StateCodesRequestDTO stateRequestDTO) throws Exception {
		StateCodesResponseDTO stateRespOnseDTO = stateService.updatecustomerstate(stateCode, stateRequestDTO);
		return ResponseEntity.ok(stateRespOnseDTO);
	}

	/**
	 * This API fetch an customercountry object.
	 * 
	 * @param userId
	 * @return ResponseEntity<CountrycodeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/{stateCode}")
	public ResponseEntity<StateCodesResponseDTO> findBystateCode(@PathVariable String stateCode) throws Exception {
		StateCodesResponseDTO stateRespOnseDTO = stateService.findBystateCode(stateCode);
		return ResponseEntity.ok(stateRespOnseDTO);
	}

	/**
	 * This API fetch all fetchAllCountryCode.
	 * 
	 * @return List<CountryCodes>
	 * @throws Exception
	 */

	@GetMapping("")
	public List<StateCodes> fetchAllstatcodeCode() throws Exception {
		List<StateCodes> countrycodeResponseList = stateService.fetchAllstatcodeCode();
		return countrycodeResponseList;
	}

	/**
	 * This REST endpoint exposes the search interface for searching customer
	 * dynamically
	 * 
	 * @param CustDataRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 */
	@PostMapping("/search")
	public ResponseEntity<List<StateCodes>> fetchByCustomerstate(@RequestBody StateCodesRequestDTO stateRequestDTO)
			throws Exception {

		List<StateCodes> stateCodes = stateService.fetchByCustomerstate(stateRequestDTO);

		return ResponseEntity.ok(stateCodes);
	}

	/**
	 * End point for delete state code *
	 * 
	 * @param id
	 * @return ResponseEntity<StateCodes>
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<StateCodesResponseDTO> deleteStateCode(@PathVariable String id) throws Exception {
		StateCodesResponseDTO response = stateService.deleteStateCode(id);
		return ResponseEntity.ok(response);
	}

}
