package com.bourntec.apmg.usermanagement.v1.dto.request;

import java.util.Set;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.MerchandiseCategory;
import com.bourntec.apmg.entity.MerchandiseSubCategory;


/**
 * 
 * Class is used as a data transfer object for Table MerchandiseCategory
 * 
 * @author vidya.p 
 *
 */

@Validated
public class MerchandiseCategoryRequestDTO {
private String categoryCode;  
private String categoryDescription;
private String locationCode;


public String getCategoryCode() {
	return categoryCode;
}
/**
 * @param categoryCode
 */
public void setCategoryCode(String categoryCode) {
	this.categoryCode = categoryCode;
}

 
public String getCategoryDescription() {
	return categoryDescription;
}
public void setCategoryDescription(String categoryDescription) {
	this.categoryDescription = categoryDescription;
}
public String getLocationCode() {
	return locationCode;
}
public void setLocationCode(String locationCode) {
	this.locationCode = locationCode;
}
public MerchandiseCategory toModel(MerchandiseCategoryRequestDTO merchandiseCategoryRequestDTO) {

		MerchandiseCategory merchandiseCategory = new MerchandiseCategory();
	
		try {
			merchandiseCategory.setCategoryCode(merchandiseCategoryRequestDTO.getCategoryCode());
			merchandiseCategory.setCategoryDescription(merchandiseCategoryRequestDTO.getCategoryDescription());
			merchandiseCategory.setLocationCode(merchandiseCategoryRequestDTO.getLocationCode()); 
		
		
		} catch (Exception e) {

		}
		return merchandiseCategory;

	}





}
