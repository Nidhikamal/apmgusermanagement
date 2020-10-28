package com.bourntec.apmg.usermanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;


import com.bourntec.apmg.entity.CustomerBrandDetails;

/**
 * 
 * Class is used as a data transfer object for Brands
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
public class CustomerBrandDetailsRequestDTO {

	private Long id;	
	private String status;
	private Long brandId;
	private String custNo;
	private Long termsDays;
	private Double markUp;
	private Double discount;
	private String salesPerson;
	private String previousSalesMan;
	private String salesPerson2;
	private String salesPerson3;
	private Double memoMarkUp;
	
	
	 
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public Long getTermsDays() {
		return termsDays;
	}
	public void setTermsDays(Long termsDays) {
		this.termsDays = termsDays;
	}
	public Double getMarkUp() {
		return markUp;
	}
	public void setMarkUp(Double markUp) {
		this.markUp = markUp;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public String getSalesPerson() {
		return salesPerson;
	}
	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}
	public String getPreviousSalesMan() {
		return previousSalesMan;
	}
	public void setPreviousSalesMan(String previousSalesMan) {
		this.previousSalesMan = previousSalesMan;
	}
	public String getSalesPerson2() {
		return salesPerson2;
	}
	public void setSalesPerson2(String salesPerson2) {
		this.salesPerson2 = salesPerson2;
	}
	public String getSalesPerson3() {
		return salesPerson3;
	}
	public void setSalesPerson3(String salesPerson3) {
		this.salesPerson3 = salesPerson3;
	}
	public Double getMemoMarkUp() {
		return memoMarkUp;
	}
	public void setMemoMarkUp(Double memoMarkUp) {
		this.memoMarkUp = memoMarkUp;
	}
	
	public CustomerBrandDetails toModel(CustomerBrandDetailsRequestDTO CustomerBrandDetailsRequestDTO) {

		CustomerBrandDetails brands = new CustomerBrandDetails();
	
		try {
			brands.setId(CustomerBrandDetailsRequestDTO.getId());
			brands.setStatus(CustomerBrandDetailsRequestDTO.getStatus());
			brands.setBrandId(CustomerBrandDetailsRequestDTO.getBrandId());
			brands.setCustNo(CustomerBrandDetailsRequestDTO.getCustNo());
			brands.setTermsDays(CustomerBrandDetailsRequestDTO.getTermsDays());
			brands.setMarkUp(CustomerBrandDetailsRequestDTO.getMarkUp());
			brands.setDiscount(CustomerBrandDetailsRequestDTO.getDiscount());
			brands.setSalesPerson(CustomerBrandDetailsRequestDTO.getSalesPerson());
			brands.setPreviousSalesMan(CustomerBrandDetailsRequestDTO.getPreviousSalesMan());
			brands.setSalesPerson2(CustomerBrandDetailsRequestDTO.getSalesPerson2());
			brands.setSalesPerson3(CustomerBrandDetailsRequestDTO.getSalesPerson3());
			brands.setMemoMarkUp(CustomerBrandDetailsRequestDTO.getMemoMarkUp());

		} catch (Exception e) {

		}
		return brands;

	}
	 
		
}
