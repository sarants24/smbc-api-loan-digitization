package com.smbc.lad.controller.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.pipeline.FileData;
import com.smbc.lad.dto.pipeline.TransactionBackground;
import com.smbc.lad.service.TransactionBackgroundService;

/**
 * @author Saravanan T
 * @since April 2022
 *  
 * This is the main controller class which exposes API end points for the following
 * 
 * 1. To get the details of transaction background 
 * 2. To add/update the details of transaction background 
 */
@RestController
public class TransactionBackgroundController {

	@Autowired
	private TransactionBackgroundService transBackgroundService;
	
	/**
	 * To fetch relation and transaction background details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/transactionbackground/{pipelineId}", method=RequestMethod.GET)
	public TransactionBackground getTransactionBackgroundById(@PathVariable int pipelineId) throws Exception 
	{
		
		TransactionBackground transactionBackground = transBackgroundService.getTransactionBackground(pipelineId);
				
		return transactionBackground;
	}
	
	/**
	 * To add or update relation and organization details for the given pipeline id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/transactionbackground/{pipelineId}",
			method=RequestMethod.POST)
	public String updateTransactionBackground(@PathVariable int pipelineId,
			@RequestBody TransactionBackground transactionBackground) throws Exception 
	{
		
		String status = transBackgroundService.updateTransactionBackgroundById(
													pipelineId, transactionBackground);
				
		return status;
	}
	
	/**
	 * To fetch file upload details for the given  id
	 * 
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/transactionbgfile/{id}", method=RequestMethod.GET)
	public FileData getTransactionsFilesById(@PathVariable int id) throws Exception 
	{
		
		FileData fileData = transBackgroundService.getTransactionBackgroundFiles(id);
				
		return fileData;
	}
	
	/**
	 * To Delete file upload details for the given  id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/smbcapi/v1/pipelinedeals/transactionbgfiledelete/{id}", method=RequestMethod.DELETE)
	public String deleteTransactionsFilesById(@PathVariable int id) throws Exception 
	{
		String status = transBackgroundService.deleteTransactionBackgroundFiles(id);

		return status;
	}
}
