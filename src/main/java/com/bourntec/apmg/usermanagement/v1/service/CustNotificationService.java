package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CustNotification;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustNotificationRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustNotificationResponseDTO;

public interface CustNotificationService {
	
	CustNotificationResponseDTO saveCustNotification(CustNotificationRequestDTO custNotificationRequestDTO);
	
	List<CustNotification> findAllCustNotifications();
	
	CustNotificationResponseDTO findByCustNotification(String custNo);
	
	CustNotificationResponseDTO updateCustNotification(String custNo, CustNotificationRequestDTO custNotificationRequestDTO);
	
	List<CustNotification> fetchByCustNotification(CustNotificationRequestDTO custNotificationRequestDTO);
	
	CustNotificationResponseDTO deleteCustNotification(String custNo);
	 
}
