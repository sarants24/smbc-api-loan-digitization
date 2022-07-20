package com.smbc.lad.entity.pipeline;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.smbc.lad.entity.lookup.BCDADOfficerEntity;
import com.smbc.lad.entity.lookup.CDADOfficerEntity;
import com.smbc.lad.entity.lookup.CurrencyEntity;
import com.smbc.lad.entity.lookup.PMGOfficerEntity;
import com.smbc.lad.entity.lookup.PriorityRankingEntity;
import com.smbc.lad.entity.lookup.ProcessTypeEntity;
import com.smbc.lad.entity.lookup.SMBCRoleEntity;
import com.smbc.lad.entity.lookup.SponsorsEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * Entity class to read/update data from/to table 'pipeline_deals_basics'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_deals_basics")
//@SecondaryTable(name = "")
public class PipelineDealsBasicsEntity {
	
	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	@Column(name = "sun_id")
	private String sunId;
	
	@Column(name = "currency_code")
	private String currencyCode;
	
	@OneToOne
	@JoinColumn(name = "currency_code", referencedColumnName="id",insertable = false,updatable = false)
	private CurrencyEntity currencyEntity;
	
	@Column(name = "current_facility_limit")
	private String currentFacilityLimit;
	
	@Column(name = "current_total_limit")
	private double currentTotalLimit;
	
	@Column(name = "current_facility_limit_currency")
	private double currentFacilityLimitCurrency;
	
	@Column(name = "current_total_limit_currency")
	private double currentTotalLimitCurrency;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "smbc_role")
	private String smbcRole;
	
	@OneToOne
	@JoinColumn(name = "smbc_role", referencedColumnName="id",insertable = false,updatable = false)
	private SMBCRoleEntity sMBCRoleEntity;
	
	@Column(name = "process_type")
	private String processType;
	
	@OneToOne
	@JoinColumn(name = "process_type", referencedColumnName="id",insertable = false,updatable = false)
	private ProcessTypeEntity processTypeEntity;
	
	@Column(name = "underwriting_distribution")
	private String underwritingDistribution;
	
	@Column(name = "proposed_facility_limit")
	private String proposedFacilityLimit;
	
	@Column(name = "proposed_total_limit")
	private double proposedTotalLimit;
	
	@Column(name = "change_total_limit")
	private double changeTotalLimit;
	
	@Column(name = "proposed_facility_limit_currency")
	private double proposedFacilityLimitCurrency;
	
	@Column(name = "proposed_total_limit_currency")
	private double proposedTotalLimitCurrency;
	
	@Column(name = "senior_leverage")
	private double seniorLeverage;
	
	@Column(name = "total_leverage")
	private double totalLeverage;
	
	@Column(name = "ebitda")
	private double ebitda;
	
	@Column(name = "receipt_deal_date")
	private Date receiptDealDate;
	
	@Column(name = "team_priority_ranking")
	private int teamPriorityRanking;
	
	@OneToOne
	@JoinColumn(name = "team_priority_ranking", referencedColumnName="id",insertable = false,updatable = false)
	private PriorityRankingEntity priorityRankingEntity;
	
	@Column(name = "submission_date")
	private Date submissionDate;
	
	@Column(name = "target_approval_date")
	private Date targetApprovalDate;
	
	@Column(name = "closing_date")
	private Date closingDate;
	
	@Column(name = "sponsor_id")
	private int sponsorId;
	
	@OneToOne
	@JoinColumn(name = "sponsor_id", referencedColumnName="id",insertable = false,updatable = false)
	private SponsorsEntity sponsorsEntity;
		
	@Column(name = "business_description")
	private String business;
	
	@Column(name = "borrower_type")
	private String borrowerType;
	
	@Column(name = "cdad_approving_transaction")
	private String cdadApprovingTransaction;
	
	@Column(name = "cdad_approving_officer")
	private int cdadApprovingOfficer;
	
	@OneToOne
	@JoinColumn(name = "cdad_approving_officer", referencedColumnName="code",insertable = false,updatable = false)
	private CDADOfficerEntity cDADOfficerEntity;
		
	@Column(name = "authority_level_required")
	private String authorityLevelRequired;
	
	@Column(name = "kyogi_required")
	private String kyogiRequired;
	
	@Column(name = "pmg_approving")
	private String pmgApproving;
	
	@Column(name = "pmg_officer")
	private int pmgOfficer;
	
	@OneToOne
	@JoinColumn(name = "pmg_officer", referencedColumnName="code",insertable = false,updatable = false)
	private PMGOfficerEntity pMGOfficerEntity;
	
	@Column(name = "bcdad_approving")
	private String bcdadApproving;
	
	@Column(name = "bcdad_officer")
	private int bcdadOfficer;
	
	@OneToOne
	@JoinColumn(name = "bcdad_officer", referencedColumnName="code",insertable = false,updatable = false)
	private BCDADOfficerEntity bCDADOfficerEntity;

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

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public CurrencyEntity getCurrencyEntity() {
		return currencyEntity;
	}

	public void setCurrencyEntity(CurrencyEntity currencyEntity) {
		this.currencyEntity = currencyEntity;
	}

	public String getCurrentFacilityLimit() {
		return currentFacilityLimit;
	}

	public void setCurrentFacilityLimit(String currentFacilityLimit) {
		this.currentFacilityLimit = currentFacilityLimit;
	}

	public double getCurrentTotalLimit() {
		return currentTotalLimit;
	}

	public void setCurrentTotalLimit(double currentTotalLimit) {
		this.currentTotalLimit = currentTotalLimit;
	}

	public double getCurrentFacilityLimitCurrency() {
		return currentFacilityLimitCurrency;
	}

	public void setCurrentFacilityLimitCurrency(double currentFacilityLimitCurrency) {
		this.currentFacilityLimitCurrency = currentFacilityLimitCurrency;
	}

	public double getCurrentTotalLimitCurrency() {
		return currentTotalLimitCurrency;
	}

	public void setCurrentTotalLimitCurrency(double currentTotalLimitCurrency) {
		this.currentTotalLimitCurrency = currentTotalLimitCurrency;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSmbcRole() {
		return smbcRole;
	}

	public void setSmbcRole(String smbcRole) {
		this.smbcRole = smbcRole;
	}

	public SMBCRoleEntity getsMBCRoleEntity() {
		return sMBCRoleEntity;
	}

	public void setsMBCRoleEntity(SMBCRoleEntity sMBCRoleEntity) {
		this.sMBCRoleEntity = sMBCRoleEntity;
	}

	public String getProcessType() {
		return processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}

	public ProcessTypeEntity getProcessTypeEntity() {
		return processTypeEntity;
	}

	public void setProcessTypeEntity(ProcessTypeEntity processTypeEntity) {
		this.processTypeEntity = processTypeEntity;
	}

	public String getUnderwritingDistribution() {
		return underwritingDistribution;
	}

	public void setUnderwritingDistribution(String underwritingDistribution) {
		this.underwritingDistribution = underwritingDistribution;
	}

	public String getProposedFacilityLimit() {
		return proposedFacilityLimit;
	}

	public void setProposedFacilityLimit(String proposedFacilityLimit) {
		this.proposedFacilityLimit = proposedFacilityLimit;
	}

	public double getProposedTotalLimit() {
		return proposedTotalLimit;
	}

	public void setProposedTotalLimit(double proposedTotalLimit) {
		this.proposedTotalLimit = proposedTotalLimit;
	}

	public double getChangeTotalLimit() {
		return changeTotalLimit;
	}

	public void setChangeTotalLimit(double changeTotalLimit) {
		this.changeTotalLimit = changeTotalLimit;
	}

	public double getProposedFacilityLimitCurrency() {
		return proposedFacilityLimitCurrency;
	}

	public void setProposedFacilityLimitCurrency(double proposedFacilityLimitCurrency) {
		this.proposedFacilityLimitCurrency = proposedFacilityLimitCurrency;
	}

	public double getProposedTotalLimitCurrency() {
		return proposedTotalLimitCurrency;
	}

	public void setProposedTotalLimitCurrency(double proposedTotalLimitCurrency) {
		this.proposedTotalLimitCurrency = proposedTotalLimitCurrency;
	}

	public double getSeniorLeverage() {
		return seniorLeverage;
	}

	public void setSeniorLeverage(double seniorLeverage) {
		this.seniorLeverage = seniorLeverage;
	}

	public double getTotalLeverage() {
		return totalLeverage;
	}

	public void setTotalLeverage(double totalLeverage) {
		this.totalLeverage = totalLeverage;
	}

	public double getEbitda() {
		return ebitda;
	}

	public void setEbitda(double ebitda) {
		this.ebitda = ebitda;
	}

	public Date getReceiptDealDate() {
		return receiptDealDate;
	}

	public void setReceiptDealDate(Date receiptDealDate) {
		this.receiptDealDate = receiptDealDate;
	}

	public int getTeamPriorityRanking() {
		return teamPriorityRanking;
	}

	public void setTeamPriorityRanking(int teamPriorityRanking) {
		this.teamPriorityRanking = teamPriorityRanking;
	}

	public PriorityRankingEntity getPriorityRankingEntity() {
		return priorityRankingEntity;
	}

	public void setPriorityRankingEntity(PriorityRankingEntity priorityRankingEntity) {
		this.priorityRankingEntity = priorityRankingEntity;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Date getTargetApprovalDate() {
		return targetApprovalDate;
	}

	public void setTargetApprovalDate(Date targetApprovalDate) {
		this.targetApprovalDate = targetApprovalDate;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public int getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(int sponsorId) {
		this.sponsorId = sponsorId;
	}

	public SponsorsEntity getSponsorsEntity() {
		return sponsorsEntity;
	}

	public void setSponsorsEntity(SponsorsEntity sponsorsEntity) {
		this.sponsorsEntity = sponsorsEntity;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getBorrowerType() {
		return borrowerType;
	}

	public void setBorrowerType(String borrowerType) {
		this.borrowerType = borrowerType;
	}

	public String getCdadApprovingTransaction() {
		return cdadApprovingTransaction;
	}

	public void setCdadApprovingTransaction(String cdadApprovingTransaction) {
		this.cdadApprovingTransaction = cdadApprovingTransaction;
	}

	public int getCdadApprovingOfficer() {
		return cdadApprovingOfficer;
	}

	public void setCdadApprovingOfficer(int cdadApprovingOfficer) {
		this.cdadApprovingOfficer = cdadApprovingOfficer;
	}

	public CDADOfficerEntity getcDADOfficerEntity() {
		return cDADOfficerEntity;
	}

	public void setcDADOfficerEntity(CDADOfficerEntity cDADOfficerEntity) {
		this.cDADOfficerEntity = cDADOfficerEntity;
	}

	public String getAuthorityLevelRequired() {
		return authorityLevelRequired;
	}

	public void setAuthorityLevelRequired(String authorityLevelRequired) {
		this.authorityLevelRequired = authorityLevelRequired;
	}

	public String getKyogiRequired() {
		return kyogiRequired;
	}

	public void setKyogiRequired(String kyogiRequired) {
		this.kyogiRequired = kyogiRequired;
	}

	public String getPmgApproving() {
		return pmgApproving;
	}

	public void setPmgApproving(String pmgApproving) {
		this.pmgApproving = pmgApproving;
	}

	public int getPmgOfficer() {
		return pmgOfficer;
	}

	public void setPmgOfficer(int pmgOfficer) {
		this.pmgOfficer = pmgOfficer;
	}

	public PMGOfficerEntity getpMGOfficerEntity() {
		return pMGOfficerEntity;
	}

	public void setpMGOfficerEntity(PMGOfficerEntity pMGOfficerEntity) {
		this.pMGOfficerEntity = pMGOfficerEntity;
	}

	public String getBcdadApproving() {
		return bcdadApproving;
	}

	public void setBcdadApproving(String bcdadApproving) {
		this.bcdadApproving = bcdadApproving;
	}

	public int getBcdadOfficer() {
		return bcdadOfficer;
	}

	public void setBcdadOfficer(int bcdadOfficer) {
		this.bcdadOfficer = bcdadOfficer;
	}

	public BCDADOfficerEntity getbCDADOfficerEntity() {
		return bCDADOfficerEntity;
	}

	public void setbCDADOfficerEntity(BCDADOfficerEntity bCDADOfficerEntity) {
		this.bCDADOfficerEntity = bCDADOfficerEntity;
	}
				
}

