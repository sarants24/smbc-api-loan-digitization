package com.smbc.lad.entity.pipeline;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.smbc.lad.entity.lookup.MoodysOutlookEntity;
import com.smbc.lad.entity.lookup.MoodysRatingEntity;
import com.smbc.lad.entity.lookup.PassWatchEntity;
import com.smbc.lad.entity.lookup.SNPOutlookEntity;
import com.smbc.lad.entity.lookup.SNPRatingEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * Entity class to read/update data from/to table 'pipeline_deals_credit'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_deals_credit")
//@SecondaryTable(name = "")
public class PipelineDealsCreditEntity {
	
	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	@Column(name = "sun_id")
	private String sunId;
	
	@Column(name = "application_number")
	private int applicationNumber;
	
	@Column(name = "catf")
	private String catf;
	
	@Column(name = "target_catf_date")
	private Date targetCatfDate;
	
	@Column(name = "mdpr")
	private String mdpr; 
	
	@Column(name = "mnpi")
	private String mnpi; 
	
	@Column(name = "smun_id")
	private String smun_id; 
	
	@Column(name = "borrower_credit_grade")
	private String borrowerCreditGrade; 
	
	@Column(name = "snp_rating")
	private String snpRating; 
	
	@Column(name = "snp_outlook")
	private String snpOutlook; 
	
	@Column(name = "moody_rating")
	private String moodyRating; 
	
	@Column(name = "moody_outlook")
	private String moodyOutlook; 
	
	@Column(name = "pass_watch")
	private String passWatch; 
	 
	@OneToOne
	@JoinColumn(name = "snp_rating", referencedColumnName="id",insertable = false,updatable = false)
	private SNPRatingEntity sNPRatingEntity;
	
	@OneToOne
	@JoinColumn(name = "snp_outlook", referencedColumnName="id",insertable = false,updatable = false)
	private SNPOutlookEntity sNPOutlookEntity;
	
	@OneToOne
	@JoinColumn(name = "moody_rating", referencedColumnName="id",insertable = false,updatable = false)
	private MoodysRatingEntity moodysRatingEntity;
	
	@OneToOne
	@JoinColumn(name = "moody_outlook", referencedColumnName="id",insertable = false,updatable = false)
	private MoodysOutlookEntity moodysOutlookEntity;
	
	@OneToOne
	@JoinColumn(name = "pass_watch", referencedColumnName="id",insertable = false,updatable = false)
	private PassWatchEntity passWatchEntity;

	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getSunId() {
		return sunId;
	}

	public void setSunId(String sunId) {
		this.sunId = sunId;
	}

	public int getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(int applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getCatf() {
		return catf;
	}

	public void setCatf(String catf) {
		this.catf = catf;
	}

	public Date getTargetCatfDate() {
		return targetCatfDate;
	}

	public void setTargetCatfDate(Date targetCatfDate) {
		this.targetCatfDate = targetCatfDate;
	}

	public String getMdpr() {
		return mdpr;
	}

	public void setMdpr(String mdpr) {
		this.mdpr = mdpr;
	}

	public String getMnpi() {
		return mnpi;
	}

	public void setMnpi(String mnpi) {
		this.mnpi = mnpi;
	}

	public String getSmun_id() {
		return smun_id;
	}

	public void setSmun_id(String smun_id) {
		this.smun_id = smun_id;
	}

	public String getBorrowerCreditGrade() {
		return borrowerCreditGrade;
	}

	public void setBorrowerCreditGrade(String borrowerCreditGrade) {
		this.borrowerCreditGrade = borrowerCreditGrade;
	}

	public String getSnpRating() {
		return snpRating;
	}

	public void setSnpRating(String snpRating) {
		this.snpRating = snpRating;
	}

	public String getSnpOutlook() {
		return snpOutlook;
	}

	public void setSnpOutlook(String snpOutlook) {
		this.snpOutlook = snpOutlook;
	}

	public String getMoodyRating() {
		return moodyRating;
	}

	public void setMoodyRating(String moodyRating) {
		this.moodyRating = moodyRating;
	}

	public String getMoodyOutlook() {
		return moodyOutlook;
	}

	public void setMoodyOutlook(String moodyOutlook) {
		this.moodyOutlook = moodyOutlook;
	}

	public String getPassWatch() {
		return passWatch;
	}

	public void setPassWatch(String passWatch) {
		this.passWatch = passWatch;
	}

	public SNPRatingEntity getsNPRatingEntity() {
		return sNPRatingEntity;
	}

	public void setsNPRatingEntity(SNPRatingEntity sNPRatingEntity) {
		this.sNPRatingEntity = sNPRatingEntity;
	}

	public SNPOutlookEntity getsNPOutlookEntity() {
		return sNPOutlookEntity;
	}

	public void setsNPOutlookEntity(SNPOutlookEntity sNPOutlookEntity) {
		this.sNPOutlookEntity = sNPOutlookEntity;
	}

	public MoodysRatingEntity getMoodysRatingEntity() {
		return moodysRatingEntity;
	}

	public void setMoodysRatingEntity(MoodysRatingEntity moodysRatingEntity) {
		this.moodysRatingEntity = moodysRatingEntity;
	}

	public MoodysOutlookEntity getMoodysOutlookEntity() {
		return moodysOutlookEntity;
	}

	public void setMoodysOutlookEntity(MoodysOutlookEntity moodysOutlookEntity) {
		this.moodysOutlookEntity = moodysOutlookEntity;
	}

	public PassWatchEntity getPassWatchEntity() {
		return passWatchEntity;
	}

	public void setPassWatchEntity(PassWatchEntity passWatchEntity) {
		this.passWatchEntity = passWatchEntity;
	}

		
}

