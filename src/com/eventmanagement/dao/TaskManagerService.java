package com.eventmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eventmanagement.model.Task;
import com.eventmanagement.util.DBUtility;
import com.eventmanagement.util.Util;



public class TaskManagerService {
    private Connection connection;

    public TaskManagerService() {
        System.out.println("\n TaskManagerService()");
    	connection = DBUtility.getConnection();
    }
    
    public void addTask(Task task) {
    	System.out.println("\n TaskManagerService::addTask(Task task)");
    	Util.displayTask(task);
    	
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement("insert into task_list(task_name, task_description, task_priority, task_status, task_archived, task_start_time, task_end_time) values (?, ?, ?, ?, ?, ?, ?)");
    		
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());  
        	preparedStatement.setString(3, task.getPriority());
        	preparedStatement.setString(4, task.getStatus());
        	preparedStatement.setInt(5,0);
        	
        	Date date = new Date();
       	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	String currentTime = sdf.format(date);
        	System.out.println("\n currentTime: " + currentTime);
        	
        	preparedStatement.setString(6, currentTime);
        	preparedStatement.setString(7, currentTime);
        	preparedStatement.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public void archiveTask(int taskId) {
    	System.out.println("\n TaskManagerService::archiveTask(int taskId))");
    	System.out.println("\n taskId: " + taskId);
    	
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement("update task_list set task_archived=true where task_id=?");

        	// Parameters start with 1
        	preparedStatement.setInt(1, taskId);
        	preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
    
    public void updateTask(Task task) throws ParseException {
    	System.out.println("\n TaskManagerService::updateTask(Task task))");
    	Util.displayTask(task);
    	
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement("update task_list set task_name=?, task_description=?, task_priority=?, task_status=?" + "where task_id=?");
    		
        	preparedStatement.setString(1, task.getName());
        	preparedStatement.setString(2, task.getDescription());
        	preparedStatement.setString(3, task.getPriority());
        	preparedStatement.setString(4, task.getStatus());
        	preparedStatement.setInt(4, task.getId());
        	preparedStatement.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public void changeTaskStatus(int taskId, String status) throws ParseException {
    	System.out.println("\n TaskManagerService::changeTaskStatus(int taskId, String status))");
    	System.out.println("\n taskId: " + taskId);
    	System.out.println("\n status: " + status);    	
    	
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement("update task_list set task_status=? where task_id=?");
        	preparedStatement.setString(1, status);
        	preparedStatement.setInt(2, taskId);
        	preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
    
    public List<Task> getAllTasks() {
    	System.out.println("\n TaskManagerService::getAllTasks())");
    	
    	List<Task> taskList = new ArrayList<Task>();
    	
    	try {
    		Statement statement = connection.createStatement();
    		ResultSet rs = statement.executeQuery("select * from task_list where task_archived=0");
    		while (rs.next()) {
    			Task task = new Task();
    			task.setId(rs.getInt("task_id"));
    			task.setName(rs.getString("task_name"));
    			task.setDescription(rs.getString("task_description"));
    			task.setPriority(rs.getString("task_priority"));
    			task.setStatus(rs.getString("task_status"));
    			Util.displayTask(task);
    			
    			taskList.add(task);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	Util.displayTaskList(taskList);    	
    	return taskList;
    }
    
    public Task getTaskById(int taskId) {
    	System.out.println("\n TaskManagerService::getTaskById(int taskId))");
    	System.out.println("\n taskId: " + taskId);
    	
    	Task task = new Task();
    	
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement("select * from task_list where task_id=?");
    		preparedStatement.setInt(1, taskId);
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		if (rs.next()) {
    			task.setId(rs.getInt("task_id"));
    			task.setName(rs.getString("task_name"));
    			task.setDescription(rs.getString("task_description"));
    			task.setPriority(rs.getString("task_priority"));
    			task.setStatus(rs.getString("task_status"));
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}

    	Util.displayTask(task);    	
    	return task;
    }
}