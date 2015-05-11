package com.eventmanagement.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Events implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * List of Event objects.
     */    
    private List<Event> eventList;
    
    /**
     * Links for this resource.
     */
    private List<Link> links;
    
    public Events() {
    }

	public List<Event> getEventList() {
		return eventList;
	}

	public void addEvent(Event event) {
        if (eventList == null) {
            eventList = new ArrayList<Event>();
        }
        eventList.add(event);
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
				+ ((eventList == null) ? 0 : eventList.hashCode());
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
		Events other = (Events) obj;
		if (eventList == null) {
			if (other.eventList != null)
				return false;
		} else if (!eventList.equals(other.eventList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Events [eventList=" + eventList + ", links=" + links + "]";
	}
}