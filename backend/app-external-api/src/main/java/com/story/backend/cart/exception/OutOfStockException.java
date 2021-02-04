package com.story.backend.cart.exception;

public class OutOfStockException extends RuntimeException {

    private static final long serialVersionUID = -3511512698933477193L;

    public OutOfStockException() {
        super();
    }

    public OutOfStockException(String message) {
        super(message);
    }
}
