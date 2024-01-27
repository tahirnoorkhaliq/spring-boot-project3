package com.tahir.darkcodder.employee.details.model;

import java.io.Serializable;

public class EmployeeDTO implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2408507953306366596L;
	private String employeeId;
	private String name;	
	private String email;
	private String imageUrl;
	private String description;
	private Long cellNumber;	
	private String password;
	private String encryptedPassword;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	
	
	

}
