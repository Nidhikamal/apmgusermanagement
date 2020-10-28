package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.Incidents;
import com.bourntec.apmg.usermanagement.v1.dto.request.IncidentsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.IncidentsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.IncidentsRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.IncidentsService;


@Service(value = "IncidentsServiceImpl")
public class IncidentsServiceImpl implements IncidentsService {

	private static final Logger logger = LogManager.getLogger(BrandServiceImpl.class);

	@Autowired
	private IncidentsRepository incidentsRepository;

	/**
	 * This method saveIncidentDetails
	 * 
	 * @param incidentsRequestDTO
	 * @return IncidentsResponseDTO
	 * @throws Exception
	 */

	public IncidentsResponseDTO saveIncidentDetails(IncidentsRequestDTO incidentsRequestDTO) throws Exception {
		logger.info("IncidentDetail is going to save");
		IncidentsResponseDTO incidentsResponseDTO = new IncidentsResponseDTO();
		try {
			Incidents incidents = incidentsRequestDTO.toModel(incidentsRequestDTO);
			if (incidents != null) {
				Incidents incidentObj = incidentsRepository.save(incidents);
				logger.info("IncidentDetails saved");
				BeanUtils.copyProperties(incidentObj, incidentsResponseDTO);
			} else {
				logger.error("saveIncidentDetails error");
				incidentsResponseDTO.setResponseMessage("saveIncidentDetails error");
			}

			return incidentsResponseDTO;
		} catch (Exception e) {
			logger.error(" Error in saveIncidentDetails" + e);
			throw e;
		}

	}

	/**
	 * This method updateIncidentDetails
	 * 
	 * @param incidentId
	 * @return IncidentsResponseDTO
	 * @throws Exception
	 */
	public IncidentsResponseDTO updateIncidentDetails(Long incidentId, IncidentsRequestDTO incidentsRequestDTO)
			throws Exception {
		IncidentsResponseDTO incidentsResponseDTO = new IncidentsResponseDTO();
		try {

			logger.info("Going Update IncidentDetails ");
			Incidents incidents = incidentsRequestDTO.toModel(incidentsRequestDTO);
			incidents.setIncidentId(incidentId);

			Incidents incidentsObj = incidentsRepository.save(incidents);
			if (incidentsObj != null) {
				logger.info("IncidentDetails is updated");
				BeanUtils.copyProperties(incidentsObj, incidentsResponseDTO);
				incidentsResponseDTO.setResponseMessage("IncidentDetails updated successfully");
			} else {
				logger.error("IncidentDetails updated error");
				incidentsResponseDTO.setResponseMessage("Update IncidentDetails error");
			}
			return incidentsResponseDTO;
		} catch (Exception e) {
			logger.error(" Error in updateIncidentDetails" + e);
			throw e;
		}

	}

	/**
	 * This method findAllIncidentsDetails
	 * 
	 * @return IncidentsResponseDTO list
	 * @throws Exception
	 */

	public List<IncidentsResponseDTO> findAllIncidentsDetails() throws Exception {
		List<IncidentsResponseDTO> incidentsResponseDTOs = new ArrayList<IncidentsResponseDTO>();
		try {
			logger.info("Going to find all incidents ");
			List<Incidents> incidentsList = incidentsRepository.findAll();
			if (incidentsList != null && incidentsList.size() > 0) {
				incidentsList.forEach((incidents) -> {
					IncidentsResponseDTO incidentsResponseDTO = new IncidentsResponseDTO();
					BeanUtils.copyProperties(incidents, incidentsResponseDTO);
					incidentsResponseDTOs.add(incidentsResponseDTO);

				});
				logger.info("Retrieve All incidents ");

			} else {
				throw new ResourceNotFoundException(ErrorCodes.INCIDENT_NOT_FOUND.getMessage());
			}
			return incidentsResponseDTOs;
		} catch (Exception e) {
			logger.error(" Error in findAllIncidentsDetails" + e);
			throw e;
		}

	}

	/**
	 * This method get incidents object.
	 * 
	 * @param incidentId
	 * @return IncidentsResponseDTO
	 * @throws Exception
	 */
	public IncidentsResponseDTO findIncidentDetailsById(Long id) throws Exception {
		IncidentsResponseDTO incidentsResponseDTO = new IncidentsResponseDTO();
		logger.info("Going to find incidents detailsById");
		try {
			Optional<Incidents> incidents = incidentsRepository.findById(id);
			if (incidents != null) {
				BeanUtils.copyProperties(incidents.get(), incidentsResponseDTO);
				logger.info("Retrieve incidents detailsById");
				return incidentsResponseDTO;
			} else {
				throw new ResourceNotFoundException(ErrorCodes.INCIDENT_NOT_FOUND.getMessage());
			}
		} catch (Exception e) {
			logger.error(" Error in findIncidentDetailsById" + e);
			throw e;
		}

	}
	
	/**
	 * This method Searches Incidents by criteria
	 * @author Amal
	 * @return List<Incidents>
	 * @throws Exception
	 */

	@Override
	public List<Incidents> findIncidentsByCriteria(IncidentsRequestDTO incidentsRequestDTO) {
			GenericSpesification<Incidents> genericSpesification = new GenericSpesification<Incidents>();
			
			if(incidentsRequestDTO.getAssignedId()!=null) {
				 genericSpesification.add(new SearchCriteria("assignedId", incidentsRequestDTO.getAssignedId(), SearchOperation.MATCH));
				}
				if(incidentsRequestDTO.getAssignedTo()!=null) {
		        genericSpesification.add(new SearchCriteria("assignedTo", incidentsRequestDTO.getAssignedTo(), SearchOperation.MATCH));
				}
				if(incidentsRequestDTO.getCreatedBy()!=null) {
		        genericSpesification.add(new SearchCriteria("createdBy", incidentsRequestDTO.getCreatedBy(), SearchOperation.MATCH));
				}
				if(incidentsRequestDTO.getDescription()!=null) {
		        genericSpesification.add(new SearchCriteria("description", incidentsRequestDTO.getDescription(), SearchOperation.MATCH));
				}
				if(incidentsRequestDTO.getEndDate()!=null) {
				genericSpesification.add(new SearchCriteria("endDate", incidentsRequestDTO.getEndDate(), SearchOperation.MATCH));
					}
				if(incidentsRequestDTO.getIncidentId()!=null) {
			    genericSpesification.add(new SearchCriteria("incidentId", incidentsRequestDTO.getIncidentId(), SearchOperation.MATCH));
					}
				if(incidentsRequestDTO.getReportedBy()!=null) {
			    genericSpesification.add(new SearchCriteria("reportedBy", incidentsRequestDTO.getReportedBy(), SearchOperation.MATCH));
					}
				if(incidentsRequestDTO.getReportedDate()!=null) {
			    genericSpesification.add(new SearchCriteria("reportedDate", incidentsRequestDTO.getReportedDate(), SearchOperation.MATCH));
					}
				if(incidentsRequestDTO.getSubject()!=null) {
				    genericSpesification.add(new SearchCriteria("subject", incidentsRequestDTO.getSubject(), SearchOperation.MATCH));
						}
			
			 return incidentsRepository.findAll(genericSpesification);
		}
	

}
