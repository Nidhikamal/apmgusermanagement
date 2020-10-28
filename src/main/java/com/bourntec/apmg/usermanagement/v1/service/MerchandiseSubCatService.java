package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.MerchandiseSubCategory;
import com.bourntec.apmg.usermanagement.v1.dto.request.MerchandiseSubCategoryRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.MerchandiseSubCategoryResponseDTO;

public interface MerchandiseSubCatService {
	
	
	 /* @author vidya.p
	 * save MerchandiseCategory
	 * @param categorycode
	 * @param categorycode
	 * @return merchandiseCategoryResponseDTO
	 * @throws Exception
	 */

	MerchandiseSubCategoryResponseDTO addMerchandiseSubCategory(
			MerchandiseSubCategoryRequestDTO merchandiseSubCategoryRequestDTO)throws Exception;
	/**
	 * update MerchandiseCategory
	 * @param categorycode
	 * @param MerchandiseCategoryRequestDTO
	 * @return merchandiseCategoryResponseDTO
	 * @throws Exception
	 */
	

	MerchandiseSubCategoryResponseDTO updateMerchandiseSubCategory(String categoryCode,
			MerchandiseSubCategoryRequestDTO merchandiseSubCategoryRequestDTO)throws Exception;
	/**
	 * findMerchandiseCategoryByID
	 * @param categorycode
	 * @return merchandiseCategoryResponseDTO
	 * @throws Exception
	 */
	MerchandiseSubCategoryResponseDTO findMerchandiseSubCategoryByID(String id) throws Exception;

	/**
	 * retrieveAllMerchandiseCategory 
	 * @param categorycode
	 * @param MerchandiseCategoryRequestDTO
	 * @return merchandiseCategoryResponseDTO list
	 * @throws Exception
	 */
	List<MerchandiseSubCategory> retrieveAllMerchandiseSubCategory()throws Exception;

	List<MerchandiseSubCategory> findMerchandiseSubCategoryByCriteria(MerchandiseSubCategoryRequestDTO merchReqDTO);
	
	

}
