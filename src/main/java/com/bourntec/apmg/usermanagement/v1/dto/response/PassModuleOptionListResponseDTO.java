package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.PassModuleOptionListRequestDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassModuleOptionListResponseDTO extends PassModuleOptionListRequestDTO {
	private String responseMessage;

}
