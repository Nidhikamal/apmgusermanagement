/**
 * 
 */
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

import com.bourntec.apmg.usermanagement.v1.dto.request.PassModuleOptionListRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PassModuleOptionListResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.PassModuleOptionService;



/**
 * @author Srijini
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/moduleoption")
public class PassModuleOptionListController {
	@Autowired
	PassModuleOptionService moduleOptionService;
	
	/**
	 * Get all option list
	 * 
	 * @return List<PassModuleOptionListResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("")
	public ResponseEntity<List<PassModuleOptionListResponseDTO>> getAll() throws Exception {
		List<PassModuleOptionListResponseDTO> PassModuleOptionLists = moduleOptionService.getAll();
		return ResponseEntity.ok(PassModuleOptionLists);
	}
	
	/**
	 * Get a submodule
	 * @param submodule
	 * @return List<PassModuleOptionListResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("/{optionname}")
	public ResponseEntity<List<PassModuleOptionListResponseDTO>> getById(@PathVariable String optionname) throws Exception {
		List<PassModuleOptionListResponseDTO> PassModuleOptionListObj = moduleOptionService.getById(optionname);
		return ResponseEntity.ok(PassModuleOptionListObj);
	}
	
	/**
	 * End point for saving submodule	 * 
	 * @param PassModuleOptionListResponseDTO
	 * @return ResponseEntity<PassModuleOptionListResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<PassModuleOptionListResponseDTO> saveOptions(
			@RequestBody List<PassModuleOptionListRequestDTO> listRequestDTOs) throws Exception {
		PassModuleOptionListResponseDTO response = moduleOptionService.saveOptions(listRequestDTOs);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * End point for update Option	 * 
	 * @param PassModuleOptionListResponseDTO
	 * @return ResponseEntity<PassModuleOptionListResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("")
	public ResponseEntity<PassModuleOptionListResponseDTO> updateOption(
			@RequestBody List<PassModuleOptionListRequestDTO> accessListRequestDTO) throws Exception {
		PassModuleOptionListResponseDTO response = moduleOptionService.updateOption(accessListRequestDTO);
		return ResponseEntity.ok(response);
	}
	/**
	 * End point for delete Option	 * 
	 * @param userId
	 * @return ResponseEntity<PassModuleOptionListResponseDTO>
	 * @throws Exception
	 */
	@DeleteMapping("/{option}")
	public ResponseEntity<PassModuleOptionListResponseDTO> deleteOption(
			@PathVariable String option) throws Exception {
		PassModuleOptionListResponseDTO response = moduleOptionService.deleteOption(option);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * AP 227 - Method for Search
	 * 
	 * @param PassModuleOptionListRequestDTO
	 * @return ResponseEntity<List<PassModuleOptionListResponseDTO>>
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<PassModuleOptionListResponseDTO>> getUserSearchList(@RequestBody PassModuleOptionListRequestDTO accessListRequestDTO,
			int page,int size)
			throws Exception {
		List<PassModuleOptionListResponseDTO> userResponseDTOList = moduleOptionService.search(accessListRequestDTO,page,size);
		return ResponseEntity.ok(userResponseDTOList);
	}
}
