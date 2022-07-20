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
 * Entity class to read/update data from/to table 'pipeline_projections_comparison'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_projections_comparison")
public class ProjectionsComparisonEntity {

	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	@Column(name = "projections_chart_desc")
	private String projectionsChartDesc;
	
	@Column(name = "repayment_source")
	private String repaymentSource;
	
	@Column(name = "repayment_capacity")
	private String repaymentCapacity;
	
	@Column(name = "us_reg_lassification")
	private String usRegClassification;

	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getProjectionsChartDesc() {
		return projectionsChartDesc;
	}

	public void setProjectionsChartDesc(String projectionsChartDesc) {
		this.projectionsChartDesc = projectionsChartDesc;
	}

	public String getRepaymentSource() {
		return repaymentSource;
	}

	public void setRepaymentSource(String repaymentSource) {
		this.repaymentSource = repaymentSource;
	}

	public String getRepaymentCapacity() {
		return repaymentCapacity;
	}

	public void setRepaymentCapacity(String repaymentCapacity) {
		this.repaymentCapacity = repaymentCapacity;
	}

	public String getUsRegClassification() {
		return usRegClassification;
	}

	public void setUsRegClassification(String usRegClassification) {
		this.usRegClassification = usRegClassification;
	}
}

