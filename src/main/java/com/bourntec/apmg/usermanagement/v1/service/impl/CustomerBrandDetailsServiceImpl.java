package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CustomerBrandDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustomerBrandDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustomerBrandDetailsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.CustomerBrandDetailsRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.CustomerBrandDetailsService;

/**
 * 
 * Service class implementation for employee Entity
 * 
 * @author Babu
 *
 */

@Service(value = "CustomerBrandDetailsServiceImpl")
public class CustomerBrandDetailsServiceImpl implements CustomerBrandDetailsService {

	private static final Logger logger = LogManager.getLogger(CustomerBrandDetailsServiceImpl.class);

	@Autowired
	private CustomerBrandDetailsRepository customerBrandDetailsRepository;
	
	
	/**
	 * This is the main method which is used to Fetch Customer Brand details
	 * 
	 * @param id
	 * @return brandRespDTO
	 */
	public CustomerBrandDetailsResponseDTO getBrandById(Long id) {
		CustomerBrandDetailsResponseDTO brandRespDTO = new CustomerBrandDetailsResponseDTO();
		try {
			logger.info("Fetching Customer Brand details....");
			Optional<CustomerBrandDetails> brandsOptional = customerBrandDetailsRepository.findById(id);
			if (brandsOptional.isPresent()) {
				CustomerBrandDetails brands = brandsOptional.get();
				BeanUtils.copyProperties(brands, brandRespDTO);
			} else {
				logger.error("CustomerBrandDetails doesn't exist");
				brandRespDTO.setResponseMessage("Failed");
			}
		} catch (Exception e) {
			logger.error("Fetch: getBrandById" + e);
			throw e;
		}
		logger.info("Exit from getBrandById....");
		return brandRespDTO;
	}
	

	/**
	 * This is the main method which is used to save brands
	 * 
	 * @param BrandRequestDTO.
	 * @return BrandResponseDTO.
	 */
	public CustomerBrandDetailsResponseDTO saveBrands(CustomerBrandDetailsRequestDTO brandReqDTO) {

		CustomerBrandDetailsResponseDTO brandsRespDTO = new CustomerBrandDetailsResponseDTO();
		try {
			CustomerBrandDetails brands = brandReqDTO.toModel(brandReqDTO);
			CustomerBrandDetails brandsEntity = customerBrandDetailsRepository.save(brands);
			if (brandsEntity != null) {
				BeanUtils.copyProperties(brandsEntity, brandsRespDTO);
				logger.info("CustomerBrandDetails saved successfully");
				brandsRespDTO.setResponseMessage("Customer Brands Saved Ssuccessfully");
			} else {
				brandsRespDTO.setResponseMessage("Failed to save Customer Brands");
				logger.error("Failed to save CustomerBrandDetails ");
			}
		} catch (Exception e) {
			logger.error("Saving CustomerBrandDetails" + e);
			throw e;
		}
		logger.info("Exit from saveBrands....");
		return brandsRespDTO;
	}

	
	/**
	 * This is the main method which is used to update brands by Id
	 * 
	 * @author Babu
	 * @param Long id,BrandRequestDTO.
	 * @return BrandResponseDTO.
	 */
	public CustomerBrandDetailsResponseDTO updateBrands(Long id, CustomerBrandDetailsRequestDTO brandReqDTO) {
		
		CustomerBrandDetailsResponseDTO savedBrandsRespDTO = new CustomerBrandDetailsResponseDTO();
		try {
			Optional<CustomerBrandDetails> brandsOptional = customerBrandDetailsRepository.findById(id);
			if (brandsOptional.isPresent()) {
				CustomerBrandDetails newBrands = brandReqDTO.toModel(brandReqDTO);
				newBrands.setId(id);
				CustomerBrandDetails brandsEntity = customerBrandDetailsRepository.save(newBrands);
				if (brandsEntity != null) {
					BeanUtils.copyProperties(brandsEntity, savedBrandsRespDTO);
					savedBrandsRespDTO.setResponseMessage("Customer Brands Updated Successfully");
					logger.info("Brands up successfully");
				} else {
					savedBrandsRespDTO.setResponseMessage("Customer Brands Updation Failed");
					logger.info("Brands updation failed");
				}
			} else {
				logger.info("Brands doesn't exist");
				savedBrandsRespDTO = saveBrands(brandReqDTO);
				savedBrandsRespDTO.setResponseMessage("Customer Brands Updated successfully.");
			}
		} catch (Exception e) {
			logger.error("Update :updateBrands" + e);
			throw e;
		}
		logger.info("Exit from updateBrands....");
		return savedBrandsRespDTO;
	}

	
	/**
	 * @author Babu 
	 * This is the main method which is used to get all brands
	 */
	public List<CustomerBrandDetails> findAllBrands() {
		logger.info("Fetching CustomerBrandDetails...");
		return customerBrandDetailsRepository.findAll();
	}
	
	
	/**
	 * This method is used to list Customer Brands data by search criteria
	 * 
	*/
	public List<CustomerBrandDetails> findBrandsByCriteria(CustomerBrandDetailsRequestDTO brandReq) {	
		
		logger.info("Entering findBrandsByCriteria");
		
		GenericSpesification<CustomerBrandDetails> genericSpesification = new GenericSpesification<CustomerBrandDetails>();		
		if(brandReq.getBrandId()!=null) {
	        genericSpesification.add(new SearchCriteria("brandId", brandReq.getBrandId(), SearchOperation.EQUAL));
			}
		if(brandReq.getId()!=null) {
	        genericSpesification.add(new SearchCriteria("id", brandReq.getId(), SearchOperation.EQUAL));
			}
			if(brandReq.getCustNo()!=null) {
	        genericSpesification.add(new SearchCriteria("custNo", brandReq.getCustNo(), SearchOperation.MATCH));
			}		   
			if(brandReq.getStatus()!=null) {
	        genericSpesification.add(new SearchCriteria("status", brandReq.getStatus(), SearchOperation.MATCH));
			}
		logger.info("Exit from findBrandsByCriteria....");			
		return customerBrandDetailsRepository.findAll(genericSpesification);
	}
	
	
	/**
	 * This method is used to Delete Customer Brand from Database
	 * 
	*/
	@Override
	public CustomerBrandDetailsResponseDTO deleteCustDataById(Long id) {
		
		logger.info("Entering deleteCustDataById  {}", id);
		
		CustomerBrandDetailsResponseDTO customerBrandDetailsResponseDTO= new CustomerBrandDetailsResponseDTO();

		Optional<CustomerBrandDetails> customerBrandDetailsList = customerBrandDetailsRepository.findById(id);
		CustomerBrandDetails customerBrandDetails = customerBrandDetailsList.get();
		try {
			if (customerBrandDetails == null) {
				logger.info("The Customer Brand doesn't exists!!!");
			} else {
				customerBrandDetailsRepository.delete(customerBrandDetails);
				logger.info("Customer Brand Deleted Successfully!!!");
				customerBrandDetailsResponseDTO.setResponseMessage("Customer Brand Deleted Successfully!!!");
			}
			logger.info("Exiting deleteCustDataById");
		} catch (Exception e) {
			throw e;
		}
		return customerBrandDetailsResponseDTO;
	}
	

}
