package com.smbc.lad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.IndustryTrends;
import com.smbc.lad.entity.pipeline.IndustryTrendsEntity;
import com.smbc.lad.repository.pipeline.IndustryTrendsRepo;


/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an implementation class for the RelationOrganizationService. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
@Service
public class IndustryTrendsServiceImpl implements IndustryTrendsService {

	@Autowired
	private IndustryTrendsRepo industryTrendsRepo;
	
	/**
	 * This method is used to get the industry trend details for the given pipeline id
	 */
	public IndustryTrends getIndustryTrends(int pipelineId) {
		
		IndustryTrends industryTrends = new IndustryTrends();
		
		IndustryTrendsEntity industryTrendsEntity = industryTrendsRepo.findByPipelineId(pipelineId);
		
		if(industryTrendsEntity != null) {
			industryTrends.setPipelineId(industryTrendsEntity.getPipelineId());
			industryTrends.setParentBorrowerDescription(industryTrendsEntity.getParentBorrowerDescription());
			industryTrends.setManagementAssessment(industryTrendsEntity.getManagementAssessment());
			industryTrends.setIndustrialTrends(industryTrendsEntity.getIndustryTrends());
		}
		
		return industryTrends;
	}
	
	/**
	 * This method is used to update the industry trend details for the given pipeline id
	 */
	public String updateIndustryTrendsById(int pipelineId,
			IndustryTrends industryTrends) throws Exception {
		
		IndustryTrendsEntity industryTrendsEntity = new IndustryTrendsEntity();
		
		industryTrendsEntity.setPipelineId(pipelineId);
		industryTrendsEntity.setParentBorrowerDescription(industryTrends.getParentBorrowerDescription());
		industryTrendsEntity.setManagementAssessment(industryTrends.getManagementAssessment());
		industryTrendsEntity.setIndustryTrends(industryTrends.getIndustrialTrends());
		industryTrendsRepo.save(industryTrendsEntity);
		
		return "Success";
	}	
}
