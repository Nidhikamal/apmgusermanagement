package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.CountryCodesRequestDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryCodesResponseDTO extends CountryCodesRequestDTO {

	/**
	 * property that is used to set the message in service when a particular action
	 * carried out in there for eg : when a user is not fetched, showing the user is
	 * not retrieved
	 * 
	 * @TODO need to remove when exception module is implementd
	 */
	private String responseMessage;

	/**
	 * @return the responseMessage
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param responseMessage the responseMessage to set
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
