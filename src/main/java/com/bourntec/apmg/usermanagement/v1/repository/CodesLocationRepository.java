package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CodesLocation;


@Repository(value = "CodesLocationRepository")
public interface CodesLocationRepository extends 
JpaRepository<CodesLocation, String>, JpaSpecificationExecutor {

	CodesLocation findBylocationCode(String locationCode);

}
