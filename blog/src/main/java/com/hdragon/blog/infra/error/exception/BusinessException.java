package com.hdragon.blog.infra.error.exception;

import com.hdragon.blog.infra.error.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{        // uncheck Exception인 RuntimeException을 상속

    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BusinessException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}