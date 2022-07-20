package com.smbc.lad.entity.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * Entity class to read data from table 'lk_sponsors'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "lk_sponsors")
public class SponsorsEntity {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "order_sequence")
	private String orderSequence;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrderSequence() {
		return orderSequence;
	}

	public void setOrderSequence(String orderSequence) {
		this.orderSequence = orderSequence;
	}
	
}
