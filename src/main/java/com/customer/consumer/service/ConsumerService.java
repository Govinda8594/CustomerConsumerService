package com.customer.consumer.service;

import com.customer.publisher.kafka.dto.CustomerDto;

public interface ConsumerService {
	void save(CustomerDto customerDto);

}
