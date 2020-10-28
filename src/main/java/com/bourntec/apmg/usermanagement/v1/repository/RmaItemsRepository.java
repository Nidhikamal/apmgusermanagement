package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.RmaItems;

/**
 * 
 * Repository for  CRUD operations of RmaItems Entity
 * 
 * @author Tinu
 *
 */
@Repository
public interface RmaItemsRepository extends JpaRepository<RmaItems, Long>, JpaSpecificationExecutor<RmaItems> {


}
