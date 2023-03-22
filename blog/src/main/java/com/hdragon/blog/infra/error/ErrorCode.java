package com.hdragon.blog.infra.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    INVALID_INPUT_VALUE(400, "ERR01", "Invalid Input Value"),
    ENTITY_NOT_FOUND(400, "ERR02", " Entity Not Found"),
    INVALID_TYPE_VALUE(400, "ERR03", "Invalid Type Value"),
    HANDLE_ACCESS_DENIED(403, "ERR04", "Access is Denied"),
    METHOD_NOT_ALLOWED(405, "ERR05", "Invalid Input Value"),
    INTERNAL_SERVER_ERROR(500, "ERR06", "Server Error");

    private final int status;
    private final String code;
    private final String message;

}
