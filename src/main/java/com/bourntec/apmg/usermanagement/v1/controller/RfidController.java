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

import com.bourntec.apmg.entity.RfidScanner;
import com.bourntec.apmg.usermanagement.v1.dto.request.RfidRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.RfidScannerResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.RfidService;

/**
 * @author Amal Chandra N A
 *
 */
@RestController(value = "RfidController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/rfidscanner")
public class RfidController {

	@Autowired
	RfidService rfidService;

	

	/**
	 * This REST endpoint exposes the search interface for saving rfid scanner
	 * 
	 * @param RfidRequestDTO
	 * @return ResponseEntity<RfidScannerResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<RfidScannerResponseDTO> saveRfid(@RequestBody RfidRequestDTO rfidcodesreq) throws Exception {

		RfidScannerResponseDTO savedresppacking = rfidService.saveRfidCodes(rfidcodesreq);

		return ResponseEntity.ok(savedresppacking);

	}

	/**
	 * This REST endpoint exposes the search interface for returning rfid by id
	 * 
	 * @param Long id
	 * @return ResponseEntity<RfidScannerResponseDTO>
	 */

	@GetMapping("/{id}")
	public ResponseEntity<RfidScannerResponseDTO> fetchRfidById(@PathVariable Long id) throws Exception {

		RfidScannerResponseDTO selectedrfidcodes = rfidService.getRfidById(id);

		return ResponseEntity.ok(selectedrfidcodes);
	}

	/**
	 * This REST endpoint exposes the search interface for updating rfid scanner by
	 * id
	 * 
	 * @param RfidRequestDTO,Long id
	 * @return ResponseEntity<RfidScannerResponseDTO>
	 */

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateupdateRfid(@RequestBody RfidRequestDTO rfidcodesreq, @PathVariable Long id)
			throws Exception {

		RfidScannerResponseDTO updatedrfidcodes = rfidService.updateRfidCodes(id, rfidcodesreq);
		return ResponseEntity.ok(updatedrfidcodes);
	}

	/**
	 * This REST endpoint exposes the search interface for fetching all rfid scanner
	 * codes
	 * 
	 * @param
	 * @return ResponseEntity<RfidScanner>
	 */
	@GetMapping("")
	public ResponseEntity<List<RfidScanner>> fetchAllsRfidCodes() throws Exception {

		List<RfidScanner> allrfidcodes = rfidService.findAllRfidCodes();
		return ResponseEntity.ok(allrfidcodes);
	}

	/**
	 * This REST endpoint exposes the search interface for searching  company codes dynamically
	 * @param RfidRequestDTO
	 * @return List<RfidScanner>
	 */
	
	@PostMapping("/search")
	public ResponseEntity<List<RfidScanner>> fetchRfidScannerByCriteria(@RequestBody RfidRequestDTO rfidcodesreq) throws Exception  {

		
		List<RfidScanner> selectedRfids= rfidService.findRfidDataByCriteria(rfidcodesreq);

		return ResponseEntity.ok(selectedRfids);
	}
	
}
