package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.usermanagement.v1.dto.request.VendorDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorDataResponseDTO;
/**
 * 
 * Service class interface for Vendor Entity
 * 
 * @author vidya.p
 *
 */


public interface VendorService {

	/**
	 * This method creates new VendorData
	 * @param vendorDataRequestDTO
	 * @return VendorDataResponseDTO
	 * @throws Exception 
	 */
	VendorDataResponseDTO saveVendor(VendorDataRequestDTO vendorDataRequestDTO)throws Exception;
	/**
	 * This method update new VendorData
	 * @param vendor id,vendorDataRequestDTO
	 * @return VendorDataResponseDTO
	 * @throws Exception 
	 */
	
	VendorDataResponseDTO  updateVendor(String id, VendorDataRequestDTO vendorDataRequestDTO)throws Exception;
	/**
	 * This method get  VendorData by
	 * @param vendor id
	 * @return VendorDataResponseDTO
	 * @throws Exception 
	 */
	
	VendorDataResponseDTO findVendorById(String id)throws Exception;
	
	/**r
	 * This method get all VendorData by
	 * @return VendorDataResponseDTO list
	 * @throws Exception 
	 */
	List<VendorDataResponseDTO> findAllVendor()throws Exception;
	
}
