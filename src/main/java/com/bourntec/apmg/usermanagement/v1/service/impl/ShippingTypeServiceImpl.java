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

import com.bourntec.apmg.entity.ShippingType;
import com.bourntec.apmg.entity.StateCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.ShippingTypeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ShippingTypeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.ShippingTypeRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.ShippingTypeService;

/**
 * implementation for ShippingTypeService
 * @author Tinu
 *
 */
@Service
public class ShippingTypeServiceImpl implements ShippingTypeService {
	private static final Logger logger = LogManager.getLogger(ShippingTypeServiceImpl.class);
	@Autowired
	ShippingTypeRepository shippingTypeRepository;

	/**
	 *    Method for retrieving  all ShippingType details
	 * 
	 * @return List<ShippingTypeResponseDTO>
	 * @throws Exception
	 */
	@Override
	public List<ShippingTypeResponseDTO>  getAll() throws Exception {
		logger.info("Entering getAll ");
		List<ShippingType>  shippingTypeList=shippingTypeRepository.findAll();
		List<ShippingTypeResponseDTO>  shippingTypeResponseDTOList=new ArrayList<ShippingTypeResponseDTO>();
		shippingTypeList.forEach(shippingType->
		{
			ShippingTypeResponseDTO shippingTypeResponseDTO=new ShippingTypeResponseDTO();
			BeanUtils.copyProperties(shippingType, shippingTypeResponseDTO);
			shippingTypeResponseDTOList.add(shippingTypeResponseDTO);
		});
		logger.info("Exiting getAll ");
		return shippingTypeResponseDTOList;
	}

	/**
	 *    Method for retrieving  ShippingType with given id
	 * 
	 * @param id
	 * @return ShippingTypeResponseDTO
	 * @throws Exception
	 */
	@Override
	public ShippingTypeResponseDTO getById(Long id) throws Exception {
		logger.info("Entering getById ");
		Optional <ShippingType> shippingTypeOptional=shippingTypeRepository.findById(id);
		ShippingTypeResponseDTO shippingTypeResponseDTO=new ShippingTypeResponseDTO();
		
		if (shippingTypeOptional.isPresent()) {
			ShippingType shippingType=shippingTypeOptional.get();
			BeanUtils.copyProperties(shippingType, shippingTypeResponseDTO);
			shippingTypeResponseDTO.setResponseMessage("ShippingType with given id is found");
		}
		else
			shippingTypeResponseDTO.setResponseMessage("ShippingType doesn't exists for given id ");
		
		logger.info("Exiting getById ");
		return shippingTypeResponseDTO;
		}
		
		/**
	 * Method for saving ShippingType
	 * 
	 * @param ShippingTypeRequestDTO
	 * @return ShippingTypeResponseDTO
	 * @throws Exception
	 */

	@Override
	public ShippingTypeResponseDTO saveShippingType(ShippingTypeRequestDTO shippingTypeRequestDTO) throws Exception {
		logger.info("Entering saveShippingType");
		ShippingTypeResponseDTO shippingTypeResponseDTO=new ShippingTypeResponseDTO();
		try {

			ShippingType shippingType = shippingTypeRepository
					.save(shippingTypeRequestDTO.toModel(shippingTypeRequestDTO));

			logger.info("ShippingType Details  is saved");
			BeanUtils.copyProperties(shippingType, shippingTypeResponseDTO);
			shippingTypeResponseDTO.setResponseMessage("ShippingType Details  is saved ");

		}

		catch (Exception e) {
			logger.error("  ShippingType Details  save failed" + e);
			throw e;
		}
		
		logger.info("Exiting saveShippingType");
		return shippingTypeResponseDTO;
	
	}

	/**
	 * Method for Search ShippingType 
	 * 
	 * @param  shippingTypeRequestDTO
	 * @return List<shippingTypeResponseDTO>
	 * @throws Exception
	 */
	@Override
	public List<ShippingTypeResponseDTO> searchForShippingType(ShippingTypeRequestDTO shippingTypeRequestDTO) throws Exception {
		logger.info("Entering searchForShippingType");
		List<ShippingTypeResponseDTO> shippingTypeResponseDTOList = new ArrayList<ShippingTypeResponseDTO>();
		try {
			List<ShippingType> shippingTypesList = findByCriteria(shippingTypeRequestDTO);
			if (shippingTypesList != null && !shippingTypesList.isEmpty()) {
				shippingTypesList.stream().forEach((shippingType) -> {
					ShippingTypeResponseDTO shippingTypeResponseDTO = new ShippingTypeResponseDTO();
					BeanUtils.copyProperties(shippingType, shippingTypeResponseDTO);
					shippingTypeResponseDTOList.add(shippingTypeResponseDTO);
				});

			} else {
				ShippingTypeResponseDTO shippingTypeResponseDTO = new ShippingTypeResponseDTO();
				shippingTypeResponseDTO.setResponseMessage(" Shipping Type not found ");
				//throw new ResourceNotFoundException(" ShippingType not found ");
				
			}
		} catch (BeansException e) {
			throw new ResourceNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
		logger.info("Exiting searchForShippingType");
		return shippingTypeResponseDTOList;
	}

	/**
	 * This is the main method which is used to search ShippingType dynamically
	 * 
	 * @param ShippingTypeRequestDTO
	 * @return List<ShippingType>
	 */

	public List<ShippingType> findByCriteria(ShippingTypeRequestDTO shippingTypeRequestDTO) throws Exception {
		logger.info("Searching findByCriteria ");
		GenericSpesification<ShippingType> genericSpesification = new GenericSpesification<ShippingType>();
		try {
			if (shippingTypeRequestDTO.getId() != null) {
				genericSpesification
						.add(new SearchCriteria("id", shippingTypeRequestDTO.getId(), SearchOperation.EQUAL));
			}
			if (shippingTypeRequestDTO.getShipCode() != null) {
				genericSpesification
						.add(new SearchCriteria("shipCode", shippingTypeRequestDTO.getShipCode(), SearchOperation.MATCH));
			}
			if (shippingTypeRequestDTO.getShipType() != null) {
				genericSpesification
						.add(new SearchCriteria("shipType", shippingTypeRequestDTO.getShipType(), SearchOperation.MATCH));
			}
			if (shippingTypeRequestDTO.getShipTypeName() != null) {
				genericSpesification
						.add(new SearchCriteria("shipTypeName", shippingTypeRequestDTO.getShipTypeName(), SearchOperation.MATCH));
			}
			
			return shippingTypeRepository.findAll(genericSpesification);

		} catch (Exception e) {
			throw new ResourceNotFoundException(ErrorCodes.SEARCH_FAILED.getMessage());
		}

	}
	
	/**
	 *    Method for deleting  ShippingType
	 * 
	 * @param id
	 * @return ShippingTypeResponseDTO
	 * @throws Exception
	 */
	@Override
	public ShippingTypeResponseDTO deleteShippingType(Long id) throws Exception {
		
		logger.info("Entering  deleteShippingType ");
		Optional <ShippingType> shippingTypeOptional=shippingTypeRepository.findById(id);
		ShippingTypeResponseDTO shippingTypeResponseDTO=new ShippingTypeResponseDTO();
		
		try {
			
			if (shippingTypeOptional.isPresent()) {
				shippingTypeRepository.deleteById(id);
				ShippingType shippingType=shippingTypeOptional.get();
				BeanUtils.copyProperties(shippingType, shippingTypeResponseDTO);
				logger.info("ShippingType details  is deleted succesfully");
				shippingTypeResponseDTO.setResponseMessage("ShippingType details  is deleted succesfully");
			} else {
				logger.info("ShippingType with the given id  doesn't exists ");
				shippingTypeResponseDTO.setResponseMessage("ShippingType with the given id  doesn't exists ");
			}
		}

		catch (Exception e) {
			logger.error("  ShippingType Details deletion  failed" + e);
			throw e;
		}
		logger.info("Exiting  deleteShippingType  ");
		return shippingTypeResponseDTO;
		
	}
	
	/**
	 *    Method for updating  ShippingType
	 * 
	 * @param id
	 * @param ShippingTypeRequestDTO
	 * @return ShippingTypeResponseDTO
	 * @throws Exception
	 */
	@Override
	public ShippingTypeResponseDTO updateShippingType(Long id,ShippingTypeRequestDTO shippingTypeRequestDTO) throws Exception {
		logger.info("Entering updateShippingType ");
		
		Optional <ShippingType> shippingTypeOptional=shippingTypeRepository.findById(id);
		ShippingTypeResponseDTO shippingTypeResponseDTO=new ShippingTypeResponseDTO();
		
		try {
			if (shippingTypeOptional.isPresent()) {
				ShippingType newShiptype = shippingTypeRequestDTO.toModel(shippingTypeRequestDTO);
				shippingTypeRequestDTO.setId(id);
				ShippingType shippingEntity = shippingTypeRepository.save(newShiptype);
				if (shippingEntity != null) {
					BeanUtils.copyProperties(shippingEntity, shippingTypeResponseDTO);
					shippingTypeResponseDTO.setResponseMessage("Updated  State code");
					logger.info("Updated  State code");
				} else {
					logger.error("State code updation failed");
										
				}
			}  else {
				shippingTypeResponseDTO = saveShippingType(shippingTypeRequestDTO);
			}
			
//			if (shippingTypeOptional.isPresent()) {
//				shippingTypeRequestDTO.setId(id);
//				ShippingType shippingType=shippingTypeRepository.save(shippingTypeRequestDTO.toModel(shippingTypeRequestDTO));
//				BeanUtils.copyProperties(shippingType, shippingTypeResponseDTO);
//				logger.info("ShippingType details  is updated succesfully");
//				shippingTypeResponseDTO.setResponseMessage("ShippingType details  is updated succesfully");
//			} else {
//				logger.info("ShippingType with the given id  doesn't exists ");
//				shippingTypeResponseDTO.setResponseMessage("ShippingType with the given id  doesn't exists ");
//			}
		}

		catch (Exception e) {
			logger.error("  ShippingType Details Update  failed" + e);
			throw e;
		}
		logger.info("Exiting  updateShippingType  ");
		return shippingTypeResponseDTO;
		
	}

}
