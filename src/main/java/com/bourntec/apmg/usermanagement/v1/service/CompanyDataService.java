package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CompanyData;
import com.bourntec.apmg.usermanagement.v1.dto.request.CompanyRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CompanyResponseDTO;

public interface CompanyDataService {
	
	
	
	CompanyResponseDTO getCompanyById(String id);

	List<CompanyData> findAllCompanies();

	CompanyResponseDTO saveCompanyData(CompanyRequestDTO companyReq);

	CompanyResponseDTO updateCompanyData(String id, CompanyRequestDTO cmpnyReqDTO);

	List<CompanyData> findCompanyDataByCriteria(CompanyRequestDTO cmpnyReqDTO);

}
