package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.PotentialGroup;
import com.bourntec.apmg.usermanagement.v1.dto.request.PotentialCustomerGroupRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PotentialCustomerGroupResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.PotentialCustomerGroupRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.PotentialDetailsCustomerService;

@Service(value = "PotentialDetailsCustomerServiceImpl")
public class PotentialDetailsCustomerServiceImpl implements PotentialDetailsCustomerService {

	private static final Logger logger = LogManager.getLogger(PotentialDetailsCustomerServiceImpl.class);

	@Autowired
	private PotentialCustomerGroupRepository potentialCustomerGroupRepository;

	/**
	 * @author naveen This is the main method which is used to save
	 *         PotentialCustomer data
	 * 
	 */

	public PotentialCustomerGroupResponseDTO potentialcustomersave(
			PotentialCustomerGroupRequestDTO potentialCustomerGroupRequestDTO) {

		PotentialCustomerGroupResponseDTO potentialCustomerGroupResponseDTO = new PotentialCustomerGroupResponseDTO();
		try {
			PotentialGroup potentialCustomerGroup = potentialCustomerGroupRequestDTO
					.toModel(potentialCustomerGroupRequestDTO);
			PotentialGroup potentialCustomerGroups = potentialCustomerGroupRepository
					.save(potentialCustomerGroup);
			if (potentialCustomerGroups != null) {
				logger.info("potentialCustomerGroup details is saved");

				BeanUtils.copyProperties(potentialCustomerGroups, potentialCustomerGroupResponseDTO);
				potentialCustomerGroupResponseDTO.setResponseMessage("passed");

			} else {
				logger.info("potentialCustomerGroup is not saved in DB");
			}

		} catch (Exception e) {
			logger.error(" potentialCustomerGroup saves ls failed" + e);
			potentialCustomerGroupResponseDTO.setResponseMessage("failed");

			throw e;
		}
		return potentialCustomerGroupResponseDTO;

	}

	/**
	 * @author naveen This is the main method which is used to update
	 *         PotentialCustomer data
	 * 
	 */
	public PotentialCustomerGroupResponseDTO updatePotentialcustomer(Long id,
			PotentialCustomerGroupRequestDTO potentialCustomerGroupRequestDTO) {
		PotentialCustomerGroupResponseDTO updatedRespDTOShippingCodes = new PotentialCustomerGroupResponseDTO();
		try {
			Optional<PotentialGroup> packingOptional = potentialCustomerGroupRepository.findById(id);
			if (packingOptional.isPresent()) {
				PotentialGroup newShipCodes = potentialCustomerGroupRequestDTO.toModel(potentialCustomerGroupRequestDTO);
				newShipCodes.setGroupId(id);
				PotentialGroup shippingEntity = potentialCustomerGroupRepository.save(newShipCodes);
				if (shippingEntity != null) {
					BeanUtils.copyProperties(shippingEntity, updatedRespDTOShippingCodes);
					updatedRespDTOShippingCodes.setResponseMessage("Updated  potential group ");
					logger.info("Updated  potential groups");
				} else {
					logger.error("potential group updation failed");
					updatedRespDTOShippingCodes.setResponseMessage("potential groups updation failed");
				}
			} else {
				logger.error(" potential groups doesn't exist");
				updatedRespDTOShippingCodes.setResponseMessage(" potential group doesn't exist");
			}
		} catch (Exception e) {
			logger.error("updatePotentialcustomerfailed " + e);
			throw e;
		}

		return updatedRespDTOShippingCodes;
	}

	/**
	 * This method findBypotentialcustomerid
	 * 
	 * @param id
	 * @return PotentialCustomerGroupResponseDTO
	 * @throws Exception
	 */
	public PotentialCustomerGroupResponseDTO findBypotentialcustomerid(Long id) {

		logger.info("Entering id  {}", id);


		PotentialCustomerGroupResponseDTO potentialCustomerGroupResponseDTO = new PotentialCustomerGroupResponseDTO();
		try {
			logger.info("Potential group entering");
			Optional<PotentialGroup> optionalShipping = potentialCustomerGroupRepository.findById(id);
			if (optionalShipping.isPresent()) {
				PotentialGroup shippping = optionalShipping.get();
				BeanUtils.copyProperties(shippping, potentialCustomerGroupResponseDTO);
			} else {
				logger.error("Potential group doesn't exist");
				potentialCustomerGroupResponseDTO.setResponseMessage("Potential group  doesn't exist");
			}
		} catch (Exception e) {
			logger.error("findBypotentialcustomerid " + e);
			throw e;
		}
		return potentialCustomerGroupResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to get all
	 *         PotentialCustomer
	 * 
	 */
	public List<PotentialGroup> findAllPotentialCustomer() {
		logger.info("Fetching all BankAccounts  ...");

		return potentialCustomerGroupRepository.findAll();
	}

	@Override
	public List<PotentialGroup> fetchBypotentialCustomer(PotentialCustomerGroupRequestDTO brandReq) {
		GenericSpesification<PotentialGroup> genericSpesification = new GenericSpesification<PotentialGroup>();

		if (brandReq.getDescription() != null) {
			genericSpesification.add(new SearchCriteria("description", brandReq.getDescription(), SearchOperation.MATCH));
		}
		if (brandReq.getGroupName() != null) {
			genericSpesification.add(new SearchCriteria("groupName", brandReq.getGroupName(), SearchOperation.MATCH));
		}
		if (brandReq.getGroupId() != null) {
			genericSpesification.add(new SearchCriteria("groupId", brandReq.getGroupId(), SearchOperation.EQUAL));
		}
		if (brandReq.getStatus() != null) {
			genericSpesification.add(new SearchCriteria("Status", brandReq.getStatus(), SearchOperation.EQUAL));
		}
		 
	  

		return potentialCustomerGroupRepository.findAll(genericSpesification);
	}

}
