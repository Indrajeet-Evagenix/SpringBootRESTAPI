package com.bidirection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bidirection.model.Employee;
import com.bidirection.repository.EmployeeRepository;
import com.bidirection.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/addEmployees")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.insertEmployee(employee);
		return "Employee Add Successfully";
	}

	@GetMapping("/getEmployee/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeService.getEmployeeById(id);
		return employee;
	}

	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		List<Employee> employees = employeeService.getAllEmployee();
		return employees;
	}

	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee) {
		Employee employee1 = employeeService.insertEmployee(employee);

		return "Employee Record Updated Successfully";
	}

	@DeleteMapping("/deleteEmployeeById/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteById(id);
		return "Employee Details with this id: " + id + " Deleted";
	}
}
