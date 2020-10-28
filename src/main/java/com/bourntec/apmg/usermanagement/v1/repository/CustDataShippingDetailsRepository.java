package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CustDataShippingDetails;


/**
 * 
 * Repository for carried out crud operations of user Entity
 * 
 * @author Srijini T.S
 *
 */
@Repository(value = "CustDataShippingDetailsRepository")
public interface CustDataShippingDetailsRepository extends JpaRepository<CustDataShippingDetails, Long>,JpaSpecificationExecutor<CustDataShippingDetails> {


}
