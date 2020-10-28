package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CustData2;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustData2RequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustData2ResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.CustData2Repository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.CustData2Service;

@Service(value = "CustData2ServiceImpl")
public class CustData2ServiceImpl implements CustData2Service {

	private static final Logger logger = LogManager.getLogger(CustData2ServiceImpl.class);

	@Autowired
	private CustData2Repository custDataRepository;

	public CustData2ResponseDTO getCustDataById(String id) {
		CustData2ResponseDTO custDataRespDTO = new CustData2ResponseDTO();
		try {
			logger.info("Fetching Customer details....");
			Optional<CustData2> customerOptional = custDataRepository.findById(id);
			if (customerOptional.isPresent()) {
				CustData2 custData = customerOptional.get();
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
	public CustData2ResponseDTO saveCustData(CustData2RequestDTO custDataReqDTO) {

		CustData2ResponseDTO custDataRespDTO = new CustData2ResponseDTO();
		try {
			CustData2 custData = custDataReqDTO.toModel(custDataReqDTO);
			CustData2 custDataEntity = custDataRepository.save(custData);
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
	public CustData2ResponseDTO updateCustData(String id, CustData2RequestDTO custReqDTO) {
		CustData2ResponseDTO savedCustDataRespDTO = new CustData2ResponseDTO();
		try {
			Optional<CustData2> customerOptional = custDataRepository.findById(id);
			if (customerOptional.isPresent()) {
				CustData2 newCustomer = custReqDTO.toModel(custReqDTO);
				newCustomer.setCustNo(id);
				CustData2 custEntity = custDataRepository.save(newCustomer);
				if (custEntity != null) {
					BeanUtils.copyProperties(custEntity, savedCustDataRespDTO);
					savedCustDataRespDTO.setResponseMessage("Customer update successfully");
					logger.info("Customer update successfully");
				} else {
					savedCustDataRespDTO.setResponseMessage("Customer updation failed");
					logger.info("Customer updation failed");
				}
			} else {
				logger.info("customer doesn't exist");
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
	public List<CustData2> findAllCustData() {
		logger.info("Fetching customer data...");
		return custDataRepository.findAll();
	}

	public List<CustData2> findCustDataByCriteria(CustData2RequestDTO custReqDTO) {
		GenericSpesification<CustData2> genericSpesification = new GenericSpesification<CustData2>();
		logger.info("Fetching customer data...");
		if (custReqDTO.getCustNo() != null) {
			genericSpesification.add(new SearchCriteria("custNo", custReqDTO.getCustNo(), SearchOperation.MATCH));
		}
		if (custReqDTO.getLocationCode() != null) {
			genericSpesification
					.add(new SearchCriteria("locCode", custReqDTO.getLocationCode(), SearchOperation.MATCH));
		}

		return custDataRepository.findAll(genericSpesification);
	}

	@Override
	public void deleteCustDataById(String id) {
		logger.info("Entering deleteCustData  {}", id);

		Optional<CustData2> custList = custDataRepository.findById(id);
		CustData2 customerData = custList.get();
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
