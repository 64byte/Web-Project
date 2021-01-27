package com.story.backend.common.handler;

import com.story.backend.authentication.exception.InvalidJwtAuthenticationException;
import com.story.backend.common.dto.ErrorResponse;
import com.story.backend.common.exception.ErrorCode;
import com.story.backend.user.exception.AlreadyRegisteredUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidJwtAuthenticationException.class)
    protected ResponseEntity<ErrorResponse> handleInvalidJwtAuthException(InvalidJwtAuthenticationException e) {

        return new ResponseEntity<>(ErrorResponse.builder().build(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(AlreadyRegisteredUserException.class)
    protected ResponseEntity<ErrorResponse> handleAlreadyRegisteredUserException(AlreadyRegisteredUserException e) {

        return new ResponseEntity<>(ErrorResponse.builder().build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {

        return new ResponseEntity<>(ErrorResponse.builder().build(), HttpStatus.BAD_REQUEST);
    }

}
