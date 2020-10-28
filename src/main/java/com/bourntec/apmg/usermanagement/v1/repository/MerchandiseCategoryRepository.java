package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.BrandDetails;
import com.bourntec.apmg.entity.MerchandiseCategory;



/**
 * 
 * Repository for carried out crud operations of MerchandiseCategory  Entity
 * 
 * @author Vidya .p
 *
 */
@Repository(value = "MerchandiseCategoryRepository")
public interface MerchandiseCategoryRepository extends JpaRepository<MerchandiseCategory,String>,JpaSpecificationExecutor<MerchandiseCategory> {


}