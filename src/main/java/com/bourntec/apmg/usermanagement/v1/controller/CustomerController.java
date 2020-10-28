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

import com.bourntec.apmg.entity.CustData;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustDataResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.CustomerService;


/**
 * @author Vidya P
 *
 */
@RestController(value = "CustomerController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v3")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	/**
	 * This API creates Customer 
	 * @param custDataRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 * @throws Exception 
	 */
	@PostMapping("/customer")
	public ResponseEntity<CustDataResponseDTO> saveCustomer(@RequestBody CustDataRequestDTO custDataRequestDTO) throws Exception{
		CustDataResponseDTO custDataResponseDTO = customerService.saveCustomer(custDataRequestDTO);
		return ResponseEntity.ok(custDataResponseDTO);
	}
	
	/**
	 * This API get customerByID  
	 * @param custDataRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 * @throws Exception 
	 */
	@GetMapping("/customer/{id}")
	public ResponseEntity<CustDataResponseDTO> findCustomerById(@PathVariable String id) throws Exception {
		CustDataResponseDTO custDataResponseDTO = customerService.findCustomerById(id);
		return ResponseEntity.ok(custDataResponseDTO);
	}
	
	/**
	 * This REST endpoint exposes the search interface for updating  customer by Id
	 * @param 
	 * @return ResponseEntity<CustDataResponseDTO>
	 */

	@PutMapping("/customer/{custNo}")
	public ResponseEntity<Object> updateCustomer(@RequestBody CustDataRequestDTO customerReqDTO, @PathVariable String custNo) throws Exception {

		CustDataResponseDTO updatedReqDTO = customerService.updateCustomerData(custNo, customerReqDTO);
		return ResponseEntity.ok(updatedReqDTO);
	}
	
	/**
	 * This REST endpoint exposes the search interface for searching  customer dynamically
	 * @param CustDataRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 */
	@PostMapping("/customer/search")
	public ResponseEntity<List<CustData>> fetchByCustomerCtriteria(@RequestBody CustDataRequestDTO customerReqDTO) throws Exception  {

		
		List<CustData> selectedCustomers = customerService.findCustomersByCriteria(customerReqDTO);

		return ResponseEntity.ok(selectedCustomers);
	}

	/**
	 * This REST endpoint exposes the search interface for returning  all customers
	 * @param 
	 * @return ResponseEntity<CustDataResponseDTO>
	 */
	@GetMapping("/customer")
	public ResponseEntity<List<CustData>> fetchAllCustomers() throws Exception {

		List<CustData> allCustomers = customerService.findAllCustomers();
		return ResponseEntity.ok(allCustomers);
	}

	
	
}
