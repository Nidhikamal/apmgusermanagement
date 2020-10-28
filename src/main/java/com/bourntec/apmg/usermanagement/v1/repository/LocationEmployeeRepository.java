package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bourntec.apmg.entity.CodesLocation;
import com.bourntec.apmg.entity.LocationEmployee;

public interface LocationEmployeeRepository  extends 
JpaRepository<LocationEmployee, Long>, JpaSpecificationExecutor {

}
