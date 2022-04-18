package com.raccoon.common.exception;

import lombok.Getter;

@Getter
public class ExceptionResponse {

    private final int errorCode;
    private final String message;

    public ExceptionResponse(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
