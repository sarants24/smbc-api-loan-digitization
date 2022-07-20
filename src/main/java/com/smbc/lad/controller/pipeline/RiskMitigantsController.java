package com.smbc.lad.controller.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.RiskMitigants;
import com.smbc.lad.service.RiskMitigantsService;

/**
 * @author Saravanan T
 * @since May 2022
 *  
 * This is the main controller class which exposes API end points for the following
 * 
 * 1. To get the details of  Risk Mitigants details
 * 2. To add/update the details of Risk Mitigants details
 */
@RestController
public class RiskMitigantsController {

	@Autowired
	private RiskMitigantsService riskMitigantsService;
	
	/**
	 * To fetch Risk Mitigants details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/riskmitigants/{pipelineId}", method=RequestMethod.GET)
	public RiskMitigants getRiskMitigants(@PathVariable int pipelineId) throws Exception 
	{
		
		RiskMitigants riskMitigants = riskMitigantsService.getRiskMitigants(pipelineId);
				
		return riskMitigants;
	}
	
	/**
	 * To add or update Risk Mitigants details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/riskmitigants/{pipelineId}", method=RequestMethod.POST)
	public String updateRiskMitigantsById(@PathVariable int pipelineId,
					@RequestBody RiskMitigants riskMitigants) throws Exception 
	{
		
		String status = riskMitigantsService.updateRiskMitigantsById(
													pipelineId, riskMitigants);
				
		return status;
	}
	
}

