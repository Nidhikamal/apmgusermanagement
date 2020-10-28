package com.bourntec.apmg.usermanagement.v1.dto.request;

import java.util.Date;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.FaqDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


/**
 * 
 * Class is used as a data transfer object for Table MerchandiseCategory
 * 
 * 
 * @author vidya.p 
 *
 */


@Getter
@Setter
public class FaqDetailsRequestDTO {
	@JsonIgnore
	private String module;
	private String question;
	private String answer;
	private String status;
	private String createdUser;
	private Date createdDate;
	private String lastModifiedUser;
	private Date lastModifiedDate;
	private Integer id;

	
	

	public FaqDetails toModel(FaqDetailsRequestDTO faqRequestDTO) {

		FaqDetails faq = new FaqDetails();
	
		try {
			faq.setId(faqRequestDTO.getId());
			faq.setAnswer(faqRequestDTO.getAnswer());
			faq.setCreatedDate(faqRequestDTO.getCreatedDate());	
			faq.setCreatedUser(faqRequestDTO.getCreatedUser());
			faq.setLastModifiedDate(faqRequestDTO.getLastModifiedDate());
			faq.setLastModifiedUser(faqRequestDTO.getLastModifiedUser());
			faq.setModule(faqRequestDTO.getModule());
			faq.setQuestion(faqRequestDTO.getQuestion());
			faq.setStatus(faqRequestDTO.getStatus());
		} catch (Exception e) {

		}
		return faq;

	}



}
