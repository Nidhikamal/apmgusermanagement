package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.VendorBrandDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorBrandDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorBrandDetailsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.VendorBrandrepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.VendorBrandService;

@Service(value="VendorBrandServiceImpl")
public class VendorBrandServiceImpl implements VendorBrandService {
	@Autowired
	VendorBrandrepository vendorBrandrepository;

	private static final Logger logger = LogManager.getLogger(VendorBrandServiceImpl.class);

	/**
	 * This method creates new VendorBrand
	 * @param VendorvendorBrandRequestDTOuestDTO
	 * @return VendorBrandResponseDTO
	 * @throws Exception 
	 */

	public VendorBrandDetailsResponseDTO saveVendorBrand(VendorBrandDetailsRequestDTO vendorvendorBrandRequestDTOuestDTO) throws Exception {		
		VendorBrandDetailsResponseDTO vendorBrandDetailsResponseDTO = new VendorBrandDetailsResponseDTO();
		try {
			logger.info("Going to save vendor Brand Details");			
			VendorBrandDetails vendorBrandDetails = vendorvendorBrandRequestDTOuestDTO.toModel(vendorvendorBrandRequestDTOuestDTO);
			VendorBrandDetails vendorBrandsentity=vendorBrandrepository.save(vendorBrandDetails);
			if(vendorBrandsentity!=null){
				BeanUtils.copyProperties(vendorBrandsentity, vendorBrandDetailsResponseDTO);
				logger.info("Vendor Brands saved successfully");
				vendorBrandDetailsResponseDTO.setResponseMessage("Vendor Brands saved successfully");
			}
			else{
				vendorBrandDetailsResponseDTO.setResponseMessage("Failed to save vendor Brands ");
				logger.error("Failed to save vendor Brands ");
			}
		}
		catch (Exception e) {
			logger.error(" VendorBrandServiceImpl saveVendorBrand" + e);
			throw e;
		}
		return vendorBrandDetailsResponseDTO;
	}
			


			

	/**
	 * This method update  VendorBrand
	 * @param VendorvendorBrandRequestDTOuestDTO
	 * @return VendorBrandResponseDTO
	 * @throws Exception 
	 */

	public VendorBrandDetailsResponseDTO updateVendorBrand(Long id, VendorBrandDetailsRequestDTO vendorvendorBrandRequestDTOuestDTO)
			throws Exception {
		VendorBrandDetailsResponseDTO savedBrandsRespDTO = new VendorBrandDetailsResponseDTO();
		try {
			Optional<VendorBrandDetails> vendorbrandsOptional = vendorBrandrepository.findById(id);
			if (vendorbrandsOptional.isPresent()) {
				VendorBrandDetails newBrands = vendorvendorBrandRequestDTOuestDTO.toModel(vendorvendorBrandRequestDTOuestDTO);
				newBrands.setId(id);
				VendorBrandDetails brandsEntity = vendorBrandrepository.save(newBrands);
				if (brandsEntity != null) {
					BeanUtils.copyProperties(brandsEntity, savedBrandsRespDTO);
					savedBrandsRespDTO.setResponseMessage("Vendor Brands updated successfully");
					logger.info("Vendor Brands updated successfully");
				} else {
					savedBrandsRespDTO.setResponseMessage("Vendor Brands updation failed");
					logger.info("Vendor Brands updation failed");
				}
			} else {
				logger.info("Vendor Brands doesn't exist");
				savedBrandsRespDTO.setResponseMessage("Vendor Brands doesn't exist");
			}
		} catch (Exception e) {
			logger.error("VendorBrandServiceImpl :updateVendorBrand" + e);
			throw e;
		}

		return savedBrandsRespDTO;
	}



	/**r
	 * This method get all VendorBrand 
	 * @return VendorBrandResponseDTO list
	 * @throws Exception 
	 */
	public VendorBrandDetailsResponseDTO findVendorBrandById(Long id) throws Exception {		

		VendorBrandDetailsResponseDTO vendorBrandDetailsResponseDTO = new VendorBrandDetailsResponseDTO();
		try {
			logger.info("Fetching Brand details....");
			Optional<VendorBrandDetails> vendorbrandsOptional = vendorBrandrepository.findById(id);
			if (vendorbrandsOptional.isPresent()) {
				VendorBrandDetails brands = vendorbrandsOptional.get();
				BeanUtils.copyProperties(brands, vendorBrandDetailsResponseDTO);
			} else {
				logger.error("Vendor Brand doesn't exist");
				vendorBrandDetailsResponseDTO.setResponseMessage("Failed");
			}
		} catch (Exception e) {
			logger.error("VendorBrandServiceImpl: findVendorBrandById" + e);
			throw e;
		}

		return vendorBrandDetailsResponseDTO;

	}



	/**r
	 * This method get all VendorBrand 
	 * @return VendorBrandResponseDTO list
	 * @throws Exception 
	 */

	public List<VendorBrandDetailsResponseDTO> findAllVendorBrand() throws Exception {
		logger.info(" Going to find All vendorBrand");

		List<VendorBrandDetailsResponseDTO> vendorBrandResponseDTOs = new ArrayList<VendorBrandDetailsResponseDTO>();
		try {
			List<VendorBrandDetails> vendorBrandList= vendorBrandrepository.findAll();
			for (VendorBrandDetails vendorBrand : vendorBrandList) {
				VendorBrandDetailsResponseDTO brandDetailsResponseDTO = new VendorBrandDetailsResponseDTO();
				BeanUtils.copyProperties(vendorBrand,brandDetailsResponseDTO);
				vendorBrandResponseDTOs.add(brandDetailsResponseDTO);

			}
			logger.info("Find All vendorBrands");	
		} catch (Exception e) {
			logger.error(" VendorBrandServiceImpl  findAllVendorBrand" + e);
			throw e;

		}
		return vendorBrandResponseDTOs;


	}

	/**
	 * searching  vendorBrand dynamically
	 * @param VendorBrandDetails
	 * @return ResponseEntity<CustDataResponseDTO>
	 */


	public List<VendorBrandDetails> findVendorBrandCriteria(VendorBrandDetailsRequestDTO vendorBrandRequestDTO) {

		GenericSpesification<VendorBrandDetails> genericSpesification = new GenericSpesification<VendorBrandDetails>();
		
		if(vendorBrandRequestDTO.getBrandId()!=null) {
			 genericSpesification.add(new SearchCriteria("brandId", vendorBrandRequestDTO.getBrandId(), SearchOperation.MATCH));
			}
			if(vendorBrandRequestDTO.getId()!=null) {
	        genericSpesification.add(new SearchCriteria("id", vendorBrandRequestDTO.getId(), SearchOperation.MATCH));
			}
			if(vendorBrandRequestDTO.getStatus()!=null) {
	        genericSpesification.add(new SearchCriteria("status", vendorBrandRequestDTO.getStatus(), SearchOperation.MATCH));
			}
			if(vendorBrandRequestDTO.getVendorNo()!=null) {
	        genericSpesification.add(new SearchCriteria("vendorNo", vendorBrandRequestDTO.getVendorNo(), SearchOperation.MATCH));
			}
		
		 return vendorBrandrepository.findAll(genericSpesification);
	
	}
}
