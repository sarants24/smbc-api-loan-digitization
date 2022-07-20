package com.smbc.lad.entity.pipeline;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saravanan T
 * @since May 2022
 * 
 * Entity class to read/update data from/to table 'pipeline_financial_analysis'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_financial_analysis")
public class FinancialAnalysisEntity {

	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;

	@Column(name = "business_segment_analysis")
	private String businessSegmentAnalysis;
	 
	@Column(name = "geographic_segment_analysis")
	private String geographicSegmentAnalysis;
	 
	@Column(name = "income_statement_trends")
	private String incomeStatementTrends;
	 
	@Column(name = "ebita_analysis")
	private String ebitaAnalysis;
	 
	@Column(name = "balance_sheet")
	private String balanceSheet;
	 
	@Column(name = "cah_flow")
	private String cahFlow;
	 
	@Column(name = "liquidity")
	private String liquidity;
	 
	@Column(name = "covenant_complaince")
	private String covenantComplaince;
	 
	@Column(name = "fixed_charge_coverage")
	private String fixedChargeCoverage;
	 
	@Column(name = "unfavourable_information")
	private String unfavourableInformation;

	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getBusinessSegmentAnalysis() {
		return businessSegmentAnalysis;
	}

	public void setBusinessSegmentAnalysis(String businessSegmentAnalysis) {
		this.businessSegmentAnalysis = businessSegmentAnalysis;
	}

	public String getGeographicSegmentAnalysis() {
		return geographicSegmentAnalysis;
	}

	public void setGeographicSegmentAnalysis(String geographicSegmentAnalysis) {
		this.geographicSegmentAnalysis = geographicSegmentAnalysis;
	}

	public String getIncomeStatementTrends() {
		return incomeStatementTrends;
	}

	public void setIncomeStatementTrends(String incomeStatementTrends) {
		this.incomeStatementTrends = incomeStatementTrends;
	}

	public String getEbitaAnalysis() {
		return ebitaAnalysis;
	}

	public void setEbitaAnalysis(String ebitaAnalysis) {
		this.ebitaAnalysis = ebitaAnalysis;
	}

	public String getBalanceSheet() {
		return balanceSheet;
	}

	public void setBalanceSheet(String balanceSheet) {
		this.balanceSheet = balanceSheet;
	}

	public String getCahFlow() {
		return cahFlow;
	}

	public void setCahFlow(String cahFlow) {
		this.cahFlow = cahFlow;
	}

	public String getLiquidity() {
		return liquidity;
	}

	public void setLiquidity(String liquidity) {
		this.liquidity = liquidity;
	}

	public String getCovenantComplaince() {
		return covenantComplaince;
	}

	public void setCovenantComplaince(String covenantComplaince) {
		this.covenantComplaince = covenantComplaince;
	}

	public String getFixedChargeCoverage() {
		return fixedChargeCoverage;
	}

	public void setFixedChargeCoverage(String fixedChargeCoverage) {
		this.fixedChargeCoverage = fixedChargeCoverage;
	}

	public String getUnfavourableInformation() {
		return unfavourableInformation;
	}

	public void setUnfavourableInformation(String unfavourableInformation) {
		this.unfavourableInformation = unfavourableInformation;
	}
	
}

