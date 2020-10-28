package com.bourntec.apmg.usermanagement.v1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.PassTable;


/**
 * 
 * Repository for carried out crud operations of user Entity
 * 
 * @author Srijini T.S
 *
 */
@Repository
public interface PassTableRepository extends JpaRepository<PassTable, String>, JpaSpecificationExecutor<PassTable>{
	//returning the PassTable entity which is not soft deleted
	Optional <PassTable> findByUserIdAndAccountDisabled(String userId,String accountDisabled );
	//returning the list of PassTable entity which are not soft deleted
	List<PassTable>	findByAccountDisabled(String accountDisabled );
}
