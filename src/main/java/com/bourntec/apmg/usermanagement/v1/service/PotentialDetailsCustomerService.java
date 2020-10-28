package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.PotentialGroup;
import com.bourntec.apmg.usermanagement.v1.dto.request.PotentialCustomerGroupRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PotentialCustomerGroupResponseDTO;

public interface PotentialDetailsCustomerService {

	List<PotentialGroup> findAllPotentialCustomer();

	PotentialCustomerGroupResponseDTO findBypotentialcustomerid(Long id);

	PotentialCustomerGroupResponseDTO updatePotentialcustomer(Long id,
			PotentialCustomerGroupRequestDTO potentialCustomerGroupRequestDTO);

	PotentialCustomerGroupResponseDTO potentialcustomersave(
			PotentialCustomerGroupRequestDTO potentialCustomerGroupRequestDTO);



	List<PotentialGroup> fetchBypotentialCustomer(PotentialCustomerGroupRequestDTO brandsreqDTO);

}
