package com.smbc.lad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.pipeline.BorrowerInformation;
import com.smbc.lad.entity.pipeline.AdditionalBorrowerInfoEntity;
import com.smbc.lad.entity.pipeline.BorrowerInfoBaseEntity;
import com.smbc.lad.entity.pipeline.BorrowerInformationEntity;
import com.smbc.lad.entity.pipeline.PipelineDealsCreditEntity;
import com.smbc.lad.entity.pipeline.PipelineDealsEntity;
import com.smbc.lad.exception.SMBCBusinessException;
import com.smbc.lad.exception.SMBCResourceNotFoundException;
import com.smbc.lad.repository.pipeline.AdditionalBorrowerInfoRepo;
import com.smbc.lad.repository.pipeline.BorrowerInformationRepo;
import com.smbc.lad.utils.LADUtils;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an implementation class for the Borrower info  entities. 
 * This class is used to fetch data from tables and populates the values into DTO 
 * (data transfer object) and also used to update the entities as well.
 *
 */
@Service
public class BorrowerServiceImpl implements BorrowerService {

	@Autowired
	private PipelineDealsService pipelineDealsService;
	
	@Autowired
	private BorrowerInformationRepo borrowerInformationRepo;
	
	@Autowired
	private AdditionalBorrowerInfoRepo additionalBorrowerInfoRepo;
	
	/**
	 * This method is used to get the Primary Borrower info for the given pipeline Id
	 */
	public BorrowerInformation getBorrowerInfoById(int pipelineId) {
		
		PipelineDealsEntity pipelineDealsEntity = pipelineDealsService.getPipelineDealsEntity(pipelineId);
		PipelineDealsCreditEntity pipelineDealsCreditEntity = pipelineDealsService.getPipelineDealsCreditEntity(pipelineId);
		
		BorrowerInformationEntity borrowerInformationEntity = 
				borrowerInformationRepo.findByPipelineId(pipelineId);
		
		BorrowerInformation borrowerInformation = new BorrowerInformation();
		
		if (borrowerInformationEntity != null) {
			borrowerInformation = setBorrowerBaseInfoDetails(borrowerInformationEntity);
		}
		borrowerInformation.setPipelineId(pipelineId);
		
		//From Pipeline Deals
		if(pipelineDealsEntity != null) {
			borrowerInformation.setBorrowerName(pipelineDealsEntity.getBorrowerName());
		}
		
		if (pipelineDealsCreditEntity != null) {
			borrowerInformation.setSnpRating(pipelineDealsCreditEntity.getSnpRating());
			if(pipelineDealsCreditEntity.getsNPRatingEntity() != null) {
				borrowerInformation.setSnpRatingLabel(
						pipelineDealsCreditEntity.getsNPRatingEntity().getDescription());
			}
			
			borrowerInformation.setSnpOutlook(pipelineDealsCreditEntity.getSnpOutlook());
			if(pipelineDealsCreditEntity.getsNPOutlookEntity() != null) {
				borrowerInformation.setSnpOutlookLabel(
						pipelineDealsCreditEntity.getsNPOutlookEntity().getDescription());
			}
			
			borrowerInformation.setMoodyRating(pipelineDealsCreditEntity.getMoodyRating());
			if(pipelineDealsCreditEntity.getMoodysRatingEntity() != null) {
				borrowerInformation.setMoodyRatingLabel(
						pipelineDealsCreditEntity.getMoodysRatingEntity().getDescription());
			}
			
			borrowerInformation.setMoodyOutlook(pipelineDealsCreditEntity.getMoodyOutlook());
			if(pipelineDealsCreditEntity.getMoodysOutlookEntity() != null) {
				borrowerInformation.setMoodyOutlookLabel(
						pipelineDealsCreditEntity.getMoodysOutlookEntity().getDescription());
			}
		}
		
		return borrowerInformation;
	}
	
	/**
	 * This method is used to update the Primary Borrower info for the given pipeline Id
	 */
	public String updateBorrowerInfoById(int pipelineId,BorrowerInformation borrowerInformation) 
															throws Exception {
		
		PipelineDealsCreditEntity pipelineDealsCreditEntity = pipelineDealsService.getPipelineDealsCreditEntity(pipelineId);
		
		BorrowerInformationEntity borrowerInformationEntity = 
										borrowerInformationRepo.findByPipelineId(pipelineId);
		
		if(borrowerInformationEntity == null) {
			borrowerInformationEntity= new BorrowerInformationEntity();
			borrowerInformationEntity.setPipelineId(pipelineId);
			borrowerInformationEntity.setSunId(pipelineDealsCreditEntity.getSunId());
		}
		
		setBorrowerBaseEntity(borrowerInformationEntity,borrowerInformation);
		borrowerInformationRepo.save(borrowerInformationEntity);
		
		if(pipelineDealsCreditEntity != null) {
			if(!LADUtils.checkNullorEmpty(borrowerInformation.getSnpRating())) {
				pipelineDealsCreditEntity.setSnpRating(borrowerInformation.getSnpRating());
			}
			if(!LADUtils.checkNullorEmpty(borrowerInformation.getMoodyRating())) {
				pipelineDealsCreditEntity.setMoodyRating(borrowerInformation.getMoodyRating());
			}
			if(!LADUtils.checkNullorEmpty(borrowerInformation.getSnpOutlook())) {
				pipelineDealsCreditEntity.setSnpOutlook(borrowerInformation.getSnpOutlook());
			}
			if(!LADUtils.checkNullorEmpty(borrowerInformation.getMoodyOutlook())) {
				pipelineDealsCreditEntity.setMoodyOutlook(borrowerInformation.getMoodyOutlook());
			}		
			pipelineDealsService.savePipelineDealsCreditEntity(pipelineDealsCreditEntity);
		}
		
		return "Success";
	}
	
	/**
	 * This method is used to get the List of Additional Borrower info for the given pipeline Id
	 */
	public List<BorrowerInformation> getAddtlBorrowerInfoByPipelineId(int pipelineId) throws Exception{
		
		//int applicationNumber = getApplicationNumber(pipelineId);
		
		List<AdditionalBorrowerInfoEntity> additionalBorrowerInfoEntityList = 
						additionalBorrowerInfoRepo.findByPipelineId(pipelineId);
		
		List<BorrowerInformation> borrwerInfoCollection = new ArrayList<BorrowerInformation>();
		
		if(additionalBorrowerInfoEntityList != null) {
			for(AdditionalBorrowerInfoEntity additionalBorrowerInfoEntity : additionalBorrowerInfoEntityList) {
				
				BorrowerInformation borrowerInformation = 
						setAdditionalBorrowerInfoDetails(additionalBorrowerInfoEntity);
				
				//setAdditionalBorrowerRatings(additionalBorrowerInfoEntity,borrowerInformation);
				borrowerInformation.setSmunId(additionalBorrowerInfoEntity.getSmunId());
				borrowerInformation.setPipelineId(pipelineId);
				borrowerInformation.setAdditionalBorrowerId(
									additionalBorrowerInfoEntity.getAddtionalBorrowerId());
				borrwerInfoCollection.add(borrowerInformation);
			}
		}
		
		return borrwerInfoCollection;
	}
	
	/**
	 * This method is used to get the Additional Borrower info for the given Additional Borrower Id
	 */
	public BorrowerInformation getAddtlBorrowerInfoByBorrowerId(int addtionalBorrowerId) {
		
		BorrowerInformation borrowerInformation = new BorrowerInformation();
		
		AdditionalBorrowerInfoEntity additionalBorrowerInfoEntity = 
								getAdditionalBorrowerInfoEntity(addtionalBorrowerId);
		
		if(additionalBorrowerInfoEntity != null) {
			borrowerInformation = setAdditionalBorrowerInfoDetails(additionalBorrowerInfoEntity);
			//setAdditionalBorrowerRatings(additionalBorrowerInfoEntity,borrowerInformation);
			borrowerInformation.setSmunId(additionalBorrowerInfoEntity.getSmunId());
			borrowerInformation.setPipelineId(additionalBorrowerInfoEntity.getPipelineId());
			borrowerInformation.setAdditionalBorrowerId(addtionalBorrowerId);
		}
		
		return borrowerInformation;
	}
	
	/**
	 * This method is used to add the Additional Borrower info for the given Additional Borrower Id
	 */
	public String addAdditinalBorrowerInfoById(int pipelineId,BorrowerInformation borrowerInformation) throws Exception {
		
		validateBorrowerDuplicate(borrowerInformation.getSmunId(),borrowerInformation.getPipelineId());
		
		AdditionalBorrowerInfoEntity additionalBorrowerInfoEntity = new AdditionalBorrowerInfoEntity();
		saveAddtionalBorrowerInfo(additionalBorrowerInfoEntity,borrowerInformation);
		
		return "Success";
	}
	
	/**
	 * This method is used to update the Additional Borrower info for the given Additional Borrower Id
	 */
	public String updateAdditinalBorrowerInfoById(int addtionalBorrowerId,BorrowerInformation borrowerInformation) throws Exception {
		
		AdditionalBorrowerInfoEntity additionalBorrowerInfoEntity = 
							getAdditionalBorrowerInfoEntity(addtionalBorrowerId);
		
		String oldSmunId = additionalBorrowerInfoEntity.getSmunId();
		String newSmunId = borrowerInformation.getSmunId();
		
		if(!oldSmunId.equals(newSmunId)) {
			validateBorrowerDuplicate(borrowerInformation.getSmunId(),borrowerInformation.getPipelineId());
		}
		
		saveAddtionalBorrowerInfo(additionalBorrowerInfoEntity,borrowerInformation);
		
		return "Success";
	}
	
	private String saveAddtionalBorrowerInfo(AdditionalBorrowerInfoEntity additionalBorrowerInfoEntity,
			BorrowerInformation borrowerInformation) throws Exception {
		
		additionalBorrowerInfoEntity.setPipelineId(borrowerInformation.getPipelineId());
		additionalBorrowerInfoEntity.setSmunId(borrowerInformation.getSmunId());
		
		setBorrowerBaseEntity(additionalBorrowerInfoEntity,borrowerInformation);
		
		if(!LADUtils.checkNullorEmpty(borrowerInformation.getSnpRating())) {
			additionalBorrowerInfoEntity.setSnpRating(borrowerInformation.getSnpRating());
		}
		
		if(!LADUtils.checkNullorEmpty(borrowerInformation.getMoodyRating())) {
			additionalBorrowerInfoEntity.setMoodyRating(borrowerInformation.getMoodyRating());
		}
		
		if(!LADUtils.checkNullorEmpty(borrowerInformation.getSnpOutlook())) {
			additionalBorrowerInfoEntity.setSnpOutlook(borrowerInformation.getSnpOutlook());
		}
		
		if(!LADUtils.checkNullorEmpty(borrowerInformation.getMoodyOutlook())) {
			additionalBorrowerInfoEntity.setMoodyOutlook(borrowerInformation.getMoodyOutlook());
		}

		additionalBorrowerInfoRepo.save(additionalBorrowerInfoEntity);
		
		return "Success";
	}
	
	/**
	 * This method is used to delete the Additional Borrower info for the given Additional Borrower Id
	 */
	public String deleteAdditinalBorrowerInfoById(int addtionalBorrowerId) throws Exception {
		
		AdditionalBorrowerInfoEntity additionalBorrowerInfoEntity = 
									getAdditionalBorrowerInfoEntity(addtionalBorrowerId);
		
		additionalBorrowerInfoRepo.delete(additionalBorrowerInfoEntity);
		
		return "sucess";  
	}
	
	
	/**
	 * This method is used to get the AdditionalBorrowerInfoEntity of the given additioanl borrower id
	 * @param pipelineId
	 * @return
	 */
	private AdditionalBorrowerInfoEntity getAdditionalBorrowerInfoEntity(int addtionalBorrowerId) {
		AdditionalBorrowerInfoEntity additionalBorrowerInfoEntity = additionalBorrowerInfoRepo.findByAddtionalBorrowerId(addtionalBorrowerId);
		
		if(additionalBorrowerInfoEntity == null) {
			throw new SMBCResourceNotFoundException("Additional Borrower details not found for the additional borrower id " + addtionalBorrowerId);
		}
		
		return additionalBorrowerInfoEntity;
	}
	
	/**
	 * This method is used to validate the duplicate borrower id
	 */
	private void validateBorrowerDuplicate(String smunId,int pipelineId) {
		
		if(LADUtils.checkNullorEmpty(smunId)) {
			throw new SMBCBusinessException("Please select Borrower Name");
		}
		
		List<String> checkBorrowerName = 
				additionalBorrowerInfoRepo.getSmunId(pipelineId);
		
		if(checkBorrowerName != null && checkBorrowerName.contains(smunId)) {
			throw new SMBCBusinessException("The given borrower name " + smunId + " already exists");
		}
	}
	
	//Common Methods
	/**
	 * This method is used to set the BorrowerInfo from Entity
	 */
	private BorrowerInformation setBorrowerBaseInfoDetails
								(BorrowerInfoBaseEntity borrowerInformationEntity) {
		
		BorrowerInformation borrowerInformation = new BorrowerInformation();
		
		borrowerInformation.setSunId(borrowerInformationEntity.getSunId());
		borrowerInformation.setSmunId(borrowerInformationEntity.getSmunId());
		borrowerInformation.setPrimarySmics(borrowerInformationEntity.getPrimarySmics());
		
		borrowerInformation.setSmbcRatingCredit(borrowerInformationEntity.getSmbcRatingCredit());
		if (borrowerInformationEntity.getSmbcRatingCurrentEntity() != null) {
			borrowerInformation.setSmbcRatingCreditLabel(
					borrowerInformationEntity.getSmbcRatingCurrentEntity().getDescription());
		}
	
		borrowerInformation.setSmbcRatingProposed(borrowerInformationEntity.getSmbcRatingProposed());
		if (borrowerInformationEntity.getSmbcRatingProposedEntity() != null) {
			borrowerInformation.setSmbcRatingProposedLabel(
					borrowerInformationEntity.getSmbcRatingProposedEntity().getDescription());
		}
		
		borrowerInformation.setLeverageLendCurrent(borrowerInformationEntity.getLeverageLendCurrent());
		borrowerInformation.setLeverageLendProposed(borrowerInformationEntity.getLeverageLendProposed());
		borrowerInformation.setMarketCapitalization(borrowerInformationEntity.getMarketCapitalization());
		
		borrowerInformation.setUsRegCurrent(borrowerInformationEntity.getUsRegCurrent());
		if(borrowerInformationEntity.getUsRegCurrentEntity() != null) {
			borrowerInformation.setUsRegCurrentLabel(
					borrowerInformationEntity.getUsRegCurrentEntity().getDescription());
		}
		
		borrowerInformation.setUsRegCurrentDate(
				LADUtils.formatDatetoString(borrowerInformationEntity.getUsRegCurrentDate()));
		borrowerInformation.setUsRegProposed(borrowerInformationEntity.getUsRegProposed());
		
		if(borrowerInformationEntity.getUsRegProposedEntity() != null) {
			borrowerInformation.setUsRegProposedLabel(
					borrowerInformationEntity.getUsRegProposedEntity().getDescription());
		}
		
		borrowerInformation.setReadBySnc(borrowerInformationEntity.getReadBySnc());
		borrowerInformation.setReadBySncDate(
				LADUtils.formatDatetoString(borrowerInformationEntity.getReadBySncDate()));
		
		borrowerInformation.setSncRating(borrowerInformationEntity.getSncRating());
		borrowerInformation.setSncRatingFacility(borrowerInformationEntity.getSncRatingFacility());
		
		if(borrowerInformationEntity.getSncRatingEntity() != null) {
			borrowerInformation.setSncRatingLabel(
					borrowerInformationEntity.getSncRatingEntity().getDescription());
		}
		
		borrowerInformation.setDesignatedByDirector(
				borrowerInformationEntity.getDesignatedByDirector());
		
		borrowerInformation.setNaturalResSector(borrowerInformationEntity.getNaturalResSector());
		borrowerInformation.setEsgRisk(borrowerInformationEntity.getEsgRisk());
		borrowerInformation.setMonitoredSector(borrowerInformationEntity.getMonitoredSector());
		borrowerInformation.setPassWatchCurrent(borrowerInformationEntity.getPassWatchCurrent());
		borrowerInformation.setPassWatchCurrentDate(
				LADUtils.formatDatetoString(borrowerInformationEntity.getPassWatchCurrentDate()));
		borrowerInformation.setPassWatchProposed(borrowerInformationEntity.getPassWatchProposed());
		borrowerInformation.setWarningCurrent(borrowerInformationEntity.getWarningCurrent());
		borrowerInformation.setWarningCurrentDate(
				LADUtils.formatDatetoString(borrowerInformationEntity.getWarningCurrentDate()));
		borrowerInformation.setWarningProposed(borrowerInformationEntity.getWarningProposed());
		borrowerInformation.setBiNotes(borrowerInformationEntity.getBiNotes());
		
		return borrowerInformation;		
	}
	

	/**
	 * This method is used to set the Additional BorrowerInfo from Entity
	 */
	private BorrowerInformation setAdditionalBorrowerInfoDetails
							(AdditionalBorrowerInfoEntity additionalBorrowerInfoEntity) {
		
		BorrowerInformation borrowerInformation = setBorrowerBaseInfoDetails(additionalBorrowerInfoEntity);
		
		borrowerInformation.setSmunId(additionalBorrowerInfoEntity.getSmunId());
		if(additionalBorrowerInfoEntity.getCompanyEntity() != null) {
			borrowerInformation.setBorrowerName(
					additionalBorrowerInfoEntity.getCompanyEntity().getCompanyName());
		}
		
		borrowerInformation.setSnpRating(additionalBorrowerInfoEntity.getSnpRating());
		if(additionalBorrowerInfoEntity.getSnpRatingEntity() != null) {
			borrowerInformation.setSnpRatingLabel(
					additionalBorrowerInfoEntity.getSnpRatingEntity().getDescription());
		}
		
		borrowerInformation.setMoodyRating(additionalBorrowerInfoEntity.getMoodyRating());
		
		if(additionalBorrowerInfoEntity.getMoodyRatingEntity() != null) {
			borrowerInformation.setMoodyRatingLabel(
					additionalBorrowerInfoEntity.getMoodyRatingEntity().getDescription());
		}
		
		borrowerInformation.setSnpOutlook(additionalBorrowerInfoEntity.getSnpOutlook());
		
		if(additionalBorrowerInfoEntity.getSnpOutlookEntity() != null) {
			borrowerInformation.setSnpOutlookLabel(
					additionalBorrowerInfoEntity.getSnpOutlookEntity().getDescription());
		}
		
		borrowerInformation.setMoodyOutlook(additionalBorrowerInfoEntity.getMoodyOutlook());
		
		if(additionalBorrowerInfoEntity.getMoodyOutlookEntity() != null) {
			borrowerInformation.setMoodyOutlookLabel(
					additionalBorrowerInfoEntity.getMoodyOutlookEntity().getDescription());
		}
		
		return borrowerInformation;
	}
	

	/**
	 * This method is used to set the BorrowerInfo Entity from DTO
	 */
	private void setBorrowerBaseEntity(BorrowerInfoBaseEntity borrowerInformationEntity,
												BorrowerInformation borrowerInformation) throws Exception {
		
		borrowerInformationEntity.setSmunId(borrowerInformation.getSmunId());
		borrowerInformationEntity.setPrimarySmics(borrowerInformation.getPrimarySmics());
		
		if(!LADUtils.checkNullorEmpty(borrowerInformation.getSmbcRatingCredit())) {
			borrowerInformationEntity.setSmbcRatingCredit(borrowerInformation.getSmbcRatingCredit());
		}
		
		if(!LADUtils.checkNullorEmpty(borrowerInformation.getSmbcRatingProposed())) {
			borrowerInformationEntity.setSmbcRatingProposed(borrowerInformation.getSmbcRatingProposed());
		}
		
		borrowerInformationEntity.setLeverageLendCurrent(borrowerInformation.getLeverageLendCurrent());
		borrowerInformationEntity.setLeverageLendProposed(borrowerInformation.getLeverageLendProposed());
		borrowerInformationEntity.setMarketCapitalization(borrowerInformation.getMarketCapitalization());
		
		if(!LADUtils.checkNullorEmpty(borrowerInformation.getUsRegCurrent())) {
			borrowerInformationEntity.setUsRegCurrent(borrowerInformation.getUsRegCurrent());
		}
		
		borrowerInformationEntity.setUsRegCurrentDate(
				LADUtils.formatStringtoDate(borrowerInformation.getUsRegCurrentDate()));
		
		if(!LADUtils.checkNullorEmpty(borrowerInformation.getUsRegProposed())) {
			borrowerInformationEntity.setUsRegProposed(borrowerInformation.getUsRegProposed());
		}
		borrowerInformationEntity.setReadBySnc(borrowerInformation.getReadBySnc());
		borrowerInformationEntity.setReadBySncDate(
				LADUtils.formatStringtoDate(borrowerInformation.getReadBySncDate()));
		
		if(!LADUtils.checkNullorEmpty(borrowerInformation.getSncRating())) {
			borrowerInformationEntity.setSncRating(borrowerInformation.getSncRating());
		}
		borrowerInformationEntity.setSncRatingFacility(borrowerInformation.getSncRatingFacility());
		borrowerInformationEntity.setDesignatedByDirector(
				borrowerInformation.getDesignatedByDirector());
		
		borrowerInformationEntity.setNaturalResSector(borrowerInformation.getNaturalResSector());
		borrowerInformationEntity.setEsgRisk(borrowerInformation.getEsgRisk());
		borrowerInformationEntity.setMonitoredSector(borrowerInformation.getMonitoredSector());
		borrowerInformationEntity.setPassWatchCurrent(borrowerInformation.getPassWatchCurrent());
		borrowerInformationEntity.setPassWatchCurrentDate(
				LADUtils.formatStringtoDate(borrowerInformation.getPassWatchCurrentDate()));
		borrowerInformationEntity.setPassWatchProposed(borrowerInformation.getPassWatchProposed());
		borrowerInformationEntity.setWarningCurrent(borrowerInformation.getWarningCurrent());
		borrowerInformationEntity.setWarningCurrentDate(
				LADUtils.formatStringtoDate(borrowerInformation.getWarningCurrentDate()));
		borrowerInformationEntity.setWarningProposed(borrowerInformation.getWarningProposed());
		borrowerInformationEntity.setBiNotes(borrowerInformation.getBiNotes());
		//return borrowerInformationEntity;
	}
	
	
	/**
	 * This method is used to get the application number for the given pipeline id
	 * @param pipelineId
	 * @return
	 * @throws Exception
	 */
	private int getApplicationNumber(int pipelineId) throws Exception {
		PipelineDealsCreditEntity pipelineDealsCreditEntity = pipelineDealsService.getPipelineDealsCreditEntity(pipelineId);
		return pipelineDealsCreditEntity.getApplicationNumber();
	}
}
