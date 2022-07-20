package com.smbc.lad.entity.pipeline;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.smbc.lad.entity.lookup.PMGStatusEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * Entity class to read/update data from/to table 'pipeline_deal_workflow'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_deal_workflow")
public class DealWorkflowEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	@Column(name = "sun_id")
	private String sunId;
	
	@Column(name = "dealNo")
	private String dealNo;
	
	@Column(name = "exposure")
	private String exposure;
	
	@Column(name = "tsd")
	private String tsd;
	
	@Column(name = "spdgb")
	private String spdgb;
	
	@Column(name = "pmg_status")
	private String pmgStatus;
	
	@Column(name = "application_deadline")
	private Date applicationDeadline;
	
	@Column(name = "gbr_circulation_pmg")
	private Date gbrCirculationByPMG;
	
	@Column(name = "deal_notes")
	private String dealNotes;

	@OneToOne
	@JoinColumn(name = "pmg_status", referencedColumnName="id",insertable = false,updatable = false)
	private PMGStatusEntity pmgStatusEntity;
	
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

	public String getDealNo() {
		return dealNo;
	}

	public void setDealNo(String dealNo) {
		this.dealNo = dealNo;
	}

	public String getExposure() {
		return exposure;
	}

	public void setExposure(String exposure) {
		this.exposure = exposure;
	}

	public String getTsd() {
		return tsd;
	}

	public void setTsd(String tsd) {
		this.tsd = tsd;
	}

	public String getSpdgb() {
		return spdgb;
	}

	public void setSpdgb(String spdgb) {
		this.spdgb = spdgb;
	}

	public String getPmgStatus() {
		return pmgStatus;
	}

	public void setPmgStatus(String pmgStatus) {
		this.pmgStatus = pmgStatus;
	}

	public Date getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	public Date getGbrCirculationByPMG() {
		return gbrCirculationByPMG;
	}

	public void setGbrCirculationByPMG(Date gbrCirculationByPMG) {
		this.gbrCirculationByPMG = gbrCirculationByPMG;
	}

	public PMGStatusEntity getPmgStatusEntity() {
		return pmgStatusEntity;
	}

	public void setPmgStatusEntity(PMGStatusEntity pmgStatusEntity) {
		this.pmgStatusEntity = pmgStatusEntity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDealNotes() {
		return dealNotes;
	}

	public void setDealNotes(String dealNotes) {
		this.dealNotes = dealNotes;
	}
}

