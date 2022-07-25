package com.smbc.lad.repository.pipeline;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.FileDataEntity;
import com.smbc.lad.entity.pipeline.FundingTermsEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class FundingTermsEntity
 *
 */
@Repository
public interface FundingTermsRepo extends 
								JpaRepository<FundingTermsEntity, String> {

	public List<FundingTermsEntity> findByPipelineId(int pipelineId);
	
	public FundingTermsEntity findById(int id);
	
}
