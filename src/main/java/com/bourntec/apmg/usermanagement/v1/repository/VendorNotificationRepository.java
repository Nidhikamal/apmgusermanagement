package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.VendorEmployees;
import com.bourntec.apmg.entity.VendorNotification;



/**
 * 
 * Repository for carried out crud operations of MerchandiseCategory  Entity
 * 
 * @author Vidya .p
 *
 */
@Repository(value = "VendorNotificationRepository")
public interface VendorNotificationRepository extends JpaRepository<VendorNotification,String>,JpaSpecificationExecutor<VendorNotification>  {


}
