package com.bourntec.apmg.usermanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.NewArrivals;

/**
 * 
 * Class is used as a data transfer object for newarrivals
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
public class ArrivalsRequestDTO {

	private Long id;
	private String itemCode;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	
	
	public NewArrivals toModel(ArrivalsRequestDTO arrivalRequestDTO) {
		NewArrivals arrivals = new NewArrivals();
		
		try {
			arrivals.setId(arrivalRequestDTO.getId());
			arrivals.setItemCode(arrivalRequestDTO.getItemCode());
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return arrivals;

	}
		
	
	
}
