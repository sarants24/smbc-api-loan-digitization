package com.smbc.lad.entity.pipeline;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.smbc.lad.entity.lookup.RegulatoryRatingEntity;
import com.smbc.lad.entity.lookup.SMBCRatingEntity;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * Entity class to read/update data from/to table 'pipeline_deals_borrowerinfo'
 *
 */
@MappedSuperclass
public class BorrowerInfoBaseEntity {

	@Column(name = "sun_id")
	private String sunId;
	
	@Column(name = "smun_id")
	private String smunId;

	@Column(name = "primary_smics")
	private String primarySmics;

	@Column(name = "smbc_rating_credit")
	private String smbcRatingCredit;

	@Column(name = "smbc_rating_proposed")
	private String smbcRatingProposed;

	@Column(name = "leverage_lend_current")
	private String leverageLendCurrent;

	@Column(name = "leverage_lend_proposed")
	private String leverageLendProposed;

	@Column(name = "market_capitalization")
	private String marketCapitalization;

	@Column(name = "us_reg_current")
	private String usRegCurrent;

	@Column(name = "us_reg_current_date")
	private Date usRegCurrentDate;

	@Column(name = "us_reg_proposed")
	private String usRegProposed;

	@Column(name = "read_by_snc")
	private String readBySnc;

	@Column(name = "read_by_snc_date")
	private Date readBySncDate;

	@Column(name = "snc_rating")
	private String sncRating;
	
	@Column(name = "snc_rating_facility")
	private String sncRatingFacility;

	@Column(name = "designated_by_director")
	private String designatedByDirector;

	@Column(name = "natural_res_sector")
	private String naturalResSector;

	@Column(name = "esg_risk")
	private String esgRisk;

	@Column(name = "monitored_sector")
	private String monitoredSector;

	@Column(name = "pass_watch_current")
	private String passWatchCurrent;

	@Column(name = "pass_watch_current_date")
	private Date passWatchCurrentDate;

	@Column(name = "pass_watch_proposed")
	private String passWatchProposed;

	@Column(name = "warning_current")
	private String warningCurrent;

	@Column(name = "warning_current_date")
	private Date warningCurrentDate;

	@Column(name = "warning_proposed")
	private String warningProposed;

	@Column(name = "borrower_info_notes")
	private String biNotes;
	
	//Dropdown Labels
	@OneToOne
	@JoinColumn(name = "smbc_rating_credit", referencedColumnName="id",insertable = false,updatable = false)
	private SMBCRatingEntity smbcRatingCurrentEntity;
	
	@OneToOne
	@JoinColumn(name = "smbc_rating_proposed", referencedColumnName="id",insertable = false,updatable = false)
	private SMBCRatingEntity smbcRatingProposedEntity;
	
	@OneToOne
	@JoinColumn(name = "us_reg_current", referencedColumnName="id",insertable = false,updatable = false)
	private RegulatoryRatingEntity usRegCurrentEntity;
	
	@OneToOne
	@JoinColumn(name = "us_reg_proposed", referencedColumnName="id",insertable = false,updatable = false)
	private RegulatoryRatingEntity usRegProposedEntity;
	
	@OneToOne
	@JoinColumn(name = "snc_rating", referencedColumnName="id",insertable = false,updatable = false)
	private RegulatoryRatingEntity sncRatingEntity;

	//Getters & Setters
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

	public String getSmbcRatingProposed() {
		return smbcRatingProposed;
	}

	public void setSmbcRatingProposed(String smbcRatingProposed) {
		this.smbcRatingProposed = smbcRatingProposed;
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

	public Date getUsRegCurrentDate() {
		return usRegCurrentDate;
	}

	public void setUsRegCurrentDate(Date usRegCurrentDate) {
		this.usRegCurrentDate = usRegCurrentDate;
	}

	public String getUsRegProposed() {
		return usRegProposed;
	}

	public void setUsRegProposed(String usRegProposed) {
		this.usRegProposed = usRegProposed;
	}

	public String getReadBySnc() {
		return readBySnc;
	}

	public void setReadBySnc(String readBySnc) {
		this.readBySnc = readBySnc;
	}

	public Date getReadBySncDate() {
		return readBySncDate;
	}

	public void setReadBySncDate(Date readBySncDate) {
		this.readBySncDate = readBySncDate;
	}

	public String getSncRating() {
		return sncRating;
	}

	public void setSncRating(String sncRating) {
		this.sncRating = sncRating;
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

	public Date getPassWatchCurrentDate() {
		return passWatchCurrentDate;
	}

	public void setPassWatchCurrentDate(Date passWatchCurrentDate) {
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

	public Date getWarningCurrentDate() {
		return warningCurrentDate;
	}

	public void setWarningCurrentDate(Date warningCurrentDate) {
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

	public SMBCRatingEntity getSmbcRatingCurrentEntity() {
		return smbcRatingCurrentEntity;
	}

	public void setSmbcRatingCurrentEntity(SMBCRatingEntity smbcRatingCurrentEntity) {
		this.smbcRatingCurrentEntity = smbcRatingCurrentEntity;
	}

	public SMBCRatingEntity getSmbcRatingProposedEntity() {
		return smbcRatingProposedEntity;
	}

	public void setSmbcRatingProposedEntity(SMBCRatingEntity smbcRatingProposedEntity) {
		this.smbcRatingProposedEntity = smbcRatingProposedEntity;
	}

	public RegulatoryRatingEntity getUsRegCurrentEntity() {
		return usRegCurrentEntity;
	}

	public void setUsRegCurrentEntity(RegulatoryRatingEntity usRegCurrentEntity) {
		this.usRegCurrentEntity = usRegCurrentEntity;
	}

	public RegulatoryRatingEntity getUsRegProposedEntity() {
		return usRegProposedEntity;
	}

	public void setUsRegProposedEntity(RegulatoryRatingEntity usRegProposedEntity) {
		this.usRegProposedEntity = usRegProposedEntity;
	}

	public RegulatoryRatingEntity getSncRatingEntity() {
		return sncRatingEntity;
	}

	public void setSncRatingEntity(RegulatoryRatingEntity sncRatingEntity) {
		this.sncRatingEntity = sncRatingEntity;
	}
	
	
}
