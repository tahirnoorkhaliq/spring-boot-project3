package com.tahir.darkcodder.employee.details.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.tahir.darkcodder.employee.details.model.Employee;
import com.tahir.darkcodder.employee.details.model.EmployeeDTO;

public interface EmployeeService extends UserDetailsService{
	EmployeeDTO creteEmployee(EmployeeDTO empDTO);
	EmployeeDTO getEmployeeDetailsByEmail(String email);
	List<EmployeeDTO> getEmployeeDetails();

}
