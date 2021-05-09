package com.brianwilens.cloudnativeuploader.service;

import com.brianwilens.cloudnativeuploader.lib.dao.FileRepo;
import com.brianwilens.cloudnativeuploader.lib.exceptions.BwException;
import com.brianwilens.cloudnativeuploader.lib.exceptions.CloudNativeUploaderExceptionEnums;
import com.brianwilens.cloudnativeuploader.lib.models.File;
import com.google.cloud.storage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.jetbrains.annotations.*;
import java.io.IOException;
import java.util.Objects;

@Service
public class CloudNativeUploaderService {
    //Globals
    @Value("${landing-bucket}")
    private String landingBucket;
    @Value("${file-name-limit}")
    private int fileNameLimit;

    private final Storage storage;
    private final FileRepo fileRepo;

    //Constructor
    @Autowired
    public CloudNativeUploaderService(FileRepo fileRepo, Storage storage){
        this.fileRepo = fileRepo;
        this.storage = storage;
    }

    //TEST FUNCTION
    public String dummyFunction(@NotNull String msg) throws BwException {
        if(!msg.equals("Brian")) {
            throw new BwException(
                    CloudNativeUploaderExceptionEnums.TESTING_EXCEPTIONS.getStatus(),
                    CloudNativeUploaderExceptionEnums.TESTING_EXCEPTIONS.getMessage());
        }
        return "Hello " + msg + "!";
    }
    public File uploadFile(MultipartFile fileToUpload) throws BwException {

        System.out.println(fileNameLimit);
        System.out.println(landingBucket);
        if(fileToUpload == null) {
            throw new BwException(
                    CloudNativeUploaderExceptionEnums.BAD_REQUEST.getStatus(),
                    CloudNativeUploaderExceptionEnums.BAD_REQUEST.getMessage());
        }
        else if(Objects.requireNonNull(fileToUpload.getOriginalFilename()).length() > fileNameLimit){
            throw new BwException(
                    CloudNativeUploaderExceptionEnums.LENGTH_EXCEPTION.getStatus(),
                    CloudNativeUploaderExceptionEnums.LENGTH_EXCEPTION.getMessage());
        }
        else {
            String normalizedFileName = StringUtils.cleanPath(fileToUpload.getOriginalFilename())
                    .replaceAll("\\s+", "_")
                    .toLowerCase();
            try {
                storage.create(
                        BlobInfo.newBuilder(landingBucket, normalizedFileName).build(),
                        fileToUpload.getBytes());
            } catch (StorageException | IOException e) {
                throw new BwException(
                        CloudNativeUploaderExceptionEnums.SERVER_ERROR.getStatus(),
                        CloudNativeUploaderExceptionEnums.SERVER_ERROR.getMessage());
            }
            File uploadedFile = File.builder()
                    .fileName(normalizedFileName)
                    .fileType(fileToUpload.getContentType())
                    .fileSize(fileToUpload.getSize())
                    .build();
            //TODO: Save metadata to DB
            return uploadedFile;
        }
    }
}
