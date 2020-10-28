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

import com.bourntec.apmg.entity.NewArrivals;
import com.bourntec.apmg.usermanagement.v1.dto.request.ArrivalsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ArrivalsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.NewArrivalService;

/**
 * @author Amal Chandra N A
 *
 */
@RestController(value = "NewArrivalController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/newarrivals")
public class NewArrivalController {

	@Autowired
	NewArrivalService arrivalService;


	/**
	 * This REST endpoint exposes the search interface for returning all new
	 * Arrivals
	 * 
	 * @param
	 * @return ResponseEntity<NewArrivals>
	 */

	@GetMapping("")
	public ResponseEntity<List<NewArrivals>> fetchAllnewArrivals() throws Exception {

		List<NewArrivals> allArrivals = arrivalService.findAllNewArrivals();
		return ResponseEntity.ok(allArrivals);
	}

	/**
	 * This REST endpoint exposes the search interface for returning arrivals by id
	 * 
	 * @param Long id
	 * @return ResponseEntity<ArrivalsResponseDTO>
	 */

	@GetMapping("/{id}")
	public ResponseEntity<ArrivalsResponseDTO> fetchById(@PathVariable Long id) throws Exception {

		ArrivalsResponseDTO selectedArrivals = arrivalService.getArrivalsById(id);

		return ResponseEntity.ok(selectedArrivals);
	}

	/**
	 * This REST endpoint exposes the search interface for saving arrivals
	 * 
	 * @param
	 * @return ResponseEntity<ArrivalsResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<ArrivalsResponseDTO> saveNewArrivals(@RequestBody ArrivalsRequestDTO arrivalsreqDTO)
			throws Exception {

		ArrivalsResponseDTO savedrespArrivals = arrivalService.saveArrivals(arrivalsreqDTO);

		return ResponseEntity.ok(savedrespArrivals);

	}

	/**
	 * This REST endpoint exposes the search interface for updating arrivals by Id
	 * 
	 * @param ArrivalsRequestDTO,Long id
	 * @return ResponseEntity<BrandDetails>
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateArrivals(@RequestBody ArrivalsRequestDTO arrivalsreqDTO, @PathVariable Long id)
			throws Exception {

		ArrivalsResponseDTO updatedrespArrivals = arrivalService.updateArrivals(id, arrivalsreqDTO);
		return ResponseEntity.ok(updatedrespArrivals);
	}
	
	/**
	 * This REST endpoint exposes the search interface for searching  company codes dynamically
	 * @param ArrivalsRequestDTO
	 * @return List<NewArrivals>
	 */
	
	@PostMapping("/search")
	public ResponseEntity<List<NewArrivals>> fetchNewArrivalsByCriteria(@RequestBody ArrivalsRequestDTO arrivalsreqDTO) throws Exception  {

		
		List<NewArrivals> selectedArrivals= arrivalService.findArrivalsDataByCriteria(arrivalsreqDTO);

		return ResponseEntity.ok(selectedArrivals);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ArrivalsResponseDTO> deleteNewArrivals(@PathVariable Long id) {
		ArrivalsResponseDTO responseDTO = arrivalService.deleteNewArrivals(id);
		return ResponseEntity.ok(responseDTO);
	}
	

}
