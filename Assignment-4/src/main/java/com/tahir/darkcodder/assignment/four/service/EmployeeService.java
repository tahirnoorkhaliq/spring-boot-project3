package com.tahir.darkcodder.assignment.four.service;

import java.util.List;

import com.tahir.darkcodder.assignment.four.pojo.EmployeeDTO;

public interface EmployeeService {
	EmployeeDTO creteEmployee(EmployeeDTO empDTO);
	List<EmployeeDTO> getEmployeeDetails();
	EmployeeDTO findbyEmployeeId(long employeeId);

}
