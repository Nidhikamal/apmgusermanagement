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


import com.bourntec.apmg.entity.CustDataShippingDetails;

import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataShippingDetailsRequestDTO;

import com.bourntec.apmg.usermanagement.v1.dto.response.CustDataShippinfDetailsResponseDTO;

import com.bourntec.apmg.usermanagement.v1.service.CustDataShippingDetailsService;


@RestController(value = "CustDataShippingDetailsController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/custshippingdetails")
public class CustDataShippingDetailsController {

	@Autowired
	CustDataShippingDetailsService custDataService;

	/**
	 * This REST endpoint exposes the search interface for returning all customer
	 * details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<CustDataShippingDetails>> findAllCustShippingDetails() throws Exception {

		List<CustDataShippingDetails> allCustData = custDataService.findAllCustShippingDetails();
		return ResponseEntity.ok(allCustData);
	}

	/**
	 * This REST endpoint exposes the search interface for returning customer by id
	 * 
	 */

	@GetMapping("/{id}")
	public ResponseEntity<CustDataShippinfDetailsResponseDTO> getCustShippingDetailsById(@PathVariable Long id) throws Exception {

		CustDataShippinfDetailsResponseDTO selectedCustomer = custDataService.getCustShippingDetailsById(id);

		return ResponseEntity.ok(selectedCustomer);
	}

	/**
	 * This REST endpoint exposes the search interface for saving customer
	 * 
	*/

	@PostMapping("")
	public ResponseEntity<CustDataShippinfDetailsResponseDTO> saveCustData(@RequestBody CustDataShippingDetailsRequestDTO custDataReq)
			throws Exception {

		CustDataShippinfDetailsResponseDTO savedrespCust = custDataService.saveCustData(custDataReq);

		return ResponseEntity.ok(savedrespCust);

	}

	/**
	 * This REST endpoint exposes the search interface for updating customer by Id
	 * 
	 */

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCustData(@RequestBody CustDataShippingDetailsRequestDTO custDataReq, @PathVariable Long id)
			throws Exception {

		CustDataShippinfDetailsResponseDTO updatedrespCust = custDataService.updateCustData(id, custDataReq);
		return ResponseEntity.ok(updatedrespCust);
	}

	/**
	 * This REST endpoint exposes the search interface for searching  customer dynamically
	 */
	@PostMapping("/search")
	public ResponseEntity<List<CustDataShippingDetails>> findCustDataByCriteria(@RequestBody CustDataShippingDetailsRequestDTO custDataReq) throws Exception  {

		
		List<CustDataShippingDetails> selectedCustomers = custDataService.findCustDataByCriteria(custDataReq);

		return ResponseEntity.ok(selectedCustomers);
	}
	@DeleteMapping("/{id}")  
	private ResponseEntity<?> deleteCustDataById(@PathVariable("id") Long id)   
	{  
		custDataService.deleteCustDataById(id); 
		return ResponseEntity.ok().build();
	}  
}
