package com.smbc.lad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.CreditInquiry;
import com.smbc.lad.entity.pipeline.CreditInquiryEntity;
import com.smbc.lad.entity.pipeline.PipelineDealsBasicsEntity;
import com.smbc.lad.entity.pipeline.PipelineDealsCreditEntity;
import com.smbc.lad.entity.pipeline.PipelineDealsEntity;
import com.smbc.lad.repository.pipeline.CreditInquiryRepo;
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
public class CreditInquiryServiceImpl implements CreditInquiryService {

	@Autowired
	private PipelineDealsService pipelineDealsService;
	
	@Autowired
	private CreditInquiryRepo creditInquiryRepo;
		
	/**
	 * This method is used to get the Credit Inquiry details for the given pipeline id
	 */
	public CreditInquiry getCreditInquiryById(int pipelineId) {
		
		CreditInquiry creditInquiry = new CreditInquiry();
		
		PipelineDealsEntity pipelineDealsEntity = pipelineDealsService.getPipelineDealsEntity(pipelineId);
		PipelineDealsBasicsEntity pipelineDealsBasicsEntity = pipelineDealsService.getPipelineDealsBasicsEntity(pipelineId);
		PipelineDealsCreditEntity pipelineDealsCreditEntity = pipelineDealsService.getPipelineDealsCreditEntity(pipelineId);
		
		if(pipelineDealsEntity != null) {
			creditInquiry.setSunId(pipelineDealsEntity.getSunId());
			creditInquiry.setBorrowerName(pipelineDealsEntity.getBorrowerName());
			creditInquiry.setParentName(pipelineDealsEntity.getParentName());
		}
		creditInquiry.setPipelineId(pipelineId);
		if(pipelineDealsBasicsEntity != null) {
			creditInquiry.setReceiptDealDate(
				LADUtils.formatDatetoString(pipelineDealsBasicsEntity.getReceiptDealDate()));
			creditInquiry.setTargetApprovalDate(
					LADUtils.formatDatetoString(pipelineDealsBasicsEntity.getTargetApprovalDate()));
			creditInquiry.setBorrowerType(pipelineDealsBasicsEntity.getBorrowerType());
		}
		
		if(pipelineDealsCreditEntity != null) {
			creditInquiry.setMdpr(pipelineDealsCreditEntity.getMdpr());
			creditInquiry.setCatf(pipelineDealsCreditEntity.getCatf());
			creditInquiry.setCatfDate(
					LADUtils.formatDatetoString(pipelineDealsCreditEntity.getTargetCatfDate()));
			creditInquiry.setMnpi(pipelineDealsCreditEntity.getMnpi());
		}
		
		CreditInquiryEntity creditInquiryEntity = creditInquiryRepo.findByPipelineId(pipelineId);
		
		
		if (creditInquiryEntity != null) {
			creditInquiry.setApprovalAuth(creditInquiryEntity.getApprovalAuth());
			creditInquiry.setRacException(creditInquiryEntity.getRacException());
			
			creditInquiry.setLeverageLoan(creditInquiryEntity.getLeverageLoan());
			
			creditInquiry.setPmg(creditInquiryEntity.getPmg());
			creditInquiry.setPmgDate(
					LADUtils.formatDatetoString(creditInquiryEntity.getPmgDate()));
			
			creditInquiry.setMdprDate(
					LADUtils.formatDatetoString(creditInquiryEntity.getMdprDate()));
			
			creditInquiry.setCiNotes(creditInquiryEntity.getCiNotes());
		}
		
		return creditInquiry;
	}

	/**
	 * This method is used to update the Credit Inquiry details for the given pipeline id
	 */
	public String updateCreditInquiryById(int pipelineId,CreditInquiry creditInquiry) throws Exception {
		
		PipelineDealsBasicsEntity pipelineDealsBasicsEntity = pipelineDealsService.getPipelineDealsBasicsEntity(pipelineId);
		PipelineDealsCreditEntity pipelineDealsCreditEntity = pipelineDealsService.getPipelineDealsCreditEntity(pipelineId);
		
		CreditInquiryEntity creditInquiryEntity = creditInquiryRepo.findByPipelineId(pipelineId);
		
		if(creditInquiryEntity == null) {
			creditInquiryEntity = new CreditInquiryEntity();
			creditInquiryEntity.setPipelineId(pipelineId);
			creditInquiryEntity.setSunId(pipelineDealsBasicsEntity.getSunId());
		}
		
		creditInquiryEntity.setApprovalAuth(creditInquiry.getApprovalAuth());
		creditInquiryEntity.setRacException(creditInquiry.getRacException());
		
		creditInquiryEntity.setLeverageLoan(creditInquiry.getLeverageLoan());
		creditInquiryEntity.setPmg(creditInquiry.getPmg());
		creditInquiryEntity.setPmgDate(
				LADUtils.formatStringtoDate(creditInquiry.getPmgDate()));
		creditInquiryEntity.setMdprDate(
				LADUtils.formatStringtoDate(creditInquiry.getMdprDate()));
		
		creditInquiryEntity.setCiNotes(creditInquiry.getCiNotes());
		
		creditInquiryRepo.save(creditInquiryEntity);
		
		if(pipelineDealsBasicsEntity != null) {
			pipelineDealsBasicsEntity.setReceiptDealDate(
					LADUtils.formatStringtoDate(creditInquiry.getReceiptDealDate()));
			pipelineDealsBasicsEntity.setTargetApprovalDate(
					LADUtils.formatStringtoDate(creditInquiry.getTargetApprovalDate()));
			pipelineDealsBasicsEntity.setBorrowerType(creditInquiry.getBorrowerType());
			pipelineDealsService.savePipelineDealsBasicsEntity(pipelineDealsBasicsEntity);
		}
		
		if(pipelineDealsCreditEntity != null) {
			pipelineDealsCreditEntity.setMdpr(creditInquiry.getMdpr());
			pipelineDealsCreditEntity.setCatf(creditInquiry.getCatf());
			pipelineDealsCreditEntity.setTargetCatfDate(
					LADUtils.formatStringtoDate(creditInquiry.getCatfDate()));
			pipelineDealsCreditEntity.setMnpi(creditInquiry.getMnpi());
			pipelineDealsService.savePipelineDealsCreditEntity(pipelineDealsCreditEntity);
		}
		
		return "Success";
	}
	
}
