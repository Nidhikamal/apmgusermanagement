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

import com.bourntec.apmg.entity.CustDataNotes;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataNotesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustDataNotesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.CustaDataNotesRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.CustDataNotesService;

/**
 * implementation for CustDataNotesService
 * @author Tinu
 *
 */
@Service
public class CustDataNotesServiceImpl implements CustDataNotesService {
	private static final Logger logger = LogManager.getLogger(CustDataNotesServiceImpl.class);
	@Autowired
	CustaDataNotesRepository custDataNotesRepository;

	/**
	 *    Method for retrieving  all CustDataNotes details
	 * 
	 * @return List<CustDataNotesResponseDTO>
	 * @throws Exception
	 */
	@Override
	public List<CustDataNotesResponseDTO>  getAll() throws Exception {
		logger.info("Entering getAll ");
		List<CustDataNotes>  custDataNotesList=custDataNotesRepository.findAll();
		List<CustDataNotesResponseDTO>  custDataNotesResponseDTOList=new ArrayList<CustDataNotesResponseDTO>();
		custDataNotesList.forEach(custDataNotes->
		{
			CustDataNotesResponseDTO custDataNotesResponseDTO=new CustDataNotesResponseDTO();
			BeanUtils.copyProperties(custDataNotes, custDataNotesResponseDTO);
			custDataNotesResponseDTOList.add(custDataNotesResponseDTO);
		});
		logger.info("Exiting getAll ");
		return custDataNotesResponseDTOList;
	}

	/**
	 *    Method for retrieving  CustDataNotes with given id
	 * 
	 * @param custNo
	 * @return CustDataNotesResponseDTO
	 * @throws Exception
	 */
	@Override
	public CustDataNotesResponseDTO getById(String custNo) throws Exception {
		logger.info("Entering getById ");
		Optional <CustDataNotes> custDataNotesOptional=custDataNotesRepository.findById(custNo);
		CustDataNotesResponseDTO custDataNotesResponseDTO=new CustDataNotesResponseDTO();
		
		if (custDataNotesOptional.isPresent()) {
			CustDataNotes custDataNotes=custDataNotesOptional.get();
			if(custDataNotes.getCustNotes()!=null) {
				byte[] custNotesbytes = custDataNotes.getCustNotes();
				String custNotes = new String(custNotesbytes);    
				custDataNotesResponseDTO.setCustNotes(custNotes);
			}
			BeanUtils.copyProperties(custDataNotes, custDataNotesResponseDTO);
			custDataNotesResponseDTO.setResponseMessage("CustDataNotes with given id is found");
		}
		else
			custDataNotesResponseDTO.setResponseMessage("CustDataNotes doesn't exists for given id ");
		
		logger.info("Exiting getById ");
		return custDataNotesResponseDTO;
		}

	/**
	 * Method for saving CustDataNotes
	 * 
	 * @param CustDataNotesRequestDTO
	 * @return CustDataNotesResponseDTO
	 * @throws Exception
	 */
	@Override
	public CustDataNotesResponseDTO saveCustDataNotes(CustDataNotesRequestDTO custDataNotesRequestDTO) throws Exception {
		logger.info("Entering saveCustDataNotes");
		CustDataNotesResponseDTO custDataNotesResponseDTO=new CustDataNotesResponseDTO();
		try {

			CustDataNotes custDataNotes = custDataNotesRepository
					.save(custDataNotesRequestDTO.toModel(custDataNotesRequestDTO));

			logger.info("CustDataNotes Details  is saved");
			if(custDataNotes.getCustNotes()!=null) {
				byte[] custNotesbytes = custDataNotes.getCustNotes();
				String custNotes = new String(custNotesbytes);    
				custDataNotesResponseDTO.setCustNotes(custNotes);
			}
			BeanUtils.copyProperties(custDataNotes, custDataNotesResponseDTO);
			custDataNotesResponseDTO.setResponseMessage("CustDataNotes Details  is saved ");

		}

		catch (Exception e) {
			logger.error("  CustDataNotes Details  save failed" + e);
			throw e;
		}
		
		logger.info("Exiting saveCustDataNotes");
		return custDataNotesResponseDTO;
	
	}

	/**
	 * Method for Search CustDataNotes based on id
	 * 
	 * @param  custDataNotesRequestDTO
	 * @return List<custDataNotesResponseDTO>
	 * @throws Exception
	 */
	@Override
	public List<CustDataNotesResponseDTO> searchForCustDataNotes(CustDataNotesRequestDTO custDataNotesRequestDTO) throws Exception {
		logger.info("Entering searchForCustDataNotes");
		List<CustDataNotesResponseDTO> custDataNotesResponseDTOList = new ArrayList<CustDataNotesResponseDTO>();
		try {
			List<CustDataNotes> custDataNotessList = findByCriteria(custDataNotesRequestDTO);
			if (custDataNotessList != null && !custDataNotessList.isEmpty()) {
				custDataNotessList.stream().forEach((custDataNotes) -> {
					CustDataNotesResponseDTO custDataNotesResponseDTO = new CustDataNotesResponseDTO();
					if(custDataNotes.getCustNotes()!=null) {
						byte[] custNotesbytes = custDataNotes.getCustNotes();
						String custNotes = new String(custNotesbytes);    
						custDataNotesResponseDTO.setCustNotes(custNotes);
					}
					BeanUtils.copyProperties(custDataNotes, custDataNotesResponseDTO);
					custDataNotesResponseDTOList.add(custDataNotesResponseDTO);
				});

			} else {
				throw new ResourceNotFoundException(" CustDataNotes not found ");
			}
		} catch (BeansException e) {
			throw new ResourceNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
		logger.info("Exiting searchForCustDataNotes");
		return custDataNotesResponseDTOList;
	}

	/**
	 * This is the main method which is used to search CustDataNotes dynamically
	 * 
	 * @param CustDataNotesRequestDTO
	 * @return List<CustDataNotes>
	 */

	public List<CustDataNotes> findByCriteria(CustDataNotesRequestDTO custDataNotesRequestDTO) throws Exception {
		logger.info("Searching findByCriteria ");
		GenericSpesification<CustDataNotes> genericSpesification = new GenericSpesification<CustDataNotes>();
		try {
			if (custDataNotesRequestDTO.getCustNo() != null) {
				genericSpesification
						.add(new SearchCriteria("custNo", custDataNotesRequestDTO.getCustNo(), SearchOperation.EQUAL));
			}
			if (custDataNotesRequestDTO.getLocationCode() != null) {
				genericSpesification
						.add(new SearchCriteria("locationCode", custDataNotesRequestDTO.getLocationCode(), SearchOperation.EQUAL));
			}
			if (custDataNotesRequestDTO.getCustNotes() != null) {
				genericSpesification
						.add(new SearchCriteria("custNotes", custDataNotesRequestDTO.getCustNotes(), SearchOperation.EQUAL));
			}
			
			return custDataNotesRepository.findAll(genericSpesification);

		} catch (Exception e) {
			throw new ResourceNotFoundException(ErrorCodes.SEARCH_FAILED.getMessage());
		}

	}
	
	/**
	 *    Method for deleting  CustDataNotes
	 * 
	 * @param id
	 * @return CustDataNotesResponseDTO
	 * @throws Exception
	 */
	@Override
	public CustDataNotesResponseDTO deleteCustDataNotes(String id) throws Exception {
		
		logger.info("Entering  deleteCustDataNotes ");
		Optional <CustDataNotes> custDataNotesOptional=custDataNotesRepository.findById(id);
		CustDataNotesResponseDTO custDataNotesResponseDTO=new CustDataNotesResponseDTO();
		
		try {
			
			if (custDataNotesOptional.isPresent()) {
				custDataNotesRepository.deleteById(id);
				CustDataNotes custDataNotes=custDataNotesOptional.get();
				BeanUtils.copyProperties(custDataNotes, custDataNotesResponseDTO);
				logger.info("CustDataNotes details  is deleted succesfully");
				custDataNotesResponseDTO.setResponseMessage("CustDataNotes details  is deleted succesfully");
			} else {
				logger.info("CustDataNotes with the given id  doesn't exists ");
				custDataNotesResponseDTO.setResponseMessage("CustDataNotes with the given id  doesn't exists ");
			}
		}

		catch (Exception e) {
			logger.error("  CustDataNotes Details deletion  failed" + e);
			throw e;
		}
		logger.info("Exiting  deleteCustDataNotes  ");
		return custDataNotesResponseDTO;
		
	}
	
	/**
	 *    Method for updating  CustDataNotes
	 * 
	 * @param id
	 * @param CustDataNotesRequestDTO
	 * @return CustDataNotesResponseDTO
	 * @throws Exception
	 */
	@Override
	public CustDataNotesResponseDTO updateCustDataNotes(String id,CustDataNotesRequestDTO custDataNotesRequestDTO) throws Exception {
		logger.info("Entering updateCustDataNotes ");
		
		Optional <CustDataNotes> custDataNotesOptional=custDataNotesRepository.findById(id);
		CustDataNotesResponseDTO custDataNotesResponseDTO=new CustDataNotesResponseDTO();
		
		try {
			
			if (custDataNotesOptional.isPresent()) {
				custDataNotesRequestDTO.setCustNo(id);
				CustDataNotes custDataNotes=custDataNotesRepository.save(custDataNotesRequestDTO.toModel(custDataNotesRequestDTO));
				if(custDataNotes.getCustNotes()!=null) {
					byte[] custNotesbytes = custDataNotes.getCustNotes();
					String custNotes = new String(custNotesbytes);    
					custDataNotesResponseDTO.setCustNotes(custNotes);
				}
				BeanUtils.copyProperties(custDataNotes, custDataNotesResponseDTO);
				logger.info("CustDataNotes details  is updated succesfully");
				custDataNotesResponseDTO.setResponseMessage("CustDataNotes details  is updated succesfully");
			} else {
				custDataNotesResponseDTO =  saveCustDataNotes(custDataNotesRequestDTO);
				logger.info("CustDataNotes with the given id  doesn't exists ");
				custDataNotesResponseDTO.setResponseMessage("CustDataNotes with the given id  doesn't exists ");
			}
		}

		catch (Exception e) {
			logger.error("  CustDataNotes Details Update  failed" + e);
			throw e;
		}
		logger.info("Exiting  updateCustDataNotes  ");
		return custDataNotesResponseDTO;
		
	}

}