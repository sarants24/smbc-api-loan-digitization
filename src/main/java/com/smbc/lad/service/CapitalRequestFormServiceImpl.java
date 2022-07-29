package com.smbc.lad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.CapitalRequestExposure;
import com.smbc.lad.dto.pipeline.CapitalRequestFacilityMetrics;
import com.smbc.lad.dto.pipeline.CapitalRequestForm;
import com.smbc.lad.dto.pipeline.DealWorkflow;
import com.smbc.lad.dto.pipeline.ParentInformation;
import com.smbc.lad.dto.pipeline.PipelineDealsBasics;
import com.smbc.lad.dto.pipeline.PipelineDealsCredit;
import com.smbc.lad.entity.pipeline.CapReqFacilityMetricsEntity;
import com.smbc.lad.entity.pipeline.CapitalRequestExposureEntity;
import com.smbc.lad.entity.pipeline.CapitalRequestFormEntity;
import com.smbc.lad.repository.pipeline.CapReqFacilityMetricsRepo;
import com.smbc.lad.repository.pipeline.CapitalRequestExposureRepo;
import com.smbc.lad.repository.pipeline.CapitalRequestFormRepo;
import com.smbc.lad.utils.LADUtils;


/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an implementation class for the CapitalRequestFormService. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
@Service
public class CapitalRequestFormServiceImpl implements CapitalRequestFormService {

	@Autowired
	private CapitalRequestFormRepo capitalRequestFormRepo;
	
	@Autowired
	private CapitalRequestExposureRepo capitalRequestExposureRepo;
	
	@Autowired
	private CapReqFacilityMetricsRepo capReqFacilityMetricsRepo;
	
	@Autowired
	private PipelineDealsService pipelineDealsService;
	
	@Autowired
	private ParentInfoService parentInfoService;
	
	@Autowired
	private DealWorkflowService dealWorkflowService;
	
	/**
	 * This method is used to get the relationship and organization details for the given pipeline id
	 */
	public CapitalRequestForm getCapitalRequestForm(int pipelineId) {
		
		CapitalRequestForm capitalRequestForm = new CapitalRequestForm();
		
		CapitalRequestFormEntity capitalRequestFormEntity = capitalRequestFormRepo.findByPipelineId(pipelineId);
		List<CapitalRequestExposureEntity> capExposureList = capitalRequestExposureRepo.findByPipelineId(pipelineId);
		List<CapReqFacilityMetricsEntity> capFacMetricsList = capReqFacilityMetricsRepo.findByPipelineId(pipelineId);
		
		PipelineDealsBasics pipelineDetails = pipelineDealsService.getPipelineDetailsById(pipelineId);
		ParentInformation parentInformation = parentInfoService.getParentInformationById(pipelineId);
		DealWorkflow dealWorkflow = dealWorkflowService.getDealWorkflow(pipelineId);
		
		capitalRequestForm.setPipelineId(pipelineId);
		
		if(pipelineDetails != null) {
			capitalRequestForm.setBusinessUnitId(pipelineDetails.getDepartmentId());
			capitalRequestForm.setBusinessUnitName(pipelineDetails.getDepartmentName());
			capitalRequestForm.setRelationshipManagerId(pipelineDetails.getRelationshipManagerId());
			capitalRequestForm.setRelationshipManager(pipelineDetails.getRelationshipManagerName());
			capitalRequestForm.setPrimaryContactSubmitterId(pipelineDetails.getFoAnalystId());
			capitalRequestForm.setPrimaryContactSubmitter(pipelineDetails.getFoAnalystName());
			capitalRequestForm.setBorrowerSmun(pipelineDetails.getSunId());
			capitalRequestForm.setBorrowerName(pipelineDetails.getBorrowerName());
			capitalRequestForm.setParentSmun(pipelineDetails.getParentId());			
			capitalRequestForm.setParentName(pipelineDetails.getParentName());
			capitalRequestForm.setCurrencyTypeId(pipelineDetails.getCurrencyCode());
			capitalRequestForm.setCurrencyType(pipelineDetails.getCurrencyCodeDescription());
			
			if(pipelineDetails.getPipelineDealsCredit() != null ) {
				PipelineDealsCredit pipelineDealsCredit = pipelineDetails.getPipelineDealsCredit();
				capitalRequestForm.setSnpRating(pipelineDealsCredit.getSnpRating());
				capitalRequestForm.setSnpRatingLabel(pipelineDealsCredit.getSnpRatingDescription());
				capitalRequestForm.setSnpOutlook(pipelineDealsCredit.getSnpOutlook());
				capitalRequestForm.setSnpOutlookLabel(pipelineDealsCredit.getSnpOutlookDescription());
				capitalRequestForm.setMoodyRating(pipelineDealsCredit.getMoodyRating());
				capitalRequestForm.setMoodyRatingLabel(pipelineDealsCredit.getMoodyRatingDescription());
				capitalRequestForm.setMoodyOutlook(pipelineDealsCredit.getMoodyOutlook());
				capitalRequestForm.setMoodyOutlookLabel(pipelineDealsCredit.getMoodyOutlookDescription());
				capitalRequestForm.setCatfRequired(pipelineDealsCredit.getCatf());
			}
		}
		
		if(parentInformation != null) {
			capitalRequestForm.setPrimarySmics(parentInformation.getPrimarySmics());
			capitalRequestForm.setIsSncRated(parentInformation.getReadBySnc());
			capitalRequestForm.setSncRatingId(parentInformation.getSncRating());
			capitalRequestForm.setSncRatingDescription(parentInformation.getSncRatingLabel());
			capitalRequestForm.setDesignatedNaturalResource(
							parentInformation.getDesignatedByDirector());
		}
		
		if(dealWorkflow != null) {
			capitalRequestForm.setTsdApproval(dealWorkflow.getTsd());
			capitalRequestForm.setSpdgb(dealWorkflow.getSpdgb());
		}
		
		if(capitalRequestFormEntity != null) {
			capitalRequestForm.setCreditContactName(capitalRequestFormEntity.getCreditContactName());
			capitalRequestForm.setAdjustedObligorGrade(capitalRequestFormEntity.getAdjustedObligorGrade());
			capitalRequestForm.setDowngradeTrigger(capitalRequestFormEntity.getDowngradeTrigger());
			capitalRequestForm.setPrimarySmics(capitalRequestFormEntity.getPrimarySmics());
			
			capitalRequestForm.setBaseRateId(capitalRequestFormEntity.getBaseRate());
			if(capitalRequestFormEntity.getBaseRateEntity() != null) {
				capitalRequestForm.setBaseRateName(
						capitalRequestFormEntity.getBaseRateEntity().getDescription());
			}
			
			capitalRequestForm.setCurrencyDays(capitalRequestFormEntity.getCurrencyDays());
			capitalRequestForm.setCurrencyTime(capitalRequestFormEntity.getCurrencyTime());
			capitalRequestForm.setPmgDeadline(
					LADUtils.formatDatetoString(capitalRequestFormEntity.getPmgDeadline()));
			capitalRequestForm.setExternalDeadline(
					LADUtils.formatDatetoString(capitalRequestFormEntity.getExternalDeadline()));
			capitalRequestForm.setSameDayFunding(capitalRequestFormEntity.getSameDayFunding());
			capitalRequestForm.setAgentNoticeMessage(capitalRequestFormEntity.getAgentNoticeMessage());
			capitalRequestForm.setGroupExposure(capitalRequestFormEntity.getGroupExposure());
			capitalRequestForm.setCdadWatchlist(capitalRequestFormEntity.getCdadWatchlist());
			capitalRequestForm.setInterestPeriod(capitalRequestFormEntity.getInterestPeriod());
			capitalRequestForm.setCommitmentChangeSign(capitalRequestFormEntity.getCommitmentChangeSign());
			capitalRequestForm.setCommitmentChange(capitalRequestFormEntity.getCommitmentChange());
			capitalRequestForm.setRequestInLine(capitalRequestFormEntity.getRequestInLine());
			
			capitalRequestForm.setExistingTiersId(capitalRequestFormEntity.getExistingTiers());
			if(capitalRequestFormEntity.getExistingTiersEntity() != null) {
				capitalRequestForm.setExistingTiersDescription(
						capitalRequestFormEntity.getExistingTiersEntity().getDescription());
			}
			
			capitalRequestForm.setProjectedTiersId(capitalRequestFormEntity.getProjectedTiers());
			if(capitalRequestFormEntity.getProjectedTiersEntity() != null) {
				capitalRequestForm.setProjectedTiersDescription(
						capitalRequestFormEntity.getProjectedTiersEntity().getDescription());
			}
			
			capitalRequestForm.setRaroraProjectedGroup(capitalRequestFormEntity.getRaroraProjectedGroup());
			capitalRequestForm.setExtendedFloor(capitalRequestFormEntity.getExtendedFloor());
			capitalRequestForm.setCompanyDescription(capitalRequestFormEntity.getCompanyDescription());
			capitalRequestForm.setRequestDescription(capitalRequestFormEntity.getRequestDescription());
			capitalRequestForm.setCreditMetrics(capitalRequestFormEntity.getCreditMetrics());
			capitalRequestForm.setLendersGroup(capitalRequestFormEntity.getLendersGroup());
			capitalRequestForm.setLcmCommentary(capitalRequestFormEntity.getLcmCommentary());
			capitalRequestForm.setRelatedExposure(capitalRequestFormEntity.getRelatedExposure());
			capitalRequestForm.setFacilityMetrics(capitalRequestFormEntity.getFacilityMetrics());
			capitalRequestForm.setBusinessDecisionRationale(capitalRequestFormEntity.getBusinessDecisionRationale());
			capitalRequestForm.setDcmSignoff(capitalRequestFormEntity.getDcmSignoff());
			capitalRequestForm.setDcmProjectedTotal(capitalRequestFormEntity.getDcmProjectedTotal());
			capitalRequestForm.setDcmComments(capitalRequestFormEntity.getDcmComments());
			capitalRequestForm.setDerivativesSignoff(capitalRequestFormEntity.getDerivativesSignoff());
			capitalRequestForm.setDerivativesProjectedTotal(capitalRequestFormEntity.getDerivativesProjectedTotal());
			capitalRequestForm.setDerivativesComments(capitalRequestFormEntity.getDerivativesComments());
			capitalRequestForm.setDepositSignoff(capitalRequestFormEntity.getDepositSignoff());
			capitalRequestForm.setDepositProjectedTotal(capitalRequestFormEntity.getDepositProjectedTotal());
			capitalRequestForm.setDepositComments(capitalRequestFormEntity.getDepositComments());
			capitalRequestForm.setEcmSignoff(capitalRequestFormEntity.getEcmSignoff());
			capitalRequestForm.setEcmProjectedTotal(capitalRequestFormEntity.getEcmProjectedTotal());
			capitalRequestForm.setEcmComments(capitalRequestFormEntity.getEcmComments());
			capitalRequestForm.setFxSignoff(capitalRequestFormEntity.getFxSignoff());
			capitalRequestForm.setFxProjectedTotal(capitalRequestFormEntity.getFxProjectedTotal());
			capitalRequestForm.setFxComments(capitalRequestFormEntity.getFxComments());
			capitalRequestForm.setProductOverallTotal(capitalRequestFormEntity.getProductOverallTotal());
			
			List<CapitalRequestExposure> capReqExposureCollection = new ArrayList<CapitalRequestExposure>();
			if(capExposureList != null) {				
				for(CapitalRequestExposureEntity capitalRequestExposureEntity : capExposureList) {
					CapitalRequestExposure capitalRequestExposure = 
							setCapitalRequestExposureVO(capitalRequestExposureEntity);
					capReqExposureCollection.add(capitalRequestExposure);
				}
			}
			capitalRequestForm.setCapitalRequestExposureList(capReqExposureCollection);
			
			List<CapitalRequestFacilityMetrics> capReqFacMetricsCollection = new ArrayList<CapitalRequestFacilityMetrics>();
			if(capExposureList != null) {				
				for(CapReqFacilityMetricsEntity capReqFacilityMetricsEntity : capFacMetricsList) {
					CapitalRequestFacilityMetrics capitalRequestFacilityMetrics = 
							setCapReqFacilityMetricsVO(capReqFacilityMetricsEntity);
					capReqFacMetricsCollection.add(capitalRequestFacilityMetrics);
				}
			}
			capitalRequestForm.setCapitalRequestFacilityMetrics(capReqFacMetricsCollection);
		}
		
		return capitalRequestForm;
	}
	
	/**
	 * This method is used to update the capital request form details for the given pipeline id
	 */
	public String updateCapitalRequestFormById(int pipelineId,CapitalRequestForm capitalRequestForm) throws Exception {
		
		//Capital Request Form
		CapitalRequestFormEntity capitalRequestFormEntity = new CapitalRequestFormEntity();
		capitalRequestFormEntity.setPipelineId(pipelineId);
		capitalRequestFormEntity.setSunId(capitalRequestForm.getBorrowerSmun());
		capitalRequestFormEntity.setCreditContactName(capitalRequestForm.getCreditContactName());
		capitalRequestFormEntity.setAdjustedObligorGrade(capitalRequestForm.getAdjustedObligorGrade());
		capitalRequestFormEntity.setDowngradeTrigger(capitalRequestForm.getDowngradeTrigger());
		capitalRequestFormEntity.setPrimarySmics(capitalRequestForm.getPrimarySmics());
		
		capitalRequestFormEntity.setBaseRate(
				LADUtils.setNullIfEmpty(capitalRequestForm.getBaseRateId()));
		
		capitalRequestFormEntity.setCurrencyDays(
				LADUtils.setNullIfEmpty(capitalRequestForm.getCurrencyDays()));
		capitalRequestFormEntity.setCurrencyTime(capitalRequestForm.getCurrencyTime());
		
		capitalRequestFormEntity.setPmgDeadline(
					LADUtils.formatStringtoDate(capitalRequestForm.getPmgDeadline()));
		capitalRequestFormEntity.setExternalDeadline(
					LADUtils.formatStringtoDate(capitalRequestForm.getExternalDeadline()));
		capitalRequestFormEntity.setSameDayFunding(capitalRequestForm.getSameDayFunding());
		capitalRequestFormEntity.setAgentNoticeMessage(capitalRequestForm.getAgentNoticeMessage());
		capitalRequestFormEntity.setGroupExposure(capitalRequestForm.getGroupExposure());
		capitalRequestFormEntity.setCdadWatchlist(capitalRequestForm.getCdadWatchlist());
		capitalRequestFormEntity.setInterestPeriod(capitalRequestForm.getInterestPeriod());
		capitalRequestFormEntity.setCommitmentChangeSign(capitalRequestForm.getCommitmentChangeSign());
		capitalRequestFormEntity.setCommitmentChange(capitalRequestForm.getCommitmentChange());
		capitalRequestFormEntity.setRequestInLine(capitalRequestForm.getRequestInLine());
		
		capitalRequestFormEntity.setExistingTiers(
				LADUtils.setNullIfEmpty(capitalRequestForm.getExistingTiersId()));
		capitalRequestFormEntity.setProjectedTiers(
				LADUtils.setNullIfEmpty(capitalRequestForm.getProjectedTiersId()));
		capitalRequestFormEntity.setRaroraProjectedGroup(capitalRequestForm.getRaroraProjectedGroup());
		capitalRequestFormEntity.setExtendedFloor(capitalRequestForm.getExtendedFloor());
		capitalRequestFormEntity.setCompanyDescription(capitalRequestForm.getCompanyDescription());
		capitalRequestFormEntity.setRequestDescription(capitalRequestForm.getRequestDescription());
		capitalRequestFormEntity.setCreditMetrics(capitalRequestForm.getCreditMetrics());
		capitalRequestFormEntity.setLendersGroup(capitalRequestForm.getLendersGroup());
		capitalRequestFormEntity.setLcmCommentary(capitalRequestForm.getLcmCommentary());
		capitalRequestFormEntity.setRelatedExposure(capitalRequestForm.getRelatedExposure());
		capitalRequestFormEntity.setFacilityMetrics(capitalRequestForm.getFacilityMetrics());
		capitalRequestFormEntity.setBusinessDecisionRationale(capitalRequestForm.getBusinessDecisionRationale());
		capitalRequestFormEntity.setDcmSignoff(capitalRequestForm.getDcmSignoff());
		capitalRequestFormEntity.setDcmProjectedTotal(capitalRequestForm.getDcmProjectedTotal());
		capitalRequestFormEntity.setDcmComments(capitalRequestForm.getDcmComments());
		capitalRequestFormEntity.setDerivativesSignoff(capitalRequestForm.getDerivativesSignoff());
		capitalRequestFormEntity.setDerivativesProjectedTotal(capitalRequestForm.getDerivativesProjectedTotal());
		capitalRequestFormEntity.setDerivativesComments(capitalRequestForm.getDerivativesComments());
		capitalRequestFormEntity.setDepositSignoff(capitalRequestForm.getDepositSignoff());
		capitalRequestFormEntity.setDepositProjectedTotal(capitalRequestForm.getDepositProjectedTotal());
		capitalRequestFormEntity.setDepositComments(capitalRequestForm.getDepositComments());
		capitalRequestFormEntity.setEcmSignoff(capitalRequestForm.getEcmSignoff());
		capitalRequestFormEntity.setEcmProjectedTotal(capitalRequestForm.getEcmProjectedTotal());
		capitalRequestFormEntity.setEcmComments(capitalRequestForm.getEcmComments());
		capitalRequestFormEntity.setFxSignoff(capitalRequestForm.getFxSignoff());
		capitalRequestFormEntity.setFxProjectedTotal(capitalRequestForm.getFxProjectedTotal());
		capitalRequestFormEntity.setFxComments(capitalRequestForm.getFxComments());
		capitalRequestFormEntity.setProductOverallTotal(capitalRequestForm.getProductOverallTotal());	
		capitalRequestFormRepo.save(capitalRequestFormEntity);
		
		//Upload Capital Request Exposure
		List<CapitalRequestExposure> capReqExposureList = capitalRequestForm.getCapitalRequestExposureList();
		if(capReqExposureList != null) {
			for(int i=0; i<capReqExposureList.size(); i++) {
				CapitalRequestExposure capReqExposure = capReqExposureList.get(i);
				
				CapitalRequestExposureEntity capitalRequestExposureEntity = new CapitalRequestExposureEntity();
				if(capReqExposure.getId() > 0) {
					capitalRequestExposureEntity.setId(capReqExposure.getId());
				}
				capitalRequestExposureEntity.setPipelineId(capReqExposure.getPipelineId());
				capitalRequestExposureEntity.setFacilityDescription(capReqExposure.getFacilityDescription());
				capitalRequestExposureEntity.setMaturityDescription(capReqExposure.getMaturityDescription());
				capitalRequestExposureEntity.setSmbcCommitment(capReqExposure.getSmbcCommitment());
				capitalRequestExposureEntity.setFacilityLevelRarora(capReqExposure.getFacilityLevelRarora());
				
				capitalRequestExposureRepo.save(capitalRequestExposureEntity);
			}
		}
		
		//Delete Capital Request Exposure
		if(capitalRequestForm.getCapReqExposureToDeleteIds() != null) {
			int[] filesToDelete = capitalRequestForm.getCapReqExposureToDeleteIds();
			for (int i=0; i<filesToDelete.length;i++) {
				deleteCapitalRequestExposure(filesToDelete[i]);
			}
		}
		
		
		//Upload CapitalFacility Metrics
		List<CapitalRequestFacilityMetrics> capReqFacMetricsList = capitalRequestForm.getCapitalRequestFacilityMetrics();
		if(capReqFacMetricsList != null) {
			for(int i=0; i<capReqFacMetricsList.size(); i++) {
				CapitalRequestFacilityMetrics capReqFacMetrics = capReqFacMetricsList.get(i);
				
				CapReqFacilityMetricsEntity capReqFacilityMetricsEntity = new CapReqFacilityMetricsEntity();
				if(capReqFacMetrics.getId() > 0) {
					capReqFacilityMetricsEntity.setId(capReqFacMetrics.getId());
				}
				capReqFacilityMetricsEntity.setPipelineId(capReqFacMetrics.getPipelineId());
				capReqFacilityMetricsEntity.setFacilityDescription(capReqFacMetrics.getFacilityDescription());
				capReqFacilityMetricsEntity.setAdjustedObligorGrade(capReqFacMetrics.getAdjustedObligorGrade());
				capReqFacilityMetricsEntity.setProposedCommitment(capReqFacMetrics.getProposedCommitment());
				capReqFacilityMetricsEntity.setExpectedAllocation(capReqFacMetrics.getExpectedAllocation());
				capReqFacilityMetricsEntity.setUsagePercent(capReqFacMetrics.getUsagePercent());
				capReqFacilityMetricsEntity.setLegalTenor(capReqFacMetrics.getLegalTenor());
				capReqFacilityMetricsEntity.setPricing(capReqFacMetrics.getPricing());
				capReqFacilityMetricsEntity.setCreditAdjustmentSpread(capReqFacMetrics.getCreditAdjustmentSpread());
				capReqFacilityMetricsEntity.setUpfrontFee(capReqFacMetrics.getUpfrontFee());
				capReqFacilityMetricsEntity.setAllocationFees(capReqFacMetrics.getAllocationFees());
				capReqFacilityMetricsEntity.setAlpha(capReqFacMetrics.getAlpha());
				capReqFacilityMetricsEntity.setFacilityRarora(capReqFacMetrics.getFacilityRarora());
				capReqFacilityMetricsEntity.setFacilityRofa(capReqFacMetrics.getFacilityRofa());
				
				capReqFacilityMetricsRepo.save(capReqFacilityMetricsEntity);
			}
		}
		//Update Pipeline Detail
		PipelineDealsBasics pipelineDetails = pipelineDealsService.getPipelineDetailsById(pipelineId);
		
		pipelineDetails.setDepartmentId(capitalRequestForm.getBusinessUnitId());
		pipelineDetails.setRelationshipManagerId(capitalRequestForm.getRelationshipManagerId());
		pipelineDetails.setFoAnalystId(capitalRequestForm.getPrimaryContactSubmitterId());
		pipelineDetails.setCurrencyCode(
				LADUtils.setNullIfEmpty(capitalRequestForm.getCurrencyTypeId()));
		
		if(pipelineDetails.getPipelineDealsCredit() != null) {
			PipelineDealsCredit pipelineDealsCredit = pipelineDetails.getPipelineDealsCredit();
			pipelineDealsCredit.setCatf(capitalRequestForm.getCatfRequired());
			
			pipelineDealsCredit.setSnpRating(capitalRequestForm.getSnpRating());
			pipelineDealsCredit.setSnpOutlook(capitalRequestForm.getSnpOutlook());
			pipelineDealsCredit.setMoodyRating(capitalRequestForm.getMoodyRating());
			pipelineDealsCredit.setMoodyOutlook(capitalRequestForm.getMoodyOutlook());
		}
		pipelineDealsService.updatePipelineDetailsById(pipelineId, pipelineDetails);
		
		//Update   Parent Info
		ParentInformation parentInformation = parentInfoService.getParentInformationById(pipelineId);
		parentInformation.setPrimarySmics(capitalRequestForm.getPrimarySmics());
		parentInformation.setReadBySnc(capitalRequestForm.getIsSncRated());
		parentInformation.setSncRating(capitalRequestForm.getSncRatingId());
		parentInformation.setDesignatedByDirector(
				capitalRequestForm.getDesignatedNaturalResource());
		parentInfoService.updateParentInformationById(pipelineId, parentInformation);
		
		//Update Dealworkflow
		DealWorkflow dealWorkflow = dealWorkflowService.getDealWorkflow(pipelineId);
		
		dealWorkflow.setTsd(capitalRequestForm.getTsdApproval());
		dealWorkflow.setSpdgb(capitalRequestForm.getSpdgb());
		dealWorkflowService.addOrUpdateDealWorkflowById(pipelineId, dealWorkflow);
		
		
		//Delete Capital Request Facility Metrics
		if(capitalRequestForm.getCapReqFacMetricsToDeleteIds() != null) {
			int[] filesToDelete = capitalRequestForm.getCapReqFacMetricsToDeleteIds();
			for (int i=0; i<filesToDelete.length;i++) {
				deleteCapitalRequestFacilityMetrics(filesToDelete[i]);
			}
		}
		return "Success";
	}
	
	/**
	 * This method is used to get the capital exposure details for the given id
	 */
	public CapitalRequestExposure getCapitalRequestExposure(int id) {
		
		CapitalRequestExposureEntity capitalRequestExposureEntity = capitalRequestExposureRepo.findById(id);
		CapitalRequestExposure capitalRequestExposure = setCapitalRequestExposureVO(capitalRequestExposureEntity);
		
		return capitalRequestExposure;
	}
	
	private CapitalRequestExposure setCapitalRequestExposureVO(CapitalRequestExposureEntity capitalRequestExposureEntity) {
		CapitalRequestExposure capitalRequestExposure = new CapitalRequestExposure();
		
		if(capitalRequestExposureEntity != null) {
			capitalRequestExposure.setId(capitalRequestExposureEntity.getId());
			capitalRequestExposure.setPipelineId(capitalRequestExposureEntity.getPipelineId());
			capitalRequestExposure.setFacilityDescription(capitalRequestExposureEntity.getFacilityDescription());
			capitalRequestExposure.setMaturityDescription(capitalRequestExposureEntity.getMaturityDescription());
			capitalRequestExposure.setSmbcCommitment(capitalRequestExposureEntity.getSmbcCommitment());
			capitalRequestExposure.setFacilityLevelRarora(capitalRequestExposureEntity.getFacilityLevelRarora());
			
			capitalRequestExposure.setCreatedTimestamp(
					LADUtils.formatDatetoTimestamp(capitalRequestExposureEntity.getCreatedDate()));
			  
		}
		
		return capitalRequestExposure;
	}
	/**
	 * This method is used to delete the capital exposure details for the given id
	 */
	public String deleteCapitalRequestExposure(int id) {
		CapitalRequestExposureEntity capitalRequestExposureEntity = capitalRequestExposureRepo.findById(id);
		if(capitalRequestExposureEntity != null) {
			capitalRequestExposureRepo.delete(capitalRequestExposureEntity);
		}
		return "Success";
	}
	
	
	/**
	 * This method is used to get the capital exposure details for the given id
	 */
	public CapitalRequestFacilityMetrics getCapitalRequestFacilityMetrics(int id) {
		
		CapReqFacilityMetricsEntity capReqFacilityMetricsEntity = 
							capReqFacilityMetricsRepo.findById(id);
		
		CapitalRequestFacilityMetrics capitalRequestFacilityMetrics = 
							setCapReqFacilityMetricsVO(capReqFacilityMetricsEntity);
		
		
		return capitalRequestFacilityMetrics;
	}
	
	private CapitalRequestFacilityMetrics setCapReqFacilityMetricsVO(CapReqFacilityMetricsEntity capReqFacilityMetricsEntity) {
		CapitalRequestFacilityMetrics capitalRequestFacilityMetrics = new CapitalRequestFacilityMetrics();
		
		if(capReqFacilityMetricsEntity != null) {
			capitalRequestFacilityMetrics.setId(capReqFacilityMetricsEntity.getId());
			capitalRequestFacilityMetrics.setPipelineId(capReqFacilityMetricsEntity.getPipelineId());
			capitalRequestFacilityMetrics.setFacilityDescription(capReqFacilityMetricsEntity.getFacilityDescription());
			capitalRequestFacilityMetrics.setAdjustedObligorGrade(capReqFacilityMetricsEntity.getAdjustedObligorGrade());
			capitalRequestFacilityMetrics.setProposedCommitment(capReqFacilityMetricsEntity.getProposedCommitment());
			capitalRequestFacilityMetrics.setExpectedAllocation(capReqFacilityMetricsEntity.getExpectedAllocation());
			capitalRequestFacilityMetrics.setUsagePercent(capReqFacilityMetricsEntity.getUsagePercent());
			capitalRequestFacilityMetrics.setLegalTenor(capReqFacilityMetricsEntity.getLegalTenor());
			capitalRequestFacilityMetrics.setPricing(capReqFacilityMetricsEntity.getPricing());
			capitalRequestFacilityMetrics.setCreditAdjustmentSpread(capReqFacilityMetricsEntity.getCreditAdjustmentSpread());
			capitalRequestFacilityMetrics.setUpfrontFee(capReqFacilityMetricsEntity.getUpfrontFee());
			capitalRequestFacilityMetrics.setAllocationFees(capReqFacilityMetricsEntity.getAllocationFees());
			capitalRequestFacilityMetrics.setAlpha(capReqFacilityMetricsEntity.getAlpha());
			capitalRequestFacilityMetrics.setFacilityRarora(capReqFacilityMetricsEntity.getFacilityRarora());
			capitalRequestFacilityMetrics.setFacilityRofa(capReqFacilityMetricsEntity.getFacilityRofa());
			capitalRequestFacilityMetrics.setCreatedTimestamp(
					LADUtils.formatDatetoTimestamp(capReqFacilityMetricsEntity.getCreatedDate()));
			  
		}
		
		return capitalRequestFacilityMetrics;
	}
	
	/**
	 * This method is used to delete the capital exposure details for the given id
	 */
	public String deleteCapitalRequestFacilityMetrics(int id) {
		CapReqFacilityMetricsEntity capReqFacilityMetricsEntity = capReqFacilityMetricsRepo.findById(id);
		if(capReqFacilityMetricsEntity != null) {
			capReqFacilityMetricsRepo.delete(capReqFacilityMetricsEntity);
		}
		return "Success";
	}
}
