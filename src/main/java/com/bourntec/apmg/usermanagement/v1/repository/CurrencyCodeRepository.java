package com.bourntec.apmg.usermanagement.v1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CurrencyCode;

@Repository("CurrencyCodeRepository")
public interface CurrencyCodeRepository 
extends JpaRepository<CurrencyCode,String>,JpaSpecificationExecutor{

	Optional<CurrencyCode> findBycurrencyCode(String currencyCode);

}
