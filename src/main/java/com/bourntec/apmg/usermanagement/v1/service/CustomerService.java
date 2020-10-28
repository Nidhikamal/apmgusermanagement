package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CustData;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustDataResponseDTO;

/**
 * 
 * Service class interface for Customer  entity
 * 
 * @author vidya.p
 *
 */

public interface CustomerService {

	
		/**
		 * This method creates new VendorData
		 * @param vendorDataRequestDTO
		 * @return responseData
		 * @throws Exception 
		 */
		
	CustDataResponseDTO saveCustomer(CustDataRequestDTO custDataRequestDTO) throws Exception ;
		/**
		 * This method findCustomerById
		 * @param id
		 * @return response
		 * @throws Exception 
		 */
		
	CustDataResponseDTO findCustomerById(String id) throws Exception;
		
    CustDataResponseDTO findById(String id) throws Exception;
    List<CustData> findAllCustomers();
	CustDataResponseDTO updateCustomerData(String custNo, CustDataRequestDTO customerReqDTO);
	List<CustData> findCustomersByCriteria(CustDataRequestDTO customerReqDTO);

}
