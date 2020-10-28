package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CodesPacking;
import com.bourntec.apmg.usermanagement.v1.dto.request.CodesPackingRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CodesPackingResponseDTO;

public interface CodesPackingService {
	
	
	CodesPackingResponseDTO getPackingCodesById(String id);

	List<CodesPacking> findAllPackingCodes();

	CodesPackingResponseDTO savePackingCodes(CodesPackingRequestDTO packingCodesReq);

	CodesPackingResponseDTO updatePackingCodes(String id, CodesPackingRequestDTO packingCodesReq);
	
	List<CodesPacking> findPackingCodesByCriteria(CodesPackingRequestDTO packingCodesReq);


}
