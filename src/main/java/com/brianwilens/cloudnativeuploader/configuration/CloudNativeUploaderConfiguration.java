package com.brianwilens.cloudnativeuploader.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.brianwilens.cloudnativeuploader.api.dao")
public class CloudNativeUploaderConfiguration {

}
