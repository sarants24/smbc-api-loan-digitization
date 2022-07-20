package com.smbc.lad.repository.lookup;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.lookup.SNPRatingEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class SNPRatingEntity
 *
 */
@Repository
public interface SNPRatingRepo extends 
								JpaRepository<SNPRatingEntity, String> {

	public List<SNPRatingEntity> findAllByOrderByOrderSequenceAsc();
}
