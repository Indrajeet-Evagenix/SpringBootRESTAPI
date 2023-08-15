package com.bidirection.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bidirection.model.Employee;

@Component
public interface EmployeeServices {
	
	public Employee insertEmployee(Employee employee);

	public Employee getEmployeeDetailsById(Long id);

	public List<Employee> getAllEmployeeDetails();

	public void deleteAllEmployeeDetails();

	public void deleteEmployeeDetailsById(Long id);

	public Employee updateEmployeeDetails(Employee employee);

}
