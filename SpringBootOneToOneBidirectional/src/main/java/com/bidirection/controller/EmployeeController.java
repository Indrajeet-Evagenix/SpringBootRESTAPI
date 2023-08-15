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
import com.bidirection.model.Profile;
import com.bidirection.repository.EmployeeRepository;
import com.bidirection.repository.ProfileRepository;
import com.bidirection.services.EmployeeServices;
import com.bidirection.services.EmployeeServicesimpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private EmployeeServices employeeServicesimpl;

//	@PostMapping("/addEmployee/{profileId}/profile")
//	public String addEmployeeDeatils(@RequestBody Employee employee, @PathVariable Long profileId) {
//		profileRepository.findById(profileId).map(profileNew -> {
//			employee.setProfile(profileNew);
//			return employeeRepository.save(employee);
//		});
//		return "Employee Details Inserted Successfully";
//	}

	@PostMapping("/addEmployee")
	public String addEmployeeDeatils(@RequestBody Employee employee) {
		employeeServicesimpl.insertEmployee(employee);
		return "Employee Details Inserted Successfully";
	}

	// Not Working
	@GetMapping("/getEmployeeById/{employeeId}")
	public Employee getEmployeeByID(@PathVariable Long employeeId) {
		Employee employee = employeeServicesimpl.getEmployeeDetailsById(employeeId);
		return employee;
	}

	// Not Working
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployeeDetails() {
		List<Employee> list = employeeRepository.findAll();
		return list;
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

	// Working but Profile Created with new Reference
	@PutMapping("/updateEmployee")
	public String updateEmployeeDetails(@RequestBody Employee employee) {
		employeeServicesimpl.updateEmployeeDetails(employee);
		return "Employee Details Updated SuccessFully";
	}

}
