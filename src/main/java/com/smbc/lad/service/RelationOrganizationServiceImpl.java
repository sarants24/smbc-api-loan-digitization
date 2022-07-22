package com.smbc.lad.service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.FileData;
import com.smbc.lad.dto.pipeline.RelationOrganization;
import com.smbc.lad.entity.pipeline.FileDataEntity;
import com.smbc.lad.entity.pipeline.RelationOrganizationEntity;
import com.smbc.lad.repository.pipeline.FileDataRepo;
import com.smbc.lad.repository.pipeline.RelationOrganizationRepo;
import com.smbc.lad.utils.LADUtils;


/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an implementation class for the RelationOrganizationService. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
@Service
public class RelationOrganizationServiceImpl implements RelationOrganizationService {

	@Autowired
	private RelationOrganizationRepo relationOrganizationRepo;
	
	@Autowired
	private FileDataRepo fileDataRepo;
	
	/**
	 * This method is used to get the relationship and organization details for the given pipeline id
	 */
	public RelationOrganization getRelationOrganization(int pipelineId) {
		
		RelationOrganization relationOrganization = new RelationOrganization();
		
		RelationOrganizationEntity relationOrganizationEntity = relationOrganizationRepo.findByPipelineId(pipelineId);
		
		if(relationOrganizationEntity != null) {
			relationOrganization.setPipelineId(relationOrganizationEntity.getPipelineId());
			relationOrganization.setRelationSummary(relationOrganizationEntity.getRelationshipSummary());
			relationOrganization.setOrganizationSummary(relationOrganizationEntity.getOrganizationSummary());
			
			List<FileData> fileDataCollection = new ArrayList<FileData>();
			if(relationOrganizationEntity.getFileDataEntity() != null) {				
				for(FileDataEntity fileDataEntity : relationOrganizationEntity.getFileDataEntity()) {
					FileData fileData = new FileData();
					fileData.setId(fileDataEntity.getId());
					fileData.setPipelineId(fileDataEntity.getPipelineId());
					fileData.setFileName(fileDataEntity.getFileName());
					fileData.setFileType(fileDataEntity.getFileType());
					fileData.setFileExtension(fileDataEntity.getFileExtension());
					fileData.setFileExtensionMetadata(fileDataEntity.getFileExtensionMetadata());
					fileData.setFileData(fileDataEntity.getFileData());
					fileData.setCreatedTimestamp(
							LADUtils.formatDatetoTimestamp(fileDataEntity.getCreatedDate()));
					fileDataCollection.add(fileData);
				}
			}
			
			relationOrganization.setFileData(fileDataCollection);
		}
		
		return relationOrganization;
	}
	
	/**
	 * This method is used to update the relationship and organization details for the given pipeline id
	 */
	public String updateRelationOrganizationById(int pipelineId,RelationOrganization relationOrganization) throws Exception {
		
		RelationOrganizationEntity relationOrganizationEntity = new RelationOrganizationEntity();
		relationOrganizationEntity.setPipelineId(pipelineId);
		relationOrganizationEntity.setRelationshipSummary(relationOrganization.getRelationSummary());
		relationOrganizationEntity.setOrganizationSummary(relationOrganization.getOrganizationSummary());
		relationOrganizationRepo.save(relationOrganizationEntity);
		
		//Upload Files
		List<FileData> filestoUpload = relationOrganization.getFileData();
		if(filestoUpload != null) {
			for(int i=0; i<filestoUpload.size(); i++) {
				FileData file = filestoUpload.get(i);
				
				if(!LADUtils.checkNullorEmpty(file.getFileName())) {
					FileDataEntity fileDataEntity = new FileDataEntity();
					fileDataEntity.setPipelineId(pipelineId);
					fileDataEntity.setFileName(file.getFileName());
					fileDataEntity.setFileType(file.getFileType());
					fileDataEntity.setFileExtension(file.getFileExtension());
					fileDataEntity.setFileExtensionMetadata(file.getFileExtensionMetadata());
					if(file.getFileBase64Data() != null) {
						byte[] fileByte = Base64.getDecoder().decode(file.getFileBase64Data());
						fileDataEntity.setFileData(fileByte);
					}
					fileDataRepo.save(fileDataEntity);
				}
			}
		}
		
		//Delete Files
		if(relationOrganization.getFilesToDeleteIds() != null) {
			int[] filesToDelete = relationOrganization.getFilesToDeleteIds();
			for (int i=0; i<filesToDelete.length;i++) {
				deleteFileData(filesToDelete[i]);
			}
		}
		return "Success";
	}
	
	/**
	 * This method is used to download the file for the given id
	 */
	public FileData getFileData(int id) {
		
		FileDataEntity fileDataEntity = fileDataRepo.findById(id);
		FileData fileData = new FileData();
		if(fileDataEntity != null) {
			fileData.setId(fileDataEntity.getId());
			fileData.setPipelineId(fileDataEntity.getPipelineId());
			fileData.setFileName(fileDataEntity.getFileName());
			fileData.setFileType(fileDataEntity.getFileType());
			fileData.setFileExtension(fileDataEntity.getFileExtension());
			fileData.setFileExtensionMetadata(fileDataEntity.getFileExtensionMetadata());
			fileData.setFileData(fileDataEntity.getFileData());
			fileData.setCreatedTimestamp(
					LADUtils.formatDatetoTimestamp(fileDataEntity.getCreatedDate()));
			  String s = new String(fileDataEntity.getFileData(), StandardCharsets.UTF_8);
		}
		
		return fileData;
	}
	
	/**
	 * This method is used to delete the file for the given id
	 */
	public String deleteFileData(int id) {
		FileDataEntity fileDataEntity = fileDataRepo.findById(id);
		if(fileDataEntity != null) {
			fileDataRepo.delete(fileDataEntity);
		}
		return "Success";
	}
	
}
