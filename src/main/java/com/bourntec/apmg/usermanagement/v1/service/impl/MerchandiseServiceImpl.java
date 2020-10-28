package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.MerchandiseCategory;
import com.bourntec.apmg.entity.MerchandiseSubCategory;
import com.bourntec.apmg.usermanagement.v1.dto.request.MerchandiseCategoryRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.MerchandiseCategoryResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.MerchandiseCategoryRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.MerchandiseService;


@Service(value = "MerchandiseServiceImpl")
public class MerchandiseServiceImpl implements MerchandiseService {

	private static final Logger logger = LogManager.getLogger(MerchandiseServiceImpl.class);

	@Autowired
	private MerchandiseCategoryRepository merchandiseCategoryRepository;

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

	public MerchandiseCategoryResponseDTO addMerchandiseCategory(
			MerchandiseCategoryRequestDTO merchandiseCategoryRequestDTO) throws Exception {
		try {
			logger.info("MerchandiseCategory is going to save");
			MerchandiseCategoryResponseDTO merchandiseCategoryResponseDTO = new MerchandiseCategoryResponseDTO();
			MerchandiseCategory merchandiseCategory = merchandiseCategoryRequestDTO
					.toModel(merchandiseCategoryRequestDTO);
			if (merchandiseCategory != null) {
//				Set<MerchandiseSubCategory> merchandiseSubCategorySet = merchandiseCategory.getSubcategory();
//				merchandiseSubCategorySet.forEach((merchandiseSubCategory) -> {
//					merchandiseSubCategory.setMerchandiseCategory(merchandiseCategory);
//				});
//				merchandiseCategory.setSubcategory(merchandiseSubCategorySet);
				MerchandiseCategory merchandiseCategoryreturn = merchandiseCategoryRepository.save(merchandiseCategory);
				logger.info("MerchandiseCategoryObject is  persisted in DB");
				BeanUtils.copyProperties(merchandiseCategoryreturn, merchandiseCategoryResponseDTO);
			} else {
				logger.info("MerchandiseCategoryObject is not persisted in DB");
			}
			return merchandiseCategoryResponseDTO;
		} catch (Exception e) {
			logger.error(" addMerchandiseCategory failed" + e);
			throw e;
		}
	}

	/**
	 * update MerchandiseCategory
	 * 
	 * @param categorycode
	 * @param MerchandiseCategoryRequestDTO
	 * @return merchandiseCategoryResponseDTO
	 * @throws Exception
	 */

	public MerchandiseCategoryResponseDTO updateMerchandiseCategory(String categoryCode,
			MerchandiseCategoryRequestDTO merchandiseCategoryRequestDTO) throws Exception {

		try {
			logger.info("MerchandiseCategory is going to update");
			MerchandiseCategoryResponseDTO merchandiseCategoryResponseDTO = new MerchandiseCategoryResponseDTO();
			MerchandiseCategory merchandiseCategory = merchandiseCategoryRequestDTO
					.toModel(merchandiseCategoryRequestDTO);
			merchandiseCategory.setCategoryCode(categoryCode);
			merchandiseCategory.setCategoryDescription(merchandiseCategoryRequestDTO.getCategoryDescription());
			merchandiseCategory.setLocationCode(merchandiseCategoryRequestDTO.getLocationCode());

			//Set<MerchandiseSubCategory> merchandiseSubCategorySet = merchandiseCategoryRequestDTO
			//		.getMerchandiseSubCategory();
			////merchandiseSubCategorySet.forEach((merchandiseSubCategory) -> {
//				merchandiseSubCategory.setMerchandiseCategory(merchandiseCategory);

			//});

//			merchandiseCategory.setSubcategory(merchandiseSubCategorySet);
			MerchandiseCategory merchandiseCategoryreturn = merchandiseCategoryRepository.save(merchandiseCategory);
			logger.info("MerchandiseCategoryObject is  updated in DB");
			BeanUtils.copyProperties(merchandiseCategoryreturn, merchandiseCategoryResponseDTO);
			return merchandiseCategoryResponseDTO;
		} catch (Exception e) {
			logger.error(" updateMerchandiseCategory failed" + e);
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
	public List<MerchandiseCategoryResponseDTO> retrieveAllMerchandiseCategory() throws Exception {

		logger.info("MerchandiseCategory is going to retrieveAllMerchandiseCategory");
		List<MerchandiseCategoryResponseDTO> merchandiseResponseList = new ArrayList<MerchandiseCategoryResponseDTO>();
		try {
			List<MerchandiseCategory> merchandiseCategoryList = merchandiseCategoryRepository.findAll();
			if (merchandiseCategoryList != null && merchandiseCategoryList.size() > 0) {
				merchandiseCategoryList.forEach((merchandiseCategory) -> {
					MerchandiseCategoryResponseDTO merchandiseCategoryResponseDTO = new MerchandiseCategoryResponseDTO();
					BeanUtils.copyProperties(merchandiseCategory, merchandiseCategoryResponseDTO);
					merchandiseResponseList.add(merchandiseCategoryResponseDTO);
				});
				logger.info("MerchandiseCategory is  retrieveAllMerchandiseCategory");
				return merchandiseResponseList;
			}

		} catch (Exception e) {
			logger.error(" retrieveAllMerchandiseCategory failed" + e);
			throw e;
		}
		return merchandiseResponseList;

	}

	/**
	 * findMerchandiseCategoryByID
	 * 
	 * @param categorycode
	 * @return merchandiseCategoryResponseDTO
	 * @throws Exception
	 */
	public MerchandiseCategoryResponseDTO findMerchandiseCategoryByID(String id) throws Exception {

		logger.info(" Going to retrieveAllMerchafindMerchandiseCategoryByID");
		MerchandiseCategoryResponseDTO merchandiseCategoryResponseDTO = new MerchandiseCategoryResponseDTO();
		try {
			
			Optional<MerchandiseCategory> merchandiseCategory = merchandiseCategoryRepository.findById(id);
			if (merchandiseCategory.isPresent()) {
				BeanUtils.copyProperties(merchandiseCategory.get(), merchandiseCategoryResponseDTO);
				logger.info("MerchandiseCategory is going to retrieveAllMerchandiseCategory");
				
			} else {
			//	throw new ResourceNotFoundException(ErrorCodes.MERCH_NOT_FOUND.getMessage());
				merchandiseCategoryResponseDTO.setResponseMessage("Merchandise Category not found");
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
	public List<MerchandiseCategory> findMeachandiseByCriteria(MerchandiseCategoryRequestDTO merchReqDTO) {
GenericSpesification<MerchandiseCategory> genericSpesification = new GenericSpesification<MerchandiseCategory>();
		
		if(merchReqDTO.getCategoryCode()!=null) {
			 genericSpesification.add(new SearchCriteria("categoryCode", merchReqDTO.getCategoryCode(), SearchOperation.MATCH));
			}
			if(merchReqDTO.getCategoryDescription()!=null) {
	        genericSpesification.add(new SearchCriteria("categoryDescription", merchReqDTO.getCategoryDescription(), SearchOperation.MATCH));
			}
			if(merchReqDTO.getLocationCode()!=null) {
	        genericSpesification.add(new SearchCriteria("locationCode", merchReqDTO.getLocationCode(), SearchOperation.MATCH));
			}
		
		 return merchandiseCategoryRepository.findAll(genericSpesification);
	}
}
