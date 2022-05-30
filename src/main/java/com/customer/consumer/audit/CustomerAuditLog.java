package com.customer.consumer.audit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerAuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String customerNumber;

	@Column(columnDefinition = "TEXT", updatable = true)
	private String payload;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	// @Column(name = "created_date", updatable = false)
	// @Temporal(TemporalType.TIMESTAMP)
	// @CreatedDate
	// protected Date creationDate;
	//
	// @Column(name = "lastMod_date")
	// @LastModifiedDate
	// @Temporal(TemporalType.TIMESTAMP)
	// protected Date lastModifiedDate;
	//
	// @CreatedBy
	// @Column(name = "created_by")
	// protected T createdBy;
	//
	// @LastModifiedBy
	// @Column(name = "modified_by")
	// protected T modifiedBy;


}