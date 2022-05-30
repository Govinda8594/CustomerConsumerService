package com.customer.consumer.audit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.consumer.audit.CustomerAuditLog;

@Repository("customerAuditRepository")
public interface CustomerAuditRepository
		extends
			JpaRepository<CustomerAuditLog, Long> {

}
