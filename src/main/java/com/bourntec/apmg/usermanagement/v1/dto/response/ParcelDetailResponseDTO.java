package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.ParcelDetailsRequestDTO;

//import javax.validation.constraints.NotNull;


/**
 * DTO class for sending the response

 * @author Vidya
 *
 */
public class ParcelDetailResponseDTO extends ParcelDetailsRequestDTO {

	private String parcelNo;
	private String responseMessage;
	

	public String getParcelNo() {
		return parcelNo;
	}
	public void setParcelNo(String parcelNo) {
		this.parcelNo = parcelNo;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
}
