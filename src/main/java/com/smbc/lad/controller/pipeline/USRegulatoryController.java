package com.smbc.lad.controller.pipeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.USRegulatory;
import com.smbc.lad.dto.pipeline.USRegulatoryList;
import com.smbc.lad.exception.SMBCBusinessException;
import com.smbc.lad.service.USRegulatoryService;

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
public class USRegulatoryController {

	@Autowired
	private USRegulatoryService usRegulatoryService;
	
	/**
	 * To fetch US Regulatory Chart details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/usregulatory/{pipelineId}", method=RequestMethod.GET)
	public List<USRegulatory> getUSRegulatoryByPipelineId(@PathVariable int pipelineId) throws Exception 
	{
		
		List<USRegulatory> usRegulatoryList = usRegulatoryService.getUSRegulatoryByPipelineId(pipelineId);
				
		return usRegulatoryList;
	}
	
	/**
	 * To add or update US Regulatory Chart  details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/usregulatory/{pipelineId}", method=RequestMethod.POST)
	public String updateUSRegulatoryByPipelineId(@PathVariable int pipelineId,
					@RequestBody USRegulatoryList usRegulatoryList) throws Exception 
	{
		
		if(usRegulatoryList == null) {
			throw new SMBCBusinessException("Input is empty");
		}
		String status = usRegulatoryService.updateUSRegulatoryByPipelineId(
									pipelineId, usRegulatoryList.getUsRegulatoryList());
				
		return status;
	}
	
}

