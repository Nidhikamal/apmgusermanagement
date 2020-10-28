package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.RmaData;
import com.bourntec.apmg.usermanagement.v1.dto.request.RmaDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.RmaDataResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.RmaDataRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.RmaDataService;

/**
 * implementation of RmaDataService
 * @author Tinu
 *
 */
@Service
public class RmaDataServiceImpl implements RmaDataService{
	
	private static final Logger logger = LogManager.getLogger(RmaDataServiceImpl.class);
	@Autowired
	RmaDataRepository rmaDataRepository;
	
	/**
	 *    Method for retrieving  all RmaData details
	 * 
	 * @return List<RmaDataResponseDTO>
	 * @throws Exception
	 */
	@Override
	public List<RmaDataResponseDTO>  getAll() throws Exception {
		logger.info("Entering getAll ");
		List<RmaData>  rmaDataList=rmaDataRepository.findAll();
		
		List<RmaDataResponseDTO>  rmaDataResponseDTOList=new ArrayList<RmaDataResponseDTO>();
		rmaDataList.forEach(rmaData->
		{
			RmaDataResponseDTO rmaDataResponseDTO=new RmaDataResponseDTO();
			BeanUtils.copyProperties(rmaData, rmaDataResponseDTO);
			rmaDataResponseDTOList.add(rmaDataResponseDTO);
		});
		logger.info("Exiting getAll ");
		return rmaDataResponseDTOList;
	}
	
	/**
	 *    Method for retrieving  RmaData with given id
	 * 
	 * @param rmaNo
	 * @return RmaDataResponseDTO
	 * @throws Exception
	 */
	@Override
	public RmaDataResponseDTO getById(String rmaNo) throws Exception {
		logger.info("Entering getById ");
		Optional <RmaData> rmaDataOptional=rmaDataRepository.findById(rmaNo);
		RmaDataResponseDTO rmaDataResponseDTO=new RmaDataResponseDTO();
		
		if (rmaDataOptional.isPresent()) {
			RmaData rmaData=rmaDataOptional.get();
			BeanUtils.copyProperties(rmaData, rmaDataResponseDTO);
			rmaDataResponseDTO.setResponseMessage("RmaData with given id is found");
		}
		else
			rmaDataResponseDTO.setResponseMessage("RmaData doesn't exists for given id ");
		
		logger.info("Exiting getById ");
		return rmaDataResponseDTO;
		}
	

	/**
	 *    Method for Search 
	 * 
	 * @param RmaDataRequestDTO
	 * @return List<RmaDataResponseDTO>
	 * @throws Exception
	 */

	@Override
	public List<RmaDataResponseDTO> searchForRmaData(RmaDataRequestDTO rmaDataRequestDTO) throws Exception {
		logger.info("Entering searchForRmaData ");
		List<RmaDataResponseDTO> userResponseDTOList = new ArrayList<RmaDataResponseDTO>();
		try {
			List<RmaData> rmaDataList = findByCriteria(rmaDataRequestDTO);
			if (rmaDataList != null && !rmaDataList.isEmpty()) {
				rmaDataList.stream().forEach((rmaData) -> {
					RmaDataResponseDTO rmaDataResponseDTO = new RmaDataResponseDTO();
					BeanUtils.copyProperties(rmaData, rmaDataResponseDTO);
					userResponseDTOList.add(rmaDataResponseDTO);
				});

			} else {
				throw new ResourceNotFoundException("RmaData details not found");
			}
		} catch (BeansException e) {
			throw new ResourceNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
		logger.info("Exiting searchForRmaData ");
		return userResponseDTOList;
	}
	
	

	/**
	 * This is the main method which is used to search RmaData dynamically
	 * 
	 * @param RmaDataRequestDTO
	 * @return List<RmaData>
	 */

	public List<RmaData> findByCriteria(RmaDataRequestDTO rmaDataRequestDTO) throws Exception {
		logger.info("Searching RmaData ...");
		GenericSpesification<RmaData> genericSpesification = new GenericSpesification<RmaData>();
		try {
			if (rmaDataRequestDTO.getRmaNo() != null) {
				genericSpesification
						.add(new SearchCriteria("rmaNo", rmaDataRequestDTO.getRmaNo(), SearchOperation.EQUAL));
			}
			
			if (rmaDataRequestDTO.getEmpNo() != null) {
				genericSpesification
						.add(new SearchCriteria("empNo", rmaDataRequestDTO.getEmpNo(), SearchOperation.EQUAL));
			}
			if (rmaDataRequestDTO.getCustNo() != null) {
				genericSpesification.add(new SearchCriteria("custNo", rmaDataRequestDTO.getCustNo(),
						SearchOperation.EQUAL));
			}
			return rmaDataRepository.findAll(genericSpesification);

		} catch (Exception e) {
			throw new ResourceNotFoundException(ErrorCodes.SEARCH_FAILED.getMessage());
		}

	}

	
	/**
	 *    Method for deleting  RmaData
	 * 
	 * @param rmaNo-
	 * @return RmaDataResponseDTO
	 * @throws Exception
	 */
	@Override
	public RmaDataResponseDTO deleteRmaData(String rmaNo) throws Exception {
		logger.info("Entering deleteRmaData ");
		Optional <RmaData> rmaDataOptional=rmaDataRepository.findById(rmaNo);
		RmaDataResponseDTO rmaDataResponseDTO=new RmaDataResponseDTO();
		
		try {
			
			if (rmaDataOptional.isPresent()) {
				rmaDataRepository.deleteById(rmaNo);
				logger.info("RmaData details  is deleted succesfully");
				RmaData rmaData=rmaDataOptional.get();
				BeanUtils.copyProperties(rmaData, rmaDataResponseDTO);
				rmaDataResponseDTO.setResponseMessage("RmaData details deleted succesfully");
			} else {
				logger.info("RmaData doesn't exists for given id ");
				rmaDataResponseDTO.setResponseMessage("RmaData doesn't exists for given id");
			}
		}

		catch (Exception e) {
			logger.error("  RmaData Details deletion  failed" + e);
			throw e;
		}
		logger.info("Exiting deleteRmaData ");
		return rmaDataResponseDTO;
	}

	
	/**
	 *    Method for updating  RmaData
	 * 
	 * @param rmaNo
	 * @param RmaDataRequestDTO
	 * @return RmaDataResponseDTO
	 * @throws Exception
	 */
	@Override
	public RmaDataResponseDTO updateRmaData(String rmaNo, RmaDataRequestDTO rmaDataRequestDTO) throws Exception {
		logger.info("Entering updateRmaData");
		Optional <RmaData> rmaDataOptional=rmaDataRepository.findById(rmaNo);
		RmaDataResponseDTO rmaDataResponseDTO=new RmaDataResponseDTO();
		
		try {
			
			if (rmaDataOptional.isPresent()) {
				rmaDataRequestDTO.setRmaNo(rmaNo);
				RmaData rmaData=rmaDataRepository.save(rmaDataRequestDTO.toModel(rmaDataRequestDTO));
				BeanUtils.copyProperties(rmaData, rmaDataResponseDTO);
				logger.info("RmaData details  is updated succesfully");
				rmaDataResponseDTO.setResponseMessage("RmaData details updated succesfully");
			} else {
				logger.info("RmaData doesn't exists for the given id");
				rmaDataResponseDTO.setResponseMessage("RmaData doesn't exists for the given id");
			}
		}

		catch (Exception e) {
			logger.error("  RmaData Details updation  failed" + e);
			throw e;
		}
		logger.info("Exiting updateRmaData ");
		return rmaDataResponseDTO;
	}
	
	
	/**
	 *    Method for saving  RmaData
	 * 
	 * @param RmaDataRequestDTO
	 * @return RmaDataResponseDTO
	 * @throws Exception
	 */

	@Override
	public RmaDataResponseDTO saveRmaData(RmaDataRequestDTO rmaDataRequestDTO) throws Exception {
		logger.info("Entering saveRmaData ");
		RmaDataResponseDTO rmaDataResponseDTO=new RmaDataResponseDTO();
		try {
			RmaData rmaData=rmaDataRepository.save(rmaDataRequestDTO.toModel(rmaDataRequestDTO));
			logger.info("RmaData Details  is saved");
			BeanUtils.copyProperties(rmaData, rmaDataResponseDTO);
			rmaDataResponseDTO.setResponseMessage("RmaData Details  is saved successfully ");
		}

		catch (Exception e) {
			logger.error("  RmaData Details  save failed" + e);
			throw e;
		}
		logger.info("Exiting saveRmaData ");
		return rmaDataResponseDTO;
	}

}
