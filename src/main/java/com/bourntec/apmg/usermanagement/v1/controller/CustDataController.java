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

import com.bourntec.apmg.entity.CustData;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustDataResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.CustDataService;


@RestController(value = "CustDataController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/custdata")
public class CustDataController {

	@Autowired
	CustDataService custDataService;

	/**
	 * This REST endpoint exposes the search interface for returning all customer
	 * details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<CustData>> fetchAllCustData() throws Exception {

		List<CustData> allCust = custDataService.findAllCustData();
		return ResponseEntity.ok(allCust);
	}

	/**
	 * This REST endpoint exposes the search interface for returning customer by id
	 * 
	 */

	@GetMapping("/{custNo}")
	public ResponseEntity<CustDataResponseDTO> getCustDataById(@PathVariable String custNo) throws Exception {

		CustDataResponseDTO selectedCustomer = custDataService.getCustDataById(custNo);

		return ResponseEntity.ok(selectedCustomer);
	}

	/**
	 * This REST endpoint exposes the search interface for saving customer
	 * 
	*/

	@PostMapping("")
	public ResponseEntity<CustDataResponseDTO> saveCustData(@RequestBody CustDataRequestDTO custDataReq)
			throws Exception {

		CustDataResponseDTO savedrespCust = custDataService.saveCustData(custDataReq);

		return ResponseEntity.ok(savedrespCust);

	}

	/**
	 * This REST endpoint exposes the search interface for updating customer by Id
	 * 
	 */

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCustData(@RequestBody CustDataRequestDTO custDataReq, @PathVariable String id)
			throws Exception {

		CustDataResponseDTO updatedrespCust = custDataService.updateCustData(id, custDataReq);
		return ResponseEntity.ok(updatedrespCust);
	}

	/**
	 * This REST endpoint exposes the search interface for searching  customer dynamically
	 */
	@PostMapping("/search")
	public ResponseEntity<List<CustData>> findCustDataByCriteria(@RequestBody CustDataRequestDTO custDataReq) throws Exception  {

		
		List<CustData> selectedCustomers = custDataService.findCustDataByCriteria(custDataReq);

		return ResponseEntity.ok(selectedCustomers);
	}
	@DeleteMapping("/{id}")  
	private ResponseEntity<?> deleteCustDataById(@PathVariable("id") String id)   
	{  
		custDataService.deleteCustDataById(id); 
		return ResponseEntity.ok().build();
	}  
}
