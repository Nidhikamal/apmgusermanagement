package com.bourntec.apmg.usermanagement.v1.dto.request;

import java.util.Date;

import com.bourntec.apmg.entity.ReturnData;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * This class is used as a data transfer object for ReturnData entity
 * 
 * @author Tinu
 *
 */
@Getter
@Setter
public class ReturnDataRequestDTO {
	
	   	private String returnNo;
	    
	    private Date returnDate;
	   
		private String empNo;
		
		private String custNo;
		
		private String miscName;
		
		private Double miscChg;
		
		private Double total;

		private Double itemTotal;
		
		private String desc1;
		
		private String locationCode;
		
		private String trackingCode;
		
		private String returnMatAuth;
		
		private String shipVia;
		
		private String externalDesc;
		
		private Date createdDate;
		
		private String createdBy;
		
		private Date modifiedDate;
		
		private String modifiedBy;
		
		private String returnFromShowYN;
		
		private String status;
		
		private String returnTo;
		
		private String mailSentYN;
		
		private String returnMemo;
		
		private String memoNo;
		
		private Long versionNo;
		
		private String parcelNo;
		
		private String toShow;
		
		public ReturnData toModel(ReturnDataRequestDTO returnDataRequestDTO)
		{
			ReturnData returnData=new ReturnData();
			returnData.setReturnNo(returnDataRequestDTO.getReturnNo());
			returnData.setReturnDate(returnDataRequestDTO.getReturnDate());
			returnData.setEmpNo(returnDataRequestDTO.getEmpNo());
			returnData.setCustNo(returnDataRequestDTO.getCustNo());
			returnData.setMiscName(returnDataRequestDTO.getMiscName());
			returnData.setMiscChg(returnDataRequestDTO.getMiscChg());
			returnData.setTotal(returnDataRequestDTO.getTotal());
			returnData.setItemTotal(returnDataRequestDTO.getItemTotal());
			returnData.setDesc1(returnDataRequestDTO.getDesc1());
			returnData.setLocationCode(returnDataRequestDTO.getLocationCode());
			returnData.setTrackingCode(returnDataRequestDTO.getTrackingCode());
			returnData.setReturnMatAuth(returnDataRequestDTO.getReturnMatAuth());
			returnData.setShipVia(returnDataRequestDTO.getShipVia());
			returnData.setExternalDesc(returnDataRequestDTO.getExternalDesc());
			returnData.setCreatedDate(returnDataRequestDTO.getCreatedDate());
			returnData.setCreatedBy(returnDataRequestDTO.getCreatedBy());
			returnData.setModifiedDate(returnDataRequestDTO.getModifiedDate());
			returnData.setModifiedBy(returnDataRequestDTO.getModifiedBy());
			returnData.setReturnFromShowYN(returnDataRequestDTO.getReturnFromShowYN());
			returnData.setStatus(returnDataRequestDTO.getStatus());
			returnData.setReturnTo(returnDataRequestDTO.getReturnTo());
			returnData.setMailSentYN(returnDataRequestDTO.getMailSentYN());
			returnData.setReturnMemo(returnDataRequestDTO.getReturnMemo());
			returnData.setMemoNo(returnDataRequestDTO.getMemoNo());
			returnData.setVersionNo(returnDataRequestDTO.getVersionNo());
			returnData.setParcelNo(returnDataRequestDTO.getParcelNo());
			returnData.setToShow(returnDataRequestDTO.getToShow());
			return returnData;
			
		}

		
}
