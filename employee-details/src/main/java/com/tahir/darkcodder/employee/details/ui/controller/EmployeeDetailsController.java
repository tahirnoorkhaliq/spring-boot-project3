package com.tahir.darkcodder.employee.details.ui.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tahir.darkcodder.employee.details.model.CreateEmployeeRequest;
import com.tahir.darkcodder.employee.details.model.Employee;
import com.tahir.darkcodder.employee.details.model.EmployeeDTO;
import com.tahir.darkcodder.employee.details.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class EmployeeDetailsController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	Environment env;
	// mvn spring-boot:run
	// -Dspring-boot:run.arguments=--spring.application.instance_id=abeer

	@GetMapping("/check/status")
	public String checkStatus() {
		return "I am up and Running" + env.getProperty("local.server.port");
	}

	@GetMapping("/fetch")
	public ResponseEntity<List<EmployeeDTO>> fetchEmployeeDetails() {
		/*
		 * List<Employee> employees = new ArrayList<>(); Employee emp = new Employee();
		 * emp.setEmployeeId(generateUUid()); emp.setName("Tahir Noor");
		 * emp.setImageUrl("https://i.ibb.co/0X4y5wZ/kanipash.jpg");
		 * emp.setDescription("This looks good"); emp.setCellNumber(9876543219L);
		 * employees.add(emp); emp = new Employee(); emp.setEmployeeId(generateUUid());
		 * emp.setName("Abeer Tahir");
		 * emp.setImageUrl("https://i.ibb.co/XtxZDfh/pashmana.jpg");
		 * emp.setDescription("My Daughter"); emp.setCellNumber(434343334l);
		 * employees.add(emp); emp = new Employee(); emp.setEmployeeId(generateUUid());
		 * emp.setName("Mehvish Tahir");
		 * emp.setImageUrl("https://i.ibb.co/7Jr37mQ/shahtosh.jpg");
		 * emp.setDescription("My Wife"); emp.setCellNumber(434343334l);
		 * employees.add(emp);
		 */
		List<EmployeeDTO> employees = employeeService.getEmployeeDetails();
		return ResponseEntity.status(HttpStatus.CREATED).body(employees);
	}

	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody CreateEmployeeRequest CreateEmployeeRequest) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		EmployeeDTO employeeDTO = modelMapper.map(CreateEmployeeRequest, EmployeeDTO.class);
		EmployeeDTO createEmp = employeeService.creteEmployee(employeeDTO);
		Employee emp = modelMapper.map(createEmp, Employee.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(emp);
	}
	@RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
		System.out.println("============handleOptions============");
		HttpHeaders headers=new HttpHeaders();
		headers.set("Access-Control-Allow-Origin", "*");
		headers.set("Access-Control-Allow-Methods", "*");
		headers.set("Access-Control-Allow-Headers", "Content-Type"); 
        return ResponseEntity.ok().headers(headers).build();
    }
	private String generateUUid() {
		return UUID.randomUUID().toString();
	}
}
