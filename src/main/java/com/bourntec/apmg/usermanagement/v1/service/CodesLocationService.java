package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CodesLocation;
import com.bourntec.apmg.usermanagement.v1.dto.request.CodesLocationRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CodesLocationResponseDTO;

public interface CodesLocationService {

	List<CodesLocation> findAllLocationcode();

	CodesLocationResponseDTO findBylocationCode(String locationCode);

	CodesLocationResponseDTO updateLocationCode(String locationCode, CodesLocationRequestDTO locationCodeRequestDTO);

	CodesLocationResponseDTO saveLocationCode(CodesLocationRequestDTO locationCodeRequestDTO);

	List<CodesLocation> fetchByLocationCode(CodesLocationRequestDTO locationCodeRequestDTO);

}
