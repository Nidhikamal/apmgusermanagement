package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.VendorData;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorDataResponseDTO;
/**
 * 
 * Service class interface for Vendor Entity
 * 
 * @author vidya.p
 *
 */


public interface VendorDataService {

	/**
	 * This method creates new VendorData
	 * @param vendorDataRequestDTO
	 * @return VendorDataResponseDTO
	 * @throws Exception 
	 */
	VendorDataResponseDTO saveVendorData(VendorDataRequestDTO vendorDataRequestDTO)throws Exception;
	/**
	 * This method update  VendorData
	 * @param vendor id,vendorDataRequestDTO
	 * @return VendorDataResponseDTO
	 * @throws Exception 
	 */
	
	VendorDataResponseDTO  updateVendorData(String id, VendorDataRequestDTO vendorDataRequestDTO)throws Exception;
	/**
	 * This method get  VendorData by id
	 * @param vendor id
	 * @return VendorDataResponseDTO
	 * @throws Exception 
	 */
	
	VendorDataResponseDTO findVendorDataById(String id)throws Exception;
	
	/**
	 * This method get all VendorData by
	 * @return VendorDataResponseDTO list
	 * @throws Exception 
	 */
	List<VendorDataResponseDTO> findAllVendorData()throws Exception;
	
	/**
	 * This method get search
	 * @return VendorDataResponseDTO list
	 * @throws Exception 
	 */
	List<VendorData> findVendorDataByCriteria(VendorDataRequestDTO vendorDataRequestDTO)throws Exception;
	
}
