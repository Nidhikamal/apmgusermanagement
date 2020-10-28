package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.VendorCountryCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorCountryCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorCountryCodesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.VendorCountryCodesRepository;
import com.bourntec.apmg.usermanagement.v1.service.VendorCountryCodesService;


@Service(value = "VendorCountryCodesServiceImpl")

public class VendorCountryCodesServiceImpl  implements  VendorCountryCodesService {

	
	private static final Logger logger = LogManager.getLogger(VendorCountryCodesServiceImpl.class);


	@Autowired
	private VendorCountryCodesRepository vendorCountryRepository;

	
	
	

	/**
	 * @author naveen This is the main method which is used to save Vendorcountry
	 *         data
	 * 
	 */
	@Override
	public VendorCountryCodesResponseDTO saveVendorCountry(VendorCountryCodesRequestDTO vendorCountryRequestDTO) {

		VendorCountryCodesResponseDTO vendorCountrycodeResponseDTO = new VendorCountryCodesResponseDTO();
		try {
			VendorCountryCodes vendorCountryCodes = vendorCountryRequestDTO.toModel(vendorCountryRequestDTO);
		
		
			
			/*
			 * Set<VendorStateCodes> vendorStateCodesList
			 * =vendorCountryRequestDTO.getStateCodesSet(); if (vendorStateCodesList != null
			 * && vendorStateCodesList.size() > 0) {
			 * vendorStateCodesList.forEach((venderobj) -> {
			 * venderobj.setVendorCountryCodes(vendorCountryCodes);
			 * 
			 * 
			 * }); }
			 */
			VendorCountryCodes vendercountry =vendorCountryRepository.save(vendorCountryCodes);
			if (vendercountry != null) {
				logger.info("vendorCountry Details is saved");
				BeanUtils.copyProperties(vendercountry, vendorCountrycodeResponseDTO);

				
			}
		} catch (Exception e) {
			logger.error(" vendorCountry Details save failed" + e);
			throw e;
		}

		return vendorCountrycodeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to update Vendorcountry
	 *         data
	 * 
	 */
	public VendorCountryCodesResponseDTO updateVendorCountry(String countryCode,
			VendorCountryCodesRequestDTO countryRequestDTO) {
		VendorCountryCodesResponseDTO updatedRespDTOVendorCountryCodes = new VendorCountryCodesResponseDTO();
		try {
			Optional<VendorCountryCodes> packingOptional = vendorCountryRepository.findById(countryCode);
			if (packingOptional.isPresent()) {
				VendorCountryCodes newShipCodes = countryRequestDTO.toModel(countryRequestDTO);
				newShipCodes.setCountryCode(countryCode);
				VendorCountryCodes shippingEntity = vendorCountryRepository.save(newShipCodes);
				if (shippingEntity != null) {
					BeanUtils.copyProperties(shippingEntity, updatedRespDTOVendorCountryCodes);
					updatedRespDTOVendorCountryCodes.setResponseMessage("Updated Vendor countrycodes");
					logger.info("Updated Vendor countrycodes");
				} else {
					logger.error("Vendor Countrycodes updation failed");
					updatedRespDTOVendorCountryCodes.setResponseMessage("Vendor Countrycodes updation failed");
				}
			} else {
				logger.error("Vendor countrycodes doesn't exist");
				updatedRespDTOVendorCountryCodes.setResponseMessage("Vendor countrycodes doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update:updateVendorCountryCodes " + e);
			throw e;
		}

		return updatedRespDTOVendorCountryCodes;
	}


	/**
	 * @author naveen This is the main method which is used to get all VendorCountry
	 * 
	 */
	public List<VendorCountryCodes> findAllVendorCountry() {
		logger.info("Fetching all vendorcountry details  ...");

		return vendorCountryRepository.findAll();
	}


	/**
	 * This method findByVendorcountryCode
	 * 
	 * @param countryCode
	 * @return CountrycodeResponseDTO
	 * @throws Exception
	 */
	public VendorCountryCodesResponseDTO findByVendorcountryCode(String countryCode) {

		logger.info("Entering vendorcountryCode  {}", countryCode);

		VendorCountryCodesResponseDTO vendorCountrycodeResponseDTO = new VendorCountryCodesResponseDTO();
		try {
			logger.info("Fetching  Vendor Countrycodes");
			Optional<VendorCountryCodes> optionalShipping = vendorCountryRepository.findById(countryCode);
			if (optionalShipping.isPresent()) {
				VendorCountryCodes shippping = optionalShipping.get();
				BeanUtils.copyProperties(shippping, vendorCountrycodeResponseDTO);
			} else {
				logger.error("Vendor Countrycodes doesn't exist");
				vendorCountrycodeResponseDTO.setResponseMessage("Vendor Countrycodes doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch:getVendorCountryCodesById " + e);
			throw e;
		}
		return vendorCountrycodeResponseDTO;

	}

}
