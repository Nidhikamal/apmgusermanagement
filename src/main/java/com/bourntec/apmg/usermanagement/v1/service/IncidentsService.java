package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.Incidents;
import com.bourntec.apmg.usermanagement.v1.dto.request.IncidentsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.IncidentsResponseDTO;

public interface IncidentsService {
	
	
	/**
	 * This method saveIncidentDetails
	 * @param incidentsRequestDTO
	 * @return IncidentsResponseDTO
	 * @throws Exception 
	 */

	IncidentsResponseDTO saveIncidentDetails(IncidentsRequestDTO incidentsRequestDTO)throws Exception;
	
	/**
	 * This method get all incidents object.
	
	 * @return IncidentsResponseDTO
	 * @throws Exception 
	 */
	List<IncidentsResponseDTO> findAllIncidentsDetails()throws Exception;
	/**
	 * This method updateIncidentDetails
	 * @param incidentId
	 * @return IncidentsResponseDTO
	 * @throws Exception 
	 */
	IncidentsResponseDTO findIncidentDetailsById(Long incidentId)throws Exception;
	/**
	 * This method updateIncidentDetails
	 * @param incidentId
	 * @return IncidentsResponseDTO
	 * @throws Exception 
	 */
	IncidentsResponseDTO updateIncidentDetails(Long incidentId, IncidentsRequestDTO incidentsRequestDTO)throws Exception;
	/**
	 * This method updates faq object.
	 * @param id
	 * @return FaqResponseDTO
	 * @throws Exception 
	 */

	List<Incidents> findIncidentsByCriteria(IncidentsRequestDTO incidentsRequestDTO);

}
