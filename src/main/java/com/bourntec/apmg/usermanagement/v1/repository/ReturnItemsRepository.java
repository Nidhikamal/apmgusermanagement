package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.ReturnItems;

/**
 * 
 * Repository for  CRUD operations of ReturnItems Entity
 * 
 * @author Tinu
 *
 */
@Repository
public interface ReturnItemsRepository extends JpaRepository<ReturnItems, Long>, JpaSpecificationExecutor<ReturnItems>{ 


}
