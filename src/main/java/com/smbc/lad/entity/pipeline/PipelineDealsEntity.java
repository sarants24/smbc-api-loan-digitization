package com.smbc.lad.entity.pipeline;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.smbc.lad.entity.lookup.ApplicationStatusEntity;
import com.smbc.lad.entity.lookup.ApplicationTypeEntity;
import com.smbc.lad.entity.lookup.CategoryEntity;
import com.smbc.lad.entity.lookup.DepartmentsEntity;
import com.smbc.lad.entity.lookup.EmployeeMasterEntity;
import com.smbc.lad.entity.lookup.SubCategoryEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * Entity class to read/update data from/to table 'pipeline_deals'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "pipeline_deals")
//@SecondaryTable(name = "")
public class PipelineDealsEntity {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "borrower_name")
	private String borrowerName;
	
	@Column(name = "parent_name")
	private String parentName;
	
	@Column(name = "sun_id")
	private String sunId;
	

	@Column(name = "parent_id")
	private String parentId;
	
	@Column(name = "group_id")
	private String groupId;
	
	@Column(name = "deal_name")
	private String dealName;
	
	@Column(name = "relation_manager_id")
	private int relationManagerId;
	
	@Column(name = "fo_analyst_id")
	private int foAnalystId;
	
	@Column(name = "dept_id")
	private String departmentId;
	
	@Column(name = "application_status_id")
	private String applicationStatusId;
	
	@Column(name = "category_id")
	private String categoryId;
	
	@Column(name = "sub_category_id")
	private String subCategoryId;
	
	@Column(name = "application_type")
	private String applicationType;
	
	@Column(name = "activity_status")
	private String activityStatus;
	
	@OneToOne
	@JoinColumn(name = "application_type", referencedColumnName="id",insertable = false,updatable = false)
	private ApplicationTypeEntity applicationTypeEntity;
	
	@Column(name = "expected_closing_date")
	private Date expectedClosingDate;
	
	@OneToOne
	@JoinColumn(name = "relation_manager_id", referencedColumnName="code",insertable = false,updatable = false)
	private EmployeeMasterEntity relationManagerName;
	
	@OneToOne
	@JoinColumn(name = "fo_analyst_id", referencedColumnName="code",insertable = false,updatable = false)
	private EmployeeMasterEntity foAnalystName;
	
	@OneToOne
	@JoinColumn(name = "dept_id", referencedColumnName="id",insertable = false,updatable = false)
	private DepartmentsEntity departmentsEntity;
	
	@OneToOne
	@JoinColumn(name = "application_status_id", referencedColumnName="id",insertable = false,updatable = false)
	private ApplicationStatusEntity applicationStatusEntity;
	
	@OneToOne
	@JoinColumn(name = "category_id", referencedColumnName="id",insertable = false,updatable = false)
	private CategoryEntity categoryEntity;
	
	@OneToOne
	@JoinColumn(name = "sub_category_id", referencedColumnName="id",insertable = false,updatable = false)
	private SubCategoryEntity subCategoryEntity;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getSunId() {
		return sunId;
	}

	public void setSunId(String sunId) {
		this.sunId = sunId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getDealName() {
		return dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	public int getRelationManagerId() {
		return relationManagerId;
	}

	public void setRelationManagerId(int relationManagerId) {
		this.relationManagerId = relationManagerId;
	}

	public int getFoAnalystId() {
		return foAnalystId;
	}

	public void setFoAnalystId(int foAnalystId) {
		this.foAnalystId = foAnalystId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getApplicationStatusId() {
		return applicationStatusId;
	}

	public void setApplicationStatusId(String applicationStatusId) {
		this.applicationStatusId = applicationStatusId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(String subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public Date getExpectedClosingDate() {
		return expectedClosingDate;
	}

	public void setExpectedClosingDate(Date expectedClosingDate) {
		this.expectedClosingDate = expectedClosingDate;
	}

	public EmployeeMasterEntity getRelationManagerName() {
		return relationManagerName;
	}

	public void setRelationManagerName(EmployeeMasterEntity relationManagerName) {
		this.relationManagerName = relationManagerName;
	}

	public EmployeeMasterEntity getFoAnalystName() {
		return foAnalystName;
	}

	public void setFoAnalystName(EmployeeMasterEntity foAnalystName) {
		this.foAnalystName = foAnalystName;
	}

	public DepartmentsEntity getDepartmentsEntity() {
		return departmentsEntity;
	}

	public void setDepartmentsEntity(DepartmentsEntity departmentsEntity) {
		this.departmentsEntity = departmentsEntity;
	}

	public ApplicationStatusEntity getApplicationStatusEntity() {
		return applicationStatusEntity;
	}

	public void setApplicationStatusEntity(ApplicationStatusEntity applicationStatusEntity) {
		this.applicationStatusEntity = applicationStatusEntity;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	public SubCategoryEntity getSubCategoryEntity() {
		return subCategoryEntity;
	}

	public void setSubCategoryEntity(SubCategoryEntity subCategoryEntity) {
		this.subCategoryEntity = subCategoryEntity;
	}
	
	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public ApplicationTypeEntity getApplicationTypeEntity() {
		return applicationTypeEntity;
	}

	public void setApplicationTypeEntity(ApplicationTypeEntity applicationTypeEntity) {
		this.applicationTypeEntity = applicationTypeEntity;
	}

	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}
}

