package com.customer.consumer.masking;

public class MaskingRegex {

  public final static String EMAIL_REGEX = "(?<=^.{0,3}).";
  public final static String CUST_NUMBER_REGEX = "\\w(?!\\w{4})";
  public final static String BIRTH_DATE_REGEX = "\\d(?=\\d{4})";
  public final static String PRE_REGEX = "[^0-9]";
}
