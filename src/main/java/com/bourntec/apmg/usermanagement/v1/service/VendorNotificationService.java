package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.VendorNotification;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorNotificationRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorNotificationResponseDTO;
/**
 * 
 * Service class interface for Vendor Entity
 * 
 * @author vidya.p
 *
 */


public interface VendorNotificationService {

	/**
	 * This method creates new VendorDataNotification
	 * @param VendorDataNotificationRequestDTO
	 * @return VendorDataNotificationResponseDTO
	 * @throws Exception 
	 */
	VendorNotificationResponseDTO save(VendorNotificationRequestDTO VendorDataNotificationRequestDTO)throws Exception;
	/**
	 * This method update new VendorDataNotification
	 * @param vendor id,VendorDataNotificationRequestDTO
	 * @return VendorDataNotificationResponseDTO
	 * @throws Exception 
	 */
	
	VendorNotificationResponseDTO  update(String id, VendorNotificationRequestDTO VendorDataNotificationRequestDTO)throws Exception;
	/**
	 * This method get  VendorDataNotification by
	 * @param vendor id
	 * @return VendorDataNotificationResponseDTO
	 * @throws Exception 
	 */
	
	VendorNotificationResponseDTO findById(String id)throws Exception;
	
	/**r
	 * This method get all VendorDataNotification by
	 * @return VendorDataNotificationResponseDTO list
	 * @throws Exception 
	 */
	List<VendorNotificationResponseDTO> findAll()throws Exception;
	
	List<VendorNotification> findByCriteria(VendorNotificationRequestDTO vendorNotificationRequestDTO);
	
}
