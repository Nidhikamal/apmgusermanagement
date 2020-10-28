package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.Brokers;



/**
 * 
 * Repository for carried out crud operations of BrokersRepository  Entity
 * 
 * @author Vidya .p
 *
 */
@Repository(value = "BrokersRepository")
public interface BrokersRepository extends JpaRepository<Brokers,String>,JpaSpecificationExecutor<Brokers> {


}
