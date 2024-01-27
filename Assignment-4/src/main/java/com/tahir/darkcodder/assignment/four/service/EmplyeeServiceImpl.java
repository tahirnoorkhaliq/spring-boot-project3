package com.tahir.darkcodder.assignment.four.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.exceptions.AlreadyInitializedException;

import com.tahir.darkcodder.assignment.four.pojo.EmployeeDTO;
import com.tahir.darkcodder.assignment.four.pojo.EmployeeEntity;


@Service
public class EmplyeeServiceImpl implements EmployeeService {

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	

	
	/*
	 * public EmplyeeServiceImpl(EmployeeRepository employeeRepository) { super();
	 * this.employeeRepository = employeeRepository;
	 * 
	 * }
	 */

	@Override
	public EmployeeDTO creteEmployee(EmployeeDTO empDTO) {
		if(!employeeRepository.existsById(empDTO.getEmployeeId())) {
		empDTO.setEmployeeUUId(generateUUid());
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		EmployeeEntity empEntity = modelMapper.map(empDTO, EmployeeEntity.class);		
		EmployeeEntity responeEntity = employeeRepository.save(empEntity);		
		return modelMapper.map(responeEntity, EmployeeDTO.class);
		}else {
			throw new AlreadyInitializedException("Record Already Available with this Id");
		}
		
	}

	private String generateUUid() {
		return UUID.randomUUID().toString();
	}

	

	@Override
	public List<EmployeeDTO> getEmployeeDetails() {
		return Arrays.asList(new ModelMapper().map(employeeRepository.findAll(), EmployeeDTO[].class));
						
	}

	@Override
	public EmployeeDTO findbyEmployeeId(long employeeId) {
		return new ModelMapper().map(employeeRepository.findById(employeeId), EmployeeDTO.class);
	}

}
