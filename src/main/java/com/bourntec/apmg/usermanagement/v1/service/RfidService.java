package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.RfidScanner;
import com.bourntec.apmg.usermanagement.v1.dto.request.RfidRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.RfidScannerResponseDTO;

public interface RfidService {
	
	
	RfidScannerResponseDTO getRfidById(Long id);

	List<RfidScanner> findAllRfidCodes();

	RfidScannerResponseDTO saveRfidCodes(RfidRequestDTO rfidCodesReq);

	RfidScannerResponseDTO updateRfidCodes(Long id, RfidRequestDTO rfidCodesReq);
	
	List<RfidScanner> findRfidDataByCriteria(RfidRequestDTO rfidCodesReq);


}
