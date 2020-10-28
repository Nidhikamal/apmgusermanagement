package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.BrandDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.BrandRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BrandResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.BrandRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.BrandService;

/**
 * 
 * Service class implementation for employee Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Service(value = "BrandServiceImpl")
public class BrandServiceImpl implements BrandService {

	private static final Logger logger = LogManager.getLogger(BrandServiceImpl.class);

	@Autowired
	private BrandRepository brandRepository;

	public BrandResponseDTO getBrandById(Long id) {
		BrandResponseDTO brandRespDTO = new BrandResponseDTO();
		try {
			logger.info("Fetching Brand details....");
			Optional<BrandDetails> brandsOptional = brandRepository.findById(id);
			if (brandsOptional.isPresent()) {
				BrandDetails brands = brandsOptional.get();
				BeanUtils.copyProperties(brands, brandRespDTO);
			} else {
				logger.error("Brand doesn't exist");
				brandRespDTO.setResponseMessage("No data found");
			}
		} catch (Exception e) {
			logger.error("BrandServiceImpl: getBrandById" + e);
			throw e;
		}

		return brandRespDTO;
	}

	/**
	 * This is the main method which is used to save brands
	 * 
	 * @param BrandRequestDTO.
	 * @return BrandResponseDTO.
	 */
	public BrandResponseDTO saveBrands(BrandRequestDTO brandReqDTO) {

		BrandResponseDTO brandsRespDTO = new BrandResponseDTO();
		try {
			BrandDetails brands = brandReqDTO.toModel(brandReqDTO);
			BrandDetails brandsEntity = brandRepository.save(brands);
			if (brandsEntity != null) {
				BeanUtils.copyProperties(brandsEntity, brandsRespDTO);
				logger.info("Brands saved successfully");
				brandsRespDTO.setResponseMessage("Brands saved successfully");
			} else {
				brandsRespDTO.setResponseMessage("Failed to save Brands");
				logger.error("Failed to save Brands ");
			}
		} catch (Exception e) {
			logger.error("BrandServiceImpl saveBrands" + e);
			throw e;
		}

		return brandsRespDTO;

	}

	/**
	 * This is the main method which is used to update brands by Id
	 * 
	 * @author amal
	 * @param Long id,BrandRequestDTO.
	 * @return BrandResponseDTO.
	 */
	public BrandResponseDTO updateBrands(Long id, BrandRequestDTO brandReqDTO) {
		BrandResponseDTO savedBrandsRespDTO = new BrandResponseDTO();
		try {
			Optional<BrandDetails> brandsOptional = brandRepository.findById(id);
			if (brandsOptional.isPresent()) {
				BrandDetails newBrands = brandReqDTO.toModel(brandReqDTO);
				newBrands.setBrandId(id);
				BrandDetails brandsEntity = brandRepository.save(newBrands);
				if (brandsEntity != null) {
					BeanUtils.copyProperties(brandsEntity, savedBrandsRespDTO);
					savedBrandsRespDTO.setResponseMessage("Brands updated successfully");
					logger.info("Brands updated successfully");
				} else {
					savedBrandsRespDTO.setResponseMessage("Brands updation failed");
					logger.info("Brands updation failed");
				}
			} else {
				logger.info("Brands doesn't exist");
				savedBrandsRespDTO.setResponseMessage("Brands doesn't exist");
			}
		} catch (Exception e) {
			logger.error("BrandServiceImpl updateBrands" + e);
			throw e;
		}

		return savedBrandsRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all brands
	 */
	public List<BrandDetails> findAllBrands() {
		logger.info("Fetching Brands...");
		return brandRepository.findAll();
	}

	public List<BrandDetails> findBrandsByCriteria(BrandRequestDTO brandReq) {
		GenericSpesification<BrandDetails> genericSpesification = new GenericSpesification<BrandDetails>();
		logger.info("Fetching Brands...");
			if(brandReq.getBrandId()!=null) {
	        genericSpesification.add(new SearchCriteria("brandId", brandReq.getBrandId(), SearchOperation.EQUAL));
			}
			if(brandReq.getBrandName()!=null) {
	        genericSpesification.add(new SearchCriteria("brandName", brandReq.getBrandName(), SearchOperation.MATCH));
			}
			if(brandReq.getBrandStatus()!=null) {
	        genericSpesification.add(new SearchCriteria("brandStatus", brandReq.getBrandStatus(), SearchOperation.MATCH));
			}
			if(brandReq.getBrandDesc()!=null) {
	        genericSpesification.add(new SearchCriteria("brandDesc", brandReq.getBrandDesc(), SearchOperation.MATCH));
			}
		
		 return brandRepository.findAll(genericSpesification);
	}


}
