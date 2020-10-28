package com.bourntec.apmg.usermanagement.v1.dto.request;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.RfidScanner;

/**
 * 
 * Class is used as a data transfer object for Brands
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
public class RfidRequestDTO {

	
	
	private Long uniqueScannerId;
	private String rfidScannerName;
	private String rfidScannerId;
	private String rfidScannerStatus;
	private String description;
	
	
	
	public Long getUniqueScannerId() {
		return uniqueScannerId;
	}
	public void setUniqueScannerId(Long uniqueScannerId) {
		this.uniqueScannerId = uniqueScannerId;
	}
	public String getRfidScannerName() {
		return rfidScannerName;
	}
	public void setRfidScannerName(String rfidScannerName) {
		this.rfidScannerName = rfidScannerName;
	}
	public String getRfidScannerId() {
		return rfidScannerId;
	}
	public void setRfidScannerId(String rfidScannerId) {
		this.rfidScannerId = rfidScannerId;
	}
	public String getRfidScannerStatus() {
		return rfidScannerStatus;
	}
	public void setRfidScannerStatus(String rfidScannerStatus) {
		this.rfidScannerStatus = rfidScannerStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public RfidScanner toModel(RfidRequestDTO rfidRequestDTO) {
		RfidScanner rfidscanner = new RfidScanner();
		
		try {
			rfidscanner.setRfidScannerId(rfidRequestDTO.getRfidScannerId());
			rfidscanner.setRfidScannerName(rfidRequestDTO.getRfidScannerName());
			rfidscanner.setRfidScannerStatus(rfidRequestDTO.getRfidScannerStatus());
			rfidscanner.setDescription(rfidRequestDTO.getDescription());
			rfidscanner.setUniqueScannerId(rfidRequestDTO.getUniqueScannerId());
		} catch (Exception e) {
            e.printStackTrace();
		}
		return rfidscanner;

	}
		
}
