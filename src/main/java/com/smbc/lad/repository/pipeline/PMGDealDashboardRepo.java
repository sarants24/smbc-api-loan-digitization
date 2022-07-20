package com.smbc.lad.repository.pipeline;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.pipeline.PMGDealDashboardEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class PipelineDealsEntity
 *
 */
@Repository
public interface PMGDealDashboardRepo extends 
								JpaRepository<PMGDealDashboardEntity, String> {

	@Query(value="select * from pipeline_deals p where p.application_status_id IN (:statusIds)",nativeQuery=true)
	public List<PMGDealDashboardEntity> findPipelineDealsEntityByAppStatusId(List<String> statusIds);

}
