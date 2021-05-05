package com.brianwilens.cloudnativeuploader.api.exceptions;

import org.springframework.http.HttpStatus;

public enum CloudNativeUploaderExceptionEnums {
    TESTING_EXCEPTIONS(HttpStatus.BAD_REQUEST, "You messed up!");

    private final HttpStatus status;
    private final String message;

    CloudNativeUploaderExceptionEnums(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
