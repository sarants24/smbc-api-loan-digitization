package com.smbc.lad.dto.pipeline;

import java.util.List;

public class FundingNotice {

	private int pipelineId;
	private String fundingNotes;
	private String tsdApproval;
	private String spdgpApproval;
	private List<FundingTerms> fundingTerms;
	private int[] filesToDeleteIds;
	
	public int getPipelineId() {
		return pipelineId;
	}
	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}
	public String getFundingNotes() {
		return fundingNotes;
	}
	public String getTsdApproval() {
		return tsdApproval;
	}
	public void setTsdApproval(String tsdApproval) {
		this.tsdApproval = tsdApproval;
	}
	public String getSpdgpApproval() {
		return spdgpApproval;
	}
	public void setSpdgpApproval(String spdgpApproval) {
		this.spdgpApproval = spdgpApproval;
	}
	public void setFundingNotes(String fundingNotes) {
		this.fundingNotes = fundingNotes;
	}
	public List<FundingTerms> getFundingTerms() {
		return fundingTerms;
	}
	public void setFundingTerms(List<FundingTerms> fundingTerms) {
		this.fundingTerms = fundingTerms;
	}
	public int[] getFilesToDeleteIds() {
		return filesToDeleteIds;
	}
	public void setFilesToDeleteIds(int[] filesToDeleteIds) {
		this.filesToDeleteIds = filesToDeleteIds;
	}
	
		
}
