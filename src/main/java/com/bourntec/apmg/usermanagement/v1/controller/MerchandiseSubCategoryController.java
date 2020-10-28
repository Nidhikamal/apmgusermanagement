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

import com.bourntec.apmg.entity.MerchandiseSubCategory;
import com.bourntec.apmg.usermanagement.v1.dto.request.MerchandiseSubCategoryRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.MerchandiseSubCategoryResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.MerchandiseSubCatService;


@RestController(value = "MerchandiseSubCategoryController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/merchandisesubcategory")
public class MerchandiseSubCategoryController {

	@Autowired
	MerchandiseSubCatService merchandiseSubCatService;

	/**
	 * Controller
	 * @author Amal
	 * @param categorycode
	 * @param categorycode
	 * @return merchandiseSubCategoryResponseDTO
	 * @throws Exception
	 */

	@GetMapping("/{subcategorycode}")
	public ResponseEntity<MerchandiseSubCategoryResponseDTO> fetchmerchandiseSubCategoryById(
			@PathVariable String subcategorycode) throws Exception {
		MerchandiseSubCategoryResponseDTO merchandiseSubCategoryResponseDTO = merchandiseSubCatService
				.findMerchandiseSubCategoryByID(subcategorycode);
		return ResponseEntity.ok(merchandiseSubCategoryResponseDTO);
	}

	/**
	 * Controller
	 * @author Amal
	 * @return merchandiseSubCategoryResponseDTO
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<MerchandiseSubCategory>> fetchAllmerchandiseSubCategory() throws Exception {
		List<MerchandiseSubCategory> merchResponseList = merchandiseSubCatService.retrieveAllMerchandiseSubCategory();
		return ResponseEntity.ok(merchResponseList);
	}

	/**
	 * This API save new merchandise category
	 * 
	 * @param merchandiseSubCategoryRequestDTO
	 * @return ResponseEntity<merchandiseSubCategoryResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<MerchandiseSubCategoryResponseDTO> saveMarchandiseCategory(
			@RequestBody MerchandiseSubCategoryRequestDTO merchandiseSubCategoryRequestDTO) throws Exception {
		MerchandiseSubCategoryResponseDTO merchandiseSubCategoryResponseDTO = merchandiseSubCatService
				.addMerchandiseSubCategory(merchandiseSubCategoryRequestDTO);
		return ResponseEntity.ok(merchandiseSubCategoryResponseDTO);
	}

	/**
	 * This API updates an merchandiseSubCategory object.
	 * 
	 * @param categoryCode
	 * @param merchandiseSubCategoryRequestDTO
	 * @return ResponseEntity<merchandiseSubCategoryResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/{subcategoryCode}")
	public ResponseEntity<MerchandiseSubCategoryResponseDTO> merchandiseSubCategory(@PathVariable String subcategoryCode,
			@RequestBody MerchandiseSubCategoryRequestDTO merchandiseSubCategoryRequestDTO) throws Exception {
		MerchandiseSubCategoryResponseDTO merchandiseSubCategoryResponseDTO = merchandiseSubCatService
				.updateMerchandiseSubCategory(subcategoryCode, merchandiseSubCategoryRequestDTO);
		return ResponseEntity.ok(merchandiseSubCategoryResponseDTO);
	}

	
	@PostMapping("/search")
	public ResponseEntity<List<MerchandiseSubCategory>> fetchMerchandiseSubCategoryByCriteria(@RequestBody  MerchandiseSubCategoryRequestDTO merchReqDTO) throws Exception  {

		
		List<MerchandiseSubCategory> selectedMerchandise = merchandiseSubCatService.findMerchandiseSubCategoryByCriteria(merchReqDTO);

		return ResponseEntity.ok(selectedMerchandise);
	}
}
