package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.PassAccessList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassAccessListRequestDTO {

	private Long id;
	
	private String userId;

	private String moduleName;

	private String optionName;

	private String status;

	private String description;

	private String groupId;

	private String locCode;

	private String accessDescr;

	private String imported;

	public PassAccessList toModel(PassAccessListRequestDTO requestDTO) {
		PassAccessList accessList = new PassAccessList();
		accessList.setUserId(requestDTO.getUserId());
		accessList.setModuleName(requestDTO.getModuleName());
		accessList.setOptionName(requestDTO.getOptionName());
		accessList.setStatus(requestDTO.getStatus());
		accessList.setDescription(requestDTO.getDescription());
		accessList.setGroupId(requestDTO.getGroupId());
		accessList.setLocCode(requestDTO.getLocCode());
		accessList.setAccessDescr(requestDTO.getAccessDescr());
		accessList.setImported(requestDTO.getImported());
		return accessList;
	}

}
