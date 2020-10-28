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
public class MerchandiseSubCategoryRequestDTO {
private String subCategoryCode;  
private String subCategoryName;
private String categoryCode;

public String getCategoryCode() {
	return categoryCode;
}
/**
 * @param categoryCode
 */
public void setCategoryCode(String categoryCode) {
	this.categoryCode = categoryCode;
}




public MerchandiseSubCategory toModel(MerchandiseSubCategoryRequestDTO merchandiseSubCatRequestDTO) {

		MerchandiseSubCategory merchandiseSubCategory = new MerchandiseSubCategory();
	
		try {
			merchandiseSubCategory.setCategoryCode(merchandiseSubCatRequestDTO.getCategoryCode());
			merchandiseSubCategory.setSubCategoryName(merchandiseSubCatRequestDTO.getSubCategoryName());
			merchandiseSubCategory.setSubCategoryCode(merchandiseSubCatRequestDTO.getSubCategoryCode());
		} catch (Exception e) {

		}
		return merchandiseSubCategory;

	}
public String getSubCategoryCode() {
	return subCategoryCode;
}
public String getSubCategoryName() {
	return subCategoryName;
}
public void setSubCategoryCode(String subCategoryCode) {
	this.subCategoryCode = subCategoryCode;
}
public void setSubCategoryName(String subCategoryName) {
	this.subCategoryName = subCategoryName;
}





}
