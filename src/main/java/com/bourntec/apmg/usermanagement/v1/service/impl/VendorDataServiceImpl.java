package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.VendorData;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorDataResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.VendorDataRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.VendorDataService;

@Service(value = "VendorDataServiceImpl")

/**
 * 
 * Service class implementation for vendor  entity
 * 
 * @author vidya.p
 *
 */
public class VendorDataServiceImpl implements VendorDataService {
	@Autowired
	VendorDataRepository vendorDataRepository;
	private static final Logger logger = LogManager.getLogger(VendorBrandServiceImpl.class);
	/**
	 * This method creates new VendorData
	 * @param vendorDataRequestDTO
	 * @return VendorDataResponseDTO
	 * @throws Exception 
	 */
	
	public VendorDataResponseDTO saveVendorData(VendorDataRequestDTO vendorDataRequestDTO) throws Exception {
		

		VendorDataResponseDTO  notificationResponseDTO = new VendorDataResponseDTO ();
		try {
			logger.info("Going to save vendorData Details");			
			VendorData vendorData = vendorDataRequestDTO.toModel(vendorDataRequestDTO);
			VendorData vendorshipsentity=vendorDataRepository.save(vendorData);
			if(vendorshipsentity!=null){
				BeanUtils.copyProperties(vendorshipsentity, notificationResponseDTO);
				logger.info("vendorData saved successfully");
				notificationResponseDTO.setResponseMessage("Success");
			}
			else{
				notificationResponseDTO.setResponseMessage("Failed");
				logger.error("Failed to save vendorData ");
			}
		}
		catch (Exception e) {
			logger.error("VendorDataServiceImpl:Saving vendorData" + e);
			throw e;
		}
		return notificationResponseDTO;




	
	}

	/**
	 * This method update  VendorData
	 * @param vendor id,vendorDataRequestDTO
	 * @return VendorDataResponseDTO
	 * @throws Exception 
	 */
	public VendorDataResponseDTO updateVendorData(String id, VendorDataRequestDTO vendorDataRequestDTO) throws Exception {

		VendorDataResponseDTO  savedshipsRespDTO = new VendorDataResponseDTO ();
		try {
			Optional<VendorData> vendorshipOptional = vendorDataRepository.findById(id);
			if (vendorshipOptional.isPresent()) {
				VendorData newships = vendorDataRequestDTO.toModel(vendorDataRequestDTO);
				newships.setVendorNo(id);
				VendorData entity = vendorDataRepository.save(newships);
				if (entity != null) {
					BeanUtils.copyProperties(entity, savedshipsRespDTO);
					savedshipsRespDTO.setResponseMessage("Success");
					logger.info("Vendor vendorData updated successfully");
				} else {
					savedshipsRespDTO.setResponseMessage("Failed");
					logger.info("Vendor vendorData updation failed");
				}
			} else {
				logger.info("Vendor vendorData doesn't exist");
				savedshipsRespDTO.setResponseMessage("Vendor ships doesn't exist");
			}
		} catch (Exception e) {
			logger.error("VendorDataServiceImpl:Update :Vendor vendorData" + e);
			throw e;
		}

		return savedshipsRespDTO;
	
	}
	/**
	 * This method get  VendorData by id
	 * @param vendor id
	 * @return VendorDataResponseDTO
	 * @throws Exception 
	 */
	
	
	public VendorDataResponseDTO findVendorDataById(String id) throws Exception {			

		VendorDataResponseDTO vendorshipDetails = new VendorDataResponseDTO ();
		try {
			logger.info("Fetching shipping details....");
			Optional<VendorData> vendorDataOptional =vendorDataRepository.findById(id);
			if (vendorDataOptional.isPresent()) {
				VendorData entity = vendorDataOptional.get();
				BeanUtils.copyProperties(entity, vendorshipDetails);
			} else {
				logger.error("Vendor shipping doesn't exist");
				vendorshipDetails.setResponseMessage("Failed");
			}
		} catch (Exception e) {
			logger.error("VendorDataServiceImpl:Fetch: getBrandById" + e);
			throw e;
		}

		return vendorshipDetails;

	 
	}

	/**
	 * This method get all VendorData by
	 * @return VendorDataResponseDTO list
	 * @throws Exception 
	 */
	public List<VendorDataResponseDTO> findAllVendorData() throws Exception {
		logger.info(" Going to find All vendorData");

		List<VendorDataResponseDTO> vendorDataResponseDTOs = new ArrayList<VendorDataResponseDTO >();
		try {
			List<VendorData> vendorDataList= vendorDataRepository.findAll();
			for (VendorData vendorData : vendorDataList) {
				VendorDataResponseDTO notificationResponseDTO = new VendorDataResponseDTO ();
				BeanUtils.copyProperties(vendorData,notificationResponseDTO);
				vendorDataResponseDTOs.add(notificationResponseDTO);

			}
			logger.info("Find All vendorData");	
		} catch (Exception e) {
			logger.error("VendorDataServiceImpl:vendorData  failed" + e);
			throw e;

		}
		return vendorDataResponseDTOs;


	}

	/**
	 * This method get search
	 * @return VendorDataResponseDTO list
	 * @throws Exception 
	 */

	public List<VendorData> findVendorDataByCriteria(VendorDataRequestDTO vendorDataRequestDTO) throws Exception {

		GenericSpesification<VendorData> genericSpesification = new GenericSpesification<VendorData>();
		
		if(vendorDataRequestDTO.getVendorNo()!=null) {
			 genericSpesification.add(new SearchCriteria("vendorNo", vendorDataRequestDTO.getVendorNo(), SearchOperation.MATCH));
			}
			if(vendorDataRequestDTO.getEmailAddress()!=null) {
	        genericSpesification.add(new SearchCriteria("emailAddress", vendorDataRequestDTO.getEmailAddress(), SearchOperation.MATCH));
			}
			if(vendorDataRequestDTO.getState()!=null) {
	        genericSpesification.add(new SearchCriteria("address1", vendorDataRequestDTO.getAddress(), SearchOperation.MATCH));
			}
			if(vendorDataRequestDTO.getCity()!=null) {
	        genericSpesification.add(new SearchCriteria("phone", vendorDataRequestDTO.getCity(), SearchOperation.MATCH));
			}
			if(vendorDataRequestDTO.getZip()!=null) {
		        genericSpesification.add(new SearchCriteria("zip", vendorDataRequestDTO.getZip(), SearchOperation.MATCH));
			}
			if(vendorDataRequestDTO.getZip()!=null) {
		        genericSpesification.add(new SearchCriteria("zip", vendorDataRequestDTO.getZip(), SearchOperation.MATCH));
			}
			
			 return vendorDataRepository.findAll(genericSpesification);
	}

	
	
	
}
