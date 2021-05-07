package com.brianwilens.cloudnativeuploader.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.brianwilens.cloudnativeuploader.lib.dao")
public class CloudNativeUploaderConfiguration {

}
