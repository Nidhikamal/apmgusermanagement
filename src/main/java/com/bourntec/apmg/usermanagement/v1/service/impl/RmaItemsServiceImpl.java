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

import com.bourntec.apmg.entity.RmaItems;
import com.bourntec.apmg.usermanagement.v1.dto.request.RmaItemsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.RmaItemsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.RmaItemsRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.RmaItemsService;

/**
 * implementation of RmaItemsService
 * @author Tinu
 *
 */
@Service
public class RmaItemsServiceImpl implements RmaItemsService{
	
	private static final Logger logger = LogManager.getLogger(RmaItemsServiceImpl.class);
	@Autowired
	RmaItemsRepository rmaItemsRepository;
	
	/**
	 *    Method for retrieving  all RmaItems details
	 * 
	 * @return List<RmaItemsResponseDTO>
	 * @throws Exception
	 */
	@Override
	public List<RmaItemsResponseDTO>  getAll() throws Exception {
		logger.info("Entering getAll ");
		List<RmaItems>  rmaItemsList=rmaItemsRepository.findAll();
		List<RmaItemsResponseDTO>  rmaItemsResponseDTOList=new ArrayList<RmaItemsResponseDTO>();
		rmaItemsList.forEach(rmaItems->
		{
			RmaItemsResponseDTO rmaItemsResponseDTO=new RmaItemsResponseDTO();
			BeanUtils.copyProperties(rmaItems, rmaItemsResponseDTO);
			rmaItemsResponseDTOList.add(rmaItemsResponseDTO);
		});
		logger.info("Exiting getAll ");
		return rmaItemsResponseDTOList;
	}
	
	/**
	 *    Method for retrieving  RmaItems with given id
	 * 
	 * @param id
	 * @return RmaItemsResponseDTO
	 * @throws Exception
	 */
	@Override
	public RmaItemsResponseDTO getById(long id) throws Exception {
		logger.info("Entering getById ");
		Optional <RmaItems> rmaItemsOptional=rmaItemsRepository.findById(id);
		RmaItemsResponseDTO rmaItemsResponseDTO=new RmaItemsResponseDTO();
		
		if (rmaItemsOptional.isPresent()) {
			RmaItems rmaItems=rmaItemsOptional.get();
			BeanUtils.copyProperties(rmaItems, rmaItemsResponseDTO);
			rmaItemsResponseDTO.setResponseMessage("RmaItems with given id is found");
		}
		else
			rmaItemsResponseDTO.setResponseMessage("RmaItems doesn't exists for given id ");
		
		logger.info("Exiting getById ");
		return rmaItemsResponseDTO;
	}
	

	/**
	 *    Method for Search 
	 * 
	 * @param RmaItemsRequestDTO
	 * @return List<RmaItemsResponseDTO>
	 * @throws Exception
	 */

	@Override
	public List<RmaItemsResponseDTO> searchForRmaItems(RmaItemsRequestDTO rmaItemsRequestDTO) throws Exception {
		logger.info("Entering searchForRmaItems");
		List<RmaItemsResponseDTO> rmaItemsResponseDTOList = new ArrayList<RmaItemsResponseDTO>();
		try {
			List<RmaItems> rmaItemsList = findByCriteria(rmaItemsRequestDTO);
			if (rmaItemsList != null && !rmaItemsList.isEmpty()) {
				rmaItemsList.stream().forEach((rmaItems) -> {
					RmaItemsResponseDTO rmaItemsResponseDTO = new RmaItemsResponseDTO();
					BeanUtils.copyProperties(rmaItems, rmaItemsResponseDTO);
					rmaItemsResponseDTOList.add(rmaItemsResponseDTO);
				});

			} else {
				throw new ResourceNotFoundException("RmaItems details not found");
			}
		} catch (BeansException e) {
			throw new ResourceNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
		logger.info("Entering searchForRmaItems");
		return rmaItemsResponseDTOList;
	}
	
	

	/**
	 * This is the main method which is used to search RmaItems dynamically
	 * 
	 * @param RmaItemsRequestDTO
	 * @return List<RmaItems>
	 */

	public List<RmaItems> findByCriteria(RmaItemsRequestDTO RmaItemsRequestDTO) throws Exception {
		logger.info("Searching RmaItems ...");
		GenericSpesification<RmaItems> genericSpesification = new GenericSpesification<RmaItems>();
		try {
			if (RmaItemsRequestDTO.getRmaNo() != null) {
				genericSpesification
						.add(new SearchCriteria("rmaNo", RmaItemsRequestDTO.getRmaNo(), SearchOperation.EQUAL));
			}
			
			if (RmaItemsRequestDTO.getJobNo() != null) {
				genericSpesification
						.add(new SearchCriteria("jobNo", RmaItemsRequestDTO.getJobNo(), SearchOperation.EQUAL));
			}
			if (RmaItemsRequestDTO.getInvNo() != null) {
				genericSpesification.add(new SearchCriteria("invNo", RmaItemsRequestDTO.getInvNo(),
						SearchOperation.EQUAL));
			}
			return rmaItemsRepository.findAll(genericSpesification);

		} catch (Exception e) {
			throw new ResourceNotFoundException(ErrorCodes.SEARCH_FAILED.getMessage());
		}

	}

	
	/**
	 *    Method for deleting  RmaItems
	 * 
	 * @param id-
	 * @return RmaItemsResponseDTO
	 * @throws Exception
	 */
	@Override
	public RmaItemsResponseDTO deleteRmaItems(long id) throws Exception {
		logger.info("Entering deleteRmaItems ");

		Optional<RmaItems> rmaItemsOptional = rmaItemsRepository.findById(id);
		RmaItemsResponseDTO rmaItemsResponseDTO = new RmaItemsResponseDTO();
		try {

			if (rmaItemsOptional.isPresent()) {
				rmaItemsRepository.deleteById(id);
				RmaItems rmaItems = rmaItemsOptional.get();
				BeanUtils.copyProperties(rmaItems, rmaItemsResponseDTO);
				logger.info("RmaItems details  is deleted succesfully");
				rmaItemsResponseDTO.setResponseMessage("RmaItems details deleted succesfully");
			} else {
				logger.info("RmaItems doesn't exists for given id ");
				rmaItemsResponseDTO.setResponseMessage("RmaItems doesn't exists for given id");
			}
		}

		catch (Exception e) {
			logger.error("  RmaItems Details deletion  failed" + e);
			throw e;
		}
		logger.info("Exiting deleteRmaItems ");
		return rmaItemsResponseDTO;
	}

	/**
	 * Method for updating RmaItems
	 * 
	 * @param id
	 * @param RmaItemsRequestDTO
	 * @return RmaItemsResponseDTO
	 * @throws Exception
	 */
	@Override
	public RmaItemsResponseDTO updateRmaItems(long id, RmaItemsRequestDTO rmaItemsRequestDTO) throws Exception {
		logger.info("Entering updateRmaItems ");

		Optional<RmaItems> rmaItemsOptional = rmaItemsRepository.findById(id);

		RmaItemsResponseDTO rmaItemsResponseDTO = new RmaItemsResponseDTO();
		try {

			if (rmaItemsOptional.isPresent()) {
				rmaItemsRequestDTO.setId(id);
				RmaItems rmaItems = rmaItemsRepository.save(rmaItemsRequestDTO.toModel(rmaItemsRequestDTO));
				BeanUtils.copyProperties(rmaItems, rmaItemsResponseDTO);
				logger.info("RmaItems details  is updated succesfully");
				rmaItemsResponseDTO.setResponseMessage("RmaItems details updated succesfully");
			} else {
				logger.info("RmaItems doesn't exists for the given id");
				rmaItemsResponseDTO.setResponseMessage("RmaItems doesn't exists for the given id");
			}
		}

		catch (Exception e) {
			logger.error("  RmaItems Details updation  failed" + e);
			throw e;
		}
		logger.info("Exiting updateRmaItems ");
		return rmaItemsResponseDTO;
	}

	/**
	 * Method for saving RmaItems
	 * 
	 * @param RmaItemsRequestDTO
	 * @return RmaItemsResponseDTO
	 * @throws Exception
	 */

	@Override
	public RmaItemsResponseDTO saveRmaItems(RmaItemsRequestDTO rmaItemsRequestDTO) throws Exception {
		logger.info("Entering saveRmaItems ");
		RmaItemsResponseDTO rmaItemsResponseDTO = new RmaItemsResponseDTO();

		try {
			//rmaItemsRequestDTO.setId(UUID.randomUUID().toString());
			RmaItems rmaItems = rmaItemsRepository.save(rmaItemsRequestDTO.toModel(rmaItemsRequestDTO));
			BeanUtils.copyProperties(rmaItems, rmaItemsResponseDTO);
			logger.info("RmaItems Details  is saved");
			rmaItemsResponseDTO.setResponseMessage("RmaItems Details  is saved successfully ");
		}

		catch (Exception e) {
			logger.error("  RmaItems Details  save failed" + e);
			throw e;
		}
		logger.info("Exiting saveRmaItems ");
		return rmaItemsResponseDTO;
	}

}