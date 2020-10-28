package com.bourntec.apmg.usermanagement.v1.dto.request;

import org.springframework.beans.BeanUtils;

import com.bourntec.apmg.entity.VendorBrandDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * VendorBrandDetailsRequestDTO 
 * @author Vidya.p
 */



public class VendorBrandDetailsRequestDTO {

	@JsonIgnore
	private Long id;
	private String vendorNo;
	private Long brandId;
	private String status;
	


	/** default constructor */
	public VendorBrandDetailsRequestDTO() {
	}

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	

		public String getVendorNo() {
		return vendorNo;
	}

	public void setVendorNo(String vendorNo) {
		this.vendorNo = vendorNo;
	}


	public Long getBrandId() {
		return brandId;
	}



	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}


	

	public VendorBrandDetails toModel(VendorBrandDetailsRequestDTO vendorBrandRequestDTO) {
		VendorBrandDetails brandDetails=new VendorBrandDetails();
		BeanUtils.copyProperties(vendorBrandRequestDTO,brandDetails);
		return brandDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}