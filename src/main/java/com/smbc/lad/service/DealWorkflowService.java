package com.smbc.lad.service;

import com.smbc.lad.dto.pipeline.DealWorkflow;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the DealWorkflowService. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface DealWorkflowService {

	public DealWorkflow getDealWorkflow(int pipelineId);
	
	public String addOrUpdateDealWorkflowById(int pipelineId,DealWorkflow dealWorkflow) throws Exception;
	
}
