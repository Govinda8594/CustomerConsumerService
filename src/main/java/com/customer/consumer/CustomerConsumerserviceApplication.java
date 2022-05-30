package com.customer.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EnableJpaRepositories({"com.customer.consumer.*"})
@EntityScan({"com.customer.publisher.*","com.customer.consumer.error","com.customer.consumer.audit"})
public class CustomerConsumerserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerConsumerserviceApplication.class, args);
	}

}
