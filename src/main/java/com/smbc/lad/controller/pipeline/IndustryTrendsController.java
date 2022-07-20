package com.smbc.lad.controller.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.IndustryTrends;
import com.smbc.lad.service.IndustryTrendsService;

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
public class IndustryTrendsController {

	@Autowired
	private IndustryTrendsService industryTrendsService;
	
	/**
	 * To fetch relation and industry trend infofor the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/industrytrends/{pipelineId}", method=RequestMethod.GET)
	public IndustryTrends getIndustryTrends(@PathVariable int pipelineId) throws Exception 
	{
		
		IndustryTrends industryTrends = industryTrendsService.getIndustryTrends(pipelineId);
				
		return industryTrends;
	}
	
	/**
	 * To add or update relation and organization details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/industrytrends/{pipelineId}", method=RequestMethod.POST)
	public String updateIndustryTrends(@PathVariable int pipelineId,
					@RequestBody IndustryTrends industryTrends) throws Exception 
	{
		
		String status = industryTrendsService.updateIndustryTrendsById(
													pipelineId, industryTrends);
				
		return status;
	}
	
}
