package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CountryCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.CountryCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CountryCodesResponseDTO;

public interface CountryCodesService {

	CountryCodesResponseDTO saveCustomerCountry(CountryCodesRequestDTO countryRequestDTO);

	CountryCodesResponseDTO updateCountry(String countryCode, CountryCodesRequestDTO countryRequestDTO);

	CountryCodesResponseDTO findBycountryCode(String countryCode);

	List<CountryCodes> fetchAllCountryCode();

	List<CountryCodes> fetchByCustomercountry(CountryCodesRequestDTO brandsreqDTO);

}
