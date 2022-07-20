package com.smbc.lad.dto.pipeline;

public class RequestFacilities {

	private int pipelineId;
	private int additionalFacilityId;
	private int sunId;
	private String borrowerName;
	private String facilities;
	private String unappliedCash;
	private String tenor;
	private String margin;
	private String drawnPricing;
	private String currentFacilityLimit;
	private String proposedFacilityLimit;
	private String outstandingAmount;
	private String maturityDate;
	private String facilityDescription;
	
	public int getPipelineId() {
		return pipelineId;
	}
	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}
	
	public int getAdditionalFacilityId() {
		return additionalFacilityId;
	}
	public void setAdditionalFacilityId(int additionalFacilityId) {
		this.additionalFacilityId = additionalFacilityId;
	}
	public int getSunId() {
		return sunId;
	}
	public void setSunId(int sunId) {
		this.sunId = sunId;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	public String getUnappliedCash() {
		return unappliedCash;
	}
	public void setUnappliedCash(String unappliedCash) {
		this.unappliedCash = unappliedCash;
	}
	public String getTenor() {
		return tenor;
	}
	public void setTenor(String tenor) {
		this.tenor = tenor;
	}
	public String getMargin() {
		return margin;
	}
	public void setMargin(String margin) {
		this.margin = margin;
	}
	public String getDrawnPricing() {
		return drawnPricing;
	}
	public void setDrawnPricing(String drawnPricing) {
		this.drawnPricing = drawnPricing;
	}
	public String getCurrentFacilityLimit() {
		return currentFacilityLimit;
	}
	public void setCurrentFacilityLimit(String currentFacilityLimit) {
		this.currentFacilityLimit = currentFacilityLimit;
	}
	public String getProposedFacilityLimit() {
		return proposedFacilityLimit;
	}
	public void setProposedFacilityLimit(String proposedFacilityLimit) {
		this.proposedFacilityLimit = proposedFacilityLimit;
	}
	public String getOutstandingAmount() {
		return outstandingAmount;
	}
	public void setOutstandingAmount(String outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}
	public String getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}
	
	public String getFacilityDescription() {
		return facilityDescription;
	}

	public void setFacilityDescription(String facilityDescription) {
		this.facilityDescription = facilityDescription;
	}
	
}
