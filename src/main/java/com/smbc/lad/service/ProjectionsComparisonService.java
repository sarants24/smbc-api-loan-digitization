package com.smbc.lad.service;

import com.smbc.lad.dto.pipeline.ProjectionsComparison;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the ProjectionsComparison. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface ProjectionsComparisonService {

	public ProjectionsComparison getProjectionsComparison(int pipelineId);
	
	public String updateProjectionsComparisonById(int pipelineId,ProjectionsComparison projectionsComparison) throws Exception;
	
}
