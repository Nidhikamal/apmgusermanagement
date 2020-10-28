package com.bourntec.apmg.usermanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.entity.CustNotification;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustNotificationRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustNotificationResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.CustNotificationService;

/**
 * @author  
 *
 */

@RestController(value = "CustNotificationController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1")

public class CustNotificationController {
	
	@Autowired
	CustNotificationService custNotificationService;
	
	/**
	 * This API saves CustNotification details
	 * 
	 * @param CustNotificationRequestDTO
	 * @return ResponseEntity<CustNotificationResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("/custnotification")
	public ResponseEntity<CustNotificationResponseDTO> saveCustNotification(@RequestBody CustNotificationRequestDTO custNotificationRequestDTO)
			throws Exception {
		CustNotificationResponseDTO custNotificationResponseDTO = custNotificationService.saveCustNotification(custNotificationRequestDTO);
		return ResponseEntity.ok(custNotificationResponseDTO);
	}	
	
	
	/**
	 * This API updates CustNotification details
	 * 
	 * @param custNo
	 * @param CustNotificationRequestDTO
	 * @return ResponseEntity<CustNotificationResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/custnotification/{custNo}")
	public ResponseEntity<CustNotificationResponseDTO> updateCustNotification(@PathVariable String custNo,
			@RequestBody CustNotificationRequestDTO custNotificationRequestDTO) throws Exception {
		CustNotificationResponseDTO custNotificationResponseDTO = custNotificationService.updateCustNotification(custNo, custNotificationRequestDTO);
		return ResponseEntity.ok(custNotificationResponseDTO);
	}
	

	/**
	 * This API fetches CustNotification details
	 * 
	 * @param custNo
	 * @return ResponseEntity<CustNotificationResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("/custnotification/{custNo}")
	public ResponseEntity<CustNotificationResponseDTO> findByCustNotification(@PathVariable String custNo) throws Exception {
		CustNotificationResponseDTO custNotificationResponseDTO = custNotificationService.findByCustNotification(custNo);
		return ResponseEntity.ok(custNotificationResponseDTO);
	}
	

	/**
	 * This API fetches all CustNotification details.
	 * 
	 * @return custNotificationList
	 * @throws Exception
	 */
	@GetMapping("/custnotification")
	public List<CustNotification> findAllCustNotification() throws Exception {
		List<CustNotification>custNotificationList = custNotificationService.findAllCustNotifications();
		return custNotificationList;
	}
	
	
	/**
	 * This REST end point exposes the search CustNotification details
	 * @param CustNotificationRequestDTO
	 * @return ResponseEntity<CustNotificationResponseDTO>
	 */
	@PostMapping("/custnotification/search")
	public ResponseEntity<List<CustNotification>>
	fetchByAccound(@RequestBody CustNotificationRequestDTO custNotificationRequestDTO) throws Exception  {		
		List<CustNotification> custNotifications = custNotificationService.fetchByCustNotification(custNotificationRequestDTO);
		return ResponseEntity.ok(custNotifications);
	}
	
	
	/**
	 * This API delete an CustNotification
	 * @param custNo
	 * @return ResponseEntity<?>
	 */
	@DeleteMapping("/custnotification/{custNo}")
	public ResponseEntity<?> deleteCustNotification(@PathVariable String custNo) {
		custNotificationService.deleteCustNotification(custNo);
		return ResponseEntity.ok().build();
	}

}
