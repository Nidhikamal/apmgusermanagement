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
import com.bourntec.apmg.usermanagement.v1.dto.request.BrandRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.BrokersRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.FaqDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BrandResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BrokersResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.FaqResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.BrandService;
import com.bourntec.apmg.usermanagement.v1.service.BrokersService;


@RestController(value = "BrokersController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/brokers")
public class BrokersController {

	@Autowired
	BrokersService brokerService;

	/**
	 * This API save new broker object
	 * 
	 * @return ResponseEntity<PaymentTermsResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<BrokersResponseDTO> saveBrokers(@RequestBody BrokersRequestDTO brokersRequestDTO)
			throws Exception {
		BrokersResponseDTO brokersResponseDTO = brokerService.saveBrokers(brokersRequestDTO);
		return ResponseEntity.ok(brokersResponseDTO);
	}

	/**
	 * This API get brokerby id
	 * 
	 * @return ResponseEntity<PaymentTermsResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("/{brokerId}")
	public ResponseEntity<BrokersResponseDTO> findBrokerById(@PathVariable String brokerId) throws Exception {
		BrokersResponseDTO brokersResponseDTO = brokerService.findBrokersById(brokerId);
		return ResponseEntity.ok(brokersResponseDTO);
	}

	/**
	 * This API get all brokers
	 * 
	 * @return ResponseEntity<BrokersResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<BrokersResponseDTO>> findAllBrokers() throws Exception {
		List<BrokersResponseDTO> brokersResponseDTOList = brokerService.findAllBrokers();
		return ResponseEntity.ok(brokersResponseDTOList);
	}

	/**
	 * This API updates broker object.
	 * 
	 * @param brokerId
	 * @param String   brokerId
	 * @return ResponseEntity<BrokersResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/{brokerId}")
	public ResponseEntity<BrokersResponseDTO> updateBrokers(@PathVariable String brokerId,
			@RequestBody BrokersRequestDTO brokersRequestDTO) throws Exception {
		BrokersResponseDTO brokersResponseDTO = brokerService.updateBrokers(brokerId, brokersRequestDTO);
		return ResponseEntity.ok(brokersResponseDTO);
	}
	
	
	@PostMapping("/search")
	public ResponseEntity<List<Brokers>> fetchBrokersByCriteria(@RequestBody BrokersRequestDTO brokersRequestDTO) throws Exception  {

		
		List<Brokers> selectedBrokers = brokerService.findBrokersByCriteria(brokersRequestDTO);

		return ResponseEntity.ok(selectedBrokers);
	}
}
