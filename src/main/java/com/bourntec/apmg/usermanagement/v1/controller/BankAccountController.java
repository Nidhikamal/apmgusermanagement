package com.bourntec.apmg.usermanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.entity.BankAccounts;
import com.bourntec.apmg.usermanagement.v1.dto.request.BankAccountRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BankAccountResponsetDTO;
import com.bourntec.apmg.usermanagement.v1.service.BankAccountService;


/**
 * @author naveen Radhakrishnan
 *
 */

@RestController(value = "BankAccountController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/bankaccount")
public class BankAccountController {

	
	@Autowired
	BankAccountService  bankAccountService;
	
	
	
	

	/**
	 * This API saves BankAccount details
	 * 
	 * @param bankNo
	 * @param BankAccountRequestDTO
	 * @return ResponseEntity<BankAccountResponsetDTO>
	 * @throws Exception
	 */

	@PostMapping("")
	public ResponseEntity<BankAccountResponsetDTO> bankAccount(@RequestBody BankAccountRequestDTO bankAccountRequestDTO)
			throws Exception {
		BankAccountResponsetDTO bankAccountResponsetDTO = bankAccountService.saveBankAccount(bankAccountRequestDTO);
		return ResponseEntity.ok(bankAccountResponsetDTO);
	}

	/**
	 * This API updates BankAccount details
	 * 
	 * @param bankNo
	 * @param BankAccountRequestDTO
	 * @return ResponseEntity<BankAccountResponsetDTO>
	 * @throws Exception
	 */
	@PutMapping("/{bankNo}")
	public ResponseEntity<BankAccountResponsetDTO> bankAccount(@PathVariable String bankNo,
			@RequestBody BankAccountRequestDTO bankAccountRequestDTO) throws Exception {
		BankAccountResponsetDTO bankAccountResponsetDTO = bankAccountService.updateBankAccount(bankNo, bankAccountRequestDTO);
		return ResponseEntity.ok(bankAccountResponsetDTO);
	}

	/**
	 * This API fetches BankAccount details
	 * 
	 * @param bankNo
	 * @return ResponseEntity<BankAccountResponsetDTO>
	 * @throws Exception
	 */

	@GetMapping("/{bankNo}")
	public ResponseEntity<BankAccountResponsetDTO> bankAccount(@PathVariable String bankNo) throws Exception {
		BankAccountResponsetDTO bankAccountResponsetDTO = bankAccountService.findBybankNo(bankNo);
		return ResponseEntity.ok(bankAccountResponsetDTO);
	}

	/**
	 * This API fetches all BankAccount details.
	 * 
	 * @return List<CurrencyCode>
	 * @throws Exception
	 */
	@GetMapping("")
	public List<BankAccounts> findAllBankAccounts() throws Exception {
		List<BankAccounts> bankAccountsList = bankAccountService.findAllBankAccounts();
		return bankAccountsList;
	}
	
	
	/**
	 * This REST endpoint exposes the search interface for searching  customer dynamically
	 * @param CustDataRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 */
	@PostMapping("/search")
	public ResponseEntity<List<BankAccounts>>
	fetchByAccound(@RequestBody BankAccountRequestDTO locationCodeRequestDTO) throws Exception  {

		
		List<BankAccounts> countryCodes = bankAccountService.fetchByAccound(locationCodeRequestDTO);

		return ResponseEntity.ok(countryCodes);
	}


}
