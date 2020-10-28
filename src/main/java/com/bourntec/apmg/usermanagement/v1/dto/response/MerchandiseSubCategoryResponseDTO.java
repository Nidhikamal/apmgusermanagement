package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.MerchandiseSubCategoryRequestDTO;

/**
 * DTO class for sending the response

 * @author Amal
 *
 */
public class MerchandiseSubCategoryResponseDTO extends MerchandiseSubCategoryRequestDTO{

	
	private String responseMessage;



	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public MerchandiseSubCategoryResponseDTO() {

	}
}
