package com.raccoon.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorMessageCode {

    STUDENT_DOES_NOT_EXIST_BY_ID(HttpStatus.NOT_FOUND, 1000);

    private final HttpStatus httpStatus;
    private final int code;

    ErrorMessageCode(int code) {
        this.httpStatus = HttpStatus.BAD_REQUEST;
        this.code = code;
    }

    ErrorMessageCode(HttpStatus httpStatus, int code) {
        this.httpStatus = httpStatus;
        this.code = code;
    }
}
