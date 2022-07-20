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
 * Entity class to read/update data from/to table 'pipeline_deals'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_industry_trends")
//@SecondaryTable(name = "")
public class IndustryTrendsEntity {

	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	@Column(name = "parent_borrower_description")
	private String parentBorrowerDescription;
	
	@Column(name = "management_assessment")
	private String managementAssessment;
	
	@Column(name = "industrial_trends")
	private String industryTrends;

	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getParentBorrowerDescription() {
		return parentBorrowerDescription;
	}

	public void setParentBorrowerDescription(String parentBorrowerDescription) {
		this.parentBorrowerDescription = parentBorrowerDescription;
	}

	public String getManagementAssessment() {
		return managementAssessment;
	}

	public void setManagementAssessment(String managementAssessment) {
		this.managementAssessment = managementAssessment;
	}

	public String getIndustryTrends() {
		return industryTrends;
	}

	public void setIndustryTrends(String industryTrends) {
		this.industryTrends = industryTrends;
	}
}

