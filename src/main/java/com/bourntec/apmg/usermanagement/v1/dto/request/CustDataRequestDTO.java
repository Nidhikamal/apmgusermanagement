package com.bourntec.apmg.usermanagement.v1.dto.request;


import java.util.Date;

import com.bourntec.apmg.entity.CustData;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Class is used as a data transfer object for Table CustData
 * 
 * @author vidya.p 
 *
 */

@Getter
@Setter
public class CustDataRequestDTO {            
private String custNo;
private String custName;
private String contact1;
private Long phone1;
private Long phone2;
private String address;
private String city;
private String state;
private Long zip;
private Long termsDays;
private Double creditLimit;
private Double goldPremium;
private String shipVia;
private Date joinDate;
private String salesPerson;
private String priority;
private String description;
private Double totalDue;
private Double totalPaid;
private Double totalCredit;
private Double markUp;
private String address2;
private String country;
private String status;
private String zips;
private String locationCode;
private String glAccountno;
private String emailAddress1;
private String emailAddress2;
private Date closeDate;
private String closingReason;
private String empId;
private String active;
private String loginPassword;
private String priceListId;
private String division;
private String group1;
private String group;
private String phone1s;
private String phone2s;
private Date anniversary;
private Date birthDate;
private String webCustomer;
private String tax;
private String companyCode;
private String companyUrl;
private Integer countryCode1;
private Integer countryCode2;
private String rank;
private String webAccess;
private String custStatus;
private String statementType;
private String accountsManager;
private String registerFrom;


public CustData toModel(CustDataRequestDTO custDataRequestDTO) {

	CustData custData = new CustData();

	try {
		custData.setAccountsManager(custDataRequestDTO.getAccountsManager());
		custData.setActive(custDataRequestDTO.getActive());
		custData.setAddress(custDataRequestDTO.getAddress());
		custData.setAddress2(custDataRequestDTO.getAddress2());
		custData.setAnniversary(custDataRequestDTO.getAnniversary());
		custData.setBirthDate(custDataRequestDTO.getBirthDate());
		custData.setCity(custDataRequestDTO.getCity());
		custData.setCloseDate(custDataRequestDTO.getCloseDate());
		custData.setClosingReason(custDataRequestDTO.getClosingReason());
		custData.setCompanyCode(custDataRequestDTO.getCompanyCode());
		custData.setCompanyUrl(custDataRequestDTO.getCompanyUrl());
		custData.setContact1(custDataRequestDTO.getContact1());
		custData.setCountry(custDataRequestDTO.getCountry());
		custData.setCountryCode1(custDataRequestDTO.getCountryCode1());
		
		custData.setCountryCode2(custDataRequestDTO.getCountryCode2());
		custData.setCreditLimit(custDataRequestDTO.getCreditLimit());
		custData.setCustName(custDataRequestDTO.getCustName());
		custData.setCustNo(custDataRequestDTO.getCustNo());
		custData.setCustStatus(custDataRequestDTO.getCustStatus());
		custData.setDescription(custDataRequestDTO.getDescription());
		custData.setDivision(custDataRequestDTO.getDivision());
		custData.setEmailAddress1(custDataRequestDTO.getEmailAddress1());
		custData.setEmailAddress2(custDataRequestDTO.getEmailAddress2());
		custData.setEmpId(custDataRequestDTO.getEmpId());
		custData.setGlAccountno(custDataRequestDTO.getGlAccountno());
		custData.setGoldPremium(custDataRequestDTO.getGoldPremium());
		custData.setGroup1(custDataRequestDTO.getGroup1());
		custData.setGroup(custDataRequestDTO.getGroup());
		custData.setJoinDate(custDataRequestDTO.getJoinDate());
		custData.setLocationCode(custDataRequestDTO.getLocationCode());
		custData.setLoginPassword(custDataRequestDTO.getLoginPassword());
		custData.setMarkUp(custDataRequestDTO.getMarkUp());
		custData.setPhone1(custDataRequestDTO.getPhone1());
		custData.setPhone2(custDataRequestDTO.getPhone2());
		custData.setPriceListId(custDataRequestDTO.getPriceListId());
		custData.setRank(custDataRequestDTO.getRank());
		custData.setSalesPerson(custDataRequestDTO.getSalesPerson());
		custData.setShipVia(custDataRequestDTO.getShipVia());
		custData.setState(custDataRequestDTO.getState());
		custData.setStatementType(custDataRequestDTO.getStatementType());
		custData.setStatus(custDataRequestDTO.getStatus());
		custData.setTax(custDataRequestDTO.getTax());
		custData.setTermsDays(custDataRequestDTO.getTermsDays());
		custData.setTotalCredit(custDataRequestDTO.getTotalCredit());
		custData.setTotalDue(custDataRequestDTO.getTotalDue());
		custData.setTotalPaid(custDataRequestDTO.getTotalPaid());
		custData.setWebAccess(custDataRequestDTO.getWebAccess());
		custData.setWebCustomer(custDataRequestDTO.getWebCustomer());
		custData.setZip(custDataRequestDTO.getZip());
		custData.setZips(custDataRequestDTO.getZips());
		custData.setPriority(custDataRequestDTO.getPriority());
		if(custDataRequestDTO.getPhone1s() != null && !custDataRequestDTO.getPhone1s().isEmpty()) {
			custData.setPhone1s(custDataRequestDTO.getPhone1s());
		}
		if(custDataRequestDTO.getPhone2s() != null && !custDataRequestDTO.getPhone2s().isEmpty()) {
			custData.setPhone2s(custDataRequestDTO.getPhone2s());
		}
	} catch (Exception e) {

	}
	return custData;

}
   



   
}
