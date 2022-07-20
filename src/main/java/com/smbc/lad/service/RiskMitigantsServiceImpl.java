package com.smbc.lad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.RiskMitigants;
import com.smbc.lad.entity.pipeline.RiskMitigantsEntity;
import com.smbc.lad.repository.pipeline.RiskMitigantsRepo;


/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an implementation class for the RiskMitigantsService. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
@Service
public class RiskMitigantsServiceImpl implements RiskMitigantsService {

	@Autowired
	private RiskMitigantsRepo riskMitigantsRepo;
	
	/**
	 * This method is used to get the industry trend details for the given pipeline id
	 */
	public RiskMitigants getRiskMitigants(int pipelineId) {
		
		RiskMitigants riskMitigants = new RiskMitigants();
		
		RiskMitigantsEntity riskMitigantsEntity = riskMitigantsRepo.findByPipelineId(pipelineId);
		
		if(riskMitigantsEntity != null) {
			riskMitigants.setPipelineId(riskMitigantsEntity.getPipelineId());
			riskMitigants.setKeyRisks(riskMitigantsEntity.getKeyRisks());
			riskMitigants.setRiskStatement1(riskMitigantsEntity.getRiskStatement1());
			riskMitigants.setRiskStatement2(riskMitigantsEntity.getRiskStatement2());
			riskMitigants.setRiskStatement3(riskMitigantsEntity.getRiskStatement3());
			riskMitigants.setRiskStatement4(riskMitigantsEntity.getRiskStatement4());
			riskMitigants.setRiskStatement5(riskMitigantsEntity.getRiskStatement5());
			riskMitigants.setRiskProbability1(riskMitigantsEntity.getRiskProbability1());
			riskMitigants.setRiskProbability2(riskMitigantsEntity.getRiskProbability2());
			riskMitigants.setRiskProbability3(riskMitigantsEntity.getRiskProbability3());
			riskMitigants.setRiskProbability4(riskMitigantsEntity.getRiskProbability4());
			riskMitigants.setRiskProbability5(riskMitigantsEntity.getRiskProbability5());
			riskMitigants.setRiskIncome1(riskMitigantsEntity.getRiskIncome1());
			riskMitigants.setRiskIncome2(riskMitigantsEntity.getRiskIncome2());
			riskMitigants.setRiskIncome3(riskMitigantsEntity.getRiskIncome3());
			riskMitigants.setRiskIncome4(riskMitigantsEntity.getRiskIncome4());
			riskMitigants.setRiskIncome5(riskMitigantsEntity.getRiskIncome5());
			riskMitigants.setRiskMitigant1(riskMitigantsEntity.getRiskMitigant1());
			riskMitigants.setRiskMitigant2(riskMitigantsEntity.getRiskMitigant2());
			riskMitigants.setRiskMitigant3(riskMitigantsEntity.getRiskMitigant3());
			riskMitigants.setRiskMitigant4(riskMitigantsEntity.getRiskMitigant4());
			riskMitigants.setRiskMitigant5(riskMitigantsEntity.getRiskMitigant5());
		}
		
		return riskMitigants;
	}
	
	/**
	 * This method is used to update the industry trend details for the given pipeline id
	 */
	public String updateRiskMitigantsById(int pipelineId,
			RiskMitigants riskMitigants) throws Exception {
		
		RiskMitigantsEntity riskMitigantsEntity = new RiskMitigantsEntity();
		
		riskMitigantsEntity.setPipelineId(pipelineId);
		riskMitigantsEntity.setKeyRisks(riskMitigants.getKeyRisks());
		riskMitigantsEntity.setRiskStatement1(riskMitigants.getRiskStatement1());
		riskMitigantsEntity.setRiskStatement2(riskMitigants.getRiskStatement2());
		riskMitigantsEntity.setRiskStatement3(riskMitigants.getRiskStatement3());
		riskMitigantsEntity.setRiskStatement4(riskMitigants.getRiskStatement4());
		riskMitigantsEntity.setRiskStatement5(riskMitigants.getRiskStatement5());
		riskMitigantsEntity.setRiskProbability1(riskMitigants.getRiskProbability1());
		riskMitigantsEntity.setRiskProbability2(riskMitigants.getRiskProbability2());
		riskMitigantsEntity.setRiskProbability3(riskMitigants.getRiskProbability3());
		riskMitigantsEntity.setRiskProbability4(riskMitigants.getRiskProbability4());
		riskMitigantsEntity.setRiskProbability5(riskMitigants.getRiskProbability5());
		riskMitigantsEntity.setRiskIncome1(riskMitigants.getRiskIncome1());
		riskMitigantsEntity.setRiskIncome2(riskMitigants.getRiskIncome2());
		riskMitigantsEntity.setRiskIncome3(riskMitigants.getRiskIncome3());
		riskMitigantsEntity.setRiskIncome4(riskMitigants.getRiskIncome4());
		riskMitigantsEntity.setRiskIncome5(riskMitigants.getRiskIncome5());
		riskMitigantsEntity.setRiskMitigant1(riskMitigants.getRiskMitigant1());
		riskMitigantsEntity.setRiskMitigant2(riskMitigants.getRiskMitigant2());
		riskMitigantsEntity.setRiskMitigant3(riskMitigants.getRiskMitigant3());
		riskMitigantsEntity.setRiskMitigant4(riskMitigants.getRiskMitigant4());
		riskMitigantsEntity.setRiskMitigant5(riskMitigants.getRiskMitigant5());
		
		riskMitigantsRepo.save(riskMitigantsEntity);
		
		return "Success";
	}	
}
