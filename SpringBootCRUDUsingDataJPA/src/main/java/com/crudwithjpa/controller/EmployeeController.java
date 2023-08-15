package com.crudwithjpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudwithjpa.model.Employee;
import com.crudwithjpa.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@PostMapping("/employees")
	public String createEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "Employee Record Inserted Successfully";
	}

	@GetMapping("/getEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(list::add);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	@GetMapping("/getEmployees/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long empid) {
		Optional<Employee> employee = employeeRepository.findById(empid);
		if (employee.isPresent()) {
			return new ResponseEntity<Employee>(employee.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/employees/{empid}")
	public String updateEmployeeById(@PathVariable long empid, @RequestBody Employee employee) {
//		Long id=employee.getEmpid(); // By Body
		Optional<Employee> empOptional = employeeRepository.findById(empid);
		if (empOptional.isPresent()) {
			Employee existEmp = empOptional.get();
			existEmp.setEmpname(employee.getEmpname());
			existEmp.setEmpage(employee.getEmpage());
			existEmp.setEmpcity(employee.getEmpcity());
			existEmp.setEmpsalary(employee.getEmpsalary());
			employeeRepository.save(existEmp);
			return "Employee Details Against ID: " + empid + " Updated";
		} else {
			return "Employee Details With this ID: " + empid + " Not Exist";
		}
	}

	@DeleteMapping("/deleteEmployeesById/{empid}")
	public String deleteEmployeeById(@PathVariable Long empid) {
		employeeRepository.deleteById(empid);
		return "Employee Deleted Successfully";
	}

	@DeleteMapping("/deleteAllEmployees")
	public String deleteAllEmployee() {
		employeeRepository.deleteAll();
		return "All Employee Deleted Successfully";
	}

	@GetMapping("/employeesByCityName/{empcity}")
	public ResponseEntity<List<Employee>> getEmployeeByCityName(@PathVariable String empcity) {
		List<Employee> list = new ArrayList<Employee>();
		employeeRepository.findByEmpcity(empcity).forEach(list::add);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	@GetMapping("/employeesByAge/{empage}")
	public ResponseEntity<List<Employee>> getEmployeeByEmpage(@PathVariable int empage) {
		List<Employee> list = new ArrayList<Employee>();
		employeeRepository.findByEmpage(empage).forEach(list::add);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	@GetMapping("/employeesByEmpName/{empname}")
	public ResponseEntity<List<Employee>> getEmployeeByEmpage(@PathVariable String empname) {
		List<Employee> list = new ArrayList<Employee>();
		employeeRepository.findByEmpname(empname).forEach(list::add);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

}
