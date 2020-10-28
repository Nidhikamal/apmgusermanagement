package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.FaqDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.FaqDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.FaqResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.FaqDetailsRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.FaqService;


@Service(value = "FaqServiceImpl")
public class FaqServiceImpl implements FaqService {

	private static final Logger logger = LogManager.getLogger(FaqServiceImpl.class);

	@Autowired
	private FaqDetailsRepository faqDetailsRepository;

	/**
	 * This method update faq object
	 * 
	 * @return PaymentTermsResponseDTO
	 * @throws Exception
	 */

	public FaqResponseDTO updateFaqDetails(Integer id, FaqDetailsRequestDTO faqDetailsRequestDTO) throws Exception {
		try {
			logger.info("FaqDetails is going to update");
			FaqResponseDTO faqResponseDTO = new FaqResponseDTO();
			FaqDetails faqDetails = faqDetailsRequestDTO.toModel(faqDetailsRequestDTO);
			faqDetails.setId(id);
			FaqDetails faqDetailsObject = faqDetailsRepository.save(faqDetails);
			if (faqDetailsObject != null) {
				logger.info("FaqDetails is updated");
				BeanUtils.copyProperties(faqDetailsObject, faqResponseDTO);
			} else {
				logger.error("FaqDetails updated error");
				faqResponseDTO.setResponseMessage("Update FaqDetails error");
			}
			return faqResponseDTO;
		} catch (Exception e) {
			logger.error(" Error in updateFaqDetails" + e);
			throw e;
		}
	}

	/**
	 * This method save new faq object
	 * 
	 * @return PaymentTermsResponseDTO
	 * @throws Exception
	 */

	public FaqResponseDTO saveFaqDetails(FaqDetailsRequestDTO faqDetailsRequestDTO) throws Exception {
		FaqResponseDTO faqResponseDTO = new FaqResponseDTO();
		try {
			logger.info("FaqDetails is going to save");
			FaqDetails faqDetails = faqDetailsRequestDTO.toModel(faqDetailsRequestDTO);
			FaqDetails faqDetailsObject = faqDetailsRepository.save(faqDetails);
			if (faqDetailsObject != null) {
				logger.info("FaqDetails is saved");
				BeanUtils.copyProperties(faqDetailsObject, faqResponseDTO);
			}

			else {
				logger.error("FaqDetails updated error");
				faqResponseDTO.setResponseMessage("Save FaqDetails error");
			}

			return faqResponseDTO;

		} catch (Exception e) {
			logger.error(" Error in saveFaqDetails" + e);
			throw e;
		}

	}

	/**
	 * This method find faq object.
	 * 
	 * @param id
	 * @return FaqResponseDTO
	 * @throws Exception
	 */

	public FaqResponseDTO findFaqDetailsById(Integer id) throws Exception {
		logger.info(" Going to find FaqDetails ById");
		FaqResponseDTO faqResponseDTO = new FaqResponseDTO();
		try {
			Optional<FaqDetails> faq = faqDetailsRepository.findById(id);
			if (faq != null) {
				logger.info("Retrieve FaqDetails");
				BeanUtils.copyProperties(faq.get(), faqResponseDTO);
				return faqResponseDTO;
			} else {
				throw new ResourceNotFoundException(ErrorCodes.FAQ_NOT_FOUND.getMessage());
			}
		} catch (Exception e) {
			logger.error(" Error findFaqDetailsById" + e);
			throw e;
		}

	}

	/**
	 * This method find all faqs
	 * 
	 * @return FaqResponseDTOList
	 * @throws Exception
	 */
	public List<FaqResponseDTO> findAllFaqDetails() throws Exception {
		logger.info("Going to findAllFaqDetails");
		List<FaqResponseDTO> FaqResponseDTOs = new ArrayList<FaqResponseDTO>();
		try {
			List<FaqDetails> faqList = faqDetailsRepository.findAll();
			faqList.forEach((faqDetails) -> {
				FaqResponseDTO faqResponseDTO = new FaqResponseDTO();
				BeanUtils.copyProperties(faqDetails, faqResponseDTO);
				FaqResponseDTOs.add(faqResponseDTO);
			});
			logger.info("retrieveAllFaqDetails");
			return FaqResponseDTOs;
		} catch (Exception e) {
			logger.error(" Error retrieveAllFaqDetails" + e);
			throw e;
		}

	}

	/**
	 * This method Searches Faq by criteria
	 * @author Amal
	 * @return List<Faq>
	 * @throws Exception
	 */
	
	
	@Override
	public List<FaqDetails> findFaqByCriteria(FaqDetailsRequestDTO faqRequestDTO) {
		GenericSpesification<FaqDetails> genericSpesification = new GenericSpesification<FaqDetails>();
		if (faqRequestDTO.getId() != null) {
			genericSpesification.add(new SearchCriteria("id", faqRequestDTO.getId(), SearchOperation.EQUAL));
		}
		if (faqRequestDTO.getStatus() != null) {
			genericSpesification.add(new SearchCriteria("status", faqRequestDTO.getStatus(), SearchOperation.MATCH));
		}

		if (faqRequestDTO.getAnswer() != null) {
			genericSpesification.add(new SearchCriteria("answer", faqRequestDTO.getAnswer(), SearchOperation.MATCH));
		}
		if (faqRequestDTO.getQuestion() != null) {
			genericSpesification
					.add(new SearchCriteria("question", faqRequestDTO.getQuestion(), SearchOperation.MATCH));
		}
		if (faqRequestDTO.getCreatedUser() != null) {
			genericSpesification
					.add(new SearchCriteria("createdUser", faqRequestDTO.getCreatedUser(), SearchOperation.MATCH));
		}
		if (faqRequestDTO.getLastModifiedUser() != null) {
			genericSpesification.add(
					new SearchCriteria("lastModifiedUser", faqRequestDTO.getLastModifiedUser(), SearchOperation.MATCH));
		}

		if (faqRequestDTO.getModule() != null) {
			genericSpesification.add(new SearchCriteria("module", faqRequestDTO.getModule(), SearchOperation.MATCH));
		}
		if (faqRequestDTO.getCreatedDate() != null) {
			genericSpesification.add(new SearchCriteria("createdDate", faqRequestDTO.getCreatedDate(),
					SearchOperation.GREATER_THAN_EQUAL));
		}
		if (faqRequestDTO.getLastModifiedDate() != null) {
			genericSpesification.add(new SearchCriteria("lastModifiedDate", faqRequestDTO.getLastModifiedDate(),
					SearchOperation.GREATER_THAN_EQUAL));
		}
		
		return faqDetailsRepository.findAll(genericSpesification);
	}

}
