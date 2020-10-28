package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.VendorCountryCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorCountryCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorCountryCodesResponseDTO;

public interface VendorCountryCodesService {

	List<VendorCountryCodes> findAllVendorCountry();

	VendorCountryCodesResponseDTO findByVendorcountryCode(String countryCode);

	VendorCountryCodesResponseDTO updateVendorCountry(String countryCode, VendorCountryCodesRequestDTO countryRequestDTO);

	VendorCountryCodesResponseDTO saveVendorCountry(VendorCountryCodesRequestDTO countryRequestDTO);

}
