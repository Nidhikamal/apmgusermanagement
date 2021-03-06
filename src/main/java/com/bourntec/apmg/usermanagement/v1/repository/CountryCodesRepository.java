package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CountryCodes;

@Repository("CountryCodesRepository")
public interface CountryCodesRepository extends 
JpaRepository<CountryCodes, String>,JpaSpecificationExecutor<CountryCodes>{


}
