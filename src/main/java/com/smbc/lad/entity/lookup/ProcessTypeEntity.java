package com.smbc.lad.entity.lookup;

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
 * Entity class to read data from table 'lk_process_type'
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "lk_process_type")
public class ProcessTypeEntity  extends LookupBaseEntity {
	@Id
	@Column(name = "id")
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
