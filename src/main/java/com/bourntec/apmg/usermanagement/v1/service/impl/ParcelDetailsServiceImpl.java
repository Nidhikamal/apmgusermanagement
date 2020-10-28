package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.BrandDetails;
import com.bourntec.apmg.entity.ParcelDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.ParcelDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ParcelDetailResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.ParcelRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.ParcelDetailsService;


@Service(value = "ParcelDetailsServiceImpl")
public class ParcelDetailsServiceImpl implements ParcelDetailsService {

	private static final Logger logger = LogManager.getLogger(ParcelDetailsServiceImpl.class);

	@Autowired
	private ParcelRepository parcelRepository;

	/**
	 * This method findParcelDetailsById
	 * 
	 * @return ParcelDetailResponseDTO
	 * @throws Exception
	 */

	public ParcelDetailResponseDTO findParcelDetailsById(String parcelNo) throws Exception {
		ParcelDetailResponseDTO parcelDetailResponseDTO = new ParcelDetailResponseDTO();
		logger.info(" Going findParcelDetails ById");
		try {
			Optional<ParcelDetails> parcel = parcelRepository.findById(parcelNo);
			if (parcel != null) {
				logger.info("Find ParcelDetails ById");
				BeanUtils.copyProperties(parcel.get(), parcelDetailResponseDTO);
				return parcelDetailResponseDTO;
			} else {
				throw new ResourceNotFoundException(ErrorCodes.PARCEL_NOT_FOUND.getMessage());
			}
		} catch (Exception e) {
			logger.error("findParcelDetailsById" + e);
			throw e;
		}

	}

	/**
	 * This method saveParcelDetails
	 * 
	 * @return ParcelDetailResponseDTO
	 * @throws Exception
	 */

	public ParcelDetailResponseDTO saveParcelDetails(ParcelDetailsRequestDTO parcelDetailsRequestDTO) throws Exception {
		ParcelDetailResponseDTO parcelDetailResponseDTO = new ParcelDetailResponseDTO();
		try {
			logger.info(" Going to saveParcelDetails");
			ParcelDetails parcelDetails = parcelDetailsRequestDTO.toModel(parcelDetailsRequestDTO);
			ParcelDetails parcelObj = parcelRepository.save(parcelDetails);
			if (parcelObj != null) {
				logger.info("saveParcelDetails");
				BeanUtils.copyProperties(parcelObj, parcelDetailResponseDTO);
			} else {
				logger.error("saveParcelDetails error");
				parcelDetailResponseDTO.setResponseMessage("saveParcelDetailserror");
			}
			return parcelDetailResponseDTO;
		} catch (Exception e) {
			logger.error("saveParcelDetails" + e);
			throw e;
		}

	}

	/**
	 * This method findAllParcelDetails
	 * 
	 * @return ParcelDetailResponseDTO list
	 * @throws Exception
	 */

	public List<ParcelDetailResponseDTO> findAllParcelDetails() throws Exception {
		List<ParcelDetailResponseDTO> parcelDetailResponseDTOs = new ArrayList<ParcelDetailResponseDTO>();
		logger.info(" Going to retrieveAll parcelDetails");
		try {
			List<ParcelDetails> parcelDetailsList = parcelRepository.findAll();
			if (parcelDetailsList != null && parcelDetailsList.size() > 0) {
				parcelDetailsList.forEach((parcelDetails) -> {
					ParcelDetailResponseDTO parcelDetailResponseDTO = new ParcelDetailResponseDTO();
					BeanUtils.copyProperties(parcelDetails, parcelDetailResponseDTO);
					parcelDetailResponseDTOs.add(parcelDetailResponseDTO);
				});
				logger.info("RetrieveAllParcelDetails");
			} else {
				throw new ResourceNotFoundException(ErrorCodes.PARCEL_NOT_FOUND.getMessage());
			}
			return parcelDetailResponseDTOs;
		} catch (Exception e) {
			logger.error(" Error in findAllParcelDetails" + e);
			throw e;
		}

	}

	/**
	 * This method updates parcel
	 * 
	 * @param parcelId ,parcelDetailsRequestDTO
	 * @return ParcelDetailResponseDTO
	 * @throws Exception
	 */

	public ParcelDetailResponseDTO updateParcelDetails(String parcelId, ParcelDetailsRequestDTO parcelDetailsRequestDTO)
			throws Exception {
		ParcelDetailResponseDTO parcelDetailResponseDTO = new ParcelDetailResponseDTO();
		logger.info("ParcelDetail is going to updated");
		try {
			ParcelDetails parcelDetails = parcelDetailsRequestDTO.toModel(parcelDetailsRequestDTO);
			parcelDetails.setParcelNo(parcelId);
			ParcelDetails parcelObjects = parcelRepository.save(parcelDetails);
			if (parcelObjects != null) {
				BeanUtils.copyProperties(parcelObjects, parcelDetailResponseDTO);
				parcelDetailResponseDTO.setResponseMessage("ParcelDetails updated successfully");
				logger.info("ParcelDetail is updated");
			} else {
				logger.error("updateParcelDetails error");
				parcelDetailResponseDTO.setResponseMessage("update ParcelDetails error");
			}
			return parcelDetailResponseDTO;
		} catch (Exception e) {
			logger.error(" Error in updateParcelDetails" + e);
			throw e;
		}

	}

	/**
	 * This method Searches ParcelDetails by criteria
	 * @author Amal
	 * @return List<ParcelDetails>
	 * @throws Exception
	 */
	
	@Override
	public List<ParcelDetails> findParcelByCriteria(ParcelDetailsRequestDTO parcelDetailsRequestDTO) {
		 GenericSpesification<ParcelDetails> genericSpesification = new GenericSpesification<ParcelDetails>();
		
		if(parcelDetailsRequestDTO.getParcelNo()!=null) {
			 genericSpesification.add(new SearchCriteria("parcelNo", parcelDetailsRequestDTO.getParcelNo(), SearchOperation.MATCH));
			}
			if(parcelDetailsRequestDTO.getParcelName()!=null) {
	        genericSpesification.add(new SearchCriteria("parcelName", parcelDetailsRequestDTO.getParcelName(), SearchOperation.MATCH));
			}
			if(parcelDetailsRequestDTO.getParcelDesc()!=null) {
	        genericSpesification.add(new SearchCriteria("parcelDesc", parcelDetailsRequestDTO.getParcelDesc(), SearchOperation.MATCH));
			}
			if(parcelDetailsRequestDTO.getCourierAgency()!=null) {
	        genericSpesification.add(new SearchCriteria("courierAgency", parcelDetailsRequestDTO.getCourierAgency(), SearchOperation.MATCH));
			}
			if(parcelDetailsRequestDTO.getCustVendType()!=null) {
		    genericSpesification.add(new SearchCriteria("custVendType", parcelDetailsRequestDTO.getCustVendType(), SearchOperation.MATCH));
			}
			if(parcelDetailsRequestDTO.getCustVendId()!=null) {
		    genericSpesification.add(new SearchCriteria("custVendId", parcelDetailsRequestDTO.getCustVendId(), SearchOperation.MATCH));
			}
		 return parcelRepository.findAll(genericSpesification);
	}


}
