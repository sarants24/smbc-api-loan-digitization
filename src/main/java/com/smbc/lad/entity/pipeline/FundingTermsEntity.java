package com.smbc.lad.entity.pipeline;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.smbc.lad.entity.lookup.CurrencyEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * Entity class to read/update data from/to table 'pilpeline_deals_credit_inquiry'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_funding_notice_files")
public class FundingTermsEntity {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	@Column(name = "currency_code")
	private String currencyCode;
	
	@Column(name = "total_amount")
	private String totalAmount;
	
	@Column(name = "funding_type")
	private String fundingType;

	@Column(name = "days")
	private String days;
	
	@Column(name = "notice_time")
	private String noticeTime;
	
	@OneToOne
	@JoinColumn(name = "currency_code", referencedColumnName="id",insertable = false,updatable = false)
	private CurrencyEntity currencyEntity;

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

	public CurrencyEntity getCurrencyEntity() {
		return currencyEntity;
	}

	public void setCurrencyEntity(CurrencyEntity currencyEntity) {
		this.currencyEntity = currencyEntity;
	}	
}

