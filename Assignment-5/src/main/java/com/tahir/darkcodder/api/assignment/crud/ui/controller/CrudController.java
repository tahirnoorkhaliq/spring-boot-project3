package com.tahir.darkcodder.api.assignment.crud.ui.controller;

import java.security.KeyException;
import java.util.List;

import javax.management.openmbean.KeyAlreadyExistsException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tahir.darkcodder.api.assignment.crud.pojo.CreateEmployeeRequest;
import com.tahir.darkcodder.api.assignment.crud.stub.EmployeeService;
import com.tahir.darkcodder.api.assignment.crud.pojo.EmployeeDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/assignment5")
public class CrudController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/status")
	public String employeeForm() {
		
		return "Crud API up and running";
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<List<EmployeeDTO>> fetchEmployeeDetails() {
				return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.getEmployeeDetails());
	}

	@PostMapping("/employee")
	public ResponseEntity<CreateEmployeeRequest> createEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest) {
		try {
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			EmployeeDTO employeeDTO = modelMapper.map(createEmployeeRequest, EmployeeDTO.class);
			EmployeeDTO createEmp = employeeService.creteEmployee(employeeDTO);
			CreateEmployeeRequest emp = modelMapper.map(createEmp, CreateEmployeeRequest.class);
			return ResponseEntity.status(HttpStatus.CREATED).body(emp);
		} catch (KeyAlreadyExistsException e) {
			createEmployeeRequest.setErrors("Record already Exists with this Id");			
			return ResponseEntity.status(HttpStatus.CONFLICT).body(createEmployeeRequest);
		}
		
	}
	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<CreateEmployeeRequest> deleteEmployee(@PathVariable Long employeeId) {
				try {
					ModelMapper modelMapper = new ModelMapper();
					 EmployeeDTO empDTO = employeeService.deleteEmployee(employeeId);
					 CreateEmployeeRequest emp = modelMapper.map(empDTO, CreateEmployeeRequest.class);
					return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).body(emp);
				} catch (KeyException e) {
					CreateEmployeeRequest emp=new CreateEmployeeRequest();
					emp.setErrors(e.getMessage());			
					return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(emp);
				}
	}
	
	@PutMapping("/update/{employeeId}")
	public ResponseEntity<CreateEmployeeRequest> deleteEmployee(@PathVariable Long employeeId,@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest) {
		try {
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			EmployeeDTO employeeDTO = modelMapper.map(createEmployeeRequest, EmployeeDTO.class);
			EmployeeDTO createEmp = employeeService.updateEmployee(employeeId, employeeDTO);
			CreateEmployeeRequest emp = modelMapper.map(createEmp, CreateEmployeeRequest.class);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(emp);
		} catch (KeyException e) {
			CreateEmployeeRequest emp=new CreateEmployeeRequest();
			emp.setErrors(e.getMessage());			
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(createEmployeeRequest);
		}
	}


}
