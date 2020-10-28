package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.CountryCodes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryCodesRequestDTO  {

	private String countryCode;
	private String countryName;
	private String currencyCode;
	private String displayWeb;


	public CountryCodes toModel(CountryCodesRequestDTO countryRequestDTO) {
		CountryCodes countryCodes = new CountryCodes();
		countryCodes.setCountryCode(countryRequestDTO.getCountryCode());
		countryCodes.setCountryName(countryRequestDTO.getCountryName());
		countryCodes.setCurrencyCode(countryRequestDTO.getCurrencyCode());
		countryCodes.setDisplayWeb(countryRequestDTO.getDisplayWeb());

		return countryCodes;
	}

}
