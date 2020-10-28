package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.VendorNotification;
import com.bourntec.apmg.entity.VendorShippingDetails;



/**
 * 
 * Repository for carried out crud operations of MerchandiseCategory  Entity
 * 
 * @author Vidya .p
 *
 */
@Repository(value = "VendorShippingRepository")
public interface VendorShippingRepository extends JpaRepository<VendorShippingDetails,Long>,JpaSpecificationExecutor<VendorShippingDetails> {


}
