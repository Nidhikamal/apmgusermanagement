package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CustDataShippingDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataShippingDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustDataShippinfDetailsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.CustDataShippingDetailsRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.CustDataShippingDetailsService;

@Service(value = "CustDataShippingDetailsServiceImpl")
public class CustDataShippingDetailsServiceImpl implements CustDataShippingDetailsService {

	private static final Logger logger = LogManager.getLogger(CustDataShippingDetailsServiceImpl.class);

	@Autowired
	private CustDataShippingDetailsRepository custDataRepository;

	public CustDataShippinfDetailsResponseDTO getCustShippingDetailsById(Long id) {
		CustDataShippinfDetailsResponseDTO custDataRespDTO = new CustDataShippinfDetailsResponseDTO();
		try {
			logger.info("Fetching Customer details....");
			Optional<CustDataShippingDetails> customerOptional = custDataRepository.findById(id);
			if (customerOptional.isPresent()) {
				CustDataShippingDetails custData = customerOptional.get();
				BeanUtils.copyProperties(custData, custDataRespDTO);
			} else {
				logger.error("Customer doesn't exist");
				custDataRespDTO.setResponseMessage("Customer doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch: getCustDataById" + e);
			throw e;
		}

		return custDataRespDTO;
	}

	/**
	 * This is the main method which is used to save Customerdata
	 * 
	 * 
	 * 
	 */
	public CustDataShippinfDetailsResponseDTO saveCustData(CustDataShippingDetailsRequestDTO custDataReqDTO) {

		CustDataShippinfDetailsResponseDTO custDataRespDTO = new CustDataShippinfDetailsResponseDTO();
		try {
			CustDataShippingDetails custData = custDataReqDTO.toModel(custDataReqDTO);
			CustDataShippingDetails custDataEntity = custDataRepository.save(custData);
			if (custDataEntity != null) {
				BeanUtils.copyProperties(custDataEntity, custDataRespDTO);
				logger.info("Customer saved successfully");
				custDataRespDTO.setResponseMessage("Customer saved successfully");
			} else {
				custDataRespDTO.setResponseMessage("Failed to save Customer");
				logger.error("Failed to save Customer ");
			}
		} catch (Exception e) {
			logger.error("Saving Customer" + e);
			throw e;
		}

		return custDataRespDTO;

	}

	/**
	 * This is the main method which is used to update Customer by Id
	 * 
	 */
	public CustDataShippinfDetailsResponseDTO updateCustData(Long id, CustDataShippingDetailsRequestDTO custReqDTO) {
		CustDataShippinfDetailsResponseDTO savedCustDataRespDTO = new CustDataShippinfDetailsResponseDTO();
		try {
			Optional<CustDataShippingDetails> customerOptional = custDataRepository.findById(id);
			if (customerOptional.isPresent()) {
				CustDataShippingDetails newCustomer = custReqDTO.toModel(custReqDTO);
				newCustomer.setCustShipId(id);
				CustDataShippingDetails custEntity = custDataRepository.save(newCustomer);
				if (custEntity != null) {
					BeanUtils.copyProperties(custEntity, savedCustDataRespDTO);
					savedCustDataRespDTO.setResponseMessage("customer update successfully");
					logger.info("Customer update successfully");
				} else {
					savedCustDataRespDTO.setResponseMessage("Customer updation failed");
					logger.info("Customer updation failed");
				}
			} else {
				logger.info("Customer doesn't exist");
				savedCustDataRespDTO.setResponseMessage("Customer doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update :updateCustomer" + e);
			throw e;
		}

		return savedCustDataRespDTO;
	}

	/**
	 * This is the main method which is used to get all customer data
	 */
	public List<CustDataShippingDetails> findAllCustShippingDetails() {
		logger.info("Fetching customer data...");
		return custDataRepository.findAll();
	}

	public List<CustDataShippingDetails> findCustDataByCriteria(CustDataShippingDetailsRequestDTO custReqDTO) {
		GenericSpesification<CustDataShippingDetails> genericSpesification = new GenericSpesification<CustDataShippingDetails>();
		logger.info("Fetching customer data...");
		if (custReqDTO.getCustNo() != null) {
			genericSpesification.add(new SearchCriteria("custNo", custReqDTO.getCustNo(), SearchOperation.MATCH));
		}
		if (custReqDTO.getCompanyName() != null) {
			genericSpesification
					.add(new SearchCriteria("compName", custReqDTO.getCompanyName(), SearchOperation.MATCH));
		}

		return custDataRepository.findAll(genericSpesification);
	}

	@Override
	public void deleteCustDataById(Long id) {
		logger.info("Entering deleteCustData  {}", id);

		Optional<CustDataShippingDetails> custList = custDataRepository.findById(id);
		CustDataShippingDetails customerData = custList.get();
		try {
			if (customerData == null) {
				logger.info("The Customer doesn't exists!!!");
			} else {
				custDataRepository.delete(customerData);
			}
			logger.info("Exiting deleteCustData");
		} catch (Exception e) {
			throw e;
		}

	}
}
