package com.smbc.lad.service;

import java.util.List;

import com.smbc.lad.dto.lookup.Company;
import com.smbc.lad.dto.lookup.LookupDTO;
import com.smbc.lad.dto.lookup.OfficerCode;
import com.smbc.lad.dto.lookup.Sponsors;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an interface class for the Lookup entities. This class is used to 
 * fetch data from tables and populates the values into dto (data transfer object)
 *
 */
public interface LookupDataService {

	public List<LookupDTO> getAllApplicationStatus();
	
	public List<LookupDTO> getAllPMGStatus();
	
	public List<Company> getAllCompanies();
	
	public Company getCompanyBySmunId(String smunId);
	
	public List<LookupDTO> getAllApplicationType();
	
	public List<LookupDTO> getAllCategory();
	
	public List<LookupDTO> getAllSubCategory();
	
	public List<LookupDTO> getAllCurrency();
	
	public List<LookupDTO> getAllDepartments();
	
	public List<LookupDTO> getAllMoodysOutlook();
	
	public List<LookupDTO> getAllMoodysRating();
	
	public List<LookupDTO> getAllPassWatch();
	
	public List<LookupDTO> getAllPriorityRanking();
	
	public List<LookupDTO> getAllProcessType();
	
	public List<LookupDTO> getAllRegulatoryRating();
	
	public List<LookupDTO> getAllSMBCRating();
	
	public List<LookupDTO> getAllSMBCRoles();
	
	public List<LookupDTO> getAllSNPOutlook();
	
	public List<LookupDTO> getAllSNPRating();
	
	public List<Sponsors> getAllSponsors();
	
	public List<OfficerCode> getAllRelationshipManager();
	
	public List<OfficerCode> getAllCDADOfficer();
	
	public List<OfficerCode> getAllBCDADOfficer();
	
	public List<OfficerCode> getAllPMGOfficer();
	
	public List<OfficerCode> getAllFOAnalyst();
	
	public List<LookupDTO> getAllPMGMeetingType();
	
	public List<LookupDTO> getAllCATFDecision();
	
	public List<LookupDTO> getAllPMGSupport();
	
	public List<LookupDTO> getAllPMGDecision();
	
	public List<LookupDTO> getAllPMGConditionType();
	
	public List<LookupDTO> getAllBaseRate();
	
	public List<LookupDTO> getAllTiers();
	
	public List<LookupDTO> getAllCATFChair();
	
	public List<LookupDTO> getAllAncillaryTimePeriod();
	
	public List<LookupDTO> getAllPMGApprovalStatus();

}
