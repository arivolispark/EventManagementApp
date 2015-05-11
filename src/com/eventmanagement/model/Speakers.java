package com.eventmanagement.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Speakers implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * List of Speaker objects.
     */    
    private List<Speaker> speakerList;
    
    /**
     * Links for this resource.
     */
    private List<Link> links;
    
    public Speakers() {
    }

	public List<Speaker> getSpeakerList() {
		return speakerList;
	}

    public void addSpeaker(Speaker speaker) {
    	if (speakerList == null) {
            speakerList = new ArrayList<Speaker>();
    	}
        speakerList.add(speaker);
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
				+ ((speakerList == null) ? 0 : speakerList.hashCode());
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
		Speakers other = (Speakers) obj;
		if (speakerList == null) {
			if (other.speakerList != null)
				return false;
		} else if (!speakerList.equals(other.speakerList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Speakers [speakerList=" + speakerList + ", links=" + links
				+ "]";
	}
}