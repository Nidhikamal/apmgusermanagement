package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.Employee;



/**
 * 
 * Repository for carried out crud operations of employee Entity
 * 
 * @author Naveen T.S
 *
 */
@Repository(value = "EmployeeRepository")
public interface EmployeeRepository 
extends JpaRepository<Employee,String>,JpaSpecificationExecutor {
	  // Your query methods here
	




	

}
