package com.smbc.lad.controller.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.DealWorkflow;
import com.smbc.lad.service.DealWorkflowService;

/**
 * @author Saravanan T
 * @since April 2022
 *  
 * This is the main controller class which exposes API end points for the following
 * 
 * 1. To get the details of Deal Workflow details
 * 2. To add/update the details of Deal Workflow details
 */
@RestController
public class DealWorkflowController {

	@Autowired
	private DealWorkflowService dealWorkflowService;
	
	/**
	 * To fetch deal workflow details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/dealworkflow/{pipelineId}", method=RequestMethod.GET)
	public DealWorkflow getDealWorkflow(@PathVariable int pipelineId) throws Exception 
	{
		
		DealWorkflow dealWorkflow = dealWorkflowService.getDealWorkflow(pipelineId);
				
		return dealWorkflow;
	}
	
	/**
	 * To add or update relation and organization details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/dealworkflow/{pipelineId}", method=RequestMethod.POST)
	public String updateDealWorkflow(@PathVariable int pipelineId,
					@RequestBody DealWorkflow dealWorkflow) throws Exception 
	{
		
		String status = dealWorkflowService.addOrUpdateDealWorkflowById(
													pipelineId, dealWorkflow);
				
		return status;
	}	
}
