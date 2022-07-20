package com.smbc.lad.controller.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.RatingsRationale;
import com.smbc.lad.service.RatingsRationaleService;

/**
 * @author Saravanan T
 * @since May 2022
 *  
 * This is the main controller class which exposes API end points for the following
 * 
 * 1. To get the details of  Ratings Rationale details
 * 2. To add/update the details of Ratings Rationale details
 */
@RestController
public class RatingsRationaleController {

	@Autowired
	private RatingsRationaleService ratingsRationaleService;
	
	/**
	 * To fetch Ratings Rationale details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/ratingsrationale/{pipelineId}", method=RequestMethod.GET)
	public RatingsRationale getRatingsRationale(@PathVariable int pipelineId) throws Exception 
	{
		
		RatingsRationale ratingsRationale = ratingsRationaleService.getRatingsRationale(pipelineId);
				
		return ratingsRationale;
	}
	
	/**
	 * To add or update Ratings Rationale details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/ratingsrationale/{pipelineId}", method=RequestMethod.POST)
	public String updateRatingsRationaleById(@PathVariable int pipelineId,
					@RequestBody RatingsRationale ratingsRationale) throws Exception 
	{
		
		String status = ratingsRationaleService.updateRatingsRationaleById(
													pipelineId, ratingsRationale);
				
		return status;
	}
	
}

