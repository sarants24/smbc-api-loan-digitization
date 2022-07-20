package com.smbc.lad.entity.pipeline;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * Entity class to read/update data from/to table `pipeline_primary_request_facility'
 *
 */
@MappedSuperclass
public class RequestFacilityBaseEntity {

	@Column(name = "sun_id")
	private String sunId;

	@Column(name = "facilities")
	private String facilities;

	@Column(name = "unapplied_cash")
	private String unappliedCash;

	@Column(name = "tenor")
	private String tenor;

	@Column(name = "margin")
	private String margin;

	@Column(name = "drawn_pricing")
	private String drawnPricing;

	@Column(name = "outstanding_amount")
	private String outstandingAmount;

	@Column(name = "maturity_date")
	private Date maturityDate;

	public String getSunId() {
		return sunId;
	}

	public void setSunId(String sunId) {
		this.sunId = sunId;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getUnappliedCash() {
		return unappliedCash;
	}

	public void setUnappliedCash(String unappliedCash) {
		this.unappliedCash = unappliedCash;
	}

	public String getTenor() {
		return tenor;
	}

	public void setTenor(String tenor) {
		this.tenor = tenor;
	}

	public String getMargin() {
		return margin;
	}

	public void setMargin(String margin) {
		this.margin = margin;
	}

	public String getDrawnPricing() {
		return drawnPricing;
	}

	public void setDrawnPricing(String drawnPricing) {
		this.drawnPricing = drawnPricing;
	}

	public String getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(String outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

			
}
