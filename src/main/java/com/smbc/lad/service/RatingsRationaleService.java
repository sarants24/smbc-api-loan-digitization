package com.smbc.lad.service;

import com.smbc.lad.dto.pipeline.RatingsRationale;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the RatingsRationale. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface RatingsRationaleService {

	public RatingsRationale getRatingsRationale(int pipelineId);
	
	public String updateRatingsRationaleById(int pipelineId,RatingsRationale ratingsRationale) throws Exception;
	
}
