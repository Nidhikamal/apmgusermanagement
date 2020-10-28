package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.CustDataEmployee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustDataEmployeeRequestDTO {

	private String empId;
	private String custNo;
	private String empName;
	private String empCell;
	private String empType;
	private String empMail;
	private String status;
	private String activeOrNot;
	private String custStatus;

	public String getEmpId() {
		return empId;
	}

	public String getCustNo() {
		return custNo;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmpCell() {
		return empCell;
	}

	public String getEmpType() {
		return empType;
	}

	public String getEmpMail() {
		return empMail;
	}

	public String getStatus() {
		return status;
	}

	public String getActiveOrNot() {
		return activeOrNot;
	}

	public String getCustStatus() {
		return custStatus;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmpCell(String empCell) {
		this.empCell = empCell;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setActiveOrNot(String activeOrNot) {
		this.activeOrNot = activeOrNot;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}

	public CustDataEmployee toModel(CustDataEmployeeRequestDTO custDataEmployeeRequestdto) {

		CustDataEmployee custDataEmployee = new CustDataEmployee();

		if (custDataEmployeeRequestdto.getEmpId() != null && !custDataEmployeeRequestdto.getEmpId().isEmpty()) {
			custDataEmployee.setEmpId(custDataEmployeeRequestdto.getEmpId());
		}
		custDataEmployee.setCustNo(custDataEmployeeRequestdto.getCustNo());
		custDataEmployee.setEmpName(custDataEmployeeRequestdto.getEmpName());
		custDataEmployee.setEmpCell(custDataEmployeeRequestdto.getEmpCell());
		custDataEmployee.setEmpType(custDataEmployeeRequestdto.getEmpType());
		custDataEmployee.setEmpMail(custDataEmployeeRequestdto.getEmpMail());
		custDataEmployee.setStatus(custDataEmployeeRequestdto.getStatus());
		//custDataEmployee.setActiveOrNot(custDataEmployeeRequestdto.getActiveOrNot());
		custDataEmployee.setCustStatus(custDataEmployeeRequestdto.getCustStatus());

		return custDataEmployee;
	}
}
