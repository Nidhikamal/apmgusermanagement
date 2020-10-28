package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.CurrencyCode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CurrencyCodeRequestDTO {
	private String currencyCode;

	private String currencyName;
	private double exchangeRate;

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public CurrencyCode toModel(CurrencyCodeRequestDTO currencyCodeRequestDTO) {
		CurrencyCode currencyCode = new CurrencyCode();
  currencyCode.setCurrencyCode(currencyCodeRequestDTO.getCurrencyCode());
		currencyCode.setCurrencyName(currencyCodeRequestDTO.getCurrencyName());
		currencyCode.setExchangeRate(currencyCodeRequestDTO.getExchangeRate());
		
		return currencyCode;
	}

}
