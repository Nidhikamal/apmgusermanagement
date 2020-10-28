package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.FaqDetailsRequestDTO;

//import javax.validation.constraints.NotNull;


/**
 * DTO class for sending the response

 * @author Vidya
 *
 */
public class FaqResponseDTO extends FaqDetailsRequestDTO {
	private Integer id;
	
	private String responseMessage;
	
	
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


}
