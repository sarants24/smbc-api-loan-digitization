package com.smbc.lad.controller.pipeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.RequestFacilities;
import com.smbc.lad.service.RequestFacilityService;

/**
 * @author Saravanan T
 * @since April 2022
 *  
 * This is the main controller class which exposes API end points for the following
 * 
 * 1. To get the Primary Request Facility
 * 2. To add/update the Primary Request Facility
 * 3. To get the list of additional Request Facility
 * 4. To get the details single additional Request Facility for the given facility id
 * 5. To add additional request facility
 * 6. To update additional request facility
 * 7. To delete additional request facility
 */
@RestController
public class RequestFacilityController {

	@Autowired
	private RequestFacilityService requestFacilityService;
	
	//Primary Borrower
	
	/**
	 * To fetch primary Request facility info details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/facility/primary/{pipelineId}", method=RequestMethod.GET)
	public RequestFacilities getPrimaryRequestFacilityById(@PathVariable int pipelineId) throws Exception 
	{
		
		RequestFacilities requestFacilities = requestFacilityService.getRequestFacilityById(pipelineId);
				
		return requestFacilities;
	}
	
	/**
	 * To update primary Borrower info details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/facility/primary/{pipelineId}", method=RequestMethod.POST)
	public String updateBorrowerInformationById(@PathVariable int pipelineId, @RequestBody RequestFacilities requestFacilities) throws Exception 
	{
		String status =requestFacilityService.updateRequestFacilityById(pipelineId, requestFacilities);
				
		return status;
	}
	
	//Additional Facility
	/**
	 * To fetch additional Request Facility details for the given pipelineId
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/facility/additional/all/{pipelineId}", method=RequestMethod.GET)
	public List<RequestFacilities> getAdditionalFacilityByPipelineId(@PathVariable int pipelineId) throws Exception 
	{
		List<RequestFacilities> requestFacilitiesList = requestFacilityService.getAddtlRequestFacilitiesByPipelineId(pipelineId);
				
		return requestFacilitiesList;
	}
		
	/**
	 * To fetch additional Request Facility details for the given facility id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/facility/additional/{addtlFacilityId}", method=RequestMethod.GET)
	public RequestFacilities getAdditionalFacilityById(@PathVariable int addtlFacilityId) throws Exception 
	{
		
		RequestFacilities requestFacilities = requestFacilityService.getRequestFacilitiesByFacilityId(addtlFacilityId);
				
		return requestFacilities;
	}

	/**
	 * To add additional Request Facility details for the pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/facility/additional/pipeline/{pipelineId}", method=RequestMethod.POST)
	public String addFacilityByPipelineId(@PathVariable int pipelineId, @RequestBody RequestFacilities requestFacilities) throws Exception 
	{
	
		String status = requestFacilityService.addAdditionalRequestFacilityById(pipelineId, requestFacilities);
				
		return status;
	}
		
		
		/**
		 * To update additional Request Facility details for the facility id
		 * 
		 * @param pipelineId
		 * @return
		 * @throws Exception;
		 */
		@RequestMapping(value = "/smbcapi/v1/pipelinedeals/facility/additional/{addtionalFacilityId}", method=RequestMethod.POST)
		public String addupdateFacilityById(@PathVariable int addtionalFacilityId, @RequestBody RequestFacilities requestFacilities) throws Exception 
		{
		
			String status =requestFacilityService.updateAdditionalRequestFacilityById(addtionalFacilityId, requestFacilities);
					
			return status;
		}

		/**
		 * To delete additional Request Facility details for the facility id
		 * 
		 * @param pipelineId
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value = "/smbcapi/v1/pipelinedeals/facility/additional/{addtionalFacilityId}", method=RequestMethod.DELETE)
		public String deleteAdditioanlBorrowerInfoById(@PathVariable int addtionalFacilityId) throws Exception 
		{
		
			String status = requestFacilityService.deleteAdditionalFacilityById(addtionalFacilityId);
					
			return status;
		}
}
