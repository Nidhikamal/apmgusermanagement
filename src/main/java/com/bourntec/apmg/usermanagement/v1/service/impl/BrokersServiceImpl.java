package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.Brokers;
import com.bourntec.apmg.usermanagement.v1.dto.request.BrokersRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BrokersResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.BrokersRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.BrokersService;


@Service(value = "BrokersServiceImpl")
public class BrokersServiceImpl implements BrokersService {

	private static final Logger logger = LogManager.getLogger(BrokersServiceImpl.class);

	@Autowired
	BrokersRepository brokersRepository;


	/**
	 * This method findBrokersById
	 * 
	 * @param brokerId
	 * @return BrokersResponseDTO
	 * @throws Exception
	 */

	public BrokersResponseDTO findBrokersById(String brokerId) throws Exception {

		logger.info(" Going to findBrokersById");
		BrokersResponseDTO brokersResponseDTO = new BrokersResponseDTO();
		try {
			Optional<Brokers> brokers = brokersRepository.findById(brokerId);
			if (brokers != null) {
				BeanUtils.copyProperties(brokers.get(), brokersResponseDTO);
				logger.info("RetrieveBrokersById");
			} else {
				throw new ResourceNotFoundException(ErrorCodes.BROKER_NOT_FOUND.getMessage());
			}

		} catch (Exception e) {
			logger.error("findBrokersById" + e);
			throw e;
		}
		return brokersResponseDTO;
	}

	/**
	 * This method findAllBrokers
	 * 
	 * @return BrokersResponseDTO list
	 * @throws Exception
	 */
	public List<BrokersResponseDTO> findAllBrokers() throws Exception {

		List<BrokersResponseDTO> brokersResponseDTOsList = new ArrayList<BrokersResponseDTO>();
		logger.info(" Going to retrieveAllBrokers");
		try {
			List<Brokers> brokersList = brokersRepository.findAll();
			if (brokersList != null && brokersList.size() > 0) {
				brokersList.forEach((brokers) -> {
					BrokersResponseDTO brokersResponseDTO = new BrokersResponseDTO();
					BeanUtils.copyProperties(brokers, brokersResponseDTO);
					brokersResponseDTOsList.add(brokersResponseDTO);

				});
				logger.info("findAllBrokers");
			} else {
				logger.error(" Error findAllBrokers ");
			}
			return brokersResponseDTOsList;
		} catch (Exception e) {
			logger.error("findAllBrokers" + e);
			throw e;
		}

	}

	/**
	 * This method saveBrokers
	 * 
	 * @return BrokersResponseDTO
	 * @throws Exception
	 */

	public BrokersResponseDTO saveBrokers(BrokersRequestDTO brokersRequestDTO) throws Exception {
		try {
			logger.info(" Going saveBrokers");
			BrokersResponseDTO brokersResponseDTO = new BrokersResponseDTO();
			Brokers brokers = brokersResponseDTO.toModel(brokersRequestDTO);
			Brokers brokersObj = brokersRepository.save(brokers);
			if (brokersObj != null) {
				logger.info("Broker object persisted");
				BeanUtils.copyProperties(brokersObj, brokersResponseDTO);
			} else {
				logger.error(" Error in persist Broker object ");
				brokersResponseDTO.setResponseMessage("Error in persist Broker object ");
			}
			return brokersResponseDTO;
		} catch (Exception e) {
			logger.error("saveBrokers" + e);
			throw e;
		}
	}

	/**
	 * This method update brokers
	 * 
	 * @return ParcelDetailResponseDTO
	 * @throws Exception
	 */

	public BrokersResponseDTO updateBrokers(String brokerId, BrokersRequestDTO brokersRequestDTO) throws Exception {
		try {

			logger.info(" Going to updateBrokers");
			BrokersResponseDTO brokersResponseDTO = new BrokersResponseDTO();
			Brokers brokers = brokersRequestDTO.toModel(brokersRequestDTO);
			brokers.setBrokerId(brokerId);
			Brokers brokersObjects = brokersRepository.save(brokers);

			if (brokersObjects != null) {
				logger.info("UpdateBrokers");
				BeanUtils.copyProperties(brokersObjects, brokersResponseDTO);
			} else {
				logger.error(" Error in UpdateBrokers ");
				brokersResponseDTO.setResponseMessage("Error in UpdateBrokers");
			}

			return brokersResponseDTO;
		} catch (Exception e) {
			logger.error("updateBrokers" + e);
			throw e;
		}

	}

	/**
	 * This method Searches brokers by criteria
	 * @author Amal
	 * @return List<Brokers>
	 * @throws Exception
	 */
	
	@Override
	public List<Brokers> findBrokersByCriteria(BrokersRequestDTO brokersRequestDTO) {
			GenericSpesification<Brokers> genericSpesification = new GenericSpesification<Brokers>();
			
			if(brokersRequestDTO.getBirthStar()!=null) {
				 genericSpesification.add(new SearchCriteria("birthStar", brokersRequestDTO.getBirthStar(), SearchOperation.MATCH));
				}
				if(brokersRequestDTO.getBrokerId()!=null) {
		        genericSpesification.add(new SearchCriteria("brokerId", brokersRequestDTO.getBrokerId(), SearchOperation.MATCH));
				}
				if(brokersRequestDTO.getBrokerName()!=null) {
		        genericSpesification.add(new SearchCriteria("brokerName", brokersRequestDTO.getBrokerName(), SearchOperation.MATCH));
				}
				if(brokersRequestDTO.getDescription()!=null) {
		        genericSpesification.add(new SearchCriteria("description", brokersRequestDTO.getDescription(), SearchOperation.MATCH));
				}
				if(brokersRequestDTO.getEmail()!=null) {
			        genericSpesification.add(new SearchCriteria("email", brokersRequestDTO.getEmail(), SearchOperation.MATCH));
					}
				if(brokersRequestDTO.getLocationCode()!=null) {
			        genericSpesification.add(new SearchCriteria("locationCode", brokersRequestDTO.getLocationCode(), SearchOperation.MATCH));
					}
				if(brokersRequestDTO.getPhone()!=null) {
			        genericSpesification.add(new SearchCriteria("phone", brokersRequestDTO.getPhone(), SearchOperation.MATCH));
					}
				if(brokersRequestDTO.getStatus()!=null) {
			        genericSpesification.add(new SearchCriteria("status", brokersRequestDTO.getStatus(), SearchOperation.MATCH));
					}
			
			 return brokersRepository.findAll(genericSpesification);
		}
	
	
	
}
