package com.customer.consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.customer.consumer.domain.AddressRequest;
import com.customer.consumer.domain.CustomerRequest;
import com.customer.consumer.domain.CustomerRequest.CustomerStatusEnum;
import com.customer.consumer.repository.AddressRepository;
import com.customer.consumer.repository.CustomerRepository;
import com.customer.consumer.service.ConsumerService;

@SpringBootTest
class CustomerConsumerserviceApplicationTests {

	@Autowired
	private ConsumerService customerService;

	@MockBean
	private CustomerRepository customerRepository;

	@MockBean
	private AddressRepository addressRepository;

	@Test
	public void getCustomerTest() {
		when(customerRepository.findAll()).thenReturn(Stream.of(
				new CustomerRequest(1L, "C0001", "Govinda", "kanojiya",
						"08-05-1994", "India", "+91", "57464433433",
						"sdsad@gmail.com", CustomerStatusEnum.RESTORED,
						new AddressRequest(1L, "sdfsdf", "fsdf", "sadsad",
								"5575", 1L)),
				new CustomerRequest(2L, "C0002", "Abhey", "Kishi",
						"08-05-1994",
						"India"
						, "+91", "57464433243", "sffsdfad@gmail.com",
						CustomerStatusEnum.RESTORED,
						new AddressRequest(2L, "sdfsdf", "fsdf", "sadsad",
								"5575", 2L)),
				new CustomerRequest(3L, "C0003", "Vishal", "Kumar",
						"08-05-1994",
						"India"
						, "+91", "57464433433", "sdsad@gmail.com",
						CustomerStatusEnum.RESTORED, new AddressRequest(3L,
								"sdfsdf", "fsdf", "sadsad", "5575", 3L)))
				.collect(Collectors.toList()));
		assertEquals(3, customerRepository.findAll().size());
	}

	@Test
	public void getAddressTest() {
		when(addressRepository.findAll()).thenReturn(Stream.of(
				new AddressRequest(1L, "sdfsdf", "fsdf", "sadsad", "5575", 1L),
				new AddressRequest(2L, "sdfsdf", "fsdf", "sadsad", "5575", 2L),
				new AddressRequest(3L, "sdfsdf", "fsdf", "sadsad", "5575", 3L))
				.collect(Collectors.toList()));
		assertEquals(3, addressRepository.findAll().size());
	}

	@Test
	public void saveCustomertest() {
		CustomerRequest customerRequest = new CustomerRequest(3L, "C0003",
				"Vishal", "Kumar", "08-05-1994", "India", "+91",
				"57464433433", "sdsad@gmail.com", CustomerStatusEnum.RESTORED,
				new AddressRequest(3L, "sdfsdf", "fsdf", "sadsad", "5575", 3L));
		
		when(customerRepository.save(customerRequest)).thenReturn(customerRequest);
		assertEquals(customerRequest, customerRepository.save(customerRequest));
	}

	@Test
	public void deleteCustomer() {
		CustomerRequest customerRequest = new CustomerRequest(3L, "C0003", "Vishal", "Kumar",
				"08-05-1994",
				"India"
				, "+91", "57464433433", "sdsad@gmail.com",
				CustomerStatusEnum.RESTORED, new AddressRequest(3L,
						"sdfsdf", "fsdf", "sadsad", "5575", 3L));
		customerRepository.delete(customerRequest);
		verify(customerRepository, timeout(1)).delete(customerRequest);
	}

}
