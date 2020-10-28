package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.VendorContactDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorContactDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorContactDetailsResponseDTO;
/**
 * 
 * Service class interface for Vendor Entity
 * 
 * @author vidya.p
 *
 */


public interface VendorContactService {

	/**
	 * This method creates new VendorContact
	 * @param VendorContactRequestDTO
	 * @return vendorContactResponseDTO
	 * @throws Exception 
	 */
	VendorContactDetailsResponseDTO saveVendorContact(VendorContactDetailsRequestDTO VendorContactRequestDTO)throws Exception;
	/**
	 * This method update  VendorContact
	 * @param VendorContact id,VendorContactRequestDTO
	 * @return vendorContactResponseDTO
	 * @throws Exception 
	 */
	
	VendorContactDetailsResponseDTO  updateVendorContact(Long id, VendorContactDetailsRequestDTO VendorContactRequestDTO)throws Exception;
	/**
	 * This method get  VendorContact by id
	 * @param VendorContact id
	 * @return vendorContactResponseDTO
	 * @throws Exception 
	 */
	
	VendorContactDetailsResponseDTO findVendorContactById(Long id)throws Exception;
	
	/**
	 * This method get all VendorContact 
	 * @return vendorContactResponseDTO list
	 * @throws Exception 
	 */
	List<VendorContactDetailsResponseDTO> findAllVendorContact()throws Exception;
	List<VendorContactDetails> fetchByVendorContactCtriteria(VendorContactDetailsRequestDTO vendorContactDetailsRequestDTO);
	
}
