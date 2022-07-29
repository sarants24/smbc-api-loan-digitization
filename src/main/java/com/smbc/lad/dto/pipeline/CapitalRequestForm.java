package com.smbc.lad.dto.pipeline;

import java.util.List;

/**
 * @author 
 *
 */
public class CapitalRequestForm {

	private int pipelineId;
	private String businessUnitId;
	private String businessUnitName;
	private int relationshipManagerId;
	private String relationshipManager;
	private int primaryContactSubmitterId;
	private String primaryContactSubmitter;
	private String creditContactName;
	private String parentName;
	private String parentSmun;
	private String borrowerName;
	private String borrowerSmun;
	private String adjustedObligorGrade;
	private String snpRating;
	private String snpRatingLabel;
	private String snpOutlook;
	private String snpOutlookLabel;
	private String moodyRating;
	private String moodyRatingLabel;
	private String moodyOutlook;
	private String moodyOutlookLabel;
	private String downgradeTrigger;
	private String primarySmics;
	private String baseRateId;
	private String baseRateName;
	private String currencyTypeId;
	private String currencyType;
	private String currencyDays;
	private String currencyTime;
	private String pmgDeadline;
	private String externalDeadline;
	private String tsdApproval;
	private String spdgb;
	private String sameDayFunding;
	private String agentNoticeMessage;
	private String catfRequired;
	private String groupExposure;
	private String cdadWatchlist;
	private String isSncRated;
	private String sncRatingId;
	private String sncRatingDescription;
	private String designatedNaturalResource;
	private String interestPeriod;
	private String commitmentChangeSign;
	private String commitmentChange;
	private String requestInLine;
	private String existingTiersId;
	private String existingTiersDescription;
	private String projectedTiersId;
	private String projectedTiersDescription;
	private String raroraProjectedGroup;
	private String extendedFloor;
	private String companyDescription;
	private String requestDescription;
	private String creditMetrics;
	private String lendersGroup;
	private String lcmCommentary;
	private String relatedExposure;
	private String facilityMetrics;
	private String businessDecisionRationale;
	private String dcmSignoff;
	private String dcmProjectedTotal;
	private String dcmComments;
	private String derivativesSignoff;
	private String derivativesProjectedTotal;
	private String derivativesComments;
	private String depositSignoff;
	private String depositProjectedTotal;
	private String depositComments;
	private String ecmSignoff;
	private String ecmProjectedTotal;
	private String ecmComments;
	private String fxSignoff;
	private String fxProjectedTotal;
	private String fxComments;
	private String productOverallTotal;
	private List<CapitalRequestExposure> capitalRequestExposureList;
	private int[] capReqExposureToDeleteIds;
	private List<CapitalRequestFacilityMetrics> capitalRequestFacilityMetrics;
	private int[] capReqFacMetricsToDeleteIds;
	public int getPipelineId() {
		return pipelineId;
	}
	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}
	public String getBusinessUnitId() {
		return businessUnitId;
	}
	public void setBusinessUnitId(String businessUnitId) {
		this.businessUnitId = businessUnitId;
	}
	public String getBusinessUnitName() {
		return businessUnitName;
	}
	public void setBusinessUnitName(String businessUnitName) {
		this.businessUnitName = businessUnitName;
	}
	public int getRelationshipManagerId() {
		return relationshipManagerId;
	}
	public void setRelationshipManagerId(int relationshipManagerId) {
		this.relationshipManagerId = relationshipManagerId;
	}
	public String getRelationshipManager() {
		return relationshipManager;
	}
	public void setRelationshipManager(String relationshipManager) {
		this.relationshipManager = relationshipManager;
	}
	public int getPrimaryContactSubmitterId() {
		return primaryContactSubmitterId;
	}
	public void setPrimaryContactSubmitterId(int primaryContactSubmitterId) {
		this.primaryContactSubmitterId = primaryContactSubmitterId;
	}
	public String getPrimaryContactSubmitter() {
		return primaryContactSubmitter;
	}
	public void setPrimaryContactSubmitter(String primaryContactSubmitter) {
		this.primaryContactSubmitter = primaryContactSubmitter;
	}
	public String getCreditContactName() {
		return creditContactName;
	}
	public void setCreditContactName(String creditContactName) {
		this.creditContactName = creditContactName;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getParentSmun() {
		return parentSmun;
	}
	public void setParentSmun(String parentSmun) {
		this.parentSmun = parentSmun;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public String getBorrowerSmun() {
		return borrowerSmun;
	}
	public void setBorrowerSmun(String borrowerSmun) {
		this.borrowerSmun = borrowerSmun;
	}
	public String getAdjustedObligorGrade() {
		return adjustedObligorGrade;
	}
	public void setAdjustedObligorGrade(String adjustedObligorGrade) {
		this.adjustedObligorGrade = adjustedObligorGrade;
	}
	public String getSnpRating() {
		return snpRating;
	}
	public void setSnpRating(String snpRating) {
		this.snpRating = snpRating;
	}
	public String getSnpRatingLabel() {
		return snpRatingLabel;
	}
	public void setSnpRatingLabel(String snpRatingLabel) {
		this.snpRatingLabel = snpRatingLabel;
	}
	public String getSnpOutlook() {
		return snpOutlook;
	}
	public void setSnpOutlook(String snpOutlook) {
		this.snpOutlook = snpOutlook;
	}
	public String getSnpOutlookLabel() {
		return snpOutlookLabel;
	}
	public void setSnpOutlookLabel(String snpOutlookLabel) {
		this.snpOutlookLabel = snpOutlookLabel;
	}
	public String getMoodyRating() {
		return moodyRating;
	}
	public void setMoodyRating(String moodyRating) {
		this.moodyRating = moodyRating;
	}
	public String getMoodyRatingLabel() {
		return moodyRatingLabel;
	}
	public void setMoodyRatingLabel(String moodyRatingLabel) {
		this.moodyRatingLabel = moodyRatingLabel;
	}
	public String getMoodyOutlook() {
		return moodyOutlook;
	}
	public void setMoodyOutlook(String moodyOutlook) {
		this.moodyOutlook = moodyOutlook;
	}
	public String getMoodyOutlookLabel() {
		return moodyOutlookLabel;
	}
	public void setMoodyOutlookLabel(String moodyOutlookLabel) {
		this.moodyOutlookLabel = moodyOutlookLabel;
	}
	public String getDowngradeTrigger() {
		return downgradeTrigger;
	}
	public void setDowngradeTrigger(String downgradeTrigger) {
		this.downgradeTrigger = downgradeTrigger;
	}
	public String getPrimarySmics() {
		return primarySmics;
	}
	public void setPrimarySmics(String primarySmics) {
		this.primarySmics = primarySmics;
	}
	public String getBaseRateId() {
		return baseRateId;
	}
	public void setBaseRateId(String baseRateId) {
		this.baseRateId = baseRateId;
	}
	public String getBaseRateName() {
		return baseRateName;
	}
	public void setBaseRateName(String baseRateName) {
		this.baseRateName = baseRateName;
	}
	public String getCurrencyTypeId() {
		return currencyTypeId;
	}
	public void setCurrencyTypeId(String currencyTypeId) {
		this.currencyTypeId = currencyTypeId;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public String getCurrencyDays() {
		return currencyDays;
	}
	public void setCurrencyDays(String currencyDays) {
		this.currencyDays = currencyDays;
	}
	public String getCurrencyTime() {
		return currencyTime;
	}
	public void setCurrencyTime(String currencyTime) {
		this.currencyTime = currencyTime;
	}
	public String getPmgDeadline() {
		return pmgDeadline;
	}
	public void setPmgDeadline(String pmgDeadline) {
		this.pmgDeadline = pmgDeadline;
	}
	public String getExternalDeadline() {
		return externalDeadline;
	}
	public void setExternalDeadline(String externalDeadline) {
		this.externalDeadline = externalDeadline;
	}
	public String getTsdApproval() {
		return tsdApproval;
	}
	public void setTsdApproval(String tsdApproval) {
		this.tsdApproval = tsdApproval;
	}
	public String getSpdgb() {
		return spdgb;
	}
	public void setSpdgb(String spdgb) {
		this.spdgb = spdgb;
	}
	public String getSameDayFunding() {
		return sameDayFunding;
	}
	public void setSameDayFunding(String sameDayFunding) {
		this.sameDayFunding = sameDayFunding;
	}
	public String getAgentNoticeMessage() {
		return agentNoticeMessage;
	}
	public void setAgentNoticeMessage(String agentNoticeMessage) {
		this.agentNoticeMessage = agentNoticeMessage;
	}
	public String getCatfRequired() {
		return catfRequired;
	}
	public void setCatfRequired(String catfRequired) {
		this.catfRequired = catfRequired;
	}
	public String getGroupExposure() {
		return groupExposure;
	}
	public void setGroupExposure(String groupExposure) {
		this.groupExposure = groupExposure;
	}
	public String getCdadWatchlist() {
		return cdadWatchlist;
	}
	public void setCdadWatchlist(String cdadWatchlist) {
		this.cdadWatchlist = cdadWatchlist;
	}
	public String getIsSncRated() {
		return isSncRated;
	}
	public void setIsSncRated(String isSncRated) {
		this.isSncRated = isSncRated;
	}
	public String getSncRatingId() {
		return sncRatingId;
	}
	public void setSncRatingId(String sncRatingId) {
		this.sncRatingId = sncRatingId;
	}
	public String getSncRatingDescription() {
		return sncRatingDescription;
	}
	public void setSncRatingDescription(String sncRatingDescription) {
		this.sncRatingDescription = sncRatingDescription;
	}
	public String getDesignatedNaturalResource() {
		return designatedNaturalResource;
	}
	public void setDesignatedNaturalResource(String designatedNaturalResource) {
		this.designatedNaturalResource = designatedNaturalResource;
	}
	public String getInterestPeriod() {
		return interestPeriod;
	}
	public void setInterestPeriod(String interestPeriod) {
		this.interestPeriod = interestPeriod;
	}
	public String getCommitmentChangeSign() {
		return commitmentChangeSign;
	}
	public void setCommitmentChangeSign(String commitmentChangeSign) {
		this.commitmentChangeSign = commitmentChangeSign;
	}
	public String getCommitmentChange() {
		return commitmentChange;
	}
	public void setCommitmentChange(String commitmentChange) {
		this.commitmentChange = commitmentChange;
	}
	public String getRequestInLine() {
		return requestInLine;
	}
	public void setRequestInLine(String requestInLine) {
		this.requestInLine = requestInLine;
	}
	public String getExistingTiersId() {
		return existingTiersId;
	}
	public void setExistingTiersId(String existingTiersId) {
		this.existingTiersId = existingTiersId;
	}
	public String getExistingTiersDescription() {
		return existingTiersDescription;
	}
	public void setExistingTiersDescription(String existingTiersDescription) {
		this.existingTiersDescription = existingTiersDescription;
	}
	public String getProjectedTiersId() {
		return projectedTiersId;
	}
	public void setProjectedTiersId(String projectedTiersId) {
		this.projectedTiersId = projectedTiersId;
	}
	public String getProjectedTiersDescription() {
		return projectedTiersDescription;
	}
	public void setProjectedTiersDescription(String projectedTiersDescription) {
		this.projectedTiersDescription = projectedTiersDescription;
	}
	public String getRaroraProjectedGroup() {
		return raroraProjectedGroup;
	}
	public void setRaroraProjectedGroup(String raroraProjectedGroup) {
		this.raroraProjectedGroup = raroraProjectedGroup;
	}
	public String getExtendedFloor() {
		return extendedFloor;
	}
	public void setExtendedFloor(String extendedFloor) {
		this.extendedFloor = extendedFloor;
	}
	public String getCompanyDescription() {
		return companyDescription;
	}
	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}
	public String getRequestDescription() {
		return requestDescription;
	}
	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}
	public String getCreditMetrics() {
		return creditMetrics;
	}
	public void setCreditMetrics(String creditMetrics) {
		this.creditMetrics = creditMetrics;
	}
	public String getLendersGroup() {
		return lendersGroup;
	}
	public void setLendersGroup(String lendersGroup) {
		this.lendersGroup = lendersGroup;
	}
	public String getLcmCommentary() {
		return lcmCommentary;
	}
	public void setLcmCommentary(String lcmCommentary) {
		this.lcmCommentary = lcmCommentary;
	}
	public String getRelatedExposure() {
		return relatedExposure;
	}
	public void setRelatedExposure(String relatedExposure) {
		this.relatedExposure = relatedExposure;
	}
	public String getFacilityMetrics() {
		return facilityMetrics;
	}
	public void setFacilityMetrics(String facilityMetrics) {
		this.facilityMetrics = facilityMetrics;
	}
	public String getBusinessDecisionRationale() {
		return businessDecisionRationale;
	}
	public void setBusinessDecisionRationale(String businessDecisionRationale) {
		this.businessDecisionRationale = businessDecisionRationale;
	}
	public String getDcmSignoff() {
		return dcmSignoff;
	}
	public void setDcmSignoff(String dcmSignoff) {
		this.dcmSignoff = dcmSignoff;
	}
	public String getDcmProjectedTotal() {
		return dcmProjectedTotal;
	}
	public void setDcmProjectedTotal(String dcmProjectedTotal) {
		this.dcmProjectedTotal = dcmProjectedTotal;
	}
	public String getDcmComments() {
		return dcmComments;
	}
	public void setDcmComments(String dcmComments) {
		this.dcmComments = dcmComments;
	}
	public String getDerivativesSignoff() {
		return derivativesSignoff;
	}
	public void setDerivativesSignoff(String derivativesSignoff) {
		this.derivativesSignoff = derivativesSignoff;
	}
	public String getDerivativesProjectedTotal() {
		return derivativesProjectedTotal;
	}
	public void setDerivativesProjectedTotal(String derivativesProjectedTotal) {
		this.derivativesProjectedTotal = derivativesProjectedTotal;
	}
	public String getDerivativesComments() {
		return derivativesComments;
	}
	public void setDerivativesComments(String derivativesComments) {
		this.derivativesComments = derivativesComments;
	}
	public String getDepositSignoff() {
		return depositSignoff;
	}
	public void setDepositSignoff(String depositSignoff) {
		this.depositSignoff = depositSignoff;
	}
	public String getDepositProjectedTotal() {
		return depositProjectedTotal;
	}
	public void setDepositProjectedTotal(String depositProjectedTotal) {
		this.depositProjectedTotal = depositProjectedTotal;
	}
	public String getDepositComments() {
		return depositComments;
	}
	public void setDepositComments(String depositComments) {
		this.depositComments = depositComments;
	}
	public String getEcmSignoff() {
		return ecmSignoff;
	}
	public void setEcmSignoff(String ecmSignoff) {
		this.ecmSignoff = ecmSignoff;
	}
	public String getEcmProjectedTotal() {
		return ecmProjectedTotal;
	}
	public void setEcmProjectedTotal(String ecmProjectedTotal) {
		this.ecmProjectedTotal = ecmProjectedTotal;
	}
	public String getEcmComments() {
		return ecmComments;
	}
	public void setEcmComments(String ecmComments) {
		this.ecmComments = ecmComments;
	}
	public String getFxSignoff() {
		return fxSignoff;
	}
	public void setFxSignoff(String fxSignoff) {
		this.fxSignoff = fxSignoff;
	}
	public String getFxProjectedTotal() {
		return fxProjectedTotal;
	}
	public void setFxProjectedTotal(String fxProjectedTotal) {
		this.fxProjectedTotal = fxProjectedTotal;
	}
	public String getFxComments() {
		return fxComments;
	}
	public void setFxComments(String fxComments) {
		this.fxComments = fxComments;
	}
	public String getProductOverallTotal() {
		return productOverallTotal;
	}
	public void setProductOverallTotal(String productOverallTotal) {
		this.productOverallTotal = productOverallTotal;
	}
	public List<CapitalRequestExposure> getCapitalRequestExposureList() {
		return capitalRequestExposureList;
	}
	public void setCapitalRequestExposureList(List<CapitalRequestExposure> capitalRequestExposureList) {
		this.capitalRequestExposureList = capitalRequestExposureList;
	}
	public int[] getCapReqExposureToDeleteIds() {
		return capReqExposureToDeleteIds;
	}
	public void setCapReqExposureToDeleteIds(int[] capReqExposureToDeleteIds) {
		this.capReqExposureToDeleteIds = capReqExposureToDeleteIds;
	}
	public List<CapitalRequestFacilityMetrics> getCapitalRequestFacilityMetrics() {
		return capitalRequestFacilityMetrics;
	}
	public void setCapitalRequestFacilityMetrics(List<CapitalRequestFacilityMetrics> capitalRequestFacilityMetrics) {
		this.capitalRequestFacilityMetrics = capitalRequestFacilityMetrics;
	}
	public int[] getCapReqFacMetricsToDeleteIds() {
		return capReqFacMetricsToDeleteIds;
	}
	public void setCapReqFacMetricsToDeleteIds(int[] capReqFacMetricsToDeleteIds) {
		this.capReqFacMetricsToDeleteIds = capReqFacMetricsToDeleteIds;
	}
		
}
