package com.smbc.lad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smbc.lad.dto.lookup.Company;
import com.smbc.lad.dto.lookup.LookupDTO;
import com.smbc.lad.dto.lookup.OfficerCode;
import com.smbc.lad.dto.lookup.Sponsors;
import com.smbc.lad.entity.lookup.AncillaryTimePeriodEntity;
import com.smbc.lad.entity.lookup.ApplicationStatusEntity;
import com.smbc.lad.entity.lookup.ApplicationTypeEntity;
import com.smbc.lad.entity.lookup.BCDADOfficerEntity;
import com.smbc.lad.entity.lookup.BaseRateEntity;
import com.smbc.lad.entity.lookup.CATFChairEntity;
import com.smbc.lad.entity.lookup.CATFDecisionEntity;
import com.smbc.lad.entity.lookup.CDADOfficerEntity;
import com.smbc.lad.entity.lookup.CategoryEntity;
import com.smbc.lad.entity.lookup.CompanyEntity;
import com.smbc.lad.entity.lookup.CurrencyEntity;
import com.smbc.lad.entity.lookup.DepartmentsEntity;
import com.smbc.lad.entity.lookup.FOAnalystEntity;
import com.smbc.lad.entity.lookup.MoodysOutlookEntity;
import com.smbc.lad.entity.lookup.MoodysRatingEntity;
import com.smbc.lad.entity.lookup.PMGApprovalStatusEntity;
import com.smbc.lad.entity.lookup.PMGConditionTypeEntity;
import com.smbc.lad.entity.lookup.PMGDecisionEntity;
import com.smbc.lad.entity.lookup.PMGMeetingTypeEntity;
import com.smbc.lad.entity.lookup.PMGOfficerEntity;
import com.smbc.lad.entity.lookup.PMGStatusEntity;
import com.smbc.lad.entity.lookup.PMGSupportEntity;
import com.smbc.lad.entity.lookup.PassWatchEntity;
import com.smbc.lad.entity.lookup.PriorityRankingEntity;
import com.smbc.lad.entity.lookup.ProcessTypeEntity;
import com.smbc.lad.entity.lookup.RegulatoryRatingEntity;
import com.smbc.lad.entity.lookup.RelationshipManagerEntity;
import com.smbc.lad.entity.lookup.SMBCRatingEntity;
import com.smbc.lad.entity.lookup.SMBCRoleEntity;
import com.smbc.lad.entity.lookup.SNPOutlookEntity;
import com.smbc.lad.entity.lookup.SNPRatingEntity;
import com.smbc.lad.entity.lookup.SponsorsEntity;
import com.smbc.lad.entity.lookup.SubCategoryEntity;
import com.smbc.lad.entity.lookup.TiersEntity;
import com.smbc.lad.exception.SMBCResourceNotFoundException;
import com.smbc.lad.repository.lookup.AncillaryTimePeriodRepo;
import com.smbc.lad.repository.lookup.ApplicationStatusRepo;
import com.smbc.lad.repository.lookup.ApplicationTypeRepo;
import com.smbc.lad.repository.lookup.BCDADOfficerRepo;
import com.smbc.lad.repository.lookup.BaseRateRepo;
import com.smbc.lad.repository.lookup.CATFChairRepo;
import com.smbc.lad.repository.lookup.CATFDecisionRepo;
import com.smbc.lad.repository.lookup.CDADOfficerRepo;
import com.smbc.lad.repository.lookup.CategoryRepo;
import com.smbc.lad.repository.lookup.CompanyRepo;
import com.smbc.lad.repository.lookup.CurrencyRepo;
import com.smbc.lad.repository.lookup.DepartmentsRepo;
import com.smbc.lad.repository.lookup.FOAnalystRepo;
import com.smbc.lad.repository.lookup.MoodysOutlookRepo;
import com.smbc.lad.repository.lookup.MoodysRatingRepo;
import com.smbc.lad.repository.lookup.PMGApprovalStatusRepo;
import com.smbc.lad.repository.lookup.PMGConditionTypeRepo;
import com.smbc.lad.repository.lookup.PMGDecisionRepo;
import com.smbc.lad.repository.lookup.PMGMeetingTypeRepo;
import com.smbc.lad.repository.lookup.PMGOfficerRepo;
import com.smbc.lad.repository.lookup.PMGStatusRepo;
import com.smbc.lad.repository.lookup.PMGSupportRepo;
import com.smbc.lad.repository.lookup.PassWatchRepo;
import com.smbc.lad.repository.lookup.PriorityRankingRepo;
import com.smbc.lad.repository.lookup.ProcessTypeRepo;
import com.smbc.lad.repository.lookup.RegulatoryRatingRepo;
import com.smbc.lad.repository.lookup.RelationshipManagerRepo;
import com.smbc.lad.repository.lookup.SMBCRatingRepo;
import com.smbc.lad.repository.lookup.SMBCRoleRepo;
import com.smbc.lad.repository.lookup.SNPOutlookRepo;
import com.smbc.lad.repository.lookup.SNPRatingRepo;
import com.smbc.lad.repository.lookup.SponsorsRepo;
import com.smbc.lad.repository.lookup.SubCategoryRepo;
import com.smbc.lad.repository.lookup.TiersRepo;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an implementation class for the Lookup entities. This class is used to 
 * fetch data from tables and populates the values into dto (data transfer object)
 *
 */
@Service
public class LookupDataServiceImpl implements LookupDataService{

	@Autowired
	private ApplicationStatusRepo applicationStatusRepo;

	@Autowired
	private PMGStatusRepo pmgStatusRepo;
	
	@Autowired
	private CompanyRepo companyRepo;
	
	@Autowired
	private ApplicationTypeRepo applicationTypeRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private SubCategoryRepo subCategoryRepo;
	
	@Autowired
	private CurrencyRepo currencyRepo;
	
	@Autowired
	private DepartmentsRepo departmentsRepo;
	
	@Autowired
	private MoodysOutlookRepo moodysOutlookRepo;
	
	@Autowired
	private MoodysRatingRepo moodysRatingRepo;
	
	@Autowired
	private PassWatchRepo passWatchRepo;
	
	@Autowired
	private PriorityRankingRepo priorityRankingRepo;
	
	@Autowired
	private ProcessTypeRepo processTypeRepo;
	
	@Autowired
	private RegulatoryRatingRepo regulatoryRatingRepo;
	
	@Autowired
	private SMBCRatingRepo sMBCRatingRepo;
	
	@Autowired
	private SMBCRoleRepo sMBCRoleRepo;
	
	@Autowired
	private SNPOutlookRepo sNPOutlookRepo;
	
	@Autowired
	private SNPRatingRepo sNPRatingRepo;
	
	@Autowired
	private SponsorsRepo sponsorsRepo;
	
	@Autowired
	private RelationshipManagerRepo relationshipManagerRepo;
	
	@Autowired
	private CDADOfficerRepo cDADOfficerRepo;
	
	@Autowired
	private BCDADOfficerRepo bCDADOfficerRepo;
	
	@Autowired
	private PMGOfficerRepo pMGOfficerRepo;
	
	@Autowired
	private FOAnalystRepo fOAnalystRepo;
	
	@Autowired
	private PMGMeetingTypeRepo pmgMeetingTypeRepo;

	@Autowired
	private CATFDecisionRepo catfDecisionRepo;

	@Autowired
	private PMGSupportRepo pmgSupportRepo;

	@Autowired
	private PMGDecisionRepo pmgDecisionRepo;

	@Autowired
	private PMGConditionTypeRepo pmgConditionTypeRepo;
	
	@Autowired
	private BaseRateRepo baseRateRepo;
	
	@Autowired
	private TiersRepo tiersRepo;
	
	@Autowired
	private CATFChairRepo catfChairRepo;
	
	@Autowired
	private AncillaryTimePeriodRepo ancillaryTimePeriodRepo;
	
	@Autowired
	private PMGApprovalStatusRepo pmgApprovalStatusRepo;
	
	@Override
	public List<LookupDTO> getAllApplicationStatus() {
		
		List<ApplicationStatusEntity> appStatusEntityList = applicationStatusRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> appStatusCollection = new ArrayList<LookupDTO>();
		
		for(ApplicationStatusEntity appStatusEntity : appStatusEntityList) {
			LookupDTO appStatus = new LookupDTO(
					appStatusEntity.getId(),appStatusEntity.getDescription());
				appStatusCollection.add(appStatus);
		}
		
		return appStatusCollection;
	}
	
	
	@Override
	public List<LookupDTO> getAllPMGStatus() {
		
		
		List<PMGStatusEntity> appStatusEntityList = pmgStatusRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> appStatusCollection = new ArrayList<LookupDTO>();
		
		for(PMGStatusEntity appStatusEntity : appStatusEntityList) {
				LookupDTO appStatus = new LookupDTO(
						appStatusEntity.getId(),appStatusEntity.getDescription());
					appStatusCollection.add(appStatus);
		}
		
		return appStatusCollection;
	}
	
	
	@Override
	public List<Company> getAllCompanies() {
		
		List<CompanyEntity> companyEntityList = companyRepo.findAllByOrderByOrderSequenceAsc();
		
		List<Company> companyCollection = new ArrayList<Company>();
		
		for(CompanyEntity companyEntity : companyEntityList) {
			Company comp = new Company(
					companyEntity.getSmunId(),companyEntity.getCompanyName());
			companyCollection.add(comp);
		}
		
		return companyCollection;
	}
	
	public Company getCompanyBySmunId(String smunId) {
		
		CompanyEntity companyEntity = companyRepo.findBySmunId(smunId);
		
		if(companyEntity == null) {
			throw new SMBCResourceNotFoundException("Company Name not found for the SMUN ID " + smunId);
		}
		
		Company company = new Company(companyEntity.getSmunId(),companyEntity.getCompanyName());
		
		return company;
	}
	
	
	@Override
	public List<LookupDTO> getAllApplicationType() {
		
		List<ApplicationTypeEntity> appTypeEntityList = applicationTypeRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> appTypeCollection = new ArrayList<LookupDTO>();
		
		for(ApplicationTypeEntity appTypeEntity : appTypeEntityList) {
			LookupDTO appType = new LookupDTO(
					appTypeEntity.getId(),appTypeEntity.getDescription());
			appTypeCollection.add(appType);
		}
				
		return appTypeCollection;
	}
	
	@Override
	public List<LookupDTO> getAllCategory(){
		
		List<CategoryEntity> categoryEntityList = categoryRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> categoryCollection = new ArrayList<LookupDTO>();
		
		for(CategoryEntity categoryEntity : categoryEntityList) {
			LookupDTO category = new LookupDTO(
					categoryEntity.getId(),categoryEntity.getDescription());
			categoryCollection.add(category);
		}
				
		return categoryCollection;
	}
	
	@Override
	public List<LookupDTO> getAllSubCategory(){
		
		List<SubCategoryEntity> subCategoryEntityList = subCategoryRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> subCategoryCollection = new ArrayList<LookupDTO>();
		
		for(SubCategoryEntity categoryEntity : subCategoryEntityList) {
			LookupDTO subCategory = new LookupDTO(
					categoryEntity.getId(),categoryEntity.getDescription());
			subCategoryCollection.add(subCategory);
		}
				
		return subCategoryCollection;
	}
	
	@Override
	public List<LookupDTO> getAllCurrency(){
		
		List<CurrencyEntity> currencyEntityList = currencyRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> currencyCollection = new ArrayList<LookupDTO>();
		
		for(CurrencyEntity currencyEntity : currencyEntityList) {
			LookupDTO currency = new LookupDTO(
					currencyEntity.getId(),currencyEntity.getDescription());
			currencyCollection.add(currency);
		}
				
		return currencyCollection;
	}
	
	@Override
	public List<LookupDTO> getAllDepartments(){
		
		List<DepartmentsEntity> departmentsEntityList = departmentsRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> departmentsCollection = new ArrayList<LookupDTO>();
		
		for(DepartmentsEntity departmentsEntity : departmentsEntityList) {
			LookupDTO departments = new LookupDTO(
					departmentsEntity.getId(),departmentsEntity.getDescription());
			departmentsCollection.add(departments);
		}
				
		return departmentsCollection;	
	}
	
	@Override
	public List<LookupDTO> getAllMoodysOutlook(){
		
		List<MoodysOutlookEntity> moodysOutlookEntityList = moodysOutlookRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> moodysOutlookCollection = new ArrayList<LookupDTO>();
		
		for(MoodysOutlookEntity moodysOutlookEntity : moodysOutlookEntityList) {
			LookupDTO doodysOutlook = new LookupDTO(
					moodysOutlookEntity.getId(),moodysOutlookEntity.getDescription());
			moodysOutlookCollection.add(doodysOutlook);
		}
				
		return moodysOutlookCollection;
	}
	
	@Override
	public List<LookupDTO> getAllMoodysRating(){
		
		List<MoodysRatingEntity> moodysRatingEntityList = moodysRatingRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> moodysRatingCollection = new ArrayList<LookupDTO>();
		
		for(MoodysRatingEntity moodysRatingEntity : moodysRatingEntityList) {
			LookupDTO moodysRating = new LookupDTO(
					moodysRatingEntity.getId(),moodysRatingEntity.getDescription());
			moodysRatingCollection.add(moodysRating);
		}
				
		return moodysRatingCollection;
	}
	
	@Override
	public List<LookupDTO> getAllPassWatch(){
		
		List<PassWatchEntity> passWatchEntityList = passWatchRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> passWatchCollection = new ArrayList<LookupDTO>();
		
		for(PassWatchEntity passWatchEntity : passWatchEntityList) {
			LookupDTO passWatch = new LookupDTO(
					passWatchEntity.getId(),passWatchEntity.getDescription());
			passWatchCollection.add(passWatch);
		}
				
		return passWatchCollection;
	}
	
	@Override
	public List<LookupDTO> getAllPriorityRanking(){
		
		List<PriorityRankingEntity> priorityRankingEntityList = priorityRankingRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> priorityRankingCollection = new ArrayList<LookupDTO>();
		
		for(PriorityRankingEntity priorityRankingEntity : priorityRankingEntityList) {
			LookupDTO priorityRanking = new LookupDTO(
					priorityRankingEntity.getId(),priorityRankingEntity.getDescription());
			priorityRankingCollection.add(priorityRanking);
		}
				
		return priorityRankingCollection;
	}
	
	@Override
	public List<LookupDTO> getAllProcessType(){
		
		List<ProcessTypeEntity> processTypeEntityList = processTypeRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> processTypeCollection = new ArrayList<LookupDTO>();
		
		for(ProcessTypeEntity processTypeEntity : processTypeEntityList) {
			LookupDTO processType = new LookupDTO(
					processTypeEntity.getId(),processTypeEntity.getDescription());
			processTypeCollection.add(processType);
		}
				
		return processTypeCollection;
	}
	
	@Override
	public List<LookupDTO> getAllRegulatoryRating(){
		
		List<RegulatoryRatingEntity> regulatoryRatingEntityList = regulatoryRatingRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> regulatoryRatingCollection = new ArrayList<LookupDTO>();
		
		for(RegulatoryRatingEntity regulatoryRatingEntity : regulatoryRatingEntityList) {
			LookupDTO regulatoryRating = new LookupDTO(
					regulatoryRatingEntity.getId(),regulatoryRatingEntity.getDescription());
			regulatoryRatingCollection.add(regulatoryRating);
		}
				
		return regulatoryRatingCollection;
	}
	
	@Override
	public List<LookupDTO> getAllSMBCRating(){
		
		List<SMBCRatingEntity> sMBCRatingEntityList = sMBCRatingRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> sMBCRatingCollection = new ArrayList<LookupDTO>();
		
		for(SMBCRatingEntity sMBCRatingEntity : sMBCRatingEntityList) {
			LookupDTO sMBCRating = new LookupDTO(
					sMBCRatingEntity.getId(),sMBCRatingEntity.getDescription());
			sMBCRatingCollection.add(sMBCRating);
		}
				
		return sMBCRatingCollection;
	}
	
	@Override
	public List<LookupDTO> getAllSMBCRoles(){
		
		List<SMBCRoleEntity> sMBCRoleEntityList = sMBCRoleRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> sMBCRoleCollection = new ArrayList<LookupDTO>();
		
		for(SMBCRoleEntity sMBCRoleEntity : sMBCRoleEntityList) {
			LookupDTO sMBCRole = new LookupDTO(
					sMBCRoleEntity.getId(),sMBCRoleEntity.getDescription());
			sMBCRoleCollection.add(sMBCRole);
		}
				
		return sMBCRoleCollection;
	}
	
	@Override
	public List<LookupDTO> getAllSNPOutlook(){
		
		List<SNPOutlookEntity> sNPOutlookEntityList = sNPOutlookRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> sNPOutlookCollection = new ArrayList<LookupDTO>();
		
		for(SNPOutlookEntity sNPOutlookEntity : sNPOutlookEntityList) {
			LookupDTO sNPOutlook = new LookupDTO(
					sNPOutlookEntity.getId(),sNPOutlookEntity.getDescription());
			sNPOutlookCollection.add(sNPOutlook);
		}
				
		return sNPOutlookCollection;
	}
	
	@Override
	public List<LookupDTO> getAllSNPRating(){
		
		List<SNPRatingEntity> sNPRatingEntityList = sNPRatingRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> sNPRatingCollection = new ArrayList<LookupDTO>();
		
		for(SNPRatingEntity sNPRatingEntity : sNPRatingEntityList) {
			LookupDTO sNPRating = new LookupDTO(
					sNPRatingEntity.getId(),sNPRatingEntity.getDescription());
			sNPRatingCollection.add(sNPRating);
		}
				
		return sNPRatingCollection;
	}
	
	@Override
	public List<Sponsors> getAllSponsors(){
		
		List<SponsorsEntity> sponsorsEntityList = sponsorsRepo.findAllByOrderByOrderSequenceAsc();
		
		List<Sponsors> sponsorsCollection = new ArrayList<Sponsors>();
		
		for(SponsorsEntity sponsorsEntity : sponsorsEntityList) {
			Sponsors sponsors = new Sponsors(
					sponsorsEntity.getId(),sponsorsEntity.getName());
			sponsorsCollection.add(sponsors);
		}
				
		return sponsorsCollection;
	}
	
	
	public List<OfficerCode> getAllRelationshipManager() {
		
		List<RelationshipManagerEntity> relationshipManagerEntityList = relationshipManagerRepo.findAllByOrderByOrderSequenceAsc();
		
		List<OfficerCode> relationshipManagerCollection = new ArrayList<OfficerCode>();
		
		for(RelationshipManagerEntity relationshipManagerEntity : relationshipManagerEntityList) {
			OfficerCode relationshipManager = new OfficerCode(
					relationshipManagerEntity.getCode(),relationshipManagerEntity.getName());
			relationshipManagerCollection.add(relationshipManager);
		}
				
		return relationshipManagerCollection;
		
	}
	
	public List<OfficerCode> getAllCDADOfficer() {
		List<CDADOfficerEntity> cDADOfficerEntityList = cDADOfficerRepo.findAllByOrderByOrderSequenceAsc();
		
		List<OfficerCode> cDADOfficerCollection = new ArrayList<OfficerCode>();
		
		for(CDADOfficerEntity cDADOfficerEntity : cDADOfficerEntityList) {
			OfficerCode cDADOfficer = new OfficerCode(
					cDADOfficerEntity.getCode(),cDADOfficerEntity.getName());
			cDADOfficerCollection.add(cDADOfficer);
		}
				
		return cDADOfficerCollection;
	}
	
	public List<OfficerCode> getAllBCDADOfficer() {
		List<BCDADOfficerEntity> bCDADOfficerEntityList = bCDADOfficerRepo.findAllByOrderByOrderSequenceAsc();
		
		List<OfficerCode> bCDADOfficerCollection = new ArrayList<OfficerCode>();
		
		for(BCDADOfficerEntity bCDADOfficerEntity : bCDADOfficerEntityList) {
			OfficerCode bCDADOfficer = new OfficerCode(
					bCDADOfficerEntity.getCode(),bCDADOfficerEntity.getName());
			bCDADOfficerCollection.add(bCDADOfficer);
		}
				
		return bCDADOfficerCollection;
	}
	
	public List<OfficerCode> getAllPMGOfficer() {
		List<PMGOfficerEntity> pMGOfficerEntityList = pMGOfficerRepo.findAllByOrderByOrderSequenceAsc();
		
		List<OfficerCode> pMGOfficerCollection = new ArrayList<OfficerCode>();
		
		for(PMGOfficerEntity pMGOfficerEntity : pMGOfficerEntityList) {
			OfficerCode pMGOfficer = new OfficerCode(
					pMGOfficerEntity.getCode(),pMGOfficerEntity.getName());
			pMGOfficerCollection.add(pMGOfficer);
		}
				
		return pMGOfficerCollection;
	}
	
	public List<OfficerCode> getAllFOAnalyst() {
		List<FOAnalystEntity> fOAnalystEntityList = fOAnalystRepo.findAllByOrderByOrderSequenceAsc();
		
		List<OfficerCode> fOAnalystCollection = new ArrayList<OfficerCode>();
		
		for(FOAnalystEntity fOAnalystEntity : fOAnalystEntityList) {
			OfficerCode fOAnalyst = new OfficerCode(
					fOAnalystEntity.getCode(),fOAnalystEntity.getName());
			fOAnalystCollection.add(fOAnalyst);
		}
				
		return fOAnalystCollection;
	}
	
	public List<LookupDTO> getAllPMGMeetingType() {
		List<PMGMeetingTypeEntity> pmgMeetingTypeEntityList = pmgMeetingTypeRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> pmgMeetingTypeCollection = new ArrayList<LookupDTO>();

		for(PMGMeetingTypeEntity pmgMeetingTypeEntity : pmgMeetingTypeEntityList) {
			LookupDTO pmgMeetingType = new LookupDTO(
					pmgMeetingTypeEntity.getId(),pmgMeetingTypeEntity.getDescription());
			pmgMeetingTypeCollection.add(pmgMeetingType);
		}
				
		return pmgMeetingTypeCollection;
	}
	
	public List<LookupDTO> getAllCATFDecision() {
		List<CATFDecisionEntity> catfDecisionEntityList = catfDecisionRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> catfDecisionCollection = new ArrayList<LookupDTO>();

		for(CATFDecisionEntity catfDecisionEntity : catfDecisionEntityList) {
			LookupDTO catfDecision = new LookupDTO(
					catfDecisionEntity.getId(),catfDecisionEntity.getDescription());
			catfDecisionCollection.add(catfDecision);
		}
				
		return catfDecisionCollection;
	}
	
	public List<LookupDTO> getAllPMGSupport() {
		List<PMGSupportEntity> pmgSupportEntityList = pmgSupportRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> pmgSupportCollection = new ArrayList<LookupDTO>();

		for(PMGSupportEntity pmgSupportEntity : pmgSupportEntityList) {
			LookupDTO pmgSupport = new LookupDTO(
					pmgSupportEntity.getId(),pmgSupportEntity.getDescription());
			pmgSupportCollection.add(pmgSupport);
		}
				
		return pmgSupportCollection;
	}
	
	public List<LookupDTO> getAllPMGDecision() {
		List<PMGDecisionEntity> pmgDecisionEntityList = pmgDecisionRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> pmgDecisionCollection = new ArrayList<LookupDTO>();

		for(PMGDecisionEntity pmgDecisionEntity : pmgDecisionEntityList) {
			LookupDTO pmgDecision = new LookupDTO(
					pmgDecisionEntity.getId(),pmgDecisionEntity.getDescription());
			pmgDecisionCollection.add(pmgDecision);
		}
				
		return pmgDecisionCollection;
	}
	
	public List<LookupDTO> getAllPMGConditionType() {
		List<PMGConditionTypeEntity> pmgConditionTypeEntityList = pmgConditionTypeRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> pmgConditionTypeCollection = new ArrayList<LookupDTO>();

		for(PMGConditionTypeEntity pmgConditionTypeEntity : pmgConditionTypeEntityList) {
			LookupDTO pmgConditionType = new LookupDTO(
					pmgConditionTypeEntity.getId(),pmgConditionTypeEntity.getDescription());
			pmgConditionTypeCollection.add(pmgConditionType);
		}
				
		return pmgConditionTypeCollection;
	}

	public List<LookupDTO> getAllBaseRate() {
		List<BaseRateEntity> baseRateEntityList = baseRateRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> baseRateCollection = new ArrayList<LookupDTO>();

		for(BaseRateEntity baseRateEntity : baseRateEntityList) {
			LookupDTO baseRate = new LookupDTO(
					baseRateEntity.getId(),baseRateEntity.getDescription());
			baseRateCollection.add(baseRate);
		}
				
		return baseRateCollection;
	}
	
	public List<LookupDTO> getAllTiers() {
		List<TiersEntity> tiersEntityList = tiersRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> tiersCollection = new ArrayList<LookupDTO>();

		for(TiersEntity tiersEntity : tiersEntityList) {
			LookupDTO tiers = new LookupDTO(
					tiersEntity.getId(),tiersEntity.getDescription());
			tiersCollection.add(tiers);
		}
				
		return tiersCollection;
	}
	
	public List<LookupDTO> getAllCATFChair() {
		List<CATFChairEntity> catfChairEntityList = catfChairRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> catfChairCollection = new ArrayList<LookupDTO>();

		for(CATFChairEntity catfChairEntity : catfChairEntityList) {
			LookupDTO catfChair = new LookupDTO(
					catfChairEntity.getId(),catfChairEntity.getDescription());
			catfChairCollection.add(catfChair);
		}
				
		return catfChairCollection;
	}
	
	public List<LookupDTO> getAllAncillaryTimePeriod() {
		List<AncillaryTimePeriodEntity> ancillaryTimePeriodEntityList = ancillaryTimePeriodRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> ancillaryTimePeriodCollection = new ArrayList<LookupDTO>();

		for(AncillaryTimePeriodEntity ancillaryTimePeriodEntity : ancillaryTimePeriodEntityList) {
			LookupDTO ancillaryTimePeriod = new LookupDTO(
					ancillaryTimePeriodEntity.getId(),ancillaryTimePeriodEntity.getDescription());
			ancillaryTimePeriodCollection.add(ancillaryTimePeriod);
		}
				
		return ancillaryTimePeriodCollection;
	}
	
	public List<LookupDTO> getAllPMGApprovalStatus() {
		List<PMGApprovalStatusEntity> pmgApprovalStatusEntityList = pmgApprovalStatusRepo.findAllByOrderByOrderSequenceAsc();
		
		List<LookupDTO> pmgApprovalStatusCollection = new ArrayList<LookupDTO>();

		for(PMGApprovalStatusEntity pmgApprovalStatusEntity : pmgApprovalStatusEntityList) {
			LookupDTO pmgApprovalStatus = new LookupDTO(
					pmgApprovalStatusEntity.getId(),pmgApprovalStatusEntity.getDescription());
			pmgApprovalStatusCollection.add(pmgApprovalStatus);
		}
				
		return pmgApprovalStatusCollection;
	}
}
