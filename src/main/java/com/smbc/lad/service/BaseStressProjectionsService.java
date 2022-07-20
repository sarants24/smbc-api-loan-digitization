package com.smbc.lad.service;

import com.smbc.lad.dto.pipeline.BaseStressProjections;

/**
 * @author Saravanan T
 * @since May 2022
 * 
 * This is an interface class for the Base & Stress Projections Service. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface BaseStressProjectionsService {

	public BaseStressProjections getBaseStressProjections(int pipelineId);
	
	public String updateBaseStressProjectionsById(int pipelineId,BaseStressProjections baseStressProjections) throws Exception;
	
}

