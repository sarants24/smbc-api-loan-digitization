package com.smbc.lad.entity.pipeline;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.smbc.lad.entity.lookup.CompanyEntity;
import com.smbc.lad.entity.lookup.MoodysOutlookEntity;
import com.smbc.lad.entity.lookup.MoodysRatingEntity;
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
 * Entity class to read/update data from/to table 'pipeline_additional_borrowerinfo'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipelinedeals_additional_borrowerinfo")
public class AdditionalBorrowerInfoEntity extends BorrowerInfoBaseEntity {

	//pipeline_deals_parentinfo
	@Id
	@Column(name = "addttional_borrower_id")
	private int addtionalBorrowerId;
	
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	//pipeline_deals_credit
	@Column(name = "snp_rating")
	private String snpRating;
	
	@Column(name = "snp_outlook")
	private String snpOutlook;
	
	@Column(name = "moody_rating")
	private String moodyRating;
	
	@Column(name = "moody_outlook")
	private String moodyOutlook;
	
	//Dropdown Labels
	
	@OneToOne
	@JoinColumn(name = "smun_id", referencedColumnName="smun_id",insertable = false,updatable = false)
	private CompanyEntity companyEntity;
	
	@OneToOne
	@JoinColumn(name = "snp_rating", referencedColumnName="id",insertable = false,updatable = false)
	private SNPRatingEntity snpRatingEntity;
	
	@OneToOne
	@JoinColumn(name = "snp_outlook", referencedColumnName="id",insertable = false,updatable = false)
	private SNPOutlookEntity snpOutlookEntity;
	
	@OneToOne
	@JoinColumn(name = "moody_rating", referencedColumnName="id",insertable = false,updatable = false)
	private MoodysRatingEntity moodyRatingEntity;
	
	@OneToOne
	@JoinColumn(name = "moody_outlook", referencedColumnName="id",insertable = false,updatable = false)
	private MoodysOutlookEntity moodyOutlookEntity;

	//Getters & Setters
	public int getAddtionalBorrowerId() {
		return addtionalBorrowerId;
	}

	public void setAddtionalBorrowerId(int addtionalBorrowerId) {
		this.addtionalBorrowerId = addtionalBorrowerId;
	}
	
	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
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

	public SNPRatingEntity getSnpRatingEntity() {
		return snpRatingEntity;
	}

	public void setSnpRatingEntity(SNPRatingEntity snpRatingEntity) {
		this.snpRatingEntity = snpRatingEntity;
	}

	public SNPOutlookEntity getSnpOutlookEntity() {
		return snpOutlookEntity;
	}

	public void setSnpOutlookEntity(SNPOutlookEntity snpOutlookEntity) {
		this.snpOutlookEntity = snpOutlookEntity;
	}

	public MoodysRatingEntity getMoodyRatingEntity() {
		return moodyRatingEntity;
	}

	public void setMoodyRatingEntity(MoodysRatingEntity moodyRatingEntity) {
		this.moodyRatingEntity = moodyRatingEntity;
	}

	public MoodysOutlookEntity getMoodyOutlookEntity() {
		return moodyOutlookEntity;
	}

	public void setMoodyOutlookEntity(MoodysOutlookEntity moodyOutlookEntity) {
		this.moodyOutlookEntity = moodyOutlookEntity;
	}

	public CompanyEntity getCompanyEntity() {
		return companyEntity;
	}

	public void setCompanyEntity(CompanyEntity companyEntity) {
		this.companyEntity = companyEntity;
	}
		
}
