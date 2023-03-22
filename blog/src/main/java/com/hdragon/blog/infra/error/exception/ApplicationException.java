package com.hdragon.blog.infra.error.exception;

import com.hdragon.blog.infra.error.ErrorCode;
import lombok.Getter;

import java.text.MessageFormat;

@Getter
public class ApplicationException extends BaseException{

    private ErrorCode errorCode;

    private static final long SerialVersionUID = 7718374726118374665L;

    public ApplicationException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ApplicationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApplicationException(String errorCode, String defaultMessage, Object[] messageParaters, Exception wrappedException) {
        super(wrappedException);
        String userMessage = defaultMessage;

        if(messageParaters != null) {
            userMessage = MessageFormat.format(defaultMessage, messageParaters);
        }

        this.errorCode = ErrorCode.valueOf(errorCode);
        this.message = userMessage;
        this.wrappedException = wrappedException;
    }
}
