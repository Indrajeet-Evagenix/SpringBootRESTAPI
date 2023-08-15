package com.bidirection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidirection.model.Employee;
import com.bidirection.repository.EmployeeRepository;

@Service
public class EmployeeServicesimpl implements EmployeeServices {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee insertEmployee(Employee employee) {
		Employee employee2 = employeeRepository.save(employee);
		return employee2;
	}

	@Override
	public Employee getEmployeeDetailsById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee.get();
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		List<Employee> list = employeeRepository.findAll();
		return list;
	}

	@Override
	public void deleteAllEmployeeDetails() {
		employeeRepository.deleteAll();

	}

	@Override
	public void deleteEmployeeDetailsById(Long id) {
		employeeRepository.deleteById(id);

	}

	@Override
	public Employee updateEmployeeDetails(Employee employee) {
		Long id = employee.getId();
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if (optionalEmployee.isPresent()) {
			Employee emp = optionalEmployee.get();
			emp.setEmployeeName(employee.getEmployeeName());
			emp.setEmployeeAge(employee.getEmployeeAge());
			emp.setProfile(employee.getProfile());
			return employeeRepository.save(emp);
		} else {
			return null;
		}

	}

}
