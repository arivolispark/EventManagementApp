package com.eventmanagement.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagement.dao.TaskManagerService;
import com.eventmanagement.model.Task;



@RestController
public class EventManagerController {
    TaskManagerService taskManagerService = new TaskManagerService();
    
    @RequestMapping(value = "/events", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Task> getAllTasks() {
    	System.out.println("\n TaskManagerController::getAllTasks())");
    	
    	List<Task> tasks = taskManagerService.getAllTasks();
    	return tasks;
    }
	 
	@RequestMapping(value = "/events/archive/{ids}", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Task> archiveAllTasks(@PathVariable int[] ids) {
    	System.out.println("\n TaskManagerController::archiveAllTasks(@PathVariable int[] ids)");
		
		for (int i=0; i<ids.length; i++) {
			taskManagerService.archiveTask(ids[i]);
		}
		
		List<Task> tasks = taskManagerService.getAllTasks();
		return tasks;
	}
	 
	@RequestMapping(value = "/events/{id}/{status}", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Task> changeTaskStatus(@PathVariable int id, @PathVariable String status) throws ParseException {
    	System.out.println("\n TaskManagerController::changeTaskStatus(@PathVariable int id, @PathVariable String status)");
		
		taskManagerService.changeTaskStatus(id, status);
		return taskManagerService.getAllTasks();
	}
	
	@RequestMapping(value = "/events/insert/{name}/{description}/{priority}/{status}", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Task> addTask(@PathVariable String name, @PathVariable String description, @PathVariable String priority, @PathVariable String status) throws ParseException {
    	System.out.println("\n TaskManagerController::addTask(@PathVariable String name, @PathVariable String description, @PathVariable String priority, @PathVariable String status)");
		
		Task task = new Task();
		task.setName(name);
		task.setDescription(description);
		task.setPriority(priority);
		task.setStatus(status);
		
		taskManagerService.addTask(task);
		return taskManagerService.getAllTasks();
	}	
}