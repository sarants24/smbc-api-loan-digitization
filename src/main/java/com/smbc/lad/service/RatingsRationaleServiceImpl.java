package com.smbc.lad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.RatingsRationale;
import com.smbc.lad.entity.pipeline.RatingsRationaleEntity;
import com.smbc.lad.repository.pipeline.RatingsRationaleRepo;


/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an implementation class for the RatingsRationaleService. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
@Service
public class RatingsRationaleServiceImpl implements RatingsRationaleService {

	@Autowired
	private RatingsRationaleRepo ratingsRationaleRepo;
	
	/**
	 * This method is used to get the industry trend details for the given pipeline id
	 */
	public RatingsRationale getRatingsRationale(int pipelineId) {
		
		RatingsRationale ratingsRationale = new RatingsRationale();
		
		RatingsRationaleEntity ratingsRationaleEntity = ratingsRationaleRepo.findByPipelineId(pipelineId);
		
		if(ratingsRationaleEntity != null) {
			ratingsRationale.setPipelineId(ratingsRationaleEntity.getPipelineId());
			ratingsRationale.setSmbcObligorRating(ratingsRationaleEntity.getSmbcObligorRating());
			ratingsRationale.setRationaleToSupport(ratingsRationaleEntity.getRationaleToSupport());
			ratingsRationale.setRiskAppetite(ratingsRationaleEntity.getRiskAppetite());
			ratingsRationale.setBasicStrategy(ratingsRationaleEntity.getBasicStrategy());
			ratingsRationale.setActionPlan(ratingsRationaleEntity.getActionPlan());
			
		}
		
		return ratingsRationale;
	}
	
	/**
	 * This method is used to update the industry trend details for the given pipeline id
	 */
	public String updateRatingsRationaleById(int pipelineId,
			RatingsRationale ratingsRationale) throws Exception {
		
		RatingsRationaleEntity ratingsRationaleEntity = new RatingsRationaleEntity();
		
		ratingsRationaleEntity.setPipelineId(pipelineId);
		ratingsRationaleEntity.setSmbcObligorRating(ratingsRationale.getSmbcObligorRating());
		ratingsRationaleEntity.setRationaleToSupport(ratingsRationale.getRationaleToSupport());
		ratingsRationaleEntity.setRiskAppetite(ratingsRationale.getRiskAppetite());
		ratingsRationaleEntity.setBasicStrategy(ratingsRationale.getBasicStrategy());
		ratingsRationaleEntity.setActionPlan(ratingsRationale.getActionPlan());
		ratingsRationaleRepo.save(ratingsRationaleEntity);
		
		return "Success";
	}	
}
