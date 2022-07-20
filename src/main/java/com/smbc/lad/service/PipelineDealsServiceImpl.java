package com.smbc.lad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.DealWorkflow;
import com.smbc.lad.dto.pipeline.PipelineDeals;
import com.smbc.lad.dto.pipeline.PipelineDealsBasics;
import com.smbc.lad.dto.pipeline.PipelineDealsCredit;
import com.smbc.lad.entity.pipeline.DealWorkflowEntity;
import com.smbc.lad.entity.pipeline.PMGDealDashboardEntity;
import com.smbc.lad.entity.pipeline.PipelineDealsBasicsEntity;
import com.smbc.lad.entity.pipeline.PipelineDealsCreditEntity;
import com.smbc.lad.entity.pipeline.PipelineDealsEntity;
import com.smbc.lad.exception.SMBCResourceNotFoundException;
import com.smbc.lad.repository.pipeline.PMGDealDashboardRepo;
import com.smbc.lad.repository.pipeline.PipelineDealsBasicsRepo;
import com.smbc.lad.repository.pipeline.PipelineDealsCreditRepo;
import com.smbc.lad.repository.pipeline.PipelineDealsRepo;
import com.smbc.lad.utils.LADUtils;


/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an implementation class for the Pipeline Dashboard, Pipeline Detail and CI  entities. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
@Service
public class PipelineDealsServiceImpl implements PipelineDealsService {

	@Autowired
	private PipelineDealsRepo pipelineDealsRepo;
	
	@Autowired
	private PipelineDealsBasicsRepo pipelineDealsBasicsRepo;
	
	@Autowired
	private PipelineDealsCreditRepo pipelineDealsCreditRepo;
	
	@Autowired
	private PMGDealDashboardRepo pMGDealDashboardRepo;
	
	/**
	 * This method is used to the list of all pipeline deals for Front Office Dashboard
	 */
	public List<PipelineDeals> getAllPipelineDeals() {
		
		List<PipelineDealsEntity> pipelineDealsEntityList = pipelineDealsRepo.findAll();
		
		List<PipelineDeals> pipelineDealsList = setViewPipelineDeals(pipelineDealsEntityList);
		
		return pipelineDealsList;
	}
	
	/**
	 * This method is used to the list of all pipeline deals for CDAD Dashboard
	 */
	public List<PipelineDeals> getAllCDADPipelineDeals() {
		
		List<String> statusList = new ArrayList<String>();
		statusList.add("DSTP");
		statusList.add("DSCP");
		statusList.add("DAPM");
		statusList.add("DSCL");
		statusList.add("DCLO");
		statusList.add("DAMN");
		
		List<PipelineDealsEntity> pipelineDealsEntityList = pipelineDealsRepo.findPipelineDealsEntityByApplicationStatusId(statusList);
		
		List<PipelineDeals> pipelineDealsList = setViewPipelineDeals(pipelineDealsEntityList);
		
		return pipelineDealsList;
	}
	
	/**
	 * This method is used to the set the values fetched from Entity to DTO
	 * of all pipeline deals to display Dashboard
	 */
	private List<PipelineDeals> setViewPipelineDeals(List<PipelineDealsEntity> pipelineDealsEntityList) {
		List<PipelineDeals> pipelineDealsList = new ArrayList<PipelineDeals>();
		
		if (pipelineDealsEntityList != null) {
			for(PipelineDealsEntity pipelineDealsEntity : pipelineDealsEntityList) {
				
				PipelineDeals plDeals = new PipelineDeals();
				
				plDeals.setPipelineId(pipelineDealsEntity.getId());
				plDeals.setSunId(pipelineDealsEntity.getSunId());
				plDeals.setApplicationName(pipelineDealsEntity.getBorrowerName());
				plDeals.setDealName(pipelineDealsEntity.getDealName());
				
				plDeals.setExpectedClosingDate(
						LADUtils.formatDatetoString(pipelineDealsEntity.getExpectedClosingDate()));
				
				if(pipelineDealsEntity.getRelationManagerName() != null) {
					plDeals.setRelationshipManagerId(
							pipelineDealsEntity.getRelationManagerName().getCode());
					plDeals.setRelationshipManagerName(
							pipelineDealsEntity.getRelationManagerName().getName());
				}
				
				if(pipelineDealsEntity.getCategoryEntity() != null) {
					plDeals.setCategoryId(
							pipelineDealsEntity.getCategoryEntity().getId());
					plDeals.setCategoryName(
							pipelineDealsEntity.getCategoryEntity().getDescription());
				}
				
				if(pipelineDealsEntity.getDepartmentsEntity() != null) {
					plDeals.setDepartmentId(
							pipelineDealsEntity.getDepartmentsEntity().getId());
					plDeals.setDepartmentName(
							pipelineDealsEntity.getDepartmentsEntity().getDescription());
				}
				
				if(pipelineDealsEntity.getApplicationStatusEntity() != null) {
					plDeals.setAppStatusId(
							pipelineDealsEntity.getApplicationStatusEntity().getId());
					plDeals.setAppStatusDescription(
							pipelineDealsEntity.getApplicationStatusEntity().getDescription());
				}
				
				if(pipelineDealsEntity.getFoAnalystName() != null) {
					plDeals.setFoAnalystId(
							pipelineDealsEntity.getFoAnalystName().getCode());
					plDeals.setFoAnalystName(
							pipelineDealsEntity.getFoAnalystName().getName());
				}
				
				if(pipelineDealsEntity.getApplicationTypeEntity() != null) {
					plDeals.setApplicationType(
							pipelineDealsEntity.getApplicationTypeEntity().getId());
					plDeals.setApplicationTypeDescription(
							pipelineDealsEntity.getApplicationTypeEntity().getDescription());
				}
				
				plDeals.setActivityStatus(pipelineDealsEntity.getActivityStatus());
				pipelineDealsList.add(plDeals);
			}
		}
		return pipelineDealsList;
	}
	
	/**
	 * This method is used to the list of all pipeline deals for PMG Dashboard
	 */
	public List<DealWorkflow> getAllPMGPipelineDeals() {
		
		List<String> statusList = new ArrayList<String>();
		statusList.add("DSTP");
		
		//For Testing to ashow more rows 
		statusList.add("DSCP");
		statusList.add("DAPM");
		statusList.add("DSCL");
		statusList.add("DCLO");
		statusList.add("DAMN");
		
		List<PMGDealDashboardEntity> pmgDealDashboardEntityList = pMGDealDashboardRepo.findPipelineDealsEntityByAppStatusId(statusList);
		
		List<DealWorkflow> dealWorkflowList = setPMGDashboardDeals(pmgDealDashboardEntityList);
		
		return dealWorkflowList;
	}
	
	/**
	 * This method is used to the set the values fetched from Entity to DTO
	 * of all pipeline deals to display PMG Dashboard
	 */
	private List<DealWorkflow> setPMGDashboardDeals(List<PMGDealDashboardEntity> pmgDealDashboardEntityList) {
		
		List<DealWorkflow> dealWorkflowList = new ArrayList<DealWorkflow>();
		
		if (dealWorkflowList != null) {
			for(PMGDealDashboardEntity pmgDealDashboardEntity : pmgDealDashboardEntityList) {
				
				DealWorkflow dealWorkflow = new DealWorkflow();
				
				if(pmgDealDashboardEntity != null) {
					dealWorkflow.setPipelineId(pmgDealDashboardEntity.getId());
					dealWorkflow.setSunId(pmgDealDashboardEntity.getSunId());
					dealWorkflow.setBorrowerName(pmgDealDashboardEntity.getBorrowerName());
					
					PipelineDealsEntity pipelineDealsEntity = getPipelineDealsEntity(pmgDealDashboardEntity.getId());
					dealWorkflow.setDealName(pipelineDealsEntity.getDealName());
					
					if(pmgDealDashboardEntity.getPipelineDealsBasicsEntity() != null) {
						PipelineDealsBasicsEntity pipelineBasicsEntity = pmgDealDashboardEntity.getPipelineDealsBasicsEntity();
						dealWorkflow.setPmgOfficer(pipelineBasicsEntity.getpMGOfficerEntity().getCode());
						dealWorkflow.setPmgOfficerName(pipelineBasicsEntity.getpMGOfficerEntity().getName());
						dealWorkflow.setDateReceived(
								LADUtils.formatDatetoString(pipelineBasicsEntity.getReceiptDealDate()));
						dealWorkflow.setRequestedAmount(
								LADUtils.convertDoubleToString(pipelineBasicsEntity.getProposedTotalLimit()));
					}
					
					if(pmgDealDashboardEntity.getPipelineDealsCreditEntity() != null) {
						PipelineDealsCreditEntity pipelineDealsCreditEntity = pmgDealDashboardEntity.getPipelineDealsCreditEntity();
						dealWorkflow.setCatf(pipelineDealsCreditEntity.getCatf());
						dealWorkflow.setCatfDate(
								LADUtils.formatDatetoString(pipelineDealsCreditEntity.getTargetCatfDate()));
					}
					
					if(pmgDealDashboardEntity.getDepartmentsEntity() != null) {
						dealWorkflow.setBusinessUnit(pmgDealDashboardEntity.getDepartmentId());
						dealWorkflow.setBusinessUnitName(pmgDealDashboardEntity.getDepartmentsEntity().getDescription());
					}
					
					if(pmgDealDashboardEntity.getDealWorkflowEntity() != null) {
						DealWorkflowEntity dealWorkflowEntity = pmgDealDashboardEntity.getDealWorkflowEntity();
						
						dealWorkflow.setDealNo(dealWorkflowEntity.getDealNo());
						dealWorkflow.setPmgStatus(dealWorkflowEntity.getPmgStatus());
						if(dealWorkflowEntity.getPmgStatusEntity() != null) {
							dealWorkflow.setPmgStatusDescription(
									dealWorkflowEntity.getPmgStatusEntity().getDescription());
						}
						
						dealWorkflow.setExposure(dealWorkflowEntity.getExposure());
						dealWorkflow.setTsd(dealWorkflowEntity.getTsd());
						dealWorkflow.setSpdgb(dealWorkflowEntity.getSpdgb());
						dealWorkflow.setApplicationDeadline(
								LADUtils.formatDatetoString(dealWorkflowEntity.getApplicationDeadline()));
						dealWorkflow.setGbrCirculationByPMG(
								LADUtils.formatDatetoString(dealWorkflowEntity.getGbrCirculationByPMG()));
					}
					
					dealWorkflowList.add(dealWorkflow);
				}
			}
		}
		
		return dealWorkflowList;
	}
	
	/**
	 * This method is used to get the pipeline details for the given pipeline id
	 */
	public PipelineDealsBasics getPipelineDetailsById(int pipelineId)  {
		
		PipelineDealsBasics pipelineDealsBasics = new PipelineDealsBasics();
		PipelineDealsCredit pipelineDealsCredit = new PipelineDealsCredit();
		
		PipelineDealsEntity pipelineDealsEntity = getPipelineDealsEntity(pipelineId);
		PipelineDealsBasicsEntity pipelineDealsBasicsEntity = getPipelineDealsBasicsEntity(pipelineId);
		PipelineDealsCreditEntity pipelineDealsCreditEntity = getPipelineDealsCreditEntity(pipelineId);
		
		//Header
		pipelineDealsBasics.setPipelineId(pipelineId);
		pipelineDealsBasics.setSunId(pipelineDealsEntity.getSunId());
		pipelineDealsBasics.setBorrowerName(pipelineDealsEntity.getBorrowerName());
		pipelineDealsBasics.setParentId(pipelineDealsEntity.getParentId());
		pipelineDealsBasics.setParentName(pipelineDealsEntity.getParentName());
		pipelineDealsBasics.setGroupName(pipelineDealsEntity.getGroupId());
		pipelineDealsBasics.setDealName(pipelineDealsEntity.getDealName());
		
		if(pipelineDealsEntity.getRelationManagerName() != null) {
			pipelineDealsBasics.setRelationshipManagerId(
					pipelineDealsEntity.getRelationManagerName().getCode());
			pipelineDealsBasics.setRelationshipManagerName(
					pipelineDealsEntity.getRelationManagerName().getName());
		}
		
		if(pipelineDealsEntity.getCategoryEntity() != null) {
			pipelineDealsBasics.setCategoryId(
					pipelineDealsEntity.getCategoryEntity().getId());
			pipelineDealsBasics.setCategoryName(
					pipelineDealsEntity.getCategoryEntity().getDescription());
		}
		
		if(pipelineDealsEntity.getSubCategoryEntity() != null) {
			pipelineDealsBasics.setSubCategoryId(
					pipelineDealsEntity.getSubCategoryEntity().getId());
			pipelineDealsBasics.setSubCategoryName(
					pipelineDealsEntity.getSubCategoryEntity().getDescription());
		}
		
		if(pipelineDealsEntity.getDepartmentsEntity() != null) {
			pipelineDealsBasics.setDepartmentId(
					pipelineDealsEntity.getDepartmentsEntity().getId());
			pipelineDealsBasics.setDepartmentName(
					pipelineDealsEntity.getDepartmentsEntity().getDescription());
		}
		
		if(pipelineDealsEntity.getApplicationStatusEntity() != null) {
			pipelineDealsBasics.setAppStatusId(
					pipelineDealsEntity.getApplicationStatusEntity().getId());
			pipelineDealsBasics.setAppStatusDescription(
					pipelineDealsEntity.getApplicationStatusEntity().getDescription());
		}
		
		pipelineDealsBasics.setExpectedClosingDate(
				LADUtils.formatDatetoString(pipelineDealsEntity.getExpectedClosingDate()));
		
		if(pipelineDealsEntity.getFoAnalystName() != null) {
			pipelineDealsBasics.setFoAnalystId(
					pipelineDealsEntity.getFoAnalystName().getCode());
			pipelineDealsBasics.setFoAnalystName(
					pipelineDealsEntity.getFoAnalystName().getName());
		}
		
		if(pipelineDealsEntity.getApplicationTypeEntity() != null) {
			pipelineDealsBasics.setApplicationType(
					pipelineDealsEntity.getApplicationTypeEntity().getId());
			pipelineDealsBasics.setApplicationTypeDescription(
					pipelineDealsEntity.getApplicationTypeEntity().getDescription());
		}
		
		//Basics
		
		if(pipelineDealsBasicsEntity.getCurrencyEntity() != null) {
			pipelineDealsBasics.setCurrencyCode(
					pipelineDealsBasicsEntity.getCurrencyEntity().getId());
			pipelineDealsBasics.setCurrencyCodeDescription(
					pipelineDealsBasicsEntity.getCurrencyEntity().getDescription());
		}
		
		pipelineDealsBasics.setCurrentFacilityLimit(pipelineDealsBasicsEntity.getCurrentFacilityLimit());
		pipelineDealsBasics.setCurrentTotalLimit(pipelineDealsBasicsEntity.getCurrentTotalLimit());
		pipelineDealsBasics.setCurrentFacilityLimitCurrency(pipelineDealsBasicsEntity.getCurrentFacilityLimitCurrency());
		pipelineDealsBasics.setCurrentTotalLimitCurrency(pipelineDealsBasicsEntity.getCurrentTotalLimitCurrency());
		pipelineDealsBasics.setRegion(pipelineDealsBasicsEntity.getRegion());
		
		if(pipelineDealsBasicsEntity.getsMBCRoleEntity() != null) {
			pipelineDealsBasics.setSmbcRole(
					pipelineDealsBasicsEntity.getsMBCRoleEntity().getId());
			pipelineDealsBasics.setSmbcRoleDescription(
					pipelineDealsBasicsEntity.getsMBCRoleEntity().getDescription());
		}
		
		if(pipelineDealsBasicsEntity.getProcessTypeEntity() != null) {
			pipelineDealsBasics.setProcessType(
					pipelineDealsBasicsEntity.getProcessTypeEntity().getId());
			pipelineDealsBasics.setProcessTypeDescription(
					pipelineDealsBasicsEntity.getProcessTypeEntity().getDescription());
		}
		
		pipelineDealsBasics.setUnderwritingDistribution(pipelineDealsBasicsEntity.getUnderwritingDistribution());
		pipelineDealsBasics.setProposedFacilityLimit(pipelineDealsBasicsEntity.getProposedFacilityLimit());
		pipelineDealsBasics.setProposedTotalLimit(pipelineDealsBasicsEntity.getProposedTotalLimit());
		pipelineDealsBasics.setChangeTotalLimit(pipelineDealsBasicsEntity.getChangeTotalLimit());
		pipelineDealsBasics.setProposedFacilityLimitCurrency(pipelineDealsBasicsEntity.getProposedFacilityLimitCurrency());
		pipelineDealsBasics.setProposedTotalLimitCurrency(pipelineDealsBasicsEntity.getProposedTotalLimitCurrency());
		pipelineDealsBasics.setSeniorLeverage(pipelineDealsBasicsEntity.getSeniorLeverage());
		pipelineDealsBasics.setTotalLeverage(pipelineDealsBasicsEntity.getTotalLeverage());
		pipelineDealsBasics.setEbitda(pipelineDealsBasicsEntity.getEbitda());
		
		pipelineDealsBasics.setReceiptDealDate(
				LADUtils.formatDatetoString(pipelineDealsBasicsEntity.getReceiptDealDate()));
		
		pipelineDealsBasics.setTeamPriorityRanking(
				LADUtils.formatStringtoInt(pipelineDealsBasicsEntity.getPriorityRankingEntity().getId()));
		
		pipelineDealsBasics.setTeamPriorityDescription(pipelineDealsBasicsEntity.getPriorityRankingEntity().getDescription());
		
		pipelineDealsBasics.setSubmissionDate(
				LADUtils.formatDatetoString(pipelineDealsBasicsEntity.getSubmissionDate()));
		
		pipelineDealsBasics.setTargetApprovalDate(
				LADUtils.formatDatetoString(pipelineDealsBasicsEntity.getTargetApprovalDate()));
		pipelineDealsBasics.setClosingDate(
				LADUtils.formatDatetoString(pipelineDealsBasicsEntity.getClosingDate()));
		
		if(pipelineDealsBasicsEntity.getSponsorsEntity() != null) {
			pipelineDealsBasics.setSponsorId(
					pipelineDealsBasicsEntity.getSponsorsEntity().getId());
			pipelineDealsBasics.setSponsorName(
					pipelineDealsBasicsEntity.getSponsorsEntity().getName());
		}
		
		pipelineDealsBasics.setBusiness(pipelineDealsBasicsEntity.getBusiness());
		pipelineDealsBasics.setBorrowerType(pipelineDealsBasicsEntity.getBorrowerType());
		pipelineDealsBasics.setCdadApprovingTransaction(pipelineDealsBasicsEntity.getCdadApprovingTransaction());
		
		if(pipelineDealsBasicsEntity.getcDADOfficerEntity() != null) {
			pipelineDealsBasics.setCdadApprovingOfficer(
					pipelineDealsBasicsEntity.getcDADOfficerEntity().getCode());
			pipelineDealsBasics.setCdadApprovingOfficerName(
					pipelineDealsBasicsEntity.getcDADOfficerEntity().getName());
		}
		
		pipelineDealsBasics.setAuthorityLevelRequired(pipelineDealsBasicsEntity.getAuthorityLevelRequired());
		pipelineDealsBasics.setKyogiRequired(pipelineDealsBasicsEntity.getKyogiRequired());
		pipelineDealsBasics.setPmgApproving(pipelineDealsBasicsEntity.getPmgApproving());
		
		if(pipelineDealsBasicsEntity.getpMGOfficerEntity() != null) {
			pipelineDealsBasics.setPmgOfficer(
					pipelineDealsBasicsEntity.getpMGOfficerEntity().getCode());
			pipelineDealsBasics.setPmgOfficerName(
					pipelineDealsBasicsEntity.getpMGOfficerEntity().getName());
		}
		
		pipelineDealsBasics.setBcdadApproving(pipelineDealsBasicsEntity.getBcdadApproving());
		
		if(pipelineDealsBasicsEntity.getbCDADOfficerEntity() != null) {
			pipelineDealsBasics.setBcdadOfficer(
					pipelineDealsBasicsEntity.getbCDADOfficerEntity().getCode());
			pipelineDealsBasics.setBcdadOfficerName(
					pipelineDealsBasicsEntity.getbCDADOfficerEntity().getName());
		}
		//Credit
		pipelineDealsCredit.setApplicationNumber(pipelineDealsCreditEntity.getApplicationNumber());
		pipelineDealsCredit.setCatf(pipelineDealsCreditEntity.getCatf());
		pipelineDealsCredit.setTargetCatfDate(
				LADUtils.formatDatetoString(pipelineDealsCreditEntity.getTargetCatfDate()));
		
		pipelineDealsCredit.setMdpr(pipelineDealsCreditEntity.getMdpr());
		pipelineDealsCredit.setMnpi(pipelineDealsCreditEntity.getMnpi());
		pipelineDealsCredit.setSmun_id(pipelineDealsCreditEntity.getSmun_id());
		pipelineDealsCredit.setBorrowerCreditGrade(pipelineDealsCreditEntity.getBorrowerCreditGrade());
		
		if(pipelineDealsCreditEntity.getsNPRatingEntity() != null) {
			pipelineDealsCredit.setSnpRating(pipelineDealsCreditEntity.getsNPRatingEntity().getId());
			pipelineDealsCredit.setSnpRatingDescription(pipelineDealsCreditEntity.getsNPRatingEntity().getDescription());
		}
		
		if(pipelineDealsCreditEntity.getsNPOutlookEntity() != null) {
			pipelineDealsCredit.setSnpOutlook(pipelineDealsCreditEntity.getsNPOutlookEntity().getId());
			pipelineDealsCredit.setSnpOutlookDescription(pipelineDealsCreditEntity.getsNPOutlookEntity().getDescription());
		}
		
		if(pipelineDealsCreditEntity.getMoodysRatingEntity() != null) {
			pipelineDealsCredit.setMoodyRating(pipelineDealsCreditEntity.getMoodysRatingEntity().getId());
			pipelineDealsCredit.setMoodyRatingDescription(pipelineDealsCreditEntity.getMoodysRatingEntity().getDescription());
		}
		
		if(pipelineDealsCreditEntity.getMoodysOutlookEntity() != null) {
			pipelineDealsCredit.setMoodyOutlook(pipelineDealsCreditEntity.getMoodysOutlookEntity().getId());
			pipelineDealsCredit.setMoodyOutlookDescription(pipelineDealsCreditEntity.getMoodysOutlookEntity().getDescription());
		}
		
		if(pipelineDealsCreditEntity.getPassWatchEntity() != null) {
			pipelineDealsCredit.setPassWatchId(pipelineDealsCreditEntity.getPassWatchEntity().getId());
			pipelineDealsCredit.setPassWatchDescription(pipelineDealsCreditEntity.getPassWatchEntity().getDescription());
		}
		
		pipelineDealsBasics.setPipelineDealsCredit(pipelineDealsCredit);
		return pipelineDealsBasics;
	}
	
	/**
	 * This method is used to update the pipeline details
	 */
	public String updatePipelineDetailsById(int pipelineId,PipelineDealsBasics pipelineDealsBasics) throws Exception {
		
		PipelineDealsEntity pipelineDealsEntity = getPipelineDealsEntity(pipelineId);
		PipelineDealsBasicsEntity pipelineDealsBasicsEntity = getPipelineDealsBasicsEntity(pipelineId);
		PipelineDealsCreditEntity pipelineDealsCreditEntity = getPipelineDealsCreditEntity(pipelineId);
		
		//pipelineDealsEntity.setSunId(pipelineDealsBasics.getSunId());
		//pipelineDealsEntity.setBorrowerName(pipelineDealsBasics.getBorrowerName());
		
		//Header
		pipelineDealsEntity.setRelationManagerId(pipelineDealsBasics.getRelationshipManagerId());
		//pipelineDealsEntity.setGroupId(pipelineDealsBasics.getGroupName());
		//pipelineDealsEntity.setDealName(pipelineDealsBasics.getDealName());
		pipelineDealsEntity.setCategoryId(pipelineDealsBasics.getCategoryId());
		pipelineDealsEntity.setSubCategoryId(pipelineDealsBasics.getSubCategoryId());
		pipelineDealsEntity.setDepartmentId(pipelineDealsBasics.getDepartmentId());
		pipelineDealsEntity.setApplicationStatusId(pipelineDealsBasics.getAppStatusId());
		pipelineDealsEntity.setFoAnalystId(pipelineDealsBasics.getFoAnalystId());	
		pipelineDealsEntity.setExpectedClosingDate(
				LADUtils.formatStringtoDate(pipelineDealsBasics.getExpectedClosingDate()));
		pipelineDealsEntity.setApplicationType(pipelineDealsBasics.getApplicationType());
		
		String smunId = pipelineDealsBasics.getPipelineDealsCredit().getSmun_id();
		//Company company = lookupDataService.getCompanyBySmunId(smunId);
		//pipelineDealsEntity.setBorrowerName(company.getCompanyName());
		
		//Basics
		pipelineDealsBasicsEntity.setCurrencyCode(pipelineDealsBasics.getCurrencyCode());
		pipelineDealsBasicsEntity.setCurrentFacilityLimit(pipelineDealsBasics.getCurrentFacilityLimit());
		pipelineDealsBasicsEntity.setCurrentTotalLimit(pipelineDealsBasics.getCurrentTotalLimit());
		pipelineDealsBasicsEntity.setCurrentFacilityLimitCurrency(pipelineDealsBasics.getCurrentFacilityLimitCurrency());
		pipelineDealsBasicsEntity.setCurrentTotalLimitCurrency(pipelineDealsBasics.getCurrentTotalLimitCurrency());
		pipelineDealsBasicsEntity.setRegion(pipelineDealsBasics.getRegion());
		pipelineDealsBasicsEntity.setSmbcRole(pipelineDealsBasics.getSmbcRole());
		pipelineDealsBasicsEntity.setProcessType(pipelineDealsBasics.getProcessType());
		pipelineDealsBasicsEntity.setUnderwritingDistribution(pipelineDealsBasics.getUnderwritingDistribution());
		pipelineDealsBasicsEntity.setProposedFacilityLimit(pipelineDealsBasics.getProposedFacilityLimit());
		pipelineDealsBasicsEntity.setProposedTotalLimit(pipelineDealsBasics.getProposedTotalLimit());
		pipelineDealsBasicsEntity.setChangeTotalLimit(pipelineDealsBasics.getChangeTotalLimit());
		pipelineDealsBasicsEntity.setProposedFacilityLimitCurrency(pipelineDealsBasics.getProposedFacilityLimitCurrency());
		pipelineDealsBasicsEntity.setProposedTotalLimitCurrency(pipelineDealsBasics.getProposedTotalLimitCurrency());
		pipelineDealsBasicsEntity.setSeniorLeverage(pipelineDealsBasics.getSeniorLeverage());
		pipelineDealsBasicsEntity.setTotalLeverage(pipelineDealsBasics.getTotalLeverage());
		pipelineDealsBasicsEntity.setEbitda(pipelineDealsBasics.getEbitda());

		pipelineDealsBasicsEntity.setReceiptDealDate(
				LADUtils.formatStringtoDate(pipelineDealsBasics.getReceiptDealDate()));

		pipelineDealsBasicsEntity.setTeamPriorityRanking(
				pipelineDealsBasics.getTeamPriorityRanking());
		
		pipelineDealsBasicsEntity.setSubmissionDate(
				LADUtils.formatStringtoDate(pipelineDealsBasics.getSubmissionDate()));

		pipelineDealsBasicsEntity.setTargetApprovalDate(
				LADUtils.formatStringtoDate(pipelineDealsBasics.getTargetApprovalDate()));
		pipelineDealsBasicsEntity.setClosingDate(
				LADUtils.formatStringtoDate(pipelineDealsBasics.getClosingDate()));
		
		pipelineDealsBasicsEntity.setSponsorId(pipelineDealsBasics.getSponsorId());
		pipelineDealsBasicsEntity.setBusiness(pipelineDealsBasics.getBusiness());
		pipelineDealsBasicsEntity.setBorrowerType(pipelineDealsBasics.getBorrowerType());
		pipelineDealsBasicsEntity.setCdadApprovingTransaction(pipelineDealsBasics.getCdadApprovingTransaction());
		pipelineDealsBasicsEntity.setCdadApprovingOfficer(pipelineDealsBasics.getCdadApprovingOfficer());
		pipelineDealsBasicsEntity.setAuthorityLevelRequired(pipelineDealsBasics.getAuthorityLevelRequired());
		pipelineDealsBasicsEntity.setKyogiRequired(pipelineDealsBasics.getKyogiRequired());
		pipelineDealsBasicsEntity.setPmgApproving(pipelineDealsBasics.getPmgApproving());
		pipelineDealsBasicsEntity.setPmgOfficer(pipelineDealsBasics.getPmgOfficer());
		pipelineDealsBasicsEntity.setBcdadApproving(pipelineDealsBasics.getBcdadApproving());
		pipelineDealsBasicsEntity.setBcdadOfficer(pipelineDealsBasics.getBcdadOfficer());
		
		//Credit
		PipelineDealsCredit pipelineDealsCredit = pipelineDealsBasics.getPipelineDealsCredit();		
		pipelineDealsCreditEntity.setApplicationNumber(pipelineDealsCredit.getApplicationNumber());
		pipelineDealsCreditEntity.setCatf(pipelineDealsCredit.getCatf());
		pipelineDealsCreditEntity.setTargetCatfDate(
				LADUtils.formatStringtoDate(pipelineDealsCredit.getTargetCatfDate()));
		
		pipelineDealsCreditEntity.setMdpr(pipelineDealsCredit.getMdpr());
		pipelineDealsCreditEntity.setMnpi(pipelineDealsCredit.getMnpi());
		pipelineDealsCreditEntity.setSmun_id(pipelineDealsCredit.getSmun_id());
		pipelineDealsCreditEntity.setBorrowerCreditGrade(
					pipelineDealsCredit.getBorrowerCreditGrade());
		pipelineDealsCreditEntity.setSnpRating(pipelineDealsCredit.getSnpRating());
		pipelineDealsCreditEntity.setSnpOutlook(pipelineDealsCredit.getSnpOutlook());
		pipelineDealsCreditEntity.setMoodyRating(pipelineDealsCredit.getMoodyRating());
		pipelineDealsCreditEntity.setMoodyOutlook(pipelineDealsCredit.getMoodyOutlook());
		pipelineDealsCreditEntity.setPassWatch(pipelineDealsCredit.getPassWatchId());
		
		pipelineDealsRepo.save(pipelineDealsEntity);
		pipelineDealsBasicsRepo.save(pipelineDealsBasicsEntity);
		pipelineDealsCreditRepo.save(pipelineDealsCreditEntity);
				
		return "Success";
	}
	
	
	/**
	 * This method is used to get the master pipeline details of the given pipeline id
	 * @param pipelineId
	 * @return
	 */
	public PipelineDealsEntity getPipelineDealsEntity(int pipelineId) {
		PipelineDealsEntity pipelineDealsEntity = pipelineDealsRepo.findById(pipelineId);
		if(pipelineDealsEntity == null) {
			throw new SMBCResourceNotFoundException("Pipeline deals not found for the pipline id " + pipelineId);
		}
		
		return pipelineDealsEntity;
	}
	
	/**
	 * This method is used to get the basic pipeline details of the given pipeline id
	 * @param pipelineId
	 * @return
	 */
	public PipelineDealsBasicsEntity getPipelineDealsBasicsEntity(int pipelineId) {
		PipelineDealsBasicsEntity pipelineDealsBasicsEntity = pipelineDealsBasicsRepo.findByPipelineId(pipelineId);
		if(pipelineDealsBasicsEntity == null) {
			throw new SMBCResourceNotFoundException("Pipeline deals basic details not found for the pipline id " + pipelineId);
		}
		
		return pipelineDealsBasicsEntity;
	}
	
	/**
	 * This method is used to get the credit pipeline details of the given pipeline id
	 * @param pipelineId
	 * @return
	 */
	public PipelineDealsCreditEntity getPipelineDealsCreditEntity(int pipelineId) {
		PipelineDealsCreditEntity pipelineDealsCreditEntity = pipelineDealsCreditRepo.findByPipelineId(pipelineId);
		if(pipelineDealsCreditEntity == null) {
			throw new SMBCResourceNotFoundException("Pipeline deals credit details not found for the pipline id " + pipelineId);
		}
		
		return pipelineDealsCreditEntity;
	}
	
	/**
	 * This method is used to update the master pipeline details of the given pipeline id
	 * @param pipelineId
	 * @return
	 */
	public void savePipelineDealsEntity(PipelineDealsEntity pipelineDealsEntity) {
		pipelineDealsRepo.save(pipelineDealsEntity);
	}
	
	/**
	 * This method is used to update the basic pipeline details of the given pipeline id
	 * @param pipelineId
	 * @return
	 */
	public void savePipelineDealsBasicsEntity(PipelineDealsBasicsEntity pipelineDealsBasicsEntity) {
		pipelineDealsBasicsRepo.save(pipelineDealsBasicsEntity);
	}
	
	/**
	 * This method is used to update the credit pipeline details of the given pipeline id
	 * @param pipelineId
	 * @return
	 */
	public void savePipelineDealsCreditEntity(PipelineDealsCreditEntity pipelineDealsCreditEntity) {
		pipelineDealsCreditRepo.save(pipelineDealsCreditEntity);
	}
	
	/**
	 * This method is used to get the list of deals for the given borrower id
	 * @param sunId
	 * @return
	 */
	public List<PipelineDeals> getAllDealNamesByBorrowerId(String sunId) {
		List<PipelineDealsEntity> pipelineDealsEntityList = pipelineDealsRepo.findBySunId(sunId);
		
		List<PipelineDeals> pipelineDealsList = new ArrayList<PipelineDeals>();
		if (pipelineDealsEntityList != null) {
			for(PipelineDealsEntity pipelineDealsEntity : pipelineDealsEntityList) {
				
				PipelineDeals plDeals = new PipelineDeals();
				plDeals.setPipelineId(pipelineDealsEntity.getId());
				plDeals.setDealName(pipelineDealsEntity.getDealName());
				pipelineDealsList.add(plDeals);
			}
		}
		
		return pipelineDealsList;
	}
		
}
