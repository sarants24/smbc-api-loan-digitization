package com.smbc.lad.entity.pipeline;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * Entity class to read/update data from/to table 'pipeline_capital_request_facility_metrics'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_capital_request_facility_metrics")
public class CapReqFacilityMetricsEntity {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	@Column(name = "facility_description")
	private String facilityDescription;
	
	@Column(name = "adjusted_obligor_grade")
	private String adjustedObligorGrade;
	
	@Column(name = "proposed_commitment")
	private String proposedCommitment;
	
	@Column(name = "expected_allocation")
	private String expectedAllocation;
	
	@Column(name = "usage_percent")
	private String usagePercent;
	
	@Column(name = "legal_tenor")
	private String legalTenor;
	
	@Column(name = "pricing")
	private String pricing;
	
	@Column(name = "credit_adjustment_spread")
	private String creditAdjustmentSpread;
	
	@Column(name = "upfront_fee")
	private String upfrontFee;
	
	@Column(name = "allocation_fees")
	private String allocationFees;
	
	@Column(name = "alpha_")
	private String alpha;
	
	@Column(name = "facility_rarora")
	private String facilityRarora;
	
	@Column(name = "facility_rofa")
	private String facilityRofa;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;

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

	public String getAdjustedObligorGrade() {
		return adjustedObligorGrade;
	}

	public void setAdjustedObligorGrade(String adjustedObligorGrade) {
		this.adjustedObligorGrade = adjustedObligorGrade;
	}

	public String getProposedCommitment() {
		return proposedCommitment;
	}

	public void setProposedCommitment(String proposedCommitment) {
		this.proposedCommitment = proposedCommitment;
	}

	public String getExpectedAllocation() {
		return expectedAllocation;
	}

	public void setExpectedAllocation(String expectedAllocation) {
		this.expectedAllocation = expectedAllocation;
	}

	public String getUsagePercent() {
		return usagePercent;
	}

	public void setUsagePercent(String usagePercent) {
		this.usagePercent = usagePercent;
	}

	public String getLegalTenor() {
		return legalTenor;
	}

	public void setLegalTenor(String legalTenor) {
		this.legalTenor = legalTenor;
	}

	public String getPricing() {
		return pricing;
	}

	public void setPricing(String pricing) {
		this.pricing = pricing;
	}

	public String getCreditAdjustmentSpread() {
		return creditAdjustmentSpread;
	}

	public void setCreditAdjustmentSpread(String creditAdjustmentSpread) {
		this.creditAdjustmentSpread = creditAdjustmentSpread;
	}

	public String getUpfrontFee() {
		return upfrontFee;
	}

	public void setUpfrontFee(String upfrontFee) {
		this.upfrontFee = upfrontFee;
	}

	public String getAllocationFees() {
		return allocationFees;
	}

	public void setAllocationFees(String allocationFees) {
		this.allocationFees = allocationFees;
	}

	public String getAlpha() {
		return alpha;
	}

	public void setAlpha(String alpha) {
		this.alpha = alpha;
	}

	public String getFacilityRarora() {
		return facilityRarora;
	}

	public void setFacilityRarora(String facilityRarora) {
		this.facilityRarora = facilityRarora;
	}

	public String getFacilityRofa() {
		return facilityRofa;
	}

	public void setFacilityRofa(String facilityRofa) {
		this.facilityRofa = facilityRofa;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}	
}

