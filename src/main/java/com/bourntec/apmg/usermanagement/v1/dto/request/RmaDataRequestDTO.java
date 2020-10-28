package com.bourntec.apmg.usermanagement.v1.dto.request;

import java.time.LocalDate;

import com.bourntec.apmg.entity.RmaData;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * This class is used as a data transfer object for RmaData entity
 * 
 * @author Tinu
 *
 */
@Getter
@Setter
public class RmaDataRequestDTO {
	
	private String rmaNo;
	
	private LocalDate rmaDate;
	
	private String empNo;
	
	private String custNo;
	
	private double total;
	
	private String desc1;
	
	private double itemTotal;
	
	private String locationCode;
	
	private String trackingCode;
	
	private String shipVia;
	
	private String createdBy;
	
	private LocalDate createdDate;
	
	private String modifiedBy;
	
	private LocalDate modifiedDate;
	
	private String mailSentYN;
	
	public RmaData toModel(RmaDataRequestDTO rmaDataRequestDTO)
	{
		RmaData rmaData=new RmaData();
		rmaData.setRmaNo(rmaDataRequestDTO.getRmaNo());
		rmaData.setRmaDate(rmaDataRequestDTO.getRmaDate());
		rmaData.setEmpNo(rmaDataRequestDTO.getEmpNo());
		rmaData.setCustNo(rmaDataRequestDTO.getCustNo());
		rmaData.setTotal(rmaDataRequestDTO.getTotal());
		rmaData.setDesc1(rmaDataRequestDTO.getDesc1());
		rmaData.setItemTotal(rmaDataRequestDTO.getItemTotal());
		rmaData.setLocationCode(rmaDataRequestDTO.getLocationCode());
		rmaData.setTrackingCode(rmaDataRequestDTO.getTrackingCode());
		rmaData.setShipVia(rmaDataRequestDTO.getShipVia());
		rmaData.setCreatedBy(rmaDataRequestDTO.getCreatedBy());
		rmaData.setCreatedDate(rmaDataRequestDTO.getCreatedDate());
		rmaData.setModifiedBy(rmaDataRequestDTO.getModifiedBy());
		rmaData.setModifiedDate(rmaDataRequestDTO.getModifiedDate());
		rmaData.setMailSentYN(rmaDataRequestDTO.getMailSentYN());
		return rmaData;
		
	}

}
