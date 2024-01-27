package com.tahir.darkcodder.assignment.four.service;

import org.springframework.data.repository.CrudRepository;

import com.tahir.darkcodder.assignment.four.pojo.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {


}
