package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CustData2;


/**
 * 
 * Repository for carried out crud operations of user Entity
 * 
 * @author Srijini T.S
 *
 */
@Repository(value = "CustData2Repository")
public interface CustData2Repository extends JpaRepository<CustData2, String>,JpaSpecificationExecutor<CustData2> {


}
