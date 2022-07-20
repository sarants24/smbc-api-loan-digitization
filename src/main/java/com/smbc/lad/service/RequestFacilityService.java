package com.smbc.lad.service;

import java.util.List;

import com.smbc.lad.dto.pipeline.RequestFacilities;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the Borrower info  entities. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface RequestFacilityService {

	//Borrower Information
	public RequestFacilities getRequestFacilityById(int pipelineId) throws Exception;
	
	public String updateRequestFacilityById(int pipelineId,RequestFacilities requestFacilities) throws Exception;
	
	//Additional Request Facility
	public List<RequestFacilities> getAddtlRequestFacilitiesByPipelineId(int pipelineId) throws Exception;
		
	public RequestFacilities getRequestFacilitiesByFacilityId(int addtionalFacilityId) throws Exception;
	
	public String addAdditionalRequestFacilityById(int pipelineId,
								RequestFacilities requestFacilities) throws Exception;
	
	public String updateAdditionalRequestFacilityById(int addtionalFacilityId,
								RequestFacilities requestFacilities) throws Exception;
	
	public String deleteAdditionalFacilityById(int addtionalFacilityId) throws Exception;
}
