package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.LabourCharge;



@Repository(value = "LabourChargeRepository")

public interface LabourChargeRepository extends 
JpaRepository<LabourCharge,Long>,JpaSpecificationExecutor {

}
