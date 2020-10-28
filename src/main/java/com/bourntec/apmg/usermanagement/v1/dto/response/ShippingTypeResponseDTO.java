package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.ShippingTypeRequestDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * DTO class for sending the response of ShippingType
 * 
 * @author Tinu
 *
 */
@Getter
@Setter
public class ShippingTypeResponseDTO extends ShippingTypeRequestDTO {
	private String responseMessage;
}
