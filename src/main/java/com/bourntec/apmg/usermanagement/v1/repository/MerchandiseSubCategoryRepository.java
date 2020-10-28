package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.MerchandiseCategory;
import com.bourntec.apmg.entity.MerchandiseSubCategory;



/**
 * 
 * Repository for carried out crud operations of MerchandiseCategory  Entity
 * 
 * @author Vidya .p
 *
 */
@Repository(value = "MerchandiseSubCategoryRepository")
public interface MerchandiseSubCategoryRepository extends JpaRepository<MerchandiseSubCategory,String>,JpaSpecificationExecutor<MerchandiseSubCategory> {


}
