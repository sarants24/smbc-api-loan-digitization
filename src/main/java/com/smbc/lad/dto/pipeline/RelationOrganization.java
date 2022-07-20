package com.smbc.lad.dto.pipeline;

import java.util.List;

public class RelationOrganization {

	private int pipelineId;
	private String relationSummary;
	private String organizationSummary;
	private List<FileData> fileData;
	private int[] filesToDeleteIds;
	
	
	public int getPipelineId() {
		return pipelineId;
	}
	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}
	public String getRelationSummary() {
		return relationSummary;
	}
	public void setRelationSummary(String relationSummary) {
		this.relationSummary = relationSummary;
	}
	public String getOrganizationSummary() {
		return organizationSummary;
	}
	public void setOrganizationSummary(String organizationSummary) {
		this.organizationSummary = organizationSummary;
	}
	public List<FileData> getFileData() {
		return fileData;
	}
	public void setFileData(List<FileData> fileData) {
		this.fileData = fileData;
	}
	public int[] getFilesToDeleteIds() {
		return filesToDeleteIds;
	}
	public void setFilesToDeleteIds(int[] filesToDeleteIds) {
		this.filesToDeleteIds = filesToDeleteIds;
	}
	
}
