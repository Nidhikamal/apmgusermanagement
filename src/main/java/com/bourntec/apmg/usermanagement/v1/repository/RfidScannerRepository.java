package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.RfidScanner;



/**
 * 
 * Repository for carried out crud operations of brand Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Repository(value = "RfidScannerRepository")
public interface RfidScannerRepository extends JpaRepository<RfidScanner, Long>,JpaSpecificationExecutor<RfidScanner> {

	/**
	 * Method that fetches branddetails according the requested {id}
	 * 
	 * @param entity
	 * @return
	 */
	

}
