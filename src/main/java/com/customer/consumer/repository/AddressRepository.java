package com.customer.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.customer.consumer.domain.AddressRequest;

@Repository
public interface AddressRepository extends JpaRepository<AddressRequest, Long> {

}
