package com.smbc.lad.entity.pipeline;

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
 * Entity class to read/update data from/to table 'pipeline_deals_borrowerinfo'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipelinedeals_primary_borrowerinfo")
public class BorrowerInformationEntity extends BorrowerInfoBaseEntity{

	//pipeline_deals_parentinfo
	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;

	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}
	
}
