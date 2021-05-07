package com.brianwilens.cloudnativeuploader.controller;

import com.brianwilens.cloudnativeuploader.lib.exceptions.BwException;
import com.brianwilens.cloudnativeuploader.lib.models.File;
import com.brianwilens.cloudnativeuploader.lib.responses.BwResponse;
import com.brianwilens.cloudnativeuploader.service.CloudNativeUploaderService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CloudNativeUploaderController {

    //private static final Logger logger = LoggerFactory.getLogger(CloudNativeUploaderController.class);
    private final CloudNativeUploaderService cloudNativeUploaderService;

    public CloudNativeUploaderController(CloudNativeUploaderService cloudNativeUploaderService){
        this.cloudNativeUploaderService = cloudNativeUploaderService;
    }

    @GetMapping("/{msg}")
    private ResponseEntity<BwResponse<String>> dummyFunction(@PathVariable String msg) throws BwException {
        return ResponseEntity.ok().body(new BwResponse<>(HttpStatus.OK.value(), cloudNativeUploaderService.dummyFunction(msg)));
    }

    @PostMapping("/upload")
    public ResponseEntity<BwResponse<File>> uploadFile(
            @RequestParam("file") MultipartFile fileToUpload) throws BwException{
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new BwResponse<>(HttpStatus.CREATED.value(), cloudNativeUploaderService.uploadFile(fileToUpload)));
    }

}
