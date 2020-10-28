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

import com.bourntec.apmg.entity.ReturnData;
import com.bourntec.apmg.usermanagement.v1.dto.request.ReturnDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ReturnDataResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.ReturnDataRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.ReturnDataService;

/**
 * implementation of ReturnDataService
 * @author Tinu
 *
 */
@Service
public class ReturnDataServiceImpl implements ReturnDataService{

	private static final Logger logger = LogManager.getLogger(ReturnDataServiceImpl.class);
	@Autowired
	ReturnDataRepository returnDataRepository;
	
	/**
	 *    Method for retrieving  all ReturnData details
	 * 
	 * @return List<ReturnDataResponseDTO>
	 * @throws Exception
	 */
	public List<ReturnDataResponseDTO>  getAll() throws Exception {
		logger.info("Entering getAll ");
		List<ReturnData>  returnDataList=returnDataRepository.findAll();
		List<ReturnDataResponseDTO>  returnDataResponseDTOList=new ArrayList<ReturnDataResponseDTO>();
		returnDataList.forEach(returnData->
		{
			ReturnDataResponseDTO returnDataResponseDTO=new ReturnDataResponseDTO();
			BeanUtils.copyProperties(returnData, returnDataResponseDTO);
			returnDataResponseDTOList.add(returnDataResponseDTO);
		});
		logger.info("Exiting getAll ");
		return returnDataResponseDTOList;
	}

	/**
	 *    Method for retrieving  ReturnData with given id
	 * 
	 * @param returnNo
	 * @return ReturnDataResponseDTO
	 * @throws Exception
	 */
	@Override
	public ReturnDataResponseDTO getById(String returnNo) throws Exception {
		logger.info("Entering getById ");
		Optional <ReturnData> returnDataOptional=returnDataRepository.findById(returnNo);
		ReturnDataResponseDTO returnDataResponseDTO=new ReturnDataResponseDTO();
		
		if (returnDataOptional.isPresent()) {
			ReturnData returnData=returnDataOptional.get();
			BeanUtils.copyProperties(returnData, returnDataResponseDTO);
			returnDataResponseDTO.setResponseMessage("ReturnData with given id is found");
		}
		else
			returnDataResponseDTO.setResponseMessage("ReturnData doesn't exists for given id ");
		
		logger.info("Exiting getById ");
		return returnDataResponseDTO;
		}
	
	/**
	 *    Method for saving  ReturnData
	 * 
	 * @param ReturnDataRequestDTO
	 * @return ReturnDataResponseDTO
	 * @throws Exception
	 */
	@Override
	public ReturnDataResponseDTO saveReturnData(ReturnDataRequestDTO returnDataRequestDTO) throws Exception {
		logger.info("Entering saveReturnData ");
		ReturnDataResponseDTO returnDataResponseDTO=new ReturnDataResponseDTO();
		try {
			ReturnData returnData=returnDataRepository.save(returnDataRequestDTO.toModel(returnDataRequestDTO));
			logger.info("ReturnData Details  is saved");
			BeanUtils.copyProperties(returnData, returnDataResponseDTO);
			returnDataResponseDTO.setResponseMessage("ReturnData Details  is saved successfully ");
		}

		catch (Exception e) {
			logger.error("  ReturnData Details  save failed" + e);
			throw e;
		}
		logger.info("Exiting saveReturnData ");
		return returnDataResponseDTO;
	}

	/**
	 *    Method for Search 
	 * 
	 * @param ReturnDataRequestDTO
	 * @return List<ReturnDataResponseDTO>
	 * @throws Exception
	 */
	@Override
	public List<ReturnDataResponseDTO> searchForReturnData(ReturnDataRequestDTO returnDataRequestDTO) throws Exception {
		List<ReturnDataResponseDTO> returnDataResponseDTOList = new ArrayList<ReturnDataResponseDTO>();
		try {
			List<ReturnData> returnDataList = findByCriteria(returnDataRequestDTO);
			if (returnDataList != null && !returnDataList.isEmpty()) {
				returnDataList.stream().forEach((returnData) -> {

					ReturnDataResponseDTO returnDataResponseDTO = new ReturnDataResponseDTO();
					BeanUtils.copyProperties(returnData, returnDataResponseDTO);
					returnDataResponseDTOList.add(returnDataResponseDTO);
				});

			} else {
				throw new ResourceNotFoundException("returnData details not found");
			}
		} catch (BeansException e) {
			throw new ResourceNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}

		return returnDataResponseDTOList;
	}

	/**
	 *    Method for deleting  ReturnData
	 * 
	 * @param returnNo-
	 * @return ReturnDataResponseDTO
	 * @throws Exception
	 */
	@Override
	public ReturnDataResponseDTO deleteReturnData(String returnNo) throws Exception {
		logger.info("Entering deleteReturnData ");
		Optional<ReturnData> returnDataOptional = returnDataRepository.findById(returnNo);
		ReturnDataResponseDTO returnDataResponseDTO = new ReturnDataResponseDTO();

		try {
			if (returnDataOptional.isPresent()) {
				returnDataRepository.deleteById(returnNo);
				ReturnData returnData = returnDataOptional.get();
				BeanUtils.copyProperties(returnData, returnDataResponseDTO);
				logger.info("ReturnData details  is deleted succesfully");
				returnDataResponseDTO.setResponseMessage("ReturnData details updated succesfully");
			} else {
				logger.info("ReturnData doesn't exists for given id ");
				returnDataResponseDTO.setResponseMessage("ReturnData doesn't exists for given id ");
			}
		}

		catch (Exception e) {
			logger.error("  ReturnData Details deletion  failed" + e);
			throw e;
		}
		logger.info("Exiting deleteReturnData ");
		return returnDataResponseDTO;
	}

	/**
	 *    Method for updating  ReturnData
	 * 
	 * @param returnNo
	 * @param ReturnDataRequestDTO
	 * @return ReturnDataResponseDTO
	 * @throws Exception
	 */
	@Override
	public ReturnDataResponseDTO updateReturnData(String returnNo, ReturnDataRequestDTO returnDataRequestDTO)
			throws Exception {
		logger.info("Entering updateReturnData ");
		Optional<ReturnData> returnDataOptional = returnDataRepository.findById(returnNo);
		ReturnDataResponseDTO returnDataResponseDTO = new ReturnDataResponseDTO();
		try {
			if (returnDataOptional.isPresent()) {
				returnDataRequestDTO.setReturnNo(returnNo);
				ReturnData returnData = returnDataRepository.save(returnDataRequestDTO.toModel(returnDataRequestDTO));
				BeanUtils.copyProperties(returnData, returnDataResponseDTO);
				logger.info("ReturnData details  is updated succesfully");
				returnDataResponseDTO.setResponseMessage("ReturnData details updated succesfully");
			} else {
				logger.info("ReturnData doesn't exists for the given id");
				returnDataResponseDTO.setResponseMessage("ReturnData doesn't exists for the given id");
			}
		}

		catch (Exception e) {
			logger.error("  ReturnData Details updation  failed" + e);
			throw e;
		}
		logger.info("Exiting updateReturnData ");
		return returnDataResponseDTO;
	}

	/**
	 * This is the main method which is used to search ReturnData dynamically
	 * 
	 * @param ReturnDataRequestDTO
	 * @return List<ReturnData>
	 */

	public List<ReturnData> findByCriteria(ReturnDataRequestDTO returnDataRequestDTO) throws Exception {
		logger.info("Searching ReturnData ...");
		GenericSpesification<ReturnData> genericSpesification = new GenericSpesification<ReturnData>();
		try {
			if (returnDataRequestDTO.getReturnNo() != null) {
				genericSpesification
						.add(new SearchCriteria("returnNo", returnDataRequestDTO.getReturnNo(), SearchOperation.EQUAL));
			}
			
			if (returnDataRequestDTO.getEmpNo() != null) {
				genericSpesification
						.add(new SearchCriteria("empNo", returnDataRequestDTO.getEmpNo(), SearchOperation.EQUAL));
			}
			if (returnDataRequestDTO.getCustNo() != null) {
				genericSpesification.add(new SearchCriteria("custNo", returnDataRequestDTO.getCustNo(),
						SearchOperation.EQUAL));
			}
			return returnDataRepository.findAll(genericSpesification);

		} catch (Exception e) {
			throw new ResourceNotFoundException(ErrorCodes.SEARCH_FAILED.getMessage());
		}

	}
}
