package com.smbc.lad.dto.pipeline;

import java.util.List;

public class ProjectionsComparison {
	
	private int pipelineId;
	private String projectionsChartDesc;
	private String repaymentSource;
	private String repaymentCapacity;
	private String usRegClassification;
	private String parentUSRegProposed;
	private List<USRegulatory> usRegulatoryList;
	
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
	
	public List<USRegulatory> getUsRegulatoryList() {
		return usRegulatoryList;
	}

	public void setUsRegulatoryList(List<USRegulatory> usRegulatoryList) {
		this.usRegulatoryList = usRegulatoryList;
	}
	public String getParentUSRegProposed() {
		return parentUSRegProposed;
	}
	public void setParentUSRegProposed(String parentUSRegProposed) {
		this.parentUSRegProposed = parentUSRegProposed;
	}
}
