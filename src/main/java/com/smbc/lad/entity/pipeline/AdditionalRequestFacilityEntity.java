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
 * Entity class to read/update data from/to table 'pipeline_additional_request_facility'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_additional_request_facility")
public class AdditionalRequestFacilityEntity extends RequestFacilityBaseEntity {

	//pipeline_deals_parentinfo
	@Id
	@Column(name = "additional_facility_id")
	private int additionalFacilityId;
	
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	//pipeline_deals_credit
	@Column(name = "current_facility_limit")
	private String currentFacilityLimit;
	
	@Column(name = "proposed_facility_limit")
	private String proposedFacilityLimit;

	public int getAdditionalFacilityId() {
		return additionalFacilityId;
	}

	public void setAdditionalFacilityId(int additionalFacilityId) {
		this.additionalFacilityId = additionalFacilityId;
	}

	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getCurrentFacilityLimit() {
		return currentFacilityLimit;
	}

	public void setCurrentFacilityLimit(String currentFacilityLimit) {
		this.currentFacilityLimit = currentFacilityLimit;
	}

	public String getProposedFacilityLimit() {
		return proposedFacilityLimit;
	}

	public void setProposedFacilityLimit(String proposedFacilityLimit) {
		this.proposedFacilityLimit = proposedFacilityLimit;
	}
	
			
}
