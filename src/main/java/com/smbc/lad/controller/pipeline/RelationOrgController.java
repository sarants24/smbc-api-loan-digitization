package com.smbc.lad.controller.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.FileData;
import com.smbc.lad.dto.pipeline.RelationOrganization;
import com.smbc.lad.service.RelationOrganizationService;

/**
 * @author Saravanan T
 * @since April 2022
 *  
 * This is the main controller class which exposes API end points for the following
 * 
 * 1. To get the details of relation and organization 
 * 2. To add/update the details of relation and organization with upload 
 */
@RestController
public class RelationOrgController {

	@Autowired
	private RelationOrganizationService relationOrgService;
	
	/**
	 * To fetch relation and organization details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/relationorginfo/{pipelineId}", method=RequestMethod.GET)
	public RelationOrganization getPrimaryBorrowerInfoById(@PathVariable int pipelineId) throws Exception 
	{
		
		RelationOrganization relationOrganization = relationOrgService.getRelationOrganization(pipelineId);
				
		return relationOrganization;
	}
	
	/**
	 * To add or update relation and organization details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/relationorginfo/{pipelineId}",
																method=RequestMethod.POST)
	public String updateRelationOrganization(@PathVariable int pipelineId,
			@RequestBody RelationOrganization relationOrganization) throws Exception 
	{
		
		String status = relationOrgService.updateRelationOrganizationById(
													pipelineId, relationOrganization);
				
		return status;
	}
	
	
	/**
	 * To fetch file upload details for the given  id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/relationorgfile/{id}", method=RequestMethod.GET)
	public FileData getFileDataById(@PathVariable int id) throws Exception 
	{
		
		FileData fileData = relationOrgService.getFileData(id);
				
		return fileData;
	}
	
	/**
	 * To delete file upload details for the given  id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/relationorgfiledelete/{id}", method=RequestMethod.DELETE)
	public String deleteFileDataById(@PathVariable int id) throws Exception 
	{
		
		String status = relationOrgService.deleteFileData(id);

		return status;
	}
		
}
