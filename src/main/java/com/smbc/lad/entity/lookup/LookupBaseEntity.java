package com.smbc.lad.entity.lookup;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * Base Entity class for Lookup Tables'
 *
 */
@MappedSuperclass
public class LookupBaseEntity {
	
	@Column(name = "description")
	private String description;

	@Column(name = "order_sequence")
	private String orderSequence;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrderSequence() {
		return orderSequence;
	}

	public void setOrderSequence(String orderSequence) {
		this.orderSequence = orderSequence;
	}
}
