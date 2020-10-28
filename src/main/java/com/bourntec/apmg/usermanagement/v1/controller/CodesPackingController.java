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

import com.bourntec.apmg.entity.CodesPacking;
import com.bourntec.apmg.usermanagement.v1.dto.request.CodesPackingRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CodesPackingResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.CodesPackingService;

/**
 * @author Amal Chandra N A
 *
 */
@RestController(value = "CodesPackingController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/codespacking")
public class CodesPackingController {

	@Autowired
	CodesPackingService packingService;


	/**
	 * This REST endpoint exposes the search interface for returning packing codes
	 * by id
	 * 
	 * @param String id
	 * @return ResponseEntity<CodesPackingResponseDTO>
	 */

	@GetMapping("/{id}")
	public ResponseEntity<CodesPackingResponseDTO> fetchById(@PathVariable String id) throws Exception {

		CodesPackingResponseDTO selectedpackingcodes = packingService.getPackingCodesById(id);

		return ResponseEntity.ok(selectedpackingcodes);
	}

	/**
	 * This REST endpoint exposes the search interface for saving packing codes
	 * 
	 * @param CodesPackingRequestDTO
	 * @return ResponseEntity<CodesPackingResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<CodesPackingResponseDTO> savePackingCodes(@RequestBody CodesPackingRequestDTO packingcodesreq)
			throws Exception {

		CodesPackingResponseDTO savedresppacking = packingService.savePackingCodes(packingcodesreq);

		return ResponseEntity.ok(savedresppacking);

	}

	/**
	 * This REST endpoint exposes the search interface for updating packing codes by
	 * Id
	 * 
	 * @param CodesPackingRequestDTO,String id
	 * @return ResponseEntity<CodesPackingResponseDTO>
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCodespacking(@RequestBody CodesPackingRequestDTO packingcodesreq,
			@PathVariable String id) throws Exception {

		CodesPackingResponseDTO updatedrespcodespack = packingService.updatePackingCodes(id, packingcodesreq);
		return ResponseEntity.ok(updatedrespcodespack);
	}

	@GetMapping("")
	public ResponseEntity<List<CodesPacking>> fetchAllpackingCodes() throws Exception {

		List<CodesPacking> allpackingCodes = packingService.findAllPackingCodes();
		return ResponseEntity.ok(allpackingCodes);
	}
	/**
	 * This REST endpoint exposes the search interface for searching  packing codes dynamically
	 * @param CodesPackingRequestDTO
	 * @return ResponseEntity<CodesPackingResponseDTO>
	 */
	
	@PostMapping("/search")
	public ResponseEntity<List<CodesPacking>> fetchByPackingCriteria(@RequestBody CodesPackingRequestDTO packingcodesreq) throws Exception  {

		
		List<CodesPacking> selectedPacking= packingService.findPackingCodesByCriteria(packingcodesreq);

		return ResponseEntity.ok(selectedPacking);
	}

}
