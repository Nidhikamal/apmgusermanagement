package com.bourntec.apmg.usermanagement.v1.dto.request;

import java.util.Date;

import com.bourntec.apmg.entity.CustDataShippingDetails;

/**
 * 
 * Class is used as a data transfer object for Table CustData
 * 
 * @author vidya.p
 *
 */

public class CustDataShippingDetailsRequestDTO {
	private String custNo;
	private long custShipId;
	private Long shipPhone;
	private String shipAddress;
	private String shipCity;

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public long getCustShipId() {
		return custShipId;
	}

	public void setCustShipId(long custShipId) {
		this.custShipId = custShipId;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

//	public boolean isShipmentaddr() {
//		return shipmentaddr;
//	}
//
//	public void setShipmentaddr(boolean shipmentaddr) {
//		this.shipmentaddr = shipmentaddr;
//	}

	public String getShipPhones() {
		return shipPhones;
	}

	public void setShipPhones(String shipPhones) {
		this.shipPhones = shipPhones;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	private String shipState;
	private String state;
	private Long shipZip;
	private String shipCountry;
	private String country;
	private String priorityCode;
	private Date lastSaleDate;
	private Date nextCallDate;
	private String shipAddress2;
	private String shipName;
	private String shipZips;
	private String companyName;
//	private boolean shipmentaddr;
	private String shipPhones;
	private String locationCode;

	public CustDataShippingDetails toModel(CustDataShippingDetailsRequestDTO custData2RequestDTO) {

		CustDataShippingDetails custData = new CustDataShippingDetails();

		try {
			custData.setCustNo(custData2RequestDTO.getCustNo());
			custData.setCompanyName(custData2RequestDTO.getCompanyName());
			//custData.setCountry(custData2RequestDTO.getCountry());
			custData.setCustShipId(custData2RequestDTO.getCustShipId());
			custData.setLastSaleDate(custData2RequestDTO.getLastSaleDate());
			custData.setLocationCode(custData2RequestDTO.getLocationCode());
			custData.setNextCallDate(custData2RequestDTO.getNextCallDate());
			custData.setPriorityCode(custData2RequestDTO.getPriorityCode());
			custData.setShipAddress(custData2RequestDTO.getShipAddress());
			custData.setShipAddress2(custData2RequestDTO.getShipAddress2());
			custData.setShipCity(custData2RequestDTO.getShipCity());
			custData.setShipCountry(custData2RequestDTO.getShipCountry());
			custData.setShipName(custData2RequestDTO.getShipName());
			custData.setShipPhone(custData2RequestDTO.getShipPhone());
			custData.setShipZip(custData2RequestDTO.getShipZip());
			custData.setShipState(custData2RequestDTO.getShipState());
			custData.setShipZips(custData2RequestDTO.getShipZips());
			//custData.setState(custData2RequestDTO.getState());
		} catch (Exception e) {

		}
		return custData;

	}

}
