package com.story.backend.common.handler;

import com.story.backend.authentication.exception.InvalidJwtAuthenticationException;
import com.story.backend.common.dto.ErrorResponse;
import com.story.backend.user.exception.AlreadyRegisteredUserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyRegisteredUserException.class)
    protected ResponseEntity<ErrorResponse> handleAlreadyRegisteredUserException(AlreadyRegisteredUserException e) {
        log.error("handleAlreadyRegisteredUserException: ", e);
        return new ResponseEntity<>(ErrorResponse.builder().build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("handleException: ", e);
        return new ResponseEntity<>(ErrorResponse.builder().build(), HttpStatus.BAD_REQUEST);
    }

}
