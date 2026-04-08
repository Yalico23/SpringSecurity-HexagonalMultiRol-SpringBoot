package com.msvc_test.infrastructure.controllers;

import com.msvc_test.domain.models.ErrorCatalog;
import com.msvc_test.domain.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalControllerAdvice {

    // Para spring boot que usen @Valid
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleErrorResponse(MethodArgumentNotValidException exception) {

        BindingResult result = exception.getBindingResult();

        return ErrorResponse.builder()
                .code(ErrorCatalog.INVALID_INPUTS.getCode())
                .message(ErrorCatalog.INVALID_INPUTS.getMessage())
                .details(result.getFieldErrors()
                        .stream()
                        .map(error -> error.getField() + ": " + error.getDefaultMessage())
                        .toList())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGeneralException(Exception exception) {
        return ErrorResponse.builder()
                .code(ErrorCatalog.INTERNAL_SERVER_ERROR.getCode())
                .message(ErrorCatalog.INTERNAL_SERVER_ERROR.getMessage())
                .details(List.of(exception.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }
}
