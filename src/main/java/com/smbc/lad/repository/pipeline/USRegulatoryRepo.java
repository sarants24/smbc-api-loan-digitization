package com.smbc.lad.repository.pipeline;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.USRegulatoryEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class USRegulatoryEntity
 *
 */
@Repository
public interface USRegulatoryRepo extends 
								JpaRepository<USRegulatoryEntity, String> {

	public List<USRegulatoryEntity> findByPipelineId(int pipelineId);
	
}
