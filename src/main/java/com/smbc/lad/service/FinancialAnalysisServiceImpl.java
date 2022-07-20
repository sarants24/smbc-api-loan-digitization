package com.smbc.lad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.FinancialAnalysis;
import com.smbc.lad.entity.pipeline.FinancialAnalysisEntity;
import com.smbc.lad.repository.pipeline.FinancialAnalysisRepo;


/**
 * @author Saravanan T
 * @since May 2022
 * 
 * This is an implementation class for the FinancialAnalysisServiceImpl. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
@Service
public class FinancialAnalysisServiceImpl implements FinancialAnalysisService {

	@Autowired
	private FinancialAnalysisRepo financialAnalysisRepo;
	
	/**
	 * This method is used to get the industry trend details for the given pipeline id
	 */
	public FinancialAnalysis getFinancialAnalysis(int pipelineId) {
		
		FinancialAnalysis financialAnalysis = new FinancialAnalysis();
		
		FinancialAnalysisEntity financialAnalysisEntity = financialAnalysisRepo.findByPipelineId(pipelineId);
		
		if(financialAnalysisEntity != null) {
			financialAnalysis.setPipelineId(financialAnalysisEntity.getPipelineId());
			financialAnalysis.setBusinessSegmentAnalysis(financialAnalysisEntity.getBusinessSegmentAnalysis());
			financialAnalysis.setGeographicSegmentAnalysis(financialAnalysisEntity.getGeographicSegmentAnalysis());
			financialAnalysis.setIncomeStatementTrends(financialAnalysisEntity.getIncomeStatementTrends());
			financialAnalysis.setEbitaAnalysis(financialAnalysisEntity.getEbitaAnalysis());
			financialAnalysis.setBalanceSheet(financialAnalysisEntity.getBalanceSheet());
			financialAnalysis.setCahFlow(financialAnalysisEntity.getCahFlow());
			financialAnalysis.setLiquidity(financialAnalysisEntity.getLiquidity());
			financialAnalysis.setCovenantComplaince(financialAnalysisEntity.getCovenantComplaince());
			financialAnalysis.setFixedChargeCoverage(financialAnalysisEntity.getFixedChargeCoverage());
			financialAnalysis.setUnfavourableInformation(financialAnalysisEntity.getUnfavourableInformation());

		}
		
		return financialAnalysis;
	}
	
	/**
	 * This method is used to update the industry trend details for the given pipeline id
	 */
	public String updateFinancialAnalysisById(int pipelineId,
			FinancialAnalysis financialAnalysis) throws Exception {
		
		FinancialAnalysisEntity financialAnalysisEntity = new FinancialAnalysisEntity();
		
		financialAnalysisEntity.setPipelineId(pipelineId);
		financialAnalysisEntity.setBusinessSegmentAnalysis(financialAnalysis.getBusinessSegmentAnalysis());
		financialAnalysisEntity.setGeographicSegmentAnalysis(financialAnalysis.getGeographicSegmentAnalysis());
		financialAnalysisEntity.setIncomeStatementTrends(financialAnalysis.getIncomeStatementTrends());
		financialAnalysisEntity.setEbitaAnalysis(financialAnalysis.getEbitaAnalysis());
		financialAnalysisEntity.setBalanceSheet(financialAnalysis.getBalanceSheet());
		financialAnalysisEntity.setCahFlow(financialAnalysis.getCahFlow());
		financialAnalysisEntity.setLiquidity(financialAnalysis.getLiquidity());
		financialAnalysisEntity.setCovenantComplaince(financialAnalysis.getCovenantComplaince());
		financialAnalysisEntity.setFixedChargeCoverage(financialAnalysis.getFixedChargeCoverage());
		financialAnalysisEntity.setUnfavourableInformation(financialAnalysis.getUnfavourableInformation());

		financialAnalysisRepo.save(financialAnalysisEntity);
		
		return "Success";
	}	
}
