package com.bourntec.apmg.usermanagement.v1.dto.request;

import org.springframework.beans.BeanUtils;

import com.bourntec.apmg.entity.VendorBrandDetails;
import com.bourntec.apmg.entity.VendorContactDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * VendorContactDetailsRequestDTO 
 * @author Vidya.p
 */



public class VendorContactDetailsRequestDTO {

	@JsonIgnore
	private Long id;
	private String vendorId;
	private String phone;
	private String fax;
	private String cell;


	/** default constructor */
	public VendorContactDetailsRequestDTO() {
	}



	


	public String getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCell() {
		return this.cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}






	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public VendorContactDetails toModel(VendorContactDetailsRequestDTO vendorcontactRequestDTO) {
		VendorContactDetails brandDetails=new VendorContactDetails();
		BeanUtils.copyProperties(vendorcontactRequestDTO,brandDetails);
		return brandDetails;
	}
}