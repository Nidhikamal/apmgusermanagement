package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.VendorCountryCodes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VendorCountryCodesRequestDTO {

	private String countryCode;
	private String countryName;
	private String currencyCode;
	private String displayWeb;

	public VendorCountryCodes toModel(VendorCountryCodesRequestDTO countryRequestDTO) {
		VendorCountryCodes countryCodes = new VendorCountryCodes();
		countryCodes.setCountryCode(countryRequestDTO.getCountryCode());
		countryCodes.setCountryName(countryRequestDTO.getCountryName());
		countryCodes.setCurrencyCode(countryRequestDTO.getCurrencyCode());
		countryCodes.setDisplayWeb(countryRequestDTO.getDisplayWeb());

		return countryCodes;
	}

}
