package com.eventmanagement.exception;

//import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



//@ResponseStatus(HttpStatus.NOT_FOUND)
//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This resource is not found in the system")
//public class NotFoundException extends Exception implements Serializable {
public class NotFoundException extends EventManagementException {
	private static final long serialVersionUID = 1L;
    
    public NotFoundException() {
        super();
    }

    public NotFoundException(Exception exception) {
        super(exception);
    }

    public NotFoundException(Throwable throwable) {
        super(throwable);
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

	@Override
	public String toString() {
		return "NotFoundException [eventManagementError="
				+ super.getEventManagementError() + "]";
	}
}