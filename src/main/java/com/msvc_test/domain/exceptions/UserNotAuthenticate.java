package com.msvc_test.domain.exceptions;

public class UserNotAuthenticate extends RuntimeException {
    public UserNotAuthenticate(String message) {
        super(message);
    }
}
