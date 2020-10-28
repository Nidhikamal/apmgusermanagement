package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.LocationEmployee;
import com.bourntec.apmg.usermanagement.v1.dto.request.LocationEmployeeDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.LocationEmployeeResponseDTO;

public interface LocationEmployeeService {

	List<LocationEmployee> findLocationEmployeeByCriteria(LocationEmployeeDTO locationEmployeereq);

	List<LocationEmployee> findAllLocationEmployee();

	LocationEmployeeResponseDTO saveLocationEmployee(LocationEmployeeDTO locationEmployeereq);

	LocationEmployeeResponseDTO getLocationEmployeeById(Long id);

	LocationEmployeeResponseDTO updateLocationEmployee(Long id, LocationEmployeeDTO locationEmployeereq);
	
	LocationEmployeeResponseDTO deleteLocationEmployeeById(Long id);

}
