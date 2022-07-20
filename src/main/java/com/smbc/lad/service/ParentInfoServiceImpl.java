package com.smbc.lad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.ParentInformation;
import com.smbc.lad.entity.pipeline.ParentInformationEntity;
import com.smbc.lad.entity.pipeline.PipelineDealsCreditEntity;
import com.smbc.lad.entity.pipeline.PipelineDealsEntity;
import com.smbc.lad.repository.pipeline.ParentInformationRepo;
import com.smbc.lad.utils.LADUtils;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an implementation class for the Parent info  entities. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
@Service
public class ParentInfoServiceImpl implements ParentInfoService {

	@Autowired
	private PipelineDealsService pipelineDealsService;
	
	@Autowired
	private ParentInformationRepo parentInformationRepo;
	
	/**
	 * This method is used to get the Parent Info details for the given pipeline id
	 */
	public ParentInformation getParentInformationById(int pipelineId) {
		
		ParentInformation parentInformation = new ParentInformation();
		
		PipelineDealsEntity pipelineDealsEntity = pipelineDealsService.getPipelineDealsEntity(pipelineId);
		PipelineDealsCreditEntity pipelineDealsCreditEntity = pipelineDealsService.getPipelineDealsCreditEntity(pipelineId);
		
		ParentInformationEntity parentInformatioEntity = parentInformationRepo.findByPipelineId(pipelineId);
		
		if (pipelineDealsEntity != null) {
			parentInformation.setPipelineId(pipelineId);
			parentInformation.setSunId(pipelineDealsEntity.getSunId());
			parentInformation.setParentName(pipelineDealsEntity.getParentName());
		}
		
		if (pipelineDealsCreditEntity != null) {			
			parentInformation.setSnpOutlook(pipelineDealsCreditEntity.getSnpOutlook());
			if(pipelineDealsCreditEntity.getsNPOutlookEntity() != null) {
				parentInformation.setSnpOutlookLabel(
						pipelineDealsCreditEntity.getsNPOutlookEntity().getDescription());
			}
			
			parentInformation.setMoodyOutlook(pipelineDealsCreditEntity.getMoodyOutlook());
			if(pipelineDealsCreditEntity.getMoodysOutlookEntity() != null) {
				parentInformation.setMoodyOutlookLabel(
						pipelineDealsCreditEntity.getMoodysOutlookEntity().getDescription());
			}
		}
		
		if(parentInformatioEntity != null) 
		{
			
			parentInformation.setPrimarySmics(parentInformatioEntity.getPrimarySmics());
			
			parentInformation.setSmbcRatingCredit(parentInformatioEntity.getSmbcRatingCredit());
			if (parentInformatioEntity.getSmbcRatingCurrentEntity() != null) {
				parentInformation.setSmbcRatingCreditLabel(
						parentInformatioEntity.getSmbcRatingCurrentEntity().getDescription());
			}
		
			parentInformation.setSmbcRatingProposed(parentInformatioEntity.getSmbcRatingProposed());
			if (parentInformatioEntity.getSmbcRatingProposedEntity() != null) {
				parentInformation.setSmbcRatingProposedLabel(
						parentInformatioEntity.getSmbcRatingProposedEntity().getDescription());
			}
			
			parentInformation.setLeverageLendCurrent(parentInformatioEntity.getLeverageLendCurrent());
			parentInformation.setLeverageLendProposed(parentInformatioEntity.getLeverageLendProposed());
			
			parentInformation.setSnpRating(parentInformatioEntity.getSnpRating());
			if(parentInformatioEntity.getSnpRatingEntity() != null) {
				parentInformation.setSnpRatingLabel(
						parentInformatioEntity.getSnpRatingEntity().getDescription());
			}
			
			parentInformation.setMoodyRating(parentInformatioEntity.getMoodyRating());
			if(parentInformatioEntity.getMoodyRatingEntity() != null) {
				parentInformation.setMoodyRatingLabel(
						parentInformatioEntity.getMoodyRatingEntity().getDescription());
			}
			
			parentInformation.setMarketCapitalization(parentInformatioEntity.getMarketCapitalization());
			
			parentInformation.setUsRegCurrent(parentInformatioEntity.getUsRegCurrent());
			if(parentInformatioEntity.getUsRegCurrentEntity() != null) {
				parentInformation.setUsRegCurrentLabel(
						parentInformatioEntity.getUsRegCurrentEntity().getDescription());
			}
			
			parentInformation.setUsRegCurrentDate(
					LADUtils.formatDatetoString(parentInformatioEntity.getUsRegCurrentDate()));
			
			parentInformation.setUsRegProposed(parentInformatioEntity.getUsRegProposed());
			if(parentInformatioEntity.getUsRegProposedEntity() != null) {
				parentInformation.setUsRegProposedLabel(
						parentInformatioEntity.getUsRegProposedEntity().getDescription());
			}
			
			parentInformation.setReadBySnc(parentInformatioEntity.getReadBySnc());
			parentInformation.setReadBySncDate(
					LADUtils.formatDatetoString(parentInformatioEntity.getReadBySncDate()));
			
			parentInformation.setSncRating(parentInformatioEntity.getSncRating());
			if(parentInformatioEntity.getSncRatingEntity() != null) {
				parentInformation.setSncRatingLabel(
						parentInformatioEntity.getSncRatingEntity().getDescription());
			}
			
			parentInformation.setSncRatingFacility(parentInformatioEntity.getSncRatingFacility());
			
			parentInformation.setDesignatedByDirector(
					parentInformatioEntity.getDesignatedByDirector());
			
			parentInformation.setNaturalResSector(parentInformatioEntity.getNaturalResSector());
			parentInformation.setEsgRisk(parentInformatioEntity.getEsgRisk());
			parentInformation.setMonitoredSector(parentInformatioEntity.getMonitoredSector());
			parentInformation.setPassWatchCurrent(parentInformatioEntity.getPassWatchCurrent());
			parentInformation.setPassWatchCurrentDate(
					LADUtils.formatDatetoString(parentInformatioEntity.getPassWatchCurrentDate()));
			parentInformation.setPassWatchProposed(parentInformatioEntity.getPassWatchProposed());
			parentInformation.setWarningCurrent(parentInformatioEntity.getWarningCurrent());
			parentInformation.setWarningCurrentDate(
					LADUtils.formatDatetoString(parentInformatioEntity.getWarningCurrentDate()));
			parentInformation.setWarningProposed(parentInformatioEntity.getWarningProposed());
			parentInformation.setPiNotes(parentInformatioEntity.getPiNotes());
		}
		
		return parentInformation;
	}
	
	/**
	 * This method is used to update the Parent Info details
	 */
	public String updateParentInformationById(int pipelineId,ParentInformation parentInformation) throws Exception {
		
		PipelineDealsCreditEntity pipelineDealsCreditEntity = pipelineDealsService.getPipelineDealsCreditEntity(pipelineId);
		
		ParentInformationEntity parentInformationEntity = parentInformationRepo.findByPipelineId(pipelineId);
		
		if(parentInformationEntity == null) {
			parentInformationEntity = new ParentInformationEntity();
			parentInformationEntity.setPipelineId(pipelineId);
			parentInformationEntity.setSunId(parentInformation.getSunId());
		}
		
		parentInformationEntity.setPrimarySmics(parentInformation.getPrimarySmics());
		parentInformationEntity.setSmbcRatingCredit(parentInformation.getSmbcRatingCredit());
		parentInformationEntity.setSmbcRatingProposed(parentInformation.getSmbcRatingProposed());
		parentInformationEntity.setLeverageLendCurrent(parentInformation.getLeverageLendCurrent());
		parentInformationEntity.setLeverageLendProposed(parentInformation.getLeverageLendProposed());
		parentInformationEntity.setSnpRating(parentInformation.getSnpRating());
		parentInformationEntity.setMoodyRating(parentInformation.getMoodyRating());
		parentInformationEntity.setMarketCapitalization(parentInformation.getMarketCapitalization());
		parentInformationEntity.setUsRegCurrent(parentInformation.getUsRegCurrent());
		parentInformationEntity.setUsRegCurrentDate(
				LADUtils.formatStringtoDate(parentInformation.getUsRegCurrentDate()));
		parentInformationEntity.setUsRegProposed(parentInformation.getUsRegProposed());
		parentInformationEntity.setReadBySnc(parentInformation.getReadBySnc());
		parentInformationEntity.setReadBySncDate(
				LADUtils.formatStringtoDate(parentInformation.getReadBySncDate()));
		
		parentInformationEntity.setSncRating(parentInformation.getSncRating());
		parentInformationEntity.setSncRatingFacility(parentInformation.getSncRatingFacility());
		parentInformationEntity.setDesignatedByDirector(
				parentInformation.getDesignatedByDirector());
		
		parentInformationEntity.setNaturalResSector(parentInformation.getNaturalResSector());
		parentInformationEntity.setEsgRisk(parentInformation.getEsgRisk());
		parentInformationEntity.setMonitoredSector(parentInformation.getMonitoredSector());
		parentInformationEntity.setPassWatchCurrent(parentInformation.getPassWatchCurrent());
		parentInformationEntity.setPassWatchCurrentDate(
				LADUtils.formatStringtoDate(parentInformation.getPassWatchCurrentDate()));
		parentInformationEntity.setPassWatchProposed(parentInformation.getPassWatchProposed());
		parentInformationEntity.setWarningCurrent(parentInformation.getWarningCurrent());
		parentInformationEntity.setWarningCurrentDate(
				LADUtils.formatStringtoDate(parentInformation.getWarningCurrentDate()));
		parentInformationEntity.setWarningProposed(parentInformation.getWarningProposed());
		parentInformationEntity.setPiNotes(parentInformation.getPiNotes());
		
		//Update parent entity
		parentInformationRepo.save(parentInformationEntity);
		
		//From Pipeline Deals
		if (pipelineDealsCreditEntity != null) {
			pipelineDealsCreditEntity.setSnpOutlook(parentInformation.getSnpOutlook());
			pipelineDealsCreditEntity.setMoodyOutlook(parentInformation.getMoodyOutlook());
			
			pipelineDealsService.savePipelineDealsCreditEntity(pipelineDealsCreditEntity);
		}
		
		return "Success";
	}
	
		
}
