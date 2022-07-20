package com.smbc.lad.entity.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
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
 * Entity class to read/update data from/to table 'lk_employee_master' and 'lk_cdad_approving_officer
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "lk_employee_master")
@org.hibernate.annotations.Table(appliesTo = "lk_cdad_approving_officer", optional=false)
@SecondaryTable(name = "lk_cdad_approving_officer", pkJoinColumns = @PrimaryKeyJoinColumn(name ="officer_code"))
public class CDADOfficerEntity {
	
	@Id
	@Column(name = "code")
	private int code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "order_sequence")
	private String orderSequence;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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
