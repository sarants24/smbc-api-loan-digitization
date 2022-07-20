package com.smbc.lad.dto.pipeline;

public class CapitalRequestExposure {

	private int id;
	private int pipelineId;
	private String facilityDescription;
	private String maturityDescription;
	private String smbcCommitment;
	private String facilityLevelRarora;
	private String createdTimestamp;
	
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
	public String getFacilityDescription() {
		return facilityDescription;
	}
	public void setFacilityDescription(String facilityDescription) {
		this.facilityDescription = facilityDescription;
	}
	public String getMaturityDescription() {
		return maturityDescription;
	}
	public void setMaturityDescription(String maturityDescription) {
		this.maturityDescription = maturityDescription;
	}
	public String getSmbcCommitment() {
		return smbcCommitment;
	}
	public void setSmbcCommitment(String smbcCommitment) {
		this.smbcCommitment = smbcCommitment;
	}
	public String getFacilityLevelRarora() {
		return facilityLevelRarora;
	}
	public void setFacilityLevelRarora(String facilityLevelRarora) {
		this.facilityLevelRarora = facilityLevelRarora;
	}
	public String getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(String createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	
}
