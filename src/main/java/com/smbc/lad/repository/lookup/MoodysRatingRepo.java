package com.smbc.lad.repository.lookup;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.lookup.MoodysRatingEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class MoodysRatingEntity
 *
 */
@Repository
public interface MoodysRatingRepo extends 
								JpaRepository<MoodysRatingEntity, String> {

	public List<MoodysRatingEntity> findAllByOrderByOrderSequenceAsc();
}
