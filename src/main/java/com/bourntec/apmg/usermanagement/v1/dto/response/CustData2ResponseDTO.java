package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.CustData2RequestDTO;






public class CustData2ResponseDTO extends CustData2RequestDTO {

	
	private String responseMessage;


	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public CustData2ResponseDTO() {

	}
}
