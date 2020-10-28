package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.VendorBrandDetails;
import com.bourntec.apmg.entity.VendorContactDetails;
import com.bourntec.apmg.entity.VendorData;
import com.bourntec.apmg.entity.VendorEmployees;
import com.bourntec.apmg.entity.VendorNotification;
import com.bourntec.apmg.entity.VendorShippingDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorDataResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.VendorDataRepository;
import com.bourntec.apmg.usermanagement.v1.repository.VendorNotificationRepository;
import com.bourntec.apmg.usermanagement.v1.service.VendorService;

@Service

/**
 * 
 * Service class implementation for vendor  entity
 * 
 * @author vidya.p
 *
 */
@Deprecated
public class VendorServiceImpl implements VendorService {
	@Autowired
	VendorDataRepository vendorDataRepository;
	@Autowired
	VendorNotificationRepository vendorNotificationRepository;

	private static final Logger logger = LogManager.getLogger(VendorServiceImpl.class);

	/**
	 * This method creates new VendorData
	 * @param merchandiseCategoryRequestDTO
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */

	public VendorDataResponseDTO saveVendor(VendorDataRequestDTO vendorDataRequestDTO) throws Exception{

		try {
			logger.info("Going to save vendor");
			VendorDataResponseDTO vendorDataResponseDTO = new VendorDataResponseDTO();
			VendorData vendorData = vendorDataRequestDTO.toModel(vendorDataRequestDTO);

		if(vendorData!=null&&vendorData.getVendorNo()!=null){
			/*
			 * VendorShippingDetails
			 * vendorShippingDetails=vendorData.getVendorShippingDetails();
			 * if(vendorShippingDetails!=null){
			 * vendorShippingDetails.setVendorData(vendorData); }
			 * 
			 * List<VendorContactDetails>contactDetailsList=vendorData.
			 * getVendorContactDetails(); contactDetailsList.forEach((vendorContactDetails)
			 * -> { vendorContactDetails.setVendorData(vendorData); });
			 * 
			 * List<VendorEmployees>vendorEmployeeList=vendorData.getVendorEmployees();
			 * if(vendorEmployeeList!=null&&vendorEmployeeList.size()>0){
			 * vendorEmployeeList.forEach((vendorEmployees) -> {
			 * vendorEmployees.setVendorData(vendorData); }); }
			 * 
			 * 
			 * List<VendorBrandDetails>vendorBrandDetails=vendorData.getVendorBrandDetails()
			 * ; if(vendorBrandDetails!=null&&vendorBrandDetails.size()>0){
			 * vendorBrandDetails.forEach((brandDetails) -> {
			 * brandDetails.setVendorData(vendorData); }); }
			 */

				VendorData vendorDatareturn=vendorDataRepository.save(vendorData);
				if(vendorDatareturn!=null){
					logger.info("Save vendor"+vendorDatareturn.getVendorNo());
					VendorNotification vendorNotification=vendorDataRequestDTO.getVendorNotification();
					if(vendorNotification!=null){
						vendorNotification.setVendorNo(vendorDatareturn.getVendorNo());
						vendorNotificationRepository.save(vendorNotification);
					}
					logger.info("Save vendorNotification");
					BeanUtils.copyProperties(vendorDatareturn,vendorDataResponseDTO);
				}
				else{
					logger.error(" saveVendor  failed");
					vendorDataResponseDTO.setResponseMessage(" saveVendor  failed");
				}
			}

			else{
				logger.error(" Vendor id   not set");
				vendorDataResponseDTO.setResponseMessage(" Vendor id  not set");
			}
			return vendorDataResponseDTO;
		} catch (Exception e) {
			logger.error(" saveVendor  failed" + e);
			throw e;
		}

	}
	/**
	 * This method update  VendorData
	 * @param vendor id,vendorDataRequestDTO
	 * @return VendorDataResponseDTO
	 * @throws Exception 
	 */

	public VendorDataResponseDTO updateVendor(String id, VendorDataRequestDTO vendorDataRequestDTO)throws Exception { 

		try {
			logger.info("Going to update vendor");
			VendorDataResponseDTO vendorDataResponseDTO = new VendorDataResponseDTO();

			VendorData vendorData = vendorDataRequestDTO.toModel(vendorDataRequestDTO);
			vendorData.setVendorNo(id);
			//VendorShippingDetails vendorShippingDetails=vendorData.getVendorShippingDetails();
			/*
			 * if(vendorShippingDetails!=null){
			 * vendorShippingDetails.setVendorData(vendorData);
			 * vendorShippingDetails.setId(vendorData.getVendorShippingDetails().getId()); }
			 * 
			 * List<VendorContactDetails>contactDetailsList=vendorData.
			 * getVendorContactDetails();
			 * if(contactDetailsList!=null&&contactDetailsList.size()>0){
			 * contactDetailsList.forEach((vendorContactDetails) -> {
			 * vendorContactDetails.setVendorData(vendorData); }); }
			 * 
			 * List<VendorEmployees>vendorEmployeeList=vendorData.getVendorEmployees();
			 * if(vendorEmployeeList!=null&&vendorEmployeeList.size()>0){
			 * vendorEmployeeList.forEach((vendorEmployees) -> {
			 * vendorEmployees.setVendorData(vendorData); }); }
			 * 
			 * 
			 * List<VendorBrandDetails>vendorBrandDetails=vendorData.getVendorBrandDetails()
			 * ; if(vendorBrandDetails!=null&&vendorBrandDetails.size()>0){
			 * vendorBrandDetails.forEach((brandDetails) -> {
			 * brandDetails.setVendorData(vendorData); }); }
			 */

			VendorData vendorDatareturn=vendorDataRepository.saveAndFlush(vendorData);
			if(vendorDatareturn!=null){
				logger.info("Save vendor"+vendorDatareturn.getVendorNo());
				VendorNotification vendorNotification=vendorDataRequestDTO.getVendorNotification();
				if(vendorNotification!=null){
					vendorNotification.setVendorNo(vendorDatareturn.getVendorNo());
					vendorNotificationRepository.save(vendorNotification);
				}
				BeanUtils.copyProperties(vendorDatareturn,vendorDataResponseDTO);
			}
			else{
				logger.error(" saveVendor  failed");
				vendorDataResponseDTO.setResponseMessage(" saveVendor  failed");
			}
			return vendorDataResponseDTO;
		} catch (Exception e) {

			logger.error(" update  failed" + e);
			throw e;
		}

	}
	/**
	 * This method get  VendorData by id
	 * @return ResponseEntity<VendorDataResponseDTO>
	 * @throws Exception 
	 */


	public VendorDataResponseDTO findVendorById(String id)throws Exception {

		VendorDataResponseDTO vendorDataResponseDTO = new VendorDataResponseDTO();
		logger.info("Going find vendor  "+id);
		try {
			Optional<VendorData> vendorData = vendorDataRepository.findById(id);
			if(vendorData!=null){
				logger.info(" Find vendor   "+vendorData.get().getVendorNo());
				BeanUtils.copyProperties(vendorData.get(),vendorDataResponseDTO);
			}
			else{
				throw new ResourceNotFoundException(ErrorCodes.VENDOR_NOT_FOUND.getMessage());
			}
		}				
		catch(Exception e) {			
			logger.error(" findVendorById  failed" + e);
			throw e;
		}
		return vendorDataResponseDTO;	

	}
	
	
	
	/**
	 * This method get all VendorData by
	 * @return VendorDataResponseDTO list
	 * @throws Exception 
	 */

	public List<VendorDataResponseDTO> findAllVendor() throws Exception{
		logger.info(" Going to find All vendors");

		List<VendorDataResponseDTO> vendorDataResponseDTOs = new ArrayList<VendorDataResponseDTO>();
		try {
			List<VendorData> vendorDataList= vendorDataRepository.findAll();
			for (VendorData vendorData : vendorDataList) {
				VendorDataResponseDTO vendorDataResponseDTO = new VendorDataResponseDTO();
				BeanUtils.copyProperties(vendorData,vendorDataResponseDTO);
				vendorDataResponseDTOs.add(vendorDataResponseDTO);

			}
			logger.info("Find All vendors");	
		} catch (Exception e) {
			logger.error(" findVendorById  failed" + e);
			throw e;

		}
		return vendorDataResponseDTOs;


	}



}
