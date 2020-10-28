package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.bourntec.apmg.entity.BankAccounts;
import com.bourntec.apmg.entity.Employee;
import com.bourntec.apmg.usermanagement.v1.dto.request.EmployeeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.EmployeeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.EmployeeRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.EmployeeService;

/**
 * 
 * Service class implementation for employee Entity
 * 
 * @author Naveen Radakrishnan
 *
 */
@Service(value = "EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * Method that saves employee object in DB
	 * 
	 * @throws Exception
	 * @return employeeResponseDTO
	 */

	@Override
	public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO)
			throws Exception {

		logger.info("Entering employee details {}", employeeRequestDTO);
		EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
		try {
			Employee employee = employeeRequestDTO.toModel(employeeRequestDTO);
			Employee emp = employeeRepository.save(employee);
			logger.info("Employee Details is saved");
			if (emp != null) {
				logger.info("EmployeeObject is saved");
				BeanUtils.copyProperties(emp, employeeResponseDTO);
			} else {
				logger.info("EmployeeObject is not persisted in DB");
				employeeResponseDTO.setResponseMessage("EmployeeObject is persisted in DB");
			}
		}

		catch (Exception e) {
			logger.error("  employee  save failed" + e);
			throw e;
		}
		return employeeResponseDTO;

	}

	/**
	 * Method that returns the employee Object from Db
	 * 
	 * @param id
	 * @return EmployeeResponseDTO
	 * @throws Exception
	 */

	@Override
	public EmployeeResponseDTO findEmployeeByID(String id) throws Exception {

		logger.info("Entering findEmployeeID  {}", id);

		EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
		try {

			Optional<Employee> empList = employeeRepository.findById(id);
			if (empList.isPresent()) {
				BeanUtils.copyProperties(empList.get(), employeeResponseDTO);
				employeeResponseDTO.setResponseMessage("Employee data exists ..");

			} else {
				employeeResponseDTO.setResponseMessage("Employee data not found ..");
			//	throw new ResourceNotFoundException("Employee data not exists ..");
			}

		} catch (Exception e) {
			logger.error(" findUserByID failed" + e);
			employeeResponseDTO.setResponseMessage("failed");

			throw e;
		}
		return employeeResponseDTO;

	}

	/**
	 * Method that updates employee object in DB
	 * 
	 * @throws Exception
	 * @return employeeResponseDTO
	 */
	@Override
	public EmployeeResponseDTO updateUEmployee(String id, EmployeeRequestDTO employeeRequestDTO) {

		Optional<Employee> empList = employeeRepository.findById(id);

		Employee emp = empList.get();

		EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();

		try {

			if (emp == null) {
				logger.info("The employee doesn't exists!!!");
				employeeResponseDTO.setResponseMessage("The employee doesn't exists");
				return employeeResponseDTO;
			} else {

				Employee employee = employeeRequestDTO.toModel(employeeRequestDTO);

				employee.setEmpId(id);
				Employee empSave = employeeRepository.save(employee);
				logger.info("employee Details is updated");

				BeanUtils.copyProperties(employee, employeeResponseDTO);
				employeeResponseDTO.setResponseMessage("employee is updated in DB");
			}
		} catch (Exception e) {

			logger.error(" update employee failed" + e);

			throw e;
		}
		return employeeResponseDTO;
	}

	/**
	 * Method that searche employeeDetails based on param EmployeeRequestDTO
	 * 
	 * @throws Exception
	 * @return employeeResponseDTO
	 */
	@Override
	public List<Employee> findByCondition(EmployeeRequestDTO employeeDTO) {

		logger.info("Entering findEmployeeID  {}", employeeDTO);
		EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();

		List<Employee> emp = new ArrayList<Employee>();
		GenericSpesification genericSpesification = new GenericSpesification<Employee>();
		if (employeeDTO.getEmpId() != null) {
			genericSpesification.add(new SearchCriteria("empId", employeeDTO.getEmpId(), SearchOperation.MATCH));
		}

		if (employeeDTO.getInitial() != null) {

			genericSpesification.add(new SearchCriteria("initial", employeeDTO.getInitial(), SearchOperation.MATCH));
		}

		if (employeeDTO.getName() != null) {
			genericSpesification.add(new SearchCriteria("name", employeeDTO.getName(), SearchOperation.MATCH));
		}

		if (employeeDTO.getLicenseNumber() != null) {
			genericSpesification
					.add(new SearchCriteria("licenseNumber", employeeDTO.getLicenseNumber(), SearchOperation.MATCH));
		}

		if (employeeDTO.getEmpType() != null) {
			genericSpesification.add(new SearchCriteria("empType", employeeDTO.getEmpType(), SearchOperation.MATCH));
		}

		if (employeeDTO.getStatus() != null) {
			genericSpesification.add(new SearchCriteria("status", employeeDTO.getStatus(), SearchOperation.EQUAL));
		}

		if (employeeDTO.getWorkType() != null) {
			genericSpesification.add(new SearchCriteria("workType", employeeDTO.getWorkType(), SearchOperation.EQUAL));
		}

		if (employeeDTO.getIntExt() != null) {
			genericSpesification.add(new SearchCriteria("intExt", employeeDTO.getIntExt(), SearchOperation.EQUAL));
		}

		if (employeeDTO.getCountry() != null) {
			genericSpesification.add(new SearchCriteria("country", employeeDTO.getCountry(), SearchOperation.EQUAL));
		}

		if (employeeDTO.getState() != null) {
			genericSpesification.add(new SearchCriteria("state", employeeDTO.getState(), SearchOperation.EQUAL));
		}

		if (employeeDTO.getLocationCode() != null) {
			genericSpesification
					.add(new SearchCriteria("locationCode", employeeDTO.getLocationCode(), SearchOperation.EQUAL));
		}

		emp = employeeRepository.findAll(genericSpesification);
		return emp;
	}
	public List<Employee> findAllEmployee() {
		logger.info("Fetching all findAllEmployee  ...");

		return employeeRepository.findAll();
	}
}
