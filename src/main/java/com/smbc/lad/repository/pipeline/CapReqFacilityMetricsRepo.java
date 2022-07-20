package com.smbc.lad.repository.pipeline;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.CapReqFacilityMetricsEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class CapitalRequestExposureEntity
 *
 */
@Repository
public interface CapReqFacilityMetricsRepo extends 
								JpaRepository<CapReqFacilityMetricsEntity, String> {

	public List<CapReqFacilityMetricsEntity> findByPipelineId(int pipelineId);
	
	public CapReqFacilityMetricsEntity findById(int id);
	
}
