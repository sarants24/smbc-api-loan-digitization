package com.smbc.lad.repository.pipeline;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.RiskMitigantsEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class RiskMitigantsEntity
 *
 */
@Repository
public interface RiskMitigantsRepo extends 
								JpaRepository<RiskMitigantsEntity, String> {

	public RiskMitigantsEntity findByPipelineId(int pipelineId);
	
}
