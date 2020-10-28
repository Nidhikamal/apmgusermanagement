package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.VendorShippingDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorShippingDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorShippingDetailsResponseDTO;
/**
 * 
 * Service class interface for Vendor Entity
 * 
 * @author vidya.p
 *
 */


public interface VendorShippingService {

	/**
	 * This method creates new VendorShipping
	 * @param VendorShippingRequestDTO
	 * @return VendorShippingResponseDTO
	 * @throws Exception 
	 */
	VendorShippingDetailsResponseDTO saveVendorShipping(VendorShippingDetailsRequestDTO VendorShippingRequestDTO)throws Exception;
	/**
	 * This method update new VendorShipping
	 * @param VendorShipping id,VendorShippingRequestDTO
	 * @return VendorShippingResponseDTO
	 * @throws Exception 
	 */
	
	VendorShippingDetailsResponseDTO  updateVendorShipping(Long id, VendorShippingDetailsRequestDTO VendorShippingRequestDTO)throws Exception;
	/**
	 * This method get  VendorShipping by
	 * @param VendorShipping id
	 * @return VendorShippingResponseDTO
	 * @throws Exception 
	 */
	
	VendorShippingDetailsResponseDTO findVendorShippingById(Long id)throws Exception;
	
	/**r
	 * This method get all VendorShipping by
	 * @return VendorShippingResponseDTO list
	 * @throws Exception 
	 */
	List<VendorShippingDetailsResponseDTO> findAllVendorShipping()throws Exception;
	List<VendorShippingDetails> findVendorShippingByCriteria(VendorShippingDetailsRequestDTO vendorShippingDetailsRequestDTO);
	
}
