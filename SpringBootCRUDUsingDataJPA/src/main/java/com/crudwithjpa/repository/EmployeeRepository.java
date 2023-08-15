package com.crudwithjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.crudwithjpa.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public List<Employee> findByEmpcity(String empcity);
	
	public List<Employee> findByEmpage(int age);
	
	public List<Employee> findByEmpname(String empname);

}
