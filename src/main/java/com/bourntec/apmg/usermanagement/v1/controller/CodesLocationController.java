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

import com.bourntec.apmg.entity.CodesLocation;
import com.bourntec.apmg.usermanagement.v1.dto.request.CodesLocationRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CodesLocationResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.CodesLocationService;


/**
 * @author naveen Radhakrishnan
 *
 */

@RestController(value = "CodesLocationController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/codeslocation")
public class CodesLocationController {
	

	@Autowired
	CodesLocationService  locationCodeService;
	/**
	 * This API creates new LocatioCode object
	 * 
	 * @param CodesLocationRequestDTO
	 * @return ResponseEntity<LocationCodeResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("")
	public ResponseEntity<CodesLocationResponseDTO> saveLocationCode(
			@RequestBody CodesLocationRequestDTO locationCodeRequestDTO) throws Exception {
		CodesLocationResponseDTO locationCodeResponseDTO = locationCodeService.saveLocationCode(locationCodeRequestDTO);
		return ResponseEntity.ok(locationCodeResponseDTO);
	}

	/**
	 * This API updates new LocationCode object
	 * 
	 * @param locationCode
	 * @param CodesLocationRequestDTO
	 * @return ResponseEntity<LocationCodeResponseDTO>
	 * @throws Exception
	 */

	@PutMapping("/{locationCode}")
	public ResponseEntity<CodesLocationResponseDTO> updateLocationcode(@PathVariable String locationCode,
			@RequestBody CodesLocationRequestDTO locationCodeRequestDTO) throws Exception {
		CodesLocationResponseDTO locationCodeResponseDTO = locationCodeService.updateLocationCode(locationCode,
				locationCodeRequestDTO);
		return ResponseEntity.ok(locationCodeResponseDTO);
	}

	/**
	 * This API fetch LocationCode
	 * 
	 * @param locationCode
	 * @return ResponseEntity<LocationCodeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/{locationCode}")
	public ResponseEntity<CodesLocationResponseDTO> findBylocationCode(@PathVariable String locationCode)
			throws Exception {
		CodesLocationResponseDTO locationCodeResponseDTO = locationCodeService.findBylocationCode(locationCode);
		return ResponseEntity.ok(locationCodeResponseDTO);
	}

	/**
	 * This API fetchAll new LocationCode Details
	 * 
	 * @param
	 * @return List<LocationCode>
	 * @throws Exception
	 */

	@GetMapping("")
	public List<CodesLocation> findAllLocationcode() throws Exception {
		List<CodesLocation> locationCodeLists = locationCodeService.findAllLocationcode();
		return locationCodeLists;
	}
	
	/**
	 * This REST endpoint exposes the search interface for searching  customer dynamically
	 * @param CustDataRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 */
	@PostMapping("/search")
	public ResponseEntity<List<CodesLocation>>
	fetchByLocationCode(@RequestBody CodesLocationRequestDTO locationCodeRequestDTO) throws Exception  {

		
		List<CodesLocation> countryCodes = locationCodeService.fetchByLocationCode(locationCodeRequestDTO);

		return ResponseEntity.ok(countryCodes);
	}

	


}
