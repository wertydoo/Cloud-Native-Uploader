package com.brianwilens.cloudnativeuploader.controller;

import com.brianwilens.cloudnativeuploader.api.exceptions.BwException;
import com.brianwilens.cloudnativeuploader.api.responses.BwResponse;
import com.brianwilens.cloudnativeuploader.service.CloudNativeUploaderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloudNativeUploaderController {

    private final CloudNativeUploaderService cloudNativeUploaderService;

    public CloudNativeUploaderController(CloudNativeUploaderService cloudNativeUploaderService){
        this.cloudNativeUploaderService = cloudNativeUploaderService;
    }

    @GetMapping("/{msg}")
    private ResponseEntity<BwResponse<String>> dummyFunction(@PathVariable String msg) throws BwException {
        return ResponseEntity.ok().body(new BwResponse<>(HttpStatus.OK.value(), cloudNativeUploaderService.dummyFunction(msg)));
    }
}
