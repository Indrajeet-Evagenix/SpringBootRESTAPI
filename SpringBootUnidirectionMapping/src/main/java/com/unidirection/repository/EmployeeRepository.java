package com.unidirection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unidirection.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
