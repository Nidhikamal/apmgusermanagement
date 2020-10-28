package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.StateCodes;
import com.bourntec.apmg.entity.StateCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.StateCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.StateCodesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.StateCodesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.StateCodesRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.StateCodesService;

/**
 * 
 * Service class implementation for employee
 * 
 * @author Naveen Radakrishnan
 *
 */
@Service(value = "StateCodesServiceImpl")

public class StateCodesServiceImpl implements StateCodesService {

	private static final Logger logger = LogManager.getLogger(StateCodesServiceImpl.class);

	@Autowired
	private StateCodesRepository stateRepository;

	@Override
	public StateCodesResponseDTO savecustomerstate(StateCodesRequestDTO stateRequestDTO) {
		StateCodes code = new StateCodes();
		logger.info("Entering satate details {}", stateRequestDTO);
		StateCodesResponseDTO stateRespOnseDTO = new StateCodesResponseDTO();
		try {
			StateCodes bAccount = stateRequestDTO.toModel(stateRequestDTO);
			StateCodes emp = stateRepository.save(bAccount);
			if (emp != null) {
				logger.info("state Details is saved");
				BeanUtils.copyProperties(emp, stateRespOnseDTO);
				stateRespOnseDTO.setResponseMessage("state details is saved in DB");

			} else {

				stateRespOnseDTO.setResponseMessage("failed");

			}
		}

		catch (Exception e) {
			logger.error(" state save  failed" + e);

			throw e;
		}
		return stateRespOnseDTO;

	}

	@Override
	public StateCodesResponseDTO updatecustomerstate(String stateCode, StateCodesRequestDTO stateRequestDTO) {
		StateCodesResponseDTO updatedRespDTOStateCodes = new StateCodesResponseDTO();
		try {
			Optional<StateCodes> packingOptional = stateRepository.findById(stateCode);
			if (packingOptional.isPresent()) {
				StateCodes newShipCodes = stateRequestDTO.toModel(stateRequestDTO);
				newShipCodes.setStateCode(stateCode);
				StateCodes shippingEntity = stateRepository.save(newShipCodes);
				if (shippingEntity != null) {
					BeanUtils.copyProperties(shippingEntity, updatedRespDTOStateCodes);
					updatedRespDTOStateCodes.setResponseMessage("Updated  State code");
					logger.info("Updated  State code");
				} else {
					logger.error("State code updation failed");
					updatedRespDTOStateCodes = savecustomerstate(stateRequestDTO);

					// updatedRespDTOStateCodes.setResponseMessage("State code updation failed");
				}
			} else {
				updatedRespDTOStateCodes = savecustomerstate(stateRequestDTO);
			}
		} catch (Exception e) {
			logger.error("Update:updateStateCodes " + e);
			throw e;
		}

		return updatedRespDTOStateCodes;
	}

	@Override
	public StateCodesResponseDTO findBystateCode(String stateCode) {
		logger.info("Entering currencyCode  {}", stateCode);

		StateCodesResponseDTO stateCodesRespDTO = new StateCodesResponseDTO();
		try {
			logger.info("Fetching  Statecod");
			Optional<StateCodes> optionalShipping = stateRepository.findById(stateCode);
			if (optionalShipping.isPresent()) {
				StateCodes shippping = optionalShipping.get();
				BeanUtils.copyProperties(shippping, stateCodesRespDTO);
			} else {
				logger.error("Statecod doesn't exist");
				stateCodesRespDTO.setResponseMessage("Statecod doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch:getStateCodesById " + e);
			throw e;
		}
		return stateCodesRespDTO;
	}

	@Override
	public List<StateCodes> fetchAllstatcodeCode() {
		logger.info("Fetching all CurrencyCode  ...");

		return stateRepository.findAll();
	}

	@Override
	public List<StateCodes> fetchByCustomerstate(StateCodesRequestDTO brandReq) {
		GenericSpesification<StateCodes> genericSpesification = new GenericSpesification<StateCodes>();

		if (brandReq.getDisplayWeb() != null) {
			genericSpesification.add(new SearchCriteria("displayWeb", brandReq.getDisplayWeb(), SearchOperation.MATCH));
		}
		if (brandReq.getStateCode() != null) {
			genericSpesification.add(new SearchCriteria("stateCode", brandReq.getStateCode(), SearchOperation.MATCH));
		}
		if (brandReq.getStateName() != null) {
			genericSpesification.add(new SearchCriteria("stateName", brandReq.getStateName(), SearchOperation.MATCH));
		}
		if (brandReq.getCountryCode() != null) {
			genericSpesification
					.add(new SearchCriteria("countryCode", brandReq.getCountryCode().trim(), SearchOperation.MATCH));
		}

		return stateRepository.findAll(genericSpesification);
	}

	@Override
	public StateCodesResponseDTO deleteStateCode(String stateCode) {
		logger.info("Entering delete ....");
		StateCodesResponseDTO responseDTO = new StateCodesResponseDTO();
		try {
			Optional<StateCodes> stateCodeObj = stateRepository.findById(stateCode);
			if (!stateCodeObj.isPresent()) {
				logger.error("StateCodes doesn't exist");
				responseDTO.setResponseMessage("StateCodes doesn't exist");
				return responseDTO;
			}
			StateCodes dataRespDTO = stateCodeObj.get();
			if (dataRespDTO == null) {
				logger.info("The StateCodes doesn't exists!!!");
				responseDTO.setResponseMessage("The StateCodes doesn't exists!!!");
			} else {
				stateRepository.delete(dataRespDTO);
				responseDTO.setResponseMessage(" StateCodes deleted successfully");
			}
		} catch (Exception e) {
			logger.error("delete :delete StateCodesof StateCodesServiceImpl  " + e);
		}
		logger.info("Exiting delete StateCodes");
		return responseDTO;
	}

}
