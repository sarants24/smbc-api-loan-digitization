package com.smbc.lad.entity.pipeline;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.smbc.lad.entity.lookup.AncillaryTimePeriodEntity;
import com.smbc.lad.entity.lookup.CATFChairEntity;
import com.smbc.lad.entity.lookup.CATFDecisionEntity;
import com.smbc.lad.entity.lookup.PMGApprovalStatusEntity;
import com.smbc.lad.entity.lookup.PMGConditionTypeEntity;
import com.smbc.lad.entity.lookup.PMGDecisionEntity;
import com.smbc.lad.entity.lookup.PMGMeetingTypeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * Entity class to read/update data from/to table 'pipeline_pmg_catf_decision'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_pmg_catf_decision")
public class PMGCATFDecisionEntity {

	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;

	@Column(name = "sun_id")
	private String sunId;

	@Column(name = "proforma_global_group")
	private String proformaGlobalGroup;

	@Column(name = "projected_rofa")
	private String projectedRofa;

	@Column(name = "projected_gross_profit")
	private String projectedGrossProfit;

	@Column(name = "deadline_commitment_summary")
	private Date deadlineCommitmentSummary;
	
	@Column(name = "catf_summary_chair_id")
	private String catfSummaryChairId;

	@Column(name = "catf_meetingtype_id")
	private String catfMeetingtypeId;

	@Column(name = "catf_chair_id")
	private String catfChair;

	@Column(name = "catf_date")
	private Date catfDate;

	@Column(name = "catf_decision_id")
	private String catfDecisionId;
	
	@Column(name = "catf_approval_status_id")
	private String catfApprovalStatusId;

	@Column(name = "catf_rational")
	private String catfRational;

	@Column(name = "pmg_date")
	private Date pmgDate;

	@Column(name = "pmg_catf_support_escalate")
	private String pmgCatfSupportEscalate;

	@Column(name = "pmg_decision_id")
	private String pmgDecisionId;

	@Column(name = "pmg_notes")
	private String pmgNotes;

	@Column(name = "condition_type_id")
	private String conditionTypeId;

	@Column(name = "condition_description")
	private String conditionDescription;

	@Column(name = "condition_course")
	private String conditionCourse;

	@Column(name = "condition_deadline")
	private Date conditionDeadline;

	@Column(name = "ancillary_time_period")
	private String ancillaryTimePeriod;

	@Column(name = "ancillary_actual")
	private String ancillaryActual;

	@Column(name = "ancillary_pmg_votum")
	private String ancillaryPmgVotum;
	
	@Column(name = "ancillary_delta")
	private String ancillaryDelta;

	@Column(name = "ancillary_explanation")
	private String ancillaryExplanation;

	@Column(name = "ancillary_rarora_time_period")
	private String ancillaryRaroraTimePeriod;

	@Column(name = "ancillary_rarora_actual")
	private String ancillaryRaroraActual;

	@Column(name = "ancillary_rarora_pmg_votum")
	private String ancillaryRaroraPmgVotum;
	
	@Column(name = "ancillary_rarora_delta")
	private String ancillaryRaroraDelta;

	@Column(name = "ancillary_rarora_explanation")
	private String ancillaryRaroraExplanation;
	
	@Column(name = "cds_commentary")
	private String cdsCommentary;

	@Column(name = "pmg_commentary")
	private String pmgCommentary;

	@Column(name = "profitability_commentary")
	private String profitabilityCommentary;
	
	@OneToOne
	@JoinColumn(name = "catf_summary_chair_id", referencedColumnName="id",insertable = false,updatable = false)
	private CATFChairEntity catfSummaryChairEntity;
	
	@OneToOne
	@JoinColumn(name = "catf_meetingtype_id", referencedColumnName="id",insertable = false,updatable = false)
	private PMGMeetingTypeEntity pmgMeetingTypeEntity;
	
	@OneToOne
	@JoinColumn(name = "catf_chair_id", referencedColumnName="id",insertable = false,updatable = false)
	private CATFChairEntity catfChairEntity;
	
	@OneToOne
	@JoinColumn(name = "catf_decision_id", referencedColumnName="id",insertable = false,updatable = false)
	private CATFDecisionEntity catfDecisionEntity;
	
	@OneToOne
	@JoinColumn(name = "catf_approval_status_id", referencedColumnName="id",insertable = false,updatable = false)
	private PMGApprovalStatusEntity pmgApprovalStatusEntity;
	
	@OneToOne
	@JoinColumn(name = "pmg_decision_id", referencedColumnName="id",insertable = false,updatable = false)
	private PMGDecisionEntity PMGDecisionEntity;
	
	@OneToOne
	@JoinColumn(name = "condition_type_id", referencedColumnName="id",insertable = false,updatable = false)
	private PMGConditionTypeEntity pmgConditionTypeEntity;
	
	@OneToOne
	@JoinColumn(name = "ancillary_time_period", referencedColumnName="id",insertable = false,updatable = false)
	private AncillaryTimePeriodEntity ancillaryTimePeriodEntity;
	
	@OneToOne
	@JoinColumn(name = "ancillary_rarora_time_period", referencedColumnName="id",insertable = false,updatable = false)
	private AncillaryTimePeriodEntity ancillaryRaroraTimePeriodEntity;

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

	public String getProformaGlobalGroup() {
		return proformaGlobalGroup;
	}

	public void setProformaGlobalGroup(String proformaGlobalGroup) {
		this.proformaGlobalGroup = proformaGlobalGroup;
	}

	public String getProjectedRofa() {
		return projectedRofa;
	}

	public void setProjectedRofa(String projectedRofa) {
		this.projectedRofa = projectedRofa;
	}

	public String getProjectedGrossProfit() {
		return projectedGrossProfit;
	}

	public void setProjectedGrossProfit(String projectedGrossProfit) {
		this.projectedGrossProfit = projectedGrossProfit;
	}

	public Date getDeadlineCommitmentSummary() {
		return deadlineCommitmentSummary;
	}

	public void setDeadlineCommitmentSummary(Date deadlineCommitmentSummary) {
		this.deadlineCommitmentSummary = deadlineCommitmentSummary;
	}

	public String getCatfSummaryChairId() {
		return catfSummaryChairId;
	}

	public void setCatfSummaryChairId(String catfSummaryChairId) {
		this.catfSummaryChairId = catfSummaryChairId;
	}

	public String getCatfMeetingtypeId() {
		return catfMeetingtypeId;
	}

	public void setCatfMeetingtypeId(String catfMeetingtypeId) {
		this.catfMeetingtypeId = catfMeetingtypeId;
	}

	public String getCatfChair() {
		return catfChair;
	}

	public void setCatfChair(String catfChair) {
		this.catfChair = catfChair;
	}

	public Date getCatfDate() {
		return catfDate;
	}

	public void setCatfDate(Date catfDate) {
		this.catfDate = catfDate;
	}

	public String getCatfDecisionId() {
		return catfDecisionId;
	}

	public void setCatfDecisionId(String catfDecisionId) {
		this.catfDecisionId = catfDecisionId;
	}

	public String getCatfApprovalStatusId() {
		return catfApprovalStatusId;
	}

	public void setCatfApprovalStatusId(String catfApprovalStatusId) {
		this.catfApprovalStatusId = catfApprovalStatusId;
	}

	public String getCatfRational() {
		return catfRational;
	}

	public void setCatfRational(String catfRational) {
		this.catfRational = catfRational;
	}

	public Date getPmgDate() {
		return pmgDate;
	}

	public void setPmgDate(Date pmgDate) {
		this.pmgDate = pmgDate;
	}

	public String getPmgCatfSupportEscalate() {
		return pmgCatfSupportEscalate;
	}

	public void setPmgCatfSupportEscalate(String pmgCatfSupportEscalate) {
		this.pmgCatfSupportEscalate = pmgCatfSupportEscalate;
	}

	public String getPmgDecisionId() {
		return pmgDecisionId;
	}

	public void setPmgDecisionId(String pmgDecisionId) {
		this.pmgDecisionId = pmgDecisionId;
	}

	public String getPmgNotes() {
		return pmgNotes;
	}

	public void setPmgNotes(String pmgNotes) {
		this.pmgNotes = pmgNotes;
	}

	public String getConditionTypeId() {
		return conditionTypeId;
	}

	public void setConditionTypeId(String conditionTypeId) {
		this.conditionTypeId = conditionTypeId;
	}

	public String getConditionDescription() {
		return conditionDescription;
	}

	public void setConditionDescription(String conditionDescription) {
		this.conditionDescription = conditionDescription;
	}

	public String getConditionCourse() {
		return conditionCourse;
	}

	public void setConditionCourse(String conditionCourse) {
		this.conditionCourse = conditionCourse;
	}

	public Date getConditionDeadline() {
		return conditionDeadline;
	}

	public void setConditionDeadline(Date conditionDeadline) {
		this.conditionDeadline = conditionDeadline;
	}

	public String getAncillaryTimePeriod() {
		return ancillaryTimePeriod;
	}

	public void setAncillaryTimePeriod(String ancillaryTimePeriod) {
		this.ancillaryTimePeriod = ancillaryTimePeriod;
	}

	public String getAncillaryActual() {
		return ancillaryActual;
	}

	public void setAncillaryActual(String ancillaryActual) {
		this.ancillaryActual = ancillaryActual;
	}

	public String getAncillaryPmgVotum() {
		return ancillaryPmgVotum;
	}

	public void setAncillaryPmgVotum(String ancillaryPmgVotum) {
		this.ancillaryPmgVotum = ancillaryPmgVotum;
	}

	public String getAncillaryDelta() {
		return ancillaryDelta;
	}

	public void setAncillaryDelta(String ancillaryDelta) {
		this.ancillaryDelta = ancillaryDelta;
	}

	public String getAncillaryExplanation() {
		return ancillaryExplanation;
	}

	public void setAncillaryExplanation(String ancillaryExplanation) {
		this.ancillaryExplanation = ancillaryExplanation;
	}

	public String getAncillaryRaroraTimePeriod() {
		return ancillaryRaroraTimePeriod;
	}

	public void setAncillaryRaroraTimePeriod(String ancillaryRaroraTimePeriod) {
		this.ancillaryRaroraTimePeriod = ancillaryRaroraTimePeriod;
	}

	public String getAncillaryRaroraActual() {
		return ancillaryRaroraActual;
	}

	public void setAncillaryRaroraActual(String ancillaryRaroraActual) {
		this.ancillaryRaroraActual = ancillaryRaroraActual;
	}

	public String getAncillaryRaroraPmgVotum() {
		return ancillaryRaroraPmgVotum;
	}

	public void setAncillaryRaroraPmgVotum(String ancillaryRaroraPmgVotum) {
		this.ancillaryRaroraPmgVotum = ancillaryRaroraPmgVotum;
	}

	public String getAncillaryRaroraDelta() {
		return ancillaryRaroraDelta;
	}

	public void setAncillaryRaroraDelta(String ancillaryRaroraDelta) {
		this.ancillaryRaroraDelta = ancillaryRaroraDelta;
	}

	public String getAncillaryRaroraExplanation() {
		return ancillaryRaroraExplanation;
	}

	public void setAncillaryRaroraExplanation(String ancillaryRaroraExplanation) {
		this.ancillaryRaroraExplanation = ancillaryRaroraExplanation;
	}

	public String getCdsCommentary() {
		return cdsCommentary;
	}

	public void setCdsCommentary(String cdsCommentary) {
		this.cdsCommentary = cdsCommentary;
	}

	public String getPmgCommentary() {
		return pmgCommentary;
	}

	public void setPmgCommentary(String pmgCommentary) {
		this.pmgCommentary = pmgCommentary;
	}

	public String getProfitabilityCommentary() {
		return profitabilityCommentary;
	}

	public void setProfitabilityCommentary(String profitabilityCommentary) {
		this.profitabilityCommentary = profitabilityCommentary;
	}

	public CATFChairEntity getCatfSummaryChairEntity() {
		return catfSummaryChairEntity;
	}

	public void setCatfSummaryChairEntity(CATFChairEntity catfSummaryChairEntity) {
		this.catfSummaryChairEntity = catfSummaryChairEntity;
	}

	public PMGMeetingTypeEntity getPmgMeetingTypeEntity() {
		return pmgMeetingTypeEntity;
	}

	public void setPmgMeetingTypeEntity(PMGMeetingTypeEntity pmgMeetingTypeEntity) {
		this.pmgMeetingTypeEntity = pmgMeetingTypeEntity;
	}

	public CATFChairEntity getCatfChairEntity() {
		return catfChairEntity;
	}

	public void setCatfChairEntity(CATFChairEntity catfChairEntity) {
		this.catfChairEntity = catfChairEntity;
	}

	public CATFDecisionEntity getCatfDecisionEntity() {
		return catfDecisionEntity;
	}

	public void setCatfDecisionEntity(CATFDecisionEntity catfDecisionEntity) {
		this.catfDecisionEntity = catfDecisionEntity;
	}

	public PMGApprovalStatusEntity getPmgApprovalStatusEntity() {
		return pmgApprovalStatusEntity;
	}

	public void setPmgApprovalStatusEntity(PMGApprovalStatusEntity pmgApprovalStatusEntity) {
		this.pmgApprovalStatusEntity = pmgApprovalStatusEntity;
	}

	public PMGDecisionEntity getPMGDecisionEntity() {
		return PMGDecisionEntity;
	}

	public void setPMGDecisionEntity(PMGDecisionEntity pMGDecisionEntity) {
		PMGDecisionEntity = pMGDecisionEntity;
	}

	public PMGConditionTypeEntity getPmgConditionTypeEntity() {
		return pmgConditionTypeEntity;
	}

	public void setPmgConditionTypeEntity(PMGConditionTypeEntity pmgConditionTypeEntity) {
		this.pmgConditionTypeEntity = pmgConditionTypeEntity;
	}

	public AncillaryTimePeriodEntity getAncillaryTimePeriodEntity() {
		return ancillaryTimePeriodEntity;
	}

	public void setAncillaryTimePeriodEntity(AncillaryTimePeriodEntity ancillaryTimePeriodEntity) {
		this.ancillaryTimePeriodEntity = ancillaryTimePeriodEntity;
	}

	public AncillaryTimePeriodEntity getAncillaryRaroraTimePeriodEntity() {
		return ancillaryRaroraTimePeriodEntity;
	}

	public void setAncillaryRaroraTimePeriodEntity(AncillaryTimePeriodEntity ancillaryRaroraTimePeriodEntity) {
		this.ancillaryRaroraTimePeriodEntity = ancillaryRaroraTimePeriodEntity;
	}		
}

