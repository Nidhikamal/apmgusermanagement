package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataEmployeeRequestDTO;

/**
 * DTO class for sending the response
 * 
 * @author jinto varghese
 *
 */
public class CustDataEmployeeResponseDTO extends CustDataEmployeeRequestDTO{
	
	private String responseMessage;


	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public CustDataEmployeeResponseDTO() {
		
	}

}
