package com.smbc.lad.repository.pipeline;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.FinancialAnalysisEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class FinancialAnalysisEntity
 *
 */
@Repository
public interface FinancialAnalysisRepo extends 
								JpaRepository<FinancialAnalysisEntity, String> {

	public FinancialAnalysisEntity findByPipelineId(int pipelineId);
}