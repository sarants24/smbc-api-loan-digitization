package com.smbc.lad.repository.lookup;


import java.util.List;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.lookup.SMBCRatingEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class SMBCRatingEntity
 *
 */
@Repository
public interface SMBCRatingRepo extends 
								JpaRepository<SMBCRatingEntity, String> {

	public List<SMBCRatingEntity> findAllByOrderByOrderSequenceAsc();
}
