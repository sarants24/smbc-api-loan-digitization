package com.smbc.lad.controller.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.ProjectionsComparison;
import com.smbc.lad.service.ProjectionsComparisonService;

/**
 * @author Saravanan T
 * @since May 2022
 *  
 * This is the main controller class which exposes API end points for the following
 * 
 * 1. To get the details of  Projections Comparison details
 * 2. To add/update the details of Projections Comparison details
 */
@RestController
public class ProjectionsComparisonController {

	@Autowired
	private ProjectionsComparisonService projectionsComparisonService;
	
	/**
	 * To fetch Projections Comparison details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/projectionscomparison/{pipelineId}", method=RequestMethod.GET)
	public ProjectionsComparison getProjectionsComparison(@PathVariable int pipelineId) throws Exception 
	{
		
		ProjectionsComparison projectionsComparison = projectionsComparisonService.getProjectionsComparison(pipelineId);
				
		return projectionsComparison;
	}
	
	/**
	 * To add or update Projections Comparison details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/projectionscomparison/{pipelineId}", method=RequestMethod.POST)
	public String updateProjectionsComparisonById(@PathVariable int pipelineId,
					@RequestBody ProjectionsComparison projectionsComparison) throws Exception 
	{
		
		String status = projectionsComparisonService.updateProjectionsComparisonById(
													pipelineId, projectionsComparison);
				
		return status;
	}
	
}

