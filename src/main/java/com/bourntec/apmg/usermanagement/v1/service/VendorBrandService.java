package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.VendorBrandDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorBrandDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorBrandDetailsResponseDTO;
/**
 * 
 * Service class interface for Vendor Entity
 * 
 * @author vidya.p
 *
 */


public interface VendorBrandService {

	/**
	 * This method creates new VendorBrand
	 * @param VendorBrandRequestDTO
	 * @return VendorBrandResponseDTO
	 * @throws Exception 
	 */
	VendorBrandDetailsResponseDTO saveVendorBrand(VendorBrandDetailsRequestDTO vendorBrandRequestDTO)throws Exception;
	/**
	 * This method update  VendorBrand
	 * @param VendorBrandRequestDTO
	 * @return VendorBrandResponseDTO
	 * @throws Exception 
	 */
	
	VendorBrandDetailsResponseDTO  updateVendorBrand(Long id, VendorBrandDetailsRequestDTO vendorBrandRequestDTO)throws Exception;
	/**
	 * This method get  VendorBrand by id
	 * @param VendorBrand id
	 * @return VendorBrandResponseDTO
	 * @throws Exception 
	 */
	
	VendorBrandDetailsResponseDTO findVendorBrandById(Long id)throws Exception;
	
	/**r
	 * This method get all VendorBrand 
	 * @return VendorBrandResponseDTO list
	 * @throws Exception 
	 */
	List<VendorBrandDetailsResponseDTO> findAllVendorBrand()throws Exception;
	List<VendorBrandDetails> findVendorBrandCriteria(VendorBrandDetailsRequestDTO vendorBrandRequestDTO);
	
}
