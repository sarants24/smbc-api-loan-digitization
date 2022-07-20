package com.smbc.lad.repository.pipeline;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.RequestFacilityEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class RequestFacilityEntity
 *
 */
@Repository
public interface RequestFacilityRepo extends 
								JpaRepository<RequestFacilityEntity, String> {

	public RequestFacilityEntity findByPipelineId(int pipelineId);
}
