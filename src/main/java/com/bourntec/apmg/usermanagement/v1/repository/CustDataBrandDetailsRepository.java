package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CustomerBrandDetails;


/**
 * 
 * Repository for carried out crud operations of user Entity
 * 
 * @author Srijini T.S
 *
 */
@Repository(value = "CustDataBrandDetailsRepository")
public interface CustDataBrandDetailsRepository extends JpaRepository<CustomerBrandDetails, Integer> {


}
