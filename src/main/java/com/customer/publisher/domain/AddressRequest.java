package com.customer.publisher.domain;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class AddressRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	private String addressLine1 = null;

	private String addressLine2 = null;

	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private CustomerRequest customerRequest;

	private String street = null;

	private String postalCode = null;

	public AddressRequest id(Long id) {
		this.id = id;
		return this;
	}

	public AddressRequest() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AddressRequest addressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
		return this;
	}
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public AddressRequest addressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
		return this;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public AddressRequest street(String street) {
		this.street = street;
		return this;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public AddressRequest postalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public AddressRequest(Long id, String addressLine1, String addressLine2,
			String street, String postalCode, Long customerid) {
		super();
		this.id = id;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.street = street;
		this.postalCode = postalCode;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AddressRequest address = (AddressRequest) o;
		return Objects.equals(this.id, address.id)
				&& Objects.equals(this.addressLine1, address.addressLine1)
				&& Objects.equals(this.addressLine2, address.addressLine2)
				&& Objects.equals(this.street, address.street)
				&& Objects.equals(this.postalCode, address.postalCode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, addressLine1, addressLine2, street, postalCode);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Address {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    addressLine1: ").append(toIndentedString(addressLine1))
				.append("\n");
		sb.append("    addressLine2: ").append(toIndentedString(addressLine2))
				.append("\n");
		sb.append("    street: ").append(toIndentedString(street)).append("\n");
		sb.append("    postalCode: ").append(toIndentedString(postalCode))
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
