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
 * Entity class to read/update data from/to table 'pipeline_base_stress_projections'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_base_stress_projections")
public class BaseStressProjectionsEntity {

	@Id
	@Column(name = "pipeline_id")
	private int pipelineId; 
		
	@Column(name = "source")
	private String source; 
		
	@Column(name = "base_fli")
	private String baseFli; 
		
	@Column(name = "stress_fli")
	private String stressFli; 
		
	@Column(name = "base_revenue")
	private String baseRevenue; 
		
	@Column(name = "stress_revenue")
	private String stressRevenue; 
		
	@Column(name = "base_gross_margin")
	private String baseGrossMargin; 
		
	@Column(name = "stress_gross_margin")
	private String stressGrossMargin; 
		
	@Column(name = "base_sgna")
	private String baseSgna; 
		
	@Column(name = "stress_sgna")
	private String stressSgna; 
		
	@Column(name = "base_ebita")
	private String baseEbita; 
		
	@Column(name = "stress_ebita")
	private String stressEbita; 
		
	@Column(name = "base_interest_expense")
	private String baseInterestExpense; 
		
	@Column(name = "stress_interest_expense")
	private String stressInterestExpense; 
		
	@Column(name = "base_taxes")
	private String baseTaxes; 
		
	@Column(name = "stress_taxes")
	private String stressTaxes; 
		
	@Column(name = "base_dna")
	private String baseDna; 
		
	@Column(name = "stress_dna")
	private String stressDna; 
		
	@Column(name = "base_working_capital")
	private String baseWorkingCapital; 
		
	@Column(name = "stress_working_capital")
	private String stressWorkingCapital; 
		
	@Column(name = "base_capex")
	private String baseCapex; 
		
	@Column(name = "stress_capex")
	private String stressCapex; 
		
	@Column(name = "base_dividends")
	private String baseDividends; 
		
	@Column(name = "stress_dividends")
	private String stressDividends; 
		
	@Column(name = "base_acquistion")
	private String baseAcquistion; 
		
	@Column(name = "stress_acquistion")
	private String stressAcquistion; 
		
	@Column(name = "base_equity_issuance")
	private String baseEquityIssuance; 
		
	@Column(name = "stress_equity_issuance")
	private String stressEquityIssuance; 
		
	@Column(name = "base_debt_issuance")
	private String baseDebtIssuance; 
		
	@Column(name = "stress_debt_issuance")
	private String stressDebtIssuance; 
		
	@Column(name = "base_summary")
	private String baseSummary; 
		
	@Column(name = "stress_summary")
	private String stressSummary; 
		
	@Column(name = "base_fccr")
	private String baseFccr; 
		
	@Column(name = "stress_fccr")
	private String stressFccr; 
		
	@Column(name = "base_covenant_compliance")
	private String baseCovenantCompliance; 
		
	@Column(name = "stress_covenant_compliance")
	private String stressCovenantCompliance; 
		
	@Column(name = "base_debt_maturity")
	private String baseDebtMaturity; 
		
	@Column(name = "stress_debt_maturity")
	private String stressDebtMaturity;

	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getBaseFli() {
		return baseFli;
	}

	public void setBaseFli(String baseFli) {
		this.baseFli = baseFli;
	}

	public String getStressFli() {
		return stressFli;
	}

	public void setStressFli(String stressFli) {
		this.stressFli = stressFli;
	}

	public String getBaseRevenue() {
		return baseRevenue;
	}

	public void setBaseRevenue(String baseRevenue) {
		this.baseRevenue = baseRevenue;
	}

	public String getStressRevenue() {
		return stressRevenue;
	}

	public void setStressRevenue(String stressRevenue) {
		this.stressRevenue = stressRevenue;
	}

	public String getBaseGrossMargin() {
		return baseGrossMargin;
	}

	public void setBaseGrossMargin(String baseGrossMargin) {
		this.baseGrossMargin = baseGrossMargin;
	}

	public String getStressGrossMargin() {
		return stressGrossMargin;
	}

	public void setStressGrossMargin(String stressGrossMargin) {
		this.stressGrossMargin = stressGrossMargin;
	}

	public String getBaseSgna() {
		return baseSgna;
	}

	public void setBaseSgna(String baseSgna) {
		this.baseSgna = baseSgna;
	}

	public String getStressSgna() {
		return stressSgna;
	}

	public void setStressSgna(String stressSgna) {
		this.stressSgna = stressSgna;
	}

	public String getBaseEbita() {
		return baseEbita;
	}

	public void setBaseEbita(String baseEbita) {
		this.baseEbita = baseEbita;
	}

	public String getStressEbita() {
		return stressEbita;
	}

	public void setStressEbita(String stressEbita) {
		this.stressEbita = stressEbita;
	}

	public String getBaseInterestExpense() {
		return baseInterestExpense;
	}

	public void setBaseInterestExpense(String baseInterestExpense) {
		this.baseInterestExpense = baseInterestExpense;
	}

	public String getStressInterestExpense() {
		return stressInterestExpense;
	}

	public void setStressInterestExpense(String stressInterestExpense) {
		this.stressInterestExpense = stressInterestExpense;
	}

	public String getBaseTaxes() {
		return baseTaxes;
	}

	public void setBaseTaxes(String baseTaxes) {
		this.baseTaxes = baseTaxes;
	}

	public String getStressTaxes() {
		return stressTaxes;
	}

	public void setStressTaxes(String stressTaxes) {
		this.stressTaxes = stressTaxes;
	}

	public String getBaseDna() {
		return baseDna;
	}

	public void setBaseDna(String baseDna) {
		this.baseDna = baseDna;
	}

	public String getStressDna() {
		return stressDna;
	}

	public void setStressDna(String stressDna) {
		this.stressDna = stressDna;
	}

	public String getBaseWorkingCapital() {
		return baseWorkingCapital;
	}

	public void setBaseWorkingCapital(String baseWorkingCapital) {
		this.baseWorkingCapital = baseWorkingCapital;
	}

	public String getStressWorkingCapital() {
		return stressWorkingCapital;
	}

	public void setStressWorkingCapital(String stressWorkingCapital) {
		this.stressWorkingCapital = stressWorkingCapital;
	}

	public String getBaseCapex() {
		return baseCapex;
	}

	public void setBaseCapex(String baseCapex) {
		this.baseCapex = baseCapex;
	}

	public String getStressCapex() {
		return stressCapex;
	}

	public void setStressCapex(String stressCapex) {
		this.stressCapex = stressCapex;
	}

	public String getBaseDividends() {
		return baseDividends;
	}

	public void setBaseDividends(String baseDividends) {
		this.baseDividends = baseDividends;
	}

	public String getStressDividends() {
		return stressDividends;
	}

	public void setStressDividends(String stressDividends) {
		this.stressDividends = stressDividends;
	}

	public String getBaseAcquistion() {
		return baseAcquistion;
	}

	public void setBaseAcquistion(String baseAcquistion) {
		this.baseAcquistion = baseAcquistion;
	}

	public String getStressAcquistion() {
		return stressAcquistion;
	}

	public void setStressAcquistion(String stressAcquistion) {
		this.stressAcquistion = stressAcquistion;
	}

	public String getBaseEquityIssuance() {
		return baseEquityIssuance;
	}

	public void setBaseEquityIssuance(String baseEquityIssuance) {
		this.baseEquityIssuance = baseEquityIssuance;
	}

	public String getStressEquityIssuance() {
		return stressEquityIssuance;
	}

	public void setStressEquityIssuance(String stressEquityIssuance) {
		this.stressEquityIssuance = stressEquityIssuance;
	}

	public String getBaseDebtIssuance() {
		return baseDebtIssuance;
	}

	public void setBaseDebtIssuance(String baseDebtIssuance) {
		this.baseDebtIssuance = baseDebtIssuance;
	}

	public String getStressDebtIssuance() {
		return stressDebtIssuance;
	}

	public void setStressDebtIssuance(String stressDebtIssuance) {
		this.stressDebtIssuance = stressDebtIssuance;
	}

	public String getBaseSummary() {
		return baseSummary;
	}

	public void setBaseSummary(String baseSummary) {
		this.baseSummary = baseSummary;
	}

	public String getStressSummary() {
		return stressSummary;
	}

	public void setStressSummary(String stressSummary) {
		this.stressSummary = stressSummary;
	}

	public String getBaseFccr() {
		return baseFccr;
	}

	public void setBaseFccr(String baseFccr) {
		this.baseFccr = baseFccr;
	}

	public String getStressFccr() {
		return stressFccr;
	}

	public void setStressFccr(String stressFccr) {
		this.stressFccr = stressFccr;
	}

	public String getBaseCovenantCompliance() {
		return baseCovenantCompliance;
	}

	public void setBaseCovenantCompliance(String baseCovenantCompliance) {
		this.baseCovenantCompliance = baseCovenantCompliance;
	}

	public String getStressCovenantCompliance() {
		return stressCovenantCompliance;
	}

	public void setStressCovenantCompliance(String stressCovenantCompliance) {
		this.stressCovenantCompliance = stressCovenantCompliance;
	}

	public String getBaseDebtMaturity() {
		return baseDebtMaturity;
	}

	public void setBaseDebtMaturity(String baseDebtMaturity) {
		this.baseDebtMaturity = baseDebtMaturity;
	}

	public String getStressDebtMaturity() {
		return stressDebtMaturity;
	}

	public void setStressDebtMaturity(String stressDebtMaturity) {
		this.stressDebtMaturity = stressDebtMaturity;
	} 
		
}

