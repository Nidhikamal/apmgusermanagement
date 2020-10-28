package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.VendorCountryCodes;

@Repository(value = "VendorCountryCodesRepository")
public interface VendorCountryCodesRepository 
extends JpaRepository<VendorCountryCodes, String>{

	VendorCountryCodes findBycountryCode(String countryCode);


}
