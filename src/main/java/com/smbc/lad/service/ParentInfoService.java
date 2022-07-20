package com.smbc.lad.service;

import com.smbc.lad.dto.pipeline.ParentInformation;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the Parent info  entities. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface ParentInfoService {

	public ParentInformation getParentInformationById(int pipelineId);
	
	public String updateParentInformationById(int pipelineId,ParentInformation parentInformation) throws Exception;
}
