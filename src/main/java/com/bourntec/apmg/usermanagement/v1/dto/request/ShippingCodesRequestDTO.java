package com.bourntec.apmg.usermanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.ShippingCodes;

/**
 * 
 * Class is used as a data transfer object for Brands
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
public class ShippingCodesRequestDTO {

	private String shipCode;
	private String shipName;
	private String locationCode;
	private String trackUrl;

	public String getShipCode() {
		return shipCode;
	}

	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getTrackUrl() {
		return trackUrl;
	}

	public void setTrackUrl(String trackUrl) {
		this.trackUrl = trackUrl;
	}

	public ShippingCodes toModel(ShippingCodesRequestDTO shipcodesRequestDTO) {
		ShippingCodes shipcodes = new ShippingCodes();

		try {
			shipcodes.setShipCode(shipcodesRequestDTO.getShipCode());
			shipcodes.setShipName(shipcodesRequestDTO.getShipName());
			shipcodes.setLocationCode(shipcodesRequestDTO.getLocationCode());
			shipcodes.setTrackUrl(shipcodesRequestDTO.getTrackUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shipcodes;

	}

}
