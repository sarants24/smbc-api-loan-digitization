package com.smbc.lad.repository.pipeline;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.BaseStressProjectionsEntity;

/**
 * @author Saravanan T
 * @since May 2022
 * 
 * JPA Repository class to read data from Entity class BaseStressProjectionsEntity
 *
 */
@Repository
public interface BaseStressProjectionsRepo extends 
								JpaRepository<BaseStressProjectionsEntity, String> {

	public BaseStressProjectionsEntity findByPipelineId(int pipelineId);
}
