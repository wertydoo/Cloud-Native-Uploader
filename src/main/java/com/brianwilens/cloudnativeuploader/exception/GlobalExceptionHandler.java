package com.brianwilens.cloudnativeuploader.exception;

import com.brianwilens.cloudnativeuploader.lib.exceptions.BwException;
import com.brianwilens.cloudnativeuploader.lib.responses.BwResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BwException.class)
    public ResponseEntity<BwResponse<String>> bwExceptions(BwException e) {
        return ResponseEntity
                .status(e.getStatus())
                .body(new BwResponse<>(e.getStatus().value(),e.getMessage()));
    }
}
