package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.CreditcardsRequestDTO;

//import javax.validation.constraints.NotNull;



/**
 * DTO class for sending the response
 *  
 * @author Amal Chandra N A
 *
 */

public class CreditcardResponseDTO extends CreditcardsRequestDTO {

	// properties
	//@NotNull
	private Long id;
	
	/**
	 * property that is used to set the message
	 * in service when a particular action carried out in there
	 * for eg : when a brand is not fetched, showing the brand is not retrieved
	 * @TODO need to remove when exception module is implementd
	 */
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
	
	public CreditcardResponseDTO() {

	}
}
