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

import com.bourntec.apmg.entity.CompanyData;
import com.bourntec.apmg.usermanagement.v1.dto.request.CompanyRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CompanyResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.CompanyDataService;

/**
 * @author Amal Chandra N A
 *
 */
@RestController(value = "CompanyDataController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v1/companydata")
public class CompanyDataController {

	@Autowired
	CompanyDataService cmpnyService;

	/**
	 * This REST endpoint exposes the search interface for saving company data
	 * 
	 * @param CompanyRequestDTO
	 * @return ResponseEntity<CompanyResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<CompanyResponseDTO> saveCompanyData(@RequestBody CompanyRequestDTO cmpnyreqDTO)
			throws Exception {

		CompanyResponseDTO savedrespcompany = cmpnyService.saveCompanyData(cmpnyreqDTO);

		return ResponseEntity.ok(savedrespcompany);

	}

	/**
	 * This REST endpoint exposes the search interface for returning Company Data by
	 * id
	 * 
	 * @param String id
	 * @return ResponseEntity<CompanyResponseDTO>
	 */

	@GetMapping("/{id}")
	public ResponseEntity<CompanyResponseDTO> fetchCompanydataById(@PathVariable String id) throws Exception {

		CompanyResponseDTO selectedcompanydata = cmpnyService.getCompanyById(id);

		return ResponseEntity.ok(selectedcompanydata);
	}

	/**
	 * This REST endpoint exposes the search interface for updating company by Id
	 * 
	 * @param CompanyRequestDTO,String id
	 * @return ResponseEntity<CompanyResponseDTO>
	 */
	@PutMapping("/{id}")
	public ResponseEntity<CompanyResponseDTO> updateCompanydataById(@RequestBody CompanyRequestDTO cmpnyreqDTO,
			@PathVariable String id) throws Exception {

		CompanyResponseDTO updatedCompanyData = cmpnyService.updateCompanyData(id, cmpnyreqDTO);
		return ResponseEntity.ok(updatedCompanyData);
	}

	/**
	 * This REST endpoint exposes the search interface for getting all company data
	 * 
	 * @param
	 * @return ResponseEntity<CompanyData>
	 */

	@GetMapping("")
	public ResponseEntity<List<CompanyData>> fetchAllsCompanies() throws Exception {

		List<CompanyData> allcmpnycodes = cmpnyService.findAllCompanies();
		return ResponseEntity.ok(allcmpnycodes);
	}
	
	/**
	 * This REST endpoint exposes the search interface for searching  company codes dynamically
	 * @param CompanyRequestDTO
	 * @return List<CompanyData>
	 */
	
	@PostMapping("/search")
	public ResponseEntity<List<CompanyData>> fetchByCompanyCriteria(@RequestBody CompanyRequestDTO cmpnyReqDTO) throws Exception  {

		
		List<CompanyData> selectedCompany= cmpnyService.findCompanyDataByCriteria(cmpnyReqDTO);

		return ResponseEntity.ok(selectedCompany);
	}

}
