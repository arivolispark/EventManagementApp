package com.eventmanagement.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.eventmanagement.model.Image;
import com.eventmanagement.model.Images;
import com.eventmanagement.model.Link;
import com.eventmanagement.model.Task;



public class Util {
	public static void displayTask(Task task) {
	    System.out.println("\n Util:displayTask(Task task)");
	    if (task != null) {
		    System.out.println("\n task: " + task);
	    }
	}
	
	public static void displayTaskList(List<Task> taskList) {
	    System.out.println("\n Util:displayTaskList(List<Task> taskList)");
	    if (taskList == null) {
		    System.out.println("\n taskList is null");
	    } else if (taskList.isEmpty()) {
		    System.out.println("\n taskList is empty");	    	
	    } else {
	    	int i = 0;
	    	for (Task task : taskList) {
			    System.out.println("\n (" + i++ + ")");	    	
	    		displayTask(task);
	    	}
	    }
	}
	
	public static void updateImage(Image sourceImage, Image targetImage) {
	    System.out.println("\n Util:updateImage(Image sourceImage, Image targetImage)");
	    if (sourceImage != null && targetImage != null) {
		    System.out.println("\n Util:updateImage::sourceImage: " + sourceImage);
		    System.out.println("\n Util:updateImage::targetImage: " + targetImage);
		    
		    targetImage.setName(sourceImage.getName());
		    targetImage.setDescription(sourceImage.getDescription());
		    targetImage.setImageURL(sourceImage.getImageURL());
		    System.out.println("\n Util:updated targetImage: " + targetImage);
	    }
	}
	
	public static void displayImage(Image image) {
	    System.out.println("\n Util:displayImage(Image image)");
	    if (image != null) {
		    System.out.println("\n image: " + image);
	    }
	}
	
	public static void displayImageList(List<Image> imageList) {
	    System.out.println("\n Util:displayImageList(List<Image> imageList)");
	    if (imageList == null) {
		    System.out.println("\n imageList is null");
	    } else if (imageList.isEmpty()) {
		    System.out.println("\n imageList is empty");	    	
	    } else {
	    	int i = 0;
	    	for (Image image : imageList) {
			    System.out.println("\n (" + i++ + ")");	    	
	    		displayImage(image);
	    	}
	    }
	}
	
	//Adding HATEOAS links into Response objects
	public static void addImagesLinks(String requestURI, Images images) throws URISyntaxException {
		if (requestURI != null && images != null) {
			URI canonicalURI = new URI(requestURI);            
            Link canonicalLink = new Link(canonicalURI, "canonical");
            
            URI selfURI = new URI(requestURI);
            Link selfLink = new Link(selfURI, "self");
            
            List<Link> links = new ArrayList<Link>();
            links.add(selfLink);
            links.add(canonicalLink);
            
            images.setLinks(links);
		}
	}
	
//public static void addApplicationPackageLinks(UriInfo uriInfo, String id, ApplicationPackage applicationPackage) throws URISyntaxException {
//  if (uriInfo != null && id != null && applicationPackage != null) {
//      URI canonicalURI = new URI(uriInfo.getBaseUri().toString() + Constants.PACKAGES_URI_V1 + "/" + id);            
//      Link canonicalLink = new Link(canonicalURI, "canonical");
//
//      URI selfURI = new URI(uriInfo.getBaseUri().toString() + Constants.PACKAGES_URI_V1 + "/" + id);
//      Link selfLink = new Link(selfURI, "self");
//
//      List<Link> links = new ArrayList<Link>();
//      links.add(selfLink);
//      links.add(canonicalLink);
//  
//      applicationPackage.setLinks(links);
//  }
//}
//
//public static void addApplicationDependentPackagesLinks(UriInfo uriInfo, String id, ApplicationDependentPackages applicationDependentPackages) throws URISyntaxException {
//  if (uriInfo != null && id != null && applicationDependentPackages != null) {
//      URI canonicalURI = new URI(uriInfo.getBaseUri().toString() + Constants.PACKAGES_URI_V1 + "/" + id + "/" + "dependentPackages");            
//      Link canonicalLink = new Link(canonicalURI, "canonical");
//
//      List<Link> links = new ArrayList<Link>();
//      links.add(canonicalLink);
//  
//      applicationDependentPackages.setLinks(links);
//  }
//}	
	//end of Adding HATEOAS links into Response objects
}