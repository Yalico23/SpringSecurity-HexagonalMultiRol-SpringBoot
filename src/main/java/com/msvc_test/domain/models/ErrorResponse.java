package com.msvc_test.domain.models;

import lombok.Builder;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Setter
public class ErrorResponse {
    private final String code;
    private final String message;
    private final List<String> details;
    private final LocalDateTime timestamp;

}
