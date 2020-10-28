package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.BankAccounts;
import com.bourntec.apmg.usermanagement.v1.dto.request.BankAccountRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BankAccountResponsetDTO;

public interface BankAccountService {

	List<BankAccounts> findAllBankAccounts();

	BankAccountResponsetDTO findBybankNo(String bankNo);

	BankAccountResponsetDTO updateBankAccount(String bankNo, BankAccountRequestDTO bankAccountRequestDTO);

	BankAccountResponsetDTO saveBankAccount(BankAccountRequestDTO bankAccountRequestDTO);

	List<BankAccounts> fetchByAccound(BankAccountRequestDTO locationCodeRequestDTO);

	
	
}
