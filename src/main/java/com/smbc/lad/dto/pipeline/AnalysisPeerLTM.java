package com.smbc.lad.dto.pipeline;

import java.util.List;

public class AnalysisPeerLTM {
	
	private int pipelineId;
	private String peerAnalysis;
	private String longTermAnalysis;
	private String analysisComparison;
	private List<FileData> fileData;
	private int[] filesToDeleteIds;
	
	public int getPipelineId() {
		return pipelineId;
	}
	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}
	public String getPeerAnalysis() {
		return peerAnalysis;
	}
	public void setPeerAnalysis(String peerAnalysis) {
		this.peerAnalysis = peerAnalysis;
	}
	public String getLongTermAnalysis() {
		return longTermAnalysis;
	}
	public void setLongTermAnalysis(String longTermAnalysis) {
		this.longTermAnalysis = longTermAnalysis;
	}
	public String getAnalysisComparison() {
		return analysisComparison;
	}
	public void setAnalysisComparison(String analysisComparison) {
		this.analysisComparison = analysisComparison;
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
