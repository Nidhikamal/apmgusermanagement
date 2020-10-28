package com.bourntec.apmg.usermanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.CodesPacking;

/**
 * 
 * Class is used as a data transfer object for Brands
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
public class CodesPackingRequestDTO {

	private String packingId;
	private String packingName;
	private String thumbImage;
	private String zoomImage;
	private String intRemarks;
	private String extRemarks;

	
	public String getPackingId() {
		return packingId;
	}
	public void setPackingId(String packingId) {
		this.packingId = packingId;
	}
	public String getPackingName() {
		return packingName;
	}
	public void setPackingName(String packingName) {
		this.packingName = packingName;
	}
	public String getThumbImage() {
		return thumbImage;
	}
	public void setThumbImage(String thumbImage) {
		this.thumbImage = thumbImage;
	}
	public String getZoomImage() {
		return zoomImage;
	}
	public void setZoomImage(String zoomImage) {
		this.zoomImage = zoomImage;
	}
	
	
	public String getIntRemarks() {
		return intRemarks;
	}
	public void setIntRemarks(String intRemarks) {
		this.intRemarks = intRemarks;
	}
	public String getExtRemarks() {
		return extRemarks;
	}
	public void setExtRemarks(String extRemarks) {
		this.extRemarks = extRemarks;
	}
	public CodesPacking toModel(CodesPackingRequestDTO packingRequestDTO) {
		CodesPacking packing = new CodesPacking();
		
		try {
			packing.setPackingId(packingRequestDTO.getPackingId());
			packing.setPackingName(packingRequestDTO.getPackingName());
			packing.setExtRemarks(packingRequestDTO.getExtRemarks());
			packing.setIntRemarks(packingRequestDTO.getIntRemarks());
			packing.setThumbImage(packingRequestDTO.getThumbImage());
			packing.setZoomImage(packingRequestDTO.getZoomImage());
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return packing;

	}
		
}
