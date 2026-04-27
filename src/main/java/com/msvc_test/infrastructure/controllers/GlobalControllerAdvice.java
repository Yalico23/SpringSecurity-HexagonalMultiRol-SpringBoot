package com.msvc_test.infrastructure.controllers;

import com.msvc_test.domain.exceptions.UserNotFoundException;
import com.msvc_test.domain.models.ErrorCatalog;
import com.msvc_test.domain.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.List;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException exception) {
        return ErrorResponse.builder()
                .code(ErrorCatalog.USER_NOT_FOUND.getCode())
                .message(ErrorCatalog.USER_NOT_FOUND.getMessage())
                .details(List.of(exception.getMessage()))
                .timestamp(LocalDate.now())
                .build();
    }

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
                .timestamp(LocalDate.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGeneralException(Exception exception) {
        return ErrorResponse.builder()
                .code(ErrorCatalog.INTERNAL_SERVER_ERROR.getCode())
                .message(ErrorCatalog.INTERNAL_SERVER_ERROR.getMessage())
                .details(List.of(exception.getMessage()))
                .timestamp(LocalDate.now())
                .build();
    }
}
