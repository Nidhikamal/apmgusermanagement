package com.bourntec.apmg.usermanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.entity.CurrencyCode;
import com.bourntec.apmg.entity.PotentialGroup;
import com.bourntec.apmg.usermanagement.v1.dto.request.CurrencyCodeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CurrencyCodeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PotentialCustomerGroupResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.CurrencyCodeService;


/**
 * @author naveen Radhakrishnan
 *
 */

@RestController(value = "CurrencyCodeController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/currencyCode")
public class CurrencyCodeController {

	@Autowired
	CurrencyCodeService  currencyCodeService;
	
	/**
	 * This API saves Currency details
	 * 
	 * @param CurrencyCodeRequestDTO
	 * @return ResponseEntity<CurrencyCodeResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("")
	public ResponseEntity<CurrencyCodeResponseDTO> bankAccount(
			@RequestBody CurrencyCodeRequestDTO currencyCodeRequestDTO) throws Exception {
		CurrencyCodeResponseDTO currencyCodeResponseDTO = currencyCodeService.currencyCodesave(currencyCodeRequestDTO);
		return ResponseEntity.ok(currencyCodeResponseDTO);
	}

	/**
	 * This API updates Currency details
	 * 
	 * @param CurrencyCodeRequestDTO
	 * @return ResponseEntity<CurrencyCodeResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("/{currencyCode}")
	public ResponseEntity<CurrencyCodeResponseDTO> bankAccount(@PathVariable String currencyCode,
			@RequestBody CurrencyCodeRequestDTO currencyCodeRequestDTO) throws Exception {
		CurrencyCodeResponseDTO currencyCodeResponseDTO = currencyCodeService.currencyCodeupdate(currencyCode,
				currencyCodeRequestDTO);
		return ResponseEntity.ok(currencyCodeResponseDTO);
	}

	/**
	 * This API fetches Currency details
	 * 
	 * @param currencyCode
	 * @return ResponseEntity<CurrencyCodeResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("/{currencyCode}")
	public ResponseEntity<CurrencyCodeResponseDTO> findBycurrencyCode(@PathVariable String currencyCode)
			throws Exception {
		CurrencyCodeResponseDTO currencyCodeResponseDTO = currencyCodeService.findBycurrencyCode(currencyCode);
		return ResponseEntity.ok(currencyCodeResponseDTO);
	}

	/**
	 * This API fetches all Currency details.
	 * 
	 * @return List<CurrencyCode>
	 * @throws Exception
	 */
	@GetMapping("")
	public List<CurrencyCode> findAllCurrencyCode() throws Exception {
		List<CurrencyCode> currencyCodesList = currencyCodeService.findAllCurrencyCode();
		return currencyCodesList;
	}
	
	
	
	
	/**
	 * This REST endpoint exposes the search interface for searching  customer dynamically
	 * @param CustDataRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 */
	@PostMapping("/search")
	public ResponseEntity<List<CurrencyCode>>
	fetchByCurrency(@RequestBody CurrencyCodeRequestDTO currencyCodeRequestDTO) throws Exception  {

		
		List<CurrencyCode> countryCodes = currencyCodeService.fetchByCurrency(currencyCodeRequestDTO);

		return ResponseEntity.ok(countryCodes);
	}
	
	
	
	

}
