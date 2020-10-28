package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.PaymentTermsRequestDTO;

//import javax.validation.constraints.NotNull;


/**
 * DTO class for sending the response

 * @author Vidya
 *
 */
public class PaymentTermsResponseDTO extends PaymentTermsRequestDTO {
	private Long terms;
	private String responseMessage;
	

	public Long getTerms() {
		return terms;
	}
	public void setTerms(Long terms) {
		this.terms = terms;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}


}
