package com.story.backend.product.exception;

public class NotFoundProductSkuException extends RuntimeException {

    private static final long serialVersionUID = -1577308613800641213L;

    public NotFoundProductSkuException() {
        super();
    }

    public NotFoundProductSkuException(String message) {
        super(message);
    }

}
