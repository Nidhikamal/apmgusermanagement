package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.StateCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.StateCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.StateCodesResponseDTO;

public interface StateCodesService {

	StateCodesResponseDTO savecustomerstate(StateCodesRequestDTO stateRequestDTO);

	StateCodesResponseDTO updatecustomerstate(String stateCode, StateCodesRequestDTO stateRequestDTO);

	StateCodesResponseDTO findBystateCode(String stateCode);

	List<StateCodes> fetchAllstatcodeCode();

	List<StateCodes> fetchByCustomerstate(StateCodesRequestDTO stateRequestDTO);

	StateCodesResponseDTO deleteStateCode(String stateCode);

}
