package com.customer.consumer.service.impl;

import javax.persistence.RollbackException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customer.consumer.audit.CustomerAuditLog;
import com.customer.consumer.audit.repo.CustomerAuditRepository;
import com.customer.consumer.error.CustomerErrorLog;
import com.customer.consumer.error.repo.CustomerErrorRepository;
import com.customer.consumer.repository.CustomerRepository;
import com.customer.consumer.service.ConsumerService;
import com.customer.publisher.domain.CustomerRequest;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerAuditRepository customerAuditRepository;

	@Autowired
	private CustomerErrorRepository customerErrorRepository;

	@Override
	@Transactional(rollbackFor = RollbackException.class)
	public void save(CustomerRequest customerRequest) {
		try {

			customerRequest = customerRepository.save(customerRequest);
			CustomerAuditLog auditLog = new CustomerAuditLog();
			auditLog.setCustomerNumber(customerRequest.getCustomerNumber());
			auditLog.setPayload(customerRequest.toString());

			customerAuditRepository.save(auditLog);

		} catch (Exception e) {
			e.printStackTrace();

			CustomerErrorLog customerErrorLog = new CustomerErrorLog();
			customerErrorLog.setErrorMsg(e.getLocalizedMessage());
			customerErrorLog.setErrorType(e.getClass().getSimpleName());
			customerErrorLog.setPayload(customerRequest.toString());
			customerErrorRepository.save(customerErrorLog);
			
		}

	}

}
