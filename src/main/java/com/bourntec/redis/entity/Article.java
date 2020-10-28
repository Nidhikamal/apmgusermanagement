package com.bourntec.redis.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(indexName = "audit_log")//, type = "book")
public class Article {

	@Id
	private String id;
	
	private String moduleName;
	
	private String subModuleName;
	
	private String userId;
	
	private String action;
	
	private String action_message;
	
	private String oldObject;
	
	private String newObject;
	
	private String primaryKey;
		
	private Date createdDateTime;

}
