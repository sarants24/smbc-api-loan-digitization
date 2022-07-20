package com.smbc.lad.repository.pipeline;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.PipelineDealsBasicsEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class PipelineDealsBasicsEntity
 *
 */
@Repository
public interface PipelineDealsBasicsRepo extends 
								JpaRepository<PipelineDealsBasicsEntity, String> {

	
	public PipelineDealsBasicsEntity findByPipelineId(int pipelineId);
}
