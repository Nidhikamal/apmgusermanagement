package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.ShippingCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.ShippingCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ShippingCodesResponseDTO;

public interface ShippingCodesService {
	
	
	
	ShippingCodesResponseDTO getShippingCodesById(String id);

	List<ShippingCodes> findAllShippingCodes();

	ShippingCodesResponseDTO saveShippingCodes(ShippingCodesRequestDTO shippingCodesReq);

	ShippingCodesResponseDTO updateShippingCodes(String id, ShippingCodesRequestDTO shippingCodesReq);
	
	List<ShippingCodes> findShippingCodeByCriteria(ShippingCodesRequestDTO shippingCodesReq);


}
