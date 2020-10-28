package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CustomerBrandDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustomerBrandDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustomerBrandDetailsResponseDTO;

public interface CustomerBrandDetailsService {
	
	
	CustomerBrandDetailsResponseDTO getBrandById(Long id);

	List<CustomerBrandDetails> findAllBrands();

	CustomerBrandDetailsResponseDTO saveBrands(CustomerBrandDetailsRequestDTO brandReq);

	CustomerBrandDetailsResponseDTO updateBrands(Long id, CustomerBrandDetailsRequestDTO brandReq);
	
	List<CustomerBrandDetails> findBrandsByCriteria(CustomerBrandDetailsRequestDTO brandReq);

	CustomerBrandDetailsResponseDTO deleteCustDataById(Long id);


}
