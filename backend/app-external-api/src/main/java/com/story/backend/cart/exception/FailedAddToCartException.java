package com.story.backend.cart.exception;

public class FailedAddToCartException extends RuntimeException{

    private static final long serialVersionUID = -7313616326171143407L;

    public FailedAddToCartException() {
        super();
    }

    public FailedAddToCartException(String message) {
        super(message);
    }

}
