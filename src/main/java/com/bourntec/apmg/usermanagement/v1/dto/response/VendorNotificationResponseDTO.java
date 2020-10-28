package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.VendorNotificationRequestDTO;

/**
 * VendorData entity.
 * 
 * @author vidya.p
 */

public class VendorNotificationResponseDTO extends VendorNotificationRequestDTO {

	private String vendorNo;
	private String responseMessage;
	public String getVendorNo() {
		return vendorNo;
	}
	public void setVendorNo(String vendorNo) {
		this.vendorNo = vendorNo;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}