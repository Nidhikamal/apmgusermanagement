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

import com.bourntec.apmg.entity.PotentialGroup;
import com.bourntec.apmg.usermanagement.v1.dto.request.PotentialCustomerGroupRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PotentialCustomerGroupResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.PotentialDetailsCustomerService;


/**
 * @author naveen Radhakrishnan
 *
 */

@RestController(value = "PotentialDetailsCustomerController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/potentialcustomer")
public class PotentialDetailsCustomerController {


	@Autowired
	PotentialDetailsCustomerService potentialDetailsCustomerService;
	/**
	 * This API creates new PotentialCustomer object
	 * 
	 * @param PotentialCustomerGroupRequestDTO
	 * @return ResponseEntity<PotentialCustomerGroupResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("")
	public ResponseEntity<PotentialCustomerGroupResponseDTO> potentialcustomersave(
			@RequestBody PotentialCustomerGroupRequestDTO potentialCustomerGroupRequestDTO) throws Exception {
		PotentialCustomerGroupResponseDTO potentialCustomerGroupResponseDTO = potentialDetailsCustomerService
				.potentialcustomersave(potentialCustomerGroupRequestDTO);
		return ResponseEntity.ok(potentialCustomerGroupResponseDTO);
	}

	/**
	 * This API updates PotentialCustomer details
	 * 
	 * @param id
	 * @param PotentialCustomerGroupRequestDTO
	 * @return ResponseEntity<PotentialCustomerGroupResponseDTO>
	 * @throws Exception
	 */

	@PutMapping("/{id}")
	public ResponseEntity<PotentialCustomerGroupResponseDTO> potentialcustomersave(@PathVariable Long id,
			@RequestBody PotentialCustomerGroupRequestDTO potentialCustomerGroupRequestDTO) throws Exception {
		PotentialCustomerGroupResponseDTO potentialCustomerGroupResponseDTO = potentialDetailsCustomerService.updatePotentialcustomer(id,
				potentialCustomerGroupRequestDTO);
		return ResponseEntity.ok(potentialCustomerGroupResponseDTO);
	}

	/**
	 * This API fetches PotentialCustomer details
	 * 
	 * @param id
	 * @return ResponseEntity<PotentialCustomerGroupResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<PotentialCustomerGroupResponseDTO> findBypotentialcustomerid(@PathVariable Long id)
			throws Exception {
		PotentialCustomerGroupResponseDTO potentialCustomerGroupResponseDTO = potentialDetailsCustomerService
				.findBypotentialcustomerid(id);
		return ResponseEntity.ok(potentialCustomerGroupResponseDTO);
	}

	/**
	 * This API fetches all PotentialCustomer details.
	 * 
	 * @return List<PotentialCustomerGroup>
	 * @throws Exception
	 */

	@GetMapping("")
	public List<PotentialGroup> findAllPotentialCustomer() throws Exception {
		List<PotentialGroup> potentialCustomerGroupList = potentialDetailsCustomerService.findAllPotentialCustomer();
		return potentialCustomerGroupList;
	}
	
	
	
	
	

	/**
	 * This REST endpoint exposes the search interface for searching  customer dynamically
	 * @param CustDataRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 */
	@PostMapping("/search")
	public ResponseEntity<List<PotentialGroup>>
	fetchBypotentialCustomer(@RequestBody PotentialCustomerGroupResponseDTO brandsreqDTO) throws Exception  {

		
		List<PotentialGroup> countryCodes = potentialDetailsCustomerService.fetchBypotentialCustomer(brandsreqDTO);

		return ResponseEntity.ok(countryCodes);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
