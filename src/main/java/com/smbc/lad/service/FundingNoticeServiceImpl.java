package com.smbc.lad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.FundingNotice;
import com.smbc.lad.dto.pipeline.FundingTerms;
import com.smbc.lad.entity.pipeline.DealWorkflowEntity;
import com.smbc.lad.entity.pipeline.FundingNoticeEntity;
import com.smbc.lad.entity.pipeline.FundingTermsEntity;
import com.smbc.lad.repository.pipeline.DealWorkflowRepo;
import com.smbc.lad.repository.pipeline.FundingNoticeRepo;
import com.smbc.lad.repository.pipeline.FundingTermsRepo;
import com.smbc.lad.utils.LADUtils;


/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an implementation class for the Transaction Background Service. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
@Service
public class FundingNoticeServiceImpl implements FundingNoticeService {

	@Autowired
	private FundingNoticeRepo fundingNoticeRepo;
	
	@Autowired
	private FundingTermsRepo fundingTermsRepo;
	
	@Autowired
	private DealWorkflowRepo dealWorkflowRepo;
	
	/**
	 * This method is used to get the funding notice details for the given pipeline id
	 */
	public FundingNotice getFundingNotice(int pipelineId) {
		
		FundingNotice fundingNotice = new FundingNotice();
		
		FundingNoticeEntity fundingNoticeEntity = fundingNoticeRepo.findByPipelineId(pipelineId);
		DealWorkflowEntity dealWorkflowEntity = dealWorkflowRepo.findByPipelineId(pipelineId);
		
		
		if(fundingNoticeEntity != null) {
			
			fundingNotice.setPipelineId(fundingNoticeEntity.getPipelineId());
			fundingNotice.setFundingNotes(fundingNoticeEntity.getFundingNotes());
			
			List<FundingTerms> fundingTermsCollection = new ArrayList<FundingTerms>();
			if(fundingNoticeEntity.getFundingTermsEntity() != null) {				
				for(FundingTermsEntity fundingTermsEntity : fundingNoticeEntity.getFundingTermsEntity()) {
					FundingTerms fundingTerms = new FundingTerms();
					fundingTerms.setId(fundingTermsEntity.getId());
					fundingTerms.setPipelineId(fundingTermsEntity.getPipelineId());
					
					fundingTerms.setCurrencyCode(fundingTermsEntity.getCurrencyCode());
					if(fundingTermsEntity.getCurrencyEntity() != null) {
						fundingTerms.setCurrencyDescription(fundingTermsEntity.getCurrencyEntity().getDescription());
					}
					fundingTerms.setDays(fundingTerms.getDays());
					fundingTerms.setTotalAmount(fundingTermsEntity.getTotalAmount());
					fundingTerms.setFundingType(fundingTermsEntity.getFundingTpe());
					fundingTerms.setNoticeTime(fundingTermsEntity.getNoticeTime());
					
					fundingTermsCollection.add(fundingTerms);
				}
			}
			
			fundingNotice.setFundingTerms(fundingTermsCollection);
		}
		
		if(dealWorkflowEntity != null) {
			fundingNotice.setTsdApproval(dealWorkflowEntity.getTsd());
			fundingNotice.setSpdgpApproval(dealWorkflowEntity.getSpdgb());
		}
		
		return fundingNotice;
	}
	
	/**
	 * This method is used to update the transaction background details for the given pipeline id
	 */
	public String updateFundingNoticeById(int pipelineId,
				FundingNotice fundingNotice) throws Exception {
		
		FundingNoticeEntity fundingNoticeEntity = new FundingNoticeEntity();
		fundingNoticeEntity.setPipelineId(pipelineId);
		fundingNoticeEntity.setFundingNotes(fundingNotice.getFundingNotes());
		
		fundingNoticeRepo.save(fundingNoticeEntity);
		
		DealWorkflowEntity dealWorkflowEntity = dealWorkflowRepo.findByPipelineId(pipelineId);
		if(dealWorkflowEntity != null) {
			dealWorkflowEntity.setTsd(fundingNotice.getTsdApproval());
			dealWorkflowEntity.setSpdgb(fundingNotice.getSpdgpApproval());
			dealWorkflowRepo.save(dealWorkflowEntity);
		}
		
		//Upload Files
		List<FundingTerms> fundingTermsList = fundingNotice.getFundingTerms();
		if(fundingTermsList != null) {
			for(int i=0; i<fundingTermsList.size(); i++) {
				FundingTerms fundingTerms = fundingTermsList.get(i);
				
					FundingTermsEntity fundingTermsEntity = new FundingTermsEntity();
					
					fundingTermsEntity.setId(fundingTerms.getId());
					fundingTermsEntity.setPipelineId(fundingTerms.getPipelineId());
					
					fundingTermsEntity.setCurrencyCode(
						LADUtils.setNullIfEmpty(fundingTerms.getCurrencyCode()));
					fundingTermsEntity.setDays(fundingTerms.getDays());
					fundingTermsEntity.setTotalAmount(fundingTerms.getTotalAmount());
					fundingTermsEntity.setFundingType(fundingTerms.getFundingTpe());
					fundingTermsEntity.setNoticeTime(fundingTerms.getNoticeTime());
					
					fundingTermsRepo.save(fundingTermsEntity);
			}
		}
		
		//Delete Files
		if(fundingNotice.getFilesToDeleteIds() != null) {
			int[] filesToDelete = fundingNotice.getFilesToDeleteIds();
			for (int i=0; i<filesToDelete.length;i++) {
				deleteFundingTermFiles(filesToDelete[i]);
			}
		}
		return "Success";
	}
	
	public FundingTerms getFundingTermFiles(int id) {
		
		FundingTermsEntity fundingTermsEntity = fundingTermsRepo.findById(id);
		FundingTerms fundingTerms = new FundingTerms();
		if(fundingTermsEntity != null) {
			fundingTerms.setId(fundingTermsEntity.getId());
			fundingTerms.setPipelineId(fundingTermsEntity.getPipelineId());
			
			fundingTerms.setCurrencyCode(fundingTermsEntity.getCurrencyCode());
			if(fundingTermsEntity.getCurrencyEntity() != null) {
				fundingTerms.setCurrencyDescription(fundingTermsEntity.getCurrencyEntity().getDescription());
			}
			fundingTerms.setDays(fundingTerms.getDays());
			fundingTerms.setTotalAmount(fundingTermsEntity.getTotalAmount());
			fundingTerms.setFundingType(fundingTermsEntity.getFundingTpe());
			fundingTerms.setNoticeTime(fundingTermsEntity.getNoticeTime());
		}
		
		return fundingTerms;
	}
	
	public String deleteFundingTermFiles(int id) {
		FundingTermsEntity fundingTermsEntity = fundingTermsRepo.findById(id);
		if(fundingTermsEntity != null) {
			fundingTermsRepo.delete(fundingTermsEntity);
		}
		return "Success";
	}
	
}
