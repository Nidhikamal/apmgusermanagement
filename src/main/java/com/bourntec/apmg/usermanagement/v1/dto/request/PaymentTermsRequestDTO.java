package com.bourntec.apmg.usermanagement.v1.dto.request;

import java.util.Date;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.PaymentTerms;


/**
 * 
 * Class is used as a data transfer object for Table MerchandiseCategory
 * 
 * @author vidya.p 
 *
 */

@Validated
public class PaymentTermsRequestDTO {
	private Long terms;
	private String termDesc;
	private String dueDateType;
	private Long dueDateDay;
	private String discDateType;
	private Long discDateDay;
	private Double discPer;
	private Date createDate;
	private String createUser;
	private String locationCode;
	
	public Long getTerms() {
		return terms;
	}
	public void setTerms(Long terms) {
		this.terms = terms;
	}
	public String getTermDesc() {
		return termDesc;
	}
	public void setTermDesc(String termDesc) {
		this.termDesc = termDesc;
	}
	public String getDueDateType() {
		return dueDateType;
	}
	public void setDueDateType(String dueDateType) {
		this.dueDateType = dueDateType;
	}
	public Long getDueDateDay() {
		return dueDateDay;
	}
	public void setDueDateDay(Long dueDateDay) {
		this.dueDateDay = dueDateDay;
	}
	public String getDiscDateType() {
		return discDateType;
	}
	public void setDiscDateType(String discDateType) {
		this.discDateType = discDateType;
	}
	public Long getDiscDateDay() {
		return discDateDay;
	}
	public void setDiscDateDay(Long discDateDay) {
		this.discDateDay = discDateDay;
	}
	public Double getDiscPer() {
		return discPer;
	}
	public void setDiscPer(Double discPer) {
		this.discPer = discPer;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public PaymentTerms toModel(PaymentTermsRequestDTO paymentTermsRequestDTO) {

		PaymentTerms paymentTerms = new PaymentTerms();
	
		try {
			paymentTerms.setTerms(paymentTermsRequestDTO.getTerms());
			paymentTerms.setCreateDate(paymentTermsRequestDTO.getCreateDate());
			paymentTerms.setDiscDateDay(paymentTermsRequestDTO.getDiscDateDay());
			paymentTerms.setDiscDateType(paymentTermsRequestDTO.getDiscDateType());
			paymentTerms.setLocationCode(paymentTermsRequestDTO.getLocationCode());
			paymentTerms.setTermDesc(paymentTermsRequestDTO.getTermDesc());
			paymentTerms.setCreateUser(paymentTermsRequestDTO.getCreateUser());
			paymentTerms.setDiscPer(paymentTermsRequestDTO.getDiscPer());
			paymentTerms.setDueDateDay(paymentTermsRequestDTO.getDueDateDay());
			paymentTerms.setDueDateType(paymentTermsRequestDTO.getDueDateType());
		} catch (Exception e) {

		}
		return paymentTerms;

	}



}
