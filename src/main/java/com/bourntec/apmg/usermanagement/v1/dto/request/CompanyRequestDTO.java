package com.bourntec.apmg.usermanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.CompanyData;

/**
 * 
 * Class is used as a data transfer object for Company
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
public class CompanyRequestDTO {

	
	    private String companyCode;
	    private String companyName;
	    private String address1;
	    private String address2;
	    private String desc1;
	    private String webAddress;
	    private String phone;
	    private String fax;
	    private String emailAddress;
	    private String companyFont;
	    private String companySize;
		
	    
	    
	    public String getCompanyCode() {
			return companyCode;
		}
		public void setCompanyCode(String companyCode) {
			this.companyCode = companyCode;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getAddress1() {
			return address1;
		}
		public void setAddress1(String address1) {
			this.address1 = address1;
		}
		public String getAddress2() {
			return address2;
		}
		public void setAddress2(String address2) {
			this.address2 = address2;
		}
		public String getDesc1() {
			return desc1;
		}
		public void setDesc1(String desc1) {
			this.desc1 = desc1;
		}
		public String getWebAddress() {
			return webAddress;
		}
		public void setWebAddress(String webAddress) {
			this.webAddress = webAddress;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getFax() {
			return fax;
		}
		public void setFax(String fax) {
			this.fax = fax;
		}
		public String getEmailAddress() {
			return emailAddress;
		}
		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}
		public String getCompanyFont() {
			return companyFont;
		}
		public void setCompanyFont(String companyFont) {
			this.companyFont = companyFont;
		}
		public String getCompanySize() {
			return companySize;
		}
		public void setCompanySize(String companySize) {
			this.companySize = companySize;
		}
		
		
		public CompanyData toModel(CompanyRequestDTO companyRequestDTO) {
			CompanyData cmpnydata = new CompanyData();
			
			try {
				cmpnydata.setCompanyCode(companyRequestDTO.getCompanyCode());
				cmpnydata.setAddress1(companyRequestDTO.getAddress1());
				cmpnydata.setAddress2(companyRequestDTO.getAddress2());
				cmpnydata.setCompanyFont(companyRequestDTO.getCompanyFont());
				cmpnydata.setCompanyName(companyRequestDTO.getCompanyName());
				cmpnydata.setCompanySize(companyRequestDTO.getCompanySize());
				cmpnydata.setDesc1(companyRequestDTO.getDesc1());
				cmpnydata.setEmailAddress(companyRequestDTO.getEmailAddress());
				cmpnydata.setFax(companyRequestDTO.getFax());
				cmpnydata.setPhone(companyRequestDTO.getPhone());
				cmpnydata.setWebAddress(companyRequestDTO.getWebAddress());
				
			} catch (Exception e) {
	            e.printStackTrace();
			}
			return cmpnydata;

		}
	
}
