package com.bidirection.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bidirection.exception.NotFoundException;
import com.bidirection.model.Task;
import com.bidirection.repository.EmployeeRepository;
import com.bidirection.repository.TaskRepository;
import com.bidirection.services.EmployeeServices;
import com.bidirection.services.EmployeeServicesImpl;
import com.bidirection.services.TaskServices;
import com.bidirection.services.TaskServicesImpl;

@RestController
public class TaskController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private TaskRepository taskRepository;

	@PostMapping("/employee/{employeeId}/addTask")
	public String addTask(@RequestBody Task task, @PathVariable Long employeeId) {
		employeeRepository.findById(employeeId).map(employee -> {
			task.setEmployee(employee);
			return taskRepository.save(task);
		}).orElseThrow(() -> new NotFoundException("Employee not found!"));
		return "Task Added Successfully";

	}

	// Not Working
//	@GetMapping("/employee/{employeeId}/getTask")
//	public Optional<Task> getTaskById(@PathVariable Long employeeId) {
//		if (!employeeRepository.existsById(employeeId)) {
//			throw new NotFoundException("Employee With this Id Not Present");
//		}
//		return taskRepository.findById(employeeId);
//	}
//
//	@GetMapping("/getAllTask")
//	public List<Task> getAllTask() {
//		List<Task> task = taskRepository.findAll();
//		return task;
//	}

	// Not Working
	@DeleteMapping("/employee/{employeeId}/task/{taskId}")
	public String deletetaskById(@PathVariable Long employeeId, @PathVariable Long taskId) {
		if (!employeeRepository.existsById(employeeId)) {
			throw new NotFoundException("Employee With this Id: " + employeeId + " Not Present");
		}
		return taskRepository.findById(taskId).map(task -> {
			taskRepository.delete(task);
			return "Task With this id: " + taskId + " Deleted Successfully!";
		}).orElseThrow(() -> new NotFoundException("Task Not Found"));

	}

//	@DeleteMapping("/deleteAllTask")
//	public String deleteAllTask() {
//		taskServices.deleteAllTaskDetails();
//		return "All Task Deleted Successfully";
//	}

	@PutMapping("/employee/{employeeId}/task/{taskId}")
	public String updateTask(@PathVariable Long employeeId, @PathVariable Long taskId, @RequestBody Task taskUpdated) {
		if (!employeeRepository.existsById(employeeId)) {
			throw new NotFoundException("Employee With this Id: " + employeeId + " Not Present");
		}
		return taskRepository.findById(taskId).map(task -> {
			task.setName(taskUpdated.getName());
			task.setPriority(taskUpdated.getPriority());
			taskRepository.save(task);
			return "Task With this id: " + taskId + " Updateed Successfully!";
		}).orElseThrow(() -> new NotFoundException("Task Not Found"));
	}

}
