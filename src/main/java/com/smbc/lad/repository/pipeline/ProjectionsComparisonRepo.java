package com.smbc.lad.repository.pipeline;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.ProjectionsComparisonEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class AnalysisPeerFilesLTMEntity
 *
 */
@Repository
public interface ProjectionsComparisonRepo extends 
								JpaRepository<ProjectionsComparisonEntity, String> {

	public ProjectionsComparisonEntity findByPipelineId(int pipelineId);
	
}
