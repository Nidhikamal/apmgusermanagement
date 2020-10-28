package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.ReturnItems;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * This class is used as a data transfer object for ReturnItems entity
 * 
 * @author Tinu
 *
 */
@Getter
@Setter
public class ReturnItemsRequestDTO {
		private long id;
	 	private String returnNo;
		private String jobNo;
		private String invNo;
		private double noPcP;
		private double noPcW;
		private double unitPrice;
		private double miscChg;
		private String desc;
		private String desc1;
		private String locationCode;
		private double discount;
		private double taxPer;
		private double itemDiscount;
	    private double originalUnitprice;
	    private String memoNo;
	    private String toShow;
	    
	    public ReturnItems toModel(ReturnItemsRequestDTO returnItemsRequestDTO)
		{
	    	ReturnItems returnItems=new ReturnItems();
	    	returnItems.setId(returnItemsRequestDTO.getId());
	    	returnItems.setReturnNo(returnItemsRequestDTO.getReturnNo());
	    	returnItems.setJobNo(returnItemsRequestDTO.getJobNo());
	    	returnItems.setInvNo(returnItemsRequestDTO.getInvNo());
	    	returnItems.setNoPcP(returnItemsRequestDTO.getNoPcP());
	    	returnItems.setNoPcW(returnItemsRequestDTO.getNoPcW());
	    	returnItems.setUnitPrice(returnItemsRequestDTO.getUnitPrice());
	    	returnItems.setMiscChg(returnItemsRequestDTO.getMiscChg());
	    	returnItems.setDesc(returnItemsRequestDTO.getDesc());
	    	returnItems.setDesc1(returnItemsRequestDTO.getDesc1());
	    	returnItems.setLocationCode(returnItemsRequestDTO.getLocationCode());
	    	returnItems.setDiscount(returnItemsRequestDTO.getDiscount());
	    	returnItems.setTaxPer(returnItemsRequestDTO.getTaxPer());
	    	returnItems.setItemDiscount(returnItemsRequestDTO.getItemDiscount());
	    	returnItems.setOriginalUnitprice(returnItemsRequestDTO.getOriginalUnitprice());
	    	returnItems.setMemoNo(returnItemsRequestDTO.getMemoNo());
	    	returnItems.setToShow(returnItemsRequestDTO.getToShow());
			return returnItems;
			
		}
}
