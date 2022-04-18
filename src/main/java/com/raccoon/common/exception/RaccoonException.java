package com.raccoon.common.exception;

import lombok.Getter;

@Getter
public class RaccoonException extends RuntimeException {

    private final ErrorMessageCode messageErrorCode;
    private final Object[] params;

    public RaccoonException(ErrorMessageCode messageCode, Object... params) {
        super();
        this.messageErrorCode = messageCode;
        this.params = params;
    }
}
