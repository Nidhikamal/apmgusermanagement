package com.bourntec.apmg.usermanagement.v1.dto.request;

import java.util.Date;

import com.bourntec.apmg.entity.ParcelDetails;

import lombok.Getter;
import lombok.Setter;


/**
 * 
 * Class is used as a data transfer object for Table ParcelDetails
 * 
 * @author vidya.p 
 *
 */

@Getter
@Setter
public class ParcelDetailsRequestDTO {

	
		private String parcelNo;
		private String custVendType;
		private String custVendId;
		private String createdBy;
		private Date createdDate;
		private String courierAgency;
		private String parcelName;
		private String parcelStreet;
		private String parcelCity;
		private String parcelState;
		private String parcelCountry;
		private Double parcelWt;
		private String parcelDesc;
		private String acceptedBy;
		private String zip;
		private String parcelStreet2;
		private String trackingNo;
		private String email;	
		private Date endDate;
		private long noBoxes;
		private String locationReceiving;
		private Date receivedDate;
		
		
	public ParcelDetails toModel(ParcelDetailsRequestDTO parcelDetailsRequestDTO ) {

		ParcelDetails parcelDetails = new ParcelDetails();
	
		try {
			parcelDetails.setParcelNo(parcelDetailsRequestDTO.getParcelNo());
			parcelDetails.setAcceptedBy(parcelDetailsRequestDTO.getAcceptedBy());
			parcelDetails.setCourierAgency(parcelDetailsRequestDTO.getCourierAgency());
			parcelDetails.setCreatedBy(parcelDetailsRequestDTO.getCreatedBy());
			parcelDetails.setCreatedDate(parcelDetailsRequestDTO.getCreatedDate());
			parcelDetails.setCustVendId(parcelDetailsRequestDTO.getCustVendId());
			parcelDetails.setCustVendType(parcelDetailsRequestDTO.getCustVendType());
			parcelDetails.setEmail(parcelDetailsRequestDTO.getEmail());
			parcelDetails.setLocationReceiving(parcelDetailsRequestDTO.getLocationReceiving());
			parcelDetails.setNoBoxes(parcelDetailsRequestDTO.getNoBoxes());
			parcelDetails.setParcelCity(parcelDetailsRequestDTO.getParcelCity());
			parcelDetails.setParcelCountry(parcelDetailsRequestDTO.getParcelCountry());
			parcelDetails.setParcelDesc(parcelDetailsRequestDTO.getParcelDesc());
			parcelDetails.setParcelName(parcelDetailsRequestDTO.getParcelName());		
			parcelDetails.setParcelState(parcelDetailsRequestDTO.getParcelState());
			parcelDetails.setParcelStreet(parcelDetailsRequestDTO.getParcelStreet());
			parcelDetails.setParcelStreet2(parcelDetailsRequestDTO.getParcelStreet2());
			parcelDetails.setTrackingNo(parcelDetailsRequestDTO.getTrackingNo());
			parcelDetails.setParcelWt(parcelDetailsRequestDTO.getParcelWt());
			parcelDetails.setZip(parcelDetailsRequestDTO.getZip());
			parcelDetails.setLocationReceiving(parcelDetailsRequestDTO.getLocationReceiving());
		} catch (Exception e) {

		}
		return parcelDetails;

	}



}
