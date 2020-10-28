package com.bourntec.apmg.usermanagement.v1.service;



import java.util.List;

import com.bourntec.apmg.entity.Employee;
import com.bourntec.apmg.usermanagement.v1.dto.request.EmployeeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.EmployeeResponseDTO;


public interface EmployeeService {
	
	
	
	/**
	 * The Method creates an Employee object in the DB 
	 * @param id
	 * @return EmployeeResponseDTO
	 */
	EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) throws Exception;

	
	
	/**
	 * Method gets a EmployeeResponse object  from the DB based on id
	 * @param id
	 * @return EmployeeResponseDTO
	 */
	EmployeeResponseDTO findEmployeeByID(String id) throws Exception;

	/**
	 * Method updates a EmployeeResponse object  from the DB based on id ,employeeRequestDTO
	 * @param id
	 * @return EmployeeResponseDTO
	 */

	EmployeeResponseDTO updateUEmployee(String id, EmployeeRequestDTO employeeRequestDTO);
	
	List<Employee>  findByCondition(EmployeeRequestDTO employeeDTO);


	List<Employee> findAllEmployee();


}
