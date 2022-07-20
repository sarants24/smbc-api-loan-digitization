package com.smbc.lad.repository.pipeline;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.PipelineDealsCreditEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class PipelineDealsCreditEntity
 *
 */
@Repository
public interface PipelineDealsCreditRepo extends 
								JpaRepository<PipelineDealsCreditEntity, String> {

	public PipelineDealsCreditEntity findByPipelineId(int pipelineId);
}
