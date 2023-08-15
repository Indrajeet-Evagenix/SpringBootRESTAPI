package com.bidirection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bidirection.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
