package com.brianwilens.cloudnativeuploader.lib.exceptions;

import org.springframework.http.HttpStatus;

public enum CloudNativeUploaderExceptionEnums {
    TESTING_EXCEPTIONS(HttpStatus.BAD_REQUEST, "You messed up!"),
    LENGTH_EXCEPTION(HttpStatus.UNPROCESSABLE_ENTITY,"File name cannot have length greater than 255 characters!"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST,"Invalid file or null object received!"),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"Server experienced a cloud storage or file IO error that could not be resolved!");

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
