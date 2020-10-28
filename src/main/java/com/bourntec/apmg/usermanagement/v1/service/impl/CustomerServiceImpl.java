package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.CustData;
import com.bourntec.apmg.entity.CustData2;
import com.bourntec.apmg.entity.CustDataEmployee;
import com.bourntec.apmg.entity.CustDataNotes;
import com.bourntec.apmg.entity.CustDataShippingDetails;
import com.bourntec.apmg.entity.CustNotification;
import com.bourntec.apmg.entity.CustomerBrandDetails;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataNotesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.CustDataRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CustDataResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.CustData2Repository;
import com.bourntec.apmg.usermanagement.v1.repository.CustDataBrandDetailsRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CustDataEmployeeRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CustDataRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CustDataShippingDetailsRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CustaDataNotesRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CustdataNotificationRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.CustomerService;
@Deprecated
@Service
/**
 * 
 * Service class implementation for vendor entity
 * 
 * @author vidya.p
 *
 */
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustDataResponseDTO saveCustomer(CustDataRequestDTO custDataRequestDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustDataResponseDTO findCustomerById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustDataResponseDTO findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustData> findAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustDataResponseDTO updateCustomerData(String custNo, CustDataRequestDTO customerReqDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustData> findCustomersByCriteria(CustDataRequestDTO customerReqDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * 
	 * @Autowired CustDataRepository custDataRepository;
	 * 
	 * @Autowired CustData2Repository custData2Repository;
	 * 
	 * @Autowired CustDataShippingDetailsRepository custDataShippindRepository;
	 * 
	 * @Autowired CustDataEmployeeRepository custDataEmployeesRepository;
	 * 
	 * @Autowired CustDataBrandDetailsRepository custDataBrandDetailsRepository ;
	 * 
	 * @Autowired CustaDataNotesRepository custDataNotesRepository;
	 * 
	 * @Autowired CustdataNotificationRepository custDataNotificationRepository;
	 * private static final Logger logger =
	 * LogManager.getLogger(VendorServiceImpl.class);
	 * 
	 * 
	 * CustData2 SettingCustData2Value(CustDataShippingDetails dataShippingDetails)
	 * { CustData2 custData2; custData2 = new CustData2(); try {
	 * 
	 * custData2.setLastSaleDate(dataShippingDetails.getLastSaleDate());
	 * custData2.setNextCallDate(dataShippingDetails.getNextCallDate());
	 * custData2.setPriorityCode(dataShippingDetails.getPriorityCode());
	 * custData2.setShipAddress(dataShippingDetails.getShipAddress());
	 * custData2.setShipAddress2(dataShippingDetails.getShipAddress2());
	 * custData2.setShipCity(dataShippingDetails.getShipCity());
	 * custData2.setShipCountry(dataShippingDetails.getShipCountry());
	 * custData2.setShipName(dataShippingDetails.getShipName());
	 * custData2.setShipPhone(dataShippingDetails.getShipPhone());
	 * custData2.setShipPhones(dataShippingDetails.getShipPhones());
	 * custData2.setShipState(dataShippingDetails.getShipState());
	 * custData2.setShipZip(dataShippingDetails.getShipZip());
	 * custData2.setShipZips(dataShippingDetails.getShipZips()); } catch (Exception
	 * e) { // TODO Auto-generated catch block
	 * logger.error("SettingCustData2Value"); throw e; } return custData2; }
	 *//**
		 * This method creates new custData
		 * 
		 * @param custDataRequestDTO
		 * @return responseData
		 * @throws Exception
		 */
	/*
	 * 
	 * public CustDataResponseDTO saveCustomer(CustDataRequestDTO
	 * custDataRequestDTO)throws Exception { CustData custData = null; try {
	 * logger.info("Going to save Customer"); CustDataResponseDTO
	 * custDataResponseDTO = new CustDataResponseDTO();
	 * if(custDataRequestDTO!=null&&custDataRequestDTO.getCustNo()!=null){ custData
	 * = custDataRequestDTO.toModel(custDataRequestDTO); CustData
	 * custDatareturn=custDataRepository.save(custData); if(custDatareturn!=null){
	 * List<CustDataShippingDetails>
	 * custDataShippingDetailsList=custDataRequestDTO.getCustDataShippingDetailList(
	 * );
	 * if(custDataShippingDetailsList!=null&&custDataShippingDetailsList.size()>0){
	 * CustDataShippingDetails dataShippingDetails
	 * =custDataRequestDTO.getCustDataShippingDetailList().get(0);
	 * if(dataShippingDetails!=null){ CustData2
	 * custData2=SettingCustData2Value(dataShippingDetails);
	 * custData2.setCustNo(custDatareturn.getCustNo());
	 * logger.info("Saving CustData"); custData2Repository.save(custData2);
	 * custDataShippingDetailsList.remove(0); }
	 * 
	 * if(custDataShippingDetailsList!=null&&custDataShippingDetailsList.size()>0){
	 * logger.info("Saving customer Shipping details");
	 * custDataShippingDetailsList.forEach((custDataShippingDetailsobj) -> {
	 * custDataShippingDetailsobj.setCustNo(custDatareturn.getCustNo());
	 * custDataShippindRepository.save(custDataShippingDetailsobj); }); } }
	 * 
	 * 
	 * List<CustDataEmployee>CustDataEmployeeList=custDataRequestDTO.
	 * getCustDataEmployee();
	 * if(CustDataEmployeeList!=null&&CustDataEmployeeList.size()>0){
	 * logger.info("Saving customer employee details");
	 * CustDataEmployeeList.forEach((custDataEmployees) -> {
	 * custDataEmployees.setCustNo(custDatareturn.getCustNo());
	 * custDataEmployeesRepository.save(custDataEmployees); }); }
	 * 
	 * 
	 * List<CustomerBrandDetails>CustDataBrandDetails=custDataRequestDTO.
	 * getCustomerBrandDetails();
	 * if(CustDataBrandDetails!=null&&CustDataBrandDetails.size()>0){
	 * logger.info("Going Saving customer brand details");
	 * CustDataBrandDetails.forEach((brandDetails) -> {
	 * brandDetails.setCustNo(custDatareturn.getCustNo());
	 * custDataBrandDetailsRepository.save(brandDetails); }); }
	 * 
	 * 
	 * CustNotification
	 * CustDataNotification=custDataRequestDTO.getCustNotification();
	 * if(CustDataNotification!=null){
	 * logger.info("Going Saving customer notification details");
	 * CustDataNotification.setCustNo(custDatareturn.getCustNo());
	 * custDataNotificationRepository.save(CustDataNotification); }
	 * 
	 * CustDataNotesRequestDTO
	 * custDataNotesRequestDTO=custDataRequestDTO.getCustDataNotesRequestDTO();
	 * CustDataNotes custDataNotes=new CustDataNotes();
	 * if(custDataNotesRequestDTO!=null){ logger.info("Saving customer notes");
	 * byte[] notesArray=null; try {
	 * if(custDataNotesRequestDTO.getNotes()!=null&&!custDataNotesRequestDTO.
	 * getNotes().isEmpty()){ notesArray =
	 * custDataNotesRequestDTO.getNotes().getBytes("UTF-8");
	 * custDataNotes.setCustNotes(notesArray); } } catch
	 * (UnsupportedEncodingException e) { logger.error("Saving customer notes");
	 * 
	 * }
	 * 
	 * custDataNotes.setCustNo(custDatareturn.getCustNo());
	 * custDataNotes.setLocationCode(custDataNotesRequestDTO.getLocationCode());
	 * custDataNotesRepository.save(custDataNotes); }
	 * 
	 * BeanUtils.copyProperties(custDatareturn,custDataResponseDTO); } else{
	 * logger.error("Error in save custData ");
	 * custDataResponseDTO.setResponseMessage("Error in save custData"); }
	 * 
	 * } else{ logger.info("customerObject is not persisted in DB");
	 * custDataResponseDTO.setResponseMessage("Customer id not present");
	 * 
	 * } return custDataResponseDTO; } catch (Exception e) {
	 * logger.error("saving customer"+e); throw e;
	 * 
	 * }
	 * 
	 * 
	 * }
	 *//**
		 * This method findCustomerById
		 * 
		 * @param id
		 * @return response
		 * @throws Exception
		 */
	/*
	 * 
	 * 
	 * public CustDataResponseDTO findCustomerById(String id) throws Exception{
	 * 
	 * CustDataResponseDTO custDataResponseDTO = new CustDataResponseDTO();
	 * 
	 * try { logger.info("Going to findCustomerById"+id); Optional<CustData>
	 * custData= custDataRepository.findById(id); if(custData!=null){
	 * BeanUtils.copyProperties(custData.get(),custDataResponseDTO); } else{ throw
	 * new ResourceNotFoundException(ErrorCodes.CUSTOMER_NOT_FOUND.getMessage()); }
	 * 
	 * } catch(Exception e) { logger.error("findCustomerById"+e); throw e; } return
	 * custDataResponseDTO;
	 * 
	 * } public CustDataResponseDTO findById(String id) throws Exception {
	 * 
	 * CustDataResponseDTO custDataResponseDTO = new CustDataResponseDTO();
	 * 
	 * try { logger.info("Going to find customer"+id); Optional<CustDataNotes> notes
	 * = custDataNotesRepository.findById(id);
	 * logger.info("Going to find customer"+id); } catch(Exception e) {
	 * logger.error(" customer findById"+e); throw e; } return custDataResponseDTO;
	 * 
	 * }
	 * 
	 *//**
		 * @author amal This is the main method which is used to search customers
		 *         dynamically
		 * 
		 * @param CustDataRequestDTO
		 * @return List<CustData>
		 */
	/*
	 * 
	 * public List<CustData> findCustomersByCriteria(CustDataRequestDTO
	 * customerReqDTO) { logger.info("Searching Customers...");
	 * GenericSpesification<CustData> genericSpesification = new
	 * GenericSpesification<CustData>(); if(customerReqDTO.getCustNo()!=null) {
	 * genericSpesification.add(new SearchCriteria("custNo",
	 * customerReqDTO.getCustNo(), SearchOperation.MATCH)); }
	 * if(customerReqDTO.getCustName()!=null) { genericSpesification.add(new
	 * SearchCriteria("custName", customerReqDTO.getCustName(),
	 * SearchOperation.MATCH)); } if(customerReqDTO.getCompanyCode()!=null) {
	 * genericSpesification.add(new SearchCriteria("companyCode",
	 * customerReqDTO.getCompanyCode(), SearchOperation.MATCH)); }
	 * if(customerReqDTO.getEmailAddress1()!=null) { genericSpesification.add(new
	 * SearchCriteria("emailAddress1", customerReqDTO.getEmailAddress1(),
	 * SearchOperation.MATCH)); } if(customerReqDTO.getActive()!=null) {
	 * genericSpesification.add(new SearchCriteria("active",
	 * customerReqDTO.getActive(), SearchOperation.EQUAL)); }
	 * if(customerReqDTO.getStatus()!=null) { genericSpesification.add(new
	 * SearchCriteria("status", customerReqDTO.getActive(), SearchOperation.EQUAL));
	 * } if(customerReqDTO.getLocationCode()!=null) { genericSpesification.add(new
	 * SearchCriteria("locationCode", customerReqDTO.getLocationCode(),
	 * SearchOperation.EQUAL)); } if(customerReqDTO.getCountry()!=null) {
	 * genericSpesification.add(new SearchCriteria("country",
	 * customerReqDTO.getCountry(), SearchOperation.EQUAL)); }
	 * if(customerReqDTO.getState()!=null) { genericSpesification.add(new
	 * SearchCriteria("state", customerReqDTO.getState(), SearchOperation.EQUAL)); }
	 * if(customerReqDTO.getPhone1()!=null) { genericSpesification.add(new
	 * SearchCriteria("phone1", customerReqDTO.getPhone1(), SearchOperation.EQUAL));
	 * } if(customerReqDTO.getJoinDate()!=null) { genericSpesification.add(new
	 * SearchCriteria("joinDate", customerReqDTO.getJoinDate(),
	 * SearchOperation.GREATER_THAN_EQUAL)); }
	 * if(customerReqDTO.getCloseDate()!=null) { genericSpesification.add(new
	 * SearchCriteria("closeDate", customerReqDTO.getCloseDate(),
	 * SearchOperation.LESS_THAN_EQUAL)); }
	 * 
	 * 
	 * 
	 * return custDataRepository.findAll(genericSpesification); }
	 * 
	 *//**
		 * @author amal This is the main method which is used to update customers
		 * 
		 * @param CustDataRequestDTO
		 * @return List<CustData>
		 */
	/*
	 * 
	 * public CustDataResponseDTO updateCustomerData(String custNo,
	 * CustDataRequestDTO custDataRequestDTO) { try {
	 * logger.info("Going to update Customer"); CustDataResponseDTO
	 * custDataResponseDTO = new CustDataResponseDTO(); Optional<CustData>
	 * custDatalst = custDataRepository.findById(custNo); if
	 * (custDatalst.isPresent()) { CustData custData =
	 * custDataRequestDTO.toModel(custDataRequestDTO); CustData custDatareturn =
	 * custDataRepository.save(custData); List<CustDataShippingDetails>
	 * custDataShippingDetailsList = custDataRequestDTO
	 * .getCustDataShippingDetailList(); if (custDataShippingDetailsList != null &&
	 * custDataShippingDetailsList.size() > 0) { CustDataShippingDetails
	 * dataShippingDetails = custDataRequestDTO.getCustDataShippingDetailList()
	 * .get(0); if (dataShippingDetails != null) { CustData2 custData2 =
	 * SettingCustData2Value(dataShippingDetails);
	 * custData2.setCustNo(custDatareturn.getCustNo());
	 * logger.info("Updating Customer Data"); custData2Repository.save(custData2);
	 * custDataShippingDetailsList.remove(0); }
	 * 
	 * if (custDataShippingDetailsList != null && custDataShippingDetailsList.size()
	 * > 0) { logger.info("Updating customer Shipping details");
	 * custDataShippingDetailsList.forEach((custDataShippingDetailsobj) -> {
	 * custDataShippingDetailsobj.setCustNo(custDatareturn.getCustNo());
	 * custDataShippindRepository.save(custDataShippingDetailsobj); }); } }
	 * List<CustDataEmployee> CustDataEmployeeList =
	 * custDataRequestDTO.getCustDataEmployee(); if (CustDataEmployeeList != null &&
	 * CustDataEmployeeList.size() > 0) {
	 * logger.info("Updating customer employee details");
	 * CustDataEmployeeList.forEach((custDataEmployees) -> {
	 * custDataEmployees.setCustNo(custDatareturn.getCustNo());
	 * custDataEmployeesRepository.save(custDataEmployees); }); }
	 * List<CustomerBrandDetails> CustDataBrandDetails =
	 * custDataRequestDTO.getCustomerBrandDetails(); if (CustDataBrandDetails !=
	 * null && CustDataBrandDetails.size() > 0) {
	 * logger.info(" Updating customer brand details");
	 * CustDataBrandDetails.forEach((brandDetails) -> {
	 * brandDetails.setCustNo(custDatareturn.getCustNo());
	 * custDataBrandDetailsRepository.save(brandDetails); }); } CustNotification
	 * CustDataNotification = custDataRequestDTO.getCustNotification(); if
	 * (CustDataNotification != null) {
	 * logger.info("Updating customer notification details");
	 * CustDataNotification.setCustNo(custDatareturn.getCustNo());
	 * 
	 * custDataNotificationRepository.save(CustDataNotification); }
	 * CustDataNotesRequestDTO custDataNotesRequestDTO =
	 * custDataRequestDTO.getCustDataNotesRequestDTO(); CustDataNotes custDataNotes
	 * = new CustDataNotes(); if (custDataNotesRequestDTO != null) {
	 * logger.info("Updating customer notes"); byte[] notesArray = null; try { if
	 * (custDataNotesRequestDTO.getNotes() != null &&
	 * !custDataNotesRequestDTO.getNotes().isEmpty()) { notesArray =
	 * custDataNotesRequestDTO.getNotes().getBytes("UTF-8");
	 * custDataNotes.setCustNotes(notesArray); } } catch
	 * (UnsupportedEncodingException e) { e.printStackTrace(); }
	 * custDataNotes.setCustNo(custDatareturn.getCustNo());
	 * custDataNotes.setLocationCode(custDataNotesRequestDTO.getLocationCode());
	 * custDataNotesRepository.save(custDataNotes); }
	 * BeanUtils.copyProperties(custDatareturn, custDataResponseDTO);
	 * logger.info("Updated Successfully"); } else {
	 * logger.error("Customer does not exists"); } return custDataResponseDTO; }
	 * catch (Exception e) { logger.error("Updating customer" + e); throw e;
	 * 
	 * } }
	 *//**
		 * @author amal This is the main method which is used to get all customers
		 * 
		 * 
		 */
	/*
	 * public List<CustData> findAllCustomers() {
	 * logger.info("Fetching all customers"); return custDataRepository.findAll(); }
	 * 
	 * 
	 * 
	 * 
	 */}
