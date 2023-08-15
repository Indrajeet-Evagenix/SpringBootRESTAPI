package com.bidirection.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bidirection.model.Task;

@Component
public interface TaskServices {

	public Task insertTask(Task task);

	public Task getTaskDetailsById(Long id);

	public List<Task> getAllTaskDetails();

	public void deleteAllTaskDetails();

	public void deleteTaskDetailsById(Long id);

	public Task updateTaskDetails(Task task);
}
