package com.brianwilens.cloudnativeuploader.lib.models;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class File {
    String fileName;
    String fileType;
    long fileSize;
}
