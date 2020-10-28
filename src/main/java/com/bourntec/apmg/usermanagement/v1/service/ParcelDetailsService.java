package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.ParcelDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.ParcelDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ParcelDetailResponseDTO;

public interface ParcelDetailsService {
	
	
	/**
	 * This method findParcelDetailsById
	 * @return ParcelDetailResponseDTO
	 * @throws Exception 
	 */
	
	ParcelDetailResponseDTO findParcelDetailsById(String parcelNo)throws Exception;
	/**
	 * This method saveParcelDetails
	 * @return ParcelDetailResponseDTO
	 * @throws Exception 
	 */

	ParcelDetailResponseDTO saveParcelDetails(ParcelDetailsRequestDTO parcelDetailsRequestDTO)throws Exception;
	/**
	 * This method findAllParcelDetails
	 * @return ParcelDetailResponseDTO list
	 * @throws Exception 
	 */

	
	List<ParcelDetailResponseDTO> findAllParcelDetails()throws Exception;
	
	/**
	 * This method updates parcel
	 * @param parcelId ,parcelDetailsRequestDTO
	 * @return ParcelDetailResponseDTO
	 * @throws Exception 
	 */
	ParcelDetailResponseDTO updateParcelDetails(String parcelId, ParcelDetailsRequestDTO parcelDetailsRequestDTO)throws Exception;
	

	List<ParcelDetails> findParcelByCriteria(ParcelDetailsRequestDTO parcelDetailsRequestDTO);
}
