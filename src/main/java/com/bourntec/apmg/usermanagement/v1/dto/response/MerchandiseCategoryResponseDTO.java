package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.MerchandiseCategoryRequestDTO;




/**
 * DTO class for sending the response

 * @author Vidya
 *
 */
public class MerchandiseCategoryResponseDTO  {

	private String  categoryCode;
	private String  categoryDescription;
	private String  locationCode;
	
	private String responseMessage;


	public String getCategoryCode() {
		return categoryCode;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public MerchandiseCategoryResponseDTO() {

	}
}
