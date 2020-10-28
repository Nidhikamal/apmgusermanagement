package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.BrandDetails;
import com.bourntec.apmg.entity.MerchandiseSubCategory;
import com.bourntec.apmg.usermanagement.v1.dto.request.BrandRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.MerchandiseSubCategoryRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BrandResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.MerchandiseSubCategoryResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.MerchandiseSubCategoryRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.MerchandiseSubCatService;


@Service(value = "MerchandiseSubCatServiceImpl")
public class MerchandiseSubCatServiceImpl implements MerchandiseSubCatService {

	private static final Logger logger = LogManager.getLogger(MerchandiseSubCatServiceImpl.class);

	@Autowired
	private MerchandiseSubCategoryRepository merchandiseSubCategoryRepository;

	/*
	 * @author vidya.p save MerchandiseCategory
	 * 
	 * @param categorycode
	 * 
	 * @param categorycode
	 * 
	 * @return merchandiseCategoryResponseDTO
	 * 
	 * @throws Exception
	 */

	
	public MerchandiseSubCategoryResponseDTO addMerchandiseSubCategory(MerchandiseSubCategoryRequestDTO merchandiseSUbCatRequestDTO) {

		MerchandiseSubCategoryResponseDTO merchandiseCategoryResponseDTO = new MerchandiseSubCategoryResponseDTO();
		try {
			MerchandiseSubCategory merchandiseCategory = merchandiseSUbCatRequestDTO.toModel(merchandiseSUbCatRequestDTO);
			MerchandiseSubCategory merchandiseCategoryreturn = merchandiseSubCategoryRepository
					.save(merchandiseCategory);
			if (merchandiseCategoryreturn != null) {
				BeanUtils.copyProperties(merchandiseCategoryreturn, merchandiseCategoryResponseDTO);
				logger.info("MerchandiseSubCategoryObject saved successfully");
				merchandiseCategoryResponseDTO.setResponseMessage("MerchandiseSubCategoryObject saved successfully");
			} else {
				merchandiseCategoryResponseDTO.setResponseMessage("MerchandiseSubCategoryObject to save Brands");
				logger.error("Failed to save Brands ");
			}
		} catch (Exception e) {
			logger.error("MerchandiseSubCategoryObject saveBrands" + e);
			throw e;
		}

		return merchandiseCategoryResponseDTO;

	}
	
	
	
	
//	public MerchandiseSubCategoryResponseDTO addMerchandiseSubCategory(
//			MerchandiseSubCategoryRequestDTO merchandiseSUbCatRequestDTO) throws Exception {
//		try {
//			logger.info("MerchandiseCategory is going to save");
//			MerchandiseSubCategoryResponseDTO merchandiseCategoryResponseDTO = new MerchandiseSubCategoryResponseDTO();
//			MerchandiseSubCategory merchandiseCategory = merchandiseSUbCatRequestDTO
//					.toModel(merchandiseSUbCatRequestDTO);
//			if (merchandiseCategory != null) {
//				MerchandiseSubCategory merchandiseCategoryreturn = merchandiseSubCategoryRepository
//						.save(merchandiseCategory);
//				logger.info("MerchandiseSubCategoryObject is  persisted in DB");
//				BeanUtils.copyProperties(merchandiseCategoryreturn, merchandiseCategoryResponseDTO);
//			} else {
//				logger.info("MerchandiseSubCategoryObject is not persisted in DB");
//			}
//			return merchandiseCategoryResponseDTO;
//		} catch (Exception e) {
//			logger.error(" addMerchandiseSubCategory failed" + e);
//			throw e;
//		}
//	}

	/**
	 * update MerchandiseCategory
	 * 
	 * @param categorycode
	 * @param MerchandiseCategoryRequestDTO
	 * @return merchandiseCategoryResponseDTO
	 * @throws Exception
	 */

	public MerchandiseSubCategoryResponseDTO updateMerchandiseSubCategory(String subcategoryCode,
			MerchandiseSubCategoryRequestDTO merchandiseCategoryRequestDTO) throws Exception {

		try {
			logger.info("MerchandiseSubCategory is going to update");
			MerchandiseSubCategoryResponseDTO merchandiseCategoryResponseDTO = new MerchandiseSubCategoryResponseDTO();
			MerchandiseSubCategory merchandisesubCategory = merchandiseCategoryRequestDTO
					.toModel(merchandiseCategoryRequestDTO);
			Optional<MerchandiseSubCategory> merchandisesubCategoryList=merchandiseSubCategoryRepository.findById(subcategoryCode);
			if(merchandisesubCategoryList.isPresent()) {
			MerchandiseSubCategory merchandisesubCategoryEntity=merchandisesubCategoryList.get();
			
			merchandisesubCategory.setCategoryCode(merchandisesubCategoryEntity.getCategoryCode());
			MerchandiseSubCategory merchandiseCategoryreturn = merchandiseSubCategoryRepository.save(merchandisesubCategory);
			logger.info("MerchandiseSubCategory is  updated in DB");
			BeanUtils.copyProperties(merchandiseCategoryreturn, merchandiseCategoryResponseDTO);
			}
			return merchandiseCategoryResponseDTO;
		} catch (Exception e) {
			logger.error(" updateMerchandiseSubCategory failed" + e);
			throw e;
		}
	}

	/**
	 * retrieveAllMerchandiseCategory
	 * 
	 * @param categorycode
	 * @param MerchandiseCategoryRequestDTO
	 * @return merchandiseCategoryResponseDTO list
	 * @throws Exception
	 */
	public List<MerchandiseSubCategory> retrieveAllMerchandiseSubCategory() throws Exception {

		logger.info("MerchandiseCategory is going to retrieveAllMerchandisesubCategory");
		
		return merchandiseSubCategoryRepository.findAll();

	}

	/**
	 * findMerchandiseCategoryByID
	 * 
	 * @param categorycode
	 * @return merchandiseCategoryResponseDTO
	 * @throws Exception
	 */
	public MerchandiseSubCategoryResponseDTO findMerchandiseSubCategoryByID(String id) throws Exception {

		logger.info(" Going to retrieveAllMerchafindMerchandisesubCategoryByID");
		MerchandiseSubCategoryResponseDTO merchandiseCategoryResponseDTO = new MerchandiseSubCategoryResponseDTO();
		try {
			
			Optional<MerchandiseSubCategory> merchandiseCategory = merchandiseSubCategoryRepository.findById(id);
			if (merchandiseCategory.isPresent()) {
				BeanUtils.copyProperties(merchandiseCategory.get(), merchandiseCategoryResponseDTO);
				logger.info("MerchandiseCategory is going to retrieveAllMerchandisesubCategory");
				
			} else {
				merchandiseCategoryResponseDTO.setResponseMessage("Merchandise sub Category not found ");
			}
		}

		catch (Exception e) {
			logger.error(" findMerchandiseCategoryByID failed" + e);
			throw e;
		}
		return merchandiseCategoryResponseDTO;
	}
	
	/**
	 * This method Searches MerchandiseCategory by criteria
	 * @author Amal
	 * @return List<MerchandiseCategory>
	 * @throws Exception
	 */

	@Override
	public List<MerchandiseSubCategory> findMerchandiseSubCategoryByCriteria(MerchandiseSubCategoryRequestDTO merchReqDTO) {
		GenericSpesification<MerchandiseSubCategory> genericSpesification = new GenericSpesification<MerchandiseSubCategory>();

		if (merchReqDTO.getCategoryCode() != null) {
			genericSpesification
					.add(new SearchCriteria("categoryCode", merchReqDTO.getCategoryCode(), SearchOperation.MATCH));
		}		 
		if (merchReqDTO.getSubCategoryCode() != null) {
			genericSpesification
					.add(new SearchCriteria("subCategoryCode", merchReqDTO.getSubCategoryCode(), SearchOperation.MATCH));
		}
		if (merchReqDTO.getSubCategoryName() != null) {
			genericSpesification
					.add(new SearchCriteria("subCategoryName", merchReqDTO.getSubCategoryName(), SearchOperation.MATCH));
		}

		return merchandiseSubCategoryRepository.findAll(genericSpesification);
	}

	
}
