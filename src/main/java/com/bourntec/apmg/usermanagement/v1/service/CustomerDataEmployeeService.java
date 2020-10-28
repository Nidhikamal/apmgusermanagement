package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CustDataEmployee;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataEmployeeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustDataEmployeeResponseDTO;

public interface CustomerDataEmployeeService {

	CustDataEmployeeResponseDTO saveCustDataEmployee(CustDataEmployeeRequestDTO custDataEmpRequestDTO);

	CustDataEmployeeResponseDTO updateCustDataEmployee(String custDataEmpNo,
			CustDataEmployeeRequestDTO custDataEmpRequestDTO);

	CustDataEmployeeResponseDTO findByCustDataEmpNo(String custDataEmpNo);

	List<CustDataEmployee> findAllCustomerDataEmployees();

	List<CustDataEmployee> fetchByCustDataEmployee(CustDataEmployeeRequestDTO custDataEmpRequestDTO);

	void deleteCustDataEmployee(String custDataEmpNo);
}
