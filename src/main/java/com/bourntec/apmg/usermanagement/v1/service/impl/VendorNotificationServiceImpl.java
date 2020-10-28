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
import com.bourntec.apmg.entity.VendorNotification;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorNotificationRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorContactDetailsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorNotificationResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.VendorEmployeeRepository;
import com.bourntec.apmg.usermanagement.v1.repository.VendorNotificationRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.VendorNotificationService;

@Service("VendorNotificationServiceImpl")

/**
 * 
 * Service class implementation for vendor  entity
 * 
 * @author vidya.p
 *
 */
public class VendorNotificationServiceImpl implements VendorNotificationService {

	
		@Autowired
		VendorNotificationRepository vendorNotificationRepository;

		private static final Logger logger = LogManager.getLogger(VendorNotificationServiceImpl.class);
		/**
		 * This method creates new VendorDataNotification
		 * @param VendorDataNotificationRequestDTO
		 * @return VendorDataNotificationResponseDTO
		 * @throws Exception 
		 */
		 
		public VendorNotificationResponseDTO save(VendorNotificationRequestDTO vendorNotificationRequestDTO)
				throws Exception {


			VendorNotificationResponseDTO  notificationResponseDTO = new VendorNotificationResponseDTO ();
			try {
				logger.info("Going to save notification Details");			
				VendorNotification vendorNotification = vendorNotificationRequestDTO.toModel(vendorNotificationRequestDTO);
				VendorNotification vendorContactsentity=vendorNotificationRepository.save(vendorNotification);
				if(vendorContactsentity!=null){
					BeanUtils.copyProperties(vendorContactsentity, notificationResponseDTO);
					logger.info("notification saved successfully");
					notificationResponseDTO.setResponseMessage("Success");
				}
				else{
					notificationResponseDTO.setResponseMessage("Failed");
					logger.error("Failed to save notification ");
				}
			}
			catch (Exception e) {
				logger.error("Saving notification" + e);
				throw e;
			}
			return notificationResponseDTO;




		}


	public VendorNotificationResponseDTO update(String id,
			VendorNotificationRequestDTO vendorNotificationRequestDTO) throws Exception {

		VendorNotificationResponseDTO  savedContactsRespDTO = new VendorNotificationResponseDTO ();
		try {
			Optional<VendorNotification> vendorcontactOptional = vendorNotificationRepository.findById(id);
			if (vendorcontactOptional.isPresent()) {
				VendorNotification newContacts = vendorNotificationRequestDTO.toModel(vendorNotificationRequestDTO);
				newContacts.setVendorNo(id);
				VendorNotification entity = vendorNotificationRepository.save(newContacts);
				if (entity != null) {
					BeanUtils.copyProperties(entity, savedContactsRespDTO);
					savedContactsRespDTO.setResponseMessage("Success");
					logger.info("Vendor notification updated successfully");
				} else {
					savedContactsRespDTO.setResponseMessage("Failed");
					logger.info("Vendor notification updation failed");
				}
			} else {
				logger.info("Vendor notification doesn't exist");
				savedContactsRespDTO.setResponseMessage("Vendor Contacts doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update :Vendor notification" + e);
			throw e;
		}

		return savedContactsRespDTO;
	
	}


	public VendorNotificationResponseDTO findById(String id) throws Exception {			

		VendorNotificationResponseDTO  vendorContactDetails = new VendorNotificationResponseDTO ();
		try {
			logger.info("Fetching Brand details....");
			Optional<VendorNotification> vendornotificationOptional =vendorNotificationRepository.findById(id);
			if (vendornotificationOptional.isPresent()) {
				VendorNotification entity = vendornotificationOptional.get();
				BeanUtils.copyProperties(entity, vendorContactDetails);
			} else {
				logger.error("Vendor Brand doesn't exist");
				vendorContactDetails.setResponseMessage("Failed");
			}
		} catch (Exception e) {
			logger.error("Fetch: getBrandById" + e);
			throw e;
		}

		return vendorContactDetails;

	 
	}


	public List<VendorNotificationResponseDTO> findAll() throws Exception {
		logger.info(" Going to find All vendorContact");

		List<VendorNotificationResponseDTO> vendorContactResponseDTOs = new ArrayList<VendorNotificationResponseDTO >();
		try {
			List<VendorNotification> vendorContactList= vendorNotificationRepository.findAll();
			for (VendorNotification vendorContact : vendorContactList) {
				VendorNotificationResponseDTO  notificationResponseDTO = new VendorNotificationResponseDTO ();
				BeanUtils.copyProperties(vendorContact,notificationResponseDTO);
				vendorContactResponseDTOs.add(notificationResponseDTO);

			}
			logger.info("Find All vendorContacts");	
		} catch (Exception e) {
			logger.error(" vendorContacts  failed" + e);
			throw e;

		}
		return vendorContactResponseDTOs;


	}



	public List<VendorNotification> findByCriteria(
			VendorNotificationRequestDTO vendorNotificationRequestDTO) {

		GenericSpesification<VendorNotification> genericSpesification = new GenericSpesification<VendorNotification>();
		
		if(vendorNotificationRequestDTO.getVendorNo()!=null) {
			 genericSpesification.add(new SearchCriteria("vendorNo", vendorNotificationRequestDTO.getVendorNo(), SearchOperation.MATCH));
			}
			if(vendorNotificationRequestDTO.getDesc1()!=null) {
	        genericSpesification.add(new SearchCriteria("desc1", vendorNotificationRequestDTO.getDesc1(), SearchOperation.MATCH));
			}
			if(vendorNotificationRequestDTO.getDesc2()!=null) {
	        genericSpesification.add(new SearchCriteria("desc2", vendorNotificationRequestDTO.getDesc2(), SearchOperation.MATCH));
			}
			if(vendorNotificationRequestDTO.getInvoice1()!=null) {
	        genericSpesification.add(new SearchCriteria("invoice1", vendorNotificationRequestDTO.getInvoice1(), SearchOperation.MATCH));
			}
			
			
		 return vendorNotificationRepository.findAll(genericSpesification);
	
	}



	}
