package com.smbc.lad.repository.pipeline;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.CreditInquiryEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class CreditInquiryEntity
 *
 */
@Repository
public interface CreditInquiryRepo extends 
								JpaRepository<CreditInquiryEntity, String> {

	public CreditInquiryEntity findByPipelineId(int pipelineId);
}
