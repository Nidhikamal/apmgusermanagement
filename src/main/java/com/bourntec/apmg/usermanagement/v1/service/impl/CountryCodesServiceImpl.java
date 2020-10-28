package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CountryCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.CountryCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CountryCodesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.CountryCodesRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.CountryCodesService;

/**
 * 
 * Service class implementation for employee
 * 
 * @author Naveen Radakrishnan
 *
 */
@Service(value = "CountryCodesServiceImpl")
public class CountryCodesServiceImpl implements CountryCodesService {

	private static final Logger logger = LogManager.getLogger(CountryCodesServiceImpl.class);

	@Autowired
	private CountryCodesRepository countryRepository;

	/**
	 * @author naveen This is the main method which is FETCH BY condition
	 * 
	 */

	public CountryCodesResponseDTO saveCustomerCountry(CountryCodesRequestDTO countryRequestDTO) {

		CountryCodesResponseDTO countrycodeResponseDTO = new CountryCodesResponseDTO();
		try {
			CountryCodes countryCodestomodel = countryRequestDTO.toModel(countryRequestDTO);

			CountryCodes country = countryRepository.save(countryCodestomodel);
			if (country != null) {
				BeanUtils.copyProperties(country, countrycodeResponseDTO);
				countrycodeResponseDTO.setResponseMessage("country details is saved in DB");

			} else {
				logger.error(" customer country to not saved  ");
			}
		} catch (Exception e) {
			logger.error(" saveCustomerCountry failed" + e);
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
	public CountryCodesResponseDTO updateCountry(String countryCode, CountryCodesRequestDTO countryRequestDTO) {
		CountryCodesResponseDTO updatedRespDTOCountryCodes = new CountryCodesResponseDTO();
		try {
			Optional<CountryCodes> packingOptional = countryRepository.findById(countryCode);
			if (packingOptional.isPresent()) {
				CountryCodes newShipCodes = countryRequestDTO.toModel(countryRequestDTO);
				newShipCodes.setCountryCode(countryCode);
				CountryCodes shippingEntity = countryRepository.save(newShipCodes);
				if (shippingEntity != null) {
					BeanUtils.copyProperties(shippingEntity, updatedRespDTOCountryCodes);
					updatedRespDTOCountryCodes.setResponseMessage("Updated  country codes");
					logger.info("Updated  country codes");
				} else {
					logger.error("country codes updation failed");
					updatedRespDTOCountryCodes.setResponseMessage("country codes updation failed");
				}
			} else {
				logger.error(" country codes doesn't exist");
				updatedRespDTOCountryCodes.setResponseMessage(" country codes doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update:updateCountryCodes " + e);
			throw e;
		}

		return updatedRespDTOCountryCodes;
	}

	/**
	 * This method findBycountryCode
	 * 
	 * @param countryCode
	 * @return CountrycodeResponseDTO
	 * @throws Exception
	 */

	public CountryCodesResponseDTO findBycountryCode(String countryCode) {

		logger.info("Entering countryCode  {}", countryCode);

		CountryCodesResponseDTO countryCodesRespDTO = new CountryCodesResponseDTO();
		try {
			logger.info("Fetching  country codes");
			Optional<CountryCodes> optionalShipping = countryRepository.findById(countryCode);
			if (optionalShipping.isPresent()) {
				CountryCodes shippping = optionalShipping.get();
				BeanUtils.copyProperties(shippping, countryCodesRespDTO);
			} else {
				logger.error("country codes doesn't exist");
				countryCodesRespDTO.setResponseMessage("country codes doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch:getCountryCodesById " + e);
			throw e;
		}
		return countryCodesRespDTO;

	}

	/**
	 * @author naveen This is the main method which is used to get all CountryCode
	 * 
	 */
	public List<CountryCodes> fetchAllCountryCode() {
		logger.info("Fetching all countrycode   ...");

		return countryRepository.findAll();
	}

	@Override
	public List<CountryCodes> fetchByCustomercountry(CountryCodesRequestDTO brandReq) {
		GenericSpesification<CountryCodes> genericSpesification = new GenericSpesification<CountryCodes>();

		if (brandReq.getCountryCode() != null) {
			genericSpesification
					.add(new SearchCriteria("countryCode", brandReq.getCountryCode(), SearchOperation.MATCH));
		}
		if (brandReq.getCountryName() != null) {
			genericSpesification
					.add(new SearchCriteria("countryName", brandReq.getCountryName(), SearchOperation.MATCH));
		}

		if (brandReq.getDisplayWeb() != null) {
			genericSpesification.add(new SearchCriteria("displayWeb", brandReq.getDisplayWeb(), SearchOperation.MATCH));
		}

		return countryRepository.findAll(genericSpesification);
	}

}
