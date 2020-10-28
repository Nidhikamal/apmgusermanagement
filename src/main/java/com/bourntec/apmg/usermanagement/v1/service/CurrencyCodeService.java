package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CurrencyCode;
import com.bourntec.apmg.usermanagement.v1.dto.request.CurrencyCodeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CurrencyCodeResponseDTO;

public interface CurrencyCodeService {

	List<CurrencyCode> findAllCurrencyCode();

	CurrencyCodeResponseDTO findBycurrencyCode(String currencyCode);

	CurrencyCodeResponseDTO currencyCodeupdate(String currencyCode, CurrencyCodeRequestDTO currencyCodeRequestDTO);

	CurrencyCodeResponseDTO currencyCodesave(CurrencyCodeRequestDTO currencyCodeRequestDTO);

	List<CurrencyCode> fetchByCurrency(CurrencyCodeRequestDTO currencyCodeRequestDTO);


}
