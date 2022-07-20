package com.smbc.lad.service;

import com.smbc.lad.dto.pipeline.FileData;
import com.smbc.lad.dto.pipeline.RelationOrganization;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the Relation and Organization. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface RelationOrganizationService {

	public RelationOrganization getRelationOrganization(int pipelineId);
	
	public String updateRelationOrganizationById(int pipelineId,RelationOrganization relationOrganization) throws Exception;
	
	public FileData getFileData(int id);
	
	public String deleteFileData(int id);

}
