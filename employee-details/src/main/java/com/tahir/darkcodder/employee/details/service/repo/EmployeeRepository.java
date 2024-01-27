package com.tahir.darkcodder.employee.details.service.repo;

import org.springframework.data.repository.CrudRepository;

import com.tahir.darkcodder.employee.details.model.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
	 EmployeeEntity findByEmail(String email);

}
