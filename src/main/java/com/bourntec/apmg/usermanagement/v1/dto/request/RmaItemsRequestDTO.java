package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.RmaItems;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * This class is used as a data transfer object for RmaItems entity
 * 
 * @author Tinu
 *
 */
@Getter
@Setter
public class RmaItemsRequestDTO {
	private long id;
	
	private String rmaNo;
	
	private String jobNo;
	
	private String invNo;
	
	public double noPcP;
	
	public double noPcW;
	
	public double unitPrice;
	
	private String desc1;
	
	public RmaItems toModel(RmaItemsRequestDTO rmaItemsRequestDTO)
	{
		RmaItems rmaItems=new RmaItems();
		rmaItems.setId(rmaItemsRequestDTO.getId());
		rmaItems.setRmaNo(rmaItemsRequestDTO.getRmaNo());
		rmaItems.setJobNo(rmaItemsRequestDTO.getJobNo());
		rmaItems.setInvNo(rmaItemsRequestDTO.getInvNo());
		rmaItems.setNoPcP(rmaItemsRequestDTO.getNoPcP());
		rmaItems.setNoPcW(rmaItemsRequestDTO.getNoPcW());
		rmaItems.setUnitPrice(rmaItemsRequestDTO.getUnitPrice());
		rmaItems.setDesc1(rmaItemsRequestDTO.getDesc1());
		return rmaItems;
		
	}
}
