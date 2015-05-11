package com.eventmanagement.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eventmanagement.dao.ImageManagerService;
import com.eventmanagement.exception.BadRequestException;
import com.eventmanagement.exception.EventManagementErrorConstants;
import com.eventmanagement.exception.EventManagementException;
import com.eventmanagement.exception.NotFoundException;
//import com.eventmanagement.model.Blog;
//import com.eventmanagement.model.Blogs;
//import com.eventmanagement.model.Conference;
import com.eventmanagement.model.EventManagementError;
import com.eventmanagement.model.Image;
import com.eventmanagement.model.Images;
//import com.eventmanagement.model.Link;
//import com.eventmanagement.model.Sponsor;
//import com.eventmanagement.model.Sponsors;
import com.eventmanagement.util.Constants;
import com.eventmanagement.util.Util;



@RestController
@RequestMapping(Constants.V1_IMAGES_URI)
public class ImageManagerController {
    ImageManagerService imageManagerService = new ImageManagerService();
    
    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json, application/xml")    
    public Images getImages() {
    	Images images = null;
    	System.out.println("\n ImageManagerController:getImages())");
    	List<Image> imageList = imageManagerService.getImageList();
    	images = imageManagerService.convertToImages(imageList);
    	
    	//String location = ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{id}").buildAndExpand(contact.getId()).toUriString();
    	String requestURI = ServletUriComponentsBuilder.fromCurrentRequest().build().toString();    	
    	System.out.println("\n requestURI: " + requestURI);
    	
    	try {
			Util.addImagesLinks(requestURI, images);
		} catch (URISyntaxException e) {
	    	System.out.println("\n e.getLocalizedMessage(): " + e.getLocalizedMessage());
			e.printStackTrace();
		}
    	
    	return images;
    }
    
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json, application/xml", produces = "application/json")
//    public @ResponseBody Image getImageById(@PathVariable int id) throws UnknownMatchException {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json, application/xml", produces = "application/json")
    @ResponseBody    
//    public Image getImageById(@PathVariable int id) throws EventManagementException {
    //public ResponseEntity<Image> getImageById(@PathVariable int id) throws EventManagementException {
    public Image getImageById(@PathVariable int id) throws EventManagementException {
    	System.out.println("\n ImageManagerController:getAllImageById(@PathVariable int id))");
    	System.out.println("\n ImageManagerController:getAllImageById::id: " + id);
    	ResponseEntity<Image> responseEntity = null;
    	Image image = null;

    	//System.out.println("\n ImageManagerController:getAllImageById::request: " + request);
    	
//        Long imageId = new Long(-1);
//        try {
//            System.out.println("\n HERE 1");
//            imageId = new Long(id);
//            System.out.println("\n imageId: " + imageId);
//        } catch(NumberFormatException numberFormatException) {
//            System.out.println("\n HERE 2");
//            BadRequestException badRequestException = new BadRequestException("The input parameter supplied is invalid.  Please supply a valid input parameter and retry.");
//            throw badRequestException;
//        }
    	
    	if (id <= 0) {
        	System.out.println("\n ImageManagerController:getAllImageById(@PathVariable int id)) HERE 1");
    		//EventManagementException e = new EventManagementException();
            BadRequestException badRequestException = new BadRequestException("The input parameter supplied is invalid.  Please supply a valid input parameter and retry.");
            throw badRequestException;
    	}
    	
    	///*
    	image = imageManagerService.getImageById(id);
    	if (image == null) {
            System.out.println("\n HERE 2A");
            
            //EventManagementError eventManagementError = createNotFoundExceptionError(id);
            
            /*
            EventManagementError eventManagementError = new EventManagementError();
            eventManagementError.setType("http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.1");
            eventManagementError.setTitle("HERE 1, Resource not found");
            eventManagementError.setStatus(404);
            eventManagementError.setDetail("Resource not found for id: " + id);
            eventManagementError.setErrorCode(EventManagementErrorConstants.ErrorCode.OBJECT_NOT_FOUND);
//            eventManagementError.setErrorPath(errorPath);

            NotFoundException notFoundException = new NotFoundException();
            //notFoundException.setEventManagementError(eventManagementError);
            throw notFoundException;
            
            //responseEntity = handleNotFoundException(notFoundException);
        	//System.out.println("\n ImageManagerController:getAllImageById(@PathVariable int id)) HERE 10, responseEntity: " + responseEntity);
            
//            NotFoundException notFoundException = new NotFoundException();
//            throw notFoundException;
            */
            
            //NotFoundException notFoundException = new NotFoundException(String.valueOf(id));
            NotFoundException notFoundException = new NotFoundException(String.valueOf(id));            
            System.out.println("\n notFoundException: " + notFoundException);
            throw notFoundException;
    	} else {
            System.out.println("\n HERE 2B");
//        	try {
//        		addImageLinks(id, image);
//        	} catch (URISyntaxException uriSyntaxException) {
//        		uriSyntaxException.printStackTrace();
//        	}
    	}
    	//*/
    	
    	responseEntity = new ResponseEntity<Image>(image, HttpStatus.OK);
    	System.out.println("\n ImageManagerController:getAllImageById(@PathVariable int id)) HERE 20, responseEntity: " + responseEntity);
    	
    	System.out.println("\n ImageManagerController:getImageById::image: " + image);
    	return image;
    	//return responseEntity;
    }

    /*
    @RequestMapping(value = "/conference/{id}", method = RequestMethod.GET, headers = "Accept=application/json, application/xml", produces = "application/json")
    public @ResponseBody Conference getConference(@PathVariable int id) throws EventManagementException {
    	System.out.println("\n ImageManagerController:getConference(@PathVariable int id))");
    	System.out.println("\n ImageManagerController:getConference::id: " + id);
    	Image image = null;
    	
        Long imageId = new Long(-1);      
        try {
            System.out.println("\n HERE 1");
            imageId = new Long(id);
            System.out.println("\n imageId: " + imageId);
        } catch(NumberFormatException numberFormatException) {
            System.out.println("\n HERE 2");
            EventManagementException eventManagementException = new EventManagementException("The input parameter supplied is invalid.  Please fix the input and retry.");
            eventManagementException.printStackTrace();
            System.out.println("\n eventManagementException: " + eventManagementException);
            throw eventManagementException;
        }
    	
    	if (id <= 0) {
    		EventManagementException e = new EventManagementException();
    	}
    	
    	image = imageManagerService.getImageById(id);
    	if (image == null) {
            System.out.println("\n HERE 2A");
            EventManagementError eventManagementError = new EventManagementError();
            eventManagementError.setType("http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.1");
            eventManagementError.setTitle("Resource not found");
            eventManagementError.setStatus(404);
            eventManagementError.setDetail("Resource not found for id: " + id);
            eventManagementError.setErrorCode(EventManagementErrorConstants.ErrorCode.OBJECT_NOT_FOUND);
//            eventManagementError.setErrorPath(errorPath);

            EventManagementException eventManagementException = new EventManagementException();
            eventManagementException.setEventManagementError(eventManagementError);
            System.out.println("\n eventManagementException: " + eventManagementException);
            throw eventManagementException;
    	} else {
        	try {
        		addImageLinks(id, image);
        	} catch (URISyntaxException uriSyntaxException) {
        		uriSyntaxException.printStackTrace();
        	}
    	}
    	
    	Conference conference = new Conference();
    	conference.setName("FeTNA 2015");
    	conference.setDescription("Description of FeTNA 2015 conference");
    	conference.setLocation("San Jose");
    	conference.setStatus("DEVELOPMENT");
    	
    	Date conferenceStartDate = new Date();
    	conference.setConferenceStartDate(conferenceStartDate);
    	conference.setConferenceStartDateTime("9:00am");
    	
    	Date conferenceEndDate = new Date();
    	conference.setConferenceEndDate(conferenceEndDate);
    	conference.setConferenceEndDateTime("5:00pm");
    	

    	Images images = new Images();

    	if (image != null) {
        	images.addImage(image);
    	}

    	Image image2 = new Image();
    	image2.setName("Image 200");
    	image2.setDescription("Description of Image 200");

    	Image image3 = new Image();
    	image3.setName("Image 300");
    	image3.setDescription("Description of Image 300");
    	
    	Image image4 = new Image();
    	image4.setName("Image 400");
    	image4.setDescription("Description of Image 400");
    	
    	images.addImage(image2);
    	images.addImage(image3);
    	images.addImage(image4);
    	
    	conference.setImages(images);
    	
    	
    	Blog blog1 = new Blog();
    	blog1.setName("Blog1");
    	blog1.setDescription("Description of Blog1");
    	
    	Blog blog2 = new Blog();
    	blog2.setName("Blog2");
    	blog2.setDescription("Description of Blog2");
    	
    	Blog blog3 = new Blog();
    	blog3.setName("Blog3");
    	blog3.setDescription("Description of Blog3");
    	
    	
    	Blogs blogs = new Blogs();
    	blogs.addBlog(blog1);
    	blogs.addBlog(blog2);
    	blogs.addBlog(blog3);
    	
    	conference.setBlogs(blogs);    	

    	
    	Sponsor sponsor1 = new Sponsor();
    	sponsor1.setName("Sponsorer1");
    	sponsor1.setDescription("Description of Sponsorer1");

    	Sponsor sponsor2 = new Sponsor();
    	sponsor2.setName("Sponsorer2");
    	sponsor2.setDescription("Description of Sponsorer2");
    	
    	Sponsor sponsor3 = new Sponsor();
    	sponsor3.setName("Sponsorer3");
    	sponsor3.setDescription("Description of Sponsorer3");
    	
    	Sponsors sponsorers = new Sponsors();
    	sponsorers.addSponsor(sponsor1);
    	sponsorers.addSponsor(sponsor2);
    	sponsorers.addSponsor(sponsor3);
    	
    	conference.setSponsors(sponsorers);
    	
    	
    	System.out.println("\n ImageManagerController:getImageById::image: " + image);
    	return conference;
    	
        //System.out.println("\n HERE 3");
    	//return null;
    }    
    
    //@RequestMapping(value = "/hello.html", method = RequestMethod.GET, produces = "application/xml")
    //@RequestMapping(value = "/link/{id}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @RequestMapping(value = "/link/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Link> getImageLinkById(@PathVariable int id) {
    	System.out.println("\n ImageManagerController:getImageLinkById(@PathVariable int id))");
    	System.out.println("\n ImageManagerController:getImageLinkById::id: " + id);    	

		List<Link> links = new ArrayList<Link>();
    	
		URI canonicalURI = null;
		try {
			canonicalURI = new URI("http://localhost:8080/EventManagementApp/v1/images" + "/" + id);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Link canonicalLink = new Link(canonicalURI, "canonical");
    	System.out.println("\n ImageManagerController:getImageLinkById::canonicalLink: " + canonicalLink);    	
		
		URI selfURI = null;
		try {
			selfURI = new URI("http://localhost:8080/EventManagementApp/v1/images" + "/" + id);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Link selfLink = new Link(selfURI, "self");
    	System.out.println("\n ImageManagerController:getImageLinkById::selfLink: " + selfLink);    	
		
    	
		links.add(selfLink);
		links.add(canonicalLink);

    	System.out.println("\n ImageManagerController:getImageLinkById::links: " + links);
    	return links;
    }
    
//	@RequestMapping(value = "/archive/{ids}", method = RequestMethod.POST, headers = "Accept=application/json")
//	public List<Task> archiveAllTasks(@PathVariable int[] ids) {
//    	System.out.println("\n ImageManagerController:archiveAllTasks(@PathVariable int[] ids)");
//		
//		for (int i=0; i<ids.length; i++) {
//			taskManagerService.archiveTask(ids[i]);
//		}
//		
//		List<Task> tasks = imageManagerService.getAllTasks();
//		return tasks;
//	}
//	 
//	@RequestMapping(value = "/{id}/{status}", method = RequestMethod.POST, headers = "Accept=application/json")
//	public List<Task> changeTaskStatus(@PathVariable int id, @PathVariable String status) throws ParseException {
//    	System.out.println("\n ImageManagerController:changeTaskStatus(@PathVariable int id, @PathVariable String status)");
//		
//		imageManagerService.changeTaskStatus(id, status);
//		return imageManagerService.getAllTasks();
//	}
	
//	@RequestMapping(value = "/insert/{name}/{description}/{imageURL}", method = RequestMethod.POST, headers = "Accept=application/json")
//	public List<Image> addImage(@PathVariable String name, @PathVariable String description, @PathVariable String imageURL) throws ParseException {
//    	System.out.println("\n ImageManagerController:addImage(@PathVariable String name, @PathVariable String description, @PathVariable String imageURL)");
//    	List<Image> imageList = new ArrayList<Image>();		
//		
//    	if (name != null &&
//    		imageURL != null) {
//        	System.out.println("\n ImageManagerController:addImage::name: " + name);
//        	System.out.println("\n ImageManagerController:addImage::description: " + description);
//        	System.out.println("\n ImageManagerController:addImage::imageURL: " + imageURL);
//    		
//    		Image image = new Image();
//    		image.setName(name);
//    		image.setDescription(description);
//    		image.setImageURL(imageURL);
//    		
//    		imageList = addImage(image);
//    	}
//    	
//		return imageList;
//	}
	
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json, application/xml")
    public List<Image> addImage(@RequestBody Image image) throws ParseException {
    	System.out.println("\n ImageManagerController:addImage(@RequestBody Image image)");
    	List<Image> imageList = new ArrayList<Image>();		

    	System.out.println("\n ImageManagerController:addImage::image: " + image);
    	if (image != null) {
    		imageManagerService.addImage(image);
    		imageList = imageManagerService.getAllImages();
    	}
    	
		return imageList;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json, application/xml")
    public List<Image> updateImage(@PathVariable int id, @RequestBody Image image) throws ParseException, UnknownMatchException {
    	System.out.println("\n ImageManagerController:updateImage(@PathVariable int id, @RequestBody Image image)");
    	List<Image> imageList = new ArrayList<Image>();		

    	System.out.println("\n ImageManagerController:updateImage::id: " + id);
    	System.out.println("\n ImageManagerController:updateImage::image: " + image);
    	if (id > 0 && image != null) {
    		Image existingImage = getImageById(id);
    		if (existingImage != null) {
    	    	System.out.println("\n ImageManagerController:updateImage::existingImage: " + existingImage);
    	    	Util.updateImage(image, existingImage);
    	    	
        		deleteImage(id);
        		imageManagerService.addImage(existingImage);
    		}
    		
    		imageList = imageManagerService.getAllImages();
    	}
    	
		return imageList;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json, application/xml")
	public List<Image> deleteImage(@PathVariable int id) throws ParseException {
    	System.out.println("\n ImageManagerController:deleteImage(@PathVariable int id)");
    	System.out.println("\n ImageManagerController:addImage::id: " + id);
		
    	if (id > 0) {
    		imageManagerService.deleteImageById(id);
    	}

    	List<Image> imageList = getAllImages();
		return imageList;
	}
	
    public void addImageLinks(int id, Image image) throws URISyntaxException {
    	System.out.println("\n ImageManagerController:addImageLinks(int id, Image image)");    	
    	System.out.println("\n ImageManagerController:addImageLinks::id: " + id);    	
    	System.out.println("\n ImageManagerController:addImageLinks::image: " + image);    	
    	
    	if (id > 0 && image != null) {
            //URI canonicalURI = new URI(uriInfo.getBaseUri().toString() + Constants.PACKAGES_URI_V1 + "/" + id);            
    		
    		URI canonicalURI = new URI("http://localhost:8080/EventManagementApp" + Constants.V1_IMAGES_URI + "/" + id);
    		Link canonicalLink = new Link(canonicalURI, "canonical");
    		
    		URI selfURI = new URI("http://localhost:8080/EventManagementApp/v1/images" + "/" + id);
    		Link selfLink = new Link(selfURI, "self");
    		
    		List<Link> links = new ArrayList<Link>();
    		links.add(selfLink);
    		links.add(canonicalLink);

    		image.setLinks(links);
    	}
    }
    
//    private AppPackage listApplicationPackageById(long id) throws ApplicationProvisioningWebAppException {
//        AppPackage appPackage = null;
//        
//        if (id > 0) {
//            try {
//                appPackage = ApplicationRegistryManagerUtil.listApplicationPackageById(applicationRegistryManagerRemote, id);
//            } catch(ApplicationProvisioningException e) {
//                throw createNotFoundException(e, uriInfo.getBaseUri().toString() + Constants.PACKAGES_URI_V1);
//            } catch(RuntimeException e) {
//                throw createNotFoundException(e, uriInfo.getBaseUri().toString() + Constants.PACKAGES_URI_V1);
//            }
//        }
//        
//        return appPackage;
//    }
    */
    
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ClientErrorInformation> rulesForCustomerNotFound(HttpServletRequest req, Exception e)
//    public ResponseEntity<EventManagementError> handleNotFoundException(EventManagementException eventManagementException) {
//    	ResponseEntity responseEntity = null;
//    	EventManagementError eventManagementError = null;    	
//    	if (eventManagementException != null) {
//    		eventManagementError = eventManagementException.getEventManagementError();
//    		responseEntity = new ResponseEntity<EventManagementError>(eventManagementError, HttpStatus.NOT_FOUND);
//    	}
//    	return responseEntity;
//    }
    
    /*
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ClientErrorInformation> rulesForCustomerNotFound(HttpServletRequest req, Exception e)
	public ResponseEntity<Object> handleNotFoundException(EventManagementException eventManagementException) {
        ResponseEntity<Object> responseEntity = null;
        if (eventManagementException != null) {
        	EventManagementError eventManagementError = eventManagementException.getEventManagementError();
  		    responseEntity = new ResponseEntity<Object>(eventManagementError, HttpStatus.NOT_FOUND);
  	    }
  	    return responseEntity;
    }
	*/
    
    @ExceptionHandler(NotFoundException.class)
    //public ResponseEntity<ClientErrorInformation> rulesForCustomerNotFound(HttpServletRequest req, Exception e)
    //public EventManagementError createNotFoundExceptionError(int id) {
    public EventManagementError createNotFoundExceptionError(int id, EventManagementException eventManagementException, HttpServletResponse response) {
    	System.out.println("\n HERE 400");
    	System.out.println("\n response: " + response);    	
    	
        EventManagementError eventManagementError = new EventManagementError();
        eventManagementError.setType("http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.4.1");
        eventManagementError.setTitle("Resource not found");
        eventManagementError.setStatus(404);
        
        StringBuilder detail = new StringBuilder();
        detail.append("Resource not found for id: " + id);
        
        eventManagementError.setDetail(detail.toString());
        eventManagementError.setErrorCode(EventManagementErrorConstants.ErrorCode.OBJECT_NOT_FOUND);
//        eventManagementError.setErrorPath(errorPath);
	    return eventManagementError;
    }
    
//    @ExceptionHandler
//    @ResponseBody
//    public ErrorResponse handleAPIException(APIException e, HttpServletResponse response) {
//    // Set any response attributes you need...
//        return e; // or some other response
//    }
    
	@RequestMapping(value = "/insert/{name}/{description}/{imageURL}", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Image> addImage(@PathVariable String name, @PathVariable String description, @PathVariable String imageURL) throws ParseException {
    	System.out.println("\n ImageManagerController:addImage(@PathVariable String name, @PathVariable String description, @PathVariable String imageURL)");
    	List<Image> imageList = new ArrayList<Image>();		
		
    	if (name != null &&
    		imageURL != null) {
        	System.out.println("\n ImageManagerController:addImage::name: " + name);
        	System.out.println("\n ImageManagerController:addImage::description: " + description);
        	System.out.println("\n ImageManagerController:addImage::imageURL: " + imageURL);
    		
    		Image image = new Image();
    		image.setName(name);
    		image.setDescription(description);
    		image.setImageURL(imageURL);
    		
    		imageList = addImage(image);
    	}
    	
		return imageList;
	}
	
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json, application/xml")
    public List<Image> addImage(@RequestBody Image image) throws ParseException {
    	System.out.println("\n ImageManagerController:addImage(@RequestBody Image image)");
    	List<Image> imageList = new ArrayList<Image>();		

    	System.out.println("\n ImageManagerController:addImage::image: " + image);
    	if (image != null) {
    		imageManagerService.addImage(image);
    		imageList = imageManagerService.getImageList();
    	}
    	
		return imageList;
	}
}