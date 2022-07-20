package com.smbc.lad.entity.pipeline;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.smbc.lad.entity.lookup.BaseRateEntity;
import com.smbc.lad.entity.lookup.TiersEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * Entity class to read/update data from/to table 'pipeline_capital_request_form'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_capital_request_form")
public class CapitalRequestFormEntity {

	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;

	@Column(name = "sun_id")
	private String sunId;
	
	@Column(name = "credit_contact")
	private String creditContactName;
	
	@Column(name = "adjusted_obligor_grade")
	private String adjustedObligorGrade;

	@Column(name = "downgrade_trigger")
	private String downgradeTrigger;

	@Column(name = "primary_smics")
	private String primarySmics;

	@Column(name = "base_rate")
	private String baseRate;

	@Column(name = "currency_days")
	private String currencyDays;

	@Column(name = "currency_time")
	private String currencyTime;

	@Column(name = "pmg_deadline")
	private Date pmgDeadline;

	@Column(name = "external_deadline")
	private Date externalDeadline;

	@Column(name = "same_day_funding")
	private String sameDayFunding;

	@Column(name = "agent_notice_message")
	private Date agentNoticeMessage;

	@Column(name = "group_exposure")
	private String groupExposure;

	@Column(name = "cdad_watchlist")
	private String cdadWatchlist;

	@Column(name = "interest_period")
	private String interestPeriod;

	@Column(name = "commitment_change_sign")
	private String commitmentChangeSign;
	
	@Column(name = "commitment_change")
	private String commitmentChange;

	@Column(name = "request_in_line")
	private String requestInLine;

	@Column(name = "existing_tiers")
	private String existingTiers;

	@Column(name = "projected_tiers")
	private String projectedTiers;

	@Column(name = "rarora_projected_group")
	private String raroraProjectedGroup;

	@Column(name = "extended_floor")
	private String extendedFloor;

	@Column(name = "company_description")
	private String companyDescription;

	@Column(name = "request_description")
	private String requestDescription;

	@Column(name = "credit_metrics")
	private String creditMetrics;

	@Column(name = "lenders_group")
	private String lendersGroup;

	@Column(name = "lcm_commentary")
	private String lcmCommentary;

	@Column(name = "related_exposure")
	private String relatedExposure;

	@Column(name = "facility_metrics_description")
	private String facilityMetrics;

	@Column(name = "business_decision_rationale")
	private String businessDecisionRationale;

	@Column(name = "dcm_signoff")
	private String dcmSignoff;

	@Column(name = "dcm_projected_total")
	private String dcmProjectedTotal;

	@Column(name = "dcm_comments")
	private String dcmComments;

	@Column(name = "derivatives_signoff")
	private String derivativesSignoff;

	@Column(name = "derivatives_projected_total")
	private String derivativesProjectedTotal;

	@Column(name = "derivatives_comments")
	private String derivativesComments;

	@Column(name = "deposit_signoff")
	private String depositSignoff;

	@Column(name = "deposit_projected_total")
	private String depositProjectedTotal;

	@Column(name = "deposit_comments")
	private String depositComments;

	@Column(name = "ecm_signoff")
	private String ecmSignoff;

	@Column(name = "ecm_projected_total")
	private String ecmProjectedTotal;

	@Column(name = "ecm_comments")
	private String ecmComments;

	@Column(name = "fx_signoff")
	private String fxSignoff;

	@Column(name = "fx_projected_total")
	private String fxProjectedTotal;

	@Column(name = "fx_comments")
	private String fxComments;

	@Column(name = "product_overall_total")
	private String productOverallTotal;
	
	@OneToOne
	@JoinColumn(name = "base_rate", referencedColumnName="id",insertable = false,updatable = false)
	private BaseRateEntity baseRateEntity;
	
	@OneToOne
	@JoinColumn(name = "existing_tiers", referencedColumnName="id",insertable = false,updatable = false)
	private TiersEntity existingTiersEntity;
	
	@OneToOne
	@JoinColumn(name = "projected_tiers", referencedColumnName="id",insertable = false,updatable = false)
	private TiersEntity projectedTiersEntity;

	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getSunId() {
		return sunId;
	}

	public void setSunId(String sunId) {
		this.sunId = sunId;
	}

	public String getCreditContactName() {
		return creditContactName;
	}

	public void setCreditContactName(String creditContactName) {
		this.creditContactName = creditContactName;
	}

	public String getAdjustedObligorGrade() {
		return adjustedObligorGrade;
	}

	public void setAdjustedObligorGrade(String adjustedObligorGrade) {
		this.adjustedObligorGrade = adjustedObligorGrade;
	}

	public String getDowngradeTrigger() {
		return downgradeTrigger;
	}

	public void setDowngradeTrigger(String downgradeTrigger) {
		this.downgradeTrigger = downgradeTrigger;
	}

	public String getPrimarySmics() {
		return primarySmics;
	}

	public void setPrimarySmics(String primarySmics) {
		this.primarySmics = primarySmics;
	}

	public String getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(String baseRate) {
		this.baseRate = baseRate;
	}

	public String getCurrencyDays() {
		return currencyDays;
	}

	public void setCurrencyDays(String currencyDays) {
		this.currencyDays = currencyDays;
	}

	public String getCurrencyTime() {
		return currencyTime;
	}

	public void setCurrencyTime(String currencyTime) {
		this.currencyTime = currencyTime;
	}

	public Date getPmgDeadline() {
		return pmgDeadline;
	}

	public void setPmgDeadline(Date pmgDeadline) {
		this.pmgDeadline = pmgDeadline;
	}

	public Date getExternalDeadline() {
		return externalDeadline;
	}

	public void setExternalDeadline(Date externalDeadline) {
		this.externalDeadline = externalDeadline;
	}

	public String getSameDayFunding() {
		return sameDayFunding;
	}

	public void setSameDayFunding(String sameDayFunding) {
		this.sameDayFunding = sameDayFunding;
	}

	public Date getAgentNoticeMessage() {
		return agentNoticeMessage;
	}

	public void setAgentNoticeMessage(Date agentNoticeMessage) {
		this.agentNoticeMessage = agentNoticeMessage;
	}

	public String getGroupExposure() {
		return groupExposure;
	}

	public void setGroupExposure(String groupExposure) {
		this.groupExposure = groupExposure;
	}

	public String getCdadWatchlist() {
		return cdadWatchlist;
	}

	public void setCdadWatchlist(String cdadWatchlist) {
		this.cdadWatchlist = cdadWatchlist;
	}

	public String getInterestPeriod() {
		return interestPeriod;
	}

	public void setInterestPeriod(String interestPeriod) {
		this.interestPeriod = interestPeriod;
	}

	public String getCommitmentChangeSign() {
		return commitmentChangeSign;
	}

	public void setCommitmentChangeSign(String commitmentChangeSign) {
		this.commitmentChangeSign = commitmentChangeSign;
	}

	public String getCommitmentChange() {
		return commitmentChange;
	}

	public void setCommitmentChange(String commitmentChange) {
		this.commitmentChange = commitmentChange;
	}

	public String getRequestInLine() {
		return requestInLine;
	}

	public void setRequestInLine(String requestInLine) {
		this.requestInLine = requestInLine;
	}

	public String getExistingTiers() {
		return existingTiers;
	}

	public void setExistingTiers(String existingTiers) {
		this.existingTiers = existingTiers;
	}

	public String getProjectedTiers() {
		return projectedTiers;
	}

	public void setProjectedTiers(String projectedTiers) {
		this.projectedTiers = projectedTiers;
	}

	public String getRaroraProjectedGroup() {
		return raroraProjectedGroup;
	}

	public void setRaroraProjectedGroup(String raroraProjectedGroup) {
		this.raroraProjectedGroup = raroraProjectedGroup;
	}

	public String getExtendedFloor() {
		return extendedFloor;
	}

	public void setExtendedFloor(String extendedFloor) {
		this.extendedFloor = extendedFloor;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public String getRequestDescription() {
		return requestDescription;
	}

	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}

	public String getCreditMetrics() {
		return creditMetrics;
	}

	public void setCreditMetrics(String creditMetrics) {
		this.creditMetrics = creditMetrics;
	}

	public String getLendersGroup() {
		return lendersGroup;
	}

	public void setLendersGroup(String lendersGroup) {
		this.lendersGroup = lendersGroup;
	}

	public String getLcmCommentary() {
		return lcmCommentary;
	}

	public void setLcmCommentary(String lcmCommentary) {
		this.lcmCommentary = lcmCommentary;
	}

	public String getRelatedExposure() {
		return relatedExposure;
	}

	public void setRelatedExposure(String relatedExposure) {
		this.relatedExposure = relatedExposure;
	}

	public String getFacilityMetrics() {
		return facilityMetrics;
	}

	public void setFacilityMetrics(String facilityMetrics) {
		this.facilityMetrics = facilityMetrics;
	}

	public String getBusinessDecisionRationale() {
		return businessDecisionRationale;
	}

	public void setBusinessDecisionRationale(String businessDecisionRationale) {
		this.businessDecisionRationale = businessDecisionRationale;
	}

	public String getDcmSignoff() {
		return dcmSignoff;
	}

	public void setDcmSignoff(String dcmSignoff) {
		this.dcmSignoff = dcmSignoff;
	}

	public String getDcmProjectedTotal() {
		return dcmProjectedTotal;
	}

	public void setDcmProjectedTotal(String dcmProjectedTotal) {
		this.dcmProjectedTotal = dcmProjectedTotal;
	}

	public String getDcmComments() {
		return dcmComments;
	}

	public void setDcmComments(String dcmComments) {
		this.dcmComments = dcmComments;
	}

	public String getDerivativesSignoff() {
		return derivativesSignoff;
	}

	public void setDerivativesSignoff(String derivativesSignoff) {
		this.derivativesSignoff = derivativesSignoff;
	}

	public String getDerivativesProjectedTotal() {
		return derivativesProjectedTotal;
	}

	public void setDerivativesProjectedTotal(String derivativesProjectedTotal) {
		this.derivativesProjectedTotal = derivativesProjectedTotal;
	}

	public String getDerivativesComments() {
		return derivativesComments;
	}

	public void setDerivativesComments(String derivativesComments) {
		this.derivativesComments = derivativesComments;
	}

	public String getDepositSignoff() {
		return depositSignoff;
	}

	public void setDepositSignoff(String depositSignoff) {
		this.depositSignoff = depositSignoff;
	}

	public String getDepositProjectedTotal() {
		return depositProjectedTotal;
	}

	public void setDepositProjectedTotal(String depositProjectedTotal) {
		this.depositProjectedTotal = depositProjectedTotal;
	}

	public String getDepositComments() {
		return depositComments;
	}

	public void setDepositComments(String depositComments) {
		this.depositComments = depositComments;
	}

	public String getEcmSignoff() {
		return ecmSignoff;
	}

	public void setEcmSignoff(String ecmSignoff) {
		this.ecmSignoff = ecmSignoff;
	}

	public String getEcmProjectedTotal() {
		return ecmProjectedTotal;
	}

	public void setEcmProjectedTotal(String ecmProjectedTotal) {
		this.ecmProjectedTotal = ecmProjectedTotal;
	}

	public String getEcmComments() {
		return ecmComments;
	}

	public void setEcmComments(String ecmComments) {
		this.ecmComments = ecmComments;
	}

	public String getFxSignoff() {
		return fxSignoff;
	}

	public void setFxSignoff(String fxSignoff) {
		this.fxSignoff = fxSignoff;
	}

	public String getFxProjectedTotal() {
		return fxProjectedTotal;
	}

	public void setFxProjectedTotal(String fxProjectedTotal) {
		this.fxProjectedTotal = fxProjectedTotal;
	}

	public String getFxComments() {
		return fxComments;
	}

	public void setFxComments(String fxComments) {
		this.fxComments = fxComments;
	}

	public String getProductOverallTotal() {
		return productOverallTotal;
	}

	public void setProductOverallTotal(String productOverallTotal) {
		this.productOverallTotal = productOverallTotal;
	}

	public BaseRateEntity getBaseRateEntity() {
		return baseRateEntity;
	}

	public void setBaseRateEntity(BaseRateEntity baseRateEntity) {
		this.baseRateEntity = baseRateEntity;
	}

	public TiersEntity getExistingTiersEntity() {
		return existingTiersEntity;
	}

	public void setExistingTiersEntity(TiersEntity existingTiersEntity) {
		this.existingTiersEntity = existingTiersEntity;
	}

	public TiersEntity getProjectedTiersEntity() {
		return projectedTiersEntity;
	}

	public void setProjectedTiersEntity(TiersEntity projectedTiersEntity) {
		this.projectedTiersEntity = projectedTiersEntity;
	}
	
}

