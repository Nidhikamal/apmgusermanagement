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
import com.bourntec.apmg.entity.Incidents;
import com.bourntec.apmg.entity.MerchandiseCategory;
import com.bourntec.apmg.usermanagement.v1.dto.request.BrandRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.FaqDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.IncidentsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.MerchandiseCategoryRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BrandResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.FaqResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.MerchandiseCategoryResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.BrandService;
import com.bourntec.apmg.usermanagement.v1.service.MerchandiseService;


@RestController(value = "MerchandiseController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/merchandisecategory")
public class MerchandiseController {

	@Autowired
	MerchandiseService merchandiseService;

	/**
	 * Controller
	 * 
	 * @param categorycode
	 * @param categorycode
	 * @return merchandiseCategoryResponseDTO
	 * @throws Exception
	 */

	@GetMapping("/{categorycode}")
	public ResponseEntity<MerchandiseCategoryResponseDTO> fetchMerchandiseCategoryById(
			@PathVariable String categorycode) throws Exception {
		MerchandiseCategoryResponseDTO merchandiseCategoryResponseDTO = merchandiseService
				.findMerchandiseCategoryByID(categorycode);
		return ResponseEntity.ok(merchandiseCategoryResponseDTO);
	}

	/**
	 * Controller
	 * 
	 * @return merchandiseCategoryResponseDTO
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<MerchandiseCategoryResponseDTO>> fetchAllMerchandiseCategory() throws Exception {
		List<MerchandiseCategoryResponseDTO> merchResponseList = merchandiseService.retrieveAllMerchandiseCategory();
		return ResponseEntity.ok(merchResponseList);
	}

	/**
	 * This API save new merchandise category
	 * 
	 * @param merchandiseCategoryRequestDTO
	 * @return ResponseEntity<merchandiseCategoryResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<MerchandiseCategoryResponseDTO> saveMarchandiseCategory(
			@RequestBody MerchandiseCategoryRequestDTO merchandiseCategoryRequestDTO) throws Exception {
		MerchandiseCategoryResponseDTO merchandiseCategoryResponseDTO = merchandiseService
				.addMerchandiseCategory(merchandiseCategoryRequestDTO);
		return ResponseEntity.ok(merchandiseCategoryResponseDTO);
	}

	/**
	 * This API updates an merchandiseCategory object.
	 * 
	 * @param categoryCode
	 * @param merchandiseCategoryRequestDTO
	 * @return ResponseEntity<MerchandiseCategoryResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/{categoryCode}")
	public ResponseEntity<MerchandiseCategoryResponseDTO> merchandiseCategory(@PathVariable String categoryCode,
			@RequestBody MerchandiseCategoryRequestDTO merchandiseCategoryRequestDTO) throws Exception {
		MerchandiseCategoryResponseDTO merchandiseCategoryResponseDTO = merchandiseService
				.updateMerchandiseCategory(categoryCode, merchandiseCategoryRequestDTO);
		return ResponseEntity.ok(merchandiseCategoryResponseDTO);
	}

	
	@PostMapping("/search")
	public ResponseEntity<List<MerchandiseCategory>> fetchMerchandiseCategoryByCtriteria(@RequestBody  MerchandiseCategoryRequestDTO merchandiseCategoryRequestDTO) throws Exception  {

		
		List<MerchandiseCategory> selectedMerchandise = merchandiseService.findMeachandiseByCriteria(merchandiseCategoryRequestDTO);

		return ResponseEntity.ok(selectedMerchandise);
	}
}
