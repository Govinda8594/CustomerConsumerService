package com.customer.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.customer.consumer.masking.MaskingUtils;
import com.customer.consumer.service.ConsumerService;
import com.customer.publisher.domain.CustomerRequest;

@Configuration
public class ConsumerListner {

	private static final Logger LOG = LoggerFactory
			.getLogger(ConsumerListner.class);

	@Autowired
	private ConsumerService consumerService;

	@KafkaListener(groupId = "customer-1", topics = "customer-2", containerFactory = "concurrentKafkaListenerContainerFactory")
	private void getJsonMessageFormTopic(@Payload CustomerRequest customer,
			Acknowledgment acknowledgment) throws Exception {
		LOG.info("Kafak Listener Jsonbody{}", customer);
		customer.setEmail(MaskingUtils.maskEmailId(customer.getEmail()));
		customer.setBirthdate(
				MaskingUtils.maskBirthdate(customer.getBirthdate()));
		customer.setCustomerNumber(
				MaskingUtils.maskCustomerNumber(customer.getCustomerNumber()));
		acknowledgment.acknowledge();

      if(customer != null)
		consumerService.save(customer);
	}

	@KafkaListener(groupId = "customer", topics = "customer-1", containerFactory = "concurrentKafkaListenerStringContainerFactory")
	private void getstringMessageFormTopic(String customer) {
		LOG.info("InConumerService {}", customer);
	}

}
