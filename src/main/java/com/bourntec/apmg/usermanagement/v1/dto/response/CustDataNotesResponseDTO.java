package com.bourntec.apmg.usermanagement.v1.dto.response;

import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataNotesRequestDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * DTO class for sending the response of CustDataNotes
 * 
 * @author 
 *
 */
@Getter
@Setter
public class CustDataNotesResponseDTO  {
	private String responseMessage;
	private String custNotes;
	//private byte[] custNotesBytes;
	private String locationCode;	
	private String custNo;
}
