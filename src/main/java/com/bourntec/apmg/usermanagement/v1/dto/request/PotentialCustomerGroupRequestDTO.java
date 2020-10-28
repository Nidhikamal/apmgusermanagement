package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.PotentialGroup;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class PotentialCustomerGroupRequestDTO {


	
   private Long groupId;
    
    private String groupName;
    
    private String Status;
    private String description;
	
	public PotentialGroup toModel(PotentialCustomerGroupRequestDTO potentialCustomerGroupRequestDTO) {

		PotentialGroup potentialCustomerGroups = new PotentialGroup();
		potentialCustomerGroups.setDescription(potentialCustomerGroupRequestDTO.getDescription());
		potentialCustomerGroups.setGroupId(potentialCustomerGroupRequestDTO.getGroupId());
		potentialCustomerGroups.setGroupName(potentialCustomerGroupRequestDTO.getGroupName());
		potentialCustomerGroups.setStatus(potentialCustomerGroupRequestDTO.getStatus());
		return potentialCustomerGroups;

	}



}
