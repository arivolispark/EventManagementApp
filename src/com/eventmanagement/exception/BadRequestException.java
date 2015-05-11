package com.eventmanagement.exception;

//import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(HttpStatus.BAD_REQUEST)
//public class BadRequestException extends EventManagementException implements Serializable {
public class BadRequestException extends EventManagementException {
    private static final long serialVersionUID = 1L;
    
    public BadRequestException() {
        super();
    }

    public BadRequestException(Exception exception) {
        super(exception);
    }

    public BadRequestException(Throwable throwable) {
        super(throwable);
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable throwable) {
        super(message, throwable);
    }

	@Override
	public String toString() {
		return "BadRequestException [eventManagementError="
				+ super.getEventManagementError() + "]";
	}
}