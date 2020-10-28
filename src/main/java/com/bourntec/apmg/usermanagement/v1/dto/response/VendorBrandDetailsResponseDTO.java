package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.VendorBrandDetailsRequestDTO;



/**
 * VendorShippingDetails entity. @author MyEclipse Persistence Tools
 */

//bugzilla#4114 start

public class VendorBrandDetailsResponseDTO extends VendorBrandDetailsRequestDTO   {

	private String responseMessage;
	
	
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}