package com.bourntec.apmg.usermanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.UserLocations;

import lombok.Getter;
import lombok.Setter;


/**
 * 
 * Class is used as a data transfer object for Table UserLocations
 * 
 * @author Nince 
 *
 */

@Getter
@Setter
@Validated
public class UserLocationsRequestDTO {
	private Long id;
	private String userId;
	private String location;	
	
	public UserLocations toModel(UserLocationsRequestDTO userLocationsRequestDTO) {
		UserLocations userLocations = new UserLocations();
		try {
			if(userLocationsRequestDTO.getId() != null) {
				userLocations.setId(userLocationsRequestDTO.getId());
			}
			if(userLocationsRequestDTO.getUserId() != null && !userLocationsRequestDTO.getUserId().isEmpty()) {
				userLocations.setUserId(userLocationsRequestDTO.getUserId());
			}
			if(userLocationsRequestDTO.getLocation() != null && !userLocationsRequestDTO.getLocation().isEmpty()) {
				userLocations.setLocation(userLocationsRequestDTO.getLocation());
			}
		} catch (Exception e) {

		}
		return userLocations;

	}



}
