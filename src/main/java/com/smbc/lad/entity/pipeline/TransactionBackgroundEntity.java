package com.smbc.lad.entity.pipeline;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * Entity class to read/update data from/to table 'pipeline_transaction_background'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_transaction_background")
//@SecondaryTable(name = "")
public class TransactionBackgroundEntity {

	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	@Column(name = "transaction_purpose")
	private String transactionPurpose;

 	@Column(name = "transaction_sources")
	private String transactionSources;

 	@Column(name = "transaction_proforma")
	private String transactionProforma;

 	@Column(name = "transaction_merger_acq")
	private String transactionMergerAcq;

 	@Column(name = "transaction_price_analysis")
	private String transactionPriceAnalysis;

 	@Column(name = "global_facility_current")
	private String globalFacilityCurrent;

 	@Column(name = "global_facility_proposed")
	private String globalFacilityProposed;

 	@Column(name = "global_facility_ci")
	private String globalFacilityCi;

 	@Column(name = "smbc_amount_current")
	private String smbcAmountCurrent;

 	@Column(name = "smbc_amount_proposed")
	private String smbcAmountProposed;

 	@Column(name = "smbc_amount_ci")
	private String smbcAmountCi;

 	@Column(name = "maturity_current")
	private String maturityCurrent;

 	@Column(name = "maturity_proposed")
	private String maturityProposed;

 	@Column(name = "maturity_ci")
	private String maturityCi;

 	@Column(name = "financial_covenants_current")
	private String financialCovenantsCurrent;

 	@Column(name = "financial_covenants_proposed")
	private String financialCovenantsProposed;

 	@Column(name = "financial_covenants_ci")
	private String financialCovenantsCi;

 	@Column(name = "underwritingExposure")
	private String underwritingExposure;

 	@Column(name = "collateralValuation")
	private String collateralValuation;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "pipeline_id", referencedColumnName="pipeline_id",insertable = false,updatable = false)
	private List<TransactionFilesEntity> transactionFilesEntity;

	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getTransactionPurpose() {
		return transactionPurpose;
	}

	public void setTransactionPurpose(String transactionPurpose) {
		this.transactionPurpose = transactionPurpose;
	}

	public String getTransactionSources() {
		return transactionSources;
	}

	public void setTransactionSources(String transactionSources) {
		this.transactionSources = transactionSources;
	}

	public String getTransactionProforma() {
		return transactionProforma;
	}

	public void setTransactionProforma(String transactionProforma) {
		this.transactionProforma = transactionProforma;
	}

	public String getTransactionMergerAcq() {
		return transactionMergerAcq;
	}

	public void setTransactionMergerAcq(String transactionMergerAcq) {
		this.transactionMergerAcq = transactionMergerAcq;
	}

	public String getTransactionPriceAnalysis() {
		return transactionPriceAnalysis;
	}

	public void setTransactionPriceAnalysis(String transactionPriceAnalysis) {
		this.transactionPriceAnalysis = transactionPriceAnalysis;
	}

	public String getGlobalFacilityCurrent() {
		return globalFacilityCurrent;
	}

	public void setGlobalFacilityCurrent(String globalFacilityCurrent) {
		this.globalFacilityCurrent = globalFacilityCurrent;
	}

	public String getGlobalFacilityProposed() {
		return globalFacilityProposed;
	}

	public void setGlobalFacilityProposed(String globalFacilityProposed) {
		this.globalFacilityProposed = globalFacilityProposed;
	}

	public String getGlobalFacilityCi() {
		return globalFacilityCi;
	}

	public void setGlobalFacilityCi(String globalFacilityCi) {
		this.globalFacilityCi = globalFacilityCi;
	}

	
	public String getSmbcAmountCurrent() {
		return smbcAmountCurrent;
	}

	public void setSmbcAmountCurrent(String smbcAmountCurrent) {
		this.smbcAmountCurrent = smbcAmountCurrent;
	}

	public String getSmbcAmountProposed() {
		return smbcAmountProposed;
	}

	public void setSmbcAmountProposed(String smbcAmountProposed) {
		this.smbcAmountProposed = smbcAmountProposed;
	}

	public String getSmbcAmountCi() {
		return smbcAmountCi;
	}

	public void setSmbcAmountCi(String smbcAmountCi) {
		this.smbcAmountCi = smbcAmountCi;
	}

	public String getMaturityCurrent() {
		return maturityCurrent;
	}

	public void setMaturityCurrent(String maturityCurrent) {
		this.maturityCurrent = maturityCurrent;
	}

	public String getMaturityProposed() {
		return maturityProposed;
	}

	public void setMaturityProposed(String maturityProposed) {
		this.maturityProposed = maturityProposed;
	}

	public String getMaturityCi() {
		return maturityCi;
	}

	public void setMaturityCi(String maturityCi) {
		this.maturityCi = maturityCi;
	}

	public String getFinancialCovenantsCurrent() {
		return financialCovenantsCurrent;
	}

	public void setFinancialCovenantsCurrent(String financialCovenantsCurrent) {
		this.financialCovenantsCurrent = financialCovenantsCurrent;
	}

	public String getFinancialCovenantsProposed() {
		return financialCovenantsProposed;
	}

	public void setFinancialCovenantsProposed(String financialCovenantsProposed) {
		this.financialCovenantsProposed = financialCovenantsProposed;
	}



	public String getFinancialCovenantsCi() {
		return financialCovenantsCi;
	}

	public void setFinancialCovenantsCi(String financialCovenantsCi) {
		this.financialCovenantsCi = financialCovenantsCi;
	}

	public String getUnderwritingExposure() {
		return underwritingExposure;
	}

	public void setUnderwritingExposure(String underwritingExposure) {
		this.underwritingExposure = underwritingExposure;
	}

	public String getCollateralValuation() {
		return collateralValuation;
	}

	public void setCollateralValuation(String collateralValuation) {
		this.collateralValuation = collateralValuation;
	}

	public List<TransactionFilesEntity> getTransactionFilesEntity() {
		return transactionFilesEntity;
	}

	public void setTransactionFilesEntity(List<TransactionFilesEntity> transactionFilesEntity) {
		this.transactionFilesEntity = transactionFilesEntity;
	}
			
}

