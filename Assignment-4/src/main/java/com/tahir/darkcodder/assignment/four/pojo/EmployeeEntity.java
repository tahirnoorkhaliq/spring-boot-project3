package com.tahir.darkcodder.assignment.four.pojo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WEmployees")
public class EmployeeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5712673039817292693L;

	@Id
	private long employeeId;
	@Column(nullable = false, unique = true)
	private String employeeUUId;
	@Column(nullable = false, length = 100)
	private String employeeName;
	@Column(nullable = false, length = 100, unique = true)
	private String employeeEmail;
	@Column(nullable = false, length = 100)
	private String employeeLocation;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getEmployeeUUId() {
		return employeeUUId;
	}

	public void setEmployeeUUId(String employeeUUId) {
		this.employeeUUId = employeeUUId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeLocation() {
		return employeeLocation;
	}

	public void setEmployeeLocation(String employeeLocation) {
		this.employeeLocation = employeeLocation;
	}

}
