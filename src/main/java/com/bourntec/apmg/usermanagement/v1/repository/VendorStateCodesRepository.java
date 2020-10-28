package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.VendorStateCodes;


@Repository(value = "VendorStateCodesRepository")
public interface VendorStateCodesRepository extends JpaRepository<VendorStateCodes, String>,JpaSpecificationExecutor<VendorStateCodes> {

	
	
	
	

}
