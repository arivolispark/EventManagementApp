package com.eventmanagement.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Blogs implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * List of Blog objects.
     */    
    private List<Blog> blogList;
    
    /**
     * Links for this resource.
     */
    private List<Link> links;
    
    public Blogs() {
    }

	public List<Blog> getBlogList() {
		return blogList;
	}

    public void addBlog(Blog blog) {
    	if (blogList == null) {
    		blogList = new ArrayList<Blog>();
    	}
        blogList.add(blog);
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
				+ ((blogList == null) ? 0 : blogList.hashCode());
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
		Blogs other = (Blogs) obj;
		if (blogList == null) {
			if (other.blogList != null)
				return false;
		} else if (!blogList.equals(other.blogList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Blogs [blogList=" + blogList + ", links=" + links + "]";
	}
}