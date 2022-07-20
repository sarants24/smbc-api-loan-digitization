package com.smbc.lad.dto.pipeline;

public class USRegulatory {
	
	private int id;
	private int pipelineId;
	private String regulatoryType;
	private String regulatoryDescription;
	private String regulatoryThreshold;
	private String actualsFYE;
	private String actualsValue;
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
	public void setRegulatoryType(String regulatoryType) {
		this.regulatoryType = regulatoryType;
	}
	public String getRegulatoryDescription() {
		return regulatoryDescription;
	}
	public void setRegulatoryDescription(String regulatoryDescription) {
		this.regulatoryDescription = regulatoryDescription;
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
