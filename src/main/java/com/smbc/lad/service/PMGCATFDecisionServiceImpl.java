package com.smbc.lad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.CapitalRequestForm;
import com.smbc.lad.dto.pipeline.PMGCATFDecision;
import com.smbc.lad.dto.pipeline.PipelineDealsBasics;
import com.smbc.lad.entity.pipeline.CapitalRequestFormEntity;
import com.smbc.lad.entity.pipeline.PipelineDealsBasicsEntity;
import com.smbc.lad.entity.pipeline.PMGCATFDecisionEntity;
import com.smbc.lad.repository.pipeline.CapitalRequestFormRepo;
import com.smbc.lad.repository.pipeline.PMGCATFDecisionRepo;
import com.smbc.lad.utils.LADUtils;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an implementation class for the PMGCATFDecisionService. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
@Service
public class PMGCATFDecisionServiceImpl implements PMGCATFDecisionService {

	@Autowired
	private PMGCATFDecisionRepo pmgCATFDecisionRepo;
	
	@Autowired
	private PipelineDealsService pipelineDealsService;
	
	@Autowired
	private CapitalRequestFormService capitalRequestFormService;
	
	@Autowired
	private CapitalRequestFormRepo capitalRequestFormRepo;
	
	
	/**
	 * This method is used to get the catf decision details for the given pipeline id
	 */
	public PMGCATFDecision getPMGCATFDecision(int pipelineId) {
		
		PMGCATFDecision pmgCATFDecision = new PMGCATFDecision();
		
		PMGCATFDecisionEntity pmgCATFDecisionEntity = pmgCATFDecisionRepo.findByPipelineId(pipelineId);
		PipelineDealsBasics pipelineDetails = pipelineDealsService.getPipelineDetailsById(pipelineId);
		CapitalRequestForm capitalRequestForm = capitalRequestFormService.getCapitalRequestForm(pipelineId);
		
		pmgCATFDecision.setPipelineId(pipelineId);
		if(pipelineDetails != null) {
			pmgCATFDecision.setPortfolioManagerId(pipelineDetails.getPmgOfficer());
			pmgCATFDecision.setPortfolioManager(pipelineDetails.getPmgOfficerName());
			pmgCATFDecision.setBorrowerId(pipelineDetails.getSunId());
			pmgCATFDecision.setBorrowerName(pipelineDetails.getBorrowerName());
			pmgCATFDecision.setParentId(pipelineDetails.getParentId());
			pmgCATFDecision.setParentName(pipelineDetails.getParentName());
		}
		
		if(capitalRequestForm != null) {
			pmgCATFDecision.setProjectedRarora(capitalRequestForm.getRaroraProjectedGroup());
		}
		
		if(pmgCATFDecisionEntity != null) {
			pmgCATFDecision.setPipelineId(pmgCATFDecisionEntity.getPipelineId());
			pmgCATFDecision.setSunId(pmgCATFDecisionEntity.getSunId());
			pmgCATFDecision.setProformaGlobalGroup(pmgCATFDecisionEntity.getProformaGlobalGroup());
			pmgCATFDecision.setProjectedRofa(pmgCATFDecisionEntity.getProjectedRofa());
			pmgCATFDecision.setProjectedGrossProfit(pmgCATFDecisionEntity.getProjectedGrossProfit());
			pmgCATFDecision.setDeadlineCommitmentSummary(
					LADUtils.formatDatetoString(pmgCATFDecisionEntity.getDeadlineCommitmentSummary()));
			
			pmgCATFDecision.setCatfSummaryChairId(pmgCATFDecisionEntity.getCatfSummaryChairId());
			if(pmgCATFDecisionEntity.getCatfSummaryChairEntity() != null) {
				pmgCATFDecision.setCatfSummaryChairDescription(
						pmgCATFDecisionEntity.getCatfSummaryChairEntity().getDescription());
			}
			
			pmgCATFDecision.setCatfMeetingtypeId(pmgCATFDecisionEntity.getCatfMeetingtypeId());
			if(pmgCATFDecisionEntity.getPmgMeetingTypeEntity() != null) {
				pmgCATFDecision.setCatfMeetingtypeDescription(
						pmgCATFDecisionEntity.getPmgMeetingTypeEntity().getDescription());
			}
			
			pmgCATFDecision.setCatfApprovalStatusId(pmgCATFDecisionEntity.getCatfApprovalStatusId());
			if(pmgCATFDecisionEntity.getPmgApprovalStatusEntity() != null) {
				pmgCATFDecision.setCatfApprovalStatusDescription(
						pmgCATFDecisionEntity.getPmgApprovalStatusEntity().getDescription());
			}
			
			pmgCATFDecision.setCatfChairId(pmgCATFDecisionEntity.getCatfChair());
			if(pmgCATFDecisionEntity.getCatfChairEntity() != null) {
				pmgCATFDecision.setCatfMeetingtypeDescription(
						pmgCATFDecisionEntity.getCatfChairEntity().getDescription());
			}
			
			pmgCATFDecision.setCatfDate(
					LADUtils.formatDatetoString(pmgCATFDecisionEntity.getCatfDate()));
			
			pmgCATFDecision.setCatfDecisionId(pmgCATFDecisionEntity.getCatfDecisionId());
			if(pmgCATFDecisionEntity.getCatfDecisionEntity() != null) {
				pmgCATFDecision.setCatfDecisionDescription(
						pmgCATFDecisionEntity.getCatfDecisionEntity().getDescription());
			}
			
			pmgCATFDecision.setCatfRational(pmgCATFDecisionEntity.getCatfRational());
			pmgCATFDecision.setPmgDate(
					LADUtils.formatDatetoString(pmgCATFDecisionEntity.getPmgDate()));
			
			pmgCATFDecision.setPmgCatfSupportEscalate(
					pmgCATFDecisionEntity.getPmgCatfSupportEscalate());
			pmgCATFDecision.setPmgDecisionId(pmgCATFDecisionEntity.getPmgDecisionId());
			if(pmgCATFDecisionEntity.getPMGDecisionEntity() != null) {
				pmgCATFDecision.setPmgDecisionDescription(
						pmgCATFDecisionEntity.getPMGDecisionEntity().getDescription());
			}
			
			pmgCATFDecision.setPmgNotes(pmgCATFDecisionEntity.getPmgNotes());
			
			pmgCATFDecision.setConditionTypeId(pmgCATFDecisionEntity.getConditionTypeId());
			if(pmgCATFDecisionEntity.getPmgConditionTypeEntity() != null) {
				pmgCATFDecision.setConditionTypeDescription(
						pmgCATFDecisionEntity.getPmgConditionTypeEntity().getDescription());
			}
			
			pmgCATFDecision.setConditionDescription(pmgCATFDecisionEntity.getConditionDescription());
			pmgCATFDecision.setConditionCourse(pmgCATFDecisionEntity.getConditionCourse());
			pmgCATFDecision.setConditionDeadline(
					LADUtils.formatDatetoString(pmgCATFDecisionEntity.getConditionDeadline()));
			
			pmgCATFDecision.setAncillaryActual(pmgCATFDecisionEntity.getAncillaryActual());
			pmgCATFDecision.setAncillaryTimePeriodId(pmgCATFDecisionEntity.getAncillaryTimePeriod());
			if(pmgCATFDecisionEntity.getAncillaryTimePeriodEntity() != null) {
				pmgCATFDecision.setAncillaryTimePeriodDescription(
						pmgCATFDecisionEntity.getAncillaryTimePeriodEntity().getDescription());
			}
			pmgCATFDecision.setAncillaryPmgVotum(pmgCATFDecisionEntity.getAncillaryPmgVotum());
			pmgCATFDecision.setAncillaryDelta(pmgCATFDecisionEntity.getAncillaryDelta());
			pmgCATFDecision.setAncillaryExplanation(pmgCATFDecisionEntity.getAncillaryExplanation());
			
			pmgCATFDecision.setAncillaryRaroraActual(pmgCATFDecisionEntity.getAncillaryRaroraActual());
			pmgCATFDecision.setAncillaryRaroraTimePeriodId(pmgCATFDecisionEntity.getAncillaryRaroraTimePeriod());
			if(pmgCATFDecisionEntity.getAncillaryRaroraTimePeriodEntity() != null) {
				pmgCATFDecision.setAncillaryRaroraTimePeriodDescription(
						pmgCATFDecisionEntity.getAncillaryRaroraTimePeriodEntity().getDescription());
			}
			pmgCATFDecision.setAncillaryRaroraPmgVotum(pmgCATFDecisionEntity.getAncillaryRaroraPmgVotum());
			pmgCATFDecision.setAncillaryRaroraDelta(pmgCATFDecisionEntity.getAncillaryRaroraDelta());
			pmgCATFDecision.setAncillaryRaroraExplanation(pmgCATFDecisionEntity.getAncillaryRaroraExplanation());
			
			pmgCATFDecision.setCdsCommentary(pmgCATFDecisionEntity.getCdsCommentary());
			pmgCATFDecision.setPmgCommentary(pmgCATFDecisionEntity.getPmgCommentary());
			pmgCATFDecision.setProfitabilityCommentary(pmgCATFDecisionEntity.getProfitabilityCommentary());

		}
		
		return pmgCATFDecision;
	}
	
	/**
	 * This method is used to update the catf decision details for the given pipeline id
	 */
	public String updatePMGCATFDecisionById(int pipelineId,
			PMGCATFDecision pmgCATFDecision) throws Exception {
		
		PMGCATFDecisionEntity pmgCATFDecisionEntity = new PMGCATFDecisionEntity();
		
		PipelineDealsBasicsEntity pipelineDealsBasicsEntity = pipelineDealsService.getPipelineDealsBasicsEntity(pipelineId);
		pipelineDealsBasicsEntity.setPmgOfficer(pmgCATFDecision.getPortfolioManagerId());
		pipelineDealsService.savePipelineDealsBasicsEntity(pipelineDealsBasicsEntity);

		pmgCATFDecisionEntity.setPipelineId(pipelineId);
		pmgCATFDecisionEntity.setSunId(pipelineDealsBasicsEntity.getSunId());
		pmgCATFDecisionEntity.setProformaGlobalGroup(pmgCATFDecision.getProformaGlobalGroup());
		pmgCATFDecisionEntity.setProjectedRofa(pmgCATFDecision.getProjectedRofa());
		pmgCATFDecisionEntity.setProjectedGrossProfit(pmgCATFDecision.getProjectedGrossProfit());
		
		pmgCATFDecisionEntity.setDeadlineCommitmentSummary(
				LADUtils.formatStringtoDate(pmgCATFDecision.getDeadlineCommitmentSummary()));
		
		pmgCATFDecisionEntity.setCatfSummaryChairId(pmgCATFDecision.getCatfSummaryChairId());
		
		pmgCATFDecisionEntity.setCatfMeetingtypeId(pmgCATFDecision.getCatfMeetingtypeId());
		pmgCATFDecisionEntity.setCatfChair(pmgCATFDecision.getCatfChairId());
		pmgCATFDecisionEntity.setCatfDate(
				LADUtils.formatStringtoDate(pmgCATFDecision.getCatfDate()));
		pmgCATFDecisionEntity.setCatfApprovalStatusId(pmgCATFDecision.getCatfApprovalStatusId());
		pmgCATFDecisionEntity.setCatfDecisionId(pmgCATFDecision.getCatfDecisionId());
		pmgCATFDecisionEntity.setCatfRational(pmgCATFDecision.getCatfRational());
		pmgCATFDecisionEntity.setPmgDate(
				LADUtils.formatStringtoDate(pmgCATFDecision.getPmgDate()));
		pmgCATFDecisionEntity.setPmgCatfSupportEscalate(
				pmgCATFDecision.getPmgCatfSupportEscalate());
		pmgCATFDecisionEntity.setPmgDecisionId(pmgCATFDecision.getPmgDecisionId());
		pmgCATFDecisionEntity.setPmgNotes(pmgCATFDecision.getPmgNotes());
		pmgCATFDecisionEntity.setConditionTypeId(pmgCATFDecision.getConditionTypeId());

		pmgCATFDecisionEntity.setConditionDescription(pmgCATFDecision.getConditionDescription());
		pmgCATFDecisionEntity.setConditionCourse(pmgCATFDecision.getConditionCourse());
		pmgCATFDecisionEntity.setConditionDeadline(
				LADUtils.formatStringtoDate(pmgCATFDecision.getConditionDeadline()));
		
		pmgCATFDecisionEntity.setAncillaryActual(pmgCATFDecision.getAncillaryActual());
		pmgCATFDecisionEntity.setAncillaryTimePeriod(pmgCATFDecision.getAncillaryTimePeriodId());
		pmgCATFDecisionEntity.setAncillaryPmgVotum(pmgCATFDecision.getAncillaryPmgVotum());
		pmgCATFDecisionEntity.setAncillaryDelta(pmgCATFDecision.getAncillaryDelta());
		pmgCATFDecisionEntity.setAncillaryExplanation(pmgCATFDecision.getAncillaryExplanation());
		
		pmgCATFDecisionEntity.setAncillaryRaroraActual(pmgCATFDecision.getAncillaryRaroraActual());
		pmgCATFDecisionEntity.setAncillaryRaroraTimePeriod(pmgCATFDecision.getAncillaryRaroraTimePeriodId());
		pmgCATFDecisionEntity.setAncillaryRaroraPmgVotum(pmgCATFDecision.getAncillaryRaroraPmgVotum());
		pmgCATFDecisionEntity.setAncillaryRaroraDelta(pmgCATFDecision.getAncillaryRaroraDelta());
		pmgCATFDecisionEntity.setAncillaryRaroraExplanation(pmgCATFDecision.getAncillaryRaroraExplanation());
		
		pmgCATFDecisionEntity.setCdsCommentary(pmgCATFDecision.getCdsCommentary());
		pmgCATFDecisionEntity.setPmgCommentary(pmgCATFDecision.getPmgCommentary());
		pmgCATFDecisionEntity.setProfitabilityCommentary(pmgCATFDecision.getProfitabilityCommentary());

		pmgCATFDecisionRepo.save(pmgCATFDecisionEntity);
		
		CapitalRequestFormEntity capitalRequestFormEntity = capitalRequestFormRepo.findByPipelineId(pipelineId);
		if(capitalRequestFormEntity != null) {
			capitalRequestFormEntity.setRaroraProjectedGroup(pmgCATFDecision.getProjectedRarora());
			capitalRequestFormRepo.save(capitalRequestFormEntity);
		}
		
		return "Success";
	}	
}
