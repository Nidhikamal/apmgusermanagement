package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.CodesLocation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CodesLocationRequestDTO {

	private String locationCode;
	private String locationName;
	private String emailId;
	private String assignedEmailId;
	private String description;

	public CodesLocation toModel(CodesLocationRequestDTO locationCodeRequestDTO) {
		CodesLocation locationCode = new CodesLocation();
		locationCode.setLocationCode(locationCodeRequestDTO.getLocationCode());
		locationCode.setLocationName(locationCodeRequestDTO.getLocationName());
		locationCode.setAssignedEmailId(locationCodeRequestDTO.getAssignedEmailId());
		locationCode.setDescription(locationCodeRequestDTO.getDescription());
		locationCode.setEmailId(locationCodeRequestDTO.getEmailId());
		// countryCodes.setStateCodesSet(countryRequestDTO.getStateCodesSet());

		return locationCode;
	}

}
