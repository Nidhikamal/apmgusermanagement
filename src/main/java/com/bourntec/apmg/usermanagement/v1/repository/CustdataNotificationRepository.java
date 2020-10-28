package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CustNotification;


/**
 * 
 * Repository for carried out crud operations of user Entity
 * 
 * @author Vidya T.S
 *
 */
@Repository(value = "CustdataNotificationRepository")
public interface CustdataNotificationRepository extends JpaRepository<CustNotification, String> {


}
