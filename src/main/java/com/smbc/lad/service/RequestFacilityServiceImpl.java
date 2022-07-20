package com.smbc.lad.service;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.RequestFacilities;
import com.smbc.lad.entity.pipeline.AdditionalRequestFacilityEntity;
import com.smbc.lad.entity.pipeline.PipelineDealsBasicsEntity;
import com.smbc.lad.entity.pipeline.PipelineDealsEntity;
import com.smbc.lad.entity.pipeline.RequestFacilityBaseEntity;
import com.smbc.lad.entity.pipeline.RequestFacilityEntity;
import com.smbc.lad.exception.SMBCBusinessException;
import com.smbc.lad.exception.SMBCResourceNotFoundException;
import com.smbc.lad.repository.pipeline.AdditionalRequestFacilityRepo;
import com.smbc.lad.repository.pipeline.RequestFacilityRepo;
import com.smbc.lad.utils.LADUtils;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an implementation class for the Request Facility entities (Primary and Additional). 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
@Service
public class RequestFacilityServiceImpl implements RequestFacilityService {

	@Autowired
	private PipelineDealsService pipelineDealsService;
	
	@Autowired
	private RequestFacilityRepo requestFacilityRepo;
	
	@Autowired
	private AdditionalRequestFacilityRepo additionalRequestFacilityRepo;
	
	
	/**
	 * This method is used to get the Primary Request Facility Details for the given pipeline Id
	 */
	public RequestFacilities getRequestFacilityById(int pipelineId) throws Exception {
		
		PipelineDealsEntity pipelineDealsEntity = pipelineDealsService.getPipelineDealsEntity(pipelineId);
		PipelineDealsBasicsEntity pipelineDealsBasicsEntity = pipelineDealsService.getPipelineDealsBasicsEntity(pipelineId);
		
		RequestFacilities requestFacilities = new RequestFacilities();
		
		RequestFacilityEntity requestFacilityEntity = 
									requestFacilityRepo.findByPipelineId(pipelineId);
		
		if (requestFacilityEntity != null) {
			requestFacilities = setRequestFacilityDetails(requestFacilityEntity);
			requestFacilities.setFacilityDescription(requestFacilityEntity.getFacilityDescription());
		}
		requestFacilities.setPipelineId(pipelineId);
		
		//From Pipeline Deals
		if(pipelineDealsEntity != null) {
			requestFacilities.setBorrowerName(pipelineDealsEntity.getBorrowerName());
		}
		
		if(pipelineDealsBasicsEntity != null) {
			requestFacilities.setCurrentFacilityLimit(pipelineDealsBasicsEntity.getCurrentFacilityLimit());
			requestFacilities.setProposedFacilityLimit(pipelineDealsBasicsEntity.getProposedFacilityLimit());
		}
		
		return requestFacilities;
	}
	
	/**
	 * This method is used to update the PrimaryRequest Facility Details for the given pipeline Id
	 */
	public String updateRequestFacilityById(int pipelineId,
					RequestFacilities requestFacilities) throws Exception{
		
		PipelineDealsBasicsEntity pipelineDealsBasicsEntity = pipelineDealsService.getPipelineDealsBasicsEntity(pipelineId);
		
		RequestFacilityEntity requestFacilityEntity = 
									requestFacilityRepo.findByPipelineId(pipelineId);
		
		if(requestFacilityEntity == null) {
			requestFacilityEntity= new RequestFacilityEntity();
			requestFacilityEntity.setFacilities(requestFacilities.getFacilities());
		}
		
		String oldFacilityName = requestFacilityEntity.getFacilities();
		String newFacilityName = requestFacilities.getFacilities();
		
		if(!oldFacilityName.equals(newFacilityName)) {
			validateFacilityDuplicate(newFacilityName);
		}
		requestFacilityEntity.setFacilities(requestFacilities.getFacilities());
		
		
		requestFacilityEntity.setPipelineId(pipelineId);
		requestFacilityEntity.setSunId(pipelineDealsBasicsEntity.getSunId());
		requestFacilityEntity.setFacilityDescription(requestFacilities.getFacilityDescription());
		
		setRequestBaseEntity(requestFacilityEntity,requestFacilities);
		requestFacilityRepo.save(requestFacilityEntity);
		
		if(pipelineDealsBasicsEntity != null) {
			pipelineDealsBasicsEntity.setCurrentFacilityLimit(requestFacilities.getCurrentFacilityLimit());
			pipelineDealsBasicsEntity.setProposedFacilityLimit(requestFacilities.getProposedFacilityLimit());
			
			pipelineDealsService.savePipelineDealsBasicsEntity(pipelineDealsBasicsEntity);
		}
		
		return "Success";
	}
	
	
	//Additional Request Facility
	
	/**
	 * This method is used to get the list of additional Request Facility Details 
	 * for the given pipeline Id
	 */
	public List<RequestFacilities> getAddtlRequestFacilitiesByPipelineId(int pipelineId) throws Exception {
		
		PipelineDealsEntity pipelineDealsEntity = pipelineDealsService.getPipelineDealsEntity(pipelineId);
		
		List<AdditionalRequestFacilityEntity> additionalRequestFacilityEntityList = 
								additionalRequestFacilityRepo.findByPipelineId(pipelineId);

		List<RequestFacilities> requestFacilitiesCollection = new ArrayList<RequestFacilities>();
		
		if(additionalRequestFacilityEntityList != null) {
			for(AdditionalRequestFacilityEntity additionalRequestFacilityEntity : additionalRequestFacilityEntityList) {
				RequestFacilities requestFacilities = 
								setRequestFacilityDetails(additionalRequestFacilityEntity);
				
				requestFacilities.setPipelineId(pipelineId);
				requestFacilities.setAdditionalFacilityId(
						additionalRequestFacilityEntity.getAdditionalFacilityId());
				requestFacilities.setCurrentFacilityLimit(
						additionalRequestFacilityEntity.getCurrentFacilityLimit());
				requestFacilities.setProposedFacilityLimit(
						additionalRequestFacilityEntity.getProposedFacilityLimit());
				
				//From Pipeline Deals
				if(pipelineDealsEntity != null) {
					requestFacilities.setBorrowerName(pipelineDealsEntity.getBorrowerName());
				}
				
				requestFacilitiesCollection.add(requestFacilities);
			}
		}
		
		return requestFacilitiesCollection;
	}
	
	/**
	 * This method is used to get the additional Request Facility Details 
	 * for the given facility Id
	 */
	public RequestFacilities getRequestFacilitiesByFacilityId(int addtionalFacilityId) throws Exception {
		
		AdditionalRequestFacilityEntity additionalRequestFacilityEntity = 
				additionalRequestFacilityRepo.findByAdditionalFacilityId(addtionalFacilityId);
		
		RequestFacilities requestFacilities = new RequestFacilities();
		
		if(additionalRequestFacilityEntity != null) {
			requestFacilities = 
				setRequestFacilityDetails(additionalRequestFacilityEntity);
	
				requestFacilities.setPipelineId(
						additionalRequestFacilityEntity.getPipelineId());
				requestFacilities.setAdditionalFacilityId(
						additionalRequestFacilityEntity.getAdditionalFacilityId());
				requestFacilities.setCurrentFacilityLimit(
						additionalRequestFacilityEntity.getCurrentFacilityLimit());
				requestFacilities.setProposedFacilityLimit(
						additionalRequestFacilityEntity.getProposedFacilityLimit());
				
				PipelineDealsEntity pipelineDealsEntity = pipelineDealsService.getPipelineDealsEntity(
										additionalRequestFacilityEntity.getPipelineId());
				//From Pipeline Deals
				if(pipelineDealsEntity != null) {
					requestFacilities.setBorrowerName(pipelineDealsEntity.getBorrowerName());
				}
		}
		
		return requestFacilities;
	}
	
	/**
	 * This method is used to add the Additional Request Facility for the given Pipeline Id
	 */
	public String addAdditionalRequestFacilityById(int pipelineId,RequestFacilities requestFacilities) throws Exception {
		
		validateFacilityDuplicate(requestFacilities.getFacilities());
		
		PipelineDealsEntity pipelineDealsEntity = pipelineDealsService.getPipelineDealsEntity(pipelineId);
		
		AdditionalRequestFacilityEntity additionalRequestFacilityEntity = new AdditionalRequestFacilityEntity();
		
		setRequestBaseEntity(additionalRequestFacilityEntity,requestFacilities);
		
		additionalRequestFacilityEntity.setFacilities(requestFacilities.getFacilities());
		additionalRequestFacilityEntity.setPipelineId(pipelineId);
		additionalRequestFacilityEntity.setCurrentFacilityLimit(
				requestFacilities.getCurrentFacilityLimit());
		additionalRequestFacilityEntity.setProposedFacilityLimit(
				requestFacilities.getProposedFacilityLimit());
		
		if(pipelineDealsEntity!= null) {
			additionalRequestFacilityEntity.setSunId(pipelineDealsEntity.getSunId());
		}
		
		additionalRequestFacilityRepo.save(additionalRequestFacilityEntity);
		
		return "Success";
	}
	
	/**
	 * This method is used to update the Additional Request Facility for the given Additional Facility Id
	 */
	public String updateAdditionalRequestFacilityById(int addtionalFacilityId,
									RequestFacilities requestFacilities) throws Exception {
		
		AdditionalRequestFacilityEntity additionalRequestFacilityEntity = 
				getAdditionalRequestFacilityEntity(addtionalFacilityId);
		
		String oldFacilityName = additionalRequestFacilityEntity.getFacilities();
		String newFacilityName = requestFacilities.getFacilities();
		
		if(!oldFacilityName.equals(newFacilityName)) {
			validateFacilityDuplicate(newFacilityName);
		}
		
		setRequestBaseEntity(additionalRequestFacilityEntity,requestFacilities);
		additionalRequestFacilityEntity.setFacilities(requestFacilities.getFacilities());
		additionalRequestFacilityEntity.setCurrentFacilityLimit(
				requestFacilities.getCurrentFacilityLimit());
		additionalRequestFacilityEntity.setProposedFacilityLimit(
				requestFacilities.getProposedFacilityLimit());
		
		additionalRequestFacilityRepo.save(additionalRequestFacilityEntity);
		
		return "Success";
	}
	
	/**
	 * This method is used to delete the Additional Request Facility for the given Additional Facility Id
	 */
	public String deleteAdditionalFacilityById(int addtionalFacilityId) throws Exception {
		
		AdditionalRequestFacilityEntity additionalRequestFacilityEntity = 
				getAdditionalRequestFacilityEntity(addtionalFacilityId);
		
		additionalRequestFacilityRepo.delete(additionalRequestFacilityEntity);
		
		return "sucess";  
	}
	
	/**
	 * This method is used to get the AdditionalRequestFacilityEntity of the given additioanl facility id
	 * @param pipelineId
	 * @return
	 */
	private AdditionalRequestFacilityEntity getAdditionalRequestFacilityEntity(int addtionalFacilityId) {
		
		AdditionalRequestFacilityEntity additionalRequestFacilityEntity = 
				additionalRequestFacilityRepo.findByAdditionalFacilityId(addtionalFacilityId);
		
		if(additionalRequestFacilityEntity == null) {
			throw new SMBCResourceNotFoundException("Additional Request Facility details not found for the additional facility id " + addtionalFacilityId);
		}
		
		return additionalRequestFacilityEntity;
	}
	
	/**
	 * This method is used to validate the duplicate facility id
	 */
	private void validateFacilityDuplicate(String facilityName) {
		
		if(LADUtils.checkNullorEmpty(facilityName)) {
			throw new SMBCBusinessException("Please enter Facility Name");
		}
		
		AdditionalRequestFacilityEntity checkFacilityName = 
				additionalRequestFacilityRepo.findByFacilities(facilityName);
		
		if(checkFacilityName != null) {
			throw new SMBCBusinessException("The given facility name " + facilityName + " already exists");
		}
		
	}
	
	//Common Methods
	private RequestFacilities setRequestFacilityDetails(
			RequestFacilityBaseEntity requestFacilityBaseEntity) throws Exception {
		
		RequestFacilities requestFacilities = new RequestFacilities();
		requestFacilities.setFacilities(requestFacilityBaseEntity.getFacilities());
		requestFacilities.setUnappliedCash(requestFacilityBaseEntity.getUnappliedCash());
		requestFacilities.setTenor(requestFacilityBaseEntity.getTenor());
		requestFacilities.setMargin(requestFacilityBaseEntity.getMargin());
		requestFacilities.setDrawnPricing(requestFacilityBaseEntity.getDrawnPricing());
		requestFacilities.setOutstandingAmount(requestFacilityBaseEntity.getOutstandingAmount());
		requestFacilities.setMaturityDate(
				LADUtils.formatDatetoString(requestFacilityBaseEntity.getMaturityDate()));
		
		return requestFacilities;
	}
	
	private void setRequestBaseEntity(RequestFacilityBaseEntity requestFacilityBaseEntity,
							RequestFacilities requestFacilities) throws Exception {
		
		requestFacilityBaseEntity.setUnappliedCash(requestFacilities.getUnappliedCash());
		requestFacilityBaseEntity.setTenor(requestFacilities.getTenor());
		requestFacilityBaseEntity.setMargin(requestFacilities.getMargin());
		requestFacilityBaseEntity.setDrawnPricing(requestFacilities.getDrawnPricing());
		requestFacilityBaseEntity.setOutstandingAmount(requestFacilities.getOutstandingAmount());
		requestFacilityBaseEntity.setMaturityDate(
				LADUtils.formatStringtoDate(requestFacilities.getMaturityDate()));
	}
	
}
