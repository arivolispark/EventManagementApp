package com.eventmanagement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



public class Conference implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * Auto-generated id of the Event.
     */
    private String id;
    
    /**
     * Name of the Event.
     * Included in the POST request.
     */
    private String name;
    
    /**
     * Description of the Event.
     * May be included in the POST and PUT request.
     */
    private String description;
    
    /**
     * Display name of the Application Package.
     * Included in the POST request.
     */
    private String location;
    
    private Date conferenceStartDate;

    private String conferenceStartDateTime;

    private Date conferenceEndDate;
    
    private String conferenceEndDateTime;

    private String status;
    
    private Speakers speakers;
    
    private Images images;

    private Sponsors sponsors;
    
    private Events events;
    
    private Blogs blogs;


    /**
     * Links for this resource.
     */
    private List<Link> links;
    
    public Conference() {
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getConferenceStartDate() {
		return conferenceStartDate;
	}

	public void setConferenceStartDate(Date conferenceStartDate) {
		this.conferenceStartDate = conferenceStartDate;
	}

	public String getConferenceStartDateTime() {
		return conferenceStartDateTime;
	}

	public void setConferenceStartDateTime(String conferenceStartDateTime) {
		this.conferenceStartDateTime = conferenceStartDateTime;
	}

	public Date getConferenceEndDate() {
		return conferenceEndDate;
	}

	public void setConferenceEndDate(Date conferenceEndDate) {
		this.conferenceEndDate = conferenceEndDate;
	}

	public String getConferenceEndDateTime() {
		return conferenceEndDateTime;
	}

	public void setConferenceEndDateTime(String conferenceEndDateTime) {
		this.conferenceEndDateTime = conferenceEndDateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Speakers getSpeakers() {
		return speakers;
	}

	public void setSpeakers(Speakers speakers) {
		this.speakers = speakers;
	}

	public Images getImages() {
		return images;
	}

	public void setImages(Images images) {
		this.images = images;
	}

	public Sponsors getSponsors() {
		return sponsors;
	}

	public void setSponsors(Sponsors sponsors) {
		this.sponsors = sponsors;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public Blogs getBlogs() {
		return blogs;
	}

	public void setBlogs(Blogs blogs) {
		this.blogs = blogs;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blogs == null) ? 0 : blogs.hashCode());
		result = prime
				* result
				+ ((conferenceEndDate == null) ? 0 : conferenceEndDate
						.hashCode());
		result = prime
				* result
				+ ((conferenceEndDateTime == null) ? 0 : conferenceEndDateTime
						.hashCode());
		result = prime
				* result
				+ ((conferenceStartDate == null) ? 0 : conferenceStartDate
						.hashCode());
		result = prime
				* result
				+ ((conferenceStartDateTime == null) ? 0
						: conferenceStartDateTime.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((links == null) ? 0 : links.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((speakers == null) ? 0 : speakers.hashCode());
		result = prime * result
				+ ((sponsors == null) ? 0 : sponsors.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conference other = (Conference) obj;
		if (blogs == null) {
			if (other.blogs != null)
				return false;
		} else if (!blogs.equals(other.blogs))
			return false;
		if (conferenceEndDate == null) {
			if (other.conferenceEndDate != null)
				return false;
		} else if (!conferenceEndDate.equals(other.conferenceEndDate))
			return false;
		if (conferenceEndDateTime == null) {
			if (other.conferenceEndDateTime != null)
				return false;
		} else if (!conferenceEndDateTime.equals(other.conferenceEndDateTime))
			return false;
		if (conferenceStartDate == null) {
			if (other.conferenceStartDate != null)
				return false;
		} else if (!conferenceStartDate.equals(other.conferenceStartDate))
			return false;
		if (conferenceStartDateTime == null) {
			if (other.conferenceStartDateTime != null)
				return false;
		} else if (!conferenceStartDateTime
				.equals(other.conferenceStartDateTime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (!events.equals(other.events))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (links == null) {
			if (other.links != null)
				return false;
		} else if (!links.equals(other.links))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (speakers == null) {
			if (other.speakers != null)
				return false;
		} else if (!speakers.equals(other.speakers))
			return false;
		if (sponsors == null) {
			if (other.sponsors != null)
				return false;
		} else if (!sponsors.equals(other.sponsors))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conference [id=" + id + ", name=" + name + ", description="
				+ description + ", location=" + location
				+ ", conferenceStartDate=" + conferenceStartDate
				+ ", conferenceStartDateTime=" + conferenceStartDateTime
				+ ", conferenceEndDate=" + conferenceEndDate
				+ ", conferenceEndDateTime=" + conferenceEndDateTime
				+ ", status=" + status + ", speakers=" + speakers + ", images="
				+ images + ", sponsors=" + sponsors + ", events=" + events
				+ ", blogs=" + blogs + ", links=" + links + "]";
	}
}