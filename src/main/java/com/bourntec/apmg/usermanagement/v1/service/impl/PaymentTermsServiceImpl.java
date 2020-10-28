package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.PaymentTerms;
import com.bourntec.apmg.usermanagement.v1.dto.request.PaymentTermsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PaymentTermsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.PaymentTermsRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.PaymentTermsService;


@Service(value = "PaymentTermsServiceImpl")
public class PaymentTermsServiceImpl implements PaymentTermsService {

	private static final Logger logger = LogManager.getLogger(PaymentTermsServiceImpl.class);

	@Autowired
	private PaymentTermsRepository paymentTermsRepository;

	/**
	 * updatePaymentTerms
	 * 
	 * @param termsId,paymentTermsRequestDTO
	 * @return paymentTermsResponseDTO
	 * @throws Exception
	 */
	public PaymentTermsResponseDTO updatePaymentTerms(Long termsId, PaymentTermsRequestDTO paymentTermsRequestDTO)
			throws Exception {

		logger.info("Going to update payment terms");

		try {
			PaymentTermsResponseDTO paymentTermsResponseDTO = new PaymentTermsResponseDTO();
			PaymentTerms paymentTerms = paymentTermsRequestDTO.toModel(paymentTermsRequestDTO);
			paymentTerms.setTerms(termsId);
			PaymentTerms paymentTermsrepo = paymentTermsRepository.save(paymentTerms);
			logger.info("Update payment terms");
			if (paymentTermsrepo != null) {
				BeanUtils.copyProperties(paymentTermsrepo, paymentTermsResponseDTO);
			} else {
				logger.error(" Error in update paymentTerms");
				paymentTermsResponseDTO.setResponseMessage("Error in update paymentTerms");
			}
			return paymentTermsResponseDTO;
		} catch (Exception e) {
			logger.error(" updatePaymentTerms failed" + e);
			throw e;
		}

	}

	/**
	 * savePaymentTerms
	 * 
	 * @param termsId,paymentTermsRequestDTO
	 * @return paymentTermsResponseDTO
	 * @throws Exception
	 */
	public PaymentTermsResponseDTO savePaymentTerms(PaymentTermsRequestDTO paymentTermsRequestDTO) throws Exception {

		logger.info(" PaymentTerms is going to save");
		PaymentTermsResponseDTO paymentTermsResponseDTO = new PaymentTermsResponseDTO();
		try {
			PaymentTerms paymentTerms = paymentTermsRequestDTO.toModel(paymentTermsRequestDTO);
			PaymentTerms paymentTermsrepo = paymentTermsRepository.save(paymentTerms);
			logger.info(" PaymentTerms persisted in Db");
			if (paymentTermsrepo != null) {
				BeanUtils.copyProperties(paymentTermsrepo, paymentTermsResponseDTO);
				paymentTermsResponseDTO.setResponseMessage("saved in savePaymentTerms");
			} else {
				logger.error(" Error in savePaymentTerms ");
				paymentTermsResponseDTO.setResponseMessage("Error in savePaymentTerms");
			}
			return paymentTermsResponseDTO;
		} catch (Exception e) {
			logger.error(" savePaymentTerms failed" + e);
			throw e;
		}
	}

	/**
	 * findPaymentTermsById
	 * 
	 * @param terms
	 * @return paymentTermsResponseDTO
	 * @throws Exception
	 */

	public PaymentTermsResponseDTO findPaymentTermsById(Long terms) throws Exception {
		logger.info("Going to findPaymentTerms");

		try {
			PaymentTermsResponseDTO paymentTermsResponseDTO = new PaymentTermsResponseDTO();
			Optional<PaymentTerms> paymentTerms = paymentTermsRepository.findById(terms);
			logger.info("findPaymentTermsById");
			if (paymentTerms != null) {
				BeanUtils.copyProperties(paymentTerms.get(), paymentTermsResponseDTO);
				return paymentTermsResponseDTO;
			} else {

				throw new ResourceNotFoundException(ErrorCodes.PAYMENTTERMS_NOT_FOUND.getMessage());
			}

		} catch (Exception e) {
			logger.error(" findPaymentTermsById failed" + e);
			throw e;
		}

	}

	/**
	 * findAllPaymentTerms
	 * 
	 * @return paymentTermsResponseDTO list
	 * @throws Exception
	 */
	public List<PaymentTermsResponseDTO> findAllPaymentTerms() throws Exception {

		logger.info(" RetrieveAllPaymentTerms");
		List<PaymentTermsResponseDTO> termsResponseDTOList = new ArrayList<PaymentTermsResponseDTO>();
		try {
			List<PaymentTerms> paymentTermsList = paymentTermsRepository.findAll();
			if (paymentTermsList != null && paymentTermsList.size() > 0) {
				paymentTermsList.forEach((paymentTerms) -> {
					PaymentTermsResponseDTO paymentTermsResponseDTO = new PaymentTermsResponseDTO();
					BeanUtils.copyProperties(paymentTerms, paymentTermsResponseDTO);
					termsResponseDTOList.add(paymentTermsResponseDTO);

				});
				logger.info("findAllPaymentTerms");
			} else {
				logger.error(" Error findAllPaymentTerms ");

			}

			return termsResponseDTOList;
		} catch (Exception e) {
			logger.error("findAllPaymentTerms" + e);
			throw e;
		}

	}

	/**
	 * This method Searches PaymentTerms by criteria
	 * @author Amal
	 * @return List<PaymentTerms>
	 * @throws Exception
	 */
	
	public List<PaymentTerms> findPaymentTermsByCriteria(PaymentTermsRequestDTO paymentTermsRequestDTO) {
		GenericSpesification<PaymentTerms> genericSpesification = new GenericSpesification<PaymentTerms>();

		if (paymentTermsRequestDTO.getTerms() != null) {
			genericSpesification
					.add(new SearchCriteria("terms", paymentTermsRequestDTO.getTerms(), SearchOperation.EQUAL));
		}
		if (paymentTermsRequestDTO.getTermDesc() != null) {
			genericSpesification
					.add(new SearchCriteria("termDesc", paymentTermsRequestDTO.getTermDesc(), SearchOperation.MATCH));
		}
		if (paymentTermsRequestDTO.getDueDateType() != null) {
			genericSpesification.add(
					new SearchCriteria("dueDateType", paymentTermsRequestDTO.getDueDateType(), SearchOperation.MATCH));
		}
		if (paymentTermsRequestDTO.getDueDateDay() != null) {
			genericSpesification.add(
					new SearchCriteria("dueDateDay", paymentTermsRequestDTO.getDueDateDay(), SearchOperation.EQUAL));
		}
		if (paymentTermsRequestDTO.getDiscDateType() != null) {
			genericSpesification.add(new SearchCriteria("discDateType", paymentTermsRequestDTO.getDiscDateType(),
					SearchOperation.MATCH));
		}
		if (paymentTermsRequestDTO.getDiscDateDay() != null) {
			genericSpesification.add(
					new SearchCriteria("discDateDay", paymentTermsRequestDTO.getDiscDateDay(), SearchOperation.EQUAL));
		}
		if (paymentTermsRequestDTO.getDiscPer() != null) {
			genericSpesification
					.add(new SearchCriteria("discPer", paymentTermsRequestDTO.getDiscPer(), SearchOperation.EQUAL));
		}
		if (paymentTermsRequestDTO.getCreateDate() != null) {
			genericSpesification.add(
					new SearchCriteria("createDate", paymentTermsRequestDTO.getCreateDate(), SearchOperation.EQUAL));
		}
		if (paymentTermsRequestDTO.getCreateUser() != null) {
			genericSpesification.add(
					new SearchCriteria("createUser", paymentTermsRequestDTO.getCreateUser(), SearchOperation.MATCH));
		}
		if (paymentTermsRequestDTO.getLocationCode() != null) {
			genericSpesification.add(new SearchCriteria("locationCode", paymentTermsRequestDTO.getLocationCode(),
					SearchOperation.MATCH));
		}
		return paymentTermsRepository.findAll(genericSpesification);
	}
}
