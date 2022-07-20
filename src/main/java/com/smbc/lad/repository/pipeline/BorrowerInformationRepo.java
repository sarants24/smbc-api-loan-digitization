package com.smbc.lad.repository.pipeline;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.BorrowerInformationEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class BorrowerInformationEntity
 *
 */
@Repository
public interface BorrowerInformationRepo extends 
								JpaRepository<BorrowerInformationEntity, String> {

	public BorrowerInformationEntity findByPipelineId(int pipelineId);
}
