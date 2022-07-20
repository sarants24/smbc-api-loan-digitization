package com.smbc.lad.dto.pipeline;

public class BorrowerInformation {

	private int additionalBorrowerId;
	private int pipelineId;
	private int applicationNumber;
	private String sunId;
	private String smunId;
	private String primarySmics;
	private String smbcRatingCredit;
	private String smbcRatingCreditLabel;
	private String smbcRatingProposed;
	private String smbcRatingProposedLabel;
	private String leverageLendCurrent;
	private String leverageLendProposed;
	private String marketCapitalization;
	private String usRegCurrent;
	private String usRegCurrentLabel;
	private String usRegCurrentDate;
	private String usRegProposed;
	private String usRegProposedLabel;
	private String readBySnc;
	private String readBySncDate;
	private String sncRating;
	private String sncRatingLabel;
	private String sncRatingFacility;
	private String designatedByDirector;
	private String naturalResSector;
	private String esgRisk;
	private String monitoredSector;
	private String passWatchCurrent;
	private String passWatchCurrentDate;
	private String passWatchProposed;
	private String warningCurrent;
	private String warningCurrentDate;
	private String warningProposed;
	private String biNotes;

	//From Pipeline Deals
	private String borrowerName;
	private String snpRating;
	private String snpRatingLabel;
	private String moodyRating;
	private String moodyRatingLabel;
	private String snpOutlook;
	private String snpOutlookLabel;
	private String moodyOutlook;
	private String moodyOutlookLabel;
	
	//Getters & Setters
	public int getPipelineId() {
		return pipelineId;
	}
	public int getAdditionalBorrowerId() {
		return additionalBorrowerId;
	}
	public void setAdditionalBorrowerId(int additionalBorrowerId) {
		this.additionalBorrowerId = additionalBorrowerId;
	}
	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}
	public int getApplicationNumber() {
		return applicationNumber;
	}
	public void setApplicationNumber(int applicationNumber) {
		this.applicationNumber = applicationNumber;
	}
	public String getSunId() {
		return sunId;
	}
	public void setSunId(String sunId) {
		this.sunId = sunId;
	}
	public String getSmunId() {
		return smunId;
	}
	public void setSmunId(String smunId) {
		this.smunId = smunId;
	}
	public String getPrimarySmics() {
		return primarySmics;
	}
	public void setPrimarySmics(String primarySmics) {
		this.primarySmics = primarySmics;
	}
	public String getSmbcRatingCredit() {
		return smbcRatingCredit;
	}
	public void setSmbcRatingCredit(String smbcRatingCredit) {
		this.smbcRatingCredit = smbcRatingCredit;
	}
	public String getSmbcRatingCreditLabel() {
		return smbcRatingCreditLabel;
	}
	public void setSmbcRatingCreditLabel(String smbcRatingCreditLabel) {
		this.smbcRatingCreditLabel = smbcRatingCreditLabel;
	}
	public String getSmbcRatingProposed() {
		return smbcRatingProposed;
	}
	public void setSmbcRatingProposed(String smbcRatingProposed) {
		this.smbcRatingProposed = smbcRatingProposed;
	}
	public String getSmbcRatingProposedLabel() {
		return smbcRatingProposedLabel;
	}
	public void setSmbcRatingProposedLabel(String smbcRatingProposedLabel) {
		this.smbcRatingProposedLabel = smbcRatingProposedLabel;
	}
	public String getLeverageLendCurrent() {
		return leverageLendCurrent;
	}
	public void setLeverageLendCurrent(String leverageLendCurrent) {
		this.leverageLendCurrent = leverageLendCurrent;
	}
	public String getLeverageLendProposed() {
		return leverageLendProposed;
	}
	public void setLeverageLendProposed(String leverageLendProposed) {
		this.leverageLendProposed = leverageLendProposed;
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
	public String getMarketCapitalization() {
		return marketCapitalization;
	}
	public void setMarketCapitalization(String marketCapitalization) {
		this.marketCapitalization = marketCapitalization;
	}
	public String getUsRegCurrent() {
		return usRegCurrent;
	}
	public void setUsRegCurrent(String usRegCurrent) {
		this.usRegCurrent = usRegCurrent;
	}
	public String getUsRegCurrentLabel() {
		return usRegCurrentLabel;
	}
	public void setUsRegCurrentLabel(String usRegCurrentLabel) {
		this.usRegCurrentLabel = usRegCurrentLabel;
	}
	public String getUsRegCurrentDate() {
		return usRegCurrentDate;
	}
	public void setUsRegCurrentDate(String usRegCurrentDate) {
		this.usRegCurrentDate = usRegCurrentDate;
	}
	public String getUsRegProposed() {
		return usRegProposed;
	}
	public void setUsRegProposed(String usRegProposed) {
		this.usRegProposed = usRegProposed;
	}
	public String getUsRegProposedLabel() {
		return usRegProposedLabel;
	}
	public void setUsRegProposedLabel(String usRegProposedLabel) {
		this.usRegProposedLabel = usRegProposedLabel;
	}
	public String getReadBySnc() {
		return readBySnc;
	}
	public void setReadBySnc(String readBySnc) {
		this.readBySnc = readBySnc;
	}
	public String getReadBySncDate() {
		return readBySncDate;
	}
	public void setReadBySncDate(String readBySncDate) {
		this.readBySncDate = readBySncDate;
	}
	public String getSncRating() {
		return sncRating;
	}
	public void setSncRating(String sncRating) {
		this.sncRating = sncRating;
	}
	public String getSncRatingLabel() {
		return sncRatingLabel;
	}
	public void setSncRatingLabel(String sncRatingLabel) {
		this.sncRatingLabel = sncRatingLabel;
	}
	public String getSncRatingFacility() {
		return sncRatingFacility;
	}
	public void setSncRatingFacility(String sncRatingFacility) {
		this.sncRatingFacility = sncRatingFacility;
	}
	public String getDesignatedByDirector() {
		return designatedByDirector;
	}
	public void setDesignatedByDirector(String designatedByDirector) {
		this.designatedByDirector = designatedByDirector;
	}
	public String getNaturalResSector() {
		return naturalResSector;
	}
	public void setNaturalResSector(String naturalResSector) {
		this.naturalResSector = naturalResSector;
	}
	public String getEsgRisk() {
		return esgRisk;
	}
	public void setEsgRisk(String esgRisk) {
		this.esgRisk = esgRisk;
	}
	public String getMonitoredSector() {
		return monitoredSector;
	}
	public void setMonitoredSector(String monitoredSector) {
		this.monitoredSector = monitoredSector;
	}
	public String getPassWatchCurrent() {
		return passWatchCurrent;
	}
	public void setPassWatchCurrent(String passWatchCurrent) {
		this.passWatchCurrent = passWatchCurrent;
	}
	public String getPassWatchCurrentDate() {
		return passWatchCurrentDate;
	}
	public void setPassWatchCurrentDate(String passWatchCurrentDate) {
		this.passWatchCurrentDate = passWatchCurrentDate;
	}
	public String getPassWatchProposed() {
		return passWatchProposed;
	}
	public void setPassWatchProposed(String passWatchProposed) {
		this.passWatchProposed = passWatchProposed;
	}
	public String getWarningCurrent() {
		return warningCurrent;
	}
	public void setWarningCurrent(String warningCurrent) {
		this.warningCurrent = warningCurrent;
	}
	public String getWarningCurrentDate() {
		return warningCurrentDate;
	}
	public void setWarningCurrentDate(String warningCurrentDate) {
		this.warningCurrentDate = warningCurrentDate;
	}
	public String getWarningProposed() {
		return warningProposed;
	}
	public void setWarningProposed(String warningProposed) {
		this.warningProposed = warningProposed;
	}
	public String getBiNotes() {
		return biNotes;
	}
	public void setBiNotes(String biNotes) {
		this.biNotes = biNotes;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
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
	
	
	
	
}
