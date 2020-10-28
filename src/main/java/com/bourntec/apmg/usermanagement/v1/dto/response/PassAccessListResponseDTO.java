package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.PassAccessListRequestDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassAccessListResponseDTO extends PassAccessListRequestDTO {
	private String responseMessage;
}
