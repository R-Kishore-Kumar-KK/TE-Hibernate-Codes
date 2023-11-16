package com.te.hibernatepractice.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "interns")
@Data
public class EntityInfo implements Serializable{

	public EntityInfo() {}
	
	@Column
	private String name;
	
	@Id
	@Column
	private Integer id;
	
	@Column
	private java.util.Date dob;
	
	@Column
	private String gender;
	
	@Column
	private String role;
	
	@Column
	private Long mobile;
	
	@Column
	private Double salary;
	
	@Column
	private Integer deptId;
	
	@Column
	private String blood_group;
	
	@Column
	private String email;
	
	@Column
	private Integer commission;
	
	@Column
	private Integer Reporting_Manager;
	
	@Column
	private java.util.Date Date_of_Join;

	
}
