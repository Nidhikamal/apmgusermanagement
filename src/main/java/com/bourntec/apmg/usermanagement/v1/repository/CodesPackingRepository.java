package com.bourntec.apmg.usermanagement.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CodesPacking;



/**
 * 
 * Repository for carried out crud operations of codespacking Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Repository(value = "CodesPackingRepository")
public interface CodesPackingRepository extends JpaRepository<CodesPacking, String>,JpaSpecificationExecutor<CodesPacking> {

	/**
	 * Method that fetches codesPacking according the requested {id}
	 * 
	 * @param entity
	 * @return
	 */
	List<CodesPacking> findAll();
}
