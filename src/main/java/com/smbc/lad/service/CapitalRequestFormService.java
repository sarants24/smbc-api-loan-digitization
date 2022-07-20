package com.smbc.lad.service;

import com.smbc.lad.dto.pipeline.CapitalRequestExposure;
import com.smbc.lad.dto.pipeline.CapitalRequestFacilityMetrics;
import com.smbc.lad.dto.pipeline.CapitalRequestForm;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the Relation and Organization. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface CapitalRequestFormService {

	public CapitalRequestForm getCapitalRequestForm(int pipelineId);
	
	public String updateCapitalRequestFormById(int pipelineId,CapitalRequestForm capitalRequestForm) throws Exception;
	
	public CapitalRequestExposure getCapitalRequestExposure(int id);
	
	public String deleteCapitalRequestExposure(int id);
	
	public CapitalRequestFacilityMetrics getCapitalRequestFacilityMetrics(int id);
	
	public String deleteCapitalRequestFacilityMetrics(int id);

}
