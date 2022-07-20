package com.smbc.lad.entity.pipeline;

import java.util.Date;

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
 * Entity class to read/update data from/to table 'pilpeline_deals_credit_inquiry'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_deals_credit_inquiry")
public class CreditInquiryEntity {

	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	@Column(name = "sun_id")
	private String sunId;
	
	@Column(name = "rac_exception")
	private String racException;
	
	@Column(name = "approval_auth")
	private String approvalAuth;
	
	@Column(name = "leverage_loan")
	private String leverageLoan;
	
	@Column(name = "pmg")
	private String pmg;
	
	@Column(name = "pmg_date")
	private Date pmgDate;
	
	@Column(name = "mdpr_date")
	private Date mdprDate;
	
	@Column(name = "notes")
	private String ciNotes;

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

	public String getRacException() {
		return racException;
	}

	public void setRacException(String racException) {
		this.racException = racException;
	}

	public String getApprovalAuth() {
		return approvalAuth;
	}

	public void setApprovalAuth(String approvalAuth) {
		this.approvalAuth = approvalAuth;
	}

	public String getLeverageLoan() {
		return leverageLoan;
	}

	public void setLeverageLoan(String leverageLoan) {
		this.leverageLoan = leverageLoan;
	}

	public String getPmg() {
		return pmg;
	}

	public void setPmg(String pmg) {
		this.pmg = pmg;
	}

	public Date getPmgDate() {
		return pmgDate;
	}

	public void setPmgDate(Date pmgDate) {
		this.pmgDate = pmgDate;
	}

	public Date getMdprDate() {
		return mdprDate;
	}

	public void setMdprDate(Date mdprDate) {
		this.mdprDate = mdprDate;
	}

	public String getCiNotes() {
		return ciNotes;
	}

	public void setCiNotes(String ciNotes) {
		this.ciNotes = ciNotes;
	}
				
}

