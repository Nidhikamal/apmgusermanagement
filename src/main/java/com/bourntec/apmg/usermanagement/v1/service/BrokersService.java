package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.Brokers;
import com.bourntec.apmg.usermanagement.v1.dto.request.BrokersRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BrokersResponseDTO;

public interface BrokersService {
	
	
	/**
	 * This method findBrokersById
	 * @param brokerId
	 * @return BrokersResponseDTO
	 * @throws Exception 
	 */
	BrokersResponseDTO findBrokersById(String brokerId)throws Exception;
	/**
	 * This method findAllBrokers
	 * @return BrokersResponseDTO list
	 * @throws Exception 
	 */
	List<BrokersResponseDTO> findAllBrokers()throws Exception;
	/**
	 * This method saveBrokers
	 * @return BrokersResponseDTO
	 * @throws Exception 
	 */
	BrokersResponseDTO saveBrokers(BrokersRequestDTO brokersRequestDTO)throws Exception;
	/**
	 * This method update brokers
	 * @return ParcelDetailResponseDTO
	 * @throws Exception 
	 */
	BrokersResponseDTO updateBrokers(String brokerId, BrokersRequestDTO brokersRequestDTO)throws Exception;
	/**
	 * This method findParcelDetailsById
	 * @return ParcelDetailResponseDTO
	 * @throws Exception 
	 */

	List<Brokers> findBrokersByCriteria(BrokersRequestDTO brokersRequestDTO);
}
