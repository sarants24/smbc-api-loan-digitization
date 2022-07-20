package com.smbc.lad.service;

import com.smbc.lad.dto.pipeline.IndustryTrends;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the Relation and Organization. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface IndustryTrendsService {

	public IndustryTrends getIndustryTrends(int pipelineId);
	
	public String updateIndustryTrendsById(int pipelineId,IndustryTrends industryTrends) throws Exception;
	
}
