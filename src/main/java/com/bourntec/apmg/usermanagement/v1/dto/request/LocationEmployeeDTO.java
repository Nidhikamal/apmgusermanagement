package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.LocationEmployee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationEmployeeDTO {
	
	private Long id;
    private String empId;
    private String name;
    private String locationCode;
	public LocationEmployee toModel(LocationEmployeeDTO locationEmployeeReq) {
		LocationEmployee	l = new  LocationEmployee()	;
		l.setId(locationEmployeeReq.getId());
		l.setEmpId(locationEmployeeReq.getEmpId());
		l.setLocationCode(locationEmployeeReq.getLocationCode());
		l.setName(locationEmployeeReq.getName());
		
		
		return l;
	}
}
