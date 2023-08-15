package com.bidirection.controller;

import java.util.Iterator;
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
import com.bidirection.services.EmployeeServices;
import com.bidirection.services.EmployeeServicesImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServices employeeServicesimpl;

	@Autowired
	private EmployeeRepository epmEmployeeRepository;

	@PostMapping("/addEmployee")
	public String addEmployeeDeatils(@RequestBody Employee employee) {
		employeeServicesimpl.insertEmployee(employee);
		return "Employee Details Inserted Successfully";
	}

	// Not Working
	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeByID(@PathVariable Long id) {
		Employee employee = employeeServicesimpl.getEmployeeDetailsById(id);
		System.out.println(employee);
		if (employee != null) {
			return employee;

		} else {
			return null;
		}
	}

	// Not Working
	@GetMapping("/getAllEmployee")
	public String getAllEmployeeDetails() {
		List<Employee> list = epmEmployeeRepository.findAll();
		for (Employee employee : list) {
			System.out.println(employee.getName());
		}
		System.out.println(list);
		return "Data Fetched";
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteEmployeeById(@PathVariable Long id) {
		employeeServicesimpl.deleteEmployeeDetailsById(id);
		return "Employee with this id: " + id + " deleted Successfully";
	}

	@DeleteMapping("/deleteAllEmployees")
	public String deleteAllEmployees() {
		employeeServicesimpl.deleteAllEmployeeDetails();
		return "All Employee Details Deleted Successfully";
	}

	@PutMapping("/updateEmployee")
	public String updateEmployeeDetails(@RequestBody Employee employee) {
		employeeServicesimpl.updateEmployeeDetails(employee);
		return "Employee Details Updated SuccessFully";
	}
}