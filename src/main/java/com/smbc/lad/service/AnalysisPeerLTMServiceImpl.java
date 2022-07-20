package com.smbc.lad.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.AnalysisPeerLTM;
import com.smbc.lad.dto.pipeline.FileData;
import com.smbc.lad.entity.pipeline.AnalysisPeerFilesLTMEntity;
import com.smbc.lad.entity.pipeline.AnalysisPeerLTMEntity;
import com.smbc.lad.repository.pipeline.AnalysisPeerFilesLTMRepo;
import com.smbc.lad.repository.pipeline.AnalysisPeerLTMRepo;
import com.smbc.lad.utils.LADUtils;


/**
 * @author Saravanan T
 * @since May 2022
 * 
 * This is an implementation class for the AnalysisPeerLTMServiceImpl. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
/**
 * @author ansibleuser
 *
 */
/**
 * @author ansibleuser
 *
 */
@Service
public class AnalysisPeerLTMServiceImpl implements AnalysisPeerLTMService {

	@Autowired
	private AnalysisPeerLTMRepo analysisPeerLTMRepo;
	
	@Autowired
	private AnalysisPeerFilesLTMRepo analysisPeerFilesLTMRepo;
	
	/**
	 * This method is used to get the industry trend details for the given pipeline id
	 */
	public AnalysisPeerLTM getAnalysisPeerLTM(int pipelineId) {
		
		AnalysisPeerLTM analysisPeerLTM = new AnalysisPeerLTM();
		
		AnalysisPeerLTMEntity analysisPeerLTMEntity = analysisPeerLTMRepo.findByPipelineId(pipelineId);
		
		if(analysisPeerLTMEntity != null) {
			analysisPeerLTM.setPipelineId(analysisPeerLTMEntity.getPipelineId());
			analysisPeerLTM.setPeerAnalysis(analysisPeerLTMEntity.getPeerAnalysis());
			analysisPeerLTM.setLongTermAnalysis(analysisPeerLTMEntity.getLongTermAnalysis());
			analysisPeerLTM.setAnalysisComparison(analysisPeerLTMEntity.getAnalysisComparison());
			
			List<FileData> fileDataCollection = new ArrayList<FileData>();
			if(analysisPeerLTMEntity.getAnalysisPeerFilesLTMEntity() != null) {				
				for(AnalysisPeerFilesLTMEntity analysisFileEntity : analysisPeerLTMEntity.getAnalysisPeerFilesLTMEntity()) {
					FileData fileData = new FileData();
					fileData.setId(analysisFileEntity.getId());
					fileData.setPipelineId(analysisFileEntity.getPipelineId());
					fileData.setFileName(analysisFileEntity.getFileName());
					fileData.setFileType(analysisFileEntity.getFileType());
					fileData.setFileExtension(analysisFileEntity.getFileExtension());
					fileData.setFileData(analysisFileEntity.getFileData());
					fileData.setCreatedTimestamp(
							LADUtils.formatDatetoTimestamp(analysisFileEntity.getCreatedDate()));
					fileDataCollection.add(fileData);
				}
			}
			analysisPeerLTM.setFileData(fileDataCollection);
		}
		
		return analysisPeerLTM;
	}
	
	/**
	 * This method is used to update the industry trend details for the given pipeline id
	 */
	public String updateAnalysisPeerLTMById(int pipelineId,
			AnalysisPeerLTM analysisPeerLTM) throws Exception {
		
		AnalysisPeerLTMEntity analysisPeerLTMEntity = new AnalysisPeerLTMEntity();
		
		analysisPeerLTMEntity.setPipelineId(pipelineId);
		analysisPeerLTMEntity.setPeerAnalysis(analysisPeerLTM.getPeerAnalysis());
		analysisPeerLTMEntity.setLongTermAnalysis(analysisPeerLTM.getLongTermAnalysis());
		analysisPeerLTMEntity.setAnalysisComparison(analysisPeerLTM.getAnalysisComparison());

		analysisPeerLTMRepo.save(analysisPeerLTMEntity);
		
		//Upload Files
		List<FileData> filestoUpload = analysisPeerLTM.getFileData();
		if(filestoUpload != null) {
			for(int i=0; i<filestoUpload.size(); i++) {
				FileData file = filestoUpload.get(i);
				
				if(!LADUtils.checkNullorEmpty(file.getFileName())) {
					AnalysisPeerFilesLTMEntity analysisPeerFilesLTMEntity = new AnalysisPeerFilesLTMEntity();
					analysisPeerFilesLTMEntity.setPipelineId(pipelineId);
					analysisPeerFilesLTMEntity.setFileName(file.getFileName());
					analysisPeerFilesLTMEntity.setFileType(file.getFileType());
					analysisPeerFilesLTMEntity.setFileExtension(file.getFileExtension());
					if(file.getFileBase64Data() != null) {
						byte[] fileByte = Base64.getDecoder().decode(file.getFileBase64Data());
						analysisPeerFilesLTMEntity.setFileData(fileByte);
					}
					analysisPeerFilesLTMRepo.save(analysisPeerFilesLTMEntity);
				}
			}
		}
		
		//Delete Files
		if(analysisPeerLTM.getFilesToDeleteIds() != null) {
			int[] filesToDelete = analysisPeerLTM.getFilesToDeleteIds();
			for (int i=0; i<filesToDelete.length;i++) {
				deleteAnalysisPeerFilesLTM(filesToDelete[i]);
			}
		}
				
		return "Success";
	}
	
	/**
	 * This method is used to download the file for the given id
	 */
	public FileData getAnalysisPeerFilesLTM(int id) {
		
		AnalysisPeerFilesLTMEntity analysisPeerFilesLTMEntity = analysisPeerFilesLTMRepo.findById(id);
		FileData fileData = new FileData();
		if(analysisPeerFilesLTMEntity != null) {
			fileData.setId(analysisPeerFilesLTMEntity.getId());
			fileData.setPipelineId(analysisPeerFilesLTMEntity.getPipelineId());
			fileData.setFileName(analysisPeerFilesLTMEntity.getFileName());
			fileData.setFileType(analysisPeerFilesLTMEntity.getFileType());
			fileData.setFileData(analysisPeerFilesLTMEntity.getFileData());
			fileData.setCreatedTimestamp(
					LADUtils.formatDatetoTimestamp(analysisPeerFilesLTMEntity.getCreatedDate()));
		}
		
		return fileData;
	}
	
	/**
	 * This method is used to delete the file for the given id
	 */
	public String deleteAnalysisPeerFilesLTM(int id) {
		AnalysisPeerFilesLTMEntity analysisPeerFilesLTMEntity = analysisPeerFilesLTMRepo.findById(id);
		if(analysisPeerFilesLTMEntity != null) {
			analysisPeerFilesLTMRepo.delete(analysisPeerFilesLTMEntity);
		}
		return "Success";
	}
}
