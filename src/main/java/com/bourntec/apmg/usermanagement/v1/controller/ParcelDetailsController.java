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
import com.bourntec.apmg.entity.MerchandiseCategory;
import com.bourntec.apmg.entity.ParcelDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.BrandRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.FaqDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.MerchandiseCategoryRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.ParcelDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BrandResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.FaqResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ParcelDetailResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.BrandService;
import com.bourntec.apmg.usermanagement.v1.service.ParcelDetailsService;


@RestController(value = "ParcelDetailsController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/parcel")
public class ParcelDetailsController {

	@Autowired
	ParcelDetailsService parcelService;

	/**
	 * This API creates parcel
	 * 
	 * @param parcelDetailsRequestDTO
	 * @return ResponseEntity<ParcelDetailResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<ParcelDetailResponseDTO> saveParcelDetails(
			@RequestBody ParcelDetailsRequestDTO parcelDetailsRequestDTO) throws Exception {

		ParcelDetailResponseDTO parcelDetailResponseDTO = parcelService.saveParcelDetails(parcelDetailsRequestDTO);
		return ResponseEntity.ok(parcelDetailResponseDTO);
	}

	/**
	 * This API updates parcel
	 * 
	 * @param parcelId
	 * @return ResponseEntity<ParcelDetailResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("/{parcelId}")
	public ResponseEntity<ParcelDetailResponseDTO> updateParcelDetails(@PathVariable String parcelId,
			@RequestBody ParcelDetailsRequestDTO parcelDetailsRequestDTO) throws Exception {
		ParcelDetailResponseDTO parcelDetailResponseDTO = parcelService.updateParcelDetails(parcelId,
				parcelDetailsRequestDTO);
		return ResponseEntity.ok(parcelDetailResponseDTO);
	}

	/**
	 * This API get parcel
	 * 
	 * @param parcelId
	 * @return ResponseEntity<ParcelDetailResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/{parcelId}")
	public ResponseEntity<ParcelDetailResponseDTO> findParcelDetailsById(@PathVariable String parcelId)
			throws Exception {
		ParcelDetailResponseDTO parcelDetailResponseDTO = parcelService.findParcelDetailsById(parcelId);
		return ResponseEntity.ok(parcelDetailResponseDTO);
	}

	/**
	 * This API get all parcel objects
	 * 
	 * @return ResponseEntity<ParcelDetailResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<ParcelDetailResponseDTO>> findAllParcelDetails() throws Exception {
		List<ParcelDetailResponseDTO> brokersResponseDTOList = parcelService.findAllParcelDetails();
		return ResponseEntity.ok(brokersResponseDTOList);
	}

	@PostMapping("/search")
	public ResponseEntity<List<ParcelDetails>> fetchByParcelDetailsCriteria(@RequestBody  ParcelDetailsRequestDTO parcelDetailsRequestDTO) throws Exception  {

		
		List<ParcelDetails> selectedParcel = parcelService.findParcelByCriteria(parcelDetailsRequestDTO);

		return ResponseEntity.ok(selectedParcel);
	}
}
