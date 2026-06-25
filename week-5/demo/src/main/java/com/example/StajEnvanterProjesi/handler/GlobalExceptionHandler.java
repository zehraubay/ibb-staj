package com.example.StajEnvanterProjesi.handler;

import com.example.StajEnvanterProjesi.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiError> handleBaseException(BaseException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(createApiError(ex.getMessage(), request, HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneral(Exception ex, WebRequest request) {
        return ResponseEntity.internalServerError().body(createApiError(ex.getMessage(), request, HttpStatus.INTERNAL_SERVER_ERROR));
    }

    private ApiError createApiError(Object message, WebRequest request, HttpStatus status) {
        ApiError apiError = new ApiError();
        apiError.setStatus(status.value());

        ExceptionDetail detail = new ExceptionDetail();
        detail.setMessage(message);
        detail.setCreateTime(new Date());
        detail.setPath(request.getDescription(false).substring(4));

        apiError.setException(detail);
        return apiError;
    }
}
