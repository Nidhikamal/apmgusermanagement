package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.PassTableRequestDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO class for sending the response
 * 
 * @author Srijini T.S
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class PassTableResponseDTO extends PassTableRequestDTO {
	private String responseMessage;
}
