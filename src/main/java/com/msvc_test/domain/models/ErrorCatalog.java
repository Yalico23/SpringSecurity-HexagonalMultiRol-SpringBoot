package com.msvc_test.domain.models;

import lombok.Getter;

@Getter
public enum ErrorCatalog {
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR_004", "Un error inesperado ocurrió"),
    INVALID_INPUTS("INVALID_INPUTS_001", "Los datos proporcionados son inválidos"),;

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
