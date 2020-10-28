package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.LabourCharge;
import com.bourntec.apmg.usermanagement.v1.dto.request.LabourChargeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.LabourChargeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.LabourChargeRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.LabourService;

@Service(value = "LabourServiceImpl")

public class LabourServiceImpl implements LabourService {

	private static final Logger logger = LogManager.getLogger(CodesLocationServiceImpl.class);

	@Autowired
	private LabourChargeRepository labourChargeRepository;

	/**
	 * @author naveen This is the main method which is used to save LabourCharge
	 *         data
	 * 
	 */
	public LabourChargeResponseDTO savelabour(LabourChargeRequestDTO labourChargeRequestDTO) {

		LabourChargeResponseDTO labourChargeResponseDTO = new LabourChargeResponseDTO();
		try {
			LabourCharge labourCharge = labourChargeRequestDTO.toModel(labourChargeRequestDTO);
			LabourCharge labourCharges = labourChargeRepository.save(labourCharge);
			if (labourCharges != null) {
				logger.info("labourCharges details is saved");
				BeanUtils.copyProperties(labourCharges, labourChargeResponseDTO);
				labourChargeResponseDTO.setResponseMessage("passed");
			} else {
				logger.info("labourCharges is not saved in DB");
			}
		} catch (Exception e) {
			logger.error(" savelabours ls failed" + e);
			labourChargeResponseDTO.setResponseMessage("failed");

			throw e;
		}
		return labourChargeResponseDTO;

	}

	/**
	 * @author naveen This is the main method which is used to update LabourCharge
	 *         data
	 * 
	 */

	public LabourChargeResponseDTO updatelabour(Long id, LabourChargeRequestDTO labourChargeRequestDTO) {
		LabourChargeResponseDTO updatedRespDTOLabourCharge = new LabourChargeResponseDTO();
		try {
			Optional<LabourCharge> packingOptional = labourChargeRepository.findById(id);
			if (packingOptional.isPresent()) {
				LabourCharge newShipCodes = labourChargeRequestDTO.toModel(labourChargeRequestDTO);
				newShipCodes.setId(id);
				LabourCharge shippingEntity = labourChargeRepository.save(newShipCodes);
				if (shippingEntity != null) {
					BeanUtils.copyProperties(shippingEntity, updatedRespDTOLabourCharge);
					updatedRespDTOLabourCharge.setResponseMessage("Updated  Laborcharge");
					logger.info("Updated  Laborcharge");
				} else {
					logger.error("Laborcharge updation failed");
					updatedRespDTOLabourCharge.setResponseMessage("Laborcharge updation failed");
				}
			} else {
				logger.error(" Laborcharge doesn't exist");
				updatedRespDTOLabourCharge.setResponseMessage(" Laborcharge doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update:updateLabourCharge " + e);
			throw e;
		}

		return updatedRespDTOLabourCharge;
	}

	/**
	 * This method findBylabourid
	 * 
	 * @param id
	 * @return LabourChargeResponseDTO
	 * @throws Exception
	 */
	public LabourChargeResponseDTO findBylabourid(Long id) {

		logger.info("Entering id  {}", id);


		LabourChargeResponseDTO laourChargeResponseDTO = new LabourChargeResponseDTO();
		try {
			logger.info("Fetching  LabourCharge");
			Optional<LabourCharge> optionalShipping = labourChargeRepository.findById(id);
			if (optionalShipping.isPresent()) {
				LabourCharge shippping = optionalShipping.get();
				BeanUtils.copyProperties(shippping, laourChargeResponseDTO);
			} else {
				logger.error("LabourCharge doesn't exist");
				laourChargeResponseDTO.setResponseMessage("LabourCharge doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch:getLabourChargeById " + e);
			throw e;
		}
		return laourChargeResponseDTO;

	}

	/**
	 * @author naveen This is the main method which is used to get all Labourcharge
	 * 
	 */
	public List<LabourCharge> findAllLabours() {
		logger.info("Fetching all Labour details  ...");
		return labourChargeRepository.findAll();
	}

	@Override
	public List<LabourCharge> fetchByLabour(LabourChargeResponseDTO brandReq) {
		GenericSpesification<LabourCharge> genericSpesification = new GenericSpesification<LabourCharge>();

		if (brandReq.getAmount() != null) {
			genericSpesification.add(new SearchCriteria("amount", brandReq.getAmount(), SearchOperation.EQUAL));
		}
		if (brandReq.getLaborName() != null) {
			genericSpesification.add(new SearchCriteria("laborName", brandReq.getLaborName(), SearchOperation.MATCH));
		}

		if (brandReq.getId() != null) {
			genericSpesification.add(new SearchCriteria("id", brandReq.getId(), SearchOperation.EQUAL));
		}

		return labourChargeRepository.findAll(genericSpesification);
	}

}
