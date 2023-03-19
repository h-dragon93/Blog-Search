package com.hdragon.blog.infra.error.custom;

import com.hdragon.blog.infra.error.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchElementFoundException extends RuntimeException{

    private ErrorCode errorCode;

    public NoSuchElementFoundException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public NoSuchElementFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
