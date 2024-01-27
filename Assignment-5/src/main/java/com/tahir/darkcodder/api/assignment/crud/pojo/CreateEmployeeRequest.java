package com.tahir.darkcodder.api.assignment.crud.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateEmployeeRequest {

	@NotNull(message = "Name Can't be empty")
	private long employeeId;
	// private String uUid;
	@NotNull(message = "Employee Name Can't be empty")
	@Size(min = 2, message = "Employee Name Can't be less than 2 chars")
	private String employeeName;
	@Email
	private String employeeEmail;
	@NotNull(message = "Employee Location Can't be empty")
	private String employeeLocation;
	private String errors;

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
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
		return "CreateEmployeeRequest [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeEmail="
				+ employeeEmail + ", employeeLocation=" + employeeLocation + "]";
	}

}
