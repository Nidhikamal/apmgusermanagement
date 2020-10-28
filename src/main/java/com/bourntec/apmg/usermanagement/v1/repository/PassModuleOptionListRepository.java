package com.bourntec.apmg.usermanagement.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.PassModuleOptionList;

/**
 * @Repository class for entity
 * 
 * @author Srijini T.S
 *
 */
@Repository
public interface PassModuleOptionListRepository extends JpaRepository<PassModuleOptionList, String>,JpaSpecificationExecutor<PassModuleOptionList> {

	/**
	 * Fetch all Option list
	 */
	List<PassModuleOptionList> findAll();

	@Query("SELECT submod FROM PassModuleOptionList submod WHERE submod.id.optionName=?1")
	List<PassModuleOptionList> findByOptionName(String optionname);

}
