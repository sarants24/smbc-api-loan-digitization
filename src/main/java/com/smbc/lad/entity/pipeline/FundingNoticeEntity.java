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
 * @since April 2022
 * 
 * Entity class to read/update data from/to table 'pipeline_transaction_background'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_funding_notice")
//@SecondaryTable(name = "")
public class FundingNoticeEntity {

	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	@Column(name = "funding_notes")
	private String fundingNotes;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "pipeline_id", referencedColumnName="pipeline_id",insertable = false,updatable = false)
	private List<FundingTermsEntity> fundingTermsEntity;

	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getFundingNotes() {
		return fundingNotes;
	}

	public void setFundingNotes(String fundingNotes) {
		this.fundingNotes = fundingNotes;
	}

	public List<FundingTermsEntity> getFundingTermsEntity() {
		return fundingTermsEntity;
	}

	public void setFundingTermsEntity(List<FundingTermsEntity> fundingTermsEntity) {
		this.fundingTermsEntity = fundingTermsEntity;
	}
			
}

