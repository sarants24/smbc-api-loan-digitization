package com.smbc.lad.entity.pipeline;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saravanan T
 * @since May 2022
 * 
 * Entity class to read/update data from/to table 'pipeline_analysis_peer_ltm'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_analysis_peer_ltm")
public class AnalysisPeerLTMEntity {

	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;

	@Column(name = "peer_analysis")
	private String peerAnalysis;

	@Column(name = "long_term_analysis")
	private String longTermAnalysis;

	@Column(name = "analysis_comparison")
	private String analysisComparison;

	public int getPipelineId() {
		return pipelineId;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "pipeline_id", referencedColumnName="pipeline_id",insertable = false,updatable = false)
	private List<AnalysisPeerFilesLTMEntity> analysisPeerFilesLTMEntity;
	
	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getPeerAnalysis() {
		return peerAnalysis;
	}

	public void setPeerAnalysis(String peerAnalysis) {
		this.peerAnalysis = peerAnalysis;
	}

	public String getLongTermAnalysis() {
		return longTermAnalysis;
	}

	public void setLongTermAnalysis(String longTermAnalysis) {
		this.longTermAnalysis = longTermAnalysis;
	}

	public String getAnalysisComparison() {
		return analysisComparison;
	}

	public void setAnalysisComparison(String analysisComparison) {
		this.analysisComparison = analysisComparison;
	}

	public List<AnalysisPeerFilesLTMEntity> getAnalysisPeerFilesLTMEntity() {
		return analysisPeerFilesLTMEntity;
	}

	public void setAnalysisPeerFilesLTMEntity(List<AnalysisPeerFilesLTMEntity> analysisPeerFilesLTMEntity) {
		this.analysisPeerFilesLTMEntity = analysisPeerFilesLTMEntity;
	}

}

