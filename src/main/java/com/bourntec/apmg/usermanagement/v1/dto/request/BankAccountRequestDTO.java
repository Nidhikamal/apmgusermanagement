package com.bourntec.apmg.usermanagement.v1.dto.request;

import java.util.Date;

import com.bourntec.apmg.entity.BankAccounts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BankAccountRequestDTO {

	private String bankNo;
	private String bankName;
	private Date openDate;
	private Date closedDate;
	private Double openBalance;
	private Double totDebits;
	private Double totCredits;
	private Double closingBalance;
	private String locationCode;
	private String glAccountno;

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public Double getOpenBalance() {
		return openBalance;
	}

	public void setOpenBalance(Double openBalance) {
		this.openBalance = openBalance;
	}

	public Double getTotDebits() {
		return totDebits;
	}

	public void setTotDebits(Double totDebits) {
		this.totDebits = totDebits;
	}

	public Double getTotCredits() {
		return totCredits;
	}

	public void setTotCredits(Double totCredits) {
		this.totCredits = totCredits;
	}

	public Double getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getGlAccountno() {
		return glAccountno;
	}

	public void setGlAccountno(String glAccountno) {
		this.glAccountno = glAccountno;
	}

	public BankAccounts toModel(BankAccountRequestDTO bankAccountRequestDTO) {

		BankAccounts bankAccounts = new BankAccounts();
		bankAccounts.setBankName(bankAccountRequestDTO.getBankName());
		bankAccounts.setBankNo(bankAccountRequestDTO.getBankNo());
		bankAccounts.setClosedDate(bankAccountRequestDTO.getClosedDate());
		bankAccounts.setOpenBalance(bankAccountRequestDTO.getOpenBalance());
		bankAccounts.setGlAccountno(bankAccountRequestDTO.getGlAccountno());
		bankAccounts.setClosingBalance(bankAccountRequestDTO.getClosingBalance());
		bankAccounts.setLocationCode(bankAccountRequestDTO.getLocationCode());

		bankAccounts.setOpenDate(bankAccountRequestDTO.getOpenDate());
		bankAccounts.setTotCredits(bankAccountRequestDTO.getTotCredits());
		bankAccounts.setTotDebits(bankAccountRequestDTO.getTotDebits());
		return bankAccounts;
	}

}
