package com.smbc.lad.service;

import com.smbc.lad.dto.pipeline.CreditInquiry;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the Pipeline Dashboard, Pipeline Detail and CI  entities. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface CreditInquiryService {

	public CreditInquiry getCreditInquiryById(int pipelineId);
	
	public String updateCreditInquiryById(int pipelineId,CreditInquiry creditInquiry) throws Exception;
}
