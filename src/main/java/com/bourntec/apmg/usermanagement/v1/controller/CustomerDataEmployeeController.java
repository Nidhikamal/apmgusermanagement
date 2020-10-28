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

import com.bourntec.apmg.entity.CustDataEmployee;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataEmployeeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustDataEmployeeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.CustomerDataEmployeeService;

@RestController(value = "CustDataEmployeeController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/custdataemployee")
public class CustomerDataEmployeeController {

	@Autowired
	CustomerDataEmployeeService custDataEmployeeService;

	/**
	 * This API saves Customer Data Employees
	 * 
	 * @param custDataEmpRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<CustDataEmployeeResponseDTO> saveCustDataEmployee(
			@RequestBody CustDataEmployeeRequestDTO custDataEmpRequestDTO) throws Exception {
		CustDataEmployeeResponseDTO CustDataEmpResponsetDTO = custDataEmployeeService
				.saveCustDataEmployee(custDataEmpRequestDTO);
		return ResponseEntity.ok(CustDataEmpResponsetDTO);
	}

	/**
	 * This API updates Customer Data Employees
	 * 
	 * @param custDataEmpNo
	 * @param custDataEmpRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{custDataEmpNo}")
	public ResponseEntity<CustDataEmployeeResponseDTO> updateCustDataEmployee(@PathVariable String custDataEmpNo,
			@RequestBody CustDataEmployeeRequestDTO custDataEmpRequestDTO) throws Exception {
		CustDataEmployeeResponseDTO CustDataEmpResponsetDTO = custDataEmployeeService
				.updateCustDataEmployee(custDataEmpNo, custDataEmpRequestDTO);
		return ResponseEntity.ok(CustDataEmpResponsetDTO);
	}

	/**
	 * This API fetches Customer Employees according to {custDataEmpNo}
	 * 
	 * @param custDataEmpNo
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{custDataEmpNo}")
	public ResponseEntity<CustDataEmployeeResponseDTO> findByCustDataEmpNo(@PathVariable String custDataEmpNo)
			throws Exception {
		CustDataEmployeeResponseDTO CustDataEmpResponsetDTO = custDataEmployeeService
				.findByCustDataEmpNo(custDataEmpNo);
		return ResponseEntity.ok(CustDataEmpResponsetDTO);
	}

	/**
	 * This API fetches all Customer Data Employees.
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("")
	public ResponseEntity<List<CustDataEmployee>> findAllCustomerDataEmployees() throws Exception {
		List<CustDataEmployee> custDataEmpList = custDataEmployeeService.findAllCustomerDataEmployees();
		return ResponseEntity.ok(custDataEmpList);
	}

	/**
	 * REST endpoint exposes the search interface for searching customer employee
	 * dynamically
	 * 
	 * @param custDataEmpRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<CustDataEmployee>> fetchByCustDataEmployee(
			@RequestBody CustDataEmployeeRequestDTO custDataEmpRequestDTO) throws Exception {

		List<CustDataEmployee> custDataEmpList = custDataEmployeeService.fetchByCustDataEmployee(custDataEmpRequestDTO);

		return ResponseEntity.ok(custDataEmpList);
	}

	/**
	 * This API delete a Customer Employee
	 * 
	 * @param custDataEmpNo
	 * @return
	 */
	@DeleteMapping("/{custDataEmpNo}")
	public ResponseEntity<?> deleteCustDataEmployee(@PathVariable String custDataEmpNo) {
		custDataEmployeeService.deleteCustDataEmployee(custDataEmpNo);
		return ResponseEntity.ok().build();
	}
}
