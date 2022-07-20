package com.smbc.lad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.BaseStressProjections;
import com.smbc.lad.entity.pipeline.BaseStressProjectionsEntity;
import com.smbc.lad.repository.pipeline.BaseStressProjectionsRepo;


/**
 * @author Saravanan T
 * @since May 2022
 * 
 * This is an implementation class for the BaseStressProjectionsServiceImpl. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
@Service
public class BaseStressProjectionsServiceImpl implements BaseStressProjectionsService {

	@Autowired
	private BaseStressProjectionsRepo baseStressProjectionsRepo;
	
	/**
	 * This method is used to get the industry trend details for the given pipeline id
	 */
	public BaseStressProjections getBaseStressProjections(int pipelineId) {
		
		BaseStressProjections baseStressProjections = new BaseStressProjections();
		
		BaseStressProjectionsEntity baseStressProjectionsEntity = baseStressProjectionsRepo.findByPipelineId(pipelineId);
		
		if(baseStressProjectionsEntity != null) {
			baseStressProjections.setPipelineId(baseStressProjectionsEntity.getPipelineId());
			baseStressProjections.setSource(baseStressProjectionsEntity.getSource());
			baseStressProjections.setBaseFli(baseStressProjectionsEntity.getBaseFli());
			baseStressProjections.setStressFli(baseStressProjectionsEntity.getStressFli());
			baseStressProjections.setBaseRevenue(baseStressProjectionsEntity.getBaseRevenue());
			baseStressProjections.setStressRevenue(baseStressProjectionsEntity.getStressRevenue());
			baseStressProjections.setBaseGrossMargin(baseStressProjectionsEntity.getBaseGrossMargin());
			baseStressProjections.setStressGrossMargin(baseStressProjectionsEntity.getStressGrossMargin());
			baseStressProjections.setBaseSgna(baseStressProjectionsEntity.getBaseSgna());
			baseStressProjections.setStressSgna(baseStressProjectionsEntity.getStressSgna());
			baseStressProjections.setBaseEbita(baseStressProjectionsEntity.getBaseEbita());
			baseStressProjections.setStressEbita(baseStressProjectionsEntity.getStressEbita());
			baseStressProjections.setBaseInterestExpense(baseStressProjectionsEntity.getBaseInterestExpense());
			baseStressProjections.setStressInterestExpense(baseStressProjectionsEntity.getStressInterestExpense());
			baseStressProjections.setBaseTaxes(baseStressProjectionsEntity.getBaseTaxes());
			baseStressProjections.setStressTaxes(baseStressProjectionsEntity.getStressTaxes());
			baseStressProjections.setBaseDna(baseStressProjectionsEntity.getBaseDna());
			baseStressProjections.setStressDna(baseStressProjectionsEntity.getStressDna());
			baseStressProjections.setBaseWorkingCapital(baseStressProjectionsEntity.getBaseWorkingCapital());
			baseStressProjections.setStressWorkingCapital(baseStressProjectionsEntity.getStressWorkingCapital());
			baseStressProjections.setBaseCapex(baseStressProjectionsEntity.getBaseCapex());
			baseStressProjections.setStressCapex(baseStressProjectionsEntity.getStressCapex());
			baseStressProjections.setBaseDividends(baseStressProjectionsEntity.getBaseDividends());
			baseStressProjections.setStressDividends(baseStressProjectionsEntity.getStressDividends());
			baseStressProjections.setBaseAcquistion(baseStressProjectionsEntity.getBaseAcquistion());
			baseStressProjections.setStressAcquistion(baseStressProjectionsEntity.getStressAcquistion());
			baseStressProjections.setBaseEquityIssuance(baseStressProjectionsEntity.getBaseEquityIssuance());
			baseStressProjections.setStressEquityIssuance(baseStressProjectionsEntity.getStressEquityIssuance());
			baseStressProjections.setBaseDebtIssuance(baseStressProjectionsEntity.getBaseDebtIssuance());
			baseStressProjections.setStressDebtIssuance(baseStressProjectionsEntity.getStressDebtIssuance());
			baseStressProjections.setBaseSummary(baseStressProjectionsEntity.getBaseSummary());
			baseStressProjections.setStressSummary(baseStressProjectionsEntity.getStressSummary());
			baseStressProjections.setBaseFccr(baseStressProjectionsEntity.getBaseFccr());
			baseStressProjections.setStressFccr(baseStressProjectionsEntity.getStressFccr());
			baseStressProjections.setBaseCovenantCompliance(baseStressProjectionsEntity.getBaseCovenantCompliance());
			baseStressProjections.setStressCovenantCompliance(baseStressProjectionsEntity.getStressCovenantCompliance());
			baseStressProjections.setBaseDebtMaturity(baseStressProjectionsEntity.getBaseDebtMaturity());
			baseStressProjections.setStressDebtMaturity(baseStressProjectionsEntity.getStressDebtMaturity());
		}
		
		return baseStressProjections;
	}
	
	/**
	 * This method is used to update the industry trend details for the given pipeline id
	 */
	public String updateBaseStressProjectionsById(int pipelineId,
			BaseStressProjections baseStressProjections) throws Exception {
		
		BaseStressProjectionsEntity baseStressProjectionsEntity = new BaseStressProjectionsEntity();
		
		baseStressProjectionsEntity.setPipelineId(baseStressProjections.getPipelineId());
		baseStressProjectionsEntity.setSource(baseStressProjections.getSource());
		baseStressProjectionsEntity.setBaseFli(baseStressProjections.getBaseFli());
		baseStressProjectionsEntity.setStressFli(baseStressProjections.getStressFli());
		baseStressProjectionsEntity.setBaseRevenue(baseStressProjections.getBaseRevenue());
		baseStressProjectionsEntity.setStressRevenue(baseStressProjections.getStressRevenue());
		baseStressProjectionsEntity.setBaseGrossMargin(baseStressProjections.getBaseGrossMargin());
		baseStressProjectionsEntity.setStressGrossMargin(baseStressProjections.getStressGrossMargin());
		baseStressProjectionsEntity.setBaseSgna(baseStressProjections.getBaseSgna());
		baseStressProjectionsEntity.setStressSgna(baseStressProjections.getStressSgna());
		baseStressProjectionsEntity.setBaseEbita(baseStressProjections.getBaseEbita());
		baseStressProjectionsEntity.setStressEbita(baseStressProjections.getStressEbita());
		baseStressProjectionsEntity.setBaseInterestExpense(baseStressProjections.getBaseInterestExpense());
		baseStressProjectionsEntity.setStressInterestExpense(baseStressProjections.getStressInterestExpense());
		baseStressProjectionsEntity.setBaseTaxes(baseStressProjections.getBaseTaxes());
		baseStressProjectionsEntity.setStressTaxes(baseStressProjections.getStressTaxes());
		baseStressProjectionsEntity.setBaseDna(baseStressProjections.getBaseDna());
		baseStressProjectionsEntity.setStressDna(baseStressProjections.getStressDna());
		baseStressProjectionsEntity.setBaseWorkingCapital(baseStressProjections.getBaseWorkingCapital());
		baseStressProjectionsEntity.setStressWorkingCapital(baseStressProjections.getStressWorkingCapital());
		baseStressProjectionsEntity.setBaseCapex(baseStressProjections.getBaseCapex());
		baseStressProjectionsEntity.setStressCapex(baseStressProjections.getStressCapex());
		baseStressProjectionsEntity.setBaseDividends(baseStressProjections.getBaseDividends());
		baseStressProjectionsEntity.setStressDividends(baseStressProjections.getStressDividends());
		baseStressProjectionsEntity.setBaseAcquistion(baseStressProjections.getBaseAcquistion());
		baseStressProjectionsEntity.setStressAcquistion(baseStressProjections.getStressAcquistion());
		baseStressProjectionsEntity.setBaseEquityIssuance(baseStressProjections.getBaseEquityIssuance());
		baseStressProjectionsEntity.setStressEquityIssuance(baseStressProjections.getStressEquityIssuance());
		baseStressProjectionsEntity.setBaseDebtIssuance(baseStressProjections.getBaseDebtIssuance());
		baseStressProjectionsEntity.setStressDebtIssuance(baseStressProjections.getStressDebtIssuance());
		baseStressProjectionsEntity.setBaseSummary(baseStressProjections.getBaseSummary());
		baseStressProjectionsEntity.setStressSummary(baseStressProjections.getStressSummary());
		baseStressProjectionsEntity.setBaseFccr(baseStressProjections.getBaseFccr());
		baseStressProjectionsEntity.setStressFccr(baseStressProjections.getStressFccr());
		baseStressProjectionsEntity.setBaseCovenantCompliance(baseStressProjections.getBaseCovenantCompliance());
		baseStressProjectionsEntity.setStressCovenantCompliance(baseStressProjections.getStressCovenantCompliance());
		baseStressProjectionsEntity.setBaseDebtMaturity(baseStressProjections.getBaseDebtMaturity());
		baseStressProjectionsEntity.setStressDebtMaturity(baseStressProjections.getStressDebtMaturity());

		baseStressProjectionsRepo.save(baseStressProjectionsEntity);
		
		return "Success";
	}	
}
