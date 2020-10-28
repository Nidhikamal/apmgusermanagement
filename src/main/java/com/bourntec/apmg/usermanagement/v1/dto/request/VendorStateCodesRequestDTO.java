package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.VendorStateCodes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class VendorStateCodesRequestDTO {

	
	private String stateCode;
	private String stateName;
	private String displayWeb;
	private String countryCode;
	
	public VendorStateCodes toModel(VendorStateCodesRequestDTO countryRequestDTO) {
		VendorStateCodes  vendorStateCodes  =new  VendorStateCodes();
		vendorStateCodes.setStateCode(countryRequestDTO.getStateCode());
		vendorStateCodes.setDisplayWeb(countryRequestDTO.getDisplayWeb());
		vendorStateCodes.setStateName(countryRequestDTO.getStateName());
		vendorStateCodes.setCountryCode(countryRequestDTO.getCountryCode());
		return vendorStateCodes;
	}
}
