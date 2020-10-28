package com.bourntec.apmg.usermanagement.v1.dto.request;


import java.util.Date;

import com.bourntec.apmg.entity.CustData2;





public class CustData2RequestDTO {            
	private String custNo;
	private Long shipPhone;
	private String shipAddress;
	private String shipCity;
	private String shipState;
	private Long shipZip;
	private String shipCountry;
	private String priorityCode;
	private Date lastSaleDate;
	private Date nextCallDate;
	private String shipAddress2;
	private String shipName;
	private String shipZips;
	private String locationCode;
	private String shipPhones;



public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public Long getShipPhone() {
		return shipPhone;
	}

	public void setShipPhone(Long shipPhone) {
		this.shipPhone = shipPhone;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipState() {
		return shipState;
	}

	public void setShipState(String shipState) {
		this.shipState = shipState;
	}

   public Long getShipZip() {
		return shipZip;
	}

  public void setShipZip(Long shipZip) {
		this.shipZip = shipZip;
	}

	public String getShipCountry() {
		return shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

	public String getPriorityCode() {
		return priorityCode;
	}

	public void setPriorityCode(String priorityCode) {
		this.priorityCode = priorityCode;
	}

	public Date getLastSaleDate() {
		return lastSaleDate;
	}

	public void setLastSaleDate(Date lastSaleDate) {
		this.lastSaleDate = lastSaleDate;
	}

	public Date getNextCallDate() {
		return nextCallDate;
	}

	public void setNextCallDate(Date nextCallDate) {
		this.nextCallDate = nextCallDate;
	}

	public String getShipAddress2() {
		return shipAddress2;
	}

	public void setShipAddress2(String shipAddress2) {
		this.shipAddress2 = shipAddress2;
	}

    public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipZips() {
		return shipZips;
	}

	public void setShipZips(String shipZips) {
		this.shipZips = shipZips;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getShipPhones() {
		return shipPhones;
	}

	public void setShipPhones(String shipPhones) {
		this.shipPhones = shipPhones;
	}



public CustData2 toModel(CustData2RequestDTO custData2RequestDTO) {

	CustData2 custData = new CustData2();

	try {
		custData.setCustNo(custData2RequestDTO.getCustNo());
		custData.setLastSaleDate(custData2RequestDTO.getLastSaleDate());
		custData.setLocationCode(custData2RequestDTO.getLocationCode());
		//custData.setNextCallDate(custData2RequestDTO.getNextCallDate());
		custData.setPriorityCode(custData2RequestDTO.getPriorityCode());
		custData.setShipAddress(custData2RequestDTO.getShipAddress());
		custData.setShipAddress2(custData2RequestDTO.getShipAddress2());
		custData.setShipCity(custData2RequestDTO.getShipCity());
		custData.setShipCountry(custData2RequestDTO.getShipCountry());
		custData.setShipName(custData2RequestDTO.getShipName());
		custData.setShipPhone(custData2RequestDTO.getShipPhone());
		custData.setShipState(custData2RequestDTO.getShipState());
		custData.setShipPhones(custData2RequestDTO.getShipPhones());
		custData.setShipZip(custData2RequestDTO.getShipZip());
		custData.setShipZips(custData2RequestDTO.getShipZips());
	} catch (Exception e) {

	}
	return custData;

}
   



   
}
