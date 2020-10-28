package com.bourntec.apmg.usermanagement.v1.dto.request;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.bourntec.apmg.entity.VendorContactDetails;
import com.bourntec.apmg.entity.VendorEmployees;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * VendorEmployeesRequestDTO
 * @author vidya.p
 */



public class VendorEmployeesRequestDTO {
	
	@JsonIgnore
	private Integer id;
	private String vendorNo;
	private String empId;
	private String empName;
	private String empType;
	private String empCell;
	private String empMail;
	private Date dob;

	

	/** default constructor */
	public VendorEmployeesRequestDTO() {
	}

	
	
	public String getVendorNo() {
		return this.vendorNo;
	}

	public void setVendorNo(String vendorNo) {
		this.vendorNo = vendorNo;
	}

	public String getEmpId() {
		return this.empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpType() {
		return this.empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getEmpCell() {
		return this.empCell;
	}

	public void setEmpCell(String empCell) {
		this.empCell = empCell;
	}

	public String getEmpMail() {
		return this.empMail;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public VendorEmployees toModel(VendorEmployeesRequestDTO vendorEmployeeRequestDTO) {

		VendorEmployees employee=new VendorEmployees();
		BeanUtils.copyProperties(vendorEmployeeRequestDTO,employee);
		return employee;
	
	}
}