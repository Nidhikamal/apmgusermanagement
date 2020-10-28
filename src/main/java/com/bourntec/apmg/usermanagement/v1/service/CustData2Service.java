package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CustData2;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustData2RequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustData2ResponseDTO;



public interface CustData2Service {
	
	
	CustData2ResponseDTO getCustDataById(String id);

	List<CustData2> findAllCustData();

	CustData2ResponseDTO saveCustData(CustData2RequestDTO custDataReq);

	CustData2ResponseDTO updateCustData(String id, CustData2RequestDTO custDataReq);
	
	List<CustData2> findCustDataByCriteria(CustData2RequestDTO custDataReq);
	
	void deleteCustDataById(String id);


}
