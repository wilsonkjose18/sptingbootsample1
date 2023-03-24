package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class AppConfiguration {

    @Bean
    File directoryBean(@Value("${application.input.directory}") String appDirectory) {
       return new File(appDirectory);
    }

}
