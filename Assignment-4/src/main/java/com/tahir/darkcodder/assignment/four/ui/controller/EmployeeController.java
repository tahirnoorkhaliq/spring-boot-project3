package com.tahir.darkcodder.assignment.four.ui.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.exceptions.AlreadyInitializedException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tahir.darkcodder.assignment.four.pojo.CreateEmployeeRequest;
import com.tahir.darkcodder.assignment.four.pojo.EmployeeDTO;
import com.tahir.darkcodder.assignment.four.service.EmployeeService;

@RestController
@RequestMapping("/")
@EnableWebMvc
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("employee-form")
	public ModelAndView employeeForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("createEmployeeRequest", new CreateEmployeeRequest());
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@PostMapping(value = "employee-form", produces = { "application/json" }, consumes = {
			"application/x-www-form-urlencoded" })
	public ModelAndView saveEmployee(@RequestParam Map<String, String> body) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			CreateEmployeeRequest createEmployeeRequest = mapper.convertValue(body, CreateEmployeeRequest.class);
			System.out.println("createEmployeeRequest " + createEmployeeRequest);
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			EmployeeDTO employeeDTO = modelMapper.map(createEmployeeRequest, EmployeeDTO.class);
			EmployeeDTO createEmp = employeeService.creteEmployee(employeeDTO);
			CreateEmployeeRequest emp = modelMapper.map(createEmp, CreateEmployeeRequest.class);
			modelAndView.addObject("createEmployeeRequest", new CreateEmployeeRequest());
		} catch (AlreadyInitializedException e) {
			modelAndView.addObject("alreadyFound", e.getMessage());
			modelAndView.addObject("createEmployeeRequest", new CreateEmployeeRequest());
		}
		return modelAndView;
	}
	
	@GetMapping("displayAll")
	public ModelAndView displayAll() {	
		List<EmployeeDTO> employees = employeeService.getEmployeeDetails();
		ModelAndView modelAndView = new ModelAndView();			
        modelAndView.addObject("employees", employees);  
        modelAndView.setViewName("display-all");
        return modelAndView;
	}
	
	@GetMapping("display/{employeeId}")
	public ModelAndView displayById(@PathVariable Long employeeId) {	
		EmployeeDTO employee = employeeService.findbyEmployeeId(employeeId);
		List<EmployeeDTO> employees=new ArrayList<>();
		employees.add(employee);		
		ModelAndView modelAndView = new ModelAndView();			
        modelAndView.addObject("employees", employees);  
        modelAndView.setViewName("display-all");
        return modelAndView;
	}
	
	

}
