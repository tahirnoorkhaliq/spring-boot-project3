package com.tahir.darkcodder.assignment.four.pojo;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1481330575079652416L;

	private String employeeUUId;
	private long employeeId;
	private String employeeName;
	private String employeeEmail;
	private String employeeLocation;

	public String getEmployeeUUId() {
		return employeeUUId;
	}

	public void setEmployeeUUId(String employeeUUId) {
		this.employeeUUId = employeeUUId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
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

	@Override
	public String toString() {
		return "EmployeeDTO [employeeUUId=" + employeeUUId + ", employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", employeeEmail=" + employeeEmail + ", employeeLocation=" + employeeLocation + "]";
	}
	
	

}
