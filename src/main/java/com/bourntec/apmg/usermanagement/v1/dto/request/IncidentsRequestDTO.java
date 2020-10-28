package com.bourntec.apmg.usermanagement.v1.dto.request;

import java.util.Date;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.Incidents;

import lombok.Getter;
import lombok.Setter;


/**
 * 
 * Class is used as a data transfer object for Table MerchandiseCategory
 * 
 * @author vidya.p 
 *
 */

@Getter
@Setter
@Validated
public class IncidentsRequestDTO {
	private Long incidentId;
	private String subject;
	private String description;
	private Date reportedDate;
	private String reportedBy;
	private String assignedTo;
	private String assignedId;
	private String createdBy;
	private Date endDate;
	
	

	public Incidents toModel(IncidentsRequestDTO incidentsRequestDTO) {
		Incidents incidents = new Incidents();
		if(incidentsRequestDTO.getAssignedId() != null && !incidentsRequestDTO.getAssignedId().isEmpty()) {
			incidents.setAssignedId(incidentsRequestDTO.getAssignedId());
		}
		if(incidentsRequestDTO.getAssignedTo() != null && !incidentsRequestDTO.getAssignedTo().isEmpty()) {
			incidents.setAssignedTo(incidentsRequestDTO.getAssignedTo());
		}
		if(incidentsRequestDTO.getCreatedBy() != null && !incidentsRequestDTO.getCreatedBy().isEmpty()) {
			incidents.setCreatedBy(incidentsRequestDTO.getCreatedBy());
		}
		if(incidentsRequestDTO.getDescription() != null && !incidentsRequestDTO.getDescription().isEmpty()) {
			incidents.setDescription(incidentsRequestDTO.getDescription());
		}
		if(incidentsRequestDTO.getIncidentId() != null && incidentsRequestDTO.getIncidentId() > 0) {
			incidents.setIncidentId(incidentsRequestDTO.getIncidentId());
		}
		if(incidentsRequestDTO.getReportedBy() != null && !incidentsRequestDTO.getAssignedId().isEmpty()) {
			incidents.setReportedBy(incidentsRequestDTO.getReportedBy());
		}
		if(incidentsRequestDTO.getReportedDate() != null ) {
			incidents.setReportedDate(incidentsRequestDTO.getReportedDate());
		}
		if(incidentsRequestDTO.getSubject() != null && !incidentsRequestDTO.getSubject().isEmpty()) {
			incidents.setSubject(incidentsRequestDTO.getSubject());
		}
		return incidents;
	}



}
