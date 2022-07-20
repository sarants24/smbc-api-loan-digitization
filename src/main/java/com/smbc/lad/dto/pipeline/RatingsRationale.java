package com.smbc.lad.dto.pipeline;

public class RatingsRationale {
	
	private int pipelineId;
	private String smbcObligorRating;
	private String rationaleToSupport;
	private String riskAppetite;
	private String basicStrategy;
	private String actionPlan;
	
	public int getPipelineId() {
		return pipelineId;
	}
	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}
	public String getSmbcObligorRating() {
		return smbcObligorRating;
	}
	public void setSmbcObligorRating(String smbcObligorRating) {
		this.smbcObligorRating = smbcObligorRating;
	}
	public String getRationaleToSupport() {
		return rationaleToSupport;
	}
	public void setRationaleToSupport(String rationaleToSupport) {
		this.rationaleToSupport = rationaleToSupport;
	}
	public String getRiskAppetite() {
		return riskAppetite;
	}
	public void setRiskAppetite(String riskAppetite) {
		this.riskAppetite = riskAppetite;
	}
	public String getBasicStrategy() {
		return basicStrategy;
	}
	public void setBasicStrategy(String basicStrategy) {
		this.basicStrategy = basicStrategy;
	}
	public String getActionPlan() {
		return actionPlan;
	}
	public void setActionPlan(String actionPlan) {
		this.actionPlan = actionPlan;
	}
}
