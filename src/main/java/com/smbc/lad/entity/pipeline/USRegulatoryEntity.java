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
 * @since May 2022
 * 
 * Entity class to read/update data from/to table 'pipeline_analysis_peer_ltm'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_us_regulatory_chart")
public class USRegulatoryEntity {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "pipeline_id")
	private int pipelineId;

	@Column(name = "regulatory_type")
	private String regulatoryType;
	
	@Column(name = "regulatory_desc")
	private String regulatoryDescription;

	@Column(name = "regulatory_threshold")
	private String regulatoryThreshold;

	@Column(name = "actuals_fye")
	private String actualsFYE;
	
	@Column(name = "actuals_value")
	private String actualsValue;
	
	@Column(name = "comments")
	private String comments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getRegulatoryType() {
		return regulatoryType;
	}
	
	public String getRegulatoryDescription() {
		return regulatoryDescription;
	}

	public void setRegulatoryDescription(String regulatoryDescription) {
		this.regulatoryDescription = regulatoryDescription;
	}

	public void setRegulatoryType(String regulatoryType) {
		this.regulatoryType = regulatoryType;
	}

	public String getRegulatoryThreshold() {
		return regulatoryThreshold;
	}

	public void setRegulatoryThreshold(String regulatoryThreshold) {
		this.regulatoryThreshold = regulatoryThreshold;
	}

	public String getActualsFYE() {
		return actualsFYE;
	}

	public void setActualsFYE(String actualsFYE) {
		this.actualsFYE = actualsFYE;
	}

	public String getActualsValue() {
		return actualsValue;
	}

	public void setActualsValue(String actualsValue) {
		this.actualsValue = actualsValue;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}

