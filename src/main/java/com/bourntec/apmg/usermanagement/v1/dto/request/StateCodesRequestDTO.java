package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.StateCodes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StateCodesRequestDTO {
	private String stateCode;
	private String stateName;
	private String countryCode;
	private String displayWeb;
	private String sstateCode;

	
	public StateCodes toModel(StateCodesRequestDTO stateRequestDTO) {
		StateCodes code  = new StateCodes();
		code.setStateCode(stateRequestDTO.getStateCode());
		code.setStateName(stateRequestDTO.getStateName());
		code.setDisplayWeb(stateRequestDTO.getDisplayWeb());
		code.setSstateCode(stateRequestDTO.getSstateCode());
		code.setCountryCode(stateRequestDTO.getCountryCode());
		return code;
	}

}
