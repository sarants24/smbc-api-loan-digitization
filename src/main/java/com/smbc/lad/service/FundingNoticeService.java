package com.smbc.lad.service;

import com.smbc.lad.dto.pipeline.FundingNotice;
import com.smbc.lad.dto.pipeline.FundingTerms;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the Relation and Organization. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface FundingNoticeService {

	public FundingNotice getFundingNotice(int pipelineId);
	
	public String updateFundingNoticeById(int pipelineId,FundingNotice fundingNotice) throws Exception;
	
	public FundingTerms getFundingTermFiles(int id);
	
	public String deleteFundingTermFiles(int id);
	
}
