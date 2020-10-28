package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.VendorContactDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorContactDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorContactDetailsResponseDTO ;
import com.bourntec.apmg.usermanagement.v1.repository.VendorContactRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.VendorContactService;

@Service(value="VendorContactServiceImpl")

/**
 * 
 * Service class implementation for vendor  entity
 * 
 * @author vidya.p
 *
 */
public  class VendorContactServiceImpl implements VendorContactService {
	@Autowired
	VendorContactRepository vendorContactRepository;

	private static final Logger logger = LogManager.getLogger(VendorContactServiceImpl.class);

	/**
	 * This method creates new VendorContact
	 * @param VendorContactRequestDTO
	 * @return vendorContactResponseDTO
	 * @throws Exception 
	 */
	public VendorContactDetailsResponseDTO saveVendorContact(VendorContactDetailsRequestDTO  vendorcontactRequestDTO) throws Exception {
		
		VendorContactDetailsResponseDTO  contactDetailsResponseDTO = new VendorContactDetailsResponseDTO ();
		try {
			logger.info("Going to save vendor contact Details");			
			VendorContactDetails vendorContactDetails = vendorcontactRequestDTO.toModel(vendorcontactRequestDTO);
			VendorContactDetails vendorContactsentity=vendorContactRepository.save(vendorContactDetails);
			if(vendorContactsentity!=null){
				BeanUtils.copyProperties(vendorContactsentity, contactDetailsResponseDTO);
				logger.info("Vendor Contacts saved successfully");
				contactDetailsResponseDTO.setResponseMessage("Success");
			}
			else{
				contactDetailsResponseDTO.setResponseMessage("Failed");
				logger.error("Failed to save vendor Contacts ");
			}
		}
		catch (Exception e) {
			logger.error("VendorContactServiceImpl:Saving vendor Contacts" + e);
			throw e;
		}
		return contactDetailsResponseDTO;
	
		
	}
	/**
	 * This method update  VendorContact
	 * @param VendorContact id,VendorContactRequestDTO
	 * @return vendorContactResponseDTO
	 * @throws Exception 
	 */
	
	public VendorContactDetailsResponseDTO updateVendorContact(Long id, VendorContactDetailsRequestDTO vendorContactDetailsRequestDTO) throws Exception {

		VendorContactDetailsResponseDTO  savedContactsRespDTO = new VendorContactDetailsResponseDTO ();
		try {
			Optional<VendorContactDetails> vendorcontactOptional = vendorContactRepository.findById(id);
			if (vendorcontactOptional.isPresent()) {
				VendorContactDetails newContacts = vendorContactDetailsRequestDTO.toModel(vendorContactDetailsRequestDTO);
				newContacts.setId(id);
				VendorContactDetails entity = vendorContactRepository.save(newContacts);
				if (entity != null) {
					BeanUtils.copyProperties(entity, savedContactsRespDTO);
					savedContactsRespDTO.setResponseMessage("Success");
					logger.info("Vendor Contacts updated successfully");
				} else {
					savedContactsRespDTO.setResponseMessage("Failed");
					logger.info("Vendor Contacts updation failed");
				}
			} else {
				logger.info("Vendor Contacts doesn't exist");
				savedContactsRespDTO.setResponseMessage("Vendor Contacts doesn't exist");
			}
		} catch (Exception e) {
			logger.error("VendorContactServiceImpl:Update :Vendor Contacts" + e);
			throw e;
		}

		return savedContactsRespDTO;
	
	}
	/**
	 * This API get  vendorcontact by id
	 * @param vendorcontact id
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */
	
	
	public VendorContactDetailsResponseDTO findVendorContactById(Long id) throws Exception {		

		VendorContactDetailsResponseDTO  vendorContactDetails = new VendorContactDetailsResponseDTO ();
		try {
			logger.info("Fetching Brand details....");
			Optional<VendorContactDetails> vendorcontactOptional = vendorContactRepository.findById(id);
			if (vendorcontactOptional.isPresent()) {
				VendorContactDetails entity = vendorcontactOptional.get();
				BeanUtils.copyProperties(entity, vendorContactDetails);
			} else {
				logger.error("Vendor Brand doesn't exist");
				vendorContactDetails.setResponseMessage("Failed");
			}
		} catch (Exception e) {
			logger.error("VendorContactServiceImpl:Fetch: findVendorContactById" + e);
			throw e;
		}

		return vendorContactDetails;

	}
	/**
	 * This API get  all vendorcontact 
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */
	
	public List<VendorContactDetailsResponseDTO> findAllVendorContact() throws Exception {
		logger.info(" Going to find All vendorcontact");

		List<VendorContactDetailsResponseDTO > vendorcontactResponseDTOs = new ArrayList<VendorContactDetailsResponseDTO >();
		try {
			List<VendorContactDetails> vendorcontactList= vendorContactRepository.findAll();
			for (VendorContactDetails vendorcontact : vendorcontactList) {
				VendorContactDetailsResponseDTO  brandDetailsResponseDTO = new VendorContactDetailsResponseDTO ();
				BeanUtils.copyProperties(vendorcontact,brandDetailsResponseDTO);
				vendorcontactResponseDTOs.add(brandDetailsResponseDTO);

			}
			logger.info("Find All vendorContacts");	
		} catch (Exception e) {
			logger.error("VendorContactServiceImpl:vendorContacts  findAllVendorContact" + e);
			throw e;

		}
		return vendorcontactResponseDTOs;


	}

	/**
	 *  search interface for searching  vendorcontact dynamically
	 * @param vendorcontactRequestDTO
	 * @return VendorContactDetails
	 */
	public List<VendorContactDetails> fetchByVendorContactCtriteria(
			VendorContactDetailsRequestDTO vendorContactDetailsRequestDTO) {

		GenericSpesification<VendorContactDetails> genericSpesification = new GenericSpesification<VendorContactDetails>();
		
		if(vendorContactDetailsRequestDTO.getId()!=null) {
			 genericSpesification.add(new SearchCriteria("id", vendorContactDetailsRequestDTO.getId(), SearchOperation.MATCH));
			}
			if(vendorContactDetailsRequestDTO.getVendorId()!=null) {
	        genericSpesification.add(new SearchCriteria("vendorId", vendorContactDetailsRequestDTO.getVendorId(), SearchOperation.MATCH));
			}
			if(vendorContactDetailsRequestDTO.getPhone()!=null) {
	        genericSpesification.add(new SearchCriteria("fax", vendorContactDetailsRequestDTO.getFax(), SearchOperation.MATCH));
			}
			if(vendorContactDetailsRequestDTO.getCell()!=null) {
	        genericSpesification.add(new SearchCriteria("phone", vendorContactDetailsRequestDTO.getPhone(), SearchOperation.MATCH));
			}
			
			if(vendorContactDetailsRequestDTO.getFax()!=null) {
				genericSpesification.add(new SearchCriteria("cell", vendorContactDetailsRequestDTO.getCell(), SearchOperation.MATCH));
			}
			
		
		 return vendorContactRepository.findAll(genericSpesification);
	
	}


	}
