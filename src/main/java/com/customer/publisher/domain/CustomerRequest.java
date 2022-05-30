package com.customer.publisher.domain;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Entity
@Table(name = "customer")
public class CustomerRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	private String customerNumber = null;

	private String firstName = null;

	private String lastName = null;

	private String birthdate = null;

	private String country = null;

	private String countryCode = null;

	private String mobileNumber = null;

	private String email = null;

	/**
	 * Customer Status
	 */
	public enum CustomerStatusEnum {
		RESTORED("Restored"),

		SUSPENDED("Suspended"),

		OPEN("Open"),

		CLOSED("Closed");

		private String value;

		CustomerStatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static CustomerStatusEnum fromValue(String text) {
			for (CustomerStatusEnum b : CustomerStatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}
	@Enumerated(EnumType.STRING)
	private CustomerStatusEnum customerStatus = null;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private AddressRequest address = null;

	public CustomerRequest id(Long id) {
		this.id = id;
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerRequest customerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
		return this;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public CustomerRequest firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public CustomerRequest() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public CustomerRequest lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CustomerRequest birthdate(String birthdate) {
		this.birthdate = birthdate;
		return this;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public CustomerRequest country(String country) {
		this.country = country;
		return this;
	}
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public CustomerRequest countryCode(String countryCode) {
		this.countryCode = countryCode;
		return this;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public CustomerRequest mobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public CustomerRequest email(String email) {
		this.email = email;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerRequest customerStatus(CustomerStatusEnum customerStatus) {
		this.customerStatus = customerStatus;
		return this;
	}

	public CustomerStatusEnum getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(CustomerStatusEnum customerStatus) {
		this.customerStatus = customerStatus;
	}

	public CustomerRequest address(AddressRequest address) {
		this.address = address;
		return this;
	}

	public AddressRequest getAddress() {
		return address;
	}

	public void setAddress(AddressRequest address) {
		this.address = address;
	}

	public CustomerRequest(Long id, String customerNumber, String firstName,
			String lastName, String birthdate, String country,
			String countryCode, String mobileNumber, String email,
			CustomerStatusEnum customerStatus, AddressRequest address) {
		super();
		this.id = id;
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.country = country;
		this.countryCode = countryCode;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.customerStatus = customerStatus;
		this.address = address;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CustomerRequest customer = (CustomerRequest) o;
		return Objects.equals(this.id, customer.id)
				&& Objects.equals(this.customerNumber, customer.customerNumber)
				&& Objects.equals(this.firstName, customer.firstName)
				&& Objects.equals(this.lastName, customer.lastName)
				&& Objects.equals(this.birthdate, customer.birthdate)
				&& Objects.equals(this.country, customer.country)
				&& Objects.equals(this.countryCode, customer.countryCode)
				&& Objects.equals(this.mobileNumber, customer.mobileNumber)
				&& Objects.equals(this.email, customer.email)
				&& Objects.equals(this.customerStatus, customer.customerStatus)
				&& Objects.equals(this.address, customer.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, customerNumber, firstName, lastName, birthdate,
				country, countryCode, mobileNumber, email, customerStatus,
				address);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Customer {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    customerNumber: ")
				.append(toIndentedString(customerNumber)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName))
				.append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName))
				.append("\n");
		sb.append("    birthdate: ").append(toIndentedString(birthdate))
				.append("\n");
		sb.append("    country: ").append(toIndentedString(country))
				.append("\n");
		sb.append("    countryCode: ").append(toIndentedString(countryCode))
				.append("\n");
		sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber))
				.append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    customerStatus: ")
				.append(toIndentedString(customerStatus)).append("\n");
		sb.append("    address: ").append(toIndentedString(address))
				.append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
