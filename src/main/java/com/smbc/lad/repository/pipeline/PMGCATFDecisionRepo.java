package com.smbc.lad.repository.pipeline;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.PMGCATFDecisionEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class PMGCATFDecisionEntity
 *
 */
@Repository
public interface PMGCATFDecisionRepo extends 
								JpaRepository<PMGCATFDecisionEntity, String> {

	public PMGCATFDecisionEntity findByPipelineId(int pipelineId);
}
