package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.RmaDataRequestDTO;

import lombok.Getter;
import lombok.Setter;


/**
 * 
 * DTO class for sending the response of RmaData
 * 
 * @author Tinu
 *
 */
@Getter
@Setter
public class RmaDataResponseDTO extends RmaDataRequestDTO {
	private String responseMessage;
}
