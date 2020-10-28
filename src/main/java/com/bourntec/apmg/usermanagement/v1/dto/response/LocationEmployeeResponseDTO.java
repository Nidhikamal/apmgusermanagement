package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.LocationEmployeeDTO;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class LocationEmployeeResponseDTO  extends  LocationEmployeeDTO{
	private String responseMessage;

}
