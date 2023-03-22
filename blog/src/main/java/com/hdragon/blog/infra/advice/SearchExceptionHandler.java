package com.hdragon.blog.infra.advice;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.hdragon.blog.infra.error.exception.ApplicationException;
import com.hdragon.blog.infra.error.exception.BusinessException;
import com.hdragon.blog.infra.error.ErrorCode;
import com.hdragon.blog.infra.error.ErrorResponse;
import com.hdragon.blog.infra.error.exception.NoSuchElementFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;

@Slf4j
@ControllerAdvice(basePackages = {"com.hdragon.blog.domain.web.search"})            // 업무 확장 시 1. basePackages={}에 추가 또는 2. Global Exception으로 변경 후 상위 패키지로 설정 가능
public class SearchExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)                        // @Valid
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("handleMethodArgumentNotValidException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ApplicationException.class)
    protected  ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException e) {
        log.error("handleApplicationException", e);
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(NoSuchElementFoundException.class)                            // Element Not Found
    protected ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementFoundException e) {
        log.error("NoSuchElementFoundException", e);
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ExceptionHandler(BindException.class)                                          // @ModelAttribute
    protected ResponseEntity<ErrorResponse> handleBindException(BindException e) {
        log.error("handleBindException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)                    // @Enum Type
    protected ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("handleMethodArgumentTypeMismatchException", e);
        final ErrorResponse response = ErrorResponse.of(e);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)                 // Http Method
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("handleHttpRequestMethodNotSupportedException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED);
        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(AccessDeniedException.class)                                  // Authentication
    protected ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException e) {
        log.error("handleAccessDeniedException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.HANDLE_ACCESS_DENIED);
        return new ResponseEntity<>(response, HttpStatus.valueOf(ErrorCode.HANDLE_ACCESS_DENIED.getStatus()));
    }

    @ExceptionHandler(BusinessException.class)                                      // Business Error
    protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
        log.error("handleBusinessException", e);
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(Exception.class)                                              // 400 Error
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("handleException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JsonParseException.class)                                     // Json Parsing Error
    public ResponseEntity<String> jsonParseExceptionHandler(JsonParseException e) {
        log.error("jsonParseExceptionHandler", e);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }

    @ExceptionHandler(JsonProcessingException.class)                                     // Json Processing Error
    public ResponseEntity<String> jsonProcessingExceptionHandler(JsonProcessingException e) {
        log.error("jsonProcessingExceptionHandler", e);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }

    @ExceptionHandler(DataAccessException.class)                                    // JDBC Error
    public ResponseEntity<String> dataExceptionHandle() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(SQLException.class)                                           // SQL Error
    public ResponseEntity<String> sqlExceptionHandle() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
