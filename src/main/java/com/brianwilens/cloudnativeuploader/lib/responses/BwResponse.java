package com.brianwilens.cloudnativeuploader.lib.responses;

import lombok.Data;

@Data
public class BwResponse <T> {
    private final int status;
    private final T data;

    public BwResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }
}
