package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.RmaItemsRequestDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * DTO class for sending the response of RmaItems
 * 
 * @author Tinu
 *
 */
@Getter
@Setter
public class RmaItemsResponseDTO extends RmaItemsRequestDTO{
	private String responseMessage;
}
