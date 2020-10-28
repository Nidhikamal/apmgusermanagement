package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.BankAccounts;
import com.bourntec.apmg.usermanagement.v1.dto.request.BankAccountRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BankAccountResponsetDTO;
import com.bourntec.apmg.usermanagement.v1.repository.BankAccountRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.BankAccountService;

@Service(value = "BankAccountServiceImpl")

public class BankAccountServiceImpl  implements  BankAccountService {
	
	
	private static final Logger logger = LogManager.getLogger(BankAccountServiceImpl.class);

	

	@Autowired
	private BankAccountRepository bankAccountRepository;

	/**
	 * @author naveen This is the main method which is used to save BankAccount data
	 * 
	 */
	public BankAccountResponsetDTO saveBankAccount(BankAccountRequestDTO bankAccountRequestDTO) {

		logger.info("Entering BankAccount details {}", bankAccountRequestDTO);
		BankAccountResponsetDTO bankAccountResponsetDTO = new BankAccountResponsetDTO();
		try {
			BankAccounts bAccount = bankAccountRequestDTO.toModel(bankAccountRequestDTO);
			BankAccounts emp = bankAccountRepository.save(bAccount);
			if (emp != null) {
				logger.info("BankAccount Details is saved");
				BeanUtils.copyProperties(emp, bankAccountResponsetDTO);
			} else {
				logger.info("BankAccount is not saved in DB");
				bankAccountResponsetDTO.setResponseMessage("BankAccount is not  in DB");
			}
		}

		catch (Exception e) {
			logger.error(" BankAccount save  failed" + e);

			throw e;
		}
		return bankAccountResponsetDTO;

	}

	/**
	 * @author naveen This is the main method which is used to update BankAccount
	 *         data
	 * 
	 */
	public BankAccountResponsetDTO updateBankAccount(String bankNo, BankAccountRequestDTO bankAccountRequestDTO) {
		BankAccountResponsetDTO updatedRespDTOBankAccounts = new BankAccountResponsetDTO();
		try {
			Optional<BankAccounts> packingOptional = bankAccountRepository.findById(bankNo);
			if (packingOptional.isPresent()) {
				BankAccounts newShipCodes = bankAccountRequestDTO.toModel(bankAccountRequestDTO);
				newShipCodes.setBankNo(bankNo);
				BankAccounts shippingEntity = bankAccountRepository.save(newShipCodes);
				if (shippingEntity != null) {
					BeanUtils.copyProperties(shippingEntity, updatedRespDTOBankAccounts);
					updatedRespDTOBankAccounts.setResponseMessage("Updated  Bank Account");
					logger.info("Updated  Bank Account");
				} else {
					logger.error("Bank Account updation failed");
					updatedRespDTOBankAccounts.setResponseMessage("Bank Account updation failed");
				}
			} else {
				logger.error(" Bank Account doesn't exist");
				updatedRespDTOBankAccounts.setResponseMessage(" Bank Account doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update:updateBankAccounts " + e);
			throw e;
		}

		return updatedRespDTOBankAccounts;
	}
	
	/**
	 * @author naveen This is the main method which is used to get all BankAccounts
	 * 
	 */
	public List<BankAccounts> findAllBankAccounts() {
		logger.info("Fetching all BankAccounts  ...");

		return bankAccountRepository.findAll();
	}
	
	

	/**
	 * This method findBybankNo
	 * 
	 * @param idbankNo
	 * @return BankAccountResponsetDTO
	 * @throws Exception
	 */
	public BankAccountResponsetDTO findBybankNo(String bankNo) {

		BankAccountResponsetDTO bankAccountResponsetDTO = new BankAccountResponsetDTO();
		try {
			logger.info("Fetching  Bank Account");
			Optional<BankAccounts> optionalShipping = bankAccountRepository.findById(bankNo);
			if (optionalShipping.isPresent()) {
				BankAccounts shippping = optionalShipping.get();
				BeanUtils.copyProperties(shippping, bankAccountResponsetDTO);
			} else {
				logger.error("Bank Account doesn't exist");
				bankAccountResponsetDTO.setResponseMessage("Bank Account doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch:getBankAccountsById " + e);
			throw e;
		}
		return bankAccountResponsetDTO;
	}
	
	


	@Override
	public List<BankAccounts> fetchByAccound(BankAccountRequestDTO brandReq) {
	GenericSpesification<BankAccounts> genericSpesification = new GenericSpesification<BankAccounts>();
		
		if(brandReq.getBankNo()!=null) {
			 genericSpesification.add(new SearchCriteria("bankNo",brandReq.getBankNo(), SearchOperation.MATCH));
			}
			if(brandReq.getBankName()!=null) {
	        genericSpesification.add(new SearchCriteria("bankName",brandReq.getBankName(), SearchOperation.MATCH));
			}
			
		
		 return bankAccountRepository.findAll(genericSpesification);
	}



}
