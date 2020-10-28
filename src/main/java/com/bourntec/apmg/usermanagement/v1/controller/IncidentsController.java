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

import com.bourntec.apmg.entity.BrandDetails;
import com.bourntec.apmg.entity.FaqDetails;
import com.bourntec.apmg.entity.Incidents;
import com.bourntec.apmg.usermanagement.v1.dto.request.BrandRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.FaqDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.IncidentsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BrandResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.FaqResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.IncidentsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.BrandService;
import com.bourntec.apmg.usermanagement.v1.service.IncidentsService;


@RestController(value = "IncidentsController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/incidents")
public class IncidentsController {

	@Autowired
	IncidentsService incidentsService;

	/**
	 * This API save incidents
	 * 
	 * @param incidentsRequestDTO
	 * @return ResponseEntity<IncidentsResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<IncidentsResponseDTO> saveIncidentDetails(
			@RequestBody IncidentsRequestDTO incidentsRequestDTO) throws Exception {

		IncidentsResponseDTO incidentsResponseDTO = incidentsService.saveIncidentDetails(incidentsRequestDTO);
		return ResponseEntity.ok(incidentsResponseDTO);
	}

	/**
	 * This API updates Pobject.
	 * 
	 * @param incidentId
	 * @return ResponseEntity<IncidentsResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/{incidentId}")
	public ResponseEntity<IncidentsResponseDTO> updateIncidentDetails(@PathVariable Long incidentId,
			@RequestBody IncidentsRequestDTO incidentsRequestDTO) throws Exception {
		IncidentsResponseDTO incidentsResponseDTO = incidentsService.updateIncidentDetails(incidentId, incidentsRequestDTO);
		return ResponseEntity.ok(incidentsResponseDTO);
	}

	/**
	 * This API get incidents object.
	 * 
	 * @param incidentId
	 * @return ResponseEntity<IncidentsResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("/{incidentId}")
	public ResponseEntity<IncidentsResponseDTO> findIncidentDetailsById(@PathVariable Long incidentId)
			throws Exception {
		IncidentsResponseDTO incidentsResponseDTO = incidentsService.findIncidentDetailsById(incidentId);
		return ResponseEntity.ok(incidentsResponseDTO);
	}

	/**
	 * This API get all incidents object.
	 * 
	 * @return ResponseEntity<IncidentsResponseDTO>
	 * @throws Exception
	 */
	/**
	 * This API get incidents object.
	 * 
	 * @param find all
	 * @return ResponseEntity<IncidentsResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("")
	public ResponseEntity<List<IncidentsResponseDTO>> findAllIncidents() throws Exception {
		List<IncidentsResponseDTO> incidentsResponseDTOs = incidentsService.findAllIncidentsDetails();
		return ResponseEntity.ok(incidentsResponseDTOs);
	}
	

	@PostMapping("/search")
	public ResponseEntity<List<Incidents>> fetchIncidentsByCriteria(@RequestBody IncidentsRequestDTO incidentsRequestDTO) throws Exception  {

		
		List<Incidents> selectedIncidents = incidentsService.findIncidentsByCriteria(incidentsRequestDTO);

		return ResponseEntity.ok(selectedIncidents);
	}
}
