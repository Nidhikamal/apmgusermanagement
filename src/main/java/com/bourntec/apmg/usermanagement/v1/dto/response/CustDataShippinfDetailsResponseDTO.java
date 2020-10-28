package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataShippingDetailsRequestDTO;

public class CustDataShippinfDetailsResponseDTO extends CustDataShippingDetailsRequestDTO {

	private String responseMessage;

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public CustDataShippinfDetailsResponseDTO() {

	}
}
