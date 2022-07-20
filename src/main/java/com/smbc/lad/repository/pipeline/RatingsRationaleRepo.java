package com.smbc.lad.repository.pipeline;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.RatingsRationaleEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class AnalysisPeerFilesLTMEntity
 *
 */
@Repository
public interface RatingsRationaleRepo extends 
								JpaRepository<RatingsRationaleEntity, String> {

	public RatingsRationaleEntity findByPipelineId(int pipelineId);
	
}
