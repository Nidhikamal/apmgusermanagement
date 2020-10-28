package com.bourntec.apmg.usermanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.ReturnData;
/**
 * 
 * Repository for  CRUD operations of ReturnData Entity
 * 
 * @author Tinu
 *
 */
@Repository
public interface ReturnDataRepository extends JpaRepository<ReturnData, String>, JpaSpecificationExecutor<ReturnData> {

}
