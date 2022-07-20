package com.smbc.lad.controller.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.BaseStressProjections;
import com.smbc.lad.service.BaseStressProjectionsService;

/**
 * @author Saravanan T
 * @since May 2022
 *  
 * This is the main controller class which exposes API end points for the following
 * 
 * 1. To get the details of Base and Stress Projections details
 * 2. To add/update the details of Base and Stress Projections details
 */
@RestController
public class BaseStressProjectionsController {

	@Autowired
	private BaseStressProjectionsService baseStressProjectionsService;
	
	/**
	 * To fetch Base and Stress Projections for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/basestressprojections/{pipelineId}", method=RequestMethod.GET)
	public BaseStressProjections getBaseStressProjections(@PathVariable int pipelineId) throws Exception 
	{
		
		BaseStressProjections baseStressProjections = baseStressProjectionsService.getBaseStressProjections(pipelineId);
				
		return baseStressProjections;
	}
	
	/**
	 * To add or update Base and Stress Projections details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/basestressprojections/{pipelineId}", method=RequestMethod.POST)
	public String updateBaseStressProjections(@PathVariable int pipelineId,
					@RequestBody BaseStressProjections baseStressProjections) throws Exception 
	{
		
		String status = baseStressProjectionsService.updateBaseStressProjectionsById(
													pipelineId, baseStressProjections);
				
		return status;
	}
	
}

