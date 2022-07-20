package com.smbc.lad.controller.lookup;

import java.util.Arrays

;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.lad.dto.lookup.Company;
import com.smbc.lad.dto.lookup.LookupDTO;
import com.smbc.lad.dto.lookup.OfficerCode;
import com.smbc.lad.dto.lookup.Sponsors;
import com.smbc.lad.service.LookupDataService;

/**
 * @author Saravanan T
 * @since April 2022
 *  
 * This is the main controller class which exposes API end points for the following look up fields
 * 
 * 1. Application Status - to get all the application status
 * 2. Application Types - to get all the application types
 * 3. Categories
 * 4. Sub Categories
 * 5. Currencies
 * 6. Departments
 * 7. Moody's Rating
 * 8. Moody's Outlook
 * 9. SNP Rating
 * 10. SNP Outlook
 * 11. Pass Watches
 * 12. Priority Ranking
 * 13. Process Types
 * 15. Regulatory Ratings (US Reg Current & Proposed)
 * 16. SMBC Roles
 * 17. SMBC Ratings (Current & Proposed)
 * 18. Relationship Managers
 * 19. Sponsors
 * 20. CDAD Officers
 * 21. BCDAD Officers
 * 22. PMG Officers
 * 23. FO Analyst
 * 24. Base Rate
 * 25. Tiers
 * 26. CATF Chair
 * 27. Ancilliary Time Period
 * 28. PMGApprovalStatus
 * 
 */
@RestController
public class LookupDataController {

	@Autowired
	private LookupDataService lookupDataService;
	
	@RequestMapping(value = "/smbcapi/v1/applicationstatus", method=RequestMethod.GET)
	public List<LookupDTO> getApplicationStatus() throws Exception 
	{
		List<LookupDTO> applicationStatusList = lookupDataService.getAllApplicationStatus();
		
		return applicationStatusList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/pmgstatus", method=RequestMethod.GET)
	public List<LookupDTO> getPMGStatus() throws Exception 
	{
		List<LookupDTO> pmgStatusList = lookupDataService.getAllPMGStatus();
		
		return pmgStatusList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/companies", method=RequestMethod.GET)
	public List<Company> getComapnies() throws Exception 
	{
		List<Company> companyList = lookupDataService.getAllCompanies();
		
		return companyList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/applicationtypes", method=RequestMethod.GET)
	public List<LookupDTO> getApplicationType() throws Exception 
	{
		List<LookupDTO> applicationTypeList = lookupDataService.getAllApplicationType();
		
		return applicationTypeList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/categories", method=RequestMethod.GET)
	public List<LookupDTO> getCategory() throws Exception 
	{
		List<LookupDTO> categoryList = lookupDataService.getAllCategory();
		
		return categoryList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/subcategories", method=RequestMethod.GET)
	public List<LookupDTO> getSubCategory() throws Exception 
	{
		List<LookupDTO> subCategoryList = lookupDataService.getAllSubCategory();
		
		return subCategoryList;
	}
	
	
	@RequestMapping(value = "/smbcapi/v1/currencies", method=RequestMethod.GET)
	public List<LookupDTO> getCurrency() throws Exception 
	{
		List<LookupDTO> currencyList = lookupDataService.getAllCurrency();
		
		return currencyList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/departments", method=RequestMethod.GET)
	public List<LookupDTO> getDepartments() throws Exception 
	{
		List<LookupDTO> departmentsList = lookupDataService.getAllDepartments();
		
		return departmentsList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/moodysoutlooks", method=RequestMethod.GET)
	public List<LookupDTO> getMoodysOutlook() throws Exception 
	{
		List<LookupDTO> moodysOutlookList = lookupDataService.getAllMoodysOutlook();
		
		return moodysOutlookList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/moodysratings", method=RequestMethod.GET)
	public List<LookupDTO> getMoodysRating() throws Exception 
	{
		List<LookupDTO> moodysRatingList = lookupDataService.getAllMoodysRating();
		
		return moodysRatingList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/passwatches", method=RequestMethod.GET)
	public List<LookupDTO> getPassWatch() throws Exception 
	{
		List<LookupDTO> passWatchList = lookupDataService.getAllPassWatch();
		
		return passWatchList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/rankingpriorities", method=RequestMethod.GET)
	public List<LookupDTO> getPriorityRanking() throws Exception 
	{
		List<LookupDTO> priorityRankingList = lookupDataService.getAllPriorityRanking();
		
		return priorityRankingList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/processtypes", method=RequestMethod.GET)
	public List<LookupDTO> getProcessType() throws Exception 
	{
		List<LookupDTO> processTypeList = lookupDataService.getAllProcessType();
		
		return processTypeList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/regulatoryratings", method=RequestMethod.GET)
	public List<LookupDTO> getRegulatoryRating() throws Exception 
	{
		List<LookupDTO> regulatoryRatingList = lookupDataService.getAllRegulatoryRating();
		
		return regulatoryRatingList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/smbcratings", method=RequestMethod.GET)
	public List<LookupDTO> getSMBCRating() throws Exception 
	{
		List<LookupDTO> sMBCRatingList = lookupDataService.getAllSMBCRating();
		
		return sMBCRatingList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/smbcroles", method=RequestMethod.GET)
	public List<LookupDTO> getSMBCRole() throws Exception 
	{
		List<LookupDTO> sMBCRoleList = lookupDataService.getAllSMBCRoles();
		
		return sMBCRoleList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/snpoutlooks", method=RequestMethod.GET)
	public List<LookupDTO> getSNPOutlook() throws Exception 
	{
		List<LookupDTO> sNPOutlookList = lookupDataService.getAllSNPOutlook();
		
		return sNPOutlookList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/snpratings", method=RequestMethod.GET)
	public List<LookupDTO> getSNPRating() throws Exception 
	{
		List<LookupDTO> sNPRatingList = lookupDataService.getAllSNPRating();
		
		return sNPRatingList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/sponsors", method=RequestMethod.GET)
	public List<Sponsors> getSponsors() throws Exception 
	{
		List<Sponsors> sponsorsList = lookupDataService.getAllSponsors();
		
		return sponsorsList;
	}
	
	
	@RequestMapping(value = "/smbcapi/v1/relationshipmanagers", method=RequestMethod.GET)
	public List<OfficerCode> getRelationshipManagers() throws Exception 
	{
		List<OfficerCode> rmList = lookupDataService.getAllRelationshipManager();
		
		return rmList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/cdadofficers", method=RequestMethod.GET)
	public List<OfficerCode> getCDADOfficerss() throws Exception 
	{
		List<OfficerCode> cdadOfficersList = lookupDataService.getAllCDADOfficer();
		
		return cdadOfficersList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/bcdadofficers", method=RequestMethod.GET)
	public List<OfficerCode> getBCDADOfficerss() throws Exception 
	{
		List<OfficerCode> bcdadOfficersList = lookupDataService.getAllBCDADOfficer();
		
		return bcdadOfficersList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/pmgofficers", method=RequestMethod.GET)
	public List<OfficerCode> getPMGOfficerss() throws Exception 
	{
		List<OfficerCode> pmgOfficersList = lookupDataService.getAllPMGOfficer();
		
		return pmgOfficersList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/foanalyst", method=RequestMethod.GET)
	public List<OfficerCode> getFOAnalyst() throws Exception 
	{
		List<OfficerCode> foAnalystList = lookupDataService.getAllFOAnalyst();
		
		return foAnalystList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/pmgmeetingtype", method=RequestMethod.GET)
	public List<LookupDTO> getAllPMGMeetingType() throws Exception 
	{
		List<LookupDTO> pmgMeetingTypeList = lookupDataService.getAllPMGMeetingType();
		
		return pmgMeetingTypeList;
	}

	@RequestMapping(value = "/smbcapi/v1/catfdecision", method=RequestMethod.GET)
	public List<LookupDTO> getAllCATFDecision() throws Exception 
	{
		List<LookupDTO> catfDecisionList = lookupDataService.getAllCATFDecision();
		
		return catfDecisionList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/pmgsupport", method=RequestMethod.GET)
	public List<LookupDTO> getAllPMGSupport() throws Exception 
	{
		List<LookupDTO> pmgSupportList = lookupDataService.getAllPMGSupport();
		
		return pmgSupportList;
	}

	@RequestMapping(value = "/smbcapi/v1/pmgdecision", method=RequestMethod.GET)
	public List<LookupDTO> getAllPMGDecision() throws Exception 
	{
		List<LookupDTO> pmgDecisionList = lookupDataService.getAllPMGDecision();
		
		return pmgDecisionList;
	}

	@RequestMapping(value = "/smbcapi/v1/pmgconditiontype", method=RequestMethod.GET)
	public List<LookupDTO> getAllPMGConditionType() throws Exception 
	{
		List<LookupDTO> pmgConditionTypeList = lookupDataService.getAllPMGConditionType();
		
		return pmgConditionTypeList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/baserate", method=RequestMethod.GET)
	public List<LookupDTO> getAllBaseRate() throws Exception 
	{
		List<LookupDTO> baseRateList = lookupDataService.getAllBaseRate();
		
		return baseRateList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/tiers", method=RequestMethod.GET)
	public List<LookupDTO> getAllTiers() throws Exception 
	{
		List<LookupDTO> tiersList = lookupDataService.getAllTiers();
		
		return tiersList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/catfchair", method=RequestMethod.GET)
	public List<LookupDTO> getAllCATFChair() throws Exception 
	{
		List<LookupDTO> catfChairList = lookupDataService.getAllCATFChair();
		
		return catfChairList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/ancillarytimeperiod", method=RequestMethod.GET)
	public List<LookupDTO> getAllAncillaryTimePeriod() throws Exception 
	{
		List<LookupDTO> tiersList = lookupDataService.getAllAncillaryTimePeriod();
		
		return tiersList;
	}
	
	@RequestMapping(value = "/smbcapi/v1/pmgapprovalstatus", method=RequestMethod.GET)
	public List<LookupDTO> getAllPMGApprovalStatus() throws Exception 
	{
		List<LookupDTO> pmgApprovalStatusList = lookupDataService.getAllPMGApprovalStatus();
		
		return pmgApprovalStatusList;
	}
	
	
	@RequestMapping(value = "/smbcapi/v1/globalookup", method=RequestMethod.GET)
	@SuppressWarnings("unchecked")
	public Map getBulkDataMap(@RequestParam(defaultValue = "applicationstatus") String lookupTypes) throws Exception 
	{
		Map bulkList = new HashMap();
		
		List<String> lookupVals = Arrays.asList(lookupTypes.split(";"));
		
		if(lookupVals.contains("applicationstatus")) {
				bulkList.put("applicationstatus",lookupDataService.getAllApplicationStatus());
		}
		
		if(lookupVals.contains("applicationtypes")) {
			bulkList.put("applicationtype",lookupDataService.getAllApplicationType());
		}
		
		if(lookupVals.contains("currencies")) {
			bulkList.put("currency",lookupDataService.getAllCurrency());
		}
		
		if(lookupVals.contains("categories")) {
			bulkList.put("category",lookupDataService.getAllCategory());
		}
		
		if(lookupVals.contains("subcategories")) {
			bulkList.put("subcategory",lookupDataService.getAllSubCategory());
		}

		if(lookupVals.contains("departments")) {
			bulkList.put("departments",lookupDataService.getAllDepartments());
		}

		if(lookupVals.contains("moodysoutlooks")) {
			bulkList.put("moodysOutlook",lookupDataService.getAllMoodysOutlook());
		}

		if(lookupVals.contains("moodysratings")) {
			bulkList.put("moodysRating",lookupDataService.getAllMoodysRating());
		}
		
		if(lookupVals.contains("passwatches")) {
			bulkList.put("passwatches",lookupDataService.getAllPassWatch());
		}
		
		if(lookupVals.contains("rankingpriorities")) {
			bulkList.put("priorityRanking",lookupDataService.getAllPriorityRanking());
		}

		if(lookupVals.contains("processtypes")) {
			bulkList.put("processType",lookupDataService.getAllProcessType());
		}

		
		if(lookupVals.contains("regulatoryratings")) {
			bulkList.put("regulatoryRating",lookupDataService.getAllRegulatoryRating());
		}

		if(lookupVals.contains("smbcratings")) {
			bulkList.put("sMBCRating",lookupDataService.getAllSMBCRating());
		}

		if(lookupVals.contains("smbcroles")) {
			bulkList.put("sMBCRole",lookupDataService.getAllSMBCRoles());
		}

		if(lookupVals.contains("snpoutlooks")) {
			bulkList.put("sNPOutlooks",lookupDataService.getAllSNPOutlook());
		}

		if(lookupVals.contains("snpratings")) {
			bulkList.put("sNPRating",lookupDataService.getAllSNPRating());
		}

		if(lookupVals.contains("sponsors")) {
			bulkList.put("sponsors",lookupDataService.getAllSponsors());
		}
		
		if(lookupVals.contains("relationshipmanagers")) {
			bulkList.put("relationshipmanager",lookupDataService.getAllRelationshipManager());
		}
		
		if(lookupVals.contains("cdadofficers")) {
			bulkList.put("cdadofficers",lookupDataService.getAllCDADOfficer());
		}
		
		if(lookupVals.contains("bcdadofficers")) {
			bulkList.put("bcdadofficers",lookupDataService.getAllBCDADOfficer());
		}
		
		if(lookupVals.contains("pmgofficers")) {
			bulkList.put("pmgofficers",lookupDataService.getAllPMGOfficer());
		}
		
		if(lookupVals.contains("foanalyst")) {
			bulkList.put("foanalyst",lookupDataService.getAllFOAnalyst());
		}
		
		if(lookupVals.contains("pmgmeetingtype")) {
			bulkList.put("pmgmeetingtype",lookupDataService.getAllPMGMeetingType());
		}
		
		if(lookupVals.contains("catfdecision")) {
			bulkList.put("catfdecision",lookupDataService.getAllCATFDecision());
		}
		
		if(lookupVals.contains("pmgsupport")) {
			bulkList.put("pmgsupport",lookupDataService.getAllPMGSupport());
		}
		
		if(lookupVals.contains("pmgdecision")) {
			bulkList.put("pmgdecision",lookupDataService.getAllPMGDecision());
		}
		
		if(lookupVals.contains("pmgconditiontype")) {
			bulkList.put("pmgconditiontype",lookupDataService.getAllPMGConditionType());
		}
		
		
		if(lookupVals.contains("baserate")) {
			bulkList.put("baserate",lookupDataService.getAllBaseRate());
		}
		
		
		if(lookupVals.contains("tiers")) {
			bulkList.put("tiers",lookupDataService.getAllTiers());
		}
		
		if(lookupVals.contains("catfchair")) {
			bulkList.put("tiers",lookupDataService.getAllCATFChair());
		}
		
		if(lookupVals.contains("ancillarytimeperiod")) {
			bulkList.put("tiers",lookupDataService.getAllAncillaryTimePeriod());
		}
		
		if(lookupVals.contains("pmgapprovalstatus")) {
			bulkList.put("pmgapprovalstatus",lookupDataService.getAllPMGApprovalStatus());
		}
		
		return bulkList;
	}
	
	
}
