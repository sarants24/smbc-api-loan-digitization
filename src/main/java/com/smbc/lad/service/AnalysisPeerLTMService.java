package com.smbc.lad.service;

import com.smbc.lad.dto.pipeline.AnalysisPeerLTM;
import com.smbc.lad.dto.pipeline.FileData;

/**
 * @author Saravanan T
 * @since May 2022
 * 
 * This is an interface class for the Peer Analysis and LTM Service. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */

public interface AnalysisPeerLTMService {

	public AnalysisPeerLTM getAnalysisPeerLTM(int pipelineId);
	
	public String updateAnalysisPeerLTMById(int pipelineId,AnalysisPeerLTM analysisPeerLTM) throws Exception;

	public FileData getAnalysisPeerFilesLTM(int id);
	
	public String deleteAnalysisPeerFilesLTM(int id);
}
