package com.eventmanagement.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.eventmanagement.model.Image;
import com.eventmanagement.model.Images;
import com.eventmanagement.util.DBUtility;
import com.eventmanagement.util.Util;



public class ImageManagerService {
	private static final String INSERT_INTO_EVENTMGMT_IMAGE_PREPARED_STATEMENT = "insert into eventmgmt_image(name, description, imageURL) values (?, ?, ?)";
	private static final String DELETE_FROM_EVENTMGMT_IMAGE_PREPARED_STATEMENT = "delete from eventmgmt_image where id=?";	
	private static final String GET_ALL_FROM_EVENTMGMT_IMAGE_PREPARED_STATEMENT = "select * from eventmgmt_image";	
	private static final String GET_BY_ID_FROM_EVENTMGMT_IMAGE_PREPARED_STATEMENT = "select * from eventmgmt_image where id=?";	
	
    private Connection connection;

    public ImageManagerService() {
        System.out.println("\n ImageManagerService()");
    	connection = DBUtility.getConnection();
    }
    
    public void addImage(Image image) {
    	System.out.println("\n ImageManagerService:addImage(Image image)");
    	Util.displayImage(image);
    	
        if (image != null &&
        	image.getName() != null &&
        	image.getImageURL() != null) {
        	try {
        		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_EVENTMGMT_IMAGE_PREPARED_STATEMENT);
                preparedStatement.setString(1, image.getName());
                preparedStatement.setString(2, image.getDescription());  
            	preparedStatement.setString(3, image.getImageURL());
            	preparedStatement.executeUpdate();
        	} catch (SQLException e) {
            	System.out.println("\n ImageManagerService:addImage::e " + e);
        		e.printStackTrace();
        	}
        }
    }
    
//    public void archiveTask(int taskId) {
//    	System.out.println("\n ImageManagerService:archiveTask(int taskId))");
//    	System.out.println("\n taskId: " + taskId);
//    	
//        try {
//        	PreparedStatement preparedStatement = connection.prepareStatement("update task_list set task_archived=true where task_id=?");
//
//        	// Parameters start with 1
//        	preparedStatement.setInt(1, taskId);
//        	preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//        	e.printStackTrace();
//        }
//    }
//    
//    public void updateTask(Task task) throws ParseException {
//    	System.out.println("\n ImageManagerService:updateTask(Task task))");
//    	Util.displayTask(task);
//    	
//    	try {
//    		PreparedStatement preparedStatement = connection.prepareStatement("update task_list set task_name=?, task_description=?, task_priority=?, task_status=?" + "where task_id=?");
//    		
//        	preparedStatement.setString(1, task.getName());
//        	preparedStatement.setString(2, task.getDescription());
//        	preparedStatement.setString(3, task.getPriority());
//        	preparedStatement.setString(4, task.getStatus());
//        	preparedStatement.setInt(4, task.getId());
//        	preparedStatement.executeUpdate();
//    	} catch (SQLException e) {
//    		e.printStackTrace();
//    	}
//    }
//    
//    public void changeTaskStatus(int taskId, String status) throws ParseException {
//    	System.out.println("\n ImageManagerService:changeTaskStatus(int taskId, String status))");
//    	System.out.println("\n taskId: " + taskId);
//    	System.out.println("\n status: " + status);    	
//    	
//        try {
//        	PreparedStatement preparedStatement = connection.prepareStatement("update task_list set task_status=? where task_id=?");
//        	preparedStatement.setString(1, status);
//        	preparedStatement.setInt(2, taskId);
//        	preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//        	e.printStackTrace();
//        }
//    }
    
    public List<Image> getImageList() {
    	System.out.println("\n getImageList())");
    	
    	List<Image> imageList = new ArrayList<Image>();

    	try {
    		Statement statement = connection.createStatement();
    		ResultSet rs = statement.executeQuery(GET_ALL_FROM_EVENTMGMT_IMAGE_PREPARED_STATEMENT);
    		while (rs.next()) {
    			int imageId = rs.getInt("id");
    			String name = rs.getString("name");
    			String description = rs.getString("description");
    			String imageURL = rs.getString("imageURL");

    			if (imageId > 0 && name != null && imageURL != null) {
        			Image image = new Image();
        			image.setId(imageId);
        			image.setName(name);
        			image.setDescription(description);
        			image.setImageURL(imageURL);
        			Util.displayImage(image);

        			imageList.add(image);
    			}
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	Util.displayImageList(imageList);    	
    	return imageList;
    }
    
    public Image getImageById(int id) {
    	System.out.println("\n ImageManagerService:getImageById(int id))");
    	System.out.println("\n id: " + id);

    	Image image = null;
    	
    	int imageId = -1;
    	String name = null;
    	String description = null;
    	String imageURL = null;    	
    	
    	if (id > 0) {
        	try {
        		PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_FROM_EVENTMGMT_IMAGE_PREPARED_STATEMENT);
        		preparedStatement.setInt(1, id);
        		ResultSet rs = preparedStatement.executeQuery();
        		if (rs != null) {
            		if (rs.next()) {
            			imageId = rs.getInt("id");
            			name = rs.getString("name");
            			description = rs.getString("description");
            			imageURL = rs.getString("imageURL");
            		}
        		}
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
        	
			if (imageId > 0 && name != null && imageURL != null) {
    			image = new Image();
    			image.setId(imageId);
    			image.setName(name);
    			image.setDescription(description);
    			image.setImageURL(imageURL);
			}
    	}
    	
    	Util.displayImage(image);    	
    	return image;
    }
    
    public void deleteImageById(int id) {
    	System.out.println("\n ImageManagerService:deleteImageById(int id))");
    	System.out.println("\n id: " + id);

    	if (id > 0) {
    		try {
    			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_EVENTMGMT_IMAGE_PREPARED_STATEMENT);
    			preparedStatement.setInt(1, id);
        		preparedStatement.execute();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    public Images convertToImages(List<Image> imageList) {
    	Images images = null;
    	if (imageList != null && !imageList.isEmpty()) {
    		images = new Images();
    		for (Image image : imageList) {
    			images.addImage(image);
    		}
    	}
    	return images;
    }
}