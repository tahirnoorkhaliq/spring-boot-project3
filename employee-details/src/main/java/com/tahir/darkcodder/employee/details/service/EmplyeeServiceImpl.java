package com.tahir.darkcodder.employee.details.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tahir.darkcodder.employee.details.model.EmployeeDTO;
import com.tahir.darkcodder.employee.details.model.EmployeeEntity;
import com.tahir.darkcodder.employee.details.service.repo.EmployeeRepository;

@Service
public class EmplyeeServiceImpl implements EmployeeService {

	EmployeeRepository employeeRepository;
	
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public EmplyeeServiceImpl(EmployeeRepository employeeRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.employeeRepository = employeeRepository;
		this.bCryptPasswordEncoder=bCryptPasswordEncoder;
	}

	@Override
	public EmployeeDTO creteEmployee(EmployeeDTO empDTO) {
		empDTO.setEmployeeId(generateUUid());
		empDTO.setEncryptedPassword(bCryptPasswordEncoder.encode(empDTO.getPassword()));
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		EmployeeEntity empEntity = modelMapper.map(empDTO, EmployeeEntity.class);		
		EmployeeEntity responeEntity = employeeRepository.save(empEntity);		
		return modelMapper.map(responeEntity, EmployeeDTO.class);
	}

	private String generateUUid() {
		return UUID.randomUUID().toString();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		EmployeeEntity employeeEntity = employeeRepository.findByEmail(username);
		
		if(null==employeeEntity) throw new UsernameNotFoundException(username);
		
		return new User(employeeEntity.getEmail(),employeeEntity.getEncryptedPassword(),true,true,true,true,new ArrayList<>());
		 
	}

	@Override
	public EmployeeDTO getEmployeeDetailsByEmail(String email) {
		EmployeeEntity employeeEntity = employeeRepository.findByEmail(email);
		if(null==employeeEntity) throw new UsernameNotFoundException(email);		
		return new ModelMapper().map(employeeEntity, EmployeeDTO.class);
	}

	@Override
	public List<EmployeeDTO> getEmployeeDetails() {
		return Arrays.asList(new ModelMapper().map(employeeRepository.findAll(), EmployeeDTO[].class));
		// new ModelMapper().map(employeeRepository.findAll(), List.class);
				
	}

}
