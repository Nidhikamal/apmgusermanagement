package com.bourntec.apmg.usermanagement.v1.dto.request;

import java.util.Date;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.PassTable;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Class is used as a data transfer object for Table pass_table
 * 
 * @author Srijini T.S
 *
 */
@Getter
@Setter
@Validated
public class PassTableRequestDTO {

	private String userId;
	private String fullName;
	private String locCode;
	private String accountDisabled;
	private Date lastLogin;

	private String password;

	private String tempLockout;

	private String description;

	private String groupUser;

	private String changePass;

	private String passLock;

	private String stopPassExpry;

	private Date lastInvalidAccessDate;

	private Date lastInvalidAccessTime;

	private Long lockoutCtr;

	private Date startTime;

	private Date endTime;

	private String empId;

	private String loggedIn;

	private String multiAccess;

	private String accessImported;
	
	public PassTable toModel(PassTableRequestDTO passTableRequestDTO)
	{
		PassTable passTable=new PassTable();
		
		passTable.setAccessImported(passTableRequestDTO.getAccessImported());
		//passTable.setAccessLists(accessLists);
		passTable.setAccountDisabled(passTableRequestDTO.getAccountDisabled());
		passTable.setChangePass(passTableRequestDTO.getChangePass());
		passTable.setDescription(passTableRequestDTO.getDescription());
		passTable.setEmpId(passTableRequestDTO.getEmpId());
		passTable.setEndTime(passTableRequestDTO.getEndTime());
		passTable.setFullName(passTableRequestDTO.getFullName());
		passTable.setGroupUser(passTableRequestDTO.getGroupUser());
		passTable.setLastInvalidAccessDate(passTableRequestDTO.getLastInvalidAccessDate());
		passTable.setLastInvalidAccessTime(passTableRequestDTO.getLastInvalidAccessTime());
		passTable.setLastLogin(passTableRequestDTO.getLastLogin());
		passTable.setLocCode(passTableRequestDTO.getLocCode());
		passTable.setLockoutCtr(passTableRequestDTO.getLockoutCtr());
		passTable.setLoggedIn(passTableRequestDTO.getLoggedIn());
		passTable.setMultiAccess(passTableRequestDTO.getMultiAccess());
		passTable.setPassLock(passTableRequestDTO.getPassLock());
		passTable.setPassword(passTableRequestDTO.getPassword());
		passTable.setStartTime(passTableRequestDTO.getStartTime());
		passTable.setStopPassExpry(passTableRequestDTO.getStopPassExpry());
		passTable.setTempLockout(passTableRequestDTO.getTempLockout());
		passTable.setUserId(passTableRequestDTO.getUserId());
		return passTable;
	}
}
