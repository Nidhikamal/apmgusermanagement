package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CustDataEmployee;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataEmployeeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustDataEmployeeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.CustDataEmployeeRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.CustomerDataEmployeeService;
/**
 * Customer Data Service implementation class
 * 
 * @author jinto varghese
 *
 */
@Service(value = "CustomerDataEmployeeServiceImpl")
public class CustomerDataEmployeeServiceImpl implements CustomerDataEmployeeService {

	private static final Logger logger = LogManager.getLogger(CustomerDataEmployeeServiceImpl.class);

	@Autowired
	CustDataEmployeeRepository custDataEmpRepository;

	/**
	 * Method used for creating a custome data employee
	 */
	@Override
	public CustDataEmployeeResponseDTO saveCustDataEmployee(CustDataEmployeeRequestDTO custDataEmpRequestDTO) {
		logger.info("Entering saveCustDataEmployee", custDataEmpRequestDTO);
		
		CustDataEmployeeResponseDTO custDataEmployeeResponsetDTO = new CustDataEmployeeResponseDTO();
		
		try {
			custDataEmpRequestDTO.setEmpId(generateIdForObjectToSave("contact_emp"));
			CustDataEmployee custDataEmployee = custDataEmpRequestDTO.toModel(custDataEmpRequestDTO);
			CustDataEmployee custDataEmp = custDataEmpRepository.save(custDataEmployee);
			if (custDataEmp != null) {
				logger.info("Customer Data Employee Details is saved");
				BeanUtils.copyProperties(custDataEmp, custDataEmployeeResponsetDTO);
				custDataEmployeeResponsetDTO.setResponseMessage("Customer Data Employee is saved Successfully");
			} else {
				logger.info("Customer Data Employee is not saved in DB");
				custDataEmployeeResponsetDTO.setResponseMessage("Customer Data Employee is not saved");
			}
		}

		catch (Exception e) {
			logger.error("CustomerDataEmployeeServiceImpl saveCustDataEmployee failed" + e);

			throw e;
		}
		return custDataEmployeeResponsetDTO;
	}

	private String generateIdForObjectToSave(String string) {
        Random rand = new Random(); 

					
			
			return "E"+rand.nextInt();
	}

	/**
	 * Updating a customer data employee
	 */
	@Override
	public CustDataEmployeeResponseDTO updateCustDataEmployee(String custDataEmpNo,
			CustDataEmployeeRequestDTO custDataEmpRequestDTO) {

		logger.info("Entering updateCustDataEmployee", custDataEmpRequestDTO);
		Optional<CustDataEmployee> custDataEmpList = custDataEmpRepository.findById(custDataEmpNo);

		CustDataEmployee custDataEmployee = custDataEmpList.get();

		CustDataEmployeeResponseDTO custDataEmpResponsedto = new CustDataEmployeeResponseDTO();

		try {

			if (custDataEmployee == null) {
				logger.info("The Customer Data Employee doesn't exists!!!");
				custDataEmpResponsedto.setResponseMessage("The Customer Data Employee doesn't exists");
				return custDataEmpResponsedto;
			} 
			else {

				CustDataEmployee custDataEmp = custDataEmpRequestDTO.toModel(custDataEmpRequestDTO);

				custDataEmp.setEmpId(custDataEmpNo);
				CustDataEmployee customerData = custDataEmpRepository.save(custDataEmp);
				logger.info("Customer Data Employee Details is updated");

				BeanUtils.copyProperties(customerData, custDataEmpResponsedto);
				custDataEmpResponsedto.setResponseMessage("Customer Data Employee is updated Successfully");

				logger.info("Exiting updateCustDataEmployee");
			}
		} catch (Exception e) {
			logger.error(" CustomerDataEmployeeServiceImpl updateCustDataEmployee  failed" + e);

			throw e;
		}
		return custDataEmpResponsedto;

	}

	/**
	 * Search a customer data employee based on {emp no}
	 */
	
	@Override
	public CustDataEmployeeResponseDTO findByCustDataEmpNo(String custDataEmpNo) {
		logger.info("Entering findByCustDataEmpNo  {}", custDataEmpNo);

		CustDataEmployeeResponseDTO custDataEmpResponsedto = new CustDataEmployeeResponseDTO();
		try {

			Optional<CustDataEmployee> custEmployeeList = custDataEmpRepository.findById(custDataEmpNo);
			CustDataEmployee custDataEmployee = custEmployeeList.get();

			if (custDataEmployee != null) {
				BeanUtils.copyProperties(custDataEmployee, custDataEmpResponsedto);
			} else {
				throw new ResourceNotFoundException("Requested Customer Data Employee is not exist");
			}
			logger.info("Exiting findByCustDataEmpNo  {}", custDataEmpNo);
		} 
		catch (Exception e) {
			logger.error("CustomerDataEmployeeServiceImpl findByCustDataEmpNo failed" + e);

			throw e;
		}
		return custDataEmpResponsedto;
	}

	/**
	 * Fetch all the Employees from DB
	 */
	@Override
	public List<CustDataEmployee> findAllCustomerDataEmployees() {
		logger.info("Fetching all Customer Data Employees  ...");
		return custDataEmpRepository.findAll();
	}

	/**
	 * Fetch employee details based on object details
	 * 
	 */
	@Override
	public List<CustDataEmployee> fetchByCustDataEmployee(CustDataEmployeeRequestDTO custDataEmpRequestDTO) {
		GenericSpesification<CustDataEmployee> genericSpesification = new GenericSpesification<CustDataEmployee>();
		if (custDataEmpRequestDTO.getCustNo() != null && !custDataEmpRequestDTO.getCustNo().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("custNo", custDataEmpRequestDTO.getCustNo(), SearchOperation.MATCH));
		}
		if (custDataEmpRequestDTO.getCustStatus() != null && !custDataEmpRequestDTO.getCustStatus().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("custStatus", custDataEmpRequestDTO.getCustStatus(), SearchOperation.MATCH));
		}
		if (custDataEmpRequestDTO.getEmpCell() != null && !custDataEmpRequestDTO.getEmpCell().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("empCell", custDataEmpRequestDTO.getEmpCell(), SearchOperation.MATCH));
		}
		if (custDataEmpRequestDTO.getEmpId() != null && !custDataEmpRequestDTO.getEmpId().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("empId", custDataEmpRequestDTO.getEmpId(), SearchOperation.MATCH));
		}
		if (custDataEmpRequestDTO.getEmpMail() != null && !custDataEmpRequestDTO.getEmpMail().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("empMail", custDataEmpRequestDTO.getEmpMail(), SearchOperation.MATCH));
		}
		if (custDataEmpRequestDTO.getEmpName() != null && !custDataEmpRequestDTO.getEmpName().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("empName", custDataEmpRequestDTO.getEmpName(), SearchOperation.MATCH));
		}
		if (custDataEmpRequestDTO.getEmpType() != null && !custDataEmpRequestDTO.getEmpType().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("empType", custDataEmpRequestDTO.getEmpType(), SearchOperation.MATCH));
		}
		if (custDataEmpRequestDTO.getStatus() != null && !custDataEmpRequestDTO.getStatus().isEmpty()) {
			genericSpesification
					.add(new SearchCriteria("status", custDataEmpRequestDTO.getStatus(), SearchOperation.MATCH));
		}
		return custDataEmpRepository.findAll(genericSpesification);
	}

	/**
	 * Deleting a customer data employee from DB
	 * 
	 */
	@Override
	public void deleteCustDataEmployee(String custDataEmpNo) {
		logger.info("Entering deleteCustDataEmployee  {}", custDataEmpNo);

		Optional<CustDataEmployee> custEmployeeList = custDataEmpRepository.findById(custDataEmpNo);
		CustDataEmployee customerDataEmp = custEmployeeList.get();
		try {
			if (customerDataEmp == null) {
				logger.info("The user doesn't exists!!!");
			} else {
				custDataEmpRepository.delete(customerDataEmp);
			}
			logger.info("Exiting deleteCustDataEmployee");
		} catch (Exception e) {
			throw e;
		}

	}

}
