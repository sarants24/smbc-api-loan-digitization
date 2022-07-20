package com.smbc.lad.repository.pipeline;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.AnalysisPeerFilesLTMEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class AnalysisPeerFilesLTMEntity
 *
 */
@Repository
public interface AnalysisPeerFilesLTMRepo extends 
								JpaRepository<AnalysisPeerFilesLTMEntity, String> {

	public List<AnalysisPeerFilesLTMEntity> findByPipelineId(int pipelineId);
	
	public AnalysisPeerFilesLTMEntity findById(int id);
	
}
