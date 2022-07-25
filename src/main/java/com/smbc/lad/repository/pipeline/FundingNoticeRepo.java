package com.smbc.lad.repository.pipeline;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.FundingNoticeEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class FundingNoticeEntity
 *
 */
@Repository
public interface FundingNoticeRepo extends 
								JpaRepository<FundingNoticeEntity, String> {

	public FundingNoticeEntity findByPipelineId(int pipelineId);
}
