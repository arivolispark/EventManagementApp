package com.eventmanagement.exception;

//import java.io.Serializable;

import com.eventmanagement.model.EventManagementError;



//public class EventManagementException extends Exception implements Serializable {
public class EventManagementException extends RuntimeException {
	private static final long serialVersionUID = 1L;
    private EventManagementError eventManagementError;
    
    public EventManagementException() {
        super();
    }

    public EventManagementException(Exception exception) {
        super(exception);
    }

    public EventManagementException(Throwable throwable) {
        super(throwable);
    }

    public EventManagementException(String message) {
        super(message);
    }

    public EventManagementException(String message, Throwable throwable) {
        super(message, throwable);
    }

	public EventManagementError getEventManagementError() {
		return eventManagementError;
	}

	public void setEventManagementError(EventManagementError eventManagementError) {
		this.eventManagementError = eventManagementError;
	}

	@Override
	public String toString() {
		return "EventManagementException [eventManagementError="
				+ eventManagementError + "]";
	}
}