package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CountryCodes;
import com.bourntec.apmg.entity.LocationEmployee;
import com.bourntec.apmg.entity.CodesLocation;
import com.bourntec.apmg.usermanagement.v1.dto.request.CountryCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.CodesLocationRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CodesLocationResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.BankAccountRepository;
import com.bourntec.apmg.usermanagement.v1.repository.BrandRepository;
import com.bourntec.apmg.usermanagement.v1.repository.BrokersRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CodesPackingRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CompanyDataRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CountryCodesRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CreditcardRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CurrencyCodeRepository;
import com.bourntec.apmg.usermanagement.v1.repository.FaqDetailsRepository;
import com.bourntec.apmg.usermanagement.v1.repository.IncidentsRepository;
import com.bourntec.apmg.usermanagement.v1.repository.LabourChargeRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CodesLocationRepository;
import com.bourntec.apmg.usermanagement.v1.repository.MerchandiseCategoryRepository;
import com.bourntec.apmg.usermanagement.v1.repository.NewArrivalsRepository;
import com.bourntec.apmg.usermanagement.v1.repository.ParcelRepository;
import com.bourntec.apmg.usermanagement.v1.repository.PaymentTermsRepository;
import com.bourntec.apmg.usermanagement.v1.repository.PotentialCustomerGroupRepository;
import com.bourntec.apmg.usermanagement.v1.repository.RfidScannerRepository;
import com.bourntec.apmg.usermanagement.v1.repository.ShippingCodesRepository;
import com.bourntec.apmg.usermanagement.v1.repository.StateCodesRepository;
import com.bourntec.apmg.usermanagement.v1.repository.VendorCountryCodesRepository;
import com.bourntec.apmg.usermanagement.v1.repository.VendorStateCodesRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.CodesLocationService;
@Service(value = "CodesLocationServiceImpl")

public class CodesLocationServiceImpl  implements CodesLocationService {
	
	private static final Logger logger = LogManager.getLogger(CodesLocationServiceImpl.class);
	@Autowired
	private CodesLocationRepository locationCodeRepository;

	

	/**
	 * @author naveen This is the main method which is used to save LocationCode
	 *         data
	 * 
	 */
	public CodesLocationResponseDTO saveLocationCode(CodesLocationRequestDTO locationCodeRequestDTO) {

		CodesLocationResponseDTO locationCodeResponseDTO = new CodesLocationResponseDTO();
		try {
			CodesLocation locationCode = locationCodeRequestDTO.toModel(locationCodeRequestDTO);
			CodesLocation locationCodes = locationCodeRepository.save(locationCode);
			if (locationCodes != null) {
				logger.info("locationCodes details  is saved");
				BeanUtils.copyProperties(locationCodes, locationCodeResponseDTO);
				locationCodeResponseDTO.setResponseMessage("state details is updated in DB");

			} else {
				logger.info("locationCodes  details is not saved in DB");
			}

		} catch (Exception e) {
			logger.error(" saveLocationCode  failed" + e);
			throw e;
		}

		return locationCodeResponseDTO;

	}

	/**
	 * @author naveen This is the main method which is used to update LocationCode
	 *         data
	 * 
	 */

	public CodesLocationResponseDTO updateLocationCode(String locationCode,
			CodesLocationRequestDTO locationCodeRequestDTO) {
		Optional<CodesLocation> locationCodeList = locationCodeRepository.findById(locationCode);
		CodesLocation lcodes = locationCodeList.get();
		CodesLocationResponseDTO locationCodeResponseDTO = new CodesLocationResponseDTO();

		try {
			if (lcodes == null) {
				logger.info("The locationCode doesn't exists!!!");
				locationCodeResponseDTO.setResponseMessage("The locationCode doesn't exists");
			} else {

				CodesLocation lcode = locationCodeRequestDTO.toModel(locationCodeRequestDTO);
				lcode.setLocationCode(locationCode);

				CodesLocation countryCodesSave = locationCodeRepository.save(lcode);
				logger.info("locationCode Details is updated");

				BeanUtils.copyProperties(countryCodesSave, locationCodeResponseDTO);
				locationCodeResponseDTO.setResponseMessage("LocationCode details is updated in DB");
			}
		} catch (Exception e) {
			logger.error(" locationCode updates ls failed" + e);

			throw e;
		}
		return locationCodeResponseDTO;
	}
	

	/**
	 * This method findBylocationCode
	 * 
	 * @param locationCode
	 * @return LocationCodeResponseDTO
	 * @throws Exception
	 */
	public CodesLocationResponseDTO findBylocationCode(String locationCode) {

		logger.info("Entering locationCode  {}", locationCode);

		CodesLocationResponseDTO locationCodeResponseDTO = new CodesLocationResponseDTO();
		try {

			Optional<CodesLocation> locationCodeList = locationCodeRepository.findById(locationCode);
			if (locationCodeList.isPresent()) {
				CodesLocation lcodes = locationCodeList.get();
				BeanUtils.copyProperties(lcodes, locationCodeResponseDTO);
			} else {
				logger.error("Location Code codes doesn't exist");
				locationCodeResponseDTO.setResponseMessage("Location Code doesn't exist");
			}
			


		} catch (Exception e) {
			logger.error(" locationCode failed" + e);
			throw e;
		}
		return locationCodeResponseDTO;

	}

	/**
	 * @author naveen This is the main method which is used to get all Locationcode
	 * 
	 */
	public List<CodesLocation> findAllLocationcode() {
		logger.info("Fetching all LocationCode details  ...");

		return locationCodeRepository.findAll();
	}
	
	

	@Override
	public List<CodesLocation> fetchByLocationCode(CodesLocationRequestDTO brandReq) {
	GenericSpesification<CodesLocation> genericSpesification = new GenericSpesification<CodesLocation>();
		
		if(brandReq.getLocationCode()!=null) {
			 genericSpesification.add(new SearchCriteria("locationCode",brandReq.getLocationCode(), SearchOperation.MATCH));
			}
			if(brandReq.getLocationName()!=null) {
	        genericSpesification.add(new SearchCriteria("locationCode",brandReq.getLocationName(), SearchOperation.MATCH));
			}
			
		
		 return locationCodeRepository.findAll(genericSpesification);
	}


}
