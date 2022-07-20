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
 * Entity class to read/update data from/to table 'pipeline_relation_organization'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_relation_organization")
//@SecondaryTable(name = "")
public class RelationOrganizationEntity {

	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	@Column(name = "relationship_summary")
	private String relationshipSummary;
	
	@Column(name = "organization_summary")
	private String organizationSummary;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "pipeline_id", referencedColumnName="pipeline_id",insertable = false,updatable = false)
	private List<FileDataEntity> fileDataEntity;
	
	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getRelationshipSummary() {
		return relationshipSummary;
	}

	public void setRelationshipSummary(String relationshipSummary) {
		this.relationshipSummary = relationshipSummary;
	}

	public String getOrganizationSummary() {
		return organizationSummary;
	}

	public void setOrganizationSummary(String organizationSummary) {
		this.organizationSummary = organizationSummary;
	}

	public List<FileDataEntity> getFileDataEntity() {
		return fileDataEntity;
	}

	public void setFileDataEntity(List<FileDataEntity> fileDataEntity) {
		this.fileDataEntity = fileDataEntity;
	}
	
		
}

