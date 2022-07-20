package com.smbc.lad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.ProjectionsComparison;
import com.smbc.lad.dto.pipeline.USRegulatory;
import com.smbc.lad.entity.pipeline.ParentInformationEntity;
import com.smbc.lad.entity.pipeline.ProjectionsComparisonEntity;
import com.smbc.lad.entity.pipeline.USRegulatoryEntity;
import com.smbc.lad.repository.pipeline.ParentInformationRepo;
import com.smbc.lad.repository.pipeline.ProjectionsComparisonRepo;
import com.smbc.lad.repository.pipeline.USRegulatoryRepo;


/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an implementation class for the ProjectionsComparisonService. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
@Service
public class ProjectionsComparisonServiceImpl implements ProjectionsComparisonService {

	@Autowired
	private ProjectionsComparisonRepo projectionsComparisonRepo;
	
	@Autowired
	private USRegulatoryRepo usRegulatoryRepo;
	
	@Autowired
	private ParentInformationRepo parentInformationRepo;
	
	/**
	 * This method is used to get the industry trend details for the given pipeline id
	 */
	public ProjectionsComparison getProjectionsComparison(int pipelineId) {
		
		ProjectionsComparison projectionsComparison = new ProjectionsComparison();
		
		ProjectionsComparisonEntity projectionsComparisonEntity = projectionsComparisonRepo.findByPipelineId(pipelineId);
		ParentInformationEntity parentInformatioEntity = parentInformationRepo.findByPipelineId(pipelineId);
		
		if(projectionsComparisonEntity != null) {
			projectionsComparison.setPipelineId(projectionsComparisonEntity.getPipelineId());
			projectionsComparison.setProjectionsChartDesc(projectionsComparisonEntity.getProjectionsChartDesc());
			projectionsComparison.setRepaymentSource(projectionsComparisonEntity.getRepaymentSource());
			projectionsComparison.setRepaymentCapacity(projectionsComparisonEntity.getRepaymentCapacity());
			projectionsComparison.setUsRegClassification(projectionsComparisonEntity.getUsRegClassification());
		}
		
		if(parentInformatioEntity != null) {
			projectionsComparison.setParentUSRegProposed(parentInformatioEntity.getUsRegProposed());
		}
		
		List<USRegulatory> usRegulatoryList = getUSRegulatoryByPipelineId(pipelineId);
		projectionsComparison.setUsRegulatoryList(usRegulatoryList);
		
		return projectionsComparison;
	}
	
	/**
	 * This method is used to update the industry trend details for the given pipeline id
	 */
	public String updateProjectionsComparisonById(int pipelineId,
			ProjectionsComparison projectionsComparison) throws Exception {
		
		ProjectionsComparisonEntity projectionsComparisonEntity = new ProjectionsComparisonEntity();
		
		projectionsComparisonEntity.setPipelineId(pipelineId);
		projectionsComparisonEntity.setProjectionsChartDesc(projectionsComparison.getProjectionsChartDesc());
		projectionsComparisonEntity.setRepaymentSource(projectionsComparison.getRepaymentSource());
		projectionsComparisonEntity.setRepaymentCapacity(projectionsComparison.getRepaymentCapacity());
		projectionsComparisonEntity.setUsRegClassification(projectionsComparison.getUsRegClassification());
		
		projectionsComparisonRepo.save(projectionsComparisonEntity);
		
		List<USRegulatory> usRegulatoryList = projectionsComparison.getUsRegulatoryList();
		
		updateUSRegulatoryByPipelineId(pipelineId,usRegulatoryList);
		
		return "Success";
	}
	
	/**
	 * This method is used to get the US Regulatory details for the given pipeline id
	 */
	public List<USRegulatory> getUSRegulatoryByPipelineId(int pipelineId) {
		
		List<USRegulatoryEntity> usRregulatoryEntityList = usRegulatoryRepo.findByPipelineId(pipelineId);
		
		List<USRegulatory> usRregulatoryList = new ArrayList<USRegulatory>();
		if(usRregulatoryEntityList != null) {				
			for(USRegulatoryEntity usRegulatoryEntity : usRregulatoryEntityList) {
				USRegulatory usRegulatory = new USRegulatory();
				usRegulatory.setId(usRegulatoryEntity.getId());
				usRegulatory.setPipelineId(usRegulatoryEntity.getPipelineId());
				usRegulatory.setRegulatoryType(usRegulatoryEntity.getRegulatoryType());
				usRegulatory.setRegulatoryDescription(usRegulatoryEntity.getRegulatoryDescription());
				usRegulatory.setRegulatoryThreshold(usRegulatoryEntity.getRegulatoryThreshold());
				usRegulatory.setActualsFYE(usRegulatoryEntity.getActualsFYE());
				usRegulatory.setActualsValue(usRegulatoryEntity.getActualsValue());
				usRegulatory.setComments(usRegulatoryEntity.getComments());
				
				usRregulatoryList.add(usRegulatory);
			}
		}
		
		return usRregulatoryList;
	}
	
	/**
	 * This method is used to update the US Regulatory details for the given pipeline id
	 */
	public String updateUSRegulatoryByPipelineId(int pipelineId,List<USRegulatory> usRregulatoryList) throws Exception {
		
		//Delete All files
		List<USRegulatoryEntity> usRregulatoryEntityList = usRegulatoryRepo.findByPipelineId(pipelineId);
		if(usRregulatoryEntityList != null) {
			usRegulatoryRepo.deleteAll(usRregulatoryEntityList);
		}
		
		//Add all Files
		if(usRregulatoryList != null) {
			for(int i=0; i<usRregulatoryList.size(); i++) {
				USRegulatory usRegulatory = usRregulatoryList.get(i);
				
				USRegulatoryEntity usRegulatoryEntity = new USRegulatoryEntity();
				usRegulatoryEntity.setPipelineId(usRegulatory.getPipelineId());
				usRegulatoryEntity.setRegulatoryType(usRegulatory.getRegulatoryType());
				usRegulatoryEntity.setRegulatoryDescription(usRegulatory.getRegulatoryDescription());
				usRegulatoryEntity.setRegulatoryThreshold(usRegulatory.getRegulatoryThreshold());
				usRegulatoryEntity.setActualsFYE(usRegulatory.getActualsFYE());
				usRegulatoryEntity.setActualsValue(usRegulatory.getActualsValue());
				usRegulatoryEntity.setComments(usRegulatory.getComments());
				
				usRegulatoryRepo.save(usRegulatoryEntity);
			}
		}

		return "Success";
	}

}
