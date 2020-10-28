package com.bourntec.apmg.usermanagement.v1.dto.request;

import org.springframework.beans.BeanUtils;

import com.bourntec.apmg.entity.VendorNotification;
import com.bourntec.apmg.entity.VendorShippingDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * VendorShippingDetailsRequestDTO
 *  @author vidya.p
 */



public class VendorShippingDetailsRequestDTO {

    private Long id;
	private String vendorNo;
	private String shipName;
	private String locationCode;
	private String shipAddress1;
	private String shipAddress2;
	private String shipCity;
	private String shipState;
	private String shipCountry;
	private Long shipZip;
	private Long shipPhone;

	// Constructors

	/** default constructor */
	public VendorShippingDetailsRequestDTO() {
	}


	
	public String getVendorNo() {
		return vendorNo;
	}

	public void setVendorNo(String vendorNo) {
		this.vendorNo = vendorNo;
	}

	public String getShipName() {
		return this.shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getLocationCode() {
		return this.locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getShipAddress1() {
		return this.shipAddress1;
	}

	public void setShipAddress1(String shipAddress1) {
		this.shipAddress1 = shipAddress1;
	}

	public String getShipAddress2() {
		return this.shipAddress2;
	}

	public void setShipAddress2(String shipAddress2) {
		this.shipAddress2 = shipAddress2;
	}

	public String getShipCity() {
		return this.shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipState() {
		return this.shipState;
	}

	public void setShipState(String shipState) {
		this.shipState = shipState;
	}

	public String getShipCountry() {
		return this.shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}


	public Long getShipZip() {
		return shipZip;
	}


	public void setShipZip(Long shipZip) {
		this.shipZip = shipZip;
	}


	public Long getShipPhone() {
		return shipPhone;
	}


	public void setShipPhone(Long shipPhone) {
		this.shipPhone = shipPhone;
	}



	public VendorShippingDetails toModel(VendorShippingDetailsRequestDTO vendorShippingRequestDTO) {


		VendorShippingDetails shippingDetails=new VendorShippingDetails();
		BeanUtils.copyProperties(vendorShippingRequestDTO,shippingDetails);
		return shippingDetails;
	
	
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


}