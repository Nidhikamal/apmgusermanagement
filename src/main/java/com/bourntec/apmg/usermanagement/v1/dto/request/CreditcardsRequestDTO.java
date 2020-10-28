package com.bourntec.apmg.usermanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.CreditcardNames;

/**
 * 
 * Class is used as a data transfer object for Brands
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
public class CreditcardsRequestDTO {

	
	    private String creditType;
		private String cardName;
		private String displayWeb;
		private String cardNo;
		private String cvv;
		private String expMonth;
		private String expYear;
		private String empNo;
		private String cardType;
		public String getCreditType() {
			return creditType;
		}
		public void setCreditType(String creditType) {
			this.creditType = creditType;
		}
		public String getCardName() {
			return cardName;
		}
		public void setCardName(String cardName) {
			this.cardName = cardName;
		}
		public String getDisplayWeb() {
			return displayWeb;
		}
		public void setDisplayWeb(String displayWeb) {
			this.displayWeb = displayWeb;
		}
		public String getCardNo() {
			return cardNo;
		}
		public void setCardNo(String cardNo) {
			this.cardNo = cardNo;
		}
		public String getCvv() {
			return cvv;
		}
		public void setCvv(String cvv) {
			this.cvv = cvv;
		}
		public String getExpMonth() {
			return expMonth;
		}
		public void setExpMonth(String expMonth) {
			this.expMonth = expMonth;
		}
		public String getExpYear() {
			return expYear;
		}
		public void setExpYear(String expYear) {
			this.expYear = expYear;
		}
		public String getEmpNo() {
			return empNo;
		}
		public void setEmpNo(String empNo) {
			this.empNo = empNo;
		}
		public String getCardType() {
			return cardType;
		}
		public void setCardType(String cardType) {
			this.cardType = cardType;
		}
		
		public CreditcardNames toModel(CreditcardsRequestDTO cardRequestDTO) {
			CreditcardNames cards = new CreditcardNames();
			
			try {
				cards.setCardNo(cardRequestDTO.getCardNo());
				cards.setCardName(cardRequestDTO.getCardName());
				cards.setCardType(cardRequestDTO.getCardType());
				cards.setCreditType(cardRequestDTO.getCreditType());
				cards.setCvv(cardRequestDTO.getCvv());
				cards.setDisplayWeb(cardRequestDTO.getDisplayWeb());
				cards.setEmpNo(cardRequestDTO.getEmpNo());
				cards.setExpMonth(cardRequestDTO.getExpMonth());
				cards.setExpYear(cardRequestDTO.getExpYear());
			} catch (Exception e) {
	            e.printStackTrace();
			}
			return cards;

		}
	
	
	
		
}
