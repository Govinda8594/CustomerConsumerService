package com.customer.consumer.masking;

public interface Converter<I, O> {

  O convert(I input);
}
