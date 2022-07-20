package com.smbc.lad.service;

import java.util.List;

import com.smbc.lad.dto.pipeline.USRegulatory;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the USregulatory. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface USRegulatoryService {

	public List<USRegulatory> getUSRegulatoryByPipelineId(int pipelineId);
	
	public String updateUSRegulatoryByPipelineId(int pipelineId,List<USRegulatory> usRegulatoryList) throws Exception;
	
}
