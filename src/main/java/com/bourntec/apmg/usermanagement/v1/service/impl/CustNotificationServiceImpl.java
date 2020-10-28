package com.bourntec.apmg.usermanagement.v1.service.impl;


import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CustNotification;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustNotificationRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustNotificationResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.CustNotificationRepository;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.CustNotificationService;


@Service(value = "CustNotificationServiceImpl")
public class CustNotificationServiceImpl implements CustNotificationService{
	
	private static final Logger logger = LogManager.getLogger(CustNotificationServiceImpl.class);
	
	@Autowired
	private CustNotificationRepository custNotificationRepository;
	
	/**
	 * This method is used to save CustNotification data
	 * 
	 */
	public CustNotificationResponseDTO saveCustNotification(CustNotificationRequestDTO custNotificationRequestDTO) {

		logger.info("Entering CustNotification details {}", custNotificationRequestDTO);
		CustNotificationResponseDTO custNotificationResponseDTO = new CustNotificationResponseDTO();
		try {
			CustNotification custNotification = custNotificationRequestDTO.toModel(custNotificationRequestDTO);
			CustNotification custNotifictn = custNotificationRepository.save(custNotification);
			if (custNotifictn != null) {
				logger.info("CustNotification Details is saved");
				BeanUtils.copyProperties(custNotifictn, custNotificationResponseDTO);
			} else {
				logger.info("CustNotification is not saved in DB");
				custNotificationResponseDTO.setResponseMessage("CustNotification is not in DB");
			}
		}catch (Exception e) {
			logger.error(" CustNotification save  failed" + e);

			throw e;
		}
		return custNotificationResponseDTO;
	}
	
	
	/**
	 * This method is used to update CustNotification data
	 * 
	*/
	public CustNotificationResponseDTO updateCustNotification(String custNo, CustNotificationRequestDTO custNotificationRequestDTO) {

		logger.info("Entering updateCustNotification", custNotificationRequestDTO);
		Optional<CustNotification> custNotificationList = custNotificationRepository.findById(custNo);

		CustNotification custNotification = custNotificationList.get();

		CustNotificationResponseDTO custNotificationResponsedto = new CustNotificationResponseDTO();

		try {

			if (custNotification == null) {
				logger.info("The CustNotification doesn't exists!!!");
				custNotificationResponsedto.setResponseMessage("The CustNotification doesn't exists");
				return custNotificationResponsedto;
			} else {

				CustNotification custNotifictn = custNotificationRequestDTO.toModel(custNotificationRequestDTO);

				custNotifictn.setCustNo(custNo);
				CustNotification customerData = custNotificationRepository.save(custNotifictn);
				logger.info("CustNotification Details is updated");

				BeanUtils.copyProperties(customerData, custNotificationResponsedto);
				custNotificationResponsedto.setResponseMessage("CustNotification is updated in DB");

				logger.info("Exiting updateCustNotification");
			}
		} catch (Exception e) {
			logger.error(" CustNotificationServiceImpl updateCustNotification  failed" + e);

			throw e;
		}
		return custNotificationResponsedto;
	}
	
	
	/**
	 * This method is used to list all CustNotification data
	 * 
	*/
	public List<CustNotification> findAllCustNotifications() {
		logger.info("Fetching all CustNotification  ...");
		return custNotificationRepository.findAll();
	}
	
	
	/**
	 * This method is used to list CustNotification data
	 * 
	*/
	public CustNotificationResponseDTO findByCustNotification(String custNo) {
		
		logger.info("Entering findByCustNotification  {}", custNo);

		CustNotificationResponseDTO custNotificationResponsedto = new CustNotificationResponseDTO();
		try {

			Optional<CustNotification> custNotificationList = custNotificationRepository.findById(custNo);
			CustNotification custNotification = custNotificationList.get();

			if (custNotification != null) {
				BeanUtils.copyProperties(custNotification, custNotificationResponsedto);
			} else {
				throw new ResourceNotFoundException("Requested CustNotification is not exist");
			}
			logger.info("Exiting findByCustNotification  {}", custNo);
		} catch (Exception e) {
			logger.error("CustNotificationServiceImpl findByCustNotification failed" + e);

			throw e;
		}
		return custNotificationResponsedto;
	}
	
	
	/**
	 * This method is used to list CustNotification data by search criteria
	 * 
	*/
	public List<CustNotification> fetchByCustNotification(CustNotificationRequestDTO custNotificationRequestDTO) {
		
		GenericSpesification<CustNotification> genericSpesification = new GenericSpesification<CustNotification>();
		
		if (custNotificationRequestDTO.getCustNo() != null && !custNotificationRequestDTO.getCustNo().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("custNo", custNotificationRequestDTO.getCustNo(), SearchOperation.EQUAL));
		}
		if (custNotificationRequestDTO.getDesc1() != null && !custNotificationRequestDTO.getDesc1().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("desc1", custNotificationRequestDTO.getDesc1(), SearchOperation.MATCH));
		}
		return custNotificationRepository.findAll(genericSpesification);
	}
	
	
	/**
	 * This method is used to Delete CustNotification data from Database
	 * 
	*/
	public CustNotificationResponseDTO deleteCustNotification(String custNo) {
		
		logger.info("Entering deleteCustNotification  {}", custNo);
		
		CustNotificationResponseDTO custNotificationResponseDTO= new CustNotificationResponseDTO();
		Optional<CustNotification> custNotificationList = custNotificationRepository.findById(custNo);
		CustNotification custNotification = custNotificationList.get();
		try {
			if (custNotification == null) {
				logger.info("The CustNotification doesn't exists!!!");
			} else {
				custNotificationRepository.delete(custNotification);
				logger.info("Customer Notification Deleted Successfully!!!");
				custNotificationResponseDTO.setResponseMessage("Customer Notification Deleted Successfully!!!");
			}
			logger.info("Exiting deleteCustNotification");
		} catch (Exception e) {
			throw e;
		}
		return custNotificationResponseDTO;
	}
	
}
