package com.customer.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import com.customer.consumer.service.ConsumerService;
import com.customer.publisher.kafka.dto.CustomerDto;

@Configuration
public class ConsumerListner {

  private static final Logger LOG = LoggerFactory.getLogger(ConsumerListner.class);

  @Autowired
  private ConsumerService consumerService;

  @KafkaListener(groupId = "customer-1", topics = "customer-2",
      containerFactory = "concurrentKafkaListenerContainerFactory")
  private void getJsonMessageFormTopic(@Payload CustomerDto customer, Acknowledgment acknowledgment)
      throws Exception {
    LOG.info("*****From Kafak Listener Jsonbody*******{}", customer);
    acknowledgment.acknowledge();
    if (customer != null)
      consumerService.save(customer);
  }
}
