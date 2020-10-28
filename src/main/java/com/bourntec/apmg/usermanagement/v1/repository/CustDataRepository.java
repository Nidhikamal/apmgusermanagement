package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CustData;


/**
 * 
 * Repository for carried out crud operations of user Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Repository(value = "CustDataRepository")
public interface CustDataRepository extends JpaRepository<CustData, String>,JpaSpecificationExecutor<CustData> {



}
