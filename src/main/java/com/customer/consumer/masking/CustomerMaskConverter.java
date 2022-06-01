package com.customer.consumer.masking;

import org.springframework.stereotype.Component;
import com.customer.publisher.kafka.dto.CustomerDto;

@Component
public class CustomerMaskConverter implements Converter<CustomerDto, CustomerDto> {

  @Override
  public CustomerDto convert(CustomerDto customerDto) {

    String maskedEmailId = customerDto.getEmail().replaceAll(MaskingRegex.EMAIL_REGEX, "*");
    String maskedCrn =
        customerDto.getCustomerNumber().replaceAll(MaskingRegex.CUST_NUMBER_REGEX, "*");
    String maskedBirthDate = customerDto.getBirthdate().replaceAll(MaskingRegex.PRE_REGEX, "")
        .replaceAll(MaskingRegex.BIRTH_DATE_REGEX, "*");
    customerDto.setBirthdate(maskedBirthDate);
    customerDto.setEmail(maskedEmailId);
    customerDto.setCustomerNumber(maskedCrn);
    return customerDto;
  }

}
