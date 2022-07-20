package com.smbc.lad.repository.pipeline;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.TransactionFilesEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class TransactionFilesEntity
 *
 */
@Repository
public interface TransactionFilesRepo extends 
								JpaRepository<TransactionFilesEntity, String> {

	public List<TransactionFilesEntity> findByPipelineId(int pipelineId);
	
	public TransactionFilesEntity findById(int id);
	
}
