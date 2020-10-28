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

import com.bourntec.apmg.entity.PaymentTerms;
import com.bourntec.apmg.usermanagement.v1.dto.request.PaymentTermsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PaymentTermsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.PaymentTermsService;


@RestController(value = "PaymentTermsController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/paymentterms")
public class PaymentTermsController {

	@Autowired
	PaymentTermsService paymentService;

	/**
	 * This API save new paymentTerms
	 * 
	 * @param PaymentTermsRequestDTO
	 * @return ResponseEntity<PaymentTermsResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<PaymentTermsResponseDTO> savePaymentTerms(
			@RequestBody PaymentTermsRequestDTO paymentTermsRequestDTO) throws Exception {
		PaymentTermsResponseDTO paymentTermsResponseDTO = paymentService.savePaymentTerms(paymentTermsRequestDTO);
		return ResponseEntity.ok(paymentTermsResponseDTO);
	}

	/**
	 * This API updates PaymentTerms .
	 * 
	 * @param terms
	 * @param String terms PaymentTermsRequestDTO
	 * @return ResponseEntity<PaymentTermsResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/{terms}")
	public ResponseEntity<PaymentTermsResponseDTO> updatePaymentTerms(@PathVariable Long terms,
			@RequestBody PaymentTermsRequestDTO paymentTermsRequestDTO) throws Exception {
		PaymentTermsResponseDTO paymentTermsResponseDTO = paymentService.updatePaymentTerms(terms,
				paymentTermsRequestDTO);
		return ResponseEntity.ok(paymentTermsResponseDTO);
	}

	/**
	 * This API get PaymentTerms .
	 * 
	 * @param String termsId
	 * @return ResponseEntity<PaymentTermsResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("/{terms}")
	public ResponseEntity<PaymentTermsResponseDTO> findPaymentTermsById(@PathVariable Long terms) throws Exception {
		PaymentTermsResponseDTO paymentTermsResponseDTO = paymentService.findPaymentTermsById(terms);
		return ResponseEntity.ok(paymentTermsResponseDTO);
	}

	/**
	 * This API get PaymentTerms .
	 * 
	 * @return ResponseEntity<PaymentTermsResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<PaymentTermsResponseDTO>> findAllPaymentTerms() throws Exception {
		List<PaymentTermsResponseDTO> paymentTermsResponseDTOList = paymentService.findAllPaymentTerms();
		return ResponseEntity.ok(paymentTermsResponseDTOList);
	}

	
	@PostMapping("/search")
	public ResponseEntity<List<PaymentTerms>> fetchPaymentTermsByCriteria(@RequestBody  PaymentTermsRequestDTO paymentTermsRequestDTO) throws Exception  {

		
		List<PaymentTerms> selectedPaymentTerms = paymentService.findPaymentTermsByCriteria(paymentTermsRequestDTO);

		return ResponseEntity.ok(selectedPaymentTerms);
	}
}
