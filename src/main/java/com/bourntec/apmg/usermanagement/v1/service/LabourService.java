package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.LabourCharge;
import com.bourntec.apmg.usermanagement.v1.dto.request.LabourChargeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.LabourChargeResponseDTO;

public interface LabourService {

	List<LabourCharge> findAllLabours();

	LabourChargeResponseDTO findBylabourid(Long id);

	LabourChargeResponseDTO updatelabour(Long id, LabourChargeRequestDTO labourChargeRequestDTO);

	LabourChargeResponseDTO savelabour(LabourChargeRequestDTO labourChargeRequestDTO);

	List<LabourCharge> fetchByLabour(LabourChargeResponseDTO locationCodeRequestDTO);

}
