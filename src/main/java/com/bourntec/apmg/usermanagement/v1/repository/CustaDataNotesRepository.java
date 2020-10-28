package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CustDataNotes;


/**
 * 
 * Repository for carried out crud operations of user Entity
 * 
 * @author Vidya T.S
 *
 */
@Repository(value = "CustaDataNotesRepository")
public interface CustaDataNotesRepository extends JpaRepository<CustDataNotes, String>,JpaSpecificationExecutor<CustDataNotes> {


}
