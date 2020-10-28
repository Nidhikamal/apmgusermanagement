package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.CustNotificationRequestDTO;

/**
 * 
 * DTO class for sending the response  
 * 
 * @author  
 *
 */

public class CustNotificationResponseDTO extends CustNotificationRequestDTO{
	
	/**
	 * property that is used to set the message
	 * in service when a particular action carried out in there
	 */
	private String responseMessage;

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
	public CustNotificationResponseDTO() {

	}

}
