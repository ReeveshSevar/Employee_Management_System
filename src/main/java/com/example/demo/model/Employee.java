package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Emp7")
public class Employee {
	@Id
	private Integer eid;
	private String ename;
	private String edob;
	private String egen;
	private String email;
	private String pwd;
	private String edept;
	private Double esal;
	private Double hra;
	private Double da;
	private String edate;
	
}
