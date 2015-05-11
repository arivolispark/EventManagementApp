package com.eventmanagement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



public class Event implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * Auto-generated id of the Event.
     */
    private String id;
    
    private Date date;

    private String startTime;
    
    private String endTime;

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
    
    private Speakers speakers;
    
    private Images images;

    private Sponsors sponsorers;

    private String status;

    /**
     * Links for this resource.
     */
    private List<Link> links;
    
    public Event() {
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public Sponsors getSponsorers() {
		return sponsorers;
	}

	public void setSponsorers(Sponsors sponsorers) {
		this.sponsorers = sponsorers;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((speakers == null) ? 0 : speakers.hashCode());
		result = prime * result
				+ ((sponsorers == null) ? 0 : sponsorers.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
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
		Event other = (Event) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
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
		if (sponsorers == null) {
			if (other.sponsorers != null)
				return false;
		} else if (!sponsorers.equals(other.sponsorers))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
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
		return "Event [id=" + id + ", date=" + date + ", startTime="
				+ startTime + ", endTime=" + endTime + ", name=" + name
				+ ", description=" + description + ", location=" + location
				+ ", speakers=" + speakers + ", images=" + images
				+ ", sponsorers=" + sponsorers + ", status=" + status
				+ ", links=" + links + "]";
	}
}