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

import com.bourntec.apmg.entity.LabourCharge;
import com.bourntec.apmg.usermanagement.v1.dto.request.LabourChargeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.LabourChargeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.LabourService;

/**
 * @author naveen Radhakrishnan
 *
 */

@RestController(value = "LabourChargeController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/labourcharge")
public class LabourChargeController {

	@Autowired
	LabourService labourService;

	/**
	 * This API creates new LabourCharge object
	 * 
	 * @param LabourChargeRequestDTO
	 * @return ResponseEntity<LabourChargeResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<LabourChargeResponseDTO> savelabour(
			@RequestBody LabourChargeRequestDTO labourChargeRequestDTO) throws Exception {
		LabourChargeResponseDTO labourChargeResponseDTO = labourService.savelabour(labourChargeRequestDTO);
		return ResponseEntity.ok(labourChargeResponseDTO);
	}

	/**
	 * This API saves an LabourCharge object.
	 * 
	 * @param id
	 * @param LabourChargeRequestDTO
	 * @return ResponseEntity<LabourChargeResponseDTO>
	 * @throws Exception
	 */

	@PutMapping("/{id}")
	public ResponseEntity<LabourChargeResponseDTO> updatelabour(@PathVariable Long id,
			@RequestBody LabourChargeRequestDTO labourChargeRequestDTO) throws Exception {
		LabourChargeResponseDTO labourChargeResponseDTO = labourService.updatelabour(id, labourChargeRequestDTO);
		return ResponseEntity.ok(labourChargeResponseDTO);
	}

	/**
	 * This API LabourCharge fetches LabourCharge details.
	 * 
	 * @param id
	 * @param LabourChargeRequestDTO
	 * @return ResponseEntity<LabourChargeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/{id}")
	public ResponseEntity<LabourChargeResponseDTO> findBylabourid(@PathVariable Long id) throws Exception {
		LabourChargeResponseDTO labourChargeResponseDTO = labourService.findBylabourid(id);
		return ResponseEntity.ok(labourChargeResponseDTO);
	}

	/**
	 * This API LabourCharge findsAll LabourCharge details.
	 * 
	 * @param
	 * @return List<LabourCharge>
	 * @throws Exception
	 */

	@GetMapping("")
	public List<LabourCharge> findAllLabours() throws Exception {
		List<LabourCharge> labourChargeLists = labourService.findAllLabours();
		return labourChargeLists;
	}

	/**
	 * This REST endpoint exposes the search interface for searching customer
	 * dynamically
	 * 
	 * @param CustDataRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 */
	@PostMapping("/search")
	public ResponseEntity<List<LabourCharge>> fetchByLaboure(
			@RequestBody LabourChargeResponseDTO locationCodeRequestDTO) throws Exception {

		List<LabourCharge> countryCodes = labourService.fetchByLabour(locationCodeRequestDTO);

		return ResponseEntity.ok(countryCodes);
	}

}
