package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.ParcelDetails;



/**
 * 
 * Repository for carried out crud operations of BrokersRepository  Entity
 * 
 * @author Vidya .p
 *
 */
@Repository(value = "ParcelRepository")
public interface ParcelRepository extends JpaRepository<ParcelDetails,String>,JpaSpecificationExecutor<ParcelDetails> {


}
