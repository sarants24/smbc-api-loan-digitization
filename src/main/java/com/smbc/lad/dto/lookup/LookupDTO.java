package com.smbc.lad.dto.lookup;

public class LookupDTO {

	private String id;
	private String description;
	
	public LookupDTO(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

