package com.smbc.lad.service;

import com.smbc.lad.dto.pipeline.FinancialAnalysis;

/**
 * @author Saravanan T
 * @since May 2022
 * 
 * This is an interface class for the Financial Analysis. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface FinancialAnalysisService {

	public FinancialAnalysis getFinancialAnalysis(int pipelineId);
	
	public String updateFinancialAnalysisById(int pipelineId,FinancialAnalysis financialAnalysis) throws Exception;
	
}
