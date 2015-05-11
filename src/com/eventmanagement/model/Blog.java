package com.eventmanagement.model;

import java.io.Serializable;
import java.util.List;



public class Blog implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * Auto-generated id of the Image.
     */
    private String id;
    
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
    private String blogURL;

    /**
     * Links for this resource.
     */
    private List<Link> links;
    
    public Blog() {
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

	public String getBlogURL() {
		return blogURL;
	}

	public void setBlogURL(String blogURL) {
		this.blogURL = blogURL;
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
		result = prime * result + ((blogURL == null) ? 0 : blogURL.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Blog other = (Blog) obj;
		if (blogURL == null) {
			if (other.blogURL != null)
				return false;
		} else if (!blogURL.equals(other.blogURL))
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
		return true;
	}
	
	@Override
	public String toString() {
		return "Blog [id=" + id + ", name=" + name + ", description="
				+ description + ", blogURL=" + blogURL + ", links=" + links
				+ "]";
	}
}