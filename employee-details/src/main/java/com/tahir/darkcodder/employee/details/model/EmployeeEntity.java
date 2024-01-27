package com.tahir.darkcodder.employee.details.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employees")
public class EmployeeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1377783203514091766L;

	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false,unique = true)
	private String employeeId;
	@Column(nullable = false,length = 100)
	private String name;
	@Column(nullable = false,length = 100,unique = true)
	private String email;
	private String imageUrl;
	private String description;
	@Column(nullable = false,length = 100)
	private Long cellNumber;
	private String password;
	@Column(nullable = false,length = 100)
	private String encryptedPassword;	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
}
