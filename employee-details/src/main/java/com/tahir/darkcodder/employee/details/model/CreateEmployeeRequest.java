package com.tahir.darkcodder.employee.details.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateEmployeeRequest {

	// private String uUid;
	@NotNull(message = "Name Can't be empty")
	@Size(min=2,message = "Name Can't be less than 2 chars")
	private String name;
	@Email
	private String email;
	private String imageUrl;
	private String description;
	private Long cellNumber;
	@NotNull(message = "password Can't be empty")
	@Size(min=8, max=16,message = "Password  must be 8 to 16 chars long")
	private String password;

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

	

}
