package com.smbc.lad.service;

import com.smbc.lad.dto.pipeline.RiskMitigants;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the RiskMitigants. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface RiskMitigantsService {

	public RiskMitigants getRiskMitigants(int pipelineId);
	
	public String updateRiskMitigantsById(int pipelineId,RiskMitigants riskMitigants) throws Exception;
	
}
