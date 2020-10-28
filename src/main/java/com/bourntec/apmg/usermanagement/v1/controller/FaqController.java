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

import com.bourntec.apmg.entity.BrandDetails;
import com.bourntec.apmg.entity.Brokers;
import com.bourntec.apmg.entity.FaqDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.BrandRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.BrokersRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.FaqDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BrandResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.FaqResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.BrandService;
import com.bourntec.apmg.usermanagement.v1.service.FaqService;


@RestController(value = "FaqController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/faq")
public class FaqController {

	@Autowired
	FaqService faqService;

	/**
	 * This API save new faq object
	 * 
	 * @return ResponseEntity<PaymentTermsResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<FaqResponseDTO> saveFaq(@RequestBody FaqDetailsRequestDTO faqDetailsRequestDTO)
			throws Exception {

		FaqResponseDTO faqResponseDTO = faqService.saveFaqDetails(faqDetailsRequestDTO);
		return ResponseEntity.ok(faqResponseDTO);
	}

	/**
	 * This API updates faq object.
	 * 
	 * @param id
	 * @return ResponseEntity<FaqResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<FaqResponseDTO> updateFaqDetails(@PathVariable Integer id,
			@RequestBody FaqDetailsRequestDTO faqDetailsRequestDTO) throws Exception {
		FaqResponseDTO faqResponseDTO = faqService.updateFaqDetails(id, faqDetailsRequestDTO);
		return ResponseEntity.ok(faqResponseDTO);
	}

	/**
	 * This API get faq object.
	 * 
	 * @param id
	 * @return ResponseEntity<FaqResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/{id}")
	public ResponseEntity<FaqResponseDTO> findFaqDetailsById(@PathVariable Integer id) throws Exception {
		FaqResponseDTO faqResponseDTO = faqService.findFaqDetailsById(id);
		return ResponseEntity.ok(faqResponseDTO);
	}

	/**
	 * This API find all faqs
	 * 
	 * @return ResponseEntity<FaqResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("")
	public ResponseEntity<List<FaqResponseDTO>> findAllFaq() throws Exception {
		List<FaqResponseDTO> faqResponseDTOs = faqService.findAllFaqDetails();
		return ResponseEntity.ok(faqResponseDTOs);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<FaqDetails>> fetchFaqByCtriteria(@RequestBody FaqDetailsRequestDTO faqRequestDTO) throws Exception  {

		
		List<FaqDetails> selectedFaqs = faqService.findFaqByCriteria(faqRequestDTO);

		return ResponseEntity.ok(selectedFaqs);
	}

}
