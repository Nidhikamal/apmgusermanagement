package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.Brokers;
import com.bourntec.apmg.entity.PassAccessList;
import com.bourntec.apmg.entity.PassTable;
import com.bourntec.apmg.entity.ShippingType;
import com.bourntec.apmg.usermanagement.v1.dto.request.PassAccessListRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.PassTableRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BrokersResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PassAccessListResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PassTableResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.PassTableRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.PassTableService;
import com.bourntec.apmg.usermanagement.v1.utils.DBConstant;

/**
 * @author Srijini
 *
 */
@Service
public class PassTableServiceImpl implements PassTableService {
	private static final Logger logger = LogManager.getLogger(PassTableServiceImpl.class);
	@Autowired
	PassTableRepository passTableRepository;

	@Value("${default.password}")
	private String defaultPassword;

	/**
	 * Method for retrieving all PassTable details
	 * 
	 * @return List<PassTableResponseDTO>
	 * @throws Exception
	 */
	@Override
	
	public List<PassTableResponseDTO> getAll() throws Exception {

		List<PassTableResponseDTO> brokersResponseDTOsList = new ArrayList<PassTableResponseDTO>();
		logger.info(" Going to PassTable");
		try {
			List<PassTable> brokersList = passTableRepository.findAll();
			if (brokersList != null && brokersList.size() > 0) {
				brokersList.forEach((brokers) -> {
					PassTableResponseDTO brokersResponseDTO = new PassTableResponseDTO();
					BeanUtils.copyProperties(brokers, brokersResponseDTO);
					brokersResponseDTOsList.add(brokersResponseDTO);

				});
				logger.info("findAllPassTable");
			} else {
				logger.error(" Error findAllPassTable ");
			}
			return brokersResponseDTOsList;
		} catch (Exception e) {
			logger.error("findAllPassTable" + e);
			throw e;
		}

	}

	/**
	 * Method for retrieving PassTable with given id
	 * 
	 * @param userId
	 * @return PassTableResponseDTO
	 * @throws Exception
	 */
	@Override
	public PassTableResponseDTO getById(String userId) throws Exception {
		logger.info("Entering getById ");
		PassTableResponseDTO passTableResponseDTO = new PassTableResponseDTO();
		try {
//			Optional<PassTable> passTableOptional = passTableRepository.findByUserIdAndAccountDisabled(userId,
//					DBConstant.NO);
			Optional <PassTable> passTableOptional=passTableRepository.findById(userId);
			if (passTableOptional != null && passTableOptional.isPresent()) {
				PassTable passTable = passTableOptional.get();
				BeanUtils.copyProperties(passTable, passTableResponseDTO);
				passTableResponseDTO.setResponseMessage("PassTable with given id is found");
			} else
				passTableResponseDTO.setResponseMessage("PassTable doesn't exists for given id ");
		} catch (BeansException e) {
			logger.error("Exiting getById "+e);
		}

		logger.info("Exiting getById ");
		return passTableResponseDTO;
	}

	/**
	 * Method for saving PassTable
	 * 
	 * @param PassTableRequestDTO
	 * 
	 * @return PassTableResponseDTO
	 * @throws Exception
	 */
	@Override
	public PassTableResponseDTO savePassTable(PassTableRequestDTO passTableRequestDTO) throws Exception {
		logger.info("Entering savePassTable{}", passTableRequestDTO);
		PassTableResponseDTO passTableResponseDTO = new PassTableResponseDTO();
		try {
			passTableRequestDTO.setPassword(new BCryptPasswordEncoder().encode(passTableRequestDTO.getPassword()));
			PassTable passTable = passTableRepository.save(passTableRequestDTO.toModel(passTableRequestDTO));
			logger.info("PassTable Details  is saved");
			BeanUtils.copyProperties(passTable, passTableResponseDTO);
			passTableResponseDTO.setResponseMessage("PassTable Details   saved succesfully ");

		}

		catch (Exception e) {
			logger.error("  PassTable Details  save failed" + e);
			throw e;
		}
		logger.info("Exiting  savePassTable");
		return passTableResponseDTO;
	}

	/**
	 * AP 227 - Method for Search passTable based on passTableid
	 * 
	 * @param PassTableRequestDTO
	 * 
	 * @return ResponseEntity<List<PassTableResponseDTO>>
	 * @throws Exception
	 */
	@Override
	public List<PassTableResponseDTO> searchForPassTable(PassTableRequestDTO passTableRequestDTO, int page, int size)
			throws Exception {
		List<PassTableResponseDTO> passTableResponseDTOList = new ArrayList<PassTableResponseDTO>();
		try {
			Page<PassTable> passTablesList = findCustomersByCriteria(passTableRequestDTO, page, size);
			if (passTablesList != null && !passTablesList.isEmpty()) {
				passTablesList.stream().forEach((pass) -> {
					PassTableResponseDTO passTableResponseDTO = new PassTableResponseDTO();
					BeanUtils.copyProperties(pass, passTableResponseDTO);
					passTableResponseDTOList.add(passTableResponseDTO);
				});

			} else {
				throw new ResourceNotFoundException(ErrorCodes.USER_NOT_FOUND.getMessage());
			}
		} catch (BeansException e) {
			throw new ResourceNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}

		return passTableResponseDTOList;
	}
	
	/**
	 * This is the main method which is used to search passTable dynamically
	 * 
	 * @param passTableRequestDTO
	 * @return Page<PassTable>
	 */

	public Page<PassTable> findCustomersByCriteria(PassTableRequestDTO passTableRequestDTO, int page, int size)
			throws Exception {
		logger.info("Searching PassTable ...");
		GenericSpesification<PassTable> genericSpesification = new GenericSpesification<PassTable>();
		try {
			// criteria for searching PassTable entities which are not soft deleted.This
			// criteria is compulsory
			genericSpesification.add(new SearchCriteria("accountDisabled", DBConstant.NO, SearchOperation.EQUAL));
			if (passTableRequestDTO.getUserId() != null) {
				genericSpesification
						.add(new SearchCriteria("userId", passTableRequestDTO.getUserId(), SearchOperation.EQUAL));
			}
			if (passTableRequestDTO.getFullName() != null) {
				genericSpesification
						.add(new SearchCriteria("fullName", passTableRequestDTO.getFullName(), SearchOperation.MATCH));
			}
			if (passTableRequestDTO.getLocCode() != null) {
				genericSpesification
						.add(new SearchCriteria("locCode", passTableRequestDTO.getLocCode(), SearchOperation.EQUAL));
			}

			return passTableRepository.findAll(genericSpesification, PageRequest.of(page, size));

		} catch (Exception e) {
			throw new ResourceNotFoundException(ErrorCodes.SEARCH_FAILED.getMessage());
		}

	}

	/**
	 * Method for deleting PassTable
	 * 
	 * @param userId-
	 * @return PassTableResponseDTO
	 * @throws Exception
	 */
	@Override
	public PassTableResponseDTO deletePassTable(String userId) throws Exception {

		logger.info("Entering  deletePassTable ");
		Optional<PassTable> passTableOptional = passTableRepository.findByUserIdAndAccountDisabled(userId,
				DBConstant.NO);
//		Optional <PassTable> passTableOptional=passTableRepository.findById(userId);
		PassTableResponseDTO passTableResponseDTO = new PassTableResponseDTO();
		try {
			if (passTableOptional.isPresent()) {
				PassTable passTable = passTableOptional.get();
				passTable.setAccountDisabled(DBConstant.YES);
				passTable = passTableRepository.save(passTable);
				BeanUtils.copyProperties(passTable, passTableResponseDTO);
				logger.info("PassTable details  is deleted succesfully");
				passTableResponseDTO.setResponseMessage("PassTable details  is deleted succesfully");
			} else {
				logger.info("PassTable doesn't  exists for given id ");
				passTableResponseDTO.setResponseMessage("PassTable doesn't  exists for given id ");
			}
		}

		catch (Exception e) {
			logger.error("  PassTable Details deletion  failed" + e);
			throw e;
		}
		logger.info("Exiting  deletePassTable");
		return passTableResponseDTO;

	}

	/**
	 * Method for updating PassTable
	 * 
	 * @param userId
	 * @param PassTableRequestDTO
	 * @return PassTableResponseDTO
	 * @throws Exception
	 */
	@Override
	public PassTableResponseDTO updatePassTable(String userId, PassTableRequestDTO passTableRequestDTO)
			throws Exception {
		logger.info("Entering  updatePassTable ");
		Optional<PassTable> passTableOptional = passTableRepository.findByUserIdAndAccountDisabled(userId,
				DBConstant.NO);
		PassTableResponseDTO passTableResponseDTO = new PassTableResponseDTO();
		try {
			if (passTableOptional!=null && passTableOptional.isPresent()) {
				PassTable passTable = passTableOptional.get();
				String password = passTableRequestDTO.getPassword();
				
				if (password != null && !password.isEmpty() && !(new BCryptPasswordEncoder().matches(password, passTable.getPassword())))
					passTableRequestDTO.setPassword(new BCryptPasswordEncoder().encode(password));
				else
					passTableRequestDTO.setPassword(passTable.getPassword());
				PassTable passTblObj = passTableRequestDTO.toModel(passTableRequestDTO);
				passTable = passTableRepository.save(passTblObj);
				BeanUtils.copyProperties(passTable, passTableResponseDTO);
				logger.info("PassTable details  is updated succesfully");
				passTableResponseDTO.setResponseMessage("PassTable details  is updated succesfully");
				
			} else {
				logger.info("PassTable doesn't exists  exists for given id");
				passTableResponseDTO.setResponseMessage("PassTable doesn't exists for given id ");
			}
		}

		catch (Exception e) {
			logger.error("  PassTable Details Update  failed" + e);
			throw e;
		}
		logger.info("Exiting  updatePassTable ");
		return passTableResponseDTO;

	}

}
