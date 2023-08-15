package com.bidirection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidirection.model.Employee;
import com.bidirection.model.Task;
import com.bidirection.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee insertEmployee(Employee employee) {

		for (Task task : employee.getTask()) {
			task.setEmployee(employee);
		}
		employee.setTask(employee.getTask());

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
