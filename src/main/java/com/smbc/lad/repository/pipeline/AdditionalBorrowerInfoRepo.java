package com.smbc.lad.repository.pipeline;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.AdditionalBorrowerInfoEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class AdditionalBorrowerInfoEntity
 *
 */
@Repository
public interface AdditionalBorrowerInfoRepo extends 
								JpaRepository<AdditionalBorrowerInfoEntity, String> {

	public List<AdditionalBorrowerInfoEntity> findByPipelineId(int pipelineId);
	
	public AdditionalBorrowerInfoEntity findByAddtionalBorrowerId(int addtionalBorrowerId);
	
	@Query(value="select smun_id from pipelinedeals_additional_borrowerinfo where pipeline_id=?1",nativeQuery=true)
	public List<String> getSmunId(int pipelineId);
}
