package com.smbc.lad.controller.pipeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.CreditInquiry;
import com.smbc.lad.dto.pipeline.DealWorkflow;
import com.smbc.lad.dto.pipeline.ParentInformation;
import com.smbc.lad.dto.pipeline.PipelineDeals;
import com.smbc.lad.dto.pipeline.PipelineDealsBasics;
import com.smbc.lad.service.CreditInquiryService;
import com.smbc.lad.service.ParentInfoService;
import com.smbc.lad.service.PipelineDealsService;

/**
 * @author Saravanan T
 * @since April 2022
 *  
 * This is the main controller class which exposes API end points for the following
 * 
 * 1. Dashboard - to get all deals from pipeline
 * 2. Pipeline Detail - to get complete details for the given pipeline id
 * 3. Update Pipeline Detail - Update pipeline details for the given pipeline id
 * 4. Credit Inquiry (CI Information) - to get complete details of CI for the given pipeline id
 * 5. Update Credit Inquiry (CI Information) - Update CI details for the given pipeline id
 * 4. Parent Information - to get complete details of Parent info for the given pipeline id
 * 5. Update Parent Information - Update Parent Information details for the given pipeline id
 */
@RestController
public class PipelineDealsController {

	@Autowired
	private PipelineDealsService pipelineDealsService;
	
	@Autowired
	private CreditInquiryService creditInquiryService;
	
	@Autowired
	private ParentInfoService parentInfoService;
	
	/**
	 * To fetch all pipeline deals
	 * 
	 * @return List<PipelineDeals>
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals", method=RequestMethod.GET)
	public List<PipelineDeals> getAllPipelineDeals() throws Exception 
	{
		List<PipelineDeals> PipelineDealsList = pipelineDealsService.getAllPipelineDeals();
		
		return PipelineDealsList;
	}
	
	/**
	 * To fetch all pipeline deals
	 * 
	 * @return List<PipelineDeals>
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/cdadpipelinedeals", method=RequestMethod.GET)
	public List<PipelineDeals> getAllCDADPipelineDeals() throws Exception 
	{
		List<PipelineDeals> pipelineDealsList = pipelineDealsService.getAllCDADPipelineDeals();
		
		return pipelineDealsList;
	}
	
	/**
	 * To fetch all pipeline deals
	 * 
	 * @return List<PipelineDeals>
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pmgpipelinedeals", method=RequestMethod.GET)
	public List<DealWorkflow> getAllPMGPipelineDeals() throws Exception 
	{
		List<DealWorkflow> dealWorkflowList = pipelineDealsService.getAllPMGPipelineDeals();
		
		return dealWorkflowList;
	}
	
	/**
	 * To fetch pipeline details for the given pipeline id
	 * 
	 * @param pipelineId - Input
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/{pipelineId}", method=RequestMethod.GET)
	public PipelineDealsBasics getPipelineDetailBySunId(@PathVariable int pipelineId) throws Exception 
	{
		
		PipelineDealsBasics pipelineDealsBasics = pipelineDealsService.getPipelineDetailsById(pipelineId);
				
		return pipelineDealsBasics;
	}
	
	/**
	 * To update pipeline details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @param pipelineDealsBasics
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/{pipelineId}", method=RequestMethod.POST)
	public String updatePipelineDetailBySunId(@PathVariable int pipelineId, @RequestBody PipelineDealsBasics pipelineDealsBasics) throws Exception 
	{
		String strStatus = pipelineDealsService.updatePipelineDetailsById(pipelineId, pipelineDealsBasics);
		
		return strStatus;
	}
	
	/**
	 * To fetch CI details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/creditinquiry/{pipelineId}", method=RequestMethod.GET)
	public CreditInquiry getCreditInquiryById(@PathVariable int pipelineId) throws Exception 
	{
		
		CreditInquiry creditInquiry = creditInquiryService.getCreditInquiryById(pipelineId);
				
		return creditInquiry;
	}
	
	/**
	 * To update CI details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @param creditInquiry
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/creditinquiry/{pipelineId}", method=RequestMethod.POST)
	public String updateCreditInquiryById(@PathVariable int pipelineId, @RequestBody CreditInquiry creditInquiry) throws Exception 
	{
		String strStatus = creditInquiryService.updateCreditInquiryById(pipelineId, creditInquiry);
		
		return strStatus;
	}
	
	/**
	 * To fetch parent info details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/parentinfo/{pipelineId}", method=RequestMethod.GET)
	public ParentInformation getParentInformationById(@PathVariable int pipelineId) throws Exception 
	{
		
		ParentInformation parentInformation = parentInfoService.getParentInformationById(pipelineId);
				
		return parentInformation;
	}
	
	/**
	 * To update parent info details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @param parentInformation
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/parentinfo/{pipelineId}", method=RequestMethod.POST)
	public String updateParentInformationById(@PathVariable int pipelineId, @RequestBody ParentInformation parentInformation) throws Exception 
	{
		String strStatus = parentInfoService.updateParentInformationById(pipelineId, parentInformation);
		
		return strStatus;
	}
	
	/**
	 * To get the list of deals for the given borrower id
	 * 
	 * @param sunId
	 * @param 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/dealnames/{sunId}", method=RequestMethod.GET)
	public List<PipelineDeals> getAllDealNamesByBorrowerId(@PathVariable String sunId) throws Exception 
	{
		List<PipelineDeals> dealNamesList = pipelineDealsService.getAllDealNamesByBorrowerId(sunId);
		
		return dealNamesList;
	}

}
