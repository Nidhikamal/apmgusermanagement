package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.LocationEmployee;
import com.bourntec.apmg.usermanagement.v1.dto.request.LocationEmployeeDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.LocationEmployeeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.LocationEmployeeRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.LocationEmployeeService;

@Service("LocationEmployeeServiceImpl")
public class LocationEmployeeServiceImpl implements LocationEmployeeService{

	
	private static final Logger logger = LogManager.getLogger(LocationEmployeeServiceImpl.class);
	
	@Autowired
	private  LocationEmployeeRepository  locationEmployeeRepository;
	
	

	/**
	 * @author amal This is the main method which is used to get LocationEmployee by
	 *         Id
	 */
	@Override
	public LocationEmployeeResponseDTO getLocationEmployeeById(Long id) {

		LocationEmployeeResponseDTO locationEmployeeResponseDTO = new LocationEmployeeResponseDTO();
		try {
			logger.info("Fetching  LocationEmployee");
			Optional<LocationEmployee> optionalShipping = locationEmployeeRepository.findById(id);
			if (optionalShipping.isPresent()) {
				LocationEmployee shippping = optionalShipping.get();
				BeanUtils.copyProperties(shippping, locationEmployeeResponseDTO);
			} else {
				logger.error("Location Employee codes doesn't exist");
				locationEmployeeResponseDTO.setResponseMessage("Location Employee doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch:getLocationEmployeeById " + e);
			throw e;
		}
		return locationEmployeeResponseDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all LocationEmployee
	 */
	@Override
	public List<LocationEmployee> findAllLocationEmployee() {
		logger.info("Location Employee codes");
		return locationEmployeeRepository.findAll();
	}

	/**
	 * @author amal This is the main method which is used to get save LocationEmployee
	 */
	@Override
	public LocationEmployeeResponseDTO saveLocationEmployee(LocationEmployeeDTO locationEmployeeDTO) {
		logger.info("save LocationEmployee details ....");
		LocationEmployeeResponseDTO locationEmployeeResponseDTO = new LocationEmployeeResponseDTO();
		try {
			LocationEmployee LocationEmployeeObj = locationEmployeeDTO.toModel(locationEmployeeDTO);
			LocationEmployee locationEmp= locationEmployeeRepository.save(LocationEmployeeObj);
			if (locationEmp != null) {
				BeanUtils.copyProperties(locationEmp, locationEmployeeResponseDTO);
				logger.info("MemoBilling saved successfully");
				locationEmployeeResponseDTO.setResponseMessage("MemoBilling saved successfully");
			} else {
				locationEmployeeResponseDTO.setResponseMessage("Failed to save MemoBilling");
				logger.error("Failed to save MemoBilling ");
			}
		} catch (Exception e) {
			logger.error("Saving saveMemoBilling of MemoBillingServiceImpl" + e);
			throw e;
		}

		return locationEmployeeResponseDTO;
	}

	

	
	private List<LocationEmployee> getFindingItem(String locationcode,List<LocationEmployeeDTO> invReqDTOList) {
		List<LocationEmployee> inventoryFindings = new ArrayList<LocationEmployee>();
		try {
			invReqDTOList.forEach(finding -> {
				LocationEmployee	loc = new  LocationEmployee();
				loc.setId(finding.getId());
				loc.setEmpId(finding.getEmpId());
				loc.setLocationCode(locationcode);
				loc.setName(finding.getName());
				inventoryFindings.add(loc);
			});
		} catch (Exception e) {
			logger.error("Exception while saving Finding : " + e.getMessage());
		}
		return inventoryFindings;
		
	}

	private List<LocationEmployee> getInvItem(String locationcode) {
		LocationEmployee findingObj = new LocationEmployee();
		findingObj.setLocationCode(locationcode);

		return locationEmployeeRepository.findAll(Example.of(findingObj));	}

	/**
	 * @author amal This is the main method which is used to get update shipping
	 *         codes
	 * 
	 */
	@Override
	public LocationEmployeeResponseDTO updateLocationEmployee(Long id, LocationEmployeeDTO finding) {
		LocationEmployeeResponseDTO updatedRespDTOLocationEmployee = new LocationEmployeeResponseDTO();
		try {
			Optional<LocationEmployee> packingOptional = locationEmployeeRepository.findById(id);
			if (packingOptional.isPresent()) {
				LocationEmployee newShipCodes = finding.toModel(finding);
				newShipCodes.setId(id);
				LocationEmployee shippingEntity = locationEmployeeRepository.save(newShipCodes);
				if (shippingEntity != null) {
					BeanUtils.copyProperties(shippingEntity, updatedRespDTOLocationEmployee);
					updatedRespDTOLocationEmployee.setResponseMessage("Updated  LocationEmployee");
					logger.info("Updated  LocationEmployee");
				} else {
					logger.error("LocationEmployee updation failed");
					updatedRespDTOLocationEmployee.setResponseMessage("LocationEmployee updation failed");
				}
			} else {
				logger.error(" LocationEmployee doesn't exist");
				updatedRespDTOLocationEmployee.setResponseMessage(" LocationEmployee doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update:updateLocationEmployee " + e);
			throw e;
		}

		return updatedRespDTOLocationEmployee;
	}
	@Override
	public List<LocationEmployee> findLocationEmployeeByCriteria(LocationEmployeeDTO finding) {
		GenericSpesification<LocationEmployee> genericSpesification = new GenericSpesification<LocationEmployee>();
		logger.info("Fetching  LocationEmployee");
		if (finding.getId()!= null) {
			genericSpesification.add(new SearchCriteria("id", finding.getId(), SearchOperation.EQUAL));
		}
		if (finding.getEmpId()!= null) {
			genericSpesification.add(new SearchCriteria("empId", finding.getEmpId(), SearchOperation.EQUAL));
		}
		
		if (finding.getLocationCode() != null) {
			genericSpesification.add(new SearchCriteria("locationCode", finding.getLocationCode(), SearchOperation.MATCH));
		}
		
		if (finding.getName() != null) {
			genericSpesification.add(new SearchCriteria("name", finding.getName(), SearchOperation.MATCH));
		}
		
		return locationEmployeeRepository.findAll(genericSpesification);
	}
	
	@Override
	public LocationEmployeeResponseDTO deleteLocationEmployeeById(Long id) {
		logger.info("Entering deleteLocationEmployee  {}", id);
		LocationEmployeeResponseDTO dataRespDTO = new LocationEmployeeResponseDTO();
		Optional<LocationEmployee> dataList = locationEmployeeRepository.findById(id);
		LocationEmployee locationEmpObj = dataList.get();
		try {
			if (locationEmpObj == null) {
				logger.info("The LocationEmployee doesn't exists!!!");
				dataRespDTO.setResponseMessage("The LocationEmployee doesn't exists!!!");
			} else {
				locationEmployeeRepository.delete(locationEmpObj);
				dataRespDTO.setResponseMessage(" LocationEmployee delete successfully");
			}
			logger.info("Exiting deleteLocationEmployee");
		} catch (Exception e) {
			logger.error("delete :deleteLocationEmployeeById of LocationEmployeeServiceImpl " + e);
			throw e;
		}
		return dataRespDTO;
	}

}
