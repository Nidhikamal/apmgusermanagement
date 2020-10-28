package com.bourntec.apmg.usermanagement.v1.queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bourntec.apmg.usermanagement.v1.entity.AuditLog;
import com.bourntec.apmg.usermanagement.v1.repository.AuditLogRepository;

public class RedisMessageSubscriber {
	private static final Logger LOGGER = LogManager.getLogger(RedisMessageSubscriber.class);

	@Autowired
	private AuditLogRepository auditLogRepository;

	public void receiveMessage(String message) throws Exception {
		LOGGER.info("Message Received from channel: <" + message + ">");
		persistElastic(message);
	}

	private void persistElastic(String logMessage) {
		AuditLog auditLog = new AuditLog();
		try {
			AuditLog auditLogObj = auditLog.toModel(logMessage);
			//auditLogObj.setCretaedDateTime("");
			AuditLog log = auditLogRepository.save(auditLogObj);
			LOGGER.info("Persist to AuditLog" + log + ">");
		} catch (Exception e) {
			LOGGER.info("couldnot Persist to AuditLog: " + e.getMessage());
		}
	}
}
