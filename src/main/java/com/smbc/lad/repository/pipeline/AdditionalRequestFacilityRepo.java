package com.smbc.lad.repository.pipeline;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.AdditionalRequestFacilityEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class AdditionalRequestFacilityEntity
 *
 */
@Repository
public interface AdditionalRequestFacilityRepo extends 
								JpaRepository<AdditionalRequestFacilityEntity, String> {

	public List<AdditionalRequestFacilityEntity> findByPipelineId(int pipelineId);
	
	public AdditionalRequestFacilityEntity findByAdditionalFacilityId(int additionalFacilityId);
	
	public AdditionalRequestFacilityEntity findByFacilities(String facilities);
	
}
