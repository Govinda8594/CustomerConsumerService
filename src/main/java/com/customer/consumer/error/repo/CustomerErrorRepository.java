package com.customer.consumer.error.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.consumer.error.CustomerErrorLog;

@Repository("customerErrorRepository")
public interface CustomerErrorRepository
		extends
			JpaRepository<CustomerErrorLog, Long> {

}
