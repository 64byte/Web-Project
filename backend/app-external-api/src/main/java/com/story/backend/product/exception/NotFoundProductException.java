package com.story.backend.product.exception;

public class NotFoundProductException extends Exception {

    private static final long serialVersionUID = -6649863422748435841L;

    public NotFoundProductException() {
        super();
    }

    public NotFoundProductException(String message) {
        super(message);
    }

}
