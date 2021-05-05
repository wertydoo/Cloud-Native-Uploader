package com.brianwilens.cloudnativeuploader.service;

import com.brianwilens.cloudnativeuploader.api.dao.FileRepo;
import com.brianwilens.cloudnativeuploader.api.exceptions.BwException;
import com.brianwilens.cloudnativeuploader.api.exceptions.CloudNativeUploaderExceptionEnums;
import org.springframework.stereotype.Service;

@Service
public class CloudNativeUploaderService {
    //Globals
    private FileRepo fileRepo;

    //Constructor
    public CloudNativeUploaderService(FileRepo fileRepo){
        this.fileRepo = fileRepo;
    }

    //TEST FUNCTION
    public String dummyFunction(String msg) throws BwException {
        if(!msg.equals("Brian")) {
            throw new BwException(
                    CloudNativeUploaderExceptionEnums.TESTING_EXCEPTIONS.getStatus(),
                    CloudNativeUploaderExceptionEnums.TESTING_EXCEPTIONS.getMessage());
        }
        return "Hello " + msg + "!";
    }
}
