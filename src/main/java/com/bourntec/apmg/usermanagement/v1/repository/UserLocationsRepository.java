package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.UserLocations;



/**
 * 
 * Repository for carried out crud operations of UserLocations  Entity
 * 
 * @author Nince
 *
 */
@Repository(value = "UserLocationsRepository")
public interface UserLocationsRepository extends JpaRepository<UserLocations,Long>,JpaSpecificationExecutor<UserLocations> {


}
