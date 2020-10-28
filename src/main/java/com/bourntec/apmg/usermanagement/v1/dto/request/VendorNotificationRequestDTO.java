package com.bourntec.apmg.usermanagement.v1.dto.request;

import org.springframework.beans.BeanUtils;

import com.bourntec.apmg.entity.VendorNotification;

import lombok.Getter;
import lombok.Setter;

/**
 * VendorNotificationRequestDTO
 * @author vidya.p
 */
@Getter
@Setter
public class VendorNotificationRequestDTO  {

	private String vendorNo;
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

	
	
	/** default constructor */
	public VendorNotificationRequestDTO() {
	}

	

	public VendorNotification toModel(VendorNotificationRequestDTO vendorNotificationRequestDTO) {


		VendorNotification notification=new VendorNotification();
		BeanUtils.copyProperties(vendorNotificationRequestDTO,notification);
		return notification;
	
	
	}

}