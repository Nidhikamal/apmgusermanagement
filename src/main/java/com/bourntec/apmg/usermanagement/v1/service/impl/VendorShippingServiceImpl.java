package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.VendorShippingDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorShippingDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorShippingDetailsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.VendorShippingRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.VendorShippingService;

@Service(value = "VendorShippingServiceImpl")

/**
 * 
 * Service class implementation for vendor  entity
 * 
 * @author vidya.p
 *
 */
public class VendorShippingServiceImpl implements VendorShippingService {
	@Autowired
	VendorShippingRepository vendorShippingRepository;

	private static final Logger logger = LogManager.getLogger(VendorShippingServiceImpl.class);


	public VendorShippingDetailsResponseDTO saveVendorShipping(VendorShippingDetailsRequestDTO vendorShippingRequestDTO)
			throws Exception {

		

		VendorShippingDetailsResponseDTO  notificationResponseDTO = new VendorShippingDetailsResponseDTO ();
		try {
			logger.info("Going to save shppingDetails Details");			
			VendorShippingDetails vendorNotification = vendorShippingRequestDTO.toModel(vendorShippingRequestDTO);
			VendorShippingDetails vendorshipsentity=vendorShippingRepository.save(vendorNotification);
			if(vendorshipsentity!=null){
				BeanUtils.copyProperties(vendorshipsentity, notificationResponseDTO);
				logger.info("shppingDetails saved successfully");
				notificationResponseDTO.setResponseMessage("Success");
			}
			else{
				notificationResponseDTO.setResponseMessage("Failed");
				logger.error("Failed to save shppingDetails ");
			}
		}
		catch (Exception e) {
			logger.error("Saving shppingDetails" + e);
			throw e;
		}
		return notificationResponseDTO;




	}


	public VendorShippingDetailsResponseDTO updateVendorShipping(Long id, VendorShippingDetailsRequestDTO vendorShippingRequestDTO)
			throws Exception {

		VendorShippingDetailsResponseDTO  savedshipsRespDTO = new VendorShippingDetailsResponseDTO ();
		try {
			Optional<VendorShippingDetails> vendorshipOptional = vendorShippingRepository.findById(id);
			if (vendorshipOptional.isPresent()) {
				VendorShippingDetails newships = vendorShippingRequestDTO.toModel(vendorShippingRequestDTO);
				newships.setId(id);
				VendorShippingDetails entity = vendorShippingRepository.save(newships);
				if (entity != null) {
					BeanUtils.copyProperties(entity, savedshipsRespDTO);
					savedshipsRespDTO.setResponseMessage("Success");
					logger.info("Vendor shppingDetails updated successfully");
				} else {
					savedshipsRespDTO.setResponseMessage("Failed");
					logger.info("Vendor shppingDetails updation failed");
				}
			} else {
				logger.info("Vendor shppingDetails doesn't exist");
				savedshipsRespDTO.setResponseMessage("Vendor ships doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update :Vendor shppingDetails" + e);
			throw e;
		}

		return savedshipsRespDTO;
	
	}


	public VendorShippingDetailsResponseDTO findVendorShippingById(Long id) throws Exception {			

		VendorShippingDetailsResponseDTO  vendorshipDetails = new VendorShippingDetailsResponseDTO ();
		try {
			logger.info("Fetching shipping details....");
			Optional<VendorShippingDetails> vendornotificationOptional =vendorShippingRepository.findById(id);
			if (vendornotificationOptional.isPresent()) {
				VendorShippingDetails entity = vendornotificationOptional.get();
				BeanUtils.copyProperties(entity, vendorshipDetails);
			} else {
				logger.error("Vendor shipping doesn't exist");
				vendorshipDetails.setResponseMessage("Failed");
			}
		} catch (Exception e) {
			logger.error("Fetch: getBrandById" + e);
			throw e;
		}

		return vendorshipDetails;

	 
	}


	public List<VendorShippingDetailsResponseDTO> findAllVendorShipping() throws Exception {
		logger.info(" Going to find All vendorshipping");

		List<VendorShippingDetailsResponseDTO> vendorshipResponseDTOs = new ArrayList<VendorShippingDetailsResponseDTO >();
		try {
			List<VendorShippingDetails> vendorshipList= vendorShippingRepository.findAll();
			for (VendorShippingDetails vendorshipping : vendorshipList) {
				VendorShippingDetailsResponseDTO  notificationResponseDTO = new VendorShippingDetailsResponseDTO ();
				BeanUtils.copyProperties(vendorshipping,notificationResponseDTO);
				vendorshipResponseDTOs.add(notificationResponseDTO);

			}
			logger.info("Find All vendorships");	
		} catch (Exception e) {
			logger.error(" vendorships  failed" + e);
			throw e;

		}
		return vendorshipResponseDTOs;


	}



	public List<VendorShippingDetails> findVendorShippingByCriteria(VendorShippingDetailsRequestDTO vendorShippingDetailsRequestDTO) {

		GenericSpesification<VendorShippingDetails> genericSpesification = new GenericSpesification<VendorShippingDetails>();

		if(vendorShippingDetailsRequestDTO.getVendorNo()!=null) {
			genericSpesification.add(new SearchCriteria("vendorNo", vendorShippingDetailsRequestDTO.getVendorNo(), SearchOperation.MATCH));
		}
		if(vendorShippingDetailsRequestDTO.getId()!=null) {
			genericSpesification.add(new SearchCriteria("id", vendorShippingDetailsRequestDTO.getId(), SearchOperation.EQUAL));
		}
		if(vendorShippingDetailsRequestDTO.getShipName()!=null) {
			genericSpesification.add(new SearchCriteria("shipName", vendorShippingDetailsRequestDTO.getShipName(), SearchOperation.MATCH));
		}
		if(vendorShippingDetailsRequestDTO.getShipAddress1()!=null) {
			genericSpesification.add(new SearchCriteria("shipAddress1", vendorShippingDetailsRequestDTO.getShipAddress1(), SearchOperation.MATCH));
		}
		if(vendorShippingDetailsRequestDTO.getShipPhone()!=null) {
			genericSpesification.add(new SearchCriteria("shipPhone", vendorShippingDetailsRequestDTO.getShipPhone(), SearchOperation.EQUAL));
		}
		if(vendorShippingDetailsRequestDTO.getShipZip()!=null) {
			genericSpesification.add(new SearchCriteria("shipZip", vendorShippingDetailsRequestDTO.getShipZip(), SearchOperation.EQUAL));
		}
		if(vendorShippingDetailsRequestDTO.getShipCountry()!=null) {
			genericSpesification.add(new SearchCriteria("shipCountry", vendorShippingDetailsRequestDTO.getShipCountry(), SearchOperation.MATCH));
		}
		if(vendorShippingDetailsRequestDTO.getLocationCode()!=null) {
			genericSpesification.add(new SearchCriteria("locationCode", vendorShippingDetailsRequestDTO.getLocationCode(), SearchOperation.MATCH));
		}
		if(vendorShippingDetailsRequestDTO.getShipAddress2()!=null) {
			genericSpesification.add(new SearchCriteria("shipAddress2", vendorShippingDetailsRequestDTO.getShipAddress2(), SearchOperation.MATCH));
		}
		if(vendorShippingDetailsRequestDTO.getShipCity()!=null) {
			genericSpesification.add(new SearchCriteria("shipCity", vendorShippingDetailsRequestDTO.getShipCity(), SearchOperation.MATCH));
		}
		if(vendorShippingDetailsRequestDTO.getShipState()!=null) {
			genericSpesification.add(new SearchCriteria("shipState", vendorShippingDetailsRequestDTO.getShipState(), SearchOperation.MATCH));
		}
		return vendorShippingRepository.findAll(genericSpesification);

	}



	
	}
