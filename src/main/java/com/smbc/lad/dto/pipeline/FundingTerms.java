package com.smbc.lad.dto.pipeline;

public class FundingTerms {

	private int id;
	private int pipelineId;
	private String currencyCode;
	private String currencyDescription;
	private String totalAmount;
	private String fundingType;
	private String days;
	private String noticeTime;
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
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCurrencyDescription() {
		return currencyDescription;
	}
	public void setCurrencyDescription(String currencyDescription) {
		this.currencyDescription = currencyDescription;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getFundingType() {
		return fundingType;
	}
	public void setFundingType(String fundingType) {
		this.fundingType = fundingType;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getNoticeTime() {
		return noticeTime;
	}
	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}	
}
