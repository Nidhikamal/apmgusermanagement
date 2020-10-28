package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.VendorStateCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorStateCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorStateCodesResponseDTO;

public interface VendorStateCodesService {

	VendorStateCodesResponseDTO saveVendorStateCustomer(VendorStateCodesRequestDTO custDataRequestDTO);

	VendorStateCodesResponseDTO findStatecodeById(String stateCode);

	VendorStateCodesResponseDTO updatestatecode(String stateCode, VendorStateCodesRequestDTO customerReqDTO);

	List<VendorStateCodes> fetchByStaterCtriteria(VendorStateCodesRequestDTO customerReqDTO);

	List<VendorStateCodes> fetchAllStatecode();

	VendorStateCodesResponseDTO deleteVendorStateCodes(String id);



}
