package com.smbc.lad.repository.pipeline;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.CapitalRequestExposureEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class CapitalRequestExposureEntity
 *
 */
@Repository
public interface CapitalRequestExposureRepo extends 
								JpaRepository<CapitalRequestExposureEntity, String> {

	public List<CapitalRequestExposureEntity> findByPipelineId(int pipelineId);
	
	public CapitalRequestExposureEntity findById(int id);
	
}
