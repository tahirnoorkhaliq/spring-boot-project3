package com.tahir.darkcodder.movflex.model;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8876548910125275908L;

	
	@Email
	@NotNull(message = "Email Can't be empty")
	@Size(min=1,max=100, message = "Email Can't be empty")
	private String email;
	
	@Size(min = 4, max = 16, message = "Password Can't be less than 4 ot greater than 16 chars")
	@NotNull(message = "Password Can't be empty")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	}

}
