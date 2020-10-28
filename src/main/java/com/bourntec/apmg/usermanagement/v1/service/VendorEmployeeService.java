package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.VendorEmployees;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorEmployeesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorEmployeesResponseDTO;
/**
 * 
 * Service class interface for Vendor Entity
 * 
 * @author vidya.p
 *
 */


public interface VendorEmployeeService {

	/**
	 * This method creates new VendorEmployee
	 * @param VendorEmployeeRequestDTO
	 * @return VendorShipping
	 * @throws Exception 
	 */
	VendorEmployeesResponseDTO saveVendorEmployees(VendorEmployeesRequestDTO vendorEmployeeRequestDTO)throws Exception;
	/**
	 * This method update update VendorEmployee
	 * @param vendor id,VendorEmployeeRequestDTO
	 * @return VendorShipping
	 * @throws Exception 
	 */
	
	VendorEmployeesResponseDTO  updateVendorEmployees(Long id, VendorEmployeesRequestDTO vendorEmployeeRequestDTO)throws Exception;
	/**
	 * This method find  VendorEmployee by id
	 * @param vendor id
	 * @return VendorShipping
	 * @throws Exception 
	 */
	
	VendorEmployeesResponseDTO findVendorEmployeesById(Long id)throws Exception;
	
	/**r
	 * This method get all VendorEmployee 
	 * @return VendorShipping list
	 * @throws Exception 
	 */
	List<VendorEmployeesResponseDTO> findAllVendorEmployees()throws Exception;
	
	List<VendorEmployees> findVendorEmployeesByCriteria(VendorEmployeesRequestDTO vendorEmployeesRequestDTO);
	
}
