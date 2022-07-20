package com.smbc.lad.dto.pipeline;

import java.util.List;

public class TransactionBackground {

	private int pipelineId;
	private String transactionPurpose;
	private String transactionSources;
	private String transactionProforma;
	private String transactionMergerAcq;
	private String transactionPriceAnalysis;
	private String globalFacilityCurrent;
	private String globalFacilityProposed;
	private String globalFacilityCi;
	private String smbcAmountCurrent;
	private String smbcAmountProposed;
	private String smbcAmountCi;
	private String maturityCurrent;
	private String maturityProposed;
	private String maturityCi;
	private String financialCovenantsCurrent;
	private String financialCovenantsProposed;
	private String financialCovenantsCi;
	private String underwritingExposure;
	private String collateralValuation;
	
	private List<FileData> fileData;
	private int[] filesToDeleteIds;
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
