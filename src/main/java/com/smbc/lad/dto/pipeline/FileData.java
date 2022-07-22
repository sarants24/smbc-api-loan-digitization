package com.smbc.lad.dto.pipeline;

public class FileData {

	private int id;
	private int pipelineId;
	private String fileName;
	private String fileType;
	private String fileExtension;
	private String fileExtensionMetadata;
	private byte[] fileData;
	private String fileBase64Data;
	private String createdTimestamp;
	
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
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	public String getFileExtensionMetadata() {
		return fileExtensionMetadata;
	}

	public void setFileExtensionMetadata(String fileExtensionMetadata) {
		this.fileExtensionMetadata = fileExtensionMetadata;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	public String getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(String createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	public String getFileBase64Data() {
		return fileBase64Data;
	}
	public void setFileBase64Data(String fileBase64Data) {
		this.fileBase64Data = fileBase64Data;
	}
}
