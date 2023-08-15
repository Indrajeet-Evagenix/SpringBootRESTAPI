package com.bidirection.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bidirection.model.Employee;

@Component
public interface EmployeeService {

	public Employee insertEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public Employee getEmployeeById(Long id);

	public void deleteById(Long id);
}
