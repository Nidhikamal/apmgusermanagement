package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.RmaData;

/**
 * 
 * Repository for  CRUD operations of RmaData Entity
 * 
 * @author Tinu
 *
 */
@Repository
public interface RmaDataRepository extends JpaRepository<RmaData, String>, JpaSpecificationExecutor<RmaData> {

}
