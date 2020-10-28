package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.ShippingCodes;



/**
 * 
 * Repository for carried out crud operations of Shippind Codes Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Repository(value = "ShippingCodesRepository")
public interface ShippingCodesRepository extends JpaRepository<ShippingCodes, String>,JpaSpecificationExecutor<ShippingCodes> {

	/**
	 * Method that fetches codesPacking according the requested {id}
	 * 
	 * @param entity
	 * @return
	 */
	

}
