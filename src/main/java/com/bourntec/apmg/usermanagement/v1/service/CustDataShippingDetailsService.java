package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CustDataShippingDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataShippingDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustDataShippinfDetailsResponseDTO;

public interface CustDataShippingDetailsService {
	
	
	CustDataShippinfDetailsResponseDTO getCustShippingDetailsById(Long id);

	List<CustDataShippingDetails> findAllCustShippingDetails();

	CustDataShippinfDetailsResponseDTO saveCustData(CustDataShippingDetailsRequestDTO custDataReq);

	CustDataShippinfDetailsResponseDTO updateCustData(Long id, CustDataShippingDetailsRequestDTO custDataReq);
	
	List<CustDataShippingDetails> findCustDataByCriteria(CustDataShippingDetailsRequestDTO custDataReq);
	
	void deleteCustDataById(Long id);


}
