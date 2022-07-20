package com.smbc.lad.service;

import com.smbc.lad.dto.pipeline.PMGCATFDecision;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the PMGCATFDecision
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface PMGCATFDecisionService {

	public PMGCATFDecision getPMGCATFDecision(int pipelineId);
	
	public String updatePMGCATFDecisionById(int pipelineId,PMGCATFDecision pmgCATFDecision) throws Exception;
}
