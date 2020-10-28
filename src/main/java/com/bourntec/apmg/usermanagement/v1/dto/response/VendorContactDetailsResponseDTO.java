package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.VendorContactDetailsRequestDTO;


/**
 * VendorEmployees entity. @author MyEclipse Persistence Tools
 */



public class VendorContactDetailsResponseDTO extends VendorContactDetailsRequestDTO{


	private Long id;
	private String responseMessage;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
}