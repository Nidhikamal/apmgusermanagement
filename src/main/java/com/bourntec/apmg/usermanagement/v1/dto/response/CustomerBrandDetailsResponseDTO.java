package com.bourntec.apmg.usermanagement.v1.dto.response;
 

import com.bourntec.apmg.usermanagement.v1.dto.request.CustomerBrandDetailsRequestDTO;

import lombok.Getter;
import lombok.Setter;

//import javax.validation.constraints.NotNull;



/**
 * DTO class for sending the response
 *  
 * @author Amal Chandra N A
 *
 */

@Getter
@Setter
public class CustomerBrandDetailsResponseDTO extends CustomerBrandDetailsRequestDTO {

	private Long id;
	private String status;
	private Long brandId;
	private String custNo;
	private Long termsDays;
	private Double markUp;
	private Double discount;
	private String salesPerson;
	private String previousSalesMan;
	private String salesPerson2;
	private String salesPerson3;
	private Double memoMarkUp;
	private String responseMessage;

	
}
