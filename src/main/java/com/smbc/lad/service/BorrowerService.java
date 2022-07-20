package com.smbc.lad.service;

import java.util.List;

import com.smbc.lad.dto.pipeline.BorrowerInformation;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the Borrower info  entities. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface BorrowerService {

	//Borrower Information
	public BorrowerInformation getBorrowerInfoById(int pipelineId);
	
	public String updateBorrowerInfoById(int pipelineId,BorrowerInformation borrowerInformation) throws Exception;
	
	//Borrower Information
	public List<BorrowerInformation> getAddtlBorrowerInfoByPipelineId(int pipelineId) throws Exception;
	
	public BorrowerInformation getAddtlBorrowerInfoByBorrowerId(int addtionalBorrowerId);
	
	public String addAdditinalBorrowerInfoById(int pipelineId,BorrowerInformation borrowerInformation) throws Exception;
	
	public String updateAdditinalBorrowerInfoById(int addtionalBorrowerId,BorrowerInformation borrowerInformation) throws Exception;
	
	public String deleteAdditinalBorrowerInfoById(int addtionalBorrowerId) throws Exception;
}
