package com.smbc.lad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.DealWorkflow;
import com.smbc.lad.dto.pipeline.PipelineDealsBasics;
import com.smbc.lad.entity.pipeline.DealWorkflowEntity;
import com.smbc.lad.repository.pipeline.DealWorkflowRepo;
import com.smbc.lad.utils.LADUtils;


/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an implementation class for the DealWorkflowService. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
@Service
public class DealWorkflowServiceImpl implements DealWorkflowService {

	@Autowired
	private DealWorkflowRepo dealWorkflowRepo;
	
	@Autowired
	private PipelineDealsService pipelineDealsService;
	
	/**
	 * This method is used to get the deal workflow details for the given pipeline id
	 */
	public DealWorkflow getDealWorkflow(int pipelineId) {
		
		DealWorkflow dealWorkflow = new DealWorkflow();
		
		DealWorkflowEntity dealWorkflowEntity = dealWorkflowRepo.findByPipelineId(pipelineId);
		PipelineDealsBasics pipelineDetails = pipelineDealsService.getPipelineDetailsById(pipelineId);
		
		if(dealWorkflowEntity != null) {
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
			dealWorkflow.setDealNotes(dealWorkflowEntity.getDealNotes());
		}
		
		
		if(pipelineDetails != null) {
			dealWorkflow.setPipelineId(pipelineDetails.getPipelineId());
			dealWorkflow.setSunId(pipelineDetails.getSunId());
			dealWorkflow.setBorrowerName(pipelineDetails.getBorrowerName());
			
			dealWorkflow.setPmgOfficer(pipelineDetails.getPmgOfficer());
			dealWorkflow.setPmgOfficerName(pipelineDetails.getPmgOfficerName());
			
			dealWorkflow.setDateReceived(pipelineDetails.getReceiptDealDate());
			dealWorkflow.setDealName(pipelineDetails.getDealName());
			dealWorkflow.setRequestedAmount(
				LADUtils.convertDoubleToString(pipelineDetails.getProposedTotalLimit()));
			if(pipelineDetails.getPipelineDealsCredit() != null) {
				dealWorkflow.setCatf(pipelineDetails.getPipelineDealsCredit().getCatf());
				dealWorkflow.setCatfDate(pipelineDetails.getPipelineDealsCredit().getTargetCatfDate());
			}
			
			dealWorkflow.setBusinessUnit(pipelineDetails.getDepartmentId());
			dealWorkflow.setBusinessUnitName(pipelineDetails.getDepartmentName());
		}
		
		return dealWorkflow;
	}
	
	/**
	 * This method is used to add or update the deal workflow details for the given pipeline id
	 */
	public String addOrUpdateDealWorkflowById(int pipelineId,
			DealWorkflow dealWorkflow) throws Exception {
		
		PipelineDealsBasics pipelineDetails = pipelineDealsService.getPipelineDetailsById(pipelineId);
		
		pipelineDetails.setPmgOfficer(dealWorkflow.getPmgOfficer());
		pipelineDetails.setReceiptDealDate(dealWorkflow.getDateReceived());
		pipelineDetails.setProposedTotalLimit(
			LADUtils.formatStringtoDouble(dealWorkflow.getRequestedAmount()));
		
		pipelineDetails.setDepartmentId(dealWorkflow.getBusinessUnit());
		if(pipelineDetails.getPipelineDealsCredit() != null) {
			pipelineDetails.getPipelineDealsCredit().setCatf(dealWorkflow.getCatf());
			pipelineDetails.getPipelineDealsCredit().setTargetCatfDate(dealWorkflow.getCatfDate());
		}
		pipelineDealsService.updatePipelineDetailsById(pipelineId, pipelineDetails);
		
		DealWorkflowEntity dealWorkflowEntity = new DealWorkflowEntity();
		dealWorkflowEntity.setPipelineId(dealWorkflow.getPipelineId());
		dealWorkflowEntity.setSunId(dealWorkflow.getSunId());
		dealWorkflowEntity.setDealNo(dealWorkflow.getDealNo());
		dealWorkflowEntity.setPmgStatus(dealWorkflow.getPmgStatus());
		dealWorkflowEntity.setExposure(dealWorkflow.getExposure());
		dealWorkflowEntity.setTsd(dealWorkflow.getTsd());
		dealWorkflowEntity.setSpdgb(dealWorkflow.getSpdgb());
		dealWorkflowEntity.setApplicationDeadline(
				LADUtils.formatStringtoDate(dealWorkflow.getApplicationDeadline()));
		dealWorkflowEntity.setGbrCirculationByPMG(
				LADUtils.formatStringtoDate(dealWorkflow.getGbrCirculationByPMG()));
		dealWorkflowEntity.setDealNotes(dealWorkflow.getDealNotes());
		dealWorkflowRepo.save(dealWorkflowEntity);
		
		return "Success";
	}	
}
