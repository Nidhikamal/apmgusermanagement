package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.VendorEmployees;
import com.bourntec.apmg.entity.VendorEmployees;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorEmployeesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorEmployeesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorEmployeesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.VendorContactRepository;
import com.bourntec.apmg.usermanagement.v1.repository.VendorEmployeeRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.VendorEmployeeService;

@Service(value = "VendorEmployeeServiceImpl")

/**
 * 
 * Service class implementation for vendor  entity
 * 
 * @author vidya.p
 *
 */
public class VendorEmployeeServiceImpl implements VendorEmployeeService {
	
	@Autowired
	VendorEmployeeRepository vendorEmployeeRepository;

	private static final Logger logger = LogManager.getLogger(VendorEmployeeServiceImpl.class);

	/**
	 * This method creates new VendorEmployee
	 * @param VendorEmployeeRequestDTO
	 * @return VendorShipping
	 * @throws Exception 
	 */
	public VendorEmployeesResponseDTO saveVendorEmployees(VendorEmployeesRequestDTO vendorEmployeesRequestDTO) throws Exception {	

		
		VendorEmployeesResponseDTO  contactDetailsResponseDTO = new VendorEmployeesResponseDTO ();
		try {
			logger.info("Going to save vendor employee Details");			
			VendorEmployees vendorEmployees = vendorEmployeesRequestDTO.toModel(vendorEmployeesRequestDTO);
			VendorEmployees vendorContactsentity=vendorEmployeeRepository.save(vendorEmployees);
			if(vendorContactsentity!=null){
				BeanUtils.copyProperties(vendorContactsentity, contactDetailsResponseDTO);
				logger.info("employee saved successfully");
				contactDetailsResponseDTO.setResponseMessage("Success");
			}
			else{
				contactDetailsResponseDTO.setResponseMessage("Failed");
				logger.error("Failed to save employee ");
			}
		}
		catch (Exception e) {
			logger.error("VendorEmployeeServiceImpl:saveVendorEmployees" + e);
			throw e;
		}
		return contactDetailsResponseDTO;
	
		
	
	}
	/**
	 * This method update update VendorEmployee
	 * @param vendor id,VendorEmployeeRequestDTO
	 * @return VendorShipping
	 * @throws Exception 
	 */
	public VendorEmployeesResponseDTO updateVendorEmployees(Long id, VendorEmployeesRequestDTO vendorEmployeesRequestDTO)throws Exception{

		VendorEmployeesResponseDTO  savedRespDTO = new VendorEmployeesResponseDTO ();
		try {
			Optional<VendorEmployees> vendoremployeeOptional = vendorEmployeeRepository.findById(id);
			if (vendoremployeeOptional.isPresent()) {
				VendorEmployees newContacts = vendorEmployeesRequestDTO.toModel(vendorEmployeesRequestDTO);
				newContacts.setId(id);
				VendorEmployees entity = vendorEmployeeRepository.save(newContacts);
				if (entity != null) {
					BeanUtils.copyProperties(entity, savedRespDTO);
					savedRespDTO.setResponseMessage("Success");
					logger.info("Vendor Employee updated successfully");
				} else {
					savedRespDTO.setResponseMessage("Failed");
					logger.info("Vendor Employee updation failed");
				}
			} else {
				logger.info("Vendor Employee doesn't exist");
				savedRespDTO.setResponseMessage("Vendor Employee doesn't exist");
			}
		} catch (Exception e) {
			logger.error("VendorEmployeeServiceImpl :updateVendorEmployees" + e);
			throw e;
		}

		return savedRespDTO;
	
	}
	
	/**
	 * This method find  VendorEmployee by id
	 * @param vendor id
	 * @return VendorShipping
	 * @throws Exception 
	 */
	
	public VendorEmployeesResponseDTO findVendorEmployeesById(Long id) throws Exception {			

		VendorEmployeesResponseDTO  vendorContactDetails = new VendorEmployeesResponseDTO ();
		try {
			logger.info("Fetching Brand details....");
			Optional<VendorEmployees> vendoremployeeOptional = vendorEmployeeRepository.findById(id);
			if (vendoremployeeOptional.isPresent()) {
				VendorEmployees entity = vendoremployeeOptional.get();
				BeanUtils.copyProperties(entity, vendorContactDetails);
			} else {
				logger.error("Vendor Brand doesn't exist");
				vendorContactDetails.setResponseMessage("Failed");
			}
		} catch (Exception e) {
			logger.error("VendorEmployeeServiceImpl: findVendorEmployeesById" + e);
			throw e;
		}

		return vendorContactDetails;

	 
	}


	/**r
	 * This method get all VendorEmployee 
	 * @return VendorEmployeesResponseDTO list
	 * @throws Exception 
	 */
	public List<VendorEmployeesResponseDTO> findAllVendorEmployees() throws Exception {
		logger.info(" Going to find All vendorBrand");

		List<VendorEmployeesResponseDTO > vendorBrandResponseDTOs = new ArrayList<VendorEmployeesResponseDTO >();
		try {
			List<VendorEmployees> vendorBrandList= vendorEmployeeRepository.findAll();
			for (VendorEmployees vendorBrand : vendorBrandList) {
				VendorEmployeesResponseDTO  brandDetailsResponseDTO = new VendorEmployeesResponseDTO ();
				BeanUtils.copyProperties(vendorBrand,brandDetailsResponseDTO);
				vendorBrandResponseDTOs.add(brandDetailsResponseDTO);

			}
			logger.info("Find All vendorContacts");	
		} catch (Exception e) {
			logger.error("VendorEmployeeServiceImpl: VendorEmployees  failed" + e);
			throw e;

		}
		return vendorBrandResponseDTOs;


	}


	public List<VendorEmployees> findVendorEmployeesByCriteria(VendorEmployeesRequestDTO vendorEmployeesRequestDTO) {

		GenericSpesification<VendorEmployees> genericSpesification = new GenericSpesification<VendorEmployees>();
		
		if(vendorEmployeesRequestDTO.getId()!=null) {
			 genericSpesification.add(new SearchCriteria("id", vendorEmployeesRequestDTO.getId(), SearchOperation.MATCH));
			}
			if(vendorEmployeesRequestDTO.getEmpType()!=null) {
	        genericSpesification.add(new SearchCriteria("empType", vendorEmployeesRequestDTO.getEmpType(), SearchOperation.MATCH));
			}
			if(vendorEmployeesRequestDTO.getVendorNo()!=null) {
		        genericSpesification.add(new SearchCriteria("vendorNo", vendorEmployeesRequestDTO.getVendorNo(), SearchOperation.MATCH));
				}
			if(vendorEmployeesRequestDTO.getEmpName()!=null) {
	        genericSpesification.add(new SearchCriteria("empName", vendorEmployeesRequestDTO.getEmpName(), SearchOperation.MATCH));
			}
			if(vendorEmployeesRequestDTO.getEmpMail()!=null) {
	        genericSpesification.add(new SearchCriteria("empMail", vendorEmployeesRequestDTO.getEmpMail(), SearchOperation.MATCH));
			}
			
			if(vendorEmployeesRequestDTO.getEmpId()!=null) {
				genericSpesification.add(new SearchCriteria("empId", vendorEmployeesRequestDTO.getEmpId(), SearchOperation.MATCH));
			}
			if(vendorEmployeesRequestDTO.getEmpCell()!=null) {
				genericSpesification.add(new SearchCriteria("empCell", vendorEmployeesRequestDTO.getEmpCell(), SearchOperation.MATCH));
			}
		
		 return vendorEmployeeRepository.findAll(genericSpesification);
	
	}




	}
