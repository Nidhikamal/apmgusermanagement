package com.bourntec.apmg.usermanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.CustNotification;

/**
 * 
 * Class is used as a data transfer object for Customer Notification  
 * 
 * @author  
 *
 */

@Validated
public class CustNotificationRequestDTO {
	
	private String custNo;
	private String desc1;
	private String desc2;
	private String order1;
	private String order2;
	private String invoice1;
	private String invoice2;
	private String return1;
	private String return2;
	private String repair1;
	private String repair2;
	
	
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public String getDesc1() {
		return desc1;
	}
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}
	public String getDesc2() {
		return desc2;
	}
	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}
	public String getOrder1() {
		return order1;
	}
	public void setOrder1(String order1) {
		this.order1 = order1;
	}
	public String getOrder2() {
		return order2;
	}
	public void setOrder2(String order2) {
		this.order2 = order2;
	}
	public String getInvoice1() {
		return invoice1;
	}
	public void setInvoice1(String invoice1) {
		this.invoice1 = invoice1;
	}
	public String getInvoice2() {
		return invoice2;
	}
	public void setInvoice2(String invoice2) {
		this.invoice2 = invoice2;
	}
	public String getReturn1() {
		return return1;
	}
	public void setReturn1(String return1) {
		this.return1 = return1;
	}
	public String getReturn2() {
		return return2;
	}
	public void setReturn2(String return2) {
		this.return2 = return2;
	}
	public String getRepair1() {
		return repair1;
	}
	public void setRepair1(String repair1) {
		this.repair1 = repair1;
	}
	public String getRepair2() {
		return repair2;
	}
	public void setRepair2(String repair2) {
		this.repair2 = repair2;
	}
	
	
	public CustNotification toModel(CustNotificationRequestDTO custNotificationRequestDTO) {
		CustNotification cn = new CustNotification();
		
		try {			
			cn.setCustNo(custNotificationRequestDTO.getCustNo());
			cn.setDesc1(custNotificationRequestDTO.getDesc1());
			cn.setDesc2(custNotificationRequestDTO.getDesc2());
			cn.setInvoice1(custNotificationRequestDTO.getInvoice1());
			cn.setInvoice2(custNotificationRequestDTO.getInvoice2());
			cn.setOrder1(custNotificationRequestDTO.getOrder1());
			cn.setOrder2(custNotificationRequestDTO.getOrder2());
			cn.setRepair1(custNotificationRequestDTO.getRepair1());
			cn.setRepair2(custNotificationRequestDTO.getRepair2());
			cn.setReturn1(custNotificationRequestDTO.getReturn1());
			cn.setReturn2(custNotificationRequestDTO.getReturn2());
		} catch (Exception e) {
            e.printStackTrace();
		}
		return cn;
	}

}
