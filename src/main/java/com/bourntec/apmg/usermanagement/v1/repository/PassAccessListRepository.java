package com.bourntec.apmg.usermanagement.v1.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.PassAccessList;

/**
 * @Repository class for entity pass_access_list
 * 
 * @author Srijini T.S
 *
 */
@Repository
public interface PassAccessListRepository extends JpaRepository<PassAccessList, Long>,
		JpaSpecificationExecutor, QueryByExampleExecutor<PassAccessList> {

	/**
	 * Fetch all user permission list
	 */
	List<PassAccessList> findAll();

	@Query("SELECT a FROM PassAccessList a ")
	// + "inner join PassModuleOptionList o "
	// + "(o.id.optionName=a.passId.optionName and
	// o.id.moduleName=a.passId.moduleOptionList.moduleName) "
	// + "group by a.passTable.userId,o.moduleName,o.id.optionName ")
	List<PassAccessList> getAllUserAccessList();

	@Query("SELECT a FROM PassAccessList a "
			+ "WHERE a.userId=?1 ")
	List<PassAccessList> getUserAccessList(String userId);

	@Modifying
	@Transactional
	@Query("DELETE FROM  PassAccessList pass WHERE pass.userId = ?1 ")
	void deleteByUserId(String userId);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM  PassAccessList pass WHERE pass.userId = ?1 AND pass.moduleName = ?2")
	void deleteByUserIdAndModuleName(String userId,String moduleName);

	@Modifying
	@Transactional
	@Query(value = "insert into apollo.pass_access_list (user_id, option_name, module_nameaccess_status, description, group_id, location_code, access_description, imported)"
			+ " select ?1 ,option_name, module_nameaccess_status, description, group_id, location_code, access_description, imported "
			+ " from apollo.pass_access_list where user_id=?2 ", nativeQuery = true)
	void copyRole(String newUserId, String userId);

	@Modifying
	@Transactional
	@Query(value = "insert into apollo.pass_access_list (user_id, option_name, module_name,access_status, "
			+ "description, group_id, location_code, access_description, imported)"
			+ " values (?1,?2,?3,?4,?5,?6,?7,?8,?9)", nativeQuery = true)
	void saveRole(String userId, String optionName, String moduleName, String accessStatus, String description,
			String groupId, String locationCode, String accessDescription, String imported);

}
