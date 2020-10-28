package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CustData;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustDataResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.CustDataRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.CustDataService;

@Service(value = "CustDataServiceImpl")
public class CustDataServiceImpl implements CustDataService {

	private static final Logger logger = LogManager.getLogger(CustDataServiceImpl.class);

	@Autowired
	private CustDataRepository custDataRepository;

	public CustDataResponseDTO getCustDataById(String id) {
		CustDataResponseDTO custDataRespDTO = new CustDataResponseDTO();
		try {
			logger.info("Fetching Customer details....");
			Optional<CustData> customerOptional = custDataRepository.findById(id);
			if (customerOptional.isPresent()) {
				CustData custData = customerOptional.get();
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
	public CustDataResponseDTO saveCustData(CustDataRequestDTO custDataReqDTO) {

		CustDataResponseDTO custDataRespDTO = new CustDataResponseDTO();
		try {
			CustData custData = custDataReqDTO.toModel(custDataReqDTO);
			CustData custDataEntity = custDataRepository.save(custData);
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
	public CustDataResponseDTO updateCustData(String id, CustDataRequestDTO custReqDTO) {
		CustDataResponseDTO savedCustDataRespDTO = new CustDataResponseDTO();
		try {
			Optional<CustData> customerOptional = custDataRepository.findById(id);
			if (customerOptional.isPresent()) {
				CustData newCustomer = custReqDTO.toModel(custReqDTO);
				newCustomer.setCustNo(id);
				CustData custEntity = custDataRepository.save(newCustomer);
				if (custEntity != null) {
					BeanUtils.copyProperties(custEntity, savedCustDataRespDTO);
					savedCustDataRespDTO.setResponseMessage("Customer updated successfully");
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
	public List<CustData> findAllCustData() {
		logger.info("Fetching Customer data...");
		return custDataRepository.findAll();
	}

	public List<CustData> findCustDataByCriteria(CustDataRequestDTO custReqDTO) {
		GenericSpesification<CustData> genericSpesification = new GenericSpesification<CustData>();
		logger.info("Fetching Customer data...");
		if (custReqDTO.getCustNo() != null) {
			genericSpesification.add(new SearchCriteria("custNo", custReqDTO.getCustNo(), SearchOperation.MATCH));
		}
		if (custReqDTO.getCustName() != null) {
			genericSpesification.add(new SearchCriteria("custName", custReqDTO.getCustName(), SearchOperation.MATCH));
		}

		return custDataRepository.findAll(genericSpesification);
	}

	@Override
	public void deleteCustDataById(String id) {
		logger.info("Entering deleteCustData  {}", id);

		Optional<CustData> custList = custDataRepository.findById(id);
		CustData customerData = custList.get();
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
