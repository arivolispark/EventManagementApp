package com.eventmanagement.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Images implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * List of Image objects.
     */    
    private List<Image> imageList;
    
    /**
     * Links for this resource.
     */
    private List<Link> links;
    
    public Images() {
    }

	public List<Image> getImageList() {
		return imageList;
	}

    public void addImage(Image image) {
    	if (imageList == null) {
    		imageList = new ArrayList<Image>();
    	}
        imageList.add(image);
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
				+ ((imageList == null) ? 0 : imageList.hashCode());
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
		Images other = (Images) obj;
		if (imageList == null) {
			if (other.imageList != null)
				return false;
		} else if (!imageList.equals(other.imageList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Images [imageList=" + imageList + ", links=" + links + "]";
	}
}