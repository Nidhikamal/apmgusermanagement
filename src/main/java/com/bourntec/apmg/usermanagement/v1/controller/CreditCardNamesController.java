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

import com.bourntec.apmg.entity.CreditcardNames;
import com.bourntec.apmg.usermanagement.v1.dto.request.CreditcardsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CreditcardResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.CreditCardNamesService;

/**
 * @author Amal Chandra N A
 *
 */
@RestController(value = "CreditCardNamesController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/creditcardsnames")
public class CreditCardNamesController {

	@Autowired
	CreditCardNamesService creditNameService;


	/**
	 * This REST endpoint exposes the search interface for saving credit card names
	 * 
	 * @param CreditcardsRequestDTO
	 * @return ResponseEntity<CreditcardResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<CreditcardResponseDTO> saveCreditCards(@RequestBody CreditcardsRequestDTO creditreqDTO)
			throws Exception {

		CreditcardResponseDTO savedrespcards = creditNameService.saveCreditCards(creditreqDTO);

		return ResponseEntity.ok(savedrespcards);

	}

	/**
	 * This REST endpoint exposes the search interface for returning credit cards by
	 * id
	 * 
	 * @param String id
	 * @return ResponseEntity<CreditcardResponseDTO>
	 */

	@GetMapping("/{id}")
	public ResponseEntity<CreditcardResponseDTO> fetchCreditCardByType(@PathVariable String id) throws Exception {

		CreditcardResponseDTO selectedcards = creditNameService.getCreditCardById(id);

		return ResponseEntity.ok(selectedcards);
	}

	/**
	 * This REST endpoint exposes the search interface for updating Credit Cards by
	 * Id
	 * 
	 * @param CreditcardsRequestDTO,String id
	 * @return ResponseEntity<CreditcardResponseDTO>
	 */

	@PutMapping("/{id}")
	public ResponseEntity<CreditcardResponseDTO> updateCreditCardByType(@RequestBody CreditcardsRequestDTO creditreqDTO,
			@PathVariable String id) throws Exception {

		CreditcardResponseDTO updatedCompanyData = creditNameService.updateCreditCards(id, creditreqDTO);
		return ResponseEntity.ok(updatedCompanyData);
	}

	/**
	 * This REST endpoint exposes the search interface for getting all Credit Cards
	 * 
	 * @param
	 * @return ResponseEntity<CreditcardResponseDTO>
	 */
	@GetMapping("")
	public ResponseEntity<List<CreditcardNames>> fetchAllsCreditCards() throws Exception {

		List<CreditcardNames> allcmpnycodes = creditNameService.findAllCreditCards();
		return ResponseEntity.ok(allcmpnycodes);
	}
	
	/**
	 * This REST endpoint exposes the search interface for searching  company codes dynamically
	 * @param CreditcardsRequestDTO
	 * @return List<CreditcardNames>
	 */
	
	@PostMapping("/search")
	public ResponseEntity<List<CreditcardNames>> fetchByCreditCriteria(@RequestBody CreditcardsRequestDTO creditReqDTO) throws Exception  {

		
		List<CreditcardNames> selectedCompany= creditNameService.findCreditCardsByCriteria(creditReqDTO);

		return ResponseEntity.ok(selectedCompany);
	}

}
