package com.smbc.lad.repository.pipeline;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.CapitalRequestFormEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class CreditInquiryEntity
 *
 */
@Repository
public interface CapitalRequestFormRepo extends 
								JpaRepository<CapitalRequestFormEntity, String> {

	public CapitalRequestFormEntity findByPipelineId(int pipelineId);
}
