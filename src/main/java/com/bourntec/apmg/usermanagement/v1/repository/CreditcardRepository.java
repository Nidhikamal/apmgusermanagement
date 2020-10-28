package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CreditcardNames;



/**
 * 
 * Repository for carried out crud operations of companydata Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Repository(value = "CreditcardNamesRepository")
public interface CreditcardRepository extends JpaRepository<CreditcardNames, String>,JpaSpecificationExecutor<CreditcardNames> {

	/**
	 * Method that fetches codesPacking according the requested {id}
	 * 
	 * @param entity
	 * @return
	 */
	

}
