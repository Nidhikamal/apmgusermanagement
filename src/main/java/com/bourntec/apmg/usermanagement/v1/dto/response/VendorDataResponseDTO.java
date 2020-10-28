package com.bourntec.apmg.usermanagement.v1.dto.response;

import java.util.Date;
import java.util.List;

import com.bourntec.apmg.entity.VendorBrandDetails;
import com.bourntec.apmg.entity.VendorContactDetails;
import com.bourntec.apmg.entity.VendorEmployees;
import com.bourntec.apmg.entity.VendorNotification;
import com.bourntec.apmg.entity.VendorShippingDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorBrandDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorContactDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorEmployeesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorShippingDetailsRequestDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * VendorData entity.
 * 
 * @author vidya.p
 */
@Getter
@Setter
public class VendorDataResponseDTO {
	private String vendorNo;
	private String vendorName;
	private String address;
	private String city;
	private String state;
	private Long zip;
	private Long phone1;
	private Long phone2;
	private Long fax;
	private String purAccNo;
	private Long terms;
	private String comments;
	private Double premium;
	private Double totalDue;
	private Double totalPaid;
	private Double totalCredit;
	private String address2;
	private String country;
	private String status;
	private String zips;
	private String locationCode;
	private String glAccountno;
	private String merchCategory;
	private String emailAddress;
	private String phone1s;
	private String phone2s;
	private String faxs;
	private Date anniversary;
	private Date birthDate;
	private String companyUrl;


	private String emailAddress2;
	private String contactName;
	private String contactEmail;
	private Long phone11s;
	private String bankName;
	private String bankAccountNo;
	private String bankTransaction;	
	private String companyUrl2;
	private String companyUrl3;

	private VendorNotification vendorNotification;
	private List<VendorContactDetailsResponseDTO> vendorContactDetails;
	private List<VendorEmployeesResponseDTO> vendorEmployees;
	private List<VendorBrandDetailsResponseDTO> vendorBrandDetails;
	private VendorShippingDetailsResponseDTO vendorShippingDetails;


	private  String responseMessage;
	
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
}