package com.smbc.lad.controller.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.CapitalRequestExposure;
import com.smbc.lad.dto.pipeline.CapitalRequestFacilityMetrics;
import com.smbc.lad.dto.pipeline.CapitalRequestForm;
import com.smbc.lad.service.CapitalRequestFormService;

/**
 * @author Saravanan T
 * @since April 2022
 *  
 * This is the main controller class which exposes API end points for the following
 * 
 * 1. To get the details of relation and organization 
 * 2. To add/update the details of relation and organization with upload 
 */
@RestController
public class CapitalRequestFormController {

	@Autowired
	private CapitalRequestFormService capitalRequestFormService;
	
	/**
	 * To fetch capital request form details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/capitalrequestform/{pipelineId}", method=RequestMethod.GET)
	public CapitalRequestForm getCapitalRequestForm(@PathVariable int pipelineId) throws Exception 
	{
		
		CapitalRequestForm capitalRequestForm = capitalRequestFormService.getCapitalRequestForm(pipelineId);
				
		return capitalRequestForm;
	}
	
	/**
	 * To add or update capital request form details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/capitalrequestform/{pipelineId}",
																method=RequestMethod.POST)
	public String updateCapitalRequestFormById(@PathVariable int pipelineId,
			@RequestBody CapitalRequestForm capitalRequestForm) throws Exception 
	{
		
		String status = capitalRequestFormService.updateCapitalRequestFormById(
													pipelineId, capitalRequestForm);
				
		return status;
	}
	
	
	/**
	 * To fetch Capital Request Exposure details for the given  id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/capitalrequestexposure/{id}", method=RequestMethod.GET)
	public CapitalRequestExposure getCapitalRequestExposure(@PathVariable int id) throws Exception 
	{
		
		CapitalRequestExposure capitalRequestExposure = capitalRequestFormService.getCapitalRequestExposure(id);
				
		return capitalRequestExposure;
	}
	
	/**
	 * To delete CapitalRequestExposure details for the given  id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/capitalrequestexposure/{id}", method=RequestMethod.DELETE)
	public String deleteCapitalRequestExposure(@PathVariable int id) throws Exception 
	{
		
		String status = capitalRequestFormService.deleteCapitalRequestExposure(id);

		return status;
	}
		
	/**
	 * To fetch Capital Request Exposure details for the given  id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/capitalrequestfacmetrics/{id}", method=RequestMethod.GET)
	public CapitalRequestFacilityMetrics getCapitalRequestFacilityMetrics(@PathVariable int id) throws Exception 
	{
		
		CapitalRequestFacilityMetrics capitalRequestFacilityMetrics = capitalRequestFormService.getCapitalRequestFacilityMetrics(id);
				
		return capitalRequestFacilityMetrics;
	}
	
	/**
	 * To delete CapitalRequestExposure details for the given  id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/capitalrequestfacmetrics/{id}", method=RequestMethod.DELETE)
	public String deleteCapitalRequestFacilityMetrics(@PathVariable int id) throws Exception 
	{
		
		String status = capitalRequestFormService.deleteCapitalRequestFacilityMetrics(id);

		return status;
	}
}
