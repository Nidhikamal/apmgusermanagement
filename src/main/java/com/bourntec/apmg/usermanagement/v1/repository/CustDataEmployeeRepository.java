package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CustDataEmployee;


/**
 * 
 * Repository for carried out crud operations of Customer data Employee
 * 
 * @author Srijini T.S
 *
 */
@Repository(value = "CustDataEmployeeRepository")
public interface CustDataEmployeeRepository extends JpaRepository<CustDataEmployee, String>,JpaSpecificationExecutor {


}
