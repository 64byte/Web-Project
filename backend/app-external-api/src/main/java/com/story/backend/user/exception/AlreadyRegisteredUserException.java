package com.story.backend.user.exception;

public class AlreadyRegisteredUserException extends RuntimeException {

    public AlreadyRegisteredUserException() {
        super();
    }

    public AlreadyRegisteredUserException(String message) {
        super(message);
    }
}
