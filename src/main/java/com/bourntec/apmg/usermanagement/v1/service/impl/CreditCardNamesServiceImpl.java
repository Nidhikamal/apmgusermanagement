package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CreditcardNames;
import com.bourntec.apmg.usermanagement.v1.dto.request.CreditcardsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CreditcardResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.CreditcardRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.CreditCardNamesService;

/**
 * 
 * Service class implementation for employee Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Service(value = "CreditCardNamesServiceImpl0")
public class CreditCardNamesServiceImpl implements CreditCardNamesService {

	private static final Logger logger = LogManager.getLogger(CreditCardNamesServiceImpl.class);

	@Autowired
	private CreditcardRepository creditCardRepository;

	

	/**
	 * @author amal This is the main method which is used to get Credit Card names
	 *         data by id
	 * 
	 */
	public CreditcardResponseDTO getCreditCardById(String id) {
		CreditcardResponseDTO cardResponceDTO = new CreditcardResponseDTO();
		try {
			logger.info("Fetching  Creditcard Names...");
			Optional<CreditcardNames> optionalCreditCard = creditCardRepository.findById(id);
			if (optionalCreditCard.isPresent()) {
				CreditcardNames card = optionalCreditCard.get();
				BeanUtils.copyProperties(card, cardResponceDTO);
			} else {
				logger.error("Creditcard Name doesn't exist");
				cardResponceDTO.setResponseMessage("Creditcard Name doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch: Company " + e);
			throw e;
		}
		return cardResponceDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all Credit Card
	 *         names
	 * 
	 */

	public List<CreditcardNames> findAllCreditCards() {
		logger.info("Fetching all Creditcard Names ...");
		return creditCardRepository.findAll();
	}

	/**
	 * @author amal This is the main method which is used to get save Credit Card
	 *         names
	 * 
	 * @param CreditcardsRequestDTO
	 * @return CreditcardResponseDTO
	 */

	public CreditcardResponseDTO saveCreditCards(CreditcardsRequestDTO creditCardReqDTO) {
		CreditcardResponseDTO cardResponseDTO = new CreditcardResponseDTO();
		try {
			CreditcardNames cardNames = creditCardReqDTO.toModel(creditCardReqDTO);
			CreditcardNames cardEntity = creditCardRepository.save(cardNames);
			if (cardEntity != null) {
				BeanUtils.copyProperties(cardEntity, cardResponseDTO);
				cardResponseDTO.setResponseMessage("Saved  Creditcard Names successfully");
				logger.info("Saved  Creditcard Names successfully");
			} else {
				cardResponseDTO.setResponseMessage("Failed to save  Creditcard Names");
				logger.error("Failed to save  Creditcard Names ");
			}
		} catch (Exception e) {
			logger.error("Save: saveCreditCards " + e);
			throw e;
		}
		return cardResponseDTO;
	}

	/**
	 * @author amal This is the main method which is used to get update Credit Card
	 *         names
	 * 
	 * @param CreditcardsRequestDTO,String cardType
	 * @return CreditcardResponseDTO
	 */

	public CreditcardResponseDTO updateCreditCards(String cardType, CreditcardsRequestDTO creditReqDTO) {
		CreditcardResponseDTO updatedCreditCardsrespDTO = new CreditcardResponseDTO();
		try {
			Optional<CreditcardNames> creditCardOptional = creditCardRepository.findById(cardType);
			if (creditCardOptional.isPresent()) {
				CreditcardNames newCreditCards = creditReqDTO.toModel(creditReqDTO);
				newCreditCards.setCreditType(cardType);
				CreditcardNames cardEntity = creditCardRepository.save(newCreditCards);
				if (cardEntity != null) {
					BeanUtils.copyProperties(cardEntity, updatedCreditCardsrespDTO);
					updatedCreditCardsrespDTO.setResponseMessage("Updated  Creditcard Names successfully");
					logger.info("Updated  Creditcard Names successfully");
				} else {
					updatedCreditCardsrespDTO.setResponseMessage("Creditcard Names updation failed");
					logger.error(" Creditcard Names updation failed");
				}
			} else {
				logger.error("Creditcard Names doesn't exist");
				updatedCreditCardsrespDTO.setResponseMessage("Creditcard Names doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update: updateCreditCards " + e);
			throw e;
		}

		return updatedCreditCardsrespDTO;
	}

	public List<CreditcardNames> findCreditCardsByCriteria(CreditcardsRequestDTO creditreqDTO) {
		GenericSpesification<CreditcardNames> genericSpesification = new GenericSpesification<CreditcardNames>();
		logger.info("Fetching  Creditcard Names...");
		if (creditreqDTO.getCardName()!= null) {
			genericSpesification
					.add(new SearchCriteria("cardName", creditreqDTO.getCardName(), SearchOperation.MATCH));
		}
		if (creditreqDTO.getCardNo() != null) {
			genericSpesification
					.add(new SearchCriteria("cardNo", creditreqDTO.getCardNo(), SearchOperation.MATCH));
		}
		if (creditreqDTO.getCardType() != null) {
			genericSpesification
					.add(new SearchCriteria("cardType", creditreqDTO.getCardType(), SearchOperation.MATCH));
		}
		if (creditreqDTO.getCreditType() != null) {
			genericSpesification
					.add(new SearchCriteria("creditType", creditreqDTO.getCreditType(), SearchOperation.MATCH));
		}
		if (creditreqDTO.getCvv() != null) {
			genericSpesification
					.add(new SearchCriteria("cvv", creditreqDTO.getCvv(), SearchOperation.MATCH));
		}
		if (creditreqDTO.getDisplayWeb() != null) {
			genericSpesification
					.add(new SearchCriteria("displayWeb", creditreqDTO.getDisplayWeb(), SearchOperation.MATCH));
		}
		if (creditreqDTO.getEmpNo() != null) {
			genericSpesification
					.add(new SearchCriteria("empNo", creditreqDTO.getEmpNo(), SearchOperation.MATCH));
		}
		if (creditreqDTO.getExpMonth() != null) {
			genericSpesification
					.add(new SearchCriteria("expMonth", creditreqDTO.getExpMonth(), SearchOperation.MATCH));
		}
		if (creditreqDTO.getExpYear() != null) {
			genericSpesification
					.add(new SearchCriteria("expYear", creditreqDTO.getExpYear(), SearchOperation.MATCH));
		}

		return creditCardRepository.findAll(genericSpesification);
	}
}
