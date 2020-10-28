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

import com.bourntec.apmg.entity.CustData2;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustData2RequestDTO;

import com.bourntec.apmg.usermanagement.v1.dto.response.CustData2ResponseDTO;

import com.bourntec.apmg.usermanagement.v1.service.CustData2Service;

@RestController(value = "CustData2Controller")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/custdata2")
public class CustData2Controller {

	@Autowired
	CustData2Service custDataService;

	/**
	 * This REST endpoint exposes the search interface for returning all customer
	 * details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<CustData2>> fetchAllCustData() throws Exception {

		List<CustData2> allCust = custDataService.findAllCustData();
		return ResponseEntity.ok(allCust);
	}

	/**
	 * This REST endpoint exposes the search interface for returning customer by id
	 * 
	 */

	@GetMapping("/{custNo}")
	public ResponseEntity<CustData2ResponseDTO> getCustDataById(@PathVariable String custNo) throws Exception {

		CustData2ResponseDTO selectedCustomer = custDataService.getCustDataById(custNo);

		return ResponseEntity.ok(selectedCustomer);
	}

	/**
	 * This REST endpoint exposes the search interface for saving customer
	 * 
	 */

	@PostMapping("")
	public ResponseEntity<CustData2ResponseDTO> saveCustData(@RequestBody CustData2RequestDTO custDataReq)
			throws Exception {

		CustData2ResponseDTO savedrespCust = custDataService.saveCustData(custDataReq);

		return ResponseEntity.ok(savedrespCust);

	}

	/**
	 * This REST endpoint exposes the search interface for updating customer by Id
	 * 
	 */

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCustData(@RequestBody CustData2RequestDTO custDataReq, @PathVariable String id)
			throws Exception {

		CustData2ResponseDTO updatedrespCust = custDataService.updateCustData(id, custDataReq);
		return ResponseEntity.ok(updatedrespCust);
	}

	/**
	 * This REST endpoint exposes the search interface for searching customer
	 * dynamically
	 */
	@PostMapping("/search")
	public ResponseEntity<List<CustData2>> findCustDataByCriteria(@RequestBody CustData2RequestDTO custDataReq)
			throws Exception {

		List<CustData2> selectedCustomers = custDataService.findCustDataByCriteria(custDataReq);

		return ResponseEntity.ok(selectedCustomers);
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<?> deleteCustDataById(@PathVariable("id") String id) {
		custDataService.deleteCustDataById(id);
		return ResponseEntity.ok().build();
	}

}
