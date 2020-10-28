package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.RfidScanner;
import com.bourntec.apmg.usermanagement.v1.dto.request.RfidRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.RfidScannerResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.RfidScannerRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.RfidService;

/**
 * 
 * Service class implementation for employee Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Service(value = "RfidServiceImpl")
public class RfidServiceImpl implements RfidService {

	private static final Logger logger = LogManager.getLogger(RfidServiceImpl.class);

	@Autowired
	private RfidScannerRepository rfidRepository;

	/**
	 * @author amal This is the main method which is used to get Rfid By Id
	 */

	public RfidScannerResponseDTO getRfidById(Long id) {
		RfidScannerResponseDTO rfidResponceDTO = new RfidScannerResponseDTO();
		try {
			logger.info("Fetching  Rfids codes...");
			Optional<RfidScanner> optionalRfid = rfidRepository.findById(id);
			if (optionalRfid.isPresent()) {
				RfidScanner rfid = optionalRfid.get();
				BeanUtils.copyProperties(rfid, rfidResponceDTO);
			} else {
				logger.error("Rfid  doesn't exist");
				rfidResponceDTO.setResponseMessage("Rfid  doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch:getRfidById : " + e);
			throw e;
		}
		return rfidResponceDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all RfidScanner
	 */

	public List<RfidScanner> findAllRfidCodes() {
		logger.info("Fetching all Rfids codes ...");
		return rfidRepository.findAll();
	}

	/**
	 * @author amal This is the main method which is used to save RfidScanners
	 */

	public RfidScannerResponseDTO saveRfidCodes(RfidRequestDTO rfidCodesReq) {
		RfidScannerResponseDTO rfidResponseDTO = new RfidScannerResponseDTO();
		try {
			RfidScanner rfid = rfidCodesReq.toModel(rfidCodesReq);
			RfidScanner rfidEntity = rfidRepository.save(rfid);
			if (rfidEntity != null) {
				BeanUtils.copyProperties(rfidEntity, rfidResponseDTO);
				rfidResponseDTO.setResponseMessage("Saved all Rfids codes");
				logger.info("Saved all Rfids codes");
			} else {
				rfidResponseDTO.setResponseMessage("Failed to save Rfids");
				logger.error("Failed to save Rfids");
			}
		} catch (Exception e) {
			logger.error("Save:saveRfidCodes : " + e);
			throw e;
		}
		return rfidResponseDTO;
	}

	/**
	 * @author amal This is the main method which is used to update RfidScanners
	 */

	public RfidScannerResponseDTO updateRfidCodes(Long id, RfidRequestDTO rfidCodesReq) {
		RfidScannerResponseDTO updatedRfidRespDTO = new RfidScannerResponseDTO();
		try {
			Optional<RfidScanner> packingOptional = rfidRepository.findById(id);
			if (packingOptional.isPresent()) {
				RfidScanner newrfidCodes = rfidCodesReq.toModel(rfidCodesReq);
				newrfidCodes.setUniqueScannerId(id);
				RfidScanner rfidEntity = rfidRepository.save(newrfidCodes);
				if (rfidEntity != null) {
					BeanUtils.copyProperties(rfidEntity, updatedRfidRespDTO);
					logger.info("Updated  Rfids codes");
					updatedRfidRespDTO.setResponseMessage("Updated  Rfids codes");
				} else {
					logger.error("Rfids  update failed");
					updatedRfidRespDTO.setResponseMessage("Rfids  update failed");
				}
			} else {
				logger.error("Rfids doesn't exist");
				updatedRfidRespDTO.setResponseMessage("Failed");
			}
		} catch (Exception e) {
			logger.error("Update:updateRfidCodes " + e);
			throw e;
		}

		return updatedRfidRespDTO;
	}

	public List<RfidScanner> findRfidDataByCriteria(RfidRequestDTO rfidCodesReq) {
		GenericSpesification<RfidScanner> genericSpesification = new GenericSpesification<RfidScanner>();
		logger.info("Fetching  Rfids codes ...");
		if (rfidCodesReq.getUniqueScannerId()!= null) {
			genericSpesification.add(new SearchCriteria("uniqueScannerId", rfidCodesReq.getUniqueScannerId(), SearchOperation.MATCH));
		}
		if (rfidCodesReq.getRfidScannerName() != null) {
			genericSpesification.add(new SearchCriteria("rfidScannerName", rfidCodesReq.getRfidScannerName(), SearchOperation.MATCH));
		}
		if (rfidCodesReq.getRfidScannerId()!= null) {
			genericSpesification
					.add(new SearchCriteria("rfidScannerId", rfidCodesReq.getRfidScannerId(), SearchOperation.MATCH));
		}
		if (rfidCodesReq.getRfidScannerStatus() != null) {
			genericSpesification.add(new SearchCriteria("rfidScannerStatus", rfidCodesReq.getRfidScannerStatus(), SearchOperation.MATCH));
		}
		if (rfidCodesReq.getDescription() != null) {
			genericSpesification.add(new SearchCriteria("description", rfidCodesReq.getDescription(), SearchOperation.MATCH));
		}

		return rfidRepository.findAll(genericSpesification);
	}

}
