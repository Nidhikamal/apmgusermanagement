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

import com.bourntec.apmg.entity.LocationEmployee;
import com.bourntec.apmg.usermanagement.v1.dto.request.LocationEmployeeDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.LocationEmployeeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.LocationEmployeeService;

/**
 * @author Naveen  N A
 *
 */
@RestController(value = "LocationEmployeeController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/LocationEmployee")
public class LocationEmployeeController {
	
	
	

	@Autowired
	LocationEmployeeService locationEmployeeService;

	
	/**
	 * This REST endpoint exposes the search interface for saving sLocation Employee
	 * 
	 * @param
	 * @return ResponseEntity<LocationEmployeeResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<LocationEmployeeResponseDTO> saveLocationEmployee(
			@RequestBody LocationEmployeeDTO locationEmployeereq) throws Exception {

		LocationEmployeeResponseDTO savedresppacking = locationEmployeeService.saveLocationEmployee(locationEmployeereq);

		return ResponseEntity.ok(savedresppacking);

	}

	/**
	 * This REST endpoint exposes the search interface for returning sLocation Employee
	 * by id
	 * 
	 * @param String id
	 * @return ResponseEntity<LocationEmployeeResponseDTO>
	 */

	@GetMapping("/{id}")
	public ResponseEntity<LocationEmployeeResponseDTO> fetchLocationEmployeeById(@PathVariable Long id) throws Exception {

		LocationEmployeeResponseDTO selectedpackingcodes = locationEmployeeService.getLocationEmployeeById(id);

		return ResponseEntity.ok(selectedpackingcodes);
	}

	/**
	 * This REST endpoint exposes the search interface for update sLocation Employee by
	 * id
	 * 
	 * @param LocationEmployeeDTO,String id
	 * @return ResponseEntity<LocationEmployeeResponseDTO>
	 */

	@PutMapping("/{id}")
	public ResponseEntity<LocationEmployeeResponseDTO> updateLocationEmployee(@RequestBody LocationEmployeeDTO LocationEmployeereq,
			@PathVariable Long id) throws Exception {

		LocationEmployeeResponseDTO updatedLocationEmployee = locationEmployeeService.updateLocationEmployee(id, LocationEmployeereq);
		return ResponseEntity.ok(updatedLocationEmployee);
	}

	/**
	 * This REST endpoint exposes the search interface for returning all shipping
	 * codes
	 * 
	 * @param
	 * @return ResponseEntity<LocationEmployeeResponseDTO>
	 */

	@GetMapping("")
	public ResponseEntity<List<LocationEmployee>> fetchAllLocationEmployee() throws Exception {

		List<LocationEmployee> allLocationEmployee = locationEmployeeService.findAllLocationEmployee();
		return ResponseEntity.ok(allLocationEmployee);
	}
	
	/**
	 * This REST endpoint exposes the search interface for searching  company codes dynamically
	 * @param LocationEmployeeDTO
	 * @return List<LocationEmployee>
	 */
	
	@PostMapping("/search")
	public ResponseEntity<List<LocationEmployee>> fetchByCreditCriteria(@RequestBody LocationEmployeeDTO locationEmployeereq) throws Exception  {

		
		List<LocationEmployee> selectedLocationEmployee= locationEmployeeService.findLocationEmployeeByCriteria(locationEmployeereq);

		return ResponseEntity.ok(selectedLocationEmployee);
	}

	
	
	@DeleteMapping("/{id}")
	private ResponseEntity<LocationEmployeeResponseDTO> deleteLocationEmployeeById(@PathVariable("id") Long id) {
		LocationEmployeeResponseDTO locationEmployeeResponseDTO = locationEmployeeService.deleteLocationEmployeeById(id);
		return ResponseEntity.ok(locationEmployeeResponseDTO);
	}
}
