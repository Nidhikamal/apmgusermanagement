package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.BrandDetails;
import com.bourntec.apmg.entity.Incidents;



/**
 * 
 * Repository for carried out crud operations of MerchandiseCategory  Entity
 * 
 * @author Vidya .p
 *
 */
@Repository(value = "IncidentsRepository")
public interface IncidentsRepository extends JpaRepository<Incidents,Long> ,JpaSpecificationExecutor<Incidents> {


}
