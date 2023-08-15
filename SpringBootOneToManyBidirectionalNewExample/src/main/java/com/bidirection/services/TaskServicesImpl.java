package com.bidirection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidirection.model.Task;
import com.bidirection.repository.TaskRepository;

@Service
public class TaskServicesImpl implements TaskServices {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task insertTask(Task task) {
		Task task1 = taskRepository.save(task);
		return task1;
	}

	@Override
	public Task getTaskDetailsById(Long id) {
		Optional<Task> task = taskRepository.findById(id);
		return task.get();
	}

	@Override
	public List<Task> getAllTaskDetails() {
		List<Task> task = taskRepository.findAll();
		
		return task;
	}

	@Override
	public void deleteAllTaskDetails() {
		taskRepository.deleteAll();

	}

	@Override
	public void deleteTaskDetailsById(Long id) {
		taskRepository.deleteById(id);

	}

	@Override
	public Task updateTaskDetails(Task task) {
		Long id = task.getId();
		Optional<Task> optional = taskRepository.findById(id);
		if (optional.isPresent()) {
			Task task1 = optional.get();
			task1.setName(task.getName());
			task1.setPriority(task.getPriority());
			task1.setEmployee(task.getEmployee());
			return taskRepository.save(task1);
		} else {
			return null;
		}
	}

}
