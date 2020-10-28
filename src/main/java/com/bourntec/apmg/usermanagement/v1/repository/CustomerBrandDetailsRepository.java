package com.bourntec.apmg.usermanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CustomerBrandDetails;



/**
 * 
 * Repository for carried out crud operations of brand Entity
 * 
 * @author Amal Chandra N A
 *
 */

@Repository(value = "CustomerBrandDetailsRepository")
public interface CustomerBrandDetailsRepository extends JpaRepository<CustomerBrandDetails, Long>,JpaSpecificationExecutor<CustomerBrandDetails> {
	

	/**
	 * Method that fetches CustomerBrandDetailsRepository according the requested {id}
	 * 
	 * @param entity
	 * @return
	 */
	

}
