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
 * Entity class to read data from table 'lk_application_status'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "lk_company")
public class CompanyEntity {
	
	@Id
	@Column(name = "smun_id")
	private String smunId;
	
	@Column(name = "company_name")
	private String companyName;

	@Column(name = "order_sequence")
	private String orderSequence;
	
	public String getSmunId() {
		return smunId;
	}

	public void setSmunId(String smunId) {
		this.smunId = smunId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOrderSequence() {
		return orderSequence;
	}

	public void setOrderSequence(String orderSequence) {
		this.orderSequence = orderSequence;
	}
		
}
