package com.smbc.lad.dto.lookup;

public class Company {

	private String smunId;
	private String companyName;
	
	
	public Company(String smunId, String companyName) {
		super();
		this.smunId = smunId;
		this.companyName = companyName;
	}
	
	public String getSmunId() {
		return smunId;
	}
	public void setSmunId(String smunId) {
		this.smunId = smunId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	
}

