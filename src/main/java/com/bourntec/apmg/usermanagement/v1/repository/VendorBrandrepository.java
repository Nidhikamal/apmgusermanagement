package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.BrandDetails;
import com.bourntec.apmg.entity.VendorBrandDetails;
import com.bourntec.apmg.entity.VendorContactDetails;



/**
 * 
 * Repository for carried out crud operations of MerchandiseCategory  Entity
 * 
 * @author Vidya .p
 *
 */
@Repository(value = "VendorBrandrepository")
public interface VendorBrandrepository extends JpaRepository<VendorBrandDetails,Long>,JpaSpecificationExecutor<VendorBrandDetails> {


}
