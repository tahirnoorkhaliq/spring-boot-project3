package com.tahir.darkcodder.api.assignment.crud.stub;

import java.security.KeyException;
import java.util.List;

import com.tahir.darkcodder.api.assignment.crud.pojo.EmployeeDTO;



public interface EmployeeService {
	EmployeeDTO creteEmployee(EmployeeDTO empDTO);
	List<EmployeeDTO> getEmployeeDetails();
	EmployeeDTO findbyEmployeeId(long employeeId);
	EmployeeDTO deleteEmployee(long employeeId) throws KeyException;
	EmployeeDTO updateEmployee(long employeeId,EmployeeDTO employeeDTO) throws KeyException;

}
