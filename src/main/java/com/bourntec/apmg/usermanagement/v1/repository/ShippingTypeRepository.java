package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.ShippingType;


/**
 * 
 * Repository for  crud operations of ShippingType Entity
 * 
 * @author Tinu
 *
 */
@Repository
public interface ShippingTypeRepository extends JpaRepository<ShippingType, Long>,JpaSpecificationExecutor<ShippingType> {


}
