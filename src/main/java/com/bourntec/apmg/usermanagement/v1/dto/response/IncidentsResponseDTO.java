package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.IncidentsRequestDTO;

//import javax.validation.constraints.NotNull;


/**
 * DTO class for sending the response

 * @author Vidya
 *
 */
public class IncidentsResponseDTO extends IncidentsRequestDTO {
	
	private String responseMessage;
	
	
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}


}
