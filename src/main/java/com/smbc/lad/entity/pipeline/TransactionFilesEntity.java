package com.smbc.lad.entity.pipeline;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * Entity class to read/update data from/to table 'pipeline_transaction_background_files'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_transaction_background_files")
public class TransactionFilesEntity {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "file_type")
	private String fileType;
	
	@Column(name = "file_extension")
	private String fileExtension;
	
	@Lob
	@Column(name = "file_data")
	private byte[] fileData;

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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}		
}

