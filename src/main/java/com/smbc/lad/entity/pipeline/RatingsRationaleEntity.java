package com.smbc.lad.entity.pipeline;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * Entity class to read/update data from/to table 'pipeline_ratings_rationale'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_ratings_rationale")
public class RatingsRationaleEntity {

	@Id
	@Column(name = "pipeline_id")
	private int pipelineId;
	
	@Column(name = "smbc_obligor_rating")
	private String smbcObligorRating;
	
	@Column(name = "rationale_to_support")
	private String rationaleToSupport;
	
	@Column(name = "risk_appetite")
	private String riskAppetite;
	
	@Column(name = "basic_strategy")
	private String basicStrategy;
	
	@Column(name = "action_plan")
	private String actionPlan;

	public int getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(int pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getSmbcObligorRating() {
		return smbcObligorRating;
	}

	public void setSmbcObligorRating(String smbcObligorRating) {
		this.smbcObligorRating = smbcObligorRating;
	}

	public String getRationaleToSupport() {
		return rationaleToSupport;
	}

	public void setRationaleToSupport(String rationaleToSupport) {
		this.rationaleToSupport = rationaleToSupport;
	}

	public String getRiskAppetite() {
		return riskAppetite;
	}

	public void setRiskAppetite(String riskAppetite) {
		this.riskAppetite = riskAppetite;
	}

	public String getBasicStrategy() {
		return basicStrategy;
	}

	public void setBasicStrategy(String basicStrategy) {
		this.basicStrategy = basicStrategy;
	}

	public String getActionPlan() {
		return actionPlan;
	}

	public void setActionPlan(String actionPlan) {
		this.actionPlan = actionPlan;
	}
					
}

