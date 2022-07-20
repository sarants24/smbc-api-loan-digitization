package com.smbc.lad.service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.FileData;
import com.smbc.lad.dto.pipeline.TransactionBackground;
import com.smbc.lad.entity.pipeline.TransactionBackgroundEntity;
import com.smbc.lad.entity.pipeline.TransactionFilesEntity;
import com.smbc.lad.repository.pipeline.TransactionBackgroundRepo;
import com.smbc.lad.repository.pipeline.TransactionFilesRepo;
import com.smbc.lad.utils.LADUtils;


/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an implementation class for the Transaction Background Service. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
@Service
public class TransactionBackgroundServiceImpl implements TransactionBackgroundService {

	@Autowired
	private TransactionBackgroundRepo transactionBackgroundRepo;
	
	@Autowired
	private TransactionFilesRepo transactionFileRepo;
	
	/**
	 * This method is used to get the transaction background details for the given pipeline id
	 */
	public TransactionBackground getTransactionBackground(int pipelineId) {
		
		TransactionBackground transactionBackground = new TransactionBackground();
		
		TransactionBackgroundEntity transBackgroundEntity = transactionBackgroundRepo.findByPipelineId(pipelineId);
		
		if(transBackgroundEntity != null) {
			transactionBackground.setPipelineId(transBackgroundEntity.getPipelineId());
			transactionBackground.setTransactionPurpose(transBackgroundEntity.getTransactionPurpose());
			transactionBackground.setTransactionSources(transBackgroundEntity.getTransactionSources());
			transactionBackground.setTransactionProforma(transBackgroundEntity.getTransactionProforma());
			transactionBackground.setTransactionMergerAcq(transBackgroundEntity.getTransactionMergerAcq());
			transactionBackground.setTransactionPriceAnalysis(transBackgroundEntity.getTransactionPriceAnalysis());
			transactionBackground.setGlobalFacilityCurrent(transBackgroundEntity.getGlobalFacilityCurrent());
			transactionBackground.setGlobalFacilityProposed(transBackgroundEntity.getGlobalFacilityProposed());
			transactionBackground.setGlobalFacilityCi(transBackgroundEntity.getGlobalFacilityCi());
			transactionBackground.setSmbcAmountCurrent(transBackgroundEntity.getSmbcAmountCurrent());
			transactionBackground.setSmbcAmountProposed(transBackgroundEntity.getSmbcAmountProposed());
			transactionBackground.setSmbcAmountCi(transBackgroundEntity.getSmbcAmountCi());
			transactionBackground.setMaturityCurrent(transBackgroundEntity.getMaturityCurrent());
			transactionBackground.setMaturityProposed(transBackgroundEntity.getMaturityProposed());
			transactionBackground.setMaturityCi(transBackgroundEntity.getMaturityCi());
			transactionBackground.setFinancialCovenantsCurrent(transBackgroundEntity.getFinancialCovenantsCurrent());
			transactionBackground.setFinancialCovenantsProposed(transBackgroundEntity.getFinancialCovenantsProposed());
			transactionBackground.setFinancialCovenantsCi(transBackgroundEntity.getFinancialCovenantsCi());
			transactionBackground.setUnderwritingExposure(transBackgroundEntity.getUnderwritingExposure());
			transactionBackground.setCollateralValuation(transBackgroundEntity.getCollateralValuation());

			
			List<FileData> fileDataCollection = new ArrayList<FileData>();
			if(transBackgroundEntity.getTransactionFilesEntity() != null) {				
				for(TransactionFilesEntity transFileEntity : transBackgroundEntity.getTransactionFilesEntity()) {
					FileData fileData = new FileData();
					fileData.setId(transFileEntity.getId());
					fileData.setPipelineId(transFileEntity.getPipelineId());
					fileData.setFileName(transFileEntity.getFileName());
					fileData.setFileType(transFileEntity.getFileType());
					fileData.setFileExtension(transFileEntity.getFileExtension());
					fileData.setFileData(transFileEntity.getFileData());
					fileData.setCreatedTimestamp(
							LADUtils.formatDatetoTimestamp(transFileEntity.getCreatedDate()));
					fileDataCollection.add(fileData);
				}
			}
			
			transactionBackground.setFileData(fileDataCollection);
		}
		
		return transactionBackground;
	}
	
	/**
	 * This method is used to update the transaction background details for the given pipeline id
	 */
	public String updateTransactionBackgroundById(int pipelineId,
				TransactionBackground transactionBackground) throws Exception {
		
		TransactionBackgroundEntity transBackgroundEntity = new TransactionBackgroundEntity();
		transBackgroundEntity.setPipelineId(pipelineId);
		transBackgroundEntity.setTransactionPurpose(transactionBackground.getTransactionPurpose());
		transBackgroundEntity.setTransactionSources(transactionBackground.getTransactionSources());
		transBackgroundEntity.setTransactionProforma(transactionBackground.getTransactionProforma());
		transBackgroundEntity.setTransactionMergerAcq(transactionBackground.getTransactionMergerAcq());
		transBackgroundEntity.setTransactionPriceAnalysis(transactionBackground.getTransactionPriceAnalysis());
		transBackgroundEntity.setGlobalFacilityCurrent(transactionBackground.getGlobalFacilityCurrent());
		transBackgroundEntity.setGlobalFacilityProposed(transactionBackground.getGlobalFacilityProposed());
		transBackgroundEntity.setGlobalFacilityCi(transactionBackground.getGlobalFacilityCi());
		transBackgroundEntity.setSmbcAmountCurrent(transactionBackground.getSmbcAmountCurrent());
		transBackgroundEntity.setSmbcAmountProposed(transactionBackground.getSmbcAmountProposed());
		transBackgroundEntity.setSmbcAmountCi(transactionBackground.getSmbcAmountCi());
		transBackgroundEntity.setMaturityCurrent(transactionBackground.getMaturityCurrent());
		transBackgroundEntity.setMaturityProposed(transactionBackground.getMaturityProposed());
		transBackgroundEntity.setMaturityCi(transactionBackground.getMaturityCi());
		transBackgroundEntity.setFinancialCovenantsCurrent(transactionBackground.getFinancialCovenantsCurrent());
		transBackgroundEntity.setFinancialCovenantsProposed(transactionBackground.getFinancialCovenantsProposed());
		transBackgroundEntity.setFinancialCovenantsCi(transactionBackground.getFinancialCovenantsCi());
		transBackgroundEntity.setUnderwritingExposure(transactionBackground.getUnderwritingExposure());
		transBackgroundEntity.setCollateralValuation(transactionBackground.getCollateralValuation());

		transactionBackgroundRepo.save(transBackgroundEntity);
		
		//Upload Files
		//Upload Files
		List<FileData> filestoUpload = transactionBackground.getFileData();
		if(filestoUpload != null) {
			for(int i=0; i<filestoUpload.size(); i++) {
				FileData file = filestoUpload.get(i);
				
				if(!LADUtils.checkNullorEmpty(file.getFileName())) {
					TransactionFilesEntity transactionFilesEntity = new TransactionFilesEntity();
					transactionFilesEntity.setPipelineId(pipelineId);
					transactionFilesEntity.setFileName(file.getFileName());
					transactionFilesEntity.setFileType(file.getFileType());
					transactionFilesEntity.setFileExtension(file.getFileExtension());
					if(file.getFileBase64Data() != null) {
						byte[] fileByte = Base64.getDecoder().decode(file.getFileBase64Data());
						transactionFilesEntity.setFileData(fileByte);
					}
					transactionFileRepo.save(transactionFilesEntity);
				}
			}
		}
		
		//Delete Files
		if(transactionBackground.getFilesToDeleteIds() != null) {
			int[] filesToDelete = transactionBackground.getFilesToDeleteIds();
			for (int i=0; i<filesToDelete.length;i++) {
				deleteTransactionBackgroundFiles(filesToDelete[i]);
			}
		}
		return "Success";
	}
	
	public FileData getTransactionBackgroundFiles(int id) {
		
		TransactionFilesEntity transactionFilesEntity = transactionFileRepo.findById(id);
		FileData fileData = new FileData();
		if(transactionFilesEntity != null) {
			fileData.setId(transactionFilesEntity.getId());
			fileData.setPipelineId(transactionFilesEntity.getPipelineId());
			fileData.setFileType(transactionFilesEntity.getFileType());
			fileData.setFileData(transactionFilesEntity.getFileData());
			
			  String s = new String(transactionFilesEntity.getFileData(), StandardCharsets.UTF_8);
			  System.out.println("File ..." + s);
		}
		
		return fileData;
	}
	
	public String deleteTransactionBackgroundFiles(int id) {
		TransactionFilesEntity transactionFilesEntity = transactionFileRepo.findById(id);
		if(transactionFilesEntity != null) {
			transactionFileRepo.delete(transactionFilesEntity);
		}
		return "Success";
	}
	
}
