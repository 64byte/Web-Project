package com.story.backend.user.exception;

public class AlreadyRegisteredUserException extends RuntimeException {

    private static final long serialVersionUID = 5178887181467849166L;

    public AlreadyRegisteredUserException() {
        super();
    }

    public AlreadyRegisteredUserException(String message) {
        super(message);
    }
}
