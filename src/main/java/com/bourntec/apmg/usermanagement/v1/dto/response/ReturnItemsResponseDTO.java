package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.ReturnItemsRequestDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * DTO class for sending the response of ReturnItems
 * 
 * @author Tinu
 *
 */
@Getter
@Setter
public class ReturnItemsResponseDTO extends ReturnItemsRequestDTO{
	private String responseMessage;
}
