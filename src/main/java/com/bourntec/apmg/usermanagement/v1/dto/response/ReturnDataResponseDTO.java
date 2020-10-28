package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.ReturnDataRequestDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * DTO class for sending the response of ReturnData
 * 
 * @author Tinu
 *
 */
@Getter
@Setter
public class ReturnDataResponseDTO extends ReturnDataRequestDTO{
	private String responseMessage;
}
