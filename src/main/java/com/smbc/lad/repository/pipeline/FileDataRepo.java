package com.smbc.lad.repository.pipeline;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.FileDataEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class FileDataEntity
 *
 */
@Repository
public interface FileDataRepo extends 
								JpaRepository<FileDataEntity, String> {

	public List<FileDataEntity> findByPipelineId(int pipelineId);
	
	public FileDataEntity findById(int id);
	
}
