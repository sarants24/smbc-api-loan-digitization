package com.smbc.lad.controller.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.AnalysisPeerLTM;
import com.smbc.lad.dto.pipeline.FileData;
import com.smbc.lad.service.AnalysisPeerLTMService;

/**
 * @author Saravanan T
 * @since May 2022
 *  
 * This is the main controller class which exposes API end points for the following
 * 
 * 1. To get the details of Peer Analysis and Long Term Trends details
 * 2. To add/update the details of Peer Analysis and Long Term Trends details
 */
@RestController
public class AnalysisPeerLTMController {

	@Autowired
	private AnalysisPeerLTMService analysisPeerLTMService;
	
	/**
	 * To fetch Peer Analysis and Long Term Trend details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/analysispeerltm/{pipelineId}", method=RequestMethod.GET)
	public AnalysisPeerLTM getAnalysisPeerLTM(@PathVariable int pipelineId) throws Exception 
	{
		
		AnalysisPeerLTM analysisPeerLTM = analysisPeerLTMService.getAnalysisPeerLTM(pipelineId);
				
		return analysisPeerLTM;
	}
	
	/**
	 * To add or update Peer Analysis and Long Term Trend details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/analysispeerltm/{pipelineId}", method=RequestMethod.POST)
	public String updateAnalysisPeerLTM(@PathVariable int pipelineId,
					@RequestBody AnalysisPeerLTM analysisPeerLTM) throws Exception 
	{
		
		String status = analysisPeerLTMService.updateAnalysisPeerLTMById(
													pipelineId, analysisPeerLTM);
				
		return status;
	}
	
	/**
	 * To fetch file upload details for the given  id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/analysispeerltmfile/{id}", method=RequestMethod.GET)
	public FileData getAnalysisPeerFilesFilesById(@PathVariable int id) throws Exception 
	{
		
		FileData fileData = analysisPeerLTMService.getAnalysisPeerFilesLTM(id);
				
		return fileData;
	}
	
	/**
	 * To delete file upload details for the given  id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/analysispeerltmfiledelete/{id}", method=RequestMethod.DELETE)
	public String deleteAnalysisPeerFilesLTM(@PathVariable int id) throws Exception 
	{
		
		String status = analysisPeerLTMService.deleteAnalysisPeerFilesLTM(id);

		return status;
	}
}

