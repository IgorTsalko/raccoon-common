package com.raccoon.common.exception;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@AllArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String RESPONSE_PATTERN_HEAD = "RESPONSE.ERROR-PATTERN-";

    private MessageSource messageSource;

    @ExceptionHandler(RaccoonException.class)
    protected ResponseEntity<Object> handleException(RaccoonException exception, Locale locale) {
        HttpStatus httpStatus = exception.getMessageErrorCode().getHttpStatus();
        String messageCode = RESPONSE_PATTERN_HEAD + exception.getMessageErrorCode().getCode();
        Object[] args = exception.getParams();
        String message = messageSource.getMessage(messageCode, args, locale);
        ExceptionResponse response = new ExceptionResponse(httpStatus.value(), message);
        return new ResponseEntity<>(response, httpStatus);
    }
}
