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

import com.bourntec.apmg.entity.ReturnItems;
import com.bourntec.apmg.usermanagement.v1.dto.request.ReturnItemsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ReturnItemsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.ReturnItemsRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.ReturnItemsService;

/**
 * implementation of ReturnItemsService
 * @author Tinu
 *
 */
@Service
public class ReturnItemsServiceImpl implements ReturnItemsService{
	
	private static final Logger logger = LogManager.getLogger(ReturnItemsServiceImpl.class);
	@Autowired
	ReturnItemsRepository returnItemsRepository;
	
	/**
	 *    Method for retrieving  all ReturnItems details
	 * 
	 * @return List<ReturnItemsResponseDTO>
	 * @throws Exception
	 */
	@Override
	public List<ReturnItemsResponseDTO>  getAll() throws Exception {
		logger.info("Entering getAll ");
		List<ReturnItems>  returnItemsList=returnItemsRepository.findAll();
		List<ReturnItemsResponseDTO>  returnItemsResponseDTOList=new ArrayList<ReturnItemsResponseDTO>();
		returnItemsList.forEach(returnItems->
		{
			ReturnItemsResponseDTO returnItemsResponseDTO=new ReturnItemsResponseDTO();
			BeanUtils.copyProperties(returnItems, returnItemsResponseDTO);
			returnItemsResponseDTOList.add(returnItemsResponseDTO);
		});
		logger.info("Exiting getAll ");
		return returnItemsResponseDTOList;
	}

	/**
	 *    Method for retrieving  ReturnItems with given id
	 * 
	 * @param id
	 * @return ReturnItemsResponseDTO
	 * @throws Exception
	 */
	@Override
	public ReturnItemsResponseDTO getById(long id) throws Exception {
		logger.info("Entering getById ");
		Optional <ReturnItems> returnItemsOptional=returnItemsRepository.findById(id);
		ReturnItemsResponseDTO returnItemsResponseDTO=new ReturnItemsResponseDTO();
		
		if (returnItemsOptional.isPresent()) {
			ReturnItems returnItems=returnItemsOptional.get();
			BeanUtils.copyProperties(returnItems, returnItemsResponseDTO);
			returnItemsResponseDTO.setResponseMessage("ReturnItems with given id is found");
		}
		else
			returnItemsResponseDTO.setResponseMessage("ReturnItems doesn't exists for given id ");
		
		logger.info("Exiting getById ");
		return returnItemsResponseDTO;
		}

	/**
	 *    Method for Search 
	 * 
	 * @param ReturnItemsRequestDTO
	 * @return List<ReturnItemsResponseDTO>
	 * @throws Exception
	 */

	@Override
	public List<ReturnItemsResponseDTO> searchForReturnItems(ReturnItemsRequestDTO returnItemsRequestDTO) throws Exception {
		List<ReturnItemsResponseDTO> returnItemsResponseDTOList = new ArrayList<ReturnItemsResponseDTO>();
		try {
			List<ReturnItems> returnItemsList = findByCriteria(returnItemsRequestDTO);
			if (returnItemsList != null && !returnItemsList.isEmpty()) {
				returnItemsList.stream().forEach((returnItems) -> {
					ReturnItemsResponseDTO returnItemsResponseDTO = new ReturnItemsResponseDTO();
					BeanUtils.copyProperties(returnItems, returnItemsResponseDTO);
					returnItemsResponseDTOList.add(returnItemsResponseDTO);
				});

			} else {
				throw new ResourceNotFoundException("ReturnItems details not found");
			}
		} catch (BeansException e) {
			throw new ResourceNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}

		return returnItemsResponseDTOList;
	}
	
	

	/**
	 * This is the main method which is used to search ReturnItems dynamically
	 * 
	 * @param ReturnItemsRequestDTO
	 * @return List<ReturnItems>
	 */

	public List<ReturnItems> findByCriteria(ReturnItemsRequestDTO ReturnItemsRequestDTO) throws Exception {
		logger.info("Searching ReturnItems ...");
		GenericSpesification<ReturnItems> genericSpesification = new GenericSpesification<ReturnItems>();
		try {
			if (ReturnItemsRequestDTO.getReturnNo() != null) {
				genericSpesification
						.add(new SearchCriteria("returnNo", ReturnItemsRequestDTO.getReturnNo(), SearchOperation.EQUAL));
			}
			
			if (ReturnItemsRequestDTO.getJobNo() != null) {
				genericSpesification
						.add(new SearchCriteria("jobNo", ReturnItemsRequestDTO.getJobNo(), SearchOperation.EQUAL));
			}
			if (ReturnItemsRequestDTO.getInvNo() != null) {
				genericSpesification.add(new SearchCriteria("invNo", ReturnItemsRequestDTO.getInvNo(),
						SearchOperation.EQUAL));
			}
			return returnItemsRepository.findAll(genericSpesification);

		} catch (Exception e) {
			throw new ResourceNotFoundException(ErrorCodes.SEARCH_FAILED.getMessage());
		}

	}

	
	/**
	 *    Method for deleting  ReturnItems
	 * 
	 * @param id-
	 * @return ReturnItemsResponseDTO
	 * @throws Exception
	 */
	@Override
	public ReturnItemsResponseDTO deleteReturnItems(long id) throws Exception {
		logger.info("Entering deleteReturnItems ");
		Optional<ReturnItems> returnItemsOptional = returnItemsRepository.findById(id);
		ReturnItemsResponseDTO returnItemsResponseDTO = new ReturnItemsResponseDTO();

		try {
			if (returnItemsOptional.isPresent()) {
				returnItemsRepository.deleteById(id);
				logger.info("ReturnItems details  is deleted succesfully");
				ReturnItems returnItems =returnItemsOptional.get();
				BeanUtils.copyProperties(returnItems, returnItemsResponseDTO);
				returnItemsResponseDTO.setResponseMessage("ReturnItems details deleted succesfully");
			} else {
				logger.info("ReturnItems doesn't exists for given id ");
				returnItemsResponseDTO.setResponseMessage("ReturnItems doesn't exists for given id ");
			}
		}

		catch (Exception e) {
			logger.error("  ReturnItems Details deletion  failed" + e);
			throw e;
		}
		logger.info("Exiting deleteReturnItems ");
		return returnItemsResponseDTO;
	}

	
	/**
	 *    Method for updating  ReturnItems
	 * 
	 * @param rmaNo
	 * @param ReturnItemsRequestDTO
	 * @return ReturnItemsResponseDTO
	 * @throws Exception
	 */
	@Override
	public ReturnItemsResponseDTO updateReturnItems(long id, ReturnItemsRequestDTO returnItemsRequestDTO)
			throws Exception {
		logger.info("Entering updateReturnItems ");
		Optional<ReturnItems> returnItemsOptional = returnItemsRepository.findById(id);
		ReturnItemsResponseDTO returnItemsResponseDTO = new ReturnItemsResponseDTO();

		try {
			if (returnItemsOptional.isPresent()) {
				returnItemsRequestDTO.setId(id);
				 ReturnItems returnItems = returnItemsRepository.save(returnItemsRequestDTO.toModel(returnItemsRequestDTO));
				logger.info("ReturnItems details  is updated succesfully");
				BeanUtils.copyProperties(returnItems, returnItemsResponseDTO);
				returnItemsResponseDTO.setResponseMessage("ReturnItems details updated succesfully");
			} else {
				logger.info("ReturnItems doesn't exists for the given id");
				returnItemsResponseDTO.setResponseMessage("ReturnItems doesn't exists for the given id");
			}
		}

		catch (Exception e) {
			logger.error("  ReturnItems Details updation  failed" + e);
			throw e;
		}
		logger.info("Exiting updateReturnItems ");
		return returnItemsResponseDTO;
	}

	/**
	 * Method for saving ReturnItems
	 * 
	 * @param ReturnItemsRequestDTO
	 * @return ReturnItemsResponseDTO
	 * @throws Exception
	 */

	@Override
	public ReturnItemsResponseDTO saveReturnItems(ReturnItemsRequestDTO returnItemsRequestDTO) throws Exception {
		logger.info("Entering saveReturnItems ");
		ReturnItemsResponseDTO returnItemsResponseDTO = new ReturnItemsResponseDTO();
		try {
			//returnItemsRequestDTO.setId(UUID.randomUUID().toString());
			logger.info(returnItemsRequestDTO.getNoPcP()+" -"+returnItemsRequestDTO.getNoPcW());
			ReturnItems returnItems = returnItemsRepository.save(returnItemsRequestDTO.toModel(returnItemsRequestDTO));
			returnItems = returnItemsRepository.save(returnItems);
			logger.info("ReturnItems Details  is saved");
			BeanUtils.copyProperties(returnItems, returnItemsResponseDTO);
			returnItemsResponseDTO.setResponseMessage("ReturnItems Details  is saved successfully ");
		}

		catch (Exception e) {
			logger.error("  ReturnItems Details  save failed" + e);
			throw e;
		}
		logger.info("Exiting saveReturnItems ");
		return returnItemsResponseDTO;
	}



}