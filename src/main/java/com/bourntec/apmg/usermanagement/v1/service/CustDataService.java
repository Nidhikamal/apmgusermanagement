package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CustData;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustDataResponseDTO;

public interface CustDataService {
	
	
	CustDataResponseDTO getCustDataById(String id);

	List<CustData> findAllCustData();

	CustDataResponseDTO saveCustData(CustDataRequestDTO custDataReq);

	CustDataResponseDTO updateCustData(String id, CustDataRequestDTO custDataReq);
	
	List<CustData> findCustDataByCriteria(CustDataRequestDTO custDataReq);
	
	void deleteCustDataById(String id);


}
