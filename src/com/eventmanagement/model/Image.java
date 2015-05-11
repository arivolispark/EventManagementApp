package com.eventmanagement.model;

import java.io.Serializable;
import java.util.List;



public class Image implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * Auto-generated id of the Image.
     */
    private int id;

    /**
     * Name of the Image.
     * Included in the POST request.
     */
    private String name;
    
    /**
     * Description of the Image.
     * May be included in the POST and PUT request.
     */
    private String description;
    
    /**
     * ImageURL of the Image.
     * Included in the POST request.
     */
    private String imageURL;

    /**
     * Links for this resource.
     */
    private List<Link> links;
    
    public Image() {
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
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
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((imageURL == null) ? 0 : imageURL.hashCode());
		result = prime * result + ((links == null) ? 0 : links.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Image other = (Image) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (imageURL == null) {
			if (other.imageURL != null)
				return false;
		} else if (!imageURL.equals(other.imageURL))
			return false;
		if (links == null) {
			if (other.links != null)
				return false;
		} else if (!links.equals(other.links))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", description="
				+ description + ", imageURL=" + imageURL + ", links=" + links
				+ "]";
	}
}