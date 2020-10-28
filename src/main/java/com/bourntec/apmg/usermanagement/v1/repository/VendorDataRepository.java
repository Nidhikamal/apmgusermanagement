package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.VendorBrandDetails;
import com.bourntec.apmg.entity.VendorData;



/**
 * 
 * Repository for carried out crud operations of MerchandiseCategory  Entity
 * 
 * @author Vidya .p
 *
 */
@Repository(value = "VendorDataRepository")
public interface VendorDataRepository extends JpaRepository<VendorData,String>,JpaSpecificationExecutor<VendorData> {


}
