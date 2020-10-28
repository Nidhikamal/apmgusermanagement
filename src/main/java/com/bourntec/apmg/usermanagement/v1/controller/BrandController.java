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
import com.bourntec.apmg.usermanagement.v1.dto.request.BrandRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BrandResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.BrandService;

/**
 * @author Amal Chandra N A
 *
 */
@RestController(value = "BrandController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/brands")
public class BrandController {

	@Autowired
	BrandService brandService;

	/**
	 * This REST endpoint exposes the search interface for returning all brand
	 * details
	 * 
	 * @param
	 * @return ResponseEntity<BrandDetails>
	 */
	@GetMapping("")
	public ResponseEntity<List<BrandDetails>> fetchAllBrands() throws Exception {

		List<BrandDetails> allBrands = brandService.findAllBrands();
		return ResponseEntity.ok(allBrands);
	}

	/**
	 * This REST endpoint exposes the search interface for returning brand by id
	 * 
	 * @param
	 * @return ResponseEntity<BrandResponseDTO>
	 */

	@GetMapping("/{brandId}")
	public ResponseEntity<BrandResponseDTO> fetchByBrandId(@PathVariable Long brandId) throws Exception {

		BrandResponseDTO selectedBrands = brandService.getBrandById(brandId);

		return ResponseEntity.ok(selectedBrands);
	}

	/**
	 * This REST endpoint exposes the search interface for saving brand
	 * 
	 * @param
	 * @return ResponseEntity<BrandResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<BrandResponseDTO> saveBrandDetails(@RequestBody BrandRequestDTO brandsreqDTO)
			throws Exception {

		BrandResponseDTO savedrespBrands = brandService.saveBrands(brandsreqDTO);

		return ResponseEntity.ok(savedrespBrands);

	}

	/**
	 * This REST endpoint exposes the search interface for updating brand by Id
	 * 
	 * @param
	 * @return ResponseEntity<BrandDetails>
	 */

	@PutMapping("/{brandId}")
	public ResponseEntity<Object> updateBrands(@RequestBody BrandRequestDTO brandsreqDTO, @PathVariable Long brandId)
			throws Exception {

		BrandResponseDTO updatedrespBrands = brandService.updateBrands(brandId, brandsreqDTO);
		return ResponseEntity.ok(updatedrespBrands);
	}

	/**
	 * This REST endpoint exposes the search interface for searching  customer dynamically
	 * @param CustDataRequestDTO
	 * @return ResponseEntity<CustDataResponseDTO>
	 */
	@PostMapping("/search")
	public ResponseEntity<List<BrandDetails>> fetchBrandsByCriteria(@RequestBody BrandRequestDTO brandsreqDTO) throws Exception  {

		
		List<BrandDetails> selectedCustomers = brandService.findBrandsByCriteria(brandsreqDTO);

		return ResponseEntity.ok(selectedCustomers);
	}
}
