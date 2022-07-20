package com.smbc.lad.repository.lookup;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.lookup.PMGDecisionEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class PMGMeetingTypeEntity
 *
 */
@Repository
public interface PMGDecisionRepo extends 
								JpaRepository<PMGDecisionEntity, String> {

	public List<PMGDecisionEntity> findAllByOrderByOrderSequenceAsc();
}
