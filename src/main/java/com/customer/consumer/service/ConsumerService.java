package com.customer.consumer.service;

import com.customer.publisher.domain.CustomerRequest;

public interface ConsumerService {
	void save(CustomerRequest customerRequest);

}
