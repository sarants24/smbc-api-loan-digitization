package com.smbc.lad.controller.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.FinancialAnalysis;
import com.smbc.lad.service.FinancialAnalysisService;

/**
 * @author Saravanan T
 * @since May 2022
 *  
 * This is the main controller class which exposes API end points for the following
 * 
 * 1. To get the details of Financial Analysis details
 * 2. To add/update the details of Financial Analysis details
 */
@RestController
public class FinancialAnalysisController {

	@Autowired
	private FinancialAnalysisService financialAnalysisService;
	
	/**
	 * To fetch Financial Analysis for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/financialanalysis/{pipelineId}", method=RequestMethod.GET)
	public FinancialAnalysis getFinancialAnalysis(@PathVariable int pipelineId) throws Exception 
	{
		
		FinancialAnalysis financialAnalysis = financialAnalysisService.getFinancialAnalysis(pipelineId);
				
		return financialAnalysis;
	}
	
	/**
	 * To add or update Financial Analysis details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/financialanalysis/{pipelineId}", method=RequestMethod.POST)
	public String updateFinancialAnalysis(@PathVariable int pipelineId,
					@RequestBody FinancialAnalysis financialAnalysis) throws Exception 
	{
		
		String status = financialAnalysisService.updateFinancialAnalysisById(
													pipelineId, financialAnalysis);
				
		return status;
	}
	
}

