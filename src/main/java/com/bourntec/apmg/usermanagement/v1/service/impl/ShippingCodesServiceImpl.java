package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.ShippingCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.ShippingCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ShippingCodesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.ShippingCodesRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.ShippingCodesService;

/**
 * 
 * Service class implementation for employee Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Service(value = "ShippingCodesServiceImpl")
public class ShippingCodesServiceImpl implements ShippingCodesService {

	private static final Logger logger = LogManager.getLogger(ShippingCodesServiceImpl.class);

	@Autowired
	private ShippingCodesRepository shippingRepository;

	/**
	 * @author amal This is the main method which is used to get shipping codes by
	 *         Id
	 */
	public ShippingCodesResponseDTO getShippingCodesById(String id) {

		ShippingCodesResponseDTO shippingCodesRespDTO = new ShippingCodesResponseDTO();
		try {
			logger.info("Fetching  shipping codes");
			Optional<ShippingCodes> optionalShipping = shippingRepository.findById(id);
			if (optionalShipping.isPresent()) {
				ShippingCodes shippping = optionalShipping.get();
				BeanUtils.copyProperties(shippping, shippingCodesRespDTO);
			} else {
				logger.error("Shipping codes doesn't exist");
				shippingCodesRespDTO.setResponseMessage("Shipping codes doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch:getShippingCodesById " + e);
			throw e;
		}
		return shippingCodesRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all shipping codes
	 */

	public List<ShippingCodes> findAllShippingCodes() {
		logger.info("Fetching  shipping codes");
		return shippingRepository.findAll();
	}

	/**
	 * @author amal This is the main method which is used to get save shipping codes
	 */
	public ShippingCodesResponseDTO saveShippingCodes(ShippingCodesRequestDTO shippingCodesReq) {
		ShippingCodesResponseDTO shippigCodesRespDTO = new ShippingCodesResponseDTO();
		try {
			ShippingCodes shipping = shippingCodesReq.toModel(shippingCodesReq);
			ShippingCodes shippingEntity = shippingRepository.save(shipping);
			if (shippingEntity != null) {
				BeanUtils.copyProperties(shippingEntity, shippigCodesRespDTO);
				shippigCodesRespDTO.setResponseMessage("Saved  shipping codes");
				logger.info("Saved  shipping codes");
			} else {
				shippigCodesRespDTO.setResponseMessage("Failed to save  shipping codes");
				logger.error("Failed to save  shipping codes");
			}
		} catch (Exception e) {
			logger.error("Save:saveShippingCodes " + e);
			throw e;
		}
		return shippigCodesRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get update shipping
	 *         codes
	 * 
	 */

	public ShippingCodesResponseDTO updateShippingCodes(String id, ShippingCodesRequestDTO shippingCodesReq) {
		ShippingCodesResponseDTO updatedRespDTOShippingCodes = new ShippingCodesResponseDTO();
		try {
			Optional<ShippingCodes> packingOptional = shippingRepository.findById(id);
			if (packingOptional.isPresent()) {
				ShippingCodes newShipCodes = shippingCodesReq.toModel(shippingCodesReq);
				newShipCodes.setShipCode(id);
				ShippingCodes shippingEntity = shippingRepository.save(newShipCodes);
				if (shippingEntity != null) {
					BeanUtils.copyProperties(shippingEntity, updatedRespDTOShippingCodes);
					updatedRespDTOShippingCodes.setResponseMessage("Updated  shipping codes");
					logger.info("Updated  shipping codes");
				} else {
					logger.error("Shipping codes updation failed");
					updatedRespDTOShippingCodes.setResponseMessage("Shipping codes updation failed");
				}
			} else {
				logger.error(" Shipping codes doesn't exist");
				updatedRespDTOShippingCodes.setResponseMessage(" Shipping codes doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update:updateShippingCodes " + e);
			throw e;
		}

		return updatedRespDTOShippingCodes;
	}

	public List<ShippingCodes> findShippingCodeByCriteria(ShippingCodesRequestDTO shippingCodesReq) {
		GenericSpesification<ShippingCodes> genericSpesification = new GenericSpesification<ShippingCodes>();
		logger.info("Fetching  shipping codes");
		if (shippingCodesReq.getShipCode() != null) {
			genericSpesification.add(new SearchCriteria("shipCode", shippingCodesReq.getShipCode(), SearchOperation.MATCH));
		}
		if (shippingCodesReq.getShipName() != null) {
			genericSpesification.add(new SearchCriteria("shipName", shippingCodesReq.getShipName(), SearchOperation.MATCH));
		}
		if (shippingCodesReq.getLocationCode() != null) {
			genericSpesification
					.add(new SearchCriteria("locationCode", shippingCodesReq.getLocationCode(), SearchOperation.MATCH));
		}
		if (shippingCodesReq.getTrackUrl() != null) {
			genericSpesification.add(new SearchCriteria("trackUrl", shippingCodesReq.getTrackUrl(), SearchOperation.MATCH));
		}

		return shippingRepository.findAll(genericSpesification);
	}



}
