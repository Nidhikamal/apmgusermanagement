package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.MerchandiseCategory;
import com.bourntec.apmg.usermanagement.v1.dto.request.MerchandiseCategoryRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.MerchandiseCategoryResponseDTO;

public interface MerchandiseService {
	
	
	 /* @author vidya.p
	 * save MerchandiseCategory
	 * @param categorycode
	 * @param categorycode
	 * @return merchandiseCategoryResponseDTO
	 * @throws Exception
	 */

	MerchandiseCategoryResponseDTO addMerchandiseCategory(
			MerchandiseCategoryRequestDTO merchandiseCategoryRequestDTO)throws Exception;
	/**
	 * update MerchandiseCategory
	 * @param categorycode
	 * @param MerchandiseCategoryRequestDTO
	 * @return merchandiseCategoryResponseDTO
	 * @throws Exception
	 */
	

	MerchandiseCategoryResponseDTO updateMerchandiseCategory(String categoryCode,
			MerchandiseCategoryRequestDTO userRequestDTO)throws Exception;
	/**
	 * findMerchandiseCategoryByID
	 * @param categorycode
	 * @return merchandiseCategoryResponseDTO
	 * @throws Exception
	 */
	MerchandiseCategoryResponseDTO findMerchandiseCategoryByID(String id) throws Exception;

	/**
	 * retrieveAllMerchandiseCategory 
	 * @param categorycode
	 * @param MerchandiseCategoryRequestDTO
	 * @return merchandiseCategoryResponseDTO list
	 * @throws Exception
	 */
	List<MerchandiseCategoryResponseDTO> retrieveAllMerchandiseCategory()throws Exception;

	List<MerchandiseCategory> findMeachandiseByCriteria(MerchandiseCategoryRequestDTO merchReqDTO);

}
