package com.bourntec.apmg.usermanagement.v1.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.usermanagement.v1.entity.AuditLog;

@Repository
public interface AuditLogRepository extends ElasticsearchRepository<AuditLog, String> {

    

}