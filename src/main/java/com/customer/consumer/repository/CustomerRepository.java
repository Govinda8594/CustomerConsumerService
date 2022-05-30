package com.customer.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.customer.publisher.domain.CustomerRequest;

@Repository
public interface CustomerRepository
		extends
			JpaRepository<CustomerRequest, Long> {

}
