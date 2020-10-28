package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CodesPacking;
import com.bourntec.apmg.usermanagement.v1.dto.request.CodesPackingRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CodesPackingResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.CodesPackingRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.CodesPackingService;

/**
 * 
 * Service class implementation for employee Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Service(value = "CodesPackingServiceImpl")
public class CodesPackingServiceImpl implements CodesPackingService {

	private static final Logger logger = LogManager.getLogger(CodesPackingServiceImpl.class);

	@Autowired
	private CodesPackingRepository codesPackingRepository;

	/**
	 * @author amal This is the main method which is used to get packing codes by Id
	 */

	public CodesPackingResponseDTO getPackingCodesById(String id) {
		CodesPackingResponseDTO packingRespDTO = new CodesPackingResponseDTO();
		try {
			logger.info("Fetching  arrivals ...");
			Optional<CodesPacking> optionalPacking = codesPackingRepository.findById(id);
			if (optionalPacking.isPresent()) {
				CodesPacking packing = optionalPacking.get();
				BeanUtils.copyProperties(packing, packingRespDTO);
			} else {
				logger.error("Packing codes doesn't exist");
				packingRespDTO.setResponseMessage("Packing codes doesn't exist");
			}
		} catch (Exception e) {
			packingRespDTO.setResponseMessage("Failed");
			logger.error("Fetch: getPackingCodesById" + e);
			throw e;
		}
		return packingRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all packing codes
	 */
	public List<CodesPacking> findAllPackingCodes() {
		logger.info("Fetching all PackingCodes ...");
		return codesPackingRepository.findAll();
	}

	/**
	 * @author amal This is the main method which is used to save packing codes
	 */
	public CodesPackingResponseDTO savePackingCodes(CodesPackingRequestDTO packingCodesReq) {
		CodesPackingResponseDTO packingRespDTO = new CodesPackingResponseDTO();
		try {
			CodesPacking packing = packingCodesReq.toModel(packingCodesReq);
			CodesPacking packingEntity = codesPackingRepository.save(packing);
			if (packingEntity != null) {
				BeanUtils.copyProperties(packingEntity, packingRespDTO);
				packingRespDTO.setResponseMessage("Saved  packing codes");
				logger.info("Saved  packing codes");
			} else {
				packingRespDTO.setResponseMessage("Failed to save packing codes");
				logger.error("Failed to save packing codes");
			}
		} catch (Exception e) {
			logger.error("Save:savePackingCodes" + e);
			throw e;
		}
		return packingRespDTO;
	}

	/**
	 * 
	 * @author amal This is the main method which is used to update packing codes
	 */

	public CodesPackingResponseDTO updatePackingCodes(String id, CodesPackingRequestDTO packingCodesReq) {
		CodesPackingResponseDTO savedPackingCodesRespDTO = new CodesPackingResponseDTO();
		try {
			Optional<CodesPacking> packingOptional = codesPackingRepository.findById(id);
			if (packingOptional.isPresent()) {
				CodesPacking newPackCodes = packingCodesReq.toModel(packingCodesReq);
				newPackCodes.setPackingId(id);
				CodesPacking packingEntity = codesPackingRepository.save(newPackCodes);
				if (packingEntity != null) {
					BeanUtils.copyProperties(packingEntity, savedPackingCodesRespDTO);
					savedPackingCodesRespDTO.setResponseMessage("Updated  packing codes");
					logger.info("Updated  packing codes");
				} else {
					savedPackingCodesRespDTO.setResponseMessage("Packing codes updation failed");
					logger.error("Packing codes updation failed");
				}
			} else {
				logger.error("Packing codes doesn't exist");
				savedPackingCodesRespDTO.setResponseMessage("Packing codes doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update:updatePackingCodes:" + e);
			throw e;
		}

		return savedPackingCodesRespDTO;
	}

	public List<CodesPacking> findPackingCodesByCriteria(CodesPackingRequestDTO packingCodesReq) {
		GenericSpesification<CodesPacking> genericSpesification = new GenericSpesification<CodesPacking>();
		logger.info("Fetching all PackingCodes ...");
		if (packingCodesReq.getPackingId() != null) {
			genericSpesification
					.add(new SearchCriteria("packingId", packingCodesReq.getPackingId(), SearchOperation.MATCH));
		}
		if (packingCodesReq.getPackingName() != null) {
			genericSpesification
					.add(new SearchCriteria("packingName", packingCodesReq.getPackingName(), SearchOperation.MATCH));
		}
		if (packingCodesReq.getExtRemarks() != null) {
			genericSpesification
					.add(new SearchCriteria("extRemarks", packingCodesReq.getExtRemarks(), SearchOperation.MATCH));
		}
		if (packingCodesReq.getIntRemarks() != null) {
			genericSpesification
					.add(new SearchCriteria("intRemarks", packingCodesReq.getIntRemarks(), SearchOperation.MATCH));
		}

		return codesPackingRepository.findAll(genericSpesification);
	}

}
