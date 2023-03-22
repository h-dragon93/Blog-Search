package com.hdragon.blog.infra.error.exception;

import lombok.Getter;
import lombok.Setter;

import java.text.MessageFormat;

@Getter
@Setter
public class BaseException extends Exception {      //  checked exception 인 Exception은 BaseException을 상속

    private static final long SerialVersionUID = 7718947363538374665L;

    protected String message = null;

    protected String customerErrorMessage = null;

    protected String messageKey = null;

    protected Object[] messageParameters = null;

    protected Exception wrappedException = null;

    public BaseException() {
        this("BaseException No Message", null, null);
    }

    public BaseException(String defaultMessage) {
        this(defaultMessage, null, null);
    }

    public BaseException(Throwable wrappedException) {
        this("BaseException No Message", null, wrappedException);
    }

    public BaseException(String defaultMessage, Throwable wrappedException) {
        this(defaultMessage, null, wrappedException);
    }

    public BaseException(String defaultMessage, Object[] messageParameters, Throwable wrappedException) {
        super(wrappedException);
        String userMessage = defaultMessage;
        if(messageParameters != null) {
            userMessage = MessageFormat.format(defaultMessage, messageParameters);
        }

        this.message = userMessage;
    }
}
