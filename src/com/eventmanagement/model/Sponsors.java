package com.eventmanagement.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Sponsors implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * List of Sponsor objects.
     */    
    private List<Sponsor> sponsorList;
    
    /**
     * Links for this resource.
     */
    private List<Link> links;
    
    public Sponsors() {
    }

	public List<Sponsor> getSponsorList() {
		return sponsorList;
	}

	public void addSponsor(Sponsor sponsorer) {
        if (sponsorList == null) {
            sponsorList = new ArrayList<Sponsor>();
        }
        sponsorList.add(sponsorer);
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
				+ ((sponsorList == null) ? 0 : sponsorList.hashCode());
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
		Sponsors other = (Sponsors) obj;
		if (sponsorList == null) {
			if (other.sponsorList != null)
				return false;
		} else if (!sponsorList.equals(other.sponsorList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sponsors [sponsorList=" + sponsorList + ", links="
				+ links + "]";
	}
}