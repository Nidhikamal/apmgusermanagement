package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.FaqDetails;



/**
 * 
 * Repository for carried out crud operations of BrokersRepository  Entity
 * 
 * @author Vidya .p
 *
 */
@Repository(value = "FaqDetailsRepository")
public interface FaqDetailsRepository extends JpaRepository<FaqDetails,Integer>,JpaSpecificationExecutor<FaqDetails> {


}
