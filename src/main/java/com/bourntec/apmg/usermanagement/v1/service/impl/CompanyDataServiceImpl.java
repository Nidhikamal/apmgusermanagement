package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CompanyData;
import com.bourntec.apmg.usermanagement.v1.dto.request.CompanyRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CompanyResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.CompanyDataRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.CompanyDataService;

/**
 * 
 * Service class implementation for employee Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Service(value = "CompanyDataServiceImpl")
public class CompanyDataServiceImpl implements CompanyDataService {

	private static final Logger logger = LogManager.getLogger(CompanyDataServiceImpl.class);

	@Autowired
	private CompanyDataRepository companyRepository;

	
	/**
	 * @author amal This is the main method which is used to get Company by Id
	 */

	public CompanyResponseDTO getCompanyById(String id) {
		CompanyResponseDTO companyResponceDTO = new CompanyResponseDTO();
		try {
			logger.info("Fetching  Company Data..");
			Optional<CompanyData> optionalcompy = companyRepository.findById(id);
			if (optionalcompy.isPresent()) {
				CompanyData cmpny = optionalcompy.get();
				BeanUtils.copyProperties(cmpny, companyResponceDTO);
				companyResponceDTO.setResponseMessage("Success");
			} else {
				logger.error("Company doesn't exist");
				companyResponceDTO.setResponseMessage("Company doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch: getCompanyById " + e);
			throw e;
		}
		return companyResponceDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all Companies
	 */

	public List<CompanyData> findAllCompanies() {
		logger.info("Fetching all Company Data..");
		return companyRepository.findAll();
	}

	/**
	 * @author amal This is the main method which is used to save Company data
	 * 
	 */

	public CompanyResponseDTO saveCompanyData(CompanyRequestDTO comapnyReq) {
		CompanyResponseDTO cmpnyResponseDTO = new CompanyResponseDTO();
		try {
			CompanyData cmony = comapnyReq.toModel(comapnyReq);
			CompanyData cmpnyEntity = companyRepository.save(cmony);
			if (cmpnyEntity != null) {
				BeanUtils.copyProperties(cmpnyEntity, cmpnyResponseDTO);
				cmpnyResponseDTO.setResponseMessage("Saved  Company Data successfully");
				logger.info("Saved  Company Data successfully");
			} else {
				cmpnyResponseDTO.setResponseMessage("Failed to save  Company Data");
				logger.error("Failed to save  Company Data ");
			}
		} catch (Exception e) {
			logger.error("Save: saveCompanyData " + e);
			throw e;
		}
		return cmpnyResponseDTO;
	}

	/**
	 * @author amal This is the main method which is used to updata Company data by
	 *         id
	 */

	public CompanyResponseDTO updateCompanyData(String companyCode, CompanyRequestDTO cmpnyReqDTO) {
		CompanyResponseDTO updatedCompanyResDTO = new CompanyResponseDTO();
		try {
			Optional<CompanyData> packingOptional = companyRepository.findById(companyCode);
			if (packingOptional.isPresent()) {
				CompanyData newcmpnyCodes = cmpnyReqDTO.toModel(cmpnyReqDTO);
				newcmpnyCodes.setCompanyCode(companyCode);
				CompanyData cmpnyEntity = companyRepository.save(newcmpnyCodes);
				if (cmpnyEntity != null) {
					BeanUtils.copyProperties(cmpnyEntity, updatedCompanyResDTO);
					logger.info("Updated  Company Data successfully");
					updatedCompanyResDTO.setResponseMessage("Updated  Company Data successfully");
				} else {
					logger.info("Company Data updation failed");
					updatedCompanyResDTO.setResponseMessage("Company Data updation failed");
				}
			} else {
				logger.error("Company Data doesn't exist");
				updatedCompanyResDTO.setResponseMessage("Company Data doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update updateCompanyData " + e);
			throw e;
		}

		return updatedCompanyResDTO;
	}

	public List<CompanyData> findCompanyDataByCriteria(CompanyRequestDTO cmpnyReqDTO) {
			GenericSpesification<CompanyData> genericSpesification = new GenericSpesification<CompanyData>();

			if (cmpnyReqDTO.getCompanyName()!= null) {
				genericSpesification
						.add(new SearchCriteria("companyName", cmpnyReqDTO.getCompanyName(), SearchOperation.MATCH));
			}
			if (cmpnyReqDTO.getAddress1() != null) {
				genericSpesification
						.add(new SearchCriteria("address1", cmpnyReqDTO.getAddress1(), SearchOperation.MATCH));
			}
			if (cmpnyReqDTO.getAddress2() != null) {
				genericSpesification
						.add(new SearchCriteria("address2", cmpnyReqDTO.getAddress2(), SearchOperation.MATCH));
			}
			if (cmpnyReqDTO.getCompanyCode() != null) {
				genericSpesification
						.add(new SearchCriteria("companyCode", cmpnyReqDTO.getCompanyCode(), SearchOperation.MATCH));
			}
			if (cmpnyReqDTO.getCompanyFont()!= null) {
				genericSpesification
						.add(new SearchCriteria("companyFont", cmpnyReqDTO.getCompanyFont(), SearchOperation.MATCH));
			}
			if (cmpnyReqDTO.getCompanySize() != null) {
				genericSpesification
						.add(new SearchCriteria("companySize", cmpnyReqDTO.getCompanySize(), SearchOperation.MATCH));
			}
			if (cmpnyReqDTO.getDesc1() != null) {
				genericSpesification
				.add(new SearchCriteria("desc1", cmpnyReqDTO.getDesc1(), SearchOperation.MATCH));
			}
			if (cmpnyReqDTO.getEmailAddress() != null) {
				genericSpesification
				.add(new SearchCriteria("emailAddress", cmpnyReqDTO.getEmailAddress(), SearchOperation.MATCH));
			}
			if (cmpnyReqDTO.getFax() != null) {
				genericSpesification
				.add(new SearchCriteria("fax", cmpnyReqDTO.getFax(), SearchOperation.MATCH));
			}
			if (cmpnyReqDTO.getPhone() != null) {
				genericSpesification
				.add(new SearchCriteria("phone", cmpnyReqDTO.getPhone(), SearchOperation.MATCH));
			}
			if (cmpnyReqDTO.getWebAddress() != null) {
				genericSpesification
				.add(new SearchCriteria("webAddress", cmpnyReqDTO.getWebAddress(), SearchOperation.MATCH));
			}
			return companyRepository.findAll(genericSpesification);
		
	}
}
