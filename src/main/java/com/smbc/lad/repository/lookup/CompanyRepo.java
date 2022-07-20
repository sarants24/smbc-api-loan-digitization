package com.smbc.lad.repository.lookup;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.lad.entity.lookup.CompanyEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * JPA Repository class to read data from Entity class ApplicationStatusEntity
 *
 */
@Repository
public interface CompanyRepo extends 
								JpaRepository<CompanyEntity, String> {

	public List<CompanyEntity> findAllByOrderByOrderSequenceAsc();
	
	public CompanyEntity findBySmunId(String smunId);
}
