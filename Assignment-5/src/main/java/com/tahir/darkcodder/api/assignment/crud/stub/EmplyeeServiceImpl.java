package com.tahir.darkcodder.api.assignment.crud.stub;

import java.security.KeyException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.management.openmbean.KeyAlreadyExistsException;

import org.springframework.stereotype.Service;

import com.tahir.darkcodder.api.assignment.crud.pojo.EmployeeDTO;

@Service
public class EmplyeeServiceImpl implements EmployeeService {

	private static Map<Long, EmployeeDTO> emp = new HashMap<>();

	@Override
	public EmployeeDTO creteEmployee(EmployeeDTO empDTO) {
		System.out.println(emp);
		System.out.println(emp.get(empDTO.getEmployeeId()));
		if (null == emp.get(empDTO.getEmployeeId())) {
			emp.put(empDTO.getEmployeeId(), empDTO);
			return empDTO;
		} else {
			throw new KeyAlreadyExistsException();
		}

	}

	@Override
	public List<EmployeeDTO> getEmployeeDetails() {
		List<EmployeeDTO> employeeDTO = emp.values().stream().collect(Collectors.toList());
		return employeeDTO;
	}

	@Override
	public EmployeeDTO findbyEmployeeId(long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO deleteEmployee(long employeeId) throws KeyException {
		if (null != emp.get(employeeId)) {			
			return emp.remove(employeeId);
		} else {
			throw new KeyException("Employee Id not found");
		}
	}

	@Override
	public EmployeeDTO updateEmployee(long employeeId, EmployeeDTO empDTO) throws KeyException {
		if (null != emp.get(employeeId)) {
			emp.put(employeeId, empDTO);
			return empDTO;
		} else {
			throw new KeyException("Employee Id not found");
		}
	}

}
