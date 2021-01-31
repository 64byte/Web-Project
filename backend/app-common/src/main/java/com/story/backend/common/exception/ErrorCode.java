package com.story.backend.common.exception;

public enum ErrorCode {
    METHOD_NOT_ALLOWED(405, "E002", " Invalid Input Value"),

    ;

    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

}
