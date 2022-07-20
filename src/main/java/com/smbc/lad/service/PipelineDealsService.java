package com.smbc.lad.service;

import java.util.List;

import com.smbc.lad.dto.pipeline.DealWorkflow;
import com.smbc.lad.dto.pipeline.PipelineDeals;
import com.smbc.lad.dto.pipeline.PipelineDealsBasics;
import com.smbc.lad.entity.pipeline.PipelineDealsBasicsEntity;
import com.smbc.lad.entity.pipeline.PipelineDealsCreditEntity;
import com.smbc.lad.entity.pipeline.PipelineDealsEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the Pipeline Dashboard, Pipeline Detail and CI  entities. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface PipelineDealsService {

	public List<PipelineDeals> getAllPipelineDeals();
	
	public List<PipelineDeals> getAllCDADPipelineDeals();
	
	public List<DealWorkflow> getAllPMGPipelineDeals();
	
	public PipelineDealsBasics getPipelineDetailsById(int pipelineId);
	
	public String updatePipelineDetailsById(int pipelineId,PipelineDealsBasics pipelineDealsBasics) throws Exception;
	
	public PipelineDealsEntity getPipelineDealsEntity(int pipelineId);
	
	public PipelineDealsBasicsEntity getPipelineDealsBasicsEntity(int pipelineId);
	
	public PipelineDealsCreditEntity getPipelineDealsCreditEntity(int pipelineId);
	
	public void savePipelineDealsEntity(PipelineDealsEntity pipelineDealsEntity);
	
	public void savePipelineDealsBasicsEntity(PipelineDealsBasicsEntity pipelineDealsBasicsEntity);
	
	public void savePipelineDealsCreditEntity(PipelineDealsCreditEntity pipelineDealsCreditEntity);
	
	public List<PipelineDeals> getAllDealNamesByBorrowerId(String sunId);
}
