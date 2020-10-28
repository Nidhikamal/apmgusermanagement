	package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.LabourCharge;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LabourChargeRequestDTO {

	private Long id;
	private String laborName;
	private Double amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLaborName() {
		return laborName;
	}

	public void setLaborName(String laborName) {
		this.laborName = laborName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LabourCharge toModel(LabourChargeRequestDTO labourChargeRequestDTO) {
		LabourCharge labourCharge = new LabourCharge();
		labourCharge.setAmount(labourChargeRequestDTO.getAmount());
		labourCharge.setId(labourChargeRequestDTO.getId());
		labourCharge.setLaborName(labourChargeRequestDTO.getLaborName());

		return labourCharge;
	}

}
