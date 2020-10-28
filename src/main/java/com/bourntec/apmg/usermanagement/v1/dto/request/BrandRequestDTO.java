package com.bourntec.apmg.usermanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.BrandDetails;

/**
 * 
 * Class is used as a data transfer object for Brands
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
public class BrandRequestDTO {

	
	
	private Long brandId;
    public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	private String brandName;
    private String brandStatus;
    private String brandDesc;

	  
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBrandStatus() {
		return brandStatus;
	}
	public void setBrandStatus(String brandStatus) {
		this.brandStatus = brandStatus;
	}
	public String getBrandDesc() {
		return brandDesc;
	}
	public void setBrandDesc(String brandDesc) {
		this.brandDesc = brandDesc;
	}
	
	
	public BrandDetails toModel(BrandRequestDTO brandRequestDTO) {
		BrandDetails brands = new BrandDetails();
		
		try {
			brands.setBrandId(brandRequestDTO.getBrandId());
			brands.setBrandName(brandRequestDTO.getBrandName());
			brands.setBrandStatus(brandRequestDTO.getBrandStatus());
			brands.setBrandDesc(brandRequestDTO.getBrandDesc());
		} catch (Exception e) {
            e.printStackTrace();
		}
		return brands;

	}
		
}
