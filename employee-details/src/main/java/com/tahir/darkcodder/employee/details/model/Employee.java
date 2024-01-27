package com.tahir.darkcodder.employee.details.model;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8016644115609899596L;
	private String employeeId;
	private String name;
	private String imageUrl;
	private String description;
	private Long cellNumber;
	private String email;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(Long cellNumber) {
		this.cellNumber = cellNumber;
	}

}
