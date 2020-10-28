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

import com.bourntec.apmg.entity.Employee;
import com.bourntec.apmg.usermanagement.v1.dto.request.EmployeeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.EmployeeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.EmployeeService;

/**
 * @author Naveen Radhhhhakrishnan
 *
 */
@RestController(value = "EmployeeController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	/**
	 * This API creates new employee object
	 * 
	 * @param EmployeeRequestDTO
	 * @return ResponseEntity<EmployeeResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("")
	public ResponseEntity<EmployeeResponseDTO> createUser(@RequestBody EmployeeRequestDTO employeeRequestDTO)
			throws Exception {
		EmployeeResponseDTO employeeResponseDTO = employeeService.createEmployee(employeeRequestDTO);
		return ResponseEntity.ok(employeeResponseDTO);
	}

	/**
	 * This API finds employee details
	 * 
	 * @param id
	 * @return ResponseEntity<EmployeeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> findId(@PathVariable String id) throws Exception {
		EmployeeResponseDTO employeeResponseDTO = employeeService.findEmployeeByID(id);
		return ResponseEntity.ok(employeeResponseDTO);
	}

	/**
	 * This API updates an employee object.
	 * 
	 * @param userId
	 * @param EmployeeRequestDTO
	 * @return ResponseEntity<EmployeeResponseDTO>
	 * @throws Exception
	 */

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> updateUser(@PathVariable String id,
			@RequestBody EmployeeRequestDTO employeeRequestDTO) throws Exception {
		EmployeeResponseDTO employeeResponseDTO = employeeService.updateUEmployee(id, employeeRequestDTO);
		return ResponseEntity.ok(employeeResponseDTO);
	}

	/**
	 * This API search employee details
	 * 
	 * @param EmployeeRequestDTO
	 * @return ResponseEntity<EmployeeResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("/search")
	public List<Employee> findByCondition(@RequestBody EmployeeRequestDTO employeeDTO) throws Exception {
		List<Employee> employeeResponseDTO = employeeService.findByCondition(employeeDTO);
		return employeeResponseDTO;
	}
	@GetMapping("")
	public List<Employee> findAllEmployee() throws Exception {
		List<Employee> empList = employeeService.findAllEmployee();
		return empList;
	}
}
