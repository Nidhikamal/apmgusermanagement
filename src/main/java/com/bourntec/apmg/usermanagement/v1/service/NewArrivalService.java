package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.NewArrivals;
import com.bourntec.apmg.usermanagement.v1.dto.request.ArrivalsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ArrivalsResponseDTO;

public interface NewArrivalService {

	ArrivalsResponseDTO getArrivalsById(Long id);

	List<NewArrivals> findAllNewArrivals();

	ArrivalsResponseDTO saveArrivals(ArrivalsRequestDTO arrivalReqDTO);

	ArrivalsResponseDTO updateArrivals(Long id, ArrivalsRequestDTO arrivalReqDTO);
	
	List<NewArrivals> findArrivalsDataByCriteria(ArrivalsRequestDTO arrivalReqDTO);

	ArrivalsResponseDTO deleteNewArrivals(Long id);

}
