package com.smbc.lad.entity.pipeline;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * Entity class to read/update data from/to table 'pipeline_capital_request_exposure'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_capital_request_exposure")
public class CapitalRequestExposureEntity {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	@Column(name = "facility_description")
	private String facilityDescription;
	
	@Column(name = "maturity_description")
	private String maturityDescription;
	
	@Column(name = "smbc_commitment")
	private String smbcCommitment;
	
	@Column(name = "facility_level_rarora")
	private String facilityLevelRarora;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getFacilityDescription() {
		return facilityDescription;
	}

	public void setFacilityDescription(String facilityDescription) {
		this.facilityDescription = facilityDescription;
	}

	public String getMaturityDescription() {
		return maturityDescription;
	}

	public void setMaturityDescription(String maturityDescription) {
		this.maturityDescription = maturityDescription;
	}

	public String getSmbcCommitment() {
		return smbcCommitment;
	}

	public void setSmbcCommitment(String smbcCommitment) {
		this.smbcCommitment = smbcCommitment;
	}

	public String getFacilityLevelRarora() {
		return facilityLevelRarora;
	}

	public void setFacilityLevelRarora(String facilityLevelRarora) {
		this.facilityLevelRarora = facilityLevelRarora;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}

