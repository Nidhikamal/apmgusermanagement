package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CreditcardNames;
import com.bourntec.apmg.usermanagement.v1.dto.request.CreditcardsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CreditcardResponseDTO;

public interface CreditCardNamesService {
	
	
	
	CreditcardResponseDTO getCreditCardById(String id);

	List<CreditcardNames> findAllCreditCards();

	CreditcardResponseDTO saveCreditCards(CreditcardsRequestDTO creditreqDTO);

	CreditcardResponseDTO updateCreditCards(String id, CreditcardsRequestDTO creditreqDTO);

	List<CreditcardNames> findCreditCardsByCriteria(CreditcardsRequestDTO creditreqDTO);


}
