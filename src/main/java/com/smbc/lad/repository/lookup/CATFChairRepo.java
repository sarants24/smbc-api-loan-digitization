package com.smbc.lad.repository.lookup;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.lookup.CATFChairEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class AncillaryTimePeriodEntity
 *
 */
@Repository
public interface CATFChairRepo extends 
								JpaRepository<CATFChairEntity, String> {

	public List<CATFChairEntity> findAllByOrderByOrderSequenceAsc();
	
}
