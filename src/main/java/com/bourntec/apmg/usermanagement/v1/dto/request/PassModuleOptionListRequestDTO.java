package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.PassModuleOptionList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassModuleOptionListRequestDTO {
	private String moduleName;
	private String optionName;
	private String description;
	private String locCode;
	private String optionUrl;
	private String menuItemName;
	private String optionDesc;

	public PassModuleOptionList toModel(PassModuleOptionListRequestDTO dto) {
		PassModuleOptionList moduleOptionList = new PassModuleOptionList();
		try {
			moduleOptionList.setModuleName(dto.getModuleName());
			moduleOptionList.setOptionName(dto.getOptionName());
			moduleOptionList.setOptionUrl(dto.getOptionUrl());
			moduleOptionList.setLocCode(dto.getLocCode());
			moduleOptionList.setDescription(dto.getDescription());
			moduleOptionList.setMenuItemName(dto.getMenuItemName());
			moduleOptionList.setOptionDesc(dto.getOptionDesc());
		} catch (Exception e) {

		}

		return moduleOptionList;
	}
}
