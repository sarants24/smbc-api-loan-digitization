package com.smbc.lad.controller.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.PMGCATFDecision;
import com.smbc.lad.service.PMGCATFDecisionService;

/**
 * @author Saravanan T
 * @since April 2022
 *  
 * This is the main controller class which exposes API end points for the following
 * 
 * 1. To get the details of Industry trend details
 * 2. To add/update the details of Industry trend details
 */
@RestController
public class PMGCATFDecisionController {

	@Autowired
	private PMGCATFDecisionService pmgCATFDecisionService;
	
	/**
	 * To fetch PMG catf decision details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/pmg/catfdecision/{pipelineId}", method=RequestMethod.GET)
	public PMGCATFDecision getPMGCATFDecision(@PathVariable int pipelineId) throws Exception 
	{
		PMGCATFDecision pmgCATFDecision = pmgCATFDecisionService.getPMGCATFDecision(pipelineId);
				
		return pmgCATFDecision;
	}
	
	/**
	 * To add or update pmg catf decision details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/pmg/catfdecision/{pipelineId}", method=RequestMethod.POST)
	public String updatePMGCATFDecision(@PathVariable int pipelineId,
					@RequestBody PMGCATFDecision pmgCATFDecision) throws Exception 
	{
		
		String status = pmgCATFDecisionService.updatePMGCATFDecisionById(
													pipelineId, pmgCATFDecision);
				
		return status;
	}
	
}
