package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CustNotification;

/**
 * 
 * Repository for carried out CRUD operations of CustNotification Entity
 * 
 * @author 
 *
 */
@Repository(value = "CustNotificationRepository")
public interface CustNotificationRepository extends JpaRepository<CustNotification,String>,JpaSpecificationExecutor{

}
