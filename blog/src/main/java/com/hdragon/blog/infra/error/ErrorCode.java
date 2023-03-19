package com.hdragon.blog.infra.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    INVALID_INPUT_VALUE(400, "ERR01", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "ERR02", " Invalid Input Value"),
    ENTITY_NOT_FOUND(400, "ERR04", " Entity Not Found"),
    INTERNAL_SERVER_ERROR(500, "ERR04", "Server Error"),
    INVALID_TYPE_VALUE(400, "ERR05", " Invalid Type Value"),
    HANDLE_ACCESS_DENIED(403, "ERR06", "Access is Denied"),;

    private final int status;
    private final String code;
    private final String message;

}
