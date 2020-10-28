package com.bourntec.apmg.usermanagement.v1.dto.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.bourntec.apmg.entity.VendorBrandDetails;
import com.bourntec.apmg.entity.VendorContactDetails;
import com.bourntec.apmg.entity.VendorData;
import com.bourntec.apmg.entity.VendorNotification;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

/**
 *VendorDataRequestDTO
 * @author vidya.p
 */

public class VendorDataRequestDTO  {
	
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
	private List<VendorContactDetailsRequestDTO> vendorContactDetails;
	private List<VendorEmployeesRequestDTO> vendorEmployees;
	private List<VendorBrandDetailsRequestDTO> vendorBrandDetails;
	private VendorShippingDetailsRequestDTO vendorShippingDetails;





	public VendorData toModel(VendorDataRequestDTO vendorDataRequestDTO) {

		VendorData vendorData = new VendorData();

		try {
			vendorData.setAddress(vendorDataRequestDTO.getAddress());
			vendorData.setAddress2(vendorDataRequestDTO.getAddress2());
			vendorData.setAnniversary(vendorDataRequestDTO.getAnniversary());
			vendorData.setBankAccountNo(vendorDataRequestDTO.getBankAccountNo());
			vendorData.setBankName(vendorDataRequestDTO.getBankName());
			vendorData.setBankTransaction(vendorDataRequestDTO.getBankTransaction());
			vendorData.setBirthDate(vendorDataRequestDTO.getBirthDate());
			vendorData.setCity(vendorDataRequestDTO.getCity());
			vendorData.setComments(vendorDataRequestDTO.getComments());
			vendorData.setCompanyUrl(vendorDataRequestDTO.getCompanyUrl());
			vendorData.setCompanyUrl2(vendorDataRequestDTO.getCompanyUrl2());
			vendorData.setCompanyUrl3(vendorDataRequestDTO.getCompanyUrl3());
			vendorData.setContactEmail(vendorDataRequestDTO.getContactEmail());
			vendorData.setContactName(vendorDataRequestDTO.getContactName());
			vendorData.setCountry(vendorDataRequestDTO.getCountry());
			vendorData.setEmailAddress(vendorDataRequestDTO.getEmailAddress());
			vendorData.setFax(vendorDataRequestDTO.getFax());
			vendorData.setFaxs(vendorDataRequestDTO.getFaxs());
			vendorData.setGlAccountno(vendorDataRequestDTO.getGlAccountno());
			vendorData.setLocationCode(vendorDataRequestDTO.getLocationCode());
			vendorData.setPhone1(vendorDataRequestDTO.getPhone1());
			vendorData.setPhone11s(vendorDataRequestDTO.getPhone11s());
			vendorData.setPurAccNo(vendorDataRequestDTO.getPurAccNo());
			vendorData.setState(vendorDataRequestDTO.getState());
			vendorData.setStatus(vendorDataRequestDTO.getStatus());
			vendorData.setTerms(vendorDataRequestDTO.getTerms());
			vendorData.setPremium(vendorDataRequestDTO.getPremium());
			vendorData.setTotalCredit(vendorDataRequestDTO.getTotalCredit());
			vendorData.setTotalDue(vendorDataRequestDTO.getTotalDue());
			vendorData.setTotalPaid(vendorDataRequestDTO.getTotalPaid());
			vendorData.setVendorName(vendorDataRequestDTO.getVendorName());
			vendorData.setVendorNo(vendorDataRequestDTO.getVendorNo());	
			vendorData.setZip(vendorDataRequestDTO.getZip());
			vendorData.setZips(vendorDataRequestDTO.getZips());
			if(vendorDataRequestDTO.getVendorBrandDetails()!=null&&vendorDataRequestDTO.getVendorBrandDetails().size()>0)
			{				
				List<VendorBrandDetails> brandDetailsList=new ArrayList<VendorBrandDetails>();		
				for(VendorBrandDetailsRequestDTO vendorBrandDetailsRequestDTO:vendorDataRequestDTO.getVendorBrandDetails()){
					VendorBrandDetails branddetails=new VendorBrandDetails();
					BeanUtils.copyProperties(vendorBrandDetailsRequestDTO,branddetails);
				//	branddetails.setVendorData(vendorData);
					brandDetailsList.add(branddetails);
				}				
			//	vendorData.setVendorBrandDetails(brandDetailsList);
			}
			if(vendorDataRequestDTO.getVendorContactDetails()!=null&&vendorDataRequestDTO.getVendorContactDetails().size()>0)
			{
				List<VendorContactDetails> contactDetailsList=new ArrayList<VendorContactDetails>();		
				for(VendorContactDetailsRequestDTO contactDetailsRequestDTO:vendorDataRequestDTO.getVendorContactDetails()){
					VendorContactDetails contactDetails=new VendorContactDetails();
					BeanUtils.copyProperties(contactDetailsRequestDTO,contactDetails);
					contactDetailsList.add(contactDetails);
				}	
		//		vendorData.setVendorContactDetails(contactDetailsList);
			}
			/*
			 * if(vendorDataRequestDTO.getVendorEmployees()!=null&&vendorDataRequestDTO.
			 * getVendorEmployees().size()>0) { List<VendorEmployees> employeeList=new
			 * ArrayList<VendorEmployees>(); for(VendorEmployeesRequestDTO
			 * vendorEmployeesRequestDTO:vendorDataRequestDTO.getVendorEmployees()){
			 * VendorEmployees employees=new VendorEmployees();
			 * BeanUtils.copyProperties(vendorEmployeesRequestDTO,employees);
			 * employees.setVendorData(vendorData);
			 * 
			 * employeeList.add(employees); } //
			 * vendorData.setVendorEmployees(employeeList); }
			 * if(vendorDataRequestDTO.getVendorShippingDetails()!=null) {
			 * VendorShippingDetails shippingDetails=new VendorShippingDetails();
			 * BeanUtils.copyProperties(vendorDataRequestDTO.getVendorShippingDetails(),
			 * shippingDetails); shippingDetails.setVendorData(vendorData); //
			 * vendorData.setVendorShippingDetails(shippingDetails);
			 * 
			 * }
			 */
		} catch (Exception e) {

		}
		return vendorData;

	}



}