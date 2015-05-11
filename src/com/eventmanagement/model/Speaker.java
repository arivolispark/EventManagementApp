package com.eventmanagement.model;

import java.io.Serializable;
import java.util.List;



public class Speaker implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * Auto-generated id of the Speaker.
     */
    private String id;
    
    /**
     * Name of the Speaker.
     * Included in the POST request.
     */
    private String name;
    
    /**
     * Description of the Speaker.
     * May be included in the POST and PUT request.
     */
    private String description;
    
    /**
     * Biography of the Speaker.
     * Included in the POST request.
     */
    private String biography;

    /**
     * PhotoURL of the Speaker.
     * Included in the POST request.
     */
    private String photoURL;

    /**
     * Links for this resource.
     */
    private List<Link> links;
    
    public Speaker() {
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

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
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
		result = prime * result
				+ ((biography == null) ? 0 : biography.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((photoURL == null) ? 0 : photoURL.hashCode());
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
		Speaker other = (Speaker) obj;
		if (biography == null) {
			if (other.biography != null)
				return false;
		} else if (!biography.equals(other.biography))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (photoURL == null) {
			if (other.photoURL != null)
				return false;
		} else if (!photoURL.equals(other.photoURL))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Speaker [id=" + id + ", name=" + name + ", description="
				+ description + ", biography=" + biography + ", photoURL="
				+ photoURL + ", links=" + links + "]";
	}
}