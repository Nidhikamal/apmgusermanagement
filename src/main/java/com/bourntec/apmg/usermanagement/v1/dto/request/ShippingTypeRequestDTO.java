package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.ShippingType;

import lombok.Getter;
import lombok.Setter;

/**
 * RequestDTO class for ShippingType 
 * @author Tinu
 *
 */
@Getter
@Setter
public class ShippingTypeRequestDTO{

private String system;

private String displayWeb;

private String locationCode;

private String shipTypeName;

private String shipType;

private Long id;

private Double shipChg;

private String shipCode;


public ShippingType toModel(ShippingTypeRequestDTO shippingTypeRequestDTO){

	ShippingType shippingType= new ShippingType();
	shippingType.setSystem(shippingTypeRequestDTO.getSystem());
	shippingType.setDisplayWeb(shippingTypeRequestDTO.getDisplayWeb());
	shippingType.setLocationCode(shippingTypeRequestDTO.getLocationCode());
	shippingType.setShipTypeName(shippingTypeRequestDTO.getShipTypeName());
	shippingType.setShipType(shippingTypeRequestDTO.getShipType());
	shippingType.setId(shippingTypeRequestDTO.getId());
	shippingType.setShipChg(shippingTypeRequestDTO.getShipChg());
	shippingType.setShipCode(shippingTypeRequestDTO.getShipCode());

	return shippingType;
}
}