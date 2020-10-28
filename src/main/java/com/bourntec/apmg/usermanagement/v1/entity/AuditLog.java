package com.bourntec.apmg.usermanagement.v1.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(indexName = "audit_log")
public class AuditLog {
	@Id
	private String id;

	private String moduleName;

	private String subModuleName;

	private String userId;

	private String action;

	private String actionMessage;

	private String oldObject;

	private String newObject;

	private String primaryKey;

	private String cretaedDateTime;

	public AuditLog toModel(String logMessage) {
		ObjectMapper objectMapper = new ObjectMapper();
		AuditLog auditLog = new AuditLog();
		try {
			auditLog = objectMapper.readValue(logMessage, AuditLog.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return auditLog;
	}

}
