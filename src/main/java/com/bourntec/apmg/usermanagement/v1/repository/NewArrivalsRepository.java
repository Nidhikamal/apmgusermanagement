package com.bourntec.apmg.usermanagement.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.NewArrivals;



/**
 * 
 * Repository for carried out crud operations of new Arrivals Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Repository(value = "NewArrivalsRepository")
public interface NewArrivalsRepository extends JpaRepository<NewArrivals, Long>,JpaSpecificationExecutor<NewArrivals> {

	/**
	 * Method that fetches NewArrivals according the requested {id}
	 * 
	 * @param entity
	 * @return
	 */
	NewArrivals findArrivalsByid(Long id);
	NewArrivals save(NewArrivals newarrvls);
	List<NewArrivals> findAll();
}
