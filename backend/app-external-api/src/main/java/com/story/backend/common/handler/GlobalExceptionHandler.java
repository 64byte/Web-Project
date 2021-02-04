package com.story.backend.common.handler;

import com.story.backend.authentication.exception.InvalidJwtAuthenticationException;
import com.story.backend.cart.exception.FailedAddToCartException;
import com.story.backend.cart.exception.OutOfStockException;
import com.story.backend.common.dto.ErrorResponse;
import com.story.backend.product.exception.NotFoundProductException;
import com.story.backend.product.exception.NotFoundProductSkuException;
import com.story.backend.user.exception.AlreadyRegisteredUserException;
import com.story.backend.user.exception.UserBadCredentialsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyRegisteredUserException.class)
    protected ResponseEntity<ErrorResponse> handleAlreadyRegisteredUserException(Exception e) {
        AlreadyRegisteredUserException are = (AlreadyRegisteredUserException)e;
        log.error("handleAlreadyRegisteredUserException: ", are);
        return new ResponseEntity<>(ErrorResponse.builder().build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserBadCredentialsException.class)
    protected ResponseEntity<ErrorResponse> handleUserBadCredentialsException(Exception e) {
        UserBadCredentialsException are = (UserBadCredentialsException)e;
        log.error("handleUserBadCredentialsException: ", are);
        return new ResponseEntity<>(ErrorResponse.builder().build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FailedAddToCartException.class)
    protected ResponseEntity<ErrorResponse> handleFailedAddToCartException(Exception e) {
        FailedAddToCartException fae = (FailedAddToCartException)e;
        log.error("handleFailedAddToCartException: ", fae);
        return new ResponseEntity<>(ErrorResponse.builder().build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OutOfStockException.class)
    protected ResponseEntity<ErrorResponse> handleOutOfStockException(Exception e) {
        OutOfStockException ose = (OutOfStockException)e;
        log.error("handleOutOfStockException: ", ose);
        return new ResponseEntity<>(ErrorResponse.builder().build(), HttpStatus.BAD_REQUEST);
    }

    // Product Exception
    @ExceptionHandler(NotFoundProductException.class)
    protected ResponseEntity<ErrorResponse> handleNotFoundProductException(Exception e) {
        NotFoundProductException ose = (NotFoundProductException)e;
        log.error("handleNotFoundProductException: ", ose);
        return new ResponseEntity<>(ErrorResponse.builder().build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundProductSkuException.class)
    protected ResponseEntity<ErrorResponse> handleNotFoundProductSkuException(Exception e) {
        NotFoundProductSkuException ose = (NotFoundProductSkuException)e;
        log.error("handleNotFoundProductSkuException: ", ose);
        return new ResponseEntity<>(ErrorResponse.builder().build(), HttpStatus.BAD_REQUEST);
    }
    //

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("handleException: ", e);
        return new ResponseEntity<>(ErrorResponse.builder().build(), HttpStatus.BAD_REQUEST);
    }

}
