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
 * @since April 2022
 * 
 * Entity class to read/update data from/to table 'pipeline_risk_mitigants'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_risk_mitigants")
public class RiskMitigantsEntity {

	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	@Column(name = "key_risks")
	private String keyRisks;
	
	@Column(name = "risk_statement1")
	private String riskStatement1;
	
	@Column(name = "risk_statement2")
	private String riskStatement2;
	
	@Column(name = "risk_statement3")
	private String riskStatement3;
	
	@Column(name = "risk_statement4")
	private String riskStatement4;
	
	@Column(name = "risk_statement5")
	private String riskStatement5;
	
	@Column(name = "risk_probability1")
	private String riskProbability1;
	
	@Column(name = "risk_probability2")
	private String riskProbability2;
	
	@Column(name = "risk_probability3")
	private String riskProbability3;
	
	@Column(name = "risk_probability4")
	private String riskProbability4;
	
	@Column(name = "risk_probability5")
	private String riskProbability5;
	
	@Column(name = "risk_income1")
	private String riskIncome1;
	
	@Column(name = "risk_income2")
	private String riskIncome2;
	
	@Column(name = "risk_income3")
	private String riskIncome3;
	
	@Column(name = "risk_income4")
	private String riskIncome4;
	
	@Column(name = "risk_income5")
	private String riskIncome5;
	
	@Column(name = "risk_mitigant1")
	private String riskMitigant1;
	
	@Column(name = "risk_mitigant2")
	private String riskMitigant2;
	
	@Column(name = "risk_mitigant3")
	private String riskMitigant3;
	
	@Column(name = "risk_mitigant4")
	private String riskMitigant4;
	
	@Column(name = "risk_mitigant5")
	private String riskMitigant5;

	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getKeyRisks() {
		return keyRisks;
	}

	public void setKeyRisks(String keyRisks) {
		this.keyRisks = keyRisks;
	}

	public String getRiskStatement1() {
		return riskStatement1;
	}

	public void setRiskStatement1(String riskStatement1) {
		this.riskStatement1 = riskStatement1;
	}

	public String getRiskStatement2() {
		return riskStatement2;
	}

	public void setRiskStatement2(String riskStatement2) {
		this.riskStatement2 = riskStatement2;
	}

	public String getRiskStatement3() {
		return riskStatement3;
	}

	public void setRiskStatement3(String riskStatement3) {
		this.riskStatement3 = riskStatement3;
	}

	public String getRiskStatement4() {
		return riskStatement4;
	}

	public void setRiskStatement4(String riskStatement4) {
		this.riskStatement4 = riskStatement4;
	}

	public String getRiskStatement5() {
		return riskStatement5;
	}

	public void setRiskStatement5(String riskStatement5) {
		this.riskStatement5 = riskStatement5;
	}

	public String getRiskProbability1() {
		return riskProbability1;
	}

	public void setRiskProbability1(String riskProbability1) {
		this.riskProbability1 = riskProbability1;
	}

	public String getRiskProbability2() {
		return riskProbability2;
	}

	public void setRiskProbability2(String riskProbability2) {
		this.riskProbability2 = riskProbability2;
	}

	public String getRiskProbability3() {
		return riskProbability3;
	}

	public void setRiskProbability3(String riskProbability3) {
		this.riskProbability3 = riskProbability3;
	}

	public String getRiskProbability4() {
		return riskProbability4;
	}

	public void setRiskProbability4(String riskProbability4) {
		this.riskProbability4 = riskProbability4;
	}

	public String getRiskProbability5() {
		return riskProbability5;
	}

	public void setRiskProbability5(String riskProbability5) {
		this.riskProbability5 = riskProbability5;
	}

	public String getRiskIncome1() {
		return riskIncome1;
	}

	public void setRiskIncome1(String riskIncome1) {
		this.riskIncome1 = riskIncome1;
	}

	public String getRiskIncome2() {
		return riskIncome2;
	}

	public void setRiskIncome2(String riskIncome2) {
		this.riskIncome2 = riskIncome2;
	}

	public String getRiskIncome3() {
		return riskIncome3;
	}

	public void setRiskIncome3(String riskIncome3) {
		this.riskIncome3 = riskIncome3;
	}

	public String getRiskIncome4() {
		return riskIncome4;
	}

	public void setRiskIncome4(String riskIncome4) {
		this.riskIncome4 = riskIncome4;
	}

	public String getRiskIncome5() {
		return riskIncome5;
	}

	public void setRiskIncome5(String riskIncome5) {
		this.riskIncome5 = riskIncome5;
	}

	public String getRiskMitigant1() {
		return riskMitigant1;
	}

	public void setRiskMitigant1(String riskMitigant1) {
		this.riskMitigant1 = riskMitigant1;
	}

	public String getRiskMitigant2() {
		return riskMitigant2;
	}

	public void setRiskMitigant2(String riskMitigant2) {
		this.riskMitigant2 = riskMitigant2;
	}

	public String getRiskMitigant3() {
		return riskMitigant3;
	}

	public void setRiskMitigant3(String riskMitigant3) {
		this.riskMitigant3 = riskMitigant3;
	}

	public String getRiskMitigant4() {
		return riskMitigant4;
	}

	public void setRiskMitigant4(String riskMitigant4) {
		this.riskMitigant4 = riskMitigant4;
	}

	public String getRiskMitigant5() {
		return riskMitigant5;
	}

	public void setRiskMitigant5(String riskMitigant5) {
		this.riskMitigant5 = riskMitigant5;
	}
}

