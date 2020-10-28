package com.bourntec.apmg.usermanagement.v1.dto.request;

import java.util.Date;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.Employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Class is used as a data transfer object for Table employee
 * 
 * @author Naveen Radhkrishnan
 *
 */
@Getter
@Setter
@NoArgsConstructor

public class EmployeeRequestDTO {

	private String empId;
	private String initial;
	private String name;
	private String address;
	private String city;
	private String state;
	private Long phone1;
	private Long phone2;
	private Double commPercent;
	private String pin;
	private Long zip;
	private String empType;
	private String intExt;
	private String payMode;
	private String workType;
	private Double totalDue;
	private Double totalPaid;
	private Double totalEmployeeDue;
	private Long ssNo;
	private Date birthDate;
	private String licenseNumber;
	private String zips;
	private String locationCode;
	private Double labor;
	private String emailAddress;
	private Date startDate;
	private String status;
	private String country;
	private String phone1s;
	private String phone2s;
	private Date anniversary;
	private String personalEmailAddress;
	private Date endDate;
	private String remarks;
	private String creditCard;
	private String empStatus;
	private String comments;
	private String telExtensn;

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPhone1() {
		return phone1;
	}

	public void setPhone1(Long phone1) {
		this.phone1 = phone1;
	}

	public Long getPhone2() {
		return phone2;
	}

	public void setPhone2(Long phone2) {
		this.phone2 = phone2;
	}

	public Double getCommPercent() {
		return commPercent;
	}

	public void setCommPercent(Double commPercent) {
		this.commPercent = commPercent;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Long getZip() {
		return zip;
	}

	public void setZip(Long zip) {
		this.zip = zip;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getIntExt() {
		return intExt;
	}

	public void setIntExt(String intExt) {
		this.intExt = intExt;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public Double getTotalDue() {
		return totalDue;
	}

	public void setTotalDue(Double totalDue) {
		this.totalDue = totalDue;
	}

	public Double getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(Double totalPaid) {
		this.totalPaid = totalPaid;
	}

	public Double getTotalEmployeeDue() {
		return totalEmployeeDue;
	}

	public void setTotalEmployeeDue(Double totalEmployeeDue) {
		this.totalEmployeeDue = totalEmployeeDue;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getZips() {
		return zips;
	}

	public void setZips(String zips) {
		this.zips = zips;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Double getLabor() {
		return labor;
	}

	public void setLabor(Double labor) {
		this.labor = labor;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone1s() {
		return phone1s;
	}

	public void setPhone1s(String phone1s) {
		this.phone1s = phone1s;
	}

	public String getPhone2s() {
		return phone2s;
	}

	public void setPhone2s(String phone2s) {
		this.phone2s = phone2s;
	}

	public Date getAnniversary() {
		return anniversary;
	}

	public void setAnniversary(Date anniversary) {
		this.anniversary = anniversary;
	}

	public String getPersonalEmailAddress() {
		return personalEmailAddress;
	}

	public void setPersonalEmailAddress(String personalEmailAddress) {
		this.personalEmailAddress = personalEmailAddress;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Employee toModel(EmployeeRequestDTO employeeRequestDTO) {

		Employee employee = new Employee();
		if (employeeRequestDTO.getEmpId() != null && !employeeRequestDTO.getEmpId().isEmpty()) {

			employee.setEmpId(employeeRequestDTO.getEmpId());
		}
		if (employeeRequestDTO.getInitial() != null && !employeeRequestDTO.getInitial().isEmpty()) {
			employee.setInitial(employeeRequestDTO.getInitial());
		}
		if (employeeRequestDTO.getName() != null && !employeeRequestDTO.getName().isEmpty()) {
			employee.setName(employeeRequestDTO.getName());
		}
		employee.setAddress(employeeRequestDTO.getAddress());
		employee.setPhone1(employeeRequestDTO.getPhone1());
		employee.setPhone2(employeeRequestDTO.getPhone2());
		employee.setPin(employeeRequestDTO.getPin());
		employee.setZip(employeeRequestDTO.getZip());
		employee.setIntExt(employeeRequestDTO.getIntExt());
		employee.setPayMode(employeeRequestDTO.getPayMode());
		employee.setWorkType(employeeRequestDTO.getWorkType());
		employee.setTotalDue(employeeRequestDTO.getTotalDue());
		employee.setTotalPaid(employeeRequestDTO.getTotalPaid());
		employee.setTotalEmployeeDue(employeeRequestDTO.getTotalEmployeeDue());
		employee.setSsNo(employeeRequestDTO.getSsNo());

		employee.setAnniversary(employeeRequestDTO.getAnniversary());
		employee.setBirthDate(employeeRequestDTO.getBirthDate());
		employee.setLicenseNumber(employeeRequestDTO.getLicenseNumber());
		employee.setZips(employeeRequestDTO.getZips());
		employee.setLocationCode(employeeRequestDTO.getLocationCode());
		employee.setLabor(employeeRequestDTO.getLabor());
		employee.setStartDate(new Date());
		employee.setStatus(employeeRequestDTO.getStatus());

		employee.setCity(employeeRequestDTO.getCity());
		employee.setCommPercent(employeeRequestDTO.getCommPercent());
		employee.setCreditCard(employeeRequestDTO.getCreditCard());
		employee.setEmailAddress(employeeRequestDTO.getEmailAddress());
		employee.setEmpStatus(employeeRequestDTO.getEmpStatus());
		employee.setEmpType(employeeRequestDTO.getEmpType());
		employee.setEndDate(employeeRequestDTO.getEndDate());

		if (employeeRequestDTO.getCountry() != null && !employeeRequestDTO.getCountry().isEmpty()) {
			employee.setCountry(employeeRequestDTO.getCountry());
		}
		if (employeeRequestDTO.getState() != null && !employeeRequestDTO.getCountry().isEmpty()) {
			employee.setState(employeeRequestDTO.getState());
		}
		employee.setPhone1s(employeeRequestDTO.getPhone1s());
		employee.setPhone2s(employeeRequestDTO.getPhone2s());
		employee.setPersonalEmailAddress(employeeRequestDTO.getPersonalEmailAddress());
		employee.setRemarks(employeeRequestDTO.getRemarks());

		employee.setTelExtensn(employeeRequestDTO.getTelExtensn());
		employee.setComments(employeeRequestDTO.getComments());

		return employee;

	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Long getSsNo() {
		return ssNo;
	}

	public void setSsNo(Long ssNo) {
		this.ssNo = ssNo;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getTelExtensn() {
		return telExtensn;
	}

	public void setTelExtensn(String telExtensn) {
		this.telExtensn = telExtensn;
	}

}
