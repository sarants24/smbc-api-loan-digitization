package com.smbc.lad.service;

import com.smbc.lad.dto.pipeline.FileData;
import com.smbc.lad.dto.pipeline.TransactionBackground;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the Relation and Organization. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface TransactionBackgroundService {

	public TransactionBackground getTransactionBackground(int pipelineId);
	
	public String updateTransactionBackgroundById(int pipelineId,TransactionBackground transactionBackground) throws Exception;
	
	public FileData getTransactionBackgroundFiles(int id);
	
	public String deleteTransactionBackgroundFiles(int id);
	
}
