package com.customer.consumer.service.impl;

import javax.persistence.RollbackException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.customer.consumer.audit.CustomerAuditLog;
import com.customer.consumer.audit.repo.CustomerAuditRepository;
import com.customer.consumer.domain.CustomerRequest;
import com.customer.consumer.domain.CustomerRequest.CustomerStatusEnum;
import com.customer.consumer.error.CustomerErrorLog;
import com.customer.consumer.error.repo.CustomerErrorRepository;
import com.customer.consumer.masking.CustomerMaskConverter;
import com.customer.consumer.repository.CustomerRepository;
import com.customer.consumer.service.ConsumerService;
import com.customer.publisher.kafka.dto.CustomerDto;

@Service
public class ConsumerServiceImpl implements ConsumerService {

  private static final Logger LOG = LoggerFactory.getLogger(ConsumerServiceImpl.class);

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private CustomerAuditRepository customerAuditRepository;

  @Autowired
  private CustomerErrorRepository customerErrorRepository;

  @Autowired
  CustomerMaskConverter customerMaskConverter;

  @Override
  @Transactional(rollbackFor = RollbackException.class)
  public void save(CustomerDto customerDto) {
    try {
      CustomerRequest customerRequest = new CustomerRequest();
      customerDto = customerMaskConverter.convert(customerDto);

      BeanUtils.copyProperties(customerDto, customerRequest);
      customerRequest
          .setCustomerStatus(CustomerStatusEnum.fromValue(customerDto.getCustomerStatus()));
      customerRequest = customerRepository.save(customerRequest);

      CustomerAuditLog auditLog = new CustomerAuditLog();
      auditLog.setCustomerNumber(customerRequest.getCustomerNumber());
      auditLog.setPayload(customerRequest.toString());
      auditLog = customerAuditRepository.save(auditLog);
      LOG.info("********CUSTOMER AUDIT LOG******* {}", auditLog.toString());

    } catch (Exception e) {
      e.printStackTrace();
      CustomerErrorLog customerErrorLog = new CustomerErrorLog();
      customerErrorLog.setErrorMsg(e.getLocalizedMessage());
      customerErrorLog.setErrorType(e.getClass().getSimpleName());
      customerErrorLog.setPayload(customerDto.toString());
      customerErrorLog = customerErrorRepository.save(customerErrorLog);
      LOG.info("********CUSTOMER ERROR LOG******* {}", customerErrorLog.toString());

    }

  }

}
