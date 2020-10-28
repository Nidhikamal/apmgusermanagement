package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CurrencyCode;
import com.bourntec.apmg.usermanagement.v1.dto.request.CurrencyCodeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CurrencyCodeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.CurrencyCodeRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.CurrencyCodeService;
@Service(value = "CurrencyCodeServiceImpl")

public class CurrencyCodeServiceImpl implements CurrencyCodeService {
	
	private static final Logger logger = LogManager.getLogger(CurrencyCodeServiceImpl.class);


	@Autowired
	private CurrencyCodeRepository currencyCodeRepository;

	/**
	 * @author naveen This is the main method which is used to save currencyCode
	 *         data
	 * 
	 */
	public CurrencyCodeResponseDTO currencyCodesave(CurrencyCodeRequestDTO currencyCodeRequestDTO) {

		logger.info("Entering currencyCode details {}", currencyCodeRequestDTO);

		CurrencyCodeResponseDTO currencyCodeResponseDTO = new CurrencyCodeResponseDTO();
		CurrencyCode currencyCode = new CurrencyCode();
		try {
			CurrencyCode curCode = currencyCodeRequestDTO.toModel(currencyCodeRequestDTO);
			CurrencyCode emp = currencyCodeRepository.save(curCode);
			if (emp != null) {
				logger.info("currencyCode Details is saved");
				BeanUtils.copyProperties(emp, currencyCodeResponseDTO);
			} else {
				logger.info("currencyCode is not persisted in DB");
				currencyCodeResponseDTO.setResponseMessage("currencyCode is persisted in DB");
			}
		} catch (Exception e) {
			logger.error(" currencyCode saved  failed" + e);

			throw e;
		}
		return currencyCodeResponseDTO;

	}

	/**
	 * @author naveen This is the main method which is used to update currencyCode
	 *  data
	 * 
	 */
	public CurrencyCodeResponseDTO currencyCodeupdate(String currencyCode,
			CurrencyCodeRequestDTO currencyCodeRequestDTO) {
		CurrencyCodeResponseDTO currencyCodeResponseDTO = new CurrencyCodeResponseDTO();
		try {
			Optional<CurrencyCode> packingOptional = currencyCodeRepository.findById(currencyCode);
			if (packingOptional.isPresent()) {
				CurrencyCode currencyCodes = currencyCodeRequestDTO.toModel(currencyCodeRequestDTO);
				currencyCodes.setCurrencyCode(currencyCode);
				CurrencyCode shippingEntity = currencyCodeRepository.save(currencyCodes);
				if (shippingEntity != null) {
					BeanUtils.copyProperties(shippingEntity, currencyCodeResponseDTO);
					currencyCodeResponseDTO.setResponseMessage("Updated  currency codes");
					logger.info("Updated  currency codes");
				} else {
					logger.error("currency codes updation failed");
					currencyCodeResponseDTO.setResponseMessage("currency codes updation failed");
				}
			} else {
				logger.error(" Shipping codes doesn't exist");
				currencyCodeResponseDTO.setResponseMessage(" currency codes doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update:updateShippingCodes " + e);
			throw e;
		}

		return currencyCodeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to get CurrencyCode
	 * 
	 */
	public List<CurrencyCode> findAllCurrencyCode() {
		logger.info("Fetching all CurrencyCode  ...");

		return currencyCodeRepository.findAll();
	}
	
	

	/**
	 * This method findBycurrencyCode
	 * 
	 * @param currencyCode
	 * @return CurrencyCodeResponseDTO
	 * @throws Exception
	 */
	public CurrencyCodeResponseDTO findBycurrencyCode(String currencyCode) {
		logger.info("Entering currencyCode  {}", currencyCode);

		CurrencyCodeResponseDTO currencyCodeResponseDTO = new CurrencyCodeResponseDTO();
		try {

			Optional<CurrencyCode> CurrencyCodeList = currencyCodeRepository.findById(currencyCode);
			if (CurrencyCodeList.isPresent()) {
				CurrencyCode CurrencyCodeEntity = CurrencyCodeList.get();
				BeanUtils.copyProperties(CurrencyCodeEntity, currencyCodeResponseDTO);
			}

		 else {
				logger.error("currencyCode  doesn't exist");
				currencyCodeResponseDTO.setResponseMessage("currencyCode  doesn't exist");
			}

		} catch (Exception e) {
			logger.error(" currencyCode failed" + e);
			throw e;
		}
		return currencyCodeResponseDTO;
	}

	@Override
	public List<CurrencyCode> fetchByCurrency(CurrencyCodeRequestDTO brandReq) {

		GenericSpesification<CurrencyCode> genericSpesification =
				new GenericSpesification<CurrencyCode>();
			
			 if(brandReq.getCurrencyCode()!=null) {
				 genericSpesification.add(new SearchCriteria("currencyCode",brandReq.getCurrencyCode(), SearchOperation.MATCH));
				}
				if(brandReq.getCurrencyName()!=null) {
		        genericSpesification.
		        add(new SearchCriteria("currencyName",brandReq.getCurrencyName(), SearchOperation.MATCH));
				}
				
			
			 return currencyCodeRepository.findAll(genericSpesification);
		}

	}
	




