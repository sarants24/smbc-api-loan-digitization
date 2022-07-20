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
 * Entity class to read/update data from/to table 'pipeline_primary_request_facility'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_primary_request_facility")
public class RequestFacilityEntity extends RequestFacilityBaseEntity{

	//pipeline_deals_parentinfo
	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	@Column(name = "facility_description")
	private String facilityDescription;

	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getFacilityDescription() {
		return facilityDescription;
	}

	public void setFacilityDescription(String facilityDescription) {
		this.facilityDescription = facilityDescription;
	}
	
}
