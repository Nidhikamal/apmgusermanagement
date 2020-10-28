package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.PaymentTerms;
import com.bourntec.apmg.usermanagement.v1.dto.request.PaymentTermsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PaymentTermsResponseDTO;

public interface PaymentTermsService {
	
	/**
	 * updatePaymentTerms
	 * @param termsId,paymentTermsRequestDTO
	 * @return paymentTermsResponseDTO
	 * @throws Exception
	 */
	PaymentTermsResponseDTO updatePaymentTerms(Long terms, PaymentTermsRequestDTO paymentTermsRequestDTO)throws Exception;
	/**
	 * savePaymentTerms
	 * @param termsId,paymentTermsRequestDTO
	 * @return paymentTermsResponseDTO
	 * @throws Exception
	 */
	PaymentTermsResponseDTO savePaymentTerms(PaymentTermsRequestDTO paymentTermsRequestDTO)throws Exception;
	/**
	 * findPaymentTermsById
	 * @param terms
	 * @return paymentTermsResponseDTO
	 * @throws Exception
	 */
	
	PaymentTermsResponseDTO findPaymentTermsById(Long terms)throws Exception;
	/**
	 * findAllPaymentTerms
	 * @return paymentTermsResponseDTO  list
	 * @throws Exception
	 */
	List<PaymentTermsResponseDTO> findAllPaymentTerms()throws Exception;

	List<PaymentTerms> findPaymentTermsByCriteria(PaymentTermsRequestDTO paymentTermsRequestDTO);
}
