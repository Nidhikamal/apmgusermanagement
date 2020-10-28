package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.BrandDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.BrandRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BrandResponseDTO;

public interface BrandService {
	
	
	BrandResponseDTO getBrandById(Long id);

	List<BrandDetails> findAllBrands();

	BrandResponseDTO saveBrands(BrandRequestDTO brandReq);

	BrandResponseDTO updateBrands(Long id, BrandRequestDTO brandReq);
	
	List<BrandDetails> findBrandsByCriteria(BrandRequestDTO brandReq);


}
