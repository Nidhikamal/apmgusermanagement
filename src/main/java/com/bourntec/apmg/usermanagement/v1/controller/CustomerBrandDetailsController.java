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

import com.bourntec.apmg.entity.CustomerBrandDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustomerBrandDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustomerBrandDetailsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.CustomerBrandDetailsService;

/**
 * @author Babu
 *
 */

@RestController(value = "CustomerBrandDetailsController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/customerbranddetails")

public class CustomerBrandDetailsController {

	@Autowired
	CustomerBrandDetailsService customerBrandDetailsService;

	/**
	 * This REST endpoint exposes the search interface for returning all customer brand details
	 * 
	 * @param
	 * @return allBrandsList
	 * @throws Exception
	 */
	@GetMapping("")
	public List<CustomerBrandDetails> fetchAllBrands() throws Exception {
		List<CustomerBrandDetails> allBrandsList = customerBrandDetailsService.findAllBrands();
		return allBrandsList;
	}
	

	/**
	 * This REST endpoint exposes the search interface for returning brand by id
	 * 
	 * @param id
	 * @return ResponseEntity<BrandResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/{id}")
	public ResponseEntity<CustomerBrandDetailsResponseDTO> fetchByBrandId(@PathVariable Long id) throws Exception {

		CustomerBrandDetailsResponseDTO selectedBrands = customerBrandDetailsService.getBrandById(id);
		return ResponseEntity.ok(selectedBrands);
	}
	

	/**
	 * This REST endpoint exposes the search interface for saving brand
	 * 
	 * @param
	 * @return ResponseEntity<BrandResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("")
	public ResponseEntity<CustomerBrandDetailsResponseDTO> saveBrandDetails(@RequestBody CustomerBrandDetailsRequestDTO brandsreqDTO)
			throws Exception {

		CustomerBrandDetailsResponseDTO savedrespBrands = customerBrandDetailsService.saveBrands(brandsreqDTO);
		return ResponseEntity.ok(savedrespBrands);

	}
	

	/**
	 * This REST endpoint exposes the search interface for updating brand by Id
	 * 
	 * @param id
	 * @return ResponseEntity<BrandDetails>
	 * @throws Exception
	 */
	

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateBrands(@RequestBody CustomerBrandDetailsRequestDTO brandsreqDTO, @PathVariable Long id)
			throws Exception {

		CustomerBrandDetailsResponseDTO updatedrespBrands = customerBrandDetailsService.updateBrands(id, brandsreqDTO);
		return ResponseEntity.ok(updatedrespBrands);
	}
	

	/**
	 * This REST endpoint exposes the search interface for searching  customer dynamically
	 * @param CustDataRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<CustomerBrandDetails>> fetchByCustomerCtriteria(@RequestBody CustomerBrandDetailsRequestDTO brandsreqDTO) 
			throws Exception  {
		
		List<CustomerBrandDetails> selectedCustomers = customerBrandDetailsService.findBrandsByCriteria(brandsreqDTO);
		return ResponseEntity.ok(selectedCustomers);
	}
	
	
	/**
	 * This API delete a Customer Brand
	 * @param id
	 * @return ResponseEntity<?>
	 */
	@DeleteMapping("/{id}")  
	public ResponseEntity<?> deleteCustDataById(@PathVariable("id") Long id)  
	{  
		customerBrandDetailsService.deleteCustDataById(id);
	return ResponseEntity.ok().build();
	}
	
}
