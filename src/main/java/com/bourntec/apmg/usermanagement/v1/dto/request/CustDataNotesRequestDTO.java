package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.CustDataNotes;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Class is used as a data transfer object for Table CustDataNotes
 * 
 * @author vidya.p 
 *
 */

@Getter
@Setter

public class CustDataNotesRequestDTO  {

	//@JsonIgnore
	private String custNotes;
	//private byte[] custNotesBytes;
	private String locationCode;	
	private String custNo;
	
	public CustDataNotes toModel(CustDataNotesRequestDTO custDataNotesRequestDTO) {
		CustDataNotes custDataNotes=new CustDataNotes();
		custDataNotes.setCustNo(custDataNotesRequestDTO.getCustNo());
		if(custDataNotesRequestDTO.getCustNotes()!=null) {
			custDataNotes.setCustNotes(custDataNotesRequestDTO.getCustNotes().getBytes());
		}
		
		custDataNotes.setLocationCode(custDataNotesRequestDTO.getLocationCode());
		return custDataNotes;
	}

	

}