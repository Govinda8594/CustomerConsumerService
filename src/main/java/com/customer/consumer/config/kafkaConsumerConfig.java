package com.customer.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties.AckMode;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.customer.publisher.domain.CustomerRequest;

@Configuration
@EnableKafka
public class kafkaConsumerConfig {

	@Bean
	public ConsumerFactory<String, CustomerRequest> consumerFactory() {
		Map<String, Object> configProperties = new HashMap<>();

		configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
				"localhost:9092");
		configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				StringDeserializer.class);
		configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				JsonDeserializer.class);
		configProperties.put(ConsumerConfig.GROUP_ID_CONFIG,
				"customer-1");
		configProperties.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		configProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,
				"earliest");
		return new DefaultKafkaConsumerFactory<>(configProperties);

	}

	@Bean
	public ConsumerFactory<String, String> consumerStringFactory() {
		Map<String, Object> configProperties = new HashMap<>();

		configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
				"localhost:9092");
		configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				StringDeserializer.class);
		configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				StringDeserializer.class);
		configProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "customer");
		return new DefaultKafkaConsumerFactory<>(configProperties);

	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, CustomerRequest> concurrentKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, CustomerRequest> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
		concurrentKafkaListenerContainerFactory
				.setConsumerFactory(consumerFactory());
		concurrentKafkaListenerContainerFactory.getContainerProperties()
				.setAckMode(AckMode.MANUAL);
		return concurrentKafkaListenerContainerFactory;
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerStringContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
		concurrentKafkaListenerContainerFactory
				.setConsumerFactory(consumerStringFactory());
		return concurrentKafkaListenerContainerFactory;
	}

}
