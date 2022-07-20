package com.smbc.lad.repository.pipeline;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.ParentInformationEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class ParentInformationEntity
 *
 */
@Repository
public interface ParentInformationRepo extends 
								JpaRepository<ParentInformationEntity, String> {

	public ParentInformationEntity findByPipelineId(int pipelineId);
}
