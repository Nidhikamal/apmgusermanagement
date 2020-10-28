package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.VendorStateCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorStateCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorStateCodesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.entity.AuditLog;
import com.bourntec.apmg.usermanagement.v1.queue.MessagePublisher;
import com.bourntec.apmg.usermanagement.v1.repository.VendorStateCodesRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.VendorStateCodesService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service(value = "VendorStateCodesServiceImpl")

public class VendorStateCodesServiceImpl implements VendorStateCodesService {
	private static final Logger logger = LogManager.getLogger(VendorStateCodesServiceImpl.class);

	@Autowired
	private VendorStateCodesRepository vendorStateRepository;

	@Autowired
	MessagePublisher redisPublisher;

	/**
	 * @author naveen This is the main method which is FETCH BY condition
	 * 
	 */
	@Override
	public VendorStateCodesResponseDTO saveVendorStateCustomer(VendorStateCodesRequestDTO countryRequestDTO) {

		VendorStateCodesResponseDTO countrycodeResponseDTO = new VendorStateCodesResponseDTO();
		try {
			VendorStateCodes countryCodestomodel = countryRequestDTO.toModel(countryRequestDTO);

			VendorStateCodes country = vendorStateRepository.save(countryCodestomodel);
			if (country != null) {
				BeanUtils.copyProperties(country, countrycodeResponseDTO);
				countrycodeResponseDTO.setResponseMessage("VendorStateCodes details is saved in DB");

			} else {
				logger.error(" VendorStateCodes country to not saved  ");
			}
		} catch (Exception e) {
			logger.error(" VendorStateCodes failed" + e);
			countrycodeResponseDTO.setResponseMessage("failed");

			throw e;
		}

		return countrycodeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to get update Country
	 * @param CountryRequestDTO,String countryCode
	 * @return CountrycodeResponseDTO
	 */

	@Override
	public VendorStateCodesResponseDTO updatestatecode(String stateCode, VendorStateCodesRequestDTO countryRequestDTO) {
		VendorStateCodesResponseDTO updatedRespDTOVendorStateCodes = new VendorStateCodesResponseDTO();
		try {
			Optional<VendorStateCodes> packingOptional = vendorStateRepository.findById(stateCode);
			if (packingOptional.isPresent()) {
				VendorStateCodes newShipCodes = countryRequestDTO.toModel(countryRequestDTO);
				newShipCodes.setStateCode(stateCode);
				VendorStateCodes shippingEntity = vendorStateRepository.save(newShipCodes);
				if (shippingEntity != null) {
					BeanUtils.copyProperties(shippingEntity, updatedRespDTOVendorStateCodes);
					updatedRespDTOVendorStateCodes.setResponseMessage("Updated  vendor state code");
					logger.info("Updated  vendor state code");
				} else {
					logger.error("vendor state code updation failed");
					updatedRespDTOVendorStateCodes.setResponseMessage("vendor state code updation failed");
				}
			} else {
				logger.info(" vendor state code doesn't exist");
				updatedRespDTOVendorStateCodes = saveVendorStateCustomer(countryRequestDTO);
				updatedRespDTOVendorStateCodes.setResponseMessage(" vendor state code added");
			}
		} catch (Exception e) {
			logger.error("Update:updateVendorStateCodes " + e);
			throw e;
		}

		return updatedRespDTOVendorStateCodes;
	}

	/**
	 * This method findBycountryCode
	 * 
	 * @param countryCode
	 * @return CountrycodeResponseDTO
	 * @throws Exception
	 */
	@Override
	public VendorStateCodesResponseDTO findStatecodeById(String stateCode) {

		logger.info("Entering stateCode  {}", stateCode);

		VendorStateCodesResponseDTO vendorStateCodesRespDTO = new VendorStateCodesResponseDTO();
		try {
			logger.info("Fetching  vendor state code");
			Optional<VendorStateCodes> optionalShipping = vendorStateRepository.findById(stateCode);
			if (optionalShipping.isPresent()) {
				VendorStateCodes shippping = optionalShipping.get();
				BeanUtils.copyProperties(shippping, vendorStateCodesRespDTO);
			} else {
				logger.error("vendor state code doesn't exist");
				vendorStateCodesRespDTO.setResponseMessage("vendor state code doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch:getVendorStateCodesById " + e);
			throw e;
		}
		return vendorStateCodesRespDTO;

	}

	/**
	 * @author naveen This is the main method which is used to get all CountryCode
	 * 
	 */
	@Override

	public List<VendorStateCodes> fetchAllStatecode() {
		logger.info("Fetching all countrycode   ...");

		return vendorStateRepository.findAll();
	}

	@Override
	public List<VendorStateCodes> fetchByStaterCtriteria(VendorStateCodesRequestDTO brandReq) {
		GenericSpesification<VendorStateCodes> genericSpesification = new GenericSpesification<VendorStateCodes>();

		if (brandReq.getStateCode() != null) {
			genericSpesification.add(new SearchCriteria("stateCode", brandReq.getStateCode(), SearchOperation.MATCH));
		}
		if (brandReq.getCountryCode() != null) {
			genericSpesification
					.add(new SearchCriteria("countryCode", brandReq.getCountryCode(), SearchOperation.MATCH));
		}
		if (brandReq.getStateName() != null) {
			genericSpesification.add(new SearchCriteria("stateName", brandReq.getStateName(), SearchOperation.MATCH));
		}

		if (brandReq.getDisplayWeb() != null) {
			genericSpesification.add(new SearchCriteria("displayWeb", brandReq.getDisplayWeb(), SearchOperation.MATCH));
		}
		return vendorStateRepository.findAll(genericSpesification);
	}

	@Override
	public VendorStateCodesResponseDTO deleteVendorStateCodes(String id) {
		logger.info("Entering delete ....");
		VendorStateCodesResponseDTO responseDTO = new VendorStateCodesResponseDTO();
		try {
			Optional<VendorStateCodes> VendorStateCodesObj = vendorStateRepository.findById(id);
			if (!VendorStateCodesObj.isPresent()) {
				logger.error("VendorStateCodes doesn't exist");
				responseDTO.setResponseMessage("VendorStateCodes doesn't exist");
				return responseDTO;
			}
			VendorStateCodes dataRespDTO = VendorStateCodesObj.get();
			if (dataRespDTO == null) {
				logger.info("The VendorStateCodes doesn't exists!!!");
				responseDTO.setResponseMessage("The VendorStateCodes doesn't exists!!!");
			} else {
				saveToAuditLog();
				//vendorStateRepository.delete(dataRespDTO);
				responseDTO.setResponseMessage(" VendorStateCodes deleted successfully");
			}
		} catch (Exception e) {
			logger.error("delete :delete VendorStateCodesof VendorStateCodesServiceImpl  " + e);
		}
		logger.info("Exiting delete VendorStateCodes");
		return responseDTO;
	}

	private void saveToAuditLog() {

		ObjectMapper objectMapper = new ObjectMapper();
		AuditLog auditLog = new AuditLog();		
		
		try {
			auditLog.setModuleName("USERMANAGEMENT");
			auditLog.setSubModuleName("VENDOR");
			auditLog.setUserId("ABC");
			auditLog.setAction("UPATION");
			auditLog.setActionMessage("SUCCESS");
			auditLog.setNewObject("");
			auditLog.setOldObject("");
			auditLog.setPrimaryKey("");
			auditLog.setCretaedDateTime("");
			
			redisPublisher.publish("receiveMessage", auditLog.toString());
		} catch (Exception e) {
			logger.info("Failed to write AuditLog : " + e.getMessage());
		}
		logger.info("successfully write AuditLog : ");
	}
}
