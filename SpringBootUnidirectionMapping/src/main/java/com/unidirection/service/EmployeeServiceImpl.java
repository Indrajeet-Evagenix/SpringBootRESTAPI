package com.unidirection.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unidirection.model.Employee;
import com.unidirection.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee insertEmployee(Employee employee) {
		return employeeRepository.save(employee);

	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = employeeRepository.findAll();
		return list;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> list = employeeRepository.findById(id);
		return list.get();
	}

	@Override
	public void deleteById(Long id) {
		employeeRepository.deleteById(id);

	}

}
