package com.story.backend.user.exception;

public class UserBadCredentialsException extends RuntimeException{

    private static final long serialVersionUID = -4978584955593025728L;

    public UserBadCredentialsException() {
        super();
    }

    public UserBadCredentialsException(String message) {
        super(message);
    }

}
