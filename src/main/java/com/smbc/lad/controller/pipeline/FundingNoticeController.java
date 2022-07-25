package com.smbc.lad.controller.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.FundingNotice;
import com.smbc.lad.dto.pipeline.FundingTerms;
import com.smbc.lad.service.FundingNoticeService;

/**
 * @author Saravanan T
 * @since April 2022
 *  
 * This is the main controller class which exposes API end points for the following
 * 
 * 1. To get the details of transaction background 
 * 2. To add/update the details of transaction background 
 */
@RestController
public class FundingNoticeController {

	@Autowired
	private FundingNoticeService fundingNoticeService;
	
	/**
	 * To fetch relation and transaction background details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/fundingnotice/{pipelineId}", method=RequestMethod.GET)
	public FundingNotice getFundingNoticeById(@PathVariable int pipelineId) throws Exception 
	{
		
		FundingNotice fundingNotice = fundingNoticeService.getFundingNotice(pipelineId);
				
		return fundingNotice;
	}
	
	/**
	 * To add or update relation and organization details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/fundingnotice/{pipelineId}",
			method=RequestMethod.POST)
	public String updateFundingNotice(@PathVariable int pipelineId,
			@RequestBody FundingNotice fundingNotice) throws Exception 
	{
		
		String status = fundingNoticeService.updateFundingNoticeById(
													pipelineId, fundingNotice);
				
		return status;
	}
	
	/**
	 * To fetch file upload details for the given  id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/fundingterms/{id}", method=RequestMethod.GET)
	public FundingTerms getFundingTermFilesById(@PathVariable int id) throws Exception 
	{
		
		FundingTerms FundingTerms = fundingNoticeService.getFundingTermFiles(id);
				
		return FundingTerms;
	}
	
	/**
	 * To Delete file upload details for the given  id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/fundingtermsdelete/{id}", method=RequestMethod.DELETE)
	public String deleteTransactionsFilesById(@PathVariable int id) throws Exception 
	{
		String status = fundingNoticeService.deleteFundingTermFiles(id);

		return status;
	}
}
