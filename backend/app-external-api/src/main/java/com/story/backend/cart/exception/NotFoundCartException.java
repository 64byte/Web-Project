package com.story.backend.cart.exception;

public class NotFoundCartException extends Exception{

    private static final long serialVersionUID = -7605685967015310357L;

    public NotFoundCartException() {
        super();
    }

    public NotFoundCartException(String message) {
        super(message);
    }
}
