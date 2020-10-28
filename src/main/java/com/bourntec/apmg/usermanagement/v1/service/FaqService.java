package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.FaqDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.FaqDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.FaqResponseDTO;

public interface FaqService {
	
	
	/**
	 * This method updates faq object.
	 * @param id
	 * @return FaqResponseDTO
	 * @throws Exception 
	 */
	
	FaqResponseDTO updateFaqDetails(Integer id, FaqDetailsRequestDTO faqDetailsRequestDTO)throws Exception;
	/**
	 * This method save new faq object
	 * @return PaymentTermsResponseDTO
	 * @throws Exception 
	 */
	
	FaqResponseDTO saveFaqDetails(FaqDetailsRequestDTO faqDetailsRequestDTO)throws Exception;
	/**
	 * This method get faq object.
	 * @param id
	 * @return FaqResponseDTO
	 * @throws Exception 
	 */
	
	FaqResponseDTO findFaqDetailsById(Integer id)throws Exception;
	/**
	 * This API find all faqs
	 * @return FaqResponseDTO
	 * @throws Exception 
	 */
	List<FaqResponseDTO> findAllFaqDetails()throws Exception;

	List<FaqDetails> findFaqByCriteria(FaqDetailsRequestDTO faqRequestDTO);

}
