package com.smbc.lad.repository.pipeline;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.TransactionBackgroundEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class TransactionBackgroundEntity
 *
 */
@Repository
public interface TransactionBackgroundRepo extends 
								JpaRepository<TransactionBackgroundEntity, String> {

	public TransactionBackgroundEntity findByPipelineId(int pipelineId);
}
